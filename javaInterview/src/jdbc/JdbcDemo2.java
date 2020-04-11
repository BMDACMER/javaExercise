package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���һ����¼
 */
public class JdbcDemo2 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;

        try {
            // 1 ע������
            Class.forName("com.mysql.jdbc.Driver");
            // 2 ����sql
            String sql = "insert into account values(null, '����', 3000)";
            // 3 ��ȡConnection����
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root");
            // 4 ��ȡִ��sql�Ķ���Statement
            stmt = conn.createStatement();
            // 5 ִ��sql
            int count = stmt.executeUpdate(sql);
            // 6 ������
            System.out.println(count);
            if (count > 0) {
                System.out.println("��ӳɹ�");
            } else {
                System.out.println("���ʧ��");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
