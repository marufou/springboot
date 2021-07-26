package com.example.dao;

import com.example.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmpDao {
    //保存用户
    void save(Emp emp);
    //查询所有
    List<Emp> findAll();
}
