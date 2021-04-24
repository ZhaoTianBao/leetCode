package com.myjava.offer.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NIOServer {


    /**
     * 入门版本
     */

    //所有建立好的    客户端连接
    public static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //绑定端口
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        //设置阻塞模式 非阻塞 true就是BIO了
        serverSocket.configureBlocking(false);
        System.out.println("nio 服务启动");

        while (true){
            //nio 非阻塞 调用的 linux系统内部  accept方法
            SocketChannel socketChannel = serverSocket.accept();
            if (socketChannel != null){
                System.out.println("nio 连接成功");
                //设置客户端连接也是 非阻塞  即使客户端没发数据，
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }


            //遍历连接进行数据读取
            Iterator<SocketChannel> iterator = channelList.iterator();
            while (iterator.hasNext()){
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                //非阻塞 模式下 read 不会阻塞   否则阻塞
                int len = sc.read(byteBuffer);
                if (len > 0){
                    //有数据
                    System.out.println("nio 收到消息: " + new String(byteBuffer.array()));
                }else if (len == -1){
                    //客户端断开,把socket 从集合中移除
                    iterator.remove();
                    System.out.println("nio 客户端断开连接");

                }
            }
            //客户端没发数据，会一直转，但是不阻塞

        }


    }
}
