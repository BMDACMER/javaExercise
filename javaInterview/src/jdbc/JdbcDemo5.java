package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行DDL语句
 */
public class JdbcDemo5 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root");
            stmt = conn.createStatement();
            String sql = "create table student (id int, name varchar(20))";  // DROP TABLE student
            int count= stmt.executeUpdate(sql);
            System.out.println(count);
            if (count > 0) {
                System.out.println("建表成功");
            } else {
                System.out.println("建表失败");
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
