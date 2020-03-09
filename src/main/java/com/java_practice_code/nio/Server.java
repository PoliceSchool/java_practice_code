package com.java_practice_code.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/10.
 */
public class Server {
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);

    String str;

    public void start() throws IOException {
        // 打开服务器套接字通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 设置为非阻塞模式
        ssc.configureBlocking(false);
        // 绑定本机的服务端端口
        ssc.bind(new InetSocketAddress("localhost", 8001));

        selector = Selector.open();
        // 注册到selector上，等待连接
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        // 当前线程什么情况下会被中断
        while (!Thread.currentThread().isInterrupted()) {
            // selector执行select方法是会被阻塞，直到有读事件发生
            selector.select();
            // 当读事件发生后，从selector找到可以读的事件，然后循环处理可以读的事件
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                // key在什么情况下是无效的？
                if (!key.isValid()) {
                    continue;
                }
                // 当一个key被返回时只知道这个key感兴趣的事件已经被触发了
                // 但是具体是什么事件还需要判断一下
                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isReadable()) {
                    read(key);
                } else if (key.isWritable()) {
                    write(key);
                }
                // 一旦某个事件处理完就从iterator里面移除，防止重复处理
                keyIterator.remove();
            }
        }
    }

    private void write(SelectionKey key) throws IOException, ClosedChannelException {
        SocketChannel channel = (SocketChannel) key.channel();
        System.out.println("write:" + str);
        System.out.println("write to " + channel.socket().toString());
        sendBuffer.clear();
        sendBuffer.put(str.getBytes());
        // 反转Buffer，最开始Buffer是用来写入的，所以它所指向的指针在最尾部
        // 通过反转可以将指针指向尾部，从而可以直接从头部顺序读出内容
        // 总结：将原本是写模式的Buffer转成读模式，用来读取数据
        sendBuffer.flip();
        channel.write(sendBuffer);
        // 手动将感兴趣的事件设置为读事件？
        channel.register(selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        System.out.println("read from " + channel.socket().toString());
        this.readBuffer.clear();

        int numRead;
        try {
            numRead = channel.read(this.readBuffer);
        } catch (IOException e) {
            key.cancel();
            channel.close();
            return;
        }

        str = new String(readBuffer.array(), 0, numRead);
        System.out.println(str);
        channel.register(selector, SelectionKey.OP_WRITE);
    }

    private void accept(SelectionKey key) throws IOException {
        // 获取channel对象
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        System.out.println("accept from " + ssc.socket().toString());
        // 为每一个新的连接创建一个SocketChannel
        SocketChannel clientChannel = ssc.accept();
        clientChannel.configureBlocking(false);
        // 将新的客户端channel注册到selector上，并将感兴趣的事件设置为读
        clientChannel.register(selector, SelectionKey.OP_READ);
    }

    public static void main(String[] args) throws IOException {
        // 下面那句代码是模拟其他线程在执行任务, 也就是模拟其他线程跟server的阻塞IO程序在强占CPU资源
        new MyThread2().start();
        System.out.println("");
        System.out.println("server started...");
        new Server().start();
    }


    static class MyThread1 extends Thread {
        @Override
        public void run() {
            System.out.println("其他工作线程" + Thread.currentThread().getId() + "工作了");
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new MyThread1().start();
            }
        }
    }
}
