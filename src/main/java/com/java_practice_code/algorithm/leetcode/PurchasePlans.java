package com.java_practice_code.algorithm.leetcode;

import com.java_practice_code.工作中常用的代码或者工具类.MergeRecord;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;

public class PurchasePlans {

    public static void main(String[] args) {
        PurchasePlans purchasePlans = new PurchasePlans();
        purchasePlans.test1();
        purchasePlans.test2();
    }

    private void test1() {
        int[] arr = {2, 5, 3, 5};
        System.out.println(new PurchasePlans().purchasePlans(arr, 6));
    }

    private void test2() {
        int[] arr = {2, 2, 1, 9};
        System.out.println(new PurchasePlans().purchasePlans(arr, 10));
    }


//    public int purchasePlans(int[] nums, int target) {
//
//        Map<Integer, Purchase> map = new HashMap<>();
//        for (int num : nums) {
//            map.compute(num, (k, v) -> (v == null) ? new Purchase(num, 1) : v.add());
//        }
//        int sum = 0;
//        ArrayList<Purchase> values = new ArrayList<>(map.values());
//        int size = values.size();
//        for (int i = 0; i < size; i++) {
//            Purchase first = values.get(i);
//            for (int j = i + 1; j < size; j++) {
//                Purchase second = values.get(j);
//                if (first.index + second.index <= target) {
//                    sum += first.count * second.count;
//                }
//            }
//        }
//        for (Purchase value : values) {
//            if (2 * value.index < target && value.count > 1) {
//                sum += (value.count * (value.count - 1)) / 2;
//            }
//        }
//        return sum % 1000000007;
//    }
//
//    class Purchase {
//        public int index;
//        public int count;
//
//        public Purchase(int index, int count) {
//            this.index = index;
//            this.count = count;
//        }
//
//        Purchase add() {
//            count++;
//            return this;
//        }
//    }

//    public int purchasePlans(int[] nums, int target) {
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int first = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (first + nums[j] <= target) {
//                    result = (result % 1000000007) + 1;
//                }
//            }
//        }
//        return result;
//    }


//    public int purchasePlans(int[] nums, int target) {
//        Arrays.sort(nums);
//        int mid = target / 2;
//        int[] tmp = new int[mid + 1];
//        int lteMidCount = 0;
//        int midIndex = 0;
//        for (; midIndex < nums.length; midIndex++) {
//            if (nums[midIndex] > mid) {
//                break;
//            }
//            lteMidCount++;
//        }
//        int result = lteMidCount * (lteMidCount - 1) / 2;
//        for (int i = 0; i < midIndex; i++) {
//            for (int j = midIndex; j < nums.length; j++) {
//                if (nums[i] + nums[j] <= target) {
//                    result++;
//                }
//            }
//        }
//        return result;
//    }


    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int[] tmp = new int[target];
        for (int num : nums) {
            tmp[num]++;
        }
        int sum = 0;
        for (int i = 1; i < target; i++) {
            if (tmp[i] == 0 || tmp[target - i] == 0) {
                continue;
            }
            if (i == (target - i) && tmp[i] > 1) {
                sum += tmp[i] * (tmp[i] - 1) / 2;
            }
            if (i != (target - i)) {
                if (tmp[i] + tmp[target - i] > 1) {
                    sum += tmp[i];
                }
            }
        }
        return sum;
    }
}
