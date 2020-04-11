package jdbc;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account�� ɾ��һ����¼
 */
public class JdbcDemo4 {
   public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver" );
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root");
            stmt = conn.createStatement();
            String sql = "delete from account where id = 3";
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if (count > 0) {
                System.out.println("ɾ���ɹ�");
            } else {
                System.out.println("ɾ��ʧ��");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
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
