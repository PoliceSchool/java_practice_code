package com.java_practice_code.designpattern.template;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/7.
 */
public abstract class AbstractClass {
    public void templateMethod1() {
        System.out.println("模板方法1（题目1）");
        System.out.println("答案：" + answer1());
    }

    public void templateMethod2() {
        System.out.println("模板方法2（题目2）");
        System.out.println("答案：" + answer2());
    }

    protected abstract String answer1();

    protected abstract String answer2();
}
