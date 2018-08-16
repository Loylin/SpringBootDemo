package com.loylin.springbootdemo.dao;

import com.loylin.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User queryUser(@Param("account") String account, @Param("password") String password);
}
