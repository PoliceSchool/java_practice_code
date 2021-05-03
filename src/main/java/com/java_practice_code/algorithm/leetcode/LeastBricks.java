package com.java_practice_code.algorithm.leetcode;

import java.util.*;

public class LeastBricks {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        List<List<Integer>> wall = new ArrayList<>();
        Integer[] arr1 = {1, 2, 2, 1};
        Integer[] arr2 = {3, 1, 2};
        Integer[] arr3 = {1, 3, 2};
        Integer[] arr4 = {2, 4};
        Integer[] arr5 = {3, 1, 2};
        Integer[] arr6 = {1, 3, 1, 1};
        wall.add(Arrays.asList(arr1));
        wall.add(Arrays.asList(arr2));
        wall.add(Arrays.asList(arr3));
        wall.add(Arrays.asList(arr4));
        wall.add(Arrays.asList(arr5));
        wall.add(Arrays.asList(arr6));

        System.out.println(new LeastBricks().leastBricks(wall));
    }


    private int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> subWall : wall) {
            int size = subWall.size();
            int sum = 0;
            for (int i = 0; i < size - 1; i++) {
                sum += subWall.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result = Math.max(entry.getValue(), result);
        }
        return wall.size() - result;
    }

}
