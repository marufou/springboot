package com.example.service;

import com.example.entity.User;

public interface UserService {
    public void register( User user);
    public User login(String username,String password);
}


