package com.exe.springdi4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//annotation ���� ���
@Component ("serviceConsumer")//->bean ��ü ������ ����
public class ServiceConsumer {

	//app-context.xml�� ��ü�� �����ؾ��� �ʱ�ȭ �� �� ����
	
	@Autowired//�˾Ƽ� ����
	@Qualifier("messageService")//�̸� �浹 ������
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
