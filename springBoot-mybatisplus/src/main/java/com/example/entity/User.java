package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="user")
public class User {
    @TableId()
    private Integer id;
    private String name;
    private Integer age;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
    @TableLogic
    private Integer delete;

}

/*
1.常用注解
@TableId 设置主键映射，value映射主键字段名，type设置主键类型，主键的生成策略
AUTO(0)数据库自增  NONE(1)Mapset主键，雪花算法实现
INPUT (2)需要开发者手动赋值 否则默认自增
ASSIGN_ID(3)MP分配ID ASSIGN_UUID(4)分配UUID 要求主键为String类型
2.TableFiled(value="")映射非主键字段，value映射字段名
TableField(exist  = false);
3.exist 表示是否数据库字段false,如果实体类中成员变量在数据库中没有对应的字段
select = false;表示是否查询该字段
fill 表示是否自动填充，将对象存入数据库中的时候，由mybatisplus 自动给某些字段赋值 create
time update_time
TableFiled(fill = FiledFill.INSERT)
创建自动处理器

@Version
标记乐观锁,通过version字段 来保证数据的安全性，当修改数据时候会以version作为条件，当条件成立的时候才会修改
version = 1
update.... set version = 2 where version = 1;
1。给数据库表添加version字段
2.
3.写一个配置类

@EnumValue
通用枚举类注解，将数据库字段映射成实体类的枚举类型成员变量

@TableLogic
映射逻辑删除
1,数据表添加delete字段
2、实体类添加注解
3.application.yml中添加配置

查询

添加
删除
修改
自定义SQL、多表关联
MybatisPlus自动生成
根据数据表自动生成实体类、Mapper、service、ServiceImpl、Controller
1.pom.xml导入依赖 MybatisPlusGenerator

SpringBoot + Mybatis PLus打包应用，直接布阿里云

 */