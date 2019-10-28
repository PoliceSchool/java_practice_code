package com.java_practice_code.designpattern.template;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/7.
 */
public class ConcreteClassA extends AbstractClass {

    @Override
    protected String answer1() {
        return "A";
    }

    @Override
    protected String answer2() {
        return "B";
    }
}
