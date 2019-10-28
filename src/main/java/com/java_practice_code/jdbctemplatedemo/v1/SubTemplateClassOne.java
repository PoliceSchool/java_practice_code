package com.java_practice_code.jdbctemplatedemo.v1;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/11.
 */
public class SubTemplateClassOne extends MyJdbcTemplate {
    @Override
    protected Object doInStatement(String sql) {
        System.out.println("SubTemplateClassOne 执行流程");
        return "执行sq语句成功, sql:" + sql;
    }
}
