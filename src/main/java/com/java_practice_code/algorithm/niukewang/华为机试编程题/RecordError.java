package com.java_practice_code.algorithm.niukewang.华为机试编程题;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.nowcoder.com/practice/2baa6aba39214d6ea91a2e03dff3fbeb?tpId=37&tqId=21242&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 简单错误记录
 */
public class RecordError {
    public static void main(String[] args) throws IOException {
        String str;
        LinkedHashMap<String, Integer> errorMap = new LinkedHashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while ((str = bufferedReader.readLine()) != null) {
            String[] arr = str.split("\\\\");
            String filename = arr[arr.length - 1];
            if (errorMap.containsKey(filename)) {
                int count = errorMap.get(filename);
                errorMap.put(filename, count + 1);
            } else {
                errorMap.put(filename, 1);
            }
        }
        int count = 1;
        int size = errorMap.size();
        Set<Map.Entry<String, Integer>> set = errorMap.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            if (size - count < 8) {
                String key = entry.getKey();
                String[] arr = key.split(" ");
                String filename = arr[0];
                String rowNum = arr[1];
                if (filename.length() > 16) {
                    System.out.println(filename.substring(filename.length() - 16) + " " + rowNum + " " + entry.getValue());
                } else {
                    System.out.println(filename + " " + rowNum + " " + entry.getValue());
                }
            }
            count++;
        }
    }
}
