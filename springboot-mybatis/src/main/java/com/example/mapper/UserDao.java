package com.example.mapper;

import com.example.entity.User;

import java.util.List;

public interface UserDao {

    //查询所有
    List<User> findAll();
    //添加用户
    public void save(User user);
}
