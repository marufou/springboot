package com.example;

import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        userService.save("123");
    }
    @Test void testFind(){
        String name = userService.find("zhangsna");
        System.out.println(name);
    }
}
