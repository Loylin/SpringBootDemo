package com.loylin.springbootdemo.service;

import com.loylin.springbootdemo.dao.UserDao;
import com.loylin.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User queryLogin(String account, String password){
        return userDao.queryUser(account, password);
    }
}
