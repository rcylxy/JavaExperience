package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @Classname JdbcDemo8
 * @Date 2022/6/28 16:46
 * @Created by 李晓阳
 */
public class JdbcDemo8 {
    public boolean login(String username, String password) {
        if (username == null || password == null)
            return false;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            assert conn != null;
            stmt = conn.createStatement();
            String sql = "SELECT PASSWORD FROM test WHERE username = '" + username + "'";
            rs = stmt.executeQuery(sql);
            rs.next();
            String psw = rs.getString("password");

            return psw.equals(password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn, rs);
        }
        return false;
    }

    public static void main(String[] args) {
        JdbcDemo8 test = new JdbcDemo8();
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
