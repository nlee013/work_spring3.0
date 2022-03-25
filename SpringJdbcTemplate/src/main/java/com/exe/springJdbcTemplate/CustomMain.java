package com.exe.springJdbcTemplate;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {

		//app-context.xml���� ���� ��ü�� ���⿡ ������ �������� ���־�ߵȴ�
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");

		//CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		
		//spring�� jdbc�� ����ϴ� dao
		CustomDAO2 dao = (CustomDAO2)context.getBean("customDAO2");
		
		//----------���⼭�� �׳� �����͸� �־ �ٷ� Ȯ�� �� ����
		CustomDTO dto;
		
		//insert
		
		  dto = new CustomDTO();//��ü �����ؼ� ������ ��������
		  
		  dto.setId(333); dto.setName("������"); dto.setAge(30);
		  
		  dao.insertData(dto);
		  
		  System.out.println("insert �Ϸ�.."); 
		 
		
		//select
		/*
		 * List<CustomDTO> lists = dao.getList();
		 * 
		 * //���� dto�� �־ ������ �ٸ��� �� dto1��.
		 * for(CustomDTO dto1 : lists) {
		 * 
		 * System.out.printf("%d %s %d\n", dto1.getId(),dto1.getName(), dto1.getAge());
		 * }
		 * 
		 * System.out.println("select �Ϸ�..");
		 */
		
		//OneSelect
		/*
		 * dto = dao.getReadData(111);
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
		 * dto = new CustomDTO();//��ü ���� dto.setId(111); dto.setName("���μ�");
		 * dto.setAge(28);
		 * 
		 * dao.updateData(dto);
		 * 
		 * System.out.println("update �Ϸ�..");
		 */
		
		//delete
		/*
		 * dao.deleteData(111);
		 * 
		 * System.out.println("delete �Ϸ�..");
		 */
	}

}
