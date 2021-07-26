package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) {
        //1.根据用户查询数据库是否存在该用户
        User userDB = userDao.findByUserName(user.getUsername());
        //2.如果存在报错，用户已存在
        if(!ObjectUtils.isEmpty(userDB)) throw new RuntimeException("用户名已存在");
        //进行注册之前给明文加密
        String passwordSecret = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        //3.如果不存在进行注册
        user.setPassword(passwordSecret);
        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        //根据用户查询数据库中是否存在用户名
        User userDB = userDao.findByUserName(username);
        if(ObjectUtils.isEmpty(userDB)) throw new RuntimeException("用户不存在");
        //判断密码是否正确
        String digestPassword = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if(!userDB.getPassword().equals(digestPassword)) throw new RuntimeException("密码错误");
        return userDB;
    }
}
