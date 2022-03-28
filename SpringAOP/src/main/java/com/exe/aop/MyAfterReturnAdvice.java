package com.exe.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterReturnAdvice {

	@AfterReturning("execution(public void com..aop.*.*(..))")
	public void afterReturnMethodCall() {
		
		System.out.print("method ���� �Ŀ� �ߴ� �ڵ�(After return)...");
	//�����Ͱ� �Ϻ��ϰ� ����� ��츸 ��µȴ�(�߰��� ������ ���� �ȳ��´�.)
	}
}
