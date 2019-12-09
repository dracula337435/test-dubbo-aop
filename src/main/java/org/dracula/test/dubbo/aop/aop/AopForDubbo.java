package org.dracula.test.dubbo.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author dk
 */
@Aspect
@Component
public class AopForDubbo {

    private static Logger logger = LoggerFactory.getLogger(AopForDubbo.class);

    @Pointcut("execution(* *(..))")
    public void allMethods(){}

    @Around("allMethods() && @annotation(forwardAway)")
    public Object forward(ProceedingJoinPoint proceedingJoinPoint, ForwardAway forwardAway) throws Throwable{
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        logger.debug("被切函数为："+methodSignature.toString());
        String forwardUrl = getUrl(forwardAway, methodSignature);
        Object[] args = proceedingJoinPoint.getArgs();
        if(args != null && args.length>0){
            Object firstParam = args[0];
            logger.debug("有参数，第1个参数为："+firstParam);
            try {
                Method getIdMethod = firstParam.getClass().getDeclaredMethod("getId");
                Object id = getIdMethod.invoke(firstParam);
                logger.debug(id.toString());
                //
                int convertedId = (int)id;
                if(convertedId < 100){
                    logger.debug("根据id="+convertedId+"<100, 调用此");
                    return proceedingJoinPoint.proceed();
                }else{
                    logger.debug("根据id="+convertedId+">=100, 去远方");
                    return "调用"+forwardUrl+"的结果";
                }
            } catch (NoSuchMethodException e) {
                logger.error("", e);
            } catch (SecurityException e) {
                logger.error("", e);
            }
        }else{
            logger.debug("无参数");
        }
        return proceedingJoinPoint.proceed();
    }

    private String getUrl(ForwardAway forwardAway, MethodSignature methodSignature){
        String forwardUrl = forwardAway.value();
        if(forwardUrl != null && !forwardUrl.isEmpty()){
            logger.debug("注解中带有目标url，使用此url："+forwardUrl);
        }else{
            forwardUrl = "/"+methodSignature.getMethod().getDeclaringClass().getCanonicalName()+"/"+methodSignature.getName();
            logger.debug("注解中带无目标url，使用默认url："+forwardUrl);
        }
        return forwardUrl;
    }

}
