package com.java_practice_code.designpattern.state.way_2;

/**
 * @author: lujingxiao
 * @description: 参考教材：https://blog.csdn.net/weixin_33670713/article/details/85151845
 * @since:
 * @version:
 * @date: Created in 2019/11/5.
 */
public interface OrderState {
    void action(Context context);
    void doPrint();
}
