package com.java_practice_code.algorithm.背包算法;

import java.util.Arrays;


public class KnapsackResult {
    public int result;
    public int[] used;

    public KnapsackResult(int result, int[] used) {
        this.result = result;
        this.used = used;
    }

    @Override
    public String toString() {
        return "KnapsackResult{" +
                "result=" + result +
                ", used=" + Arrays.toString(used) +
                '}';
    }
}
