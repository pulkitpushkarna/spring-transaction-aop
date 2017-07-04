package com.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    @Before("displayAdvice()")
    void displayInvoked(JoinPoint joinPoint){
        System.out.println(joinPoint.getThis());
        System.out.println("display  invoked for ::"+joinPoint.getSignature());
    }

    @Pointcut("execution(void display())")
    void displayAdvice(){}
//
//    @After("execution(void display())")
//    void displayAfterInvoked(){
//        System.out.println("display after invoked");
//    }

//    @AfterReturning(pointcut = "execution(* display())",returning = "returnValue")
//    void afterReturning(Integer returnValue){
//        System.out.println("return value "+returnValue);
//    }

//    @AfterThrowing(pointcut = "execution(void display())",throwing = "ex")
//    void afterThrowing(Exception ex){
//        System.out.println("Exception raised "+ ex);
//    }

//    @Around("execution(void display())")
//    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        System.out.println("Before");
//            proceedingJoinPoint.proceed();
//        System.out.println("After");
//    }

}
