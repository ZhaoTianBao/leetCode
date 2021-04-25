package com.myjava.offer.io.nio.netty.txChatDemo;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

// netty 关键代码  3行
public class ChatServer {
    public static void main(String[] args) throws InterruptedException {
        //创立2个线程组，boss 含有子线程个数为cpu核数 的 2倍
        //bossGroup 只处理连接请求
        //workerGroup 真正处理客户端业务
        // loop 2个线程池
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);
        try{
            //创建服务器启动对象  1 行  创建netty服务端
            ServerBootstrap bootstrap = new ServerBootstrap();
            //配置参数 链式编程   2 netty服务端绑定参数 如2个线程池
            bootstrap.group(bossGroup,workerGroup) //设置2个线程组
                    .channel(NioServerSocketChannel.class)//使用NioSocketChannel作为服务器通道实现
                    .option(ChannelOption.SO_BACKLOG,1024)//初始化服务器处理连接队列，一次处理1个，其他放入队列等待
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //初始化对象
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //通道加入解码器
                            pipeline.addLast("decoder", new StringDecoder());
                            //通道加入编码器
                            pipeline.addLast("encoder", new StringEncoder());
                            //设置处理器    //开发此处 写 NettyServerHandler 业务代码  就够了
                            pipeline.addLast(new ChatServerHandler());
                        }
                    });
            System.out.println("。。。。聊天室 启动。。。。");
            //    sync异步启动    3 绑定端口
            ChannelFuture channelFuture = bootstrap.bind(9001).sync();
            //关闭通道
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }



    }
}
