package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    public void test(){
        mapper.selectList(null).forEach(System.out::println);
    }
    @Test
    void select(){
//        不加任何条件全部查询
//        mapper.selectList(null);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name","小红");
        mapper.selectList(wrapper);
//        多条件查询
        Map<String,Object> map = new HashMap();
        map.put("name","小红");
        map.put("age",3);
        wrapper.allEq(map);
//        年龄判断
//        wrapper.lt("age",2);//小于
//        wrapper.ne("name","小红");//不等于
        wrapper.ge("age",2);//大于等于
//        模糊查询
        //like '%小'
        wrapper.like("name","小");
        //like '小%'
        wrapper.likeRight("name","小");
        //inSQL
        wrapper.inSql("id","select id from  user where id < 10");
        wrapper.inSql("age","select age from user where age > 3");
        //排序
        wrapper.orderByAsc("age");
        wrapper.having("id>8");
        System.out.println(mapper.selectList(wrapper));
        //通过主键查询
        mapper.selectById(7);
        mapper.selectBatchIds(Arrays.asList(7,8,9)).forEach(System.out::println);
        //Map 只能等值查询判断，逻辑判断需要使用Wrapper来处理
        Map<String,Object> map1 = new HashMap();
        map.put("id",7);
        mapper.selectByMap(map1);
        //统计
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.gt("id",1);
        mapper.selectCount(wrapper1);
        //将查询的结果集封装到Map中
        mapper.selectMaps(wrapper1).forEach(System.out::println);
        //分页查询
        Page<User> page = new Page<User>(1,2);
        Page<User> result = mapper.selectPage(page,null);
        System.out.println(result.getSize());
        System.out.println(result.getTotal());
        System.out.println(result.getRecords());

        //结果封装到Map集合
        Page<Map<String,Object>> page1 = new Page(1,2);
        mapper.selectMapsPage(page1,null);
        //所有的Id
        mapper.selectObjs(null);
        //结果集只有一个才能用
        mapper.selectOne(null);

    }
    @Test
    void definitionSql(){
        mapper.ProductList(4);
    }
    @Test
    void save(){
        User user = new User();
        mapper.insert(user);
        System.out.println(user);
    }
    @Test
    void delete(){
//        mapper.deleteById(1);
//        mapper.deleteBatchIds(Arrays.asList(7,8));
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("age",17);
        mapper.delete(wrapper);
        Map<String,Object> map = new HashMap();
        map.put("id",110);
        mapper.deleteByMap(map);
    }

    @Test
    void update(){
        User user = mapper.selectById(7);
        user.setName("yihao");
        mapper.updateById(user);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("age",22);
        mapper.update(user,wrapper);
    }

}