package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9?tpId=37&tqId=21246&tPage=2&rp=&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking
 */
public class DeleteCharInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            solution2(str);
        }
    }

    private static void solution(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>(26);
        for (char aChar : chars) {
            int count = map.getOrDefault(aChar, 0);
            map.put(aChar, count + 1);
        }
        int size = 0;
        Set<Character> characters = map.keySet();
        for (Character key : characters) {
            int value = map.get(key);
            if (size == 0) {
                size = value;
            } else {
                size = value < size ? value : size;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (map.get(aChar) != size) {
                sb.append(aChar);
            }
        }
        System.out.println(sb.toString());
    }

    private static void solution2(String str) {
        char[] chars = str.toCharArray();
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>(26);
        for (char aChar : chars) {
            int count = map.getOrDefault(aChar, 0) + 1;
            map.put(aChar, count);
            min = min < count ? min : count;
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (map.get(aChar) != min) {
                sb.append(aChar);
            }
        }
        System.out.println(sb.toString());
    }
}
