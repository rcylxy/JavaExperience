package cn.itcast.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Classname DruidDemo
 * @Date 2022/6/28 21:09
 * @Created by 李晓阳
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        for (int i = 1; i <= 10; ++i) {
            Connection conn = ds.getConnection();
            System.out.println(conn);
        }


    }
}
