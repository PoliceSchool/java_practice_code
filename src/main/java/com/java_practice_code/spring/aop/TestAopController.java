package com.java_practice_code.spring.aop;

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
    @GetMapping("/index")
    @TestAnnotation(msg = "i am msg")
    public String index() {
        return "hello";
    }
}
