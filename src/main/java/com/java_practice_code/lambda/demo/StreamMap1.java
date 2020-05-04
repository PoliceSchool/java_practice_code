package com.java_practice_code.lambda.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");

        List<String> listUpper = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(listUpper);

        Stream.of("Monkey", "Lion", "Giraffe", "Lemur").mapToInt(String::length).forEach(System.out::println);
    }
}
