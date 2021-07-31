package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void insert(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
    @Test
    public void insertTest(){
        User user = new User();

        user.setName("张三");
        user.setAge(31);
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.insert(user);
        System.out.println("影响记录数" + rows);
    }
    //查询名字为王，年龄不小于40或者邮箱不能为空
    // name like '王%' or (age<40 and age>20  and email is not null)
    @Test
    public void selectByWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.likeRight("name","王").and(wq ->  wq.lt("age",40)).or().isNotNull("email");
//        List<User> userList = userMapper.selectList(queryWrapper);
//        queryWrapper.in("age", Arrays.asList(20,21,34,35));

        //查询名字中含有雨并且年龄小于40
//        queryWrapper.select("id","name").like("name","雨").lt("age",40);
        //或者
        queryWrapper.like("name","雨").lt("age",40)
                .select(User.class,info -> info.getColumn().equals("create_time")&&
                !info.getColumn().equals("manager_id"));
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }
    @Test
    public void testCondition(){
        String name = "王";
        String email = "";
        testCondition(name,email);
    }
    private void testCondition(String name,String email){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        if(StringUtils.isNotEmpty(name)){
//            queryWrapper.like("name",name);
//        }
//        if(StringUtils.isNotEmpty(email)){
//            queryWrapper.like("email",email);
//        }
//        queryWrapper.like(StringUtils.isNotEmpty(name),"name",name).like(StringUtils.isNotEmpty(email),"email",email);
        User user = new User();
        user.setName("刘宇红");
        user.setAge(32);
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>(user);
//        queryWrapper1.allEq(,false)第二个参数是不判断为null的值
        List<User> users = userMapper.selectList(queryWrapper1 );

        users.forEach(System.out::println);
    }
    /*
    按照直属上级分组，查询每组的平均 年龄，最大年龄。最少年龄并且支取年龄的总和小于500的组
    select avg(age) avg_age,min(age) min_age,max(age) max_age
    from user
    group by manager_id
    having sum(age) < 500
     */
    @Test
    public void selectByWrapperMaps(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("avg(age) avg_age","min(age) min_age","max(age) max_age")
                .groupBy("manager_id").having("sum(age)<{0}",500);
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void selectLambda(){
//        LambdaQueryWrapper<User> lambda = new QueryWrapper<User>().lambda();
//        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        userLambdaQueryWrapper.like(User::getName,"雨").lt(User::getAge,40);
//        Page<User> page = new Page<>(1, 2);
//        Page<User> userPage = userMapper.selectPage(page, userLambdaQueryWrapper);
//        userMapper.selectMapsPage();
        List<User> users = userMapper.selectAll(userLambdaQueryWrapper);
        users.forEach(System.out::println);
//        System.out.println("总页数"+ userPage.getPages());
//        System.out.println("总记录数"+ userPage.getTotal());
//        List<User> records = userPage.getRecords();
//        records.forEach(System.out::println);
    }
}