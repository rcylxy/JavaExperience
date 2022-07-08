package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @Classname JdbcDemo9
 * @Date 2022/6/28 17:48
 * @Created by 李晓阳
 */
public class JdbcDemo9 {
    public boolean login(String username, String password) {
        if (username == null || password == null)
            return false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            assert conn != null;
            String sql = "select * from test where username = ? and password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn, rs);
        }
        return false;
    }

    public static void main(String[] args) {
        JdbcDemo9 test = new JdbcDemo9();
        Scanner in = new Scanner(System.in);
        String username = in.next();
        String password = in.next();
        boolean res = test.login(username, password);
        if (res) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登陆失败！");
        }

    }
}
