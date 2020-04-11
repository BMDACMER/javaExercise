package jdbc;

import jdk.nashorn.internal.scripts.JD;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 */
public class JdbcDemo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);

            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);

            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);
            //5.执行sql
            pstmt1.executeUpdate();
            // 手动制造异常
            int i = 3/0;

            pstmt2.executeUpdate();
            //提交事务
            conn.commit();

        } catch (Exception e) {
            // 事务回滚
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1, conn);
            JDBCUtils.close(pstmt2,null);
        }
    }

}
