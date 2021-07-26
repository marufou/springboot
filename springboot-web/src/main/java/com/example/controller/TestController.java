package com.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello zhangliuliu";
    }

    @RequestMapping(value= "/user",method = RequestMethod.GET)
    public String getUser(){
        return  "GET_USER";
    }
    @RequestMapping(value= "/user",method = RequestMethod.POST)
    public String getUser2(){
        return  "POST_USER";
    }
//    @DeleteMapping("/user")
    @RequestMapping(value= "/user",method = RequestMethod.DELETE)
    public String getUser3(){
        return  "DELETE_USER";
    }
    @RequestMapping(value= "/user",method = RequestMethod.PUT)
//    @PutMapping("/user")
    public String getUser4(){
        return  "PUT_USER";
    }
}
