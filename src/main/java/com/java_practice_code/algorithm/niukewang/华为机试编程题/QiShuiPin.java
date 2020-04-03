package com.java_practice_code.algorithm.niukewang.华为机试编程题;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/fe298c55694f4ed39e256170ff2c205f?tpId=37&tqId=21245&tPage=2&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class QiShuiPin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int result = 0;
            while (n != 0) {
                int tmp1 = n / 3;
                int tmp2 = n - tmp1 * 3;
                result += tmp1;
                n = tmp1 + tmp2;
                if (n == 1) {
                    break;
                }
                if (n == 2) {
                    result += 1;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
