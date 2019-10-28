package com.java_practice_code.jdbctemplatedemo.callback;

/**
 * @author: lujingxiao
 * @description:
 * @since:
 * @version:
 * @date: Created in 2019/9/11.
 */
public class CallBackTest {
    public static void main(String[] args) {
        execute("select * from user");
    }

    private static void execute(final String sql) {
        String a = "a";
        String b = "b";
        String c = "c";

        class ExecuteStatementCallback1 implements CallBackInterface {
            @Override
            public Object doInStatement() {
                System.out.println(sql);
                return null;
            }

            @Override
            public String getSql() {
                return sql;
            }

            @Override
            public String getA() {
                return a;
            }

            @Override
            public String getB() {
                return b;
            }

            @Override
            public String getC() {
                return c;
            }
        }

        execute(new ExecuteStatementCallback1());
    }

    private static void execute(CallBackInterface callback) {
        callback.doInStatement();
        System.out.println(callback.getSql());
        System.out.println(callback.getA());
        System.out.println(callback.getB());
        System.out.println(callback.getC());
    }
}
