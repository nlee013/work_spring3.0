package com.exe.springwebview;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class CustomDownloadView extends AbstractView{

	//���� �⺻���� default view�� abstractView�� Ư���� ��ɾ��� �̰ɷ� ����
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		//response.setContentType("application/unknown"); -� �������� �𸦶� �̷������� ���
		
		//response.addHeader("Content-Dispostion", "attachment;fileName=" + saveFileName);
		response.addHeader("Content-Dispostion", "attachment;fileName=\"3.jpg\"");
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/files/������3.jpg");
		
		//�о��
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));//path�� �ִ� ���� ������ �о��
		
		//��������
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		
		int data;
		
		//���� �� ����~
		while((data = bis.read()) != -1) {
			
			bos.write(data);
		}
		
		bis.close();
		bos.close();
	}

}
