package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Classname JdbcDemo2
 * @Date 2022/6/27 14:56
 * @Created by 李晓阳
 * 标准写法
 */
public class JdbcDemo2 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "INSERT INTO emp VALUES(NULL,'lixiaoyan','男',100,NULL,1)";
            conn = DriverManager.getConnection("jdbc:mysql://192.168.56.10:3306/db1", "root", "root");
            stmt = conn.createStatement();
            int ret = stmt.executeUpdate(sql);

            System.out.println(ret);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
