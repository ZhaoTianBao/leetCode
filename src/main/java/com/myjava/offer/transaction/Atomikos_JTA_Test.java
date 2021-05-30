package com.myjava.offer.transaction;


import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;

import javax.transaction.SystemException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Atomikos_JTA_Test {

    public static AtomikosDataSourceBean createAtomikosDataSourceBean(String dbName){
        //基本属性
        Properties p = new Properties();
        p.setProperty("url","jdbc:mysql://localhost:3306/"+dbName);
        p.setProperty("user","root");
        p.setProperty("password","root");
        //使用AtomikosDataSourceBean 封装数据源  做一个别名代理   和dbName 相同 便于记忆
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName(dbName);
        ds.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        ds.setXaProperties(p);
        return ds;
    }

    public static void main(String[] args) throws Exception {
        //封装 2个 Atomikos 数据源
        AtomikosDataSourceBean ds1 = createAtomikosDataSourceBean("es_blog");
        AtomikosDataSourceBean ds2 = createAtomikosDataSourceBean("test");
        Connection conn1 = null;
        Connection conn2 = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        //声明事务全局管理器
        UserTransactionImp userTransactionImp = new UserTransactionImp();

        try {

            //开启事务
            userTransactionImp.begin();

            //执行db1 上 sql
            conn1 = ds1.getConnection();
            String sql1 = "insert into user(name) VALUES(?)";
            ps1 = conn1.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1,"zhugelaoshi");
            ps1.executeUpdate();
            //执行sql，但是没提交

            //模拟异常  直接进入catch   2个代码块都不执行
            //int i = 1/0;



            //执行db2 上 sql
            conn2 = ds2.getConnection();
            String sql2 = "insert into account(name) VALUES(?)";
            ps2 = conn2.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            ps2.setString(1,"zhugelaoshi");
            ps2.executeUpdate();


            //2pc   两阶段提交   全局提交
            userTransactionImp.commit();


        }catch (Exception e){
            e.printStackTrace();
            userTransactionImp.rollback();

        }finally {
            try {
                ps1.close();
                ps2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



}
