package com.java_practice_code.jdbctemplatedemo.v2;


/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/11.
 */
public class JdbcTest {
    public static void main(String[] args) {
        query("select * from user");
    }

    //内部类方式
    public static void query(final String sql) {
        int i = 99;
        class QueryStatementCallbackOne implements StatementCallback {
            @Override
            public Object doInStatement() {
                System.out.println("QueryStatementCallbackOne 执行完成" + i);
                return "执行完成";
            }

        }

        MyJdbcTemplate myJdbcTemplate = new MyJdbcTemplate();
        myJdbcTemplate.execute(new QueryStatementCallbackOne());
    }

    //内部类方式
    public static void query2(final String sql) {
        MyJdbcTemplate myJdbcTemplate = new MyJdbcTemplate();
        myJdbcTemplate.execute(new StatementCallback() {
            @Override
            public Object doInStatement() {
                System.out.println("QueryStatementCallbackOne 执行完成");
                return "执行完成";
            }
        });
    }
}
