package com.java_practice_code.designpattern.state.way_2;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public class DaiPingJiaState implements OrderState {
    @Override
    public void action(Context context) {
        context.setOrderState(new CompletedOrder());
    }

    @Override
    public void doPrint() {
        System.out.println("经过一系列业务逻辑后，订单评价成功，状态从待评价状态变为完结状态。");
    }
}
