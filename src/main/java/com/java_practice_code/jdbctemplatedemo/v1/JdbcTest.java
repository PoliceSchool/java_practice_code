package com.java_practice_code.jdbctemplatedemo.v1;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/11.
 */
public class JdbcTest {
    public static void main(String[] args) {
        MyJdbcTemplate jdbcTemplate = new SubTemplateClassOne();
        jdbcTemplate.execute("select * from user");
    }
}
