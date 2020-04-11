package jdbc;

import java.sql.*;

/**
 *  Ö´ÐÐDDLÓï¾ä
 */
public class JdbcDemo6 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3","root","root");
            String sql = "select * from account";
            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);
            res.next();
            int id = res.getInt(1);
            String name = res.getString(2);
            double balance = res.getDouble(3);

            System.out.println(id + "----" + name + "---" + balance);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(res != null){
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
