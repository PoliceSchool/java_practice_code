package com.java_practice_code.executor.callable;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/10.
 */
public class Duction implements Callable<String> {
    private final BigDecimal first;
    private final BigDecimal second;

    public Duction(BigDecimal first, BigDecimal second) {
        this.first = first;
        this.second = second;
    }


    @Override
    public String call() throws Exception {
        return "The dut result of Thread " + Thread.currentThread().getId() + " is " + first.subtract(second);
    }
}
