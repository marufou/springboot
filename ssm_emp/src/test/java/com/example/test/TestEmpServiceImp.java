package com.example.test;

import com.example.entity.Emp;
import com.example.service.EmpService;
import com.example.service.EmpServiceImp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestEmpServiceImp {
    public static void main(String[] args) {
        //1.运行工厂
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring.xml");
        //2.得到bean
        EmpService empService = (EmpService) application.getBean("empServiceImp");
        //调用服务
        empService.save(new Emp(null,"小陈",new Date(),23.23));
        empService.findAll().forEach(emp -> System.out.println(emp));
    }
}
