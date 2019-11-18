package com.java_practice_code.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * description: 数据库连接类
 * date: Created in 2019/11/15.
 *
 * @author lujingxiao
 */
class DBUtil {
    private final static String PASSWORD = "root";
    private final static String USER_NAME = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/test_insert";

    /**
     * 记得导入JDBC驱动包，不然会报错；
     * 到下面这个网址下载jdbc8的驱动，下载完Platform Independent版本的zip包后，
     * 打开idea，点击file->Project Structure->SDKs，然后点击“+”添加jar包
     * https://dev.mysql.com/downloads/connector/j/
     */
    static Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}
