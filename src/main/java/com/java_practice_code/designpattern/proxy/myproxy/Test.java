package com.java_practice_code.designpattern.proxy.myproxy;

import com.java_practice_code.designpattern.proxy.demo.Eat;
import com.java_practice_code.designpattern.proxy.demo.EatImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/23.
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, IOException, InvocationTargetException, ClassNotFoundException {
        Eat eat = new EatImpl();
        MyHandler eatHandler = new MyHandler(eat);
        Eat proxyEat = (Eat) MyProxy.newProxyInstance(new MyClassLoader("E:\\jimson\\github\\mall-learning\\demo\\src\\main\\java\\com\\proxy\\myproxy", "myproxy"), Eat.class, eatHandler);
        System.out.println(proxyEat.getClass().getName());
        proxyEat.eat();
    }
}
