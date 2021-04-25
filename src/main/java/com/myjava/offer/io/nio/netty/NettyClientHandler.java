package com.myjava.offer.io.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * netty 客户端 handler写法和 服务端一样
     *
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //发送数据
        ByteBuf bf = Unpooled.copiedBuffer(" hello netty ! ".getBytes(CharsetUtil.UTF_8));
        // writeAndFlush 往另一端发数据
        ctx.writeAndFlush(bf);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //ctx 上下文对象 包含 通道channel  管道pipeline
        //收到数据 业务写这里就好了
        ByteBuf bf = (ByteBuf) msg;
        System.out.println("netty client handle  收到数据"+bf.toString(CharsetUtil.UTF_8));
    }
}
