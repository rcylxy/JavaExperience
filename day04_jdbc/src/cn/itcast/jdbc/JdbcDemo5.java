package cn.itcast.jdbc;

import java.sql.*;

/**
 * @Classname JdbcDemo5
 * @Date 2022/6/28 11:01
 * @Created by 李晓阳
 */
public class JdbcDemo5 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet ret = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.56.10:3306/db1", "root", "root");
            String sql = "select * from dept";
            stmt = conn.createStatement();
//            int ret = stmt.executeUpdate(sql);
            ret = stmt.executeQuery(sql);
            System.out.println("id\tname");
            while (ret.next()) {
                int id = ret.getInt(1);
                String name = ret.getString("name");
                System.out.println(id + "\t" + name);
            }
//            System.out.println(ret);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ret != null) try {
                ret.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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