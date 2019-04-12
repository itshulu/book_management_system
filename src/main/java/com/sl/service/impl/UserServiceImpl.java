package com.sl.service.impl;

import com.sl.dao.UserDao;
import com.sl.entity.User;
import com.sl.exception.NotFoundUser;
import com.sl.pojo.UserPojo;
import com.sl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @Override
    public String getPasswd(String name) {
        String passwd = userDao.getPasswd(name);
        if (passwd!=null){
            return passwd;
        }
        throw new NotFoundUser("未找到该用户密码", HttpStatus.NOT_FOUND);
    }
    @Override
    public User getUserEntity(String name) {
        User userEntity = userDao.getUserEntity(name);
        if (userEntity!=null){
            return userEntity;
        }
        throw new NotFoundUser("未找到该用户",HttpStatus.NOT_FOUND);
    }
}
