package com.myjava.offer.io.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 真正开发就是处理这个类
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //管道初始建立连接
        System.out.println(" netty handle 建立连接。。。");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //ctx 上下文对象 包含 通道channel  管道pipeline
        //收到数据 业务写这里就好了
        ByteBuf bf = (ByteBuf) msg;
        System.out.println("netty handle  收到数据"+bf.toString(CharsetUtil.UTF_8));
    }
}
