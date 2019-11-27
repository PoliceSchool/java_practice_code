package com.java_practice_code.currying_functions;

import java.util.function.Function;

/**
 * @author: lujingxiao
 * @description: 参考资料：https://www.geeksforgeeks.org/currying-functions-in-java-with-examples/
 * @since:
 * @version:
 * @date: Created in 2019/11/27.
 */
public class CurryingFunctionDemo {
    public static void main(String args[]) {
        test2();
    }

    private static void test1() {
        // Using Java 8 Functions
        // to create lambda expressions for functions
        // and with this, applying Function Currying

        // Curried Function for Adding u & v
        Function<Integer, Function<Integer, Integer>> curryAdder = u -> v -> u + v;

        // Calling the curried functions

        // Calling Curried Function for Adding u & v
        System.out.println("Add 2, 3 :" + curryAdder.apply(2).apply(3));
    }

    private static void test2() {
        Function<String, Function<Integer, String>> curryAdder = u -> v -> u + v;

        System.out.println("append 3 and 2 is : " + curryAdder.apply("3").apply(2));

    }
}
