package jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid��ʾ
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        //1.����jar��
        //2.���������ļ�
        //3.���������ļ�
        Properties pro = new Properties();
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        // 4 ��ȡ���ӳض���
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        // 5 ��ȡ����
        Connection conn = ds.getConnection();
        System.out.println(conn);   // com.mysql.jdbc.JDBC4Connection@2be94b0f
    }
}
