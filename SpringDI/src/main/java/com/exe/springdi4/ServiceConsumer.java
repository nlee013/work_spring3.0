package com.exe.springdi4;

import org.springframework.context.support.GenericXmlApplicationContext;


public class ServiceConsumer {

	//app-context.xml에 객체를 생성해야지 초기화 할 수 있음
	
	//interface 이름
	MessageService ms;
	TimeService ts;
	JobService js;
	
	//생성자로 의존성 주입
	//app-context.xml에서 만든 messageService을 따로 빼주는 작업
	public ServiceConsumer(MessageService ms) {
		
		this.ms = ms;//생성자 만듦
	}

	//method로 의존성 주입
	//app-context.xml에서 setTimeService - set 후 T->t로 바꿔서 timeService로 사용
	public void setTimeService(TimeService ts) {
		
		this.ts = ts;
	}
	//method로 의존성 주입
	public void setJobService(JobService js) {
		
		this.js = js;
	}
	
	public void consumerService() {
		
		//읽어냄
		//생성자로 DI 할 때는 아래는 필요없음
		//GenericXmlApplicationContext context = new GenericXmlApplicationContext("app-context.xml");
	
		//interface에 넣어줘야됌
		//생성자로 DI 할 때는 아래는 필요없음
		//MessageService ms = (MessageService) context.getBean("messageService");
	
		String message = ms.getMessage();
		System.out.println(message);
	
		String time = ts.getTimeString();
		System.out.println(time);
		
		js.getJob();
	}

}
