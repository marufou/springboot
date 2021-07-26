package com.example.controller;

import com.example.bean.Car;
import com.example.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@Slf4j
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public  String handle01(){
        return  "Hello ,Spring Boot  2!";
    }
    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car(){
        log.info("请求进来了");
        return car;
    }
    @Autowired
    Person person;
    @RequestMapping("/person")
    public Person person(){
        return person;
    }
}
