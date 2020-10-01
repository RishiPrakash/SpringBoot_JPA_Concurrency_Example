package com.freecharge.dc.aspect;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MetriceLoggingAspect {

	@Pointcut("within(com.freecharge.dc.repository.*)" +
	        " || within(com.freecharge.dc.service.*)" +
	        " || within(com.freecharge.dc.controller.*)")
	    public void springBeanPointcut() {}
	
	@Around("springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Enter: "+ joinPoint.getSignature().getDeclaringTypeName()+ "."+ joinPoint.getSignature().getName() +"() with argument[s] = "+
                 Arrays.toString(joinPoint.getArgs()));
		long startTime = System.nanoTime();

        try {
            Object result = joinPoint.proceed();
            long stopTime = System.nanoTime();
                System.out.println("Exit: "+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"() with result = "+result);
                System.err.println("Time taken: "+(stopTime - startTime) +" which is in MILLISECONDS ="+TimeUnit.MILLISECONDS.convert((stopTime - startTime), TimeUnit.NANOSECONDS));
            return result;
        } catch (IllegalArgumentException e) {
        	throw e;
        }
    }
	
}
