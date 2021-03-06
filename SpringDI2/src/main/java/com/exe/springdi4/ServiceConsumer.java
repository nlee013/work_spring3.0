package com.exe.springdi4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//annotation 쓰는 방법
@Component ("serviceConsumer")//->bean 객체 생성과 같음
public class ServiceConsumer {

	//app-context.xml에 객체를 생성해야지 초기화 할 수 있음
	
	@Autowired//알아서 실행
	@Qualifier("messageService")//이름 충돌 방지용
	MessageService ms;
	
	@Autowired
	TimeService ts;
	
	@Autowired
	JobService js;
	
	public void consumerService() {
	
		String message = ms.getMessage();
		System.out.println(message);
	
		String time = ts.getTimeString();
		System.out.println(time);
		
		js.getJob();
	}

}
