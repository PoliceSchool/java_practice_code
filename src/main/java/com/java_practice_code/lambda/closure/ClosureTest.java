package com.java_practice_code.lambda.closure;

/**
 * description: 闭包接口测试方法
 * date: Created in 2020/1/19.
 *
 * @author lujingxiao
 */
public class ClosureTest {
    public static void main(String[] args) {
        ClosureTest closureTest = new ClosureTest();
        System.out.println(closureTest.testClosure(() -> 123));
    }

    public Object testClosure(Closure closure) {
        return closure.getData();
    }
}
