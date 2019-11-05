package com.java_practice_code.designpattern.state.way_2;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public class DaiFuKuanState implements OrderState{

    @Override
    public void action(Context context) {
        context.setOrderState(new DaiChuKuState());
    }

    @Override
    public void doPrint() {
        System.out.println("经过一系列业务逻辑后，订单支付成功，状态从待付款状态变为待出库状态。");
    }
}
