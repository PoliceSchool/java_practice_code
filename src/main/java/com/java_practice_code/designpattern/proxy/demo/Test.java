package com.java_practice_code.designpattern.proxy.demo;


import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/23.
 */
public class Test {
    public static void main(String[] args) {
        Eat eat = new EatImpl();
        EatHandler eatHandler = new EatHandler(eat);
        Eat proxyEat = (Eat) Proxy.newProxyInstance(eat.getClass().getClassLoader(), new Class[]{Eat.class}, eatHandler);
        System.out.println(proxyEat.getClass().getName());
        proxyEat.eat();

        // 打印JVM在内存中生成的动态代理类
        createProxyClassFile(Eat.class);
    }

    private static void createProxyClassFile(Class c) {
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{c});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("$Proxy0.class");
            fileOutputStream.write(data);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
