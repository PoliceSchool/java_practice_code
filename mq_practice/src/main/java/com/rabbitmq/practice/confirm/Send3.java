package com.rabbitmq.practice.confirm;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.practice.util.ConnectionUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;

/**
 * mq confirm模式下的批量模式,即发送一批消息就确认一批消息
 * 值得注意的是:如果出问题了那么这一批消息都消失了,需要重复发送这一批消息;有可能性能反而下降
 * <p>
 * 批量模式也简单,就是将普通模式的发送单条改为for循环发送多条
 * 最后再统一确认即可
 */
public class Send3 {
    private static final String QUEUE_NAME = "test_queue_confirm3";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 获取一个连接
        Connection con = ConnectionUtils.getConnection();
        // 从连接中获取一个通道
        Channel channel = con.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 生产者调用confirmSelect 将channel设置为confirm模式
        // 注意,如果该队列以及设置为tx模式,那么将其设置为confirm模式将会报错
        channel.confirmSelect();

        // 存放未确认的消息标识
        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<>());

        // 通道添加监听
        channel.addConfirmListener(new ConfirmListener() {
            // 没有问题的回执
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                // multiple:有可能一下子返回多个消息的确认,所以需要这个字段
                if (multiple) {
                    System.out.println("----handleAck----multiple");
                    confirmSet.headSet(deliveryTag + 1).clear();
                } else {
                    System.out.println("----handleAck----multiple false");
                    confirmSet.remove(deliveryTag);
                }
            }

            // 有问题的回执,具体业务逻辑具体处理,你可以重发,但是这里就直接删除了
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                if (multiple) {
                    System.out.println("----handleNack----multiple");
                    confirmSet.headSet(deliveryTag + 1).clear();
                } else {
                    System.out.println("----handleNack----multiple false");
                    confirmSet.remove(deliveryTag);
                }
            }
        });

        String msg = "hello confirm message add confirm listener!";
        while (true) {
            long seqNo = channel.getNextPublishSeqNo();
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            confirmSet.add(seqNo);
        }
    }
}
