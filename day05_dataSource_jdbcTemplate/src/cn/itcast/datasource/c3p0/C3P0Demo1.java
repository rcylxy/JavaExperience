package cn.itcast.datasource.c3p0;


import javax.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * C3P0数据库连接池的演示
 * @Classname C3P0Demo1
 * @Date 2022/6/28 20:17
 * @Created by 李晓阳
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        // 创建数据库连接池对象
        DataSource ds=new ComboPooledDataSource();
        // 获取拦截对象
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }



}
