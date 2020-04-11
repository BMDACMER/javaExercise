package jdbc;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ʹ���µĹ�����
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1 ��ȡ����
            conn = JDBCUtils.getConnection();
            // 2 ����sql
            String sql = "insert into account value(3,?,?)";
            // 3 ��ȡpstmt����
            pstmt = conn.prepareStatement(sql);
            // 4 ������ֵ
            pstmt.setString(1,"����");
            pstmt.setDouble(2,2000);
            // 5 ִ��sql
            int count = pstmt.executeUpdate();
            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6 �ͷ���Դ
            JDBCUtils.close(pstmt, conn);
        }

    }
}
