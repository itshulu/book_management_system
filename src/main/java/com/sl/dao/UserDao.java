package com.sl.dao;

import com.sl.entity.User;
import com.sl.pojo.UserPojo;

/**
 * @author ShuLu
 */
public interface UserDao {
    UserPojo getUser(Integer id);
    /**
     * 根据用户名获取密码
     *
     * @param username 用户名
     * @return 密码
     */
    String getPasswd(String username);
    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User getUserEntity(String username);

    /**
     * 添加用户 默认是添加普通用户
     * @param user
     */
    void saveUser(User user);
}
