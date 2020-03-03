package com.java_practice_code.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 切面里面拿到注解参数
 * date: Created in 2019/12/27.
 * 参考资料：http://www.voidcn.com/article/p-mlgpchyi-bpy.html
 *
 * @author lujingxiao
 */
@RestController
public class TestAopController {
    @Autowired
    private TestServiceImpl testService;

    @Autowired
    private TestService2 testService2;

    // 当被代理的类实现了接口时,使用的是java动态代理
    @GetMapping("/index-with-interface")
    public String indexWithInterface() {
        return testService.index();
    }

    // 当被代理的类没有实现接口是,使用的是cglib
    @GetMapping("/index-without-interface")
    public String indexWithoutInterface() {
        return testService2.index();
    }
}
