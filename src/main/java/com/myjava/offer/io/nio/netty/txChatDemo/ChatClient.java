package com.myjava.offer.io.nio.netty.txChatDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class ChatClient {

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
                            ChannelPipeline pipeline = ch.pipeline();
                            //通道加入解码器
                            pipeline.addLast("decoder", new StringDecoder());
                            //通道加入编码器
                            pipeline.addLast("encoder", new StringEncoder());
                            //设置处理器
                            pipeline.addLast(new ChatClientHandler());
                        }
                    });
            System.out.println(" netty client start....");
            //3启动端口 连接服务端
            ChannelFuture cf = bootstrap.connect("127.0.0.1", 9001).sync();
            //得到channel
            Channel channel = cf.channel();
            System.out.println("========== "+channel.localAddress()+" ==========");

            //客户端需要输入信息，创建一个扫描器
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String msg = scanner.nextLine();
                //通过channel 发送消息 至服务端
                channel.writeAndFlush(msg);
            }
            //对通道关闭进行监听
            channel.closeFuture().sync();

        }finally {
            group.shutdownGracefully();
        }

    }
}
