package com.example.config;

import ch.qos.logback.core.db.DBHelper;
import com.example.bean.Car;
import com.example.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 配置类中使用@Bean标注在方法上给容器注册组件，默认也是单实例
 * 配置类本身 也是组件
 * 3.proxyBeanMethods:代理bean方法保持组件为单实例true
 * false 模式 Springboot不会检查组件是否已经创建
 * FUll
 * lite
 * 解决组件依赖
 * 4、给容器中自动创建两个类型的组件
 * @Import
 * @ImportResource(.xml)导入 原生 配置文件
 * @ConfigurationProperties
 *
 */
//@Import({User.class, DBHelper.class})
@Configuration() //告訴SpringBoot這是一個配置类 == 配置文件
@EnableConfigurationProperties(Car.class)
//1.开启Car配置绑定 功能
//2.把这个Car组件自动注册到容器
public class Myconfig {
    @Bean("user") //给容器中添加组件，以方法名作为id,返回类型就是组件类型，返回的值，就是组件在容器中的实例
    //可以修改实例名
    public User user01(){
        return new User("zhangsan","45");
    }
//    public void fun() throws IOException {
//        Properties pps = new Properties;
//        pps.load(new FileInputStream("a.properties"));
//        Enumeration<?> enums = pps.propertyNames();//得到配置文件的名字
//        while(enums.hasMoreElements()){
//            String strKey = (String) enums.nextElement();
//            String strValue = pps.getProperty(strKey);
//            System.out.println(strKey + " + " + strValue);
//            //封装到javaBean
////        }
//
//    }
}
