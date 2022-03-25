package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {

		//app-context.xml���� ���� ��ü�� ���⿡ ������ �������� ���־�ߵȴ�
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");

		CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		
		
		//----------���⼭�� �׳� �����͸� �־ �ٷ� Ȯ�� �� ����
		CustomDTO dto;
		
		//insert
		/*
		 * dto = new CustomDTO();//��ü �����ؼ� ������ ��������
		 * 
		 * dto.setId(444); dto.setName("��Ƽ��"); dto.setAge(33);
		 * 
		 * dao.insertData(dto);
		 * 
		 * System.out.println("insert �Ϸ�..");
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
		 * System.out.println("select �Ϸ�..");
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
		 * System.out.println("OneSelect �Ϸ�..");
		 */
		
		//update
		/*
		 * dto = new CustomDTO();//��ü ����
		 * 
		 * dto.setId(444); dto.setName("������"); dto.setAge(26);
		 * 
		 * dao.updateData(dto);
		 * 
		 * System.out.println("update �Ϸ�..");
		 */
		
		//delete
		
		  dao.deleteData(111);
		  
		  System.out.println("delete �Ϸ�..");
		 
	}

}
