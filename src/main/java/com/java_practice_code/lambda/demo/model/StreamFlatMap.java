package com.java_practice_code.lambda.demo.model;

import java.util.Arrays;
import java.util.List;

public class StreamFlatMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world");
        words.stream()
                .map(w -> w.split(""))
                .forEach(System.out::println);

        words.stream()
                .flatMap(w -> Arrays.stream(w.split("")))
                .forEach(System.out::println);
    }
}
