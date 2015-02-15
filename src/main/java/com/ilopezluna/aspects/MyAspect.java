package com.ilopezluna.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ignasi on 15/2/15.
 */
@Aspect
@Component
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(MyAspect.class);

    @Pointcut("execution(public * *(..))")
    private void anyPublic() {}

    @Pointcut("within(com.ilopezluna..*)")
    private void inPackage() {}

    @Around("inPackage() && anyPublic()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {

        long start = System.currentTimeMillis();

        Object output = pjp.proceed();

        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Method: " + pjp.getSignature() + " Execution time: " + elapsedTime + " milliseconds.");
        return output;
    }
}
