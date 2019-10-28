package com.java_practice_code.jdbctemplatedemo.v1;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/11.
 */
public abstract class MyJdbcTemplate {
    /**
     * 这是模板方法
     *
     * @param sql
     * @return
     */
    public final Object execute(String sql) {
        System.out.println("父类定义的算法流程1");
        System.out.println("父类定义的算法流程2");
        // 由子类实现的抽象方法
        System.out.println(doInStatement(sql));
        System.out.println("父类定义的算法流程3");
        return "查找成功";
    }

    protected abstract Object doInStatement(String sql);
}
