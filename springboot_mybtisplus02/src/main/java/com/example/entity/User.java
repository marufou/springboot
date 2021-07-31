package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {
    @TableId
    //主键
    private Long id;
    //姓名
    private String name;
    @TableField(exist = false)
//    transient 不参与序列化
    //真实姓名
    private String realName;
    //年龄
    private Integer age;
    //邮箱
    private String email;
    //直属上级
    private Long managerId;
    //创建时间
    private LocalDateTime createTime;


}
/*
SSM传统编程模式
接口中写抽象方法
XML或注解写SQL
Service中调用接口
Controller中调用
AR模式


通用Mapper
 */