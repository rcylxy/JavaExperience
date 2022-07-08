package cn.itcast.jdbc;

import cn.itcast.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname JdbcDemo6
 * @Date 2022/6/28 11:34
 * @Created by 李晓阳
 */
public class JdbcDemo6 {
    public List<Emp> fidAll() {
        List<Emp> res = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet ret = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.56.10:3306/db1", "root", "root");
            String sql = "select * from emp";
            stmt = conn.createStatement();
            ret = stmt.executeQuery(sql);
            Emp temp = null;
            while (ret.next()) {
                int id = ret.getInt("id");
                String name = ret.getString("name");
                String gender = ret.getString("gender");
                double salary = ret.getDouble("salary");
                Date join_date = ret.getDate("join_date");
                int dept_id = ret.getInt("dept_id");
                temp = new Emp(id, name, gender, salary, join_date, dept_id);
                res.add(temp);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ret != null) {
                    ret.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int index = 0;
        JdbcDemo6 test = new JdbcDemo6();
        List<Emp> res;
        res = test.fidAll();
        while (index < res.size()) {
            System.out.println(res.get(index));
            index++;
        }
    }
}
