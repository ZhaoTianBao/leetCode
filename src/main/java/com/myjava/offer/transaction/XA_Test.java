package com.myjava.offer.transaction;

import com.mysql.jdbc.jdbc2.optional.MysqlXAConnection;
import com.mysql.jdbc.jdbc2.optional.MysqlXid;

import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.*;

public class XA_Test {
    /**
     * 原生jdbc 实现两阶段提交
     */

    public static void main(String[] args) throws Exception {
        //true 表示打印XA语句 便于调试
        boolean logXACommand = true;
        //属性
        String url1 = "jdbc:mysql://localhost:3306/es_blog";
        String url2 = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String passwd = "root";
        //获得资源管理器操作实例 RM1
        Connection conn1 = DriverManager.getConnection(url1, user, passwd);
        MysqlXAConnection xaConn1 = new MysqlXAConnection((com.mysql.jdbc.Connection) conn1, logXACommand);
        XAResource rm1 = xaConn1.getXAResource();
        //获得资源管理器操作实例 RM2
        Connection conn2 = DriverManager.getConnection(url2, user, passwd);
        MysqlXAConnection xaConn2 = new MysqlXAConnection((com.mysql.jdbc.Connection) conn2, logXACommand);
        //  XAResource    数据库对应的资源管理器
        XAResource rm2 = xaConn2.getXAResource();
        //AP请求TM执行一个分布式事务，TM生成全局id
        byte[] gtrid = "g12345".getBytes();
        int formatId = 1;
        try {
            //分别执行RM1 RM2 上的事务分支
            //tm生成rm1事务分支id
            byte[] b1 = "b00001".getBytes();
            Xid xid1 = new MysqlXid(gtrid, b1, formatId);
            //执行rm1的事务分支
            rm1.start(xid1,XAResource.TMNOFLAGS);
            String sql1 = "insert into user(name) VALUES('zhangsan')";
            PreparedStatement ps1 = conn1.prepareStatement(sql1);
            ps1.execute();
            rm1.end(xid1,XAResource.TMSUCCESS);
            //执行rm2的事务分支
            //tm生成rm1事务分支id
            byte[] b2 = "b00002".getBytes();
            Xid xid2 = new MysqlXid(gtrid, b2, formatId);
            rm2.start(xid2,XAResource.TMNOFLAGS);
            String sql2 = "insert into account(name) VALUES('zhangsan')";
            PreparedStatement ps2 = conn1.prepareStatement(sql2);
            ps2.execute();
            rm2.end(xid2,XAResource.TMSUCCESS);



            //两阶段提交
            //询问所有rm    准备提交事务分支
            int rm1_prepare = rm1.prepare(xid1);
            int rm2_prepare = rm2.prepare(xid2);
            boolean onePhase =  false;
            //判断所有 预提交都是成功的
            if (rm1_prepare == XAResource.XA_OK && rm2_prepare == XAResource.XA_OK){
                rm1.commit(xid1,onePhase);
                rm2.commit(xid2,onePhase);
            }else{
                rm1.rollback(xid1);
                rm2.rollback(xid2);
            }



        }catch (Exception e){

        }



    }
}
