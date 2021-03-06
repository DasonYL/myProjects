package com.nt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @Author syl
 * @Date 2022/05/04/22:14
 * @Description:
 * @Version 1.0
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /***
    * @Description: 当客户端连接服务器完成就会触发该方法
    * @Param: [ctx]
    * @return: void
    * @throws Exception
    * @Author: syl
    * @Date: 2022/5/4
    */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("HelloServer", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);
    }

    /***
    * @Description: 当通道有读取事件时会触发，即服务端发送数据给客户端
    * @Param: [ctx, msg]
    * @return: void
    * @Author: syl
    * @Date: 2022/5/4
    */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("收到服务端的消息:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务端的地址： " + ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
