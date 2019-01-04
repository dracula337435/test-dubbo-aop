package org.dracula.test.dubbo.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author dk
 */
@Aspect
@Component
public class AopForDubbo {

    private static Logger logger = LoggerFactory.getLogger(AopForDubbo.class);

//    @Pointcut("@annotation(org.dracula.test.dubbo.aop.aop.ForwardAway)")
    @Pointcut("execution(* *(..))")
    public void hasCertainAnnotation(){}

    @Around("hasCertainAnnotation() && @annotation(forwardAway)")
    public Object forward(ProceedingJoinPoint proceedingJoinPoint, ForwardAway forwardAway) throws Throwable{
        logger.info("注解中带有的信息");
        logger.info(forwardAway.value());
        logger.info("before");
        logger.info("被切函数的情况");
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        logger.info(methodSignature.toString());
        logger.info("被切函数的入参");
        logger.info(proceedingJoinPoint.getArgs()[0].toString());
        Object returnValue = proceedingJoinPoint.proceed();
        logger.info("after");
        return returnValue;
    }

}
