package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname JdbcDemo7
 * @Date 2022/6/28 15:12
 * @Created by 李晓阳
 */
public class JdbcDemo7 {
    public List<Emp> findAll() {
        List<Emp> res = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet ret = null;
        try {
            conn = JDBCUtils.getConnection();
            final String sql = "select * from emp";
            assert conn != null;
            stmt = conn.createStatement();
            if (stmt != null)
                ret = stmt.executeQuery(sql);
            Emp temp;
            while (true) {
                assert ret != null;
                if (!ret.next()) break;
                int id = ret.getInt("id");
                String name = ret.getString("name");
                String gender = ret.getString("gender");
                double salary = ret.getDouble("salary");
                Date join_date = ret.getDate("join_date");
                int dept_id = ret.getInt("dept_id");
                temp = new Emp(id, name, gender, salary, join_date, dept_id);
                res.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn, ret);
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.next();
        int index = 0;
        JdbcDemo7 test = new JdbcDemo7();
        List<Emp> res;
        res = test.findAll();
        while (index < res.size()) {
            System.out.println(res.get(index));
            index++;
        }
    }
}
