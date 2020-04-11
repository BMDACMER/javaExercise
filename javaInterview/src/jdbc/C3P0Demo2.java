package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        // 1 获取DataSource，使用默认设置
        DataSource ds = new ComboPooledDataSource();
        // 2 获取链接
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);

            if (i == 5) {
                conn.close();  // 归还连接到连接池中
            }
        }
        System.out.println("\n==============================================\n");
        testNamedConfig();
    }

    public static void testNamedConfig() throws SQLException {
        // 1.1 获取DataSource，使用指定名称配置   默认最大8个
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        // 2 获取连接
        for (int i = 1; i <= 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
        }
    }
}
