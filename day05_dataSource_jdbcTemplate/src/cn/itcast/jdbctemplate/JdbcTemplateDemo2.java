package cn.itcast.jdbctemplate;

import cn.itcast.domain.Emp;
import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.testng.annotations.Test;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Classname JdbcTemplateDemo2
 * @Date 2022/6/28 22:21
 * @Created by 李晓阳
 */
public class JdbcTemplateDemo2 {
    //Junit单元测试



    @Test
    public void test1() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update emp set salary = 1000";
        template.update(sql);
    }

    @Test
    public void test2() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);

    }

    @Test
    public void test3() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);

    }

    @Test
    public void test4() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from emp";
        List<Emp> query = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                double salary = rs.getDouble("salary");
                Date join_date = rs.getDate("join_date");
                int dept_id = rs.getInt("dept_id");
                return new Emp(id, name, gender, salary, join_date, dept_id);
            }
        });
        System.out.println(query);
    }

    @Test
    public void test5(){

    }
}
