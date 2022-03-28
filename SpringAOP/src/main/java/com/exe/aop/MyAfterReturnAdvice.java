package com.exe.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterReturnAdvice {

	@AfterReturning("execution(public void com..aop.*.*(..))")
	public void afterReturnMethodCall() {
		
		System.out.print("method 실행 후에 뜨는 코딩(After return)...");
	//데이터가 완벽하게 실행된 경우만 출력된다(중간에 오류가 나면 안나온다.)
	}
}
