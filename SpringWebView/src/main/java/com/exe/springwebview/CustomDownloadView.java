package com.exe.springwebview;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class CustomDownloadView extends AbstractView{

	//가장 기본적인 default view가 abstractView로 특별한 기능없고 이걸로 만듦
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		//response.setContentType("application/unknown"); -어떤 형식일지 모를때 이런식으로 사용
		
		//response.addHeader("Content-Dispostion", "attachment;fileName=" + saveFileName);
		response.addHeader("Content-Dispostion", "attachment;fileName=\"3.jpg\"");
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/files/나영님3.jpg");
		
		//읽어내기
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));//path에 있는 것을 서버가 읽어내기
		
		//내보내기
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		
		int data;
		
		//있을 때 까지~
		while((data = bis.read()) != -1) {
			
			bos.write(data);
		}
		
		bis.close();
		bos.close();
	}

}
