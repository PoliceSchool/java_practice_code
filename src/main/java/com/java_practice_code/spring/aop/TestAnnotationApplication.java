package com.java_practice_code.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: 切面里面拿到注解参数;
 * spring aop是使用java 动态代理还是cglib代理实现的? 1.当被代理的类没有实现接口是,使用的是cglib  2.当被代理的类实现了接口时,使用的是java动态代理
 * date: Created in 2019/12/27.
 * 参考资料：http://www.voidcn.com/article/p-mlgpchyi-bpy.html
 *
 * @author lujingxiao
 */
@SpringBootApplication
public class TestAnnotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestAnnotationApplication.class, args);
    }

}
