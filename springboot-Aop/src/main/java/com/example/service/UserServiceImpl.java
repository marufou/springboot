package com.example.service;

import com.example.config.MyAdvice;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void save(String name) {
        System.out.println("处理save核心逻辑,调用Dao");
    }

    @Override
    public void delete(Integer id) {
        System.out.println("处理delete核心逻辑,调用Dao");
    }

    @Override
    public void update(String name) {
        System.out.println("处理update核心逻辑,调用Dao");
    }

    @Override
    @MyAdvice
    public String find(String name) {
        System.out.println("处理find核心逻辑,调用Dao");
        return name;
    }
}
