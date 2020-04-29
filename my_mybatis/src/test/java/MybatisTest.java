import cn.gh.mapper.UserMapper;
import cn.gh.pojo.User;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    /**
     * Mybatis入门案例
     */
    /**
    @Test
    public void testInit() {
        try {
            // 1 读取配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 2 创建SqlSessionFactory 工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            // 3 获取SqlSession对象
            SqlSession sqlSession = factory.openSession();
            // 4 使用SqlSession创建Mapper的代理对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 5 使用代理对象执行查询
            List<User> users = mapper.listAllUsers();
            users.forEach(System.out::println);
            // 6 释放资源
            sqlSession.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    private InputStream is;
    private SqlSession sqlSession;
    private UserMapper mapper;

    /**
     *  测试之前执行，用于初始化
     */
    @Before
    public void init() throws Exception {
        // 1 读取配置文件
        is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2. 创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        // 3 获取sqlSession对象
        sqlSession = factory.openSession();
        // 4 使用sqlSession创建Mapper的代理对象
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    // 测试结束执行，用于提交事务和释放资源
    @After
    public void destory() throws Exception {
        // 6 提交事务
        sqlSession.commit();
        // 7 释放资源
        sqlSession.close();
        is.close();
    }

    /**
     * 测试添加用户
     */
    @Test
    public void testSaverUser() {
        User user = new User();
        user.setUsername("鱼开饭");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("广东");

        // 调用Mapper完成添加
        int count = mapper.saveUser(user);
        System.out.println("添加条数为：" + count);
    }

    /**
     * 测试删除用户
     */
    @Test
    public void testremoveUserById() {
        int count = mapper.removeUserById(51);
        System.out.println("删除条数为：" + count);
    }

    /**
     * 测试修改用户
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUsername("update2");
//        user.setAddress("testUpdate");
        user.setSex("女");
        user.setBirthday(new Date());
        // id为自己数据库中存在的值
        user.setId(41);

        // 执行修改
        int count = mapper.updateUser(user);
        System.out.println("修改条数为 ： " + count);
    }

    /**
     * 测试查询单个用户
     */
    @Test
    public void testGetUserById() {
        // 确保id存在，否则返回null
        User user = mapper.getUserById(48);
        System.out.println(user);
    }

    /**
     * 测试模糊查询
     */
    @Test
    public void testListUsersByName() {
        List<User> users = mapper.listUsersByName("%王%");
        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testCountUser() {
        int countUser = mapper.countUser();
        System.out.println("用户总记录数为：" + countUser);
    }

    /**
     * 测试添加用户，并获取 id 的返回值
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("鱼开饭");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("广东");

        System.out.println("添加前 ： " + user);

        // 调用mapper完成添加
        int count = mapper.saveUser(user);
        System.out.println("添加条数为 : " + count);

        System.out.println("添加后 ： " + user);
    }

}
