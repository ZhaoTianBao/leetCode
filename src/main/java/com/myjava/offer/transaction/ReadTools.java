package com.myjava.offer.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReadTools {


    //隔离级别工具

    public static Thread run(Runnable runnable){
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }

    public static Connection openConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/transaction_test";
        String username = "root";
        String password = "root";
        boolean autoCommit = false;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            conn.setAutoCommit(autoCommit);
//            logger.debug(jdbcurl);
//            logger.debug("username=【"+username+"】");
//            logger.debug("MYSQL DATABASE: Connection success!");
        }catch(Exception se) {
            //连接失败
            conn = null;
//            logger.debug("initMYSQL："+jdbcurl + "\r\n" + " Connection failed! " + se.getMessage());
            return null;
        }
        return conn;
    }
    public static void insert(String accountName, String name, int money){
        try {
            Connection conn = ReadTools.openConnection();
            conn.setAutoCommit(false);
            String sql = "insert into transaction_test(account_name,user_name,money) values (?,?,?)";
            PreparedStatement prepare = conn.prepareStatement(sql);
            prepare.setString(1, accountName);
            prepare.setString(2, name);
            prepare.setInt(3, money);
            prepare.executeUpdate();
            Thread.sleep(3000);
            System.out.println("执行插入");
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void select(){
        try {
            Connection conn = ReadTools.openConnection();
            conn.setAutoCommit(false);
            String sql = " select * from transaction_test ";
            PreparedStatement prepare = conn.prepareStatement(sql);
            boolean execute = prepare.execute();
            System.out.println(execute);
            Thread.sleep(3000);
            System.out.println("执行插入");
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
