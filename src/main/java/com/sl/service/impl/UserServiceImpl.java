package com.sl.service.impl;

import com.sl.dao.UserDao;
import com.sl.pojo.UserPojo;
import com.sl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ShuLu
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserPojo getUser(Integer id) {
        return userDao.getUser(id);
    }
}
