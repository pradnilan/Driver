package com.murata.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.PrintWriter;

@Component
@Aspect
public class ErrorLogAspect {

    /*Logger logger=LoggerFactory.getLogger(ErrorLogAspect.class);

    @AfterThrowing(value="execution (* com.murata..*.*(..))", throwing = "ex")
    public void getExceptions(JoinPoint joinpoint, Exception ex){
        logger.error("Exception Occured!",ex);
    }*/


}
