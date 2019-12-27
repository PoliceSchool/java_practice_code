package com.java_practice_code.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * description: 切面里面拿到注解参数
 * date: Created in 2019/12/27.
 * 参考资料：http://www.voidcn.com/article/p-mlgpchyi-bpy.html
 *
 * @author lujingxiao
 */
@Aspect
@Component
public class TestAnnotationAspect {
    @Pointcut("@annotation(com.java_practice_code.spring.aop.TestAnnotation)")
    public void pointcut() {
    }

    @Around("pointcut() && @annotation(testAnnotation)")
    public Object doSurround(ProceedingJoinPoint proceedingJoinPoint, TestAnnotation testAnnotation) throws Throwable {
        System.out.println(testAnnotation.msg());
        return proceedingJoinPoint.proceed();
    }
}
