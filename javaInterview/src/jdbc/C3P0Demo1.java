package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0 ����ʾ
 */
public class C3P0Demo1 {
    public static void main(String[] args) {
        //1  �������ݿ����ӳض���
        DataSource ds = new ComboPooledDataSource();
        // 2 ��ȡ���Ӷ���
        try {
            Connection conn = ds.getConnection();
            // 3 ��ӡ
            // com.mchange.v2.c3p0.impl.NewProxyConnection@4b6995df [wrapping: com.mysql.jdbc.JDBC4Connection@2fc14f68]
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
