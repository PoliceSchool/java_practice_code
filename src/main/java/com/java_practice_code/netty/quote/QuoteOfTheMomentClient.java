package com.java_practice_code.netty.quote;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.SocketUtils;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/8/22.
 */
public class QuoteOfTheMomentClient {
    static final int PORT = Integer.parseInt(System.getProperty("port", "7686"));

    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new QuoteOfTheMomentClientHandler());

            Channel ch = b.bind(0).sync().channel();

            // Broadcast the QOTM request to port 8080
            ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("QOTM?", CharsetUtil.UTF_8), SocketUtils.socketAddress("255.255.255.255", PORT))).sync();

            if (!ch.closeFuture().await(5000)) {
                System.err.println("QOTM request timed out");
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}
