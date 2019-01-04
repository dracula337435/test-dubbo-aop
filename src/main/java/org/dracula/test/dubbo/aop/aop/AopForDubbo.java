package org.dracula.test.dubbo.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("@annotation(org.dracula.test.dubbo.aop.aop.ForwardAway)")
    public void hasCertainAnnotation(){}

    @Around("hasCertainAnnotation()")
    public Object forward(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        logger.info("before");
        logger.info("被切函数的情况");
        logger.info(proceedingJoinPoint.getSignature().getName());
        logger.info("被切函数的入参");
        logger.info(proceedingJoinPoint.getArgs()[0].toString());
        Object returnValue = proceedingJoinPoint.proceed();
        logger.info("after");
        return returnValue;
    }

}
