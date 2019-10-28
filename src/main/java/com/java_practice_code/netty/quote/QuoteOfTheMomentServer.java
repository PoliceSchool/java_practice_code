package com.java_practice_code.netty.quote;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/8/22.
 */
public class QuoteOfTheMomentServer {
    private static final int PORT = Integer.parseInt(System.getProperty("port", "7686"));

    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioDatagramChannel.class).option(ChannelOption.SO_BROADCAST, true).handler(new QuoteOfTheMomentServerHandler());
            b.bind(PORT).sync().channel().closeFuture().await();
        } finally {
            group.shutdownGracefully();
        }
    }
}
