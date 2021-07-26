package com.example.controller;

import com.example.entity.Emp;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//代表类中返回值转为json响应到浏览器
public class EmpController {

    private EmpService empService;
    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }
    //查询所有
    @RequestMapping("/findAll")
    public List<Emp> findAll(){
        return empService.findAll();
    }

    //保存
    @RequestMapping("save")
    public void save(Emp emp){
        empService.save(emp);
    }

}
