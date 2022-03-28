package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAdvice {

	//시작하자마자 ~ 끝나자마자 
	@Around("execution(public void com..aop.*.*(..))")
	public Object aroundMethodCall(ProceedingJoinPoint jointPoint) {
		
		Object result = null;
		
		try {
			
			System.out.println("method 실행전(AroundAdvice)...");
			
			result = jointPoint.proceed();
			
			System.out.println("method 실행 후(AroundAdvice)...");
			
		} catch (Throwable e) {
			// TODO: handle exception
		}	
		
		return result;
	}
}
