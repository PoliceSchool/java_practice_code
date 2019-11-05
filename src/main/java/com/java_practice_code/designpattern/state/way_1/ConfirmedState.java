package com.java_practice_code.designpattern.state.way_1;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public class ConfirmedState extends OrderState {

    @Override
    void confirm(OrderContext orderContext) {
        System.out.println("订单已确认，请勿重复操作！");
    }

    @Override
    void modify(OrderContext orderContext) {
        System.out.println("订单已修改，订单状态重置为预定状态，需再次确认！");
        orderContext.setState(new OrderedState());
    }

    @Override
    void pay(OrderContext orderContext) {
        System.out.println("经过业务逻辑处理后，订单已支付，订单状态变为已锁定状态！");
        orderContext.setState(new LockedState());
    }
}
