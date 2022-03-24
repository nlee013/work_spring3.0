package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageService {

	public void messageService() {
		
		//BeanFactory ����
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");
		
		//bean ��ü ���
		Message ms = (Message) context.getBean("message");//downcast
		//object����ϹǷ� interface�� downcasting
		
		ms.sayHello("�����");
	}
}
