package cn.itcast.jdbctemplate;

import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Classname JdbcTemplateDemo1
 * @Date 2022/6/28 21:54
 * @Created by 李晓阳
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update account set balance = 5000 where id = ?";
        int ret = template.update(sql, 1);
        System.out.println(ret);
    }
}
