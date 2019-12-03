package com.uestc.miaoshi.aspect;

import com.uestc.miaoshi.controller.PersonController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //声明一个切面
@Component
public class AspectDemo {
    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);
    //定义切点
    @Pointcut("execution(* com.uestc.miaoshi.controller.*.*(..))")
    public void qieru(){

    }

    //在切点前执行以下代码
    @Before("qieru()")
    public void qianzhi(){
        System.out.println("前置通知");
    }
    @After("qieru()")
    public void houzhi(){
        System.out.println("后置通知");
    }
    @AfterReturning("qieru()")
    public void qianzhifanhui(){
        System.out.println("后置返回 ");
    }
    @AfterThrowing("qieru()")
    public void qianzhiYichang(){
        System.out.println("后置异常");
    }
    @Around("qieru()")
    public void huanrao(ProceedingJoinPoint poin) throws Throwable {
        System.out.println("环绕通知"+ logger.getClass().getName());
        poin.proceed();
    }
}

