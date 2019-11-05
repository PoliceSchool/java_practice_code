package com.java_practice_code.designpattern.state.way_1;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public class LockedState extends OrderState {
    @Override
    void confirm(OrderContext orderContext) {
        System.out.println("订单已锁定");
    }

    @Override
    void modify(OrderContext orderContext) {
        System.out.println("订单已锁定");
    }

    @Override
    void pay(OrderContext orderContext) {
        System.out.println("订单已锁定");
    }
}
