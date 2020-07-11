package com.imooc.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author:guohao
 * @email 1163753605@qq.com
 * @date: 2020/7/11 15:58
 */
public class JDBCUtilTest {
    @Test
    public void testConnection() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}
