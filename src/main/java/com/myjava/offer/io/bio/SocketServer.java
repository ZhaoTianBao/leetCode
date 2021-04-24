package com.myjava.offer.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true){
            System.out.println("等待连接。。。。");
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接");
            //开线程处理
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        handle(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            handle(socket);
        }
    }

    private static void handle(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read");
        int read = socket.getInputStream().read(bytes);
        System.out.println("read 完毕");
        while (read != -1){
            System.out.println("接受客户端的数据"+ new String(bytes,0,read));
        }
    }


    //测试 cmd telnet localhost   9000    send zhuge
}
