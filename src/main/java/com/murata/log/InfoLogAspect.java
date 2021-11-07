package com.murata.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InfoLogAspect {

    //TODO aop does not work with static methods, check AspectJ LTW
   /* Logger logger= LoggerFactory.getLogger(InfoLogAspect.class);

    @AfterReturning(value = "execution(* com.murata.utility.PathUtility .*(..))", returning = "list")
    public void infoPathUtility(JoinPoint jp,Object list){

        logger.error("Info log");
        System.out.println("path utility");

    }*/


}
