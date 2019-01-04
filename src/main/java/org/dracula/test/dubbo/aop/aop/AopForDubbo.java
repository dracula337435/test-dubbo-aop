package org.dracula.test.dubbo.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author dk
 */
@Aspect
@Component
public class AopForDubbo {

    @Pointcut("execution(* org.dracula.test.dubbo.aop.provider..*(..))")
    public void hasCertainAnnotation(){}

    @Around("hasCertainAnnotation()")
    public Object forward(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("before");
        Object returnValue = proceedingJoinPoint.proceed();
        System.out.println("after");
        return returnValue;
    }

}
