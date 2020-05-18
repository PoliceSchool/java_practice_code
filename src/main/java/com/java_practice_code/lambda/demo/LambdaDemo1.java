package com.java_practice_code.lambda.demo;

// https://www.bilibili.com/video/BV1sE411P7C1?p=10
public class LambdaDemo1 {
    interface Printer {
        void printer(String val);
    }

    public static void printSomething(String something, Printer printer) {
        printer.printer(something);
    }

    public static void main(String[] args) {
        String some = "falskdjf";

        Printer printer = (String val) -> {
            System.out.println(val);
        };

        Printer printer1 = (val) -> {
            System.out.println(val);
        };

        Printer printer2 = val -> {
            System.out.println(val);
        };

        Printer printer3 = val -> System.out.println(val);

        Printer printer4 = val -> System.out.println(val);

        Printer printer5 = System.out::println;

        printSomething(some, printer5);
    }
}
