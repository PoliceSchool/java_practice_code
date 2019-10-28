package com.java_practice_code.jdbctemplatedemo.v2;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/11.
 */
public class MyJdbcTemplate {
    /**
     * 这是模板方法
     *
     * @param action
     * @return
     */
    public final Object execute(StatementCallback action) {
        System.out.println("父类定义的算法流程1");
        System.out.println("父类定义的算法流程2");
        // 由接口实现的方法
        action.doInStatement();
        System.out.println("父类定义的算法流程3");
        return "查找成功";
    }
}
