package com.nt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @Author syl
 * @Date 2022/05/04/22:01
 * @Description:  自定义Handler需要继承netty规定好的某个HandlerAdapter(规范)
 * @Version 1.0
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /***
    * @Description: 读取客户端发送的数据
    * @Param: ctx 上下文对象, 含有通道channel，管道pipeline
    * @param: msg 就是客户端发送的数据
    * @Author: syl
    * @Date: 2022/5/4
    * @throws Exception
    */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程 " + Thread.currentThread().getName());
        //Channel channel = ctx.channel();
        //ChannelPipeline pipeline = ctx.pipeline(); //本质上是个双向链表, 出栈入栈
        //将msg转成一个 ByteBuf，类似NIO 的 ByteBuffer
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
    }


    /***
    * @Description: 数据读取完毕处理方法
    * @Param: ctx
    * @throws Exception
    * @Author: syl
    * @Date: 2022/5/4
    */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("HelloClient", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);
    }


    /***
    * @Description: 对异常的处理（一般是需要关闭通道）
    * @Param: ctx
    * @Param: cause
    * @throws Exception
    * @Author: syl
    * @Date: 2022/5/4
    */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
