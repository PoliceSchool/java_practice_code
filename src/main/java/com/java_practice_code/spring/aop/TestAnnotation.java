package com.java_practice_code.spring.aop;

import java.lang.annotation.*;

/**
 * description: 切面里面拿到注解参数
 * date: Created in 2019/12/27.
 * 参考资料：http://www.voidcn.com/article/p-mlgpchyi-bpy.html
 *
 * @author lujingxiao
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TestAnnotation {
    String msg();
}
