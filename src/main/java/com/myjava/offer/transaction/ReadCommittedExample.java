package com.myjava.offer.transaction;


import com.atomikos.icatch.Propagation;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReadCommittedExample {

    public static void main(String[] args) {
        String lock = "lock";
        //启动插入线程
        Thread t1 = ReadTools.run(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                ReadTools.insert("111", "luban", 1000);
            }
        });
        //启动查询线程
        Thread t2 = ReadTools.run(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    Connection conn = ReadTools.openConnection();
                    //参数升级解决脏读
                    conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);


                }catch (Exception e){

                }
            }
        });

    }







}
