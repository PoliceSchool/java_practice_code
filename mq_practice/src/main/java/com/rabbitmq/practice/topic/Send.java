package com.rabbitmq.practice.topic;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.practice.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取一个连接
        Connection con = ConnectionUtils.getConnection();
        // 从连接中获取一个通道
        Channel channel = con.createChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        // 发送消息
        String msg = "商品....";

        channel.basicPublish(EXCHANGE_NAME, "goods.delete", null, msg.getBytes());
        System.out.println("send msg");
        channel.close();
        con.close();
    }
}
