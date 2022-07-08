package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Classname JdbcDemo1
 * @Date 2022/6/27 12:55
 * @Created by 李晓阳
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.10:3306/db1", "root", "root");
        String sql = "update emp set salary = 100";
        String sql2 = "select * from emp";
        Statement stmt = conn.createStatement();
        int count = stmt.executeUpdate(sql);
        // executeUpdate func is used to DML(insert update delete) DDL(create alter drop) ,
        // the return value is the nums of lines which are influenced
        ResultSet ret = stmt.executeQuery(sql2);
        System.out.println(count);
        stmt.close();
        conn.close();

    }
}
