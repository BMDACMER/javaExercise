package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        // 1 ��ȡDataSource��ʹ��Ĭ������
        DataSource ds = new ComboPooledDataSource();
        // 2 ��ȡ����
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);

            if (i == 5) {
                conn.close();  // �黹���ӵ����ӳ���
            }
        }
        System.out.println("\n==============================================\n");
        testNamedConfig();
    }

    public static void testNamedConfig() throws SQLException {
        // 1.1 ��ȡDataSource��ʹ��ָ����������   Ĭ�����8��
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        // 2 ��ȡ����
        for (int i = 1; i <= 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
        }
    }
}
