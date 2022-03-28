package com.exe.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterAdvice {

	@After("execution(public void com..aop.*.*(..))")
	public void afterMethodCall() {
		
		System.out.println("method 실행 한 후에 뜨는 코딩(AfterAdvice)...");
	}
}
