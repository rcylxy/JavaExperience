package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Classname DruidDemo2
 * @Date 2022/6/28 21:35
 * @Created by 李晓阳
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO account VALUES(NULL,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "xiaoyanyan");
            stmt.setInt(2, 999999);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt,conn);

        }
    }
}
