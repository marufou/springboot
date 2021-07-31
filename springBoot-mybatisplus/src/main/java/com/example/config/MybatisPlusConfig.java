package com.example.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
/*
Apachee  dubbo 是一款面向高性能，轻量级的开源javaRPC框架，它提供了三大核心能力：面向接口的远程
调用 智能容错和负载均衡、以及服务自动注册和发现
RPC:远程过程调用，它是一种通过网络从远程计算机程序上请求服务，而不需要了解底层网络技术的协议。RPC协议
假定某些传输协议的存在，
RPC采用客户机/服务器模式，
调用服务：1.直接走url的http协议调用 2,同构走dubbo协议接口方法调用
 */
