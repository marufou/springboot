package com.example.service;

import com.example.mapper.EmpDao;
import com.example.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmpServiceImp implements EmpService{
    private EmpDao empDao;
    @Autowired
    public EmpServiceImp(EmpDao empDao) {
        this.empDao = empDao;
    }

    @Override
    public void save(Emp emp) {
        empDao.save(emp);
    }

    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }
}
