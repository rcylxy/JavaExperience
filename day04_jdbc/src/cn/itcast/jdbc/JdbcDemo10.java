package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Classname JdbcDemo10
 * @Date 2022/6/28 18:11
 * @Created by 李晓阳
 */
public class JdbcDemo10 {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        conn = JDBCUtils.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "update account set balance = balance - ? where id =?";
        String sql2 = "update account set balance = balance + ? where id =?";
        try {
            assert conn != null;
            stmt1 = conn.prepareStatement(sql1);
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
        try {
            stmt2 = conn.prepareStatement(sql2);
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
        try {
            assert stmt1 != null;
            stmt1.setInt(1, 500);
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
        try {
            stmt1.setInt(2, 1);
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
        try {
            assert stmt2 != null;
            stmt2.setInt(1, 500);
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
        try {
            stmt2.setInt(2, 2);
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
        try {
            stmt1.executeUpdate();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
//        int i = 3 / 0;
        try {
            stmt2.executeUpdate();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }
        conn.commit();


    }
}
