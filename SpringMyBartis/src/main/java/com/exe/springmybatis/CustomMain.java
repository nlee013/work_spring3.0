package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {

		//app-context.xml에서 만든 객체를 여기에 의존성 주입으로 해주어야된다
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");

		CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		
		
		//----------여기서는 그냥 데이터만 넣어서 바로 확인 할 예정
		CustomDTO dto;
		
		//insert
		/*
		 * dto = new CustomDTO();//객체 생성해서 데이터 넣을예정
		 * 
		 * dto.setId(444); dto.setName("바티스"); dto.setAge(33);
		 * 
		 * dao.insertData(dto);
		 * 
		 * System.out.println("insert 완료..");
		 */
		
		//select
		/*
		 * List<CustomDTO> lists = dao.getList();
		 * 
		 * for(CustomDTO dto1 : lists) {
		 * 
		 * System.out.printf("%d %s %d\n", dto1.getId(),dto1.getName(), dto1.getAge());
		 * }
		 * 
		 * System.out.println("select 완료..");
		 */
		
		//OneSelect
		/*
		 * dto = dao.getReadData(444);
		 * 
		 * if(dto != null) {
		 * 
		 * System.out.printf("%d %s %d\n", dto.getId(),dto.getName(), dto.getAge());
		 * 
		 * }
		 * 
		 * System.out.println("OneSelect 완료..");
		 */
		
		//update
		/*
		 * dto = new CustomDTO();//객체 생성
		 * 
		 * dto.setId(444); dto.setName("뉴뉴뉴"); dto.setAge(26);
		 * 
		 * dao.updateData(dto);
		 * 
		 * System.out.println("update 완료..");
		 */
		
		//delete
		
		  dao.deleteData(111);
		  
		  System.out.println("delete 완료..");
		 
	}

}
