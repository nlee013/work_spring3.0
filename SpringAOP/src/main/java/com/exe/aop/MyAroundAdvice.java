package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAdvice {

	//�������ڸ��� ~ �����ڸ��� 
	@Around("execution(public void com..aop.*.*(..))")
	public Object aroundMethodCall(ProceedingJoinPoint jointPoint) {
		
		Object result = null;
		
		try {
			
			System.out.println("method ������(AroundAdvice)...");
			
			result = jointPoint.proceed();
			
			System.out.println("method ���� ��(AroundAdvice)...");
			
		} catch (Throwable e) {
			// TODO: handle exception
		}	
		
		return result;
	}
}
