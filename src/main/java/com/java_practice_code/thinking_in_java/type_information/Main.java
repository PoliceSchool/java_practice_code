package com.java_practice_code.thinking_in_java.type_information;

import java.util.HashMap;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/9.
 */
public class Main {
    public static void main(String[] args) {
        Object s = new HashMap<>();
        System.out.println(s instanceof TestInterface);
        s = new SubClass();
        System.out.println(s instanceof TestInterface);
    }
}
