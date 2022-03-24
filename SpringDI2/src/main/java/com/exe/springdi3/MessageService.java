package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageService {

	public void messageService() {
		
		//BeanFactory 생성
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");
		
		//bean 객체 사용
		Message ms = (Message) context.getBean("message");//downcast
		//object사용하므로 interface로 downcasting
		
		ms.sayHello("배수지");
	}
}
