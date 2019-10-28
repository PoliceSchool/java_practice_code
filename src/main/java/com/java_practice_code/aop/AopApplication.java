package com.java_practice_code.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/6.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AopApplication.class, args);
        WeixinService weixinService = applicationContext.getBean(WeixinService.class);
        weixinService.share("https://www.jianshu.com/u/db7d7a281529");
        weixinService.shareProxy("https://www.jianshu.com/u/db7d7a281529");
    }
}
