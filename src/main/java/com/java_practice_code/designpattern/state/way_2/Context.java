package com.java_practice_code.designpattern.state.way_2;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public class Context {
    private OrderState orderState;

    public Context() {
        this.orderState = new DaiFuKuanState();
    }

    public Context(OrderState orderState) {
        this.orderState = orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void action() {
        this.orderState.action(this);
    }

    public void printInfo() {
        this.orderState.doPrint();
    }
}
