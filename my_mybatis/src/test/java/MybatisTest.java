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
     * Mybatis���Ű���
     */
    /**
    @Test
    public void testInit() {
        try {
            // 1 ��ȡ�����ļ�
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 2 ����SqlSessionFactory ����
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(is);
            // 3 ��ȡSqlSession����
            SqlSession sqlSession = factory.openSession();
            // 4 ʹ��SqlSession����Mapper�Ĵ������
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 5 ʹ�ô������ִ�в�ѯ
            List<User> users = mapper.listAllUsers();
            users.forEach(System.out::println);
            // 6 �ͷ���Դ
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
     *  ����֮ǰִ�У����ڳ�ʼ��
     */
    @Before
    public void init() throws Exception {
        // 1 ��ȡ�����ļ�
        is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2. ����sqlSessionFactory����
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        // 3 ��ȡsqlSession����
        sqlSession = factory.openSession();
        // 4 ʹ��sqlSession����Mapper�Ĵ������
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    // ���Խ���ִ�У������ύ������ͷ���Դ
    @After
    public void destory() throws Exception {
        // 6 �ύ����
        sqlSession.commit();
        // 7 �ͷ���Դ
        sqlSession.close();
        is.close();
    }

    /**
     * ��������û�
     */
    @Test
    public void testSaverUser() {
        User user = new User();
        user.setUsername("�㿪��");
        user.setBirthday(new Date());
        user.setSex("��");
        user.setAddress("�㶫");

        // ����Mapper������
        int count = mapper.saveUser(user);
        System.out.println("�������Ϊ��" + count);
    }

    /**
     * ����ɾ���û�
     */
    @Test
    public void testremoveUserById() {
        int count = mapper.removeUserById(51);
        System.out.println("ɾ������Ϊ��" + count);
    }

    /**
     * �����޸��û�
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUsername("update2");
//        user.setAddress("testUpdate");
        user.setSex("Ů");
        user.setBirthday(new Date());
        // idΪ�Լ����ݿ��д��ڵ�ֵ
        user.setId(41);

        // ִ���޸�
        int count = mapper.updateUser(user);
        System.out.println("�޸�����Ϊ �� " + count);
    }

    /**
     * ���Բ�ѯ�����û�
     */
    @Test
    public void testGetUserById() {
        // ȷ��id���ڣ����򷵻�null
        User user = mapper.getUserById(48);
        System.out.println(user);
    }

    /**
     * ����ģ����ѯ
     */
    @Test
    public void testListUsersByName() {
        List<User> users = mapper.listUsersByName("%��%");
        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testCountUser() {
        int countUser = mapper.countUser();
        System.out.println("�û��ܼ�¼��Ϊ��" + countUser);
    }

    /**
     * ��������û�������ȡ id �ķ���ֵ
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("�㿪��");
        user.setBirthday(new Date());
        user.setSex("��");
        user.setAddress("�㶫");

        System.out.println("���ǰ �� " + user);

        // ����mapper������
        int count = mapper.saveUser(user);
        System.out.println("�������Ϊ : " + count);

        System.out.println("��Ӻ� �� " + user);
    }

}
