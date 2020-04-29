package cn.gh.mapper;

import cn.gh.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 查询所有用户
     */
//    @Select("SELECT * FROM user")   // 使用的注解方式
    List<User> listAllUsers();

    /**
     * 添加用户
     * @param user
     * @return  成功返回1，失败返回0
     */
    int saveUser(User user);

    /**
     * 根据id删除用户
     * @param userId
     * @return 成功返回1 失败返回0
     */
    int removeUserById(Integer userId);

    /**
     * 修改用户
     * @param user
     * @return 成功返回1 失败返回0
     */
    int updateUser(User user);

    /**
     * 根据id查询单个用户
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * 根据姓名模糊查询多个用户
     * @param username
     * @return
     */
    List<User> listUsersByName(String username);

    /**
     * 查询用户总数
     * @return
     */
    int countUser();
}
