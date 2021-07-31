package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义切面
 */
/*
切入点表达式: execution  方法级别切入点表达式 运行效率低 within：类级别切入点：控制越粗 运行效率越高
@Around("within(com.example.service.*)")
@Around("execution(* com.example.service.*.*(..)")
基于注解的切入点表达式 @annotation(com.example.annotation.xxx)
 */
@Configuration //代表当前这个类值一个spring的配置类
@Aspect // 代表这个这个类是一个切面配置类
public class MyAspectConfig {
//    // 切面Aspect = Advice 附加操作 + Pointcut切入点
    @Before("execution(* com.example.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("=======前置附加操作========");
        System.out.println("当前执行类目标类" + joinPoint.getTarget());
        System.out.println("当前执行目标类中方法：" + joinPoint.getSignature().getName());
    }
//
    @After("@annotation(com.example.config.MyAdvice)")
    public void after(){
        System.out.println("========后置操作==========");
    }
    @Around("(execution(* com.example.service.*.*(..)))")
    //返回值作用： 用来讲业务方法返回给调用者
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("========进入环绕的前置操作======");
        System.out.println("当前执行类" + proceedingJoinPoint.getTarget());
        System.out.println( "方法名"+ proceedingJoinPoint.getSignature().getName());
        //放行目标方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("=======进入环绕后置的操作========");
        return proceed;

    }
}
