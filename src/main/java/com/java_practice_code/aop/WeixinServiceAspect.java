package com.java_practice_code.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/6.
 */
@Aspect
@Component
public class WeixinServiceAspect {
    /**
     * 切面是基于代理的，所以如果在同一个类里面调用被切面的方法的话切面是不生效的
     * 例如：
     * AService里面有A和B两个方法，其中A被切面了，B中调用了A方法；
     * 此时如果BService中调用了AService中的A方法，那么切面就会生效；
     * 如果BService中调用了AService中的B方法，那么切面就不会生效；
     */

    /**
     * 任何类中的每个任何方法都可以是JoinPoint
     **/
//    @AfterReturning("execution(public void WeixinService.share(String))")
//    public void log(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature() + " executed");
//    }
    /*******************/


    /**
     * 可以将任意一个或者多个JoinPoint定义为切点，
     * 这样的话就可以在@AfterReturning这个Advice里面直接写成shareCut这个方法名
     **/
    @Pointcut("execution(public void WeixinService.share(String))")
    public void shareCut() {

    }

    @AfterReturning("shareCut()")
    public void log(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature() + " executed");
    }
    /*******************/
}
