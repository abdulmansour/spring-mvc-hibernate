package com.abdulmansour.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //setup logger
    Logger logger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations
    //controller package
    @Pointcut("execution(* com.abdulmansour.controller.*.*(..))")
    private void forControllerPackage() {

    }

    //service package
    @Pointcut("execution(* com.abdulmansour.service.*.*(..))")
    private void forServicePackage() {

    }

    //dao package
    @Pointcut("execution(* com.abdulmansour.dao.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {

    }
    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        //display the method making the advice call
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> @Before: calling method: " + method);

        //get and display the arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg:args) {
            logger.info("=====> argument: " + arg);
        }
    }

    //add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public  void afterReturning(JoinPoint joinPoint, Object result) {
        // display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> @AfterReturning: from method: " + method);

        //display returned data
        logger.info("=====> result: " + result);
    }

}
