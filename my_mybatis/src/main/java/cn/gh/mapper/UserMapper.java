package cn.gh.mapper;

import cn.gh.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * ��ѯ�����û�
     */
//    @Select("SELECT * FROM user")   // ʹ�õ�ע�ⷽʽ
    List<User> listAllUsers();

    /**
     * ����û�
     * @param user
     * @return  �ɹ�����1��ʧ�ܷ���0
     */
    int saveUser(User user);

    /**
     * ����idɾ���û�
     * @param userId
     * @return �ɹ�����1 ʧ�ܷ���0
     */
    int removeUserById(Integer userId);

    /**
     * �޸��û�
     * @param user
     * @return �ɹ�����1 ʧ�ܷ���0
     */
    int updateUser(User user);

    /**
     * ����id��ѯ�����û�
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * ��������ģ����ѯ����û�
     * @param username
     * @return
     */
    List<User> listUsersByName(String username);

    /**
     * ��ѯ�û�����
     * @return
     */
    int countUser();
}
