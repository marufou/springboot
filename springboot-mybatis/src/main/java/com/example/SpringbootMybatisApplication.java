package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Mapper注解：修饰范围： 只能在Dao接口上 作用：用来在工厂中创建dao对象 只能创建单个的dao对象
@MapperScan("com.example.dao")//修饰范围： 用在类上作用：用来扫描dao接口所在包同时将所有dao接口在工厂中创建对象
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
