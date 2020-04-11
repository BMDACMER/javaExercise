package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0 的演示
 */
public class C3P0Demo1 {
    public static void main(String[] args) {
        //1  创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 2 获取连接对象
        try {
            Connection conn = ds.getConnection();
            // 3 打印
            // com.mchange.v2.c3p0.impl.NewProxyConnection@4b6995df [wrapping: com.mysql.jdbc.JDBC4Connection@2fc14f68]
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
