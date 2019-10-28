package com.java_practice_code.jdbctemplatedemo.callback;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/11.
 */
public interface CallBackInterface {
    Object doInStatement();

    String getSql();

    String getA();
    String getB();
    String getC();
}
