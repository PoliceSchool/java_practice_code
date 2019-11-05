package com.java_practice_code.designpattern.state.way_1;

/**
 * @author: lujingxiao
 * @description: 参考教材：https://blog.csdn.net/kemucc/article/details/10452859
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public class TestMain {
    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        orderContext.confirm();     //已预定状态>已确认状态
        orderContext.modify();      //已确认状态>已预定状态
        orderContext.confirm();    //已预定状态>已确认状态
        orderContext.pay();       //已确认状态>已锁定状态
        orderContext.modify();    //已锁定状态
    }
}
