package com.java_practice_code.designpattern.strategy;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/28.
 */
public class ZhiFuBaoStrategy implements Strategy {
    @Override
    public void pay() {
        System.out.println("ZhiFuBao Pay");
    }
}
