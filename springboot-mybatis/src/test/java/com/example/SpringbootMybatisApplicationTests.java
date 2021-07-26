package com.example;

import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisApplicationTests {
    //生命一个日志对象
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        userService.findAll().forEach(user -> System.out.println(user.getName()));
    }

}
