package com.java_practice_code.designpattern.proxy.myproxy;


import com.java_practice_code.designpattern.proxy.demo.Eat;

import java.lang.reflect.Method;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/23.
 */
public class MyHandler implements MyInvocationHandler {

    private Eat eat;

    public MyHandler(Eat eat) {
        this.eat = eat;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(eat);
        after();
        return null;
    }

    public void before() {
        System.out.println("吃饭之前先洗手");
    }

    public void after() {
        System.out.println("吃饭之后要洗碗");
    }
}
