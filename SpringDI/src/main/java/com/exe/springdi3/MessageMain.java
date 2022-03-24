package com.exe.springdi3;

public class MessageMain {

	public static void main(String[] args) {//main절(console)이니까

		MessageService ms = new MessageService();
		
		ms.messageService();//호출
	}

}
