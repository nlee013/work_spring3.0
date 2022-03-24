package com.exe.springdi2;

public class MessageMain {

	public static void main(String[] args) {

		System.out.println("1. 일반적인 객체 생성...");
		
		MessageKr ob1 = new MessageKr();//객체생성
		ob1.sayHello("유인나");//한글
		
		MessageEn ob2 = new MessageEn();
		ob2.sayHello("suzi");
		
		System.out.println("2. 인터페이스 객체 생성...");
		
		Message ms = null;
		
		ms = new MessageEn();
		ms.sayHello("insun");
		
		ms = new MessageKr();
		ms.sayHello("정인선");
		
		//의존성은 약해졌지만 없어지지 않음
		//한개를 다른 한개에서 사용하고 싶을 때 의존성이 존재!
	}

}
