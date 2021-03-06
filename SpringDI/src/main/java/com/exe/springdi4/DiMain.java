package com.exe.springdi4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DiMain {

	public static void main(String[] args) {

		//객체 생성 후 method 호출하면 됌
		/*
		 ServiceConsumer sc = new ServiceConsumer();
		 sc.consumerService();
	    */
		 GenericXmlApplicationContext context =
				 new GenericXmlApplicationContext("app-context.xml");
		 
		 ServiceConsumer sc = (ServiceConsumer) context.getBean("serviceConsumer");
		 sc.consumerService();
	}

}
