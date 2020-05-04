package com.java_practice_code.lambda.demo;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo1 {

    public static void main(String[] args) throws IOException {
        // 对数组进行流操作
        String[] arr = {"Monkey", "Lion", "Giraffe", "Lemur"};
        List<String> result1 = Stream.of(arr).
                filter(s -> s.startsWith("L")). // 留下以L开头的字符串
                map(String::toUpperCase).       // 对每一个字符串进行字母大写处理
                sorted(/*这里可以填写排序规则*/).   // 排序
                collect(Collectors.toList());   // 转换成list
        result1.forEach(System.out::println);

        // 对list进行流操作
        List<String> list = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");
        List<String> result2 = list.stream().
                filter(s -> s.startsWith("L")). // 留下以L开头的字符串
                map(String::toUpperCase).       // 对每一个字符串进行字母大写处理
                sorted(/*这里可以填写排序规则*/).   // 排序
                collect(Collectors.toList());   // 转换成list
        result2.forEach(System.out::println);

        // 对set进行流操作
        Set<String> set = new HashSet<>(list);
        Map<String, String> map1 = set.stream().
                filter(s -> s.startsWith("L")). // 留下以L开头的字符串
                map(String::toUpperCase).       // 对每一个字符串进行字母大写处理
                sorted(/*这里可以填写排序规则*/).   // 排序
                collect(Collectors.toMap(Function.identity(), s -> s));   // 转换成map
        map1.forEach((k, v) -> System.out.println(k + " " + v));

        // 对文件进行流操作
        Map<String, String> map2 = Files.lines(Paths.get("file.txt")).
                filter(s -> s.startsWith("L")). // 留下以L开头的字符串
                map(String::toUpperCase).       // 对每一个字符串进行字母大写处理
                sorted(/*这里可以填写排序规则*/).   // 排序
                collect(Collectors.toMap(Function.identity(), s -> s));   // 转换成map
        map2.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
