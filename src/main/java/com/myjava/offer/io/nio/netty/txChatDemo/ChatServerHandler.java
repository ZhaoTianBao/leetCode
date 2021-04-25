package com.myjava.offer.io.nio.netty.txChatDemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    //全局事件执行器   用来存储 当前连接的客户端  客户端不能直接发消息给客户端，要通过服务端中转
    private static ChannelGroup channelGroup =  new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *
     * 表示 channel 处于就绪状态 上线
     *
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        String loginMsg = " [客户端] "+ channel.remoteAddress()+" 上线了 " + sdf.format(new Date()) + "\n";
        //将该客户端 发送的信息 推送给 其他在线的客户端
        //该方法  遍历channelGroup 所有的channel 发送消息
        channelGroup.writeAndFlush(loginMsg);
        //发送数据
        //将当前channel 加入channelGroup
        channelGroup.add(channel);
        System.out.println(channel.remoteAddress()+" 上线了 "+"\n");
    }

    /**
     *      表示channel 处于不活跃状态 离线了
     */

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将客户离开信息推送给当前在线客户
        String logoutMsg = " [客户端] "+ channel.remoteAddress()+" 下线了 " + sdf.format(new Date()) + "\n";
        channelGroup.writeAndFlush(logoutMsg);
        System.out.println("当前还在线channel 数量size "+channelGroup.size());
    }


    /**
     * 读取数据
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        //遍历channelGroup根据不同情况，回复不同信息
        channelGroup.forEach(ch -> {
            String content = "";
            if (channel != ch){
                //不是当前channel 转发消息
                content = " [客户端] "+ channel.remoteAddress()
                        +"  " + sdf.format(new Date())
                        +" 发送了消息 "
                        + msg
                        + "\n";
                ch.writeAndFlush(content);
            }else{
                content = " [自己] "+ channel.remoteAddress()
                        +"  " + sdf.format(new Date())
                        +" 发送了消息 "
                        + msg
                        + "\n";
                ch.writeAndFlush(content);
            }
        });
    }


    /**
     * 关闭通道
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }




}
