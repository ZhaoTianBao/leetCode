package com.myjava.offer.io.nio.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClientSimple {

    public static void main(String[] args) throws Exception {
        //客户端需要一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //1 创建客户端启动对象
            Bootstrap bootstrap = new Bootstrap();
            //2 设置启动参数
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)    //使用NioSocketChannel 作为客户端通道的实现
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch)  {
                            //加入处理器
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            System.out.println(" netty client start....");
            //3启动端口 连接服务端
            ChannelFuture cf = bootstrap.connect("127.0.0.1", 9000).sync();
            //对通道关闭进行监听
            cf.channel().closeFuture().sync();

        }finally {
            group.shutdownGracefully();
        }

    }
}
