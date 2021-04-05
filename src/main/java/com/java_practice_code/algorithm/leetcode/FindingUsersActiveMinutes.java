package com.java_practice_code.algorithm.leetcode;

import java.util.*;

public class FindingUsersActiveMinutes {

    public static void main(String[] args) {
        FindingUsersActiveMinutes findingUsersActiveMinutes = new FindingUsersActiveMinutes();
        findingUsersActiveMinutes.test1();
        findingUsersActiveMinutes.test2();
    }

    private void test1() {
        int[][] arr = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        System.out.println(Arrays.toString(findingUsersActiveMinutes(arr, 5)));
    }

    private void test2() {
        int[][] arr = {{1, 1}, {2, 2}, {2, 3}};
        System.out.println(Arrays.toString(findingUsersActiveMinutes(arr, 4)));
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0];
            int min = log[1];
            Set<Integer> set = map.compute(id, (key, value) -> (value == null) ? new HashSet<>() : value);
            set.add(min);
        }
        TreeMap<Integer, Integer> result = new TreeMap<>();
        for (Set<Integer> set : map.values()) {
            result.compute(set.size(), (key, value) -> (value == null) ? 1 : value + 1);
        }
        int[] arr = new int[k];
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            arr[entry.getKey() - 1] = entry.getValue();
        }
        return arr;
    }
}
