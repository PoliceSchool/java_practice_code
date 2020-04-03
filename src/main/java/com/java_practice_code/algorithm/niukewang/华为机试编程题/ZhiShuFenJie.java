package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛客网：https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&tqId=21229&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 参考：https://baike.baidu.com/item/%E5%88%86%E8%A7%A3%E8%B4%A8%E5%9B%A0%E6%95%B0/2253749?fr=aladdin
 */
public class ZhiShuFenJie {
    public static void main(String[] args) {
        zhiShuFenJie4Main();
    }

    private static void zhiShuFenJie() {
        Scanner scanner = new Scanner(System.in);
        long[] data = new long[50];
        StringBuilder result = new StringBuilder();
        long n, m;
        while (scanner.hasNext()) {
            n = scanner.nextLong();
            m = n;
            int flag = 0;
            Arrays.fill(data, 0, 50, 0);
            result.delete(0, result.length());
            // 在2~n范围内查找质数
            // 如果找到一个质数x，那说明n可以分解为x*(n/x),所以下一次迭代的范围为2~(n/x)
            // 比如原始数字是180，一开始找到了2这个质数，那么180就可以分解为2*90;那么下一次迭代范围就是2~90
            for (long i = 2; i <= n; i++) {
                if (n % i == 0) {
                    data[flag] = i;
                    flag++;
                    n = n / i;
                    i--;
                }
            }
            if (flag < 2) {
                result.append(m);
                result.append(" ");
            } else {
                for (int i = 0; i < flag; i++) {
                    result.append(data[i]);
                    result.append(" ");
                }
            }
            System.out.println(result.toString());
        }
    }

    private static void zhiShuFenJiea2() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        long n, m;
        while (scanner.hasNext()) {
            m = n = scanner.nextLong();
            result.delete(0, result.length());
            // 在2~n范围内查找质数
            // 如果找到一个质数x，那说明n可以分解为x*(n/x),所以下一次迭代的范围为2~(n/x)
            // 比如原始数字是180，一开始找到了2这个质数，那么180就可以分解为2*90;那么下一次迭代范围就是2~90
            for (long i = 2; i <= n; i++) {
                if (n % i == 0) {
                    result.append(i);
                    result.append(" ");
                    n /= i--;
                }
            }
            if (result.length() == 0) {
                result.append(m);
                result.append(" ");
            }
            System.out.println(result.toString());
        }
    }

    private static void zhiShuFenJiea3() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        long n, m;
        m = n = scanner.nextLong();
        result.delete(0, result.length());
        // 在2~n范围内查找质数
        // 如果找到一个质数x，那说明n可以分解为x*(n/x),所以下一次迭代的范围为2~(n/x)
        // 比如原始数字是180，一开始找到了2这个质数，那么180就可以分解为2*90;那么下一次迭代范围就是2~90
        for (long i = 2; i <= n; i++) {
            if (n % i == 0) {
                result.append(i).append(" ");
                n /= i--;
            }
        }
        if (result.length() == 0) {
            result.append(m).append(" ");
        }
        System.out.println(result.toString());
        scanner.close();
    }

    private static void zhiShuFenJie4Main() {
        Scanner sc = new Scanner(System.in);
        long params = sc.nextLong();
        if (params < 2) {
            sc.close();
            return;
        }
        String result = zhiShuFenJie4(params);
        System.out.println(result);
        sc.close();
    }

    private static String zhiShuFenJie4(long ulDataInput) {
        StringBuilder str = new StringBuilder();
        int index = 2;
        while (index <= ulDataInput) {
            if (ulDataInput % index == 0) {
                if (index == ulDataInput) {
                    str.append(index).append(" ");
                    break;
                } else {
                    str.append(index).append(" ");
                    ulDataInput = ulDataInput / index;
                }
            } else {
                index++;
            }
        }
        return str.toString();
    }
}
