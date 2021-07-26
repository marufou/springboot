package com.example.service;

import com.example.entity.Emp;

import java.util.List;

public interface EmpService {
    void save(Emp emp);

    List<Emp> findAll();
}
