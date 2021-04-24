package com.myjava.offer.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NIOServerPlus {


    /**
     * 比如，1W连接，有用发送数据的1K个，但是每次都遍历10W个channelList9K数据是空，浪费
     * 2个list，增加一个存储有数据的连接，只遍历处理那个连接List，减少空遍历次数
     *
     * select 多路复用器
     * 引入 多路复用器
     *
     */

    //所有建立好的    客户端连接
    public static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //绑定端口
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(9000));
        //设置阻塞模式 非阻塞 true就是BIO了
        serverSocket.configureBlocking(false);
        //打开 Selector 处理channel 即创建 epoll 即 多路复用器 Selector 收集有读写数据的channel
        Selector selector = Selector.open();
        // IO事件 读事件 写事件 连接accept事件
        //  把ServerSocketChannel 注册到 Selector 上   去关注下 上边的连接事件accept
        // 服务端的channel注册到Selector
        SelectionKey register = serverSocket.register(selector, SelectionKey.OP_ACCEPT);


        System.out.println("nio select 服务启动");

        while (true){

            //阻塞 等待
            selector.select();
            //事件集合 就是   SelectionKey    10W客户连接，但是只有10个客户端发消息，selector只处理那10个客户端
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //如果是注册事件 服务端事件
                if (key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    //建立连接
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    //客户端的channel 也注册到 selector  后续处理客户端收发
                    SelectionKey socketKey = socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("nio select 客户端连接成功");

                }else if (key.isReadable()){
                    SocketChannel socket = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = socket.read(byteBuffer);
                    if (len > 0){
                        //有数据
                        System.out.println("nio select 收到消息: " + new String(byteBuffer.array()));
                    }else if (len == -1){
                        //客户端断开,把socket 从集合中移除
                        iterator.remove();
                        System.out.println("nio select 客户端断开连接");
                        socket.close();
                    }
                }
                //删除事件，防止selector重复处理此事件
                iterator.remove();


            }
        }
    }
}
