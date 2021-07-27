package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.ProductVo;
import com.example.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("select p.* ,u.name from product p,user u where product p.user_id = u.id and u.id = #{id}")
    List<ProductVo> ProductList(Integer id);
}
