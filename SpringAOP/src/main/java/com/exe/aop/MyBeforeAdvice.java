package com.exe.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyBeforeAdvice {

	@Before("execution(public void com..aop.*.*(..))")
	public void beforeMethodCall() {
		
		System.out.println("method 실행 하기 전에 뜨는 코딩(BeforeAdvice)...");
	}
}
