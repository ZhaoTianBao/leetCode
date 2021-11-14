package com.myjava.offer.transaction;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReadUncommittedExample {



    public static Thread run(Runnable runnable){
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }


    public static void main(String[] args) {
        //启动插入线程
        Thread t1 = run(new Runnable() {
            @Override
            public void run() {
                ReadTools.insert("111", "luban", 1000);
            }
        });
        //启动查询线程
        Thread t2 = run(new Runnable() {
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
