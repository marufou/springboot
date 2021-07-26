package com.example.dao;

import com.example.entity.User;

public interface UserDao {

//    用户注册
    public void save(User user);
    //根据用户名查询用户
    public User findByUserName(String username);
}
