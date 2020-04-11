package jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1 获取连接
            conn = JDBCUtils.getConnection();
            // 2 定义sql
            String sql = "insert into account value(3,?,?)";
            // 3 获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            // 4 给？赋值
            pstmt.setString(1,"赵六");
            pstmt.setDouble(2,2000);
            // 5 执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6 释放资源
            JDBCUtils.close(pstmt, conn);
        }

    }
}
