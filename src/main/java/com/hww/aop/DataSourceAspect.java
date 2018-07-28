package com.hww.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class DataSourceAspect {

    @Before("execution(* com.hww.aop..*(..))&&@annotation(dataSource)")
    public void before(DataSource dataSource) {
        System.out.println(new Date() + dataSource.value());
    }
}
