package com.exe.springdi4;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageService")
@Scope(value = "prototype")//constructor을 쓰지 않아도 자동으로 읽어옴
public class MyMessageService implements MessageService{

	public String getMessage() {
		
		return "안녕, 반가워~~";
	}

}
