package com.imooc.luckmoney.aspect;

import jakarta.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;


@Slf4j
@Aspect
@Component
public class GirlHttpAspect {
    @Pointcut("execution(public * com.imooc.luckmoney.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("方法执行前");

        ServletRequestAttributes attributes = (ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        log.info("url={}", request.getRequestURL());

        //method
        log.info("method={}", request.getMethod());

        //ip
        log.info("ip={}", request.getRemoteAddr());

        //类方法
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        log.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        log.info("方法执行后");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("response={}", object);
    }
}
