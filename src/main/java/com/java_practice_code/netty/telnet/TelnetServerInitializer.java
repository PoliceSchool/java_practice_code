package com.java_practice_code.netty.telnet;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslContext;


/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/8/21.
 */
public class TelnetServerInitializer extends ChannelInitializer<SocketChannel> {
    private static final StringDecoder DECODER = new StringDecoder();
    private static final StringEncoder ENCODER = new StringEncoder();

    private static final TelnetServerHandler SERVER_HANDLER = new TelnetServerHandler();

    private final SslContext sslCtx;

    public TelnetServerInitializer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        if (sslCtx != null){
            pipeline.addLast(sslCtx.newHandler(socketChannel.alloc()));
        }

        // Add the text line codec combination first
        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast(DECODER);
        pipeline.addLast(ENCODER);

        // and the business logic
        pipeline.addLast(SERVER_HANDLER);
    }
}
