package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&tqId=21231&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出
 * 已通过牛客网测试
 */
public class MergeRecord {
    private void mergeRecord() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = Integer.parseInt(scanner.nextLine());
            while (n-- > 0) {
                String record = scanner.nextLine();
                String[] arr = record.split(" ");
                int index = Integer.parseInt(arr[0]);
                int valueVal = Integer.parseInt(arr[1]);
                map.compute(index, (key, value) -> value == null ? valueVal : value + valueVal);
            }
            map.forEach((key, value) -> System.out.println(key + " " + value));
        }
    }

    public static void main(String[] args) {
        new MergeRecord().mergeRecord();
    }
}
