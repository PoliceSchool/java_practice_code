package com.java_practice_code.designpattern.state.way_1;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public class OrderedState extends OrderState {
    @Override
    void confirm(OrderContext orderContext) {
        System.out.println("下单后，订单状态变为已确认状态");
        orderContext.setState(new ConfirmedState());
    }

    @Override
    void modify(OrderContext orderContext) {
        System.out.println("订单修改后，订单状态再次变回预定状态");
        orderContext.setState(this);
    }

    @Override
    void pay(OrderContext orderContext) {
        System.out.println("预定状态无法完成订单！");
    }
}
