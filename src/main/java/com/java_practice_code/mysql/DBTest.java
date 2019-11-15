package com.java_practice_code.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

/**
 * description: 数据库测试
 * date: Created in 2019/11/15.
 *
 * @author lujingxiao
 */
public class DBTest {
    private final Logger logger = LoggerFactory.getLogger(DBTest.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new DBTest().batchSave2();
    }

    private void insertSingleData() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            logger.info("连接数据库...");
            conn = DBUtil.getConnection();
            logger.info("实例化Statement对象...");
            ps = conn.prepareStatement(getInsertDataSql());
            setData(ps, 1);
            // 完成后关闭
            int resultSet = ps.executeUpdate();
            if (resultSet > 0) {
                logger.info("success");
            } else {
                logger.info("failure");
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private String getInsertDataSql() {
        return "insert into yun_cashflow (userid,type,operatoruserid,withdrawdepositid,money) values(?,?,?,?,?)";
    }

    private void setData(PreparedStatement ps, int index) throws SQLException {
        ps.setInt(1, index);
        ps.setInt(2, index);
        ps.setInt(3, index);
        ps.setInt(4, index);
        ps.setDouble(5, index * 1.0);
    }

    /**
     * 批量添加数据
     */
    private void batchSave() {
        int singleNum = 1000;
        int totalLoopNum = 1;
        Connection conn = null;
        PreparedStatement ps = null;
        long startTime = System.currentTimeMillis();
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(getInsertDataSql());
            for (int loop = 0; loop < totalLoopNum; loop++) {
                int index = 0;
                for (; index < (singleNum * (loop + 1)); index++) {
                    ps.clearParameters();
                    setData(ps, index);
                    ps.execute();
                }
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        logger.info("总花费时间：{}", (System.currentTimeMillis() - startTime));
    }

    private void batchSave2() throws ClassNotFoundException, SQLException {
        long startTime = System.currentTimeMillis();
        Connection conn = DBUtil.getConnection();
        Statement statement = null;
        int loopCount = 10000;
        int recordCount = 10000;
        for (int loop = 1; loop <= loopCount; loop++) {
            statement = conn.createStatement();
            String sql = getBatchInsertDataSql((loop - 1) * recordCount, loop * recordCount);
            statement.execute(sql);
        }
        statement.close();
        conn.close();
        logger.info("总花费时间：{}", (System.currentTimeMillis() - startTime));
    }

    private String getBatchInsertDataSql(int start, int end) {
        StringJoiner joiner = new StringJoiner(",");
        for (int i = start; i < end; i++) {
            joiner.add("(" + i + "," + i + "," + i + "," + i + "," + i * 1.0 + ")");
        }
        return "insert into yun_cashflow (userid,type,operatoruserid,withdrawdepositid,money) values " + joiner.toString();
    }
}
