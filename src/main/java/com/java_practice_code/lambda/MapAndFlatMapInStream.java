package com.java_practice_code.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description: 在stream中flatMap和map的区别
 * date: Created in 2019/12/19.
 * 参考：https://www.baeldung.com/java-difference-map-and-flatmap
 *
 * @author lujingxiao
 */
public class MapAndFlatMapInStream {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        List<String> list = Arrays.asList("a", "b");
        System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }

    private static void test2() {
        List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
        System.out.println(list);
        System.out.println(list.stream().flatMap(Collection::stream).map(String::toUpperCase).collect(Collectors.toList()));
    }
}
