package com.java_practice_code.netty.telnet;

import io.netty.channel.*;

import java.net.InetAddress;
import java.util.Date;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/8/21.
 */
@ChannelHandler.Sharable  //允许客户端的Handler重复注册和删除
public class TelnetServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // Send greeting for a new connection
        ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n");
        ctx.write("It is " + new Date() + " now.\r\n");
        ctx.flush();
    }

    @Override
    /**
     * 这里的channelRead0方法是被netty的某个线程调用的，也是我们用来编写业务代码的
     * 如果这里使用同步、并且耗时过长，那么netty也就会被阻塞，从而导致netty性能的下降
     * 如果这里的业务逻辑耗时过长，需要我们自己定义业务线程组异步执行我们的业务逻辑，避免降低netty的性能
     */
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String request) throws Exception {
        String response;
        boolean close = false;
        if (request.isEmpty()) {
            response = "Please type something.\r\n";
        } else if ("bye".equals(request.toLowerCase())) {
            response = "Have a good day!\r\n";
            close = true;
        } else {
            response = "Dis you say '" + request + "'?\r\n";
        }

        ChannelFuture future = channelHandlerContext.write(response);
        if (close) {
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
