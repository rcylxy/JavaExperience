package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Classname JdbcDemo4
 * @Date 2022/6/28 10:44
 * @Created by 李晓阳
 */
public class JdbcDemo4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.56.10:3306/db1", "root", "root");
            String sql = "CREATE TABLE test2(id INT, saraly INT, NAME VARCHAR(20))";
            stmt = conn.createStatement();
            int ret = stmt.executeUpdate(sql);
            System.out.println(ret);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
