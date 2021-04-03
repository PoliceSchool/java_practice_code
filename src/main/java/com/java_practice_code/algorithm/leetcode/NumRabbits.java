package com.java_practice_code.algorithm.leetcode;

import com.java_practice_code.工作中常用的代码或者工具类.MergeRecord;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NumRabbits {

    public static void main(String[] args) {
        NumRabbits numRabbits = new NumRabbits();
        numRabbits.test1();
        numRabbits.test2();
        numRabbits.test3();
        numRabbits.test4();
        numRabbits.test5();
        numRabbits.test6();
    }

    private void test1() {
        int[] arr = {1, 1, 2};
        System.out.println(numRabbits(arr));
    }

    private void test2() {
        int[] arr = {10, 10, 10};
        System.out.println(numRabbits(arr));
    }

    private void test3() {
        int[] arr = {};
        System.out.println(numRabbits(arr));
    }

    private void test4() {
        int[] arr = {1, 0, 1, 0, 0};
        System.out.println(numRabbits(arr));
    }

    private void test5() {
        int[] arr = {0, 0, 1, 1, 1};
        System.out.println(numRabbits(arr));
    }

    private void test6() {
        int[] arr = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(numRabbits(arr));
    }

    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int answer : answers) {
            if (answer == 0) {
                result++;
                continue;
            }
            map.compute(answer, (key, value) -> (value == null) ? 1 : value + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            int item = key + 1;
            if (value > key) {
                result = result + (value / item) * item + (value % item == 0 ? 0 : 1) * item;
            } else {
                result += item;
            }
        }
        return result;
    }

//    public int numRabbits(int[] answers) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int result = 0;
//        for (int answer : answers) {
//            if (answer == 0) {
//                result++;
//                continue;
//            }
//            int value = map.compute(answer, (k, v) -> (v == null) ? 1 : v + 1);
//            if (value > answer) {
//                result += answer + 1;
//                value -= answer + 1;
//            }
//            if (value == 0) {
//                map.remove(answer);
//                continue;
//            }
//            map.put(answer, value);
//        }
//        for (Integer value : map.keySet()) {
//            result += value + 1;
//        }
//        return result;
//    }
}
