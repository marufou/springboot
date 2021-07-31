package com.example;

import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybtisplus02ApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
//        userService.getOne(Wrappers<User>.lambdaQuery().gt(User::getAge,25));
    }

}
