package com.java_practice_code.designpattern.state.way_2;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public class CompletedOrder implements OrderState {
    @Override
    public void action(Context context) {
        context.setOrderState(null);
    }

    @Override
    public void doPrint() {
        System.out.println("订单完结");
    }
}
