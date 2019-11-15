package com.java_practice_code.designpattern.state.way_2;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public class TestMain {
    public static void main(String[] args) {
        Context context = new Context();
        context.printInfo();

        // 用户付款
        context.action();
        context.printInfo();
        // 商家出库
        context.action();
        context.printInfo();
        // 用户收货
        context.action();
        context.printInfo();
        // 评价成功，订单完结
        context.action();
        context.printInfo();
    }
}
