package com.sl.dao;

import com.sl.pojo.UserPojo;

/**
 * @author ShuLu
 */
public interface UserDao {
    UserPojo getUser(Integer id);
}
