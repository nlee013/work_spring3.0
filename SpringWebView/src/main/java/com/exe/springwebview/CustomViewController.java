package com.exe.springwebview;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomViewController {

	@RequestMapping(value = "/simpleCustomView.action")
	public ModelAndView customView() {
		
		ModelAndView mav = new ModelAndView();
		
		//.jsp���Ϸ� ����
		//mav.setViewName("simpleCustomView");
		
		//Class(.java)�� data�� �ѱ�
		mav.setView(new SimpleCustomView());//class�̸� �ֱ� + ��ü ����
		mav.addObject("message", "SimpleCustomView Class �Դϴ�.");
		
		return mav;
	}
	
	@RequestMapping(value = "/pdfView.action")
	public ModelAndView getPdfView() {
		
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("pdfView");
		
		mav.setView(new CustomPdfView());
		mav.addObject("message", "pdfView Class �Դϴ�.");
		
		return mav;
	}
	
	@RequestMapping(value = "/excelView.action")
	public ModelAndView getExcelView() {
		
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("excelView");
		
		mav.setView(new CustomExcelView());
		mav.addObject("message", "excelView Class �Դϴ�.");
				
		return mav;
	}
	
	@RequestMapping(value = "/uploadView.action", method = {RequestMethod.POST, RequestMethod.GET})
	public String getUploadView(MultipartHttpServletRequest request, String str) throws Exception {
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/files");//���� ���
		
		//WEB_INF�� �ܺο��� ���� ���� �����̹Ƿ�
		//�̹����� ���� ���� (�Ϲ������� Ȩ�������� ������� �̹����� ����)
		//����(�� ���α׷�) webapp ���� �Ʒ� ����(image)�� �����ϰų� resources������ ����� �ش�.
		
		//getServletContext().getRealPath("/resources/image");-resources ���� �ȿ� ������
		//getServletContext().getRealPath("/image");-webapp ���� �ȿ� ������
		
		//image������ ���� ��� servlet-context.xml����
		//<resources mapping"/resources**" location="/resources/" />��
		//<resources mapping"/**" loaction="/" />�� ����
		
		//String path = cp + "/resources/image" ��η� �ѱ�-resources ���� �ȿ� ������
		
		MultipartFile file = request.getFile("upload");//home.jsp�� name="upload"�� ��
		
		if(file != null && file.getSize() > 0) {
			
			try {
				
				//������ ��ġ
				FileOutputStream fos = new FileOutputStream(path + "/" + file.getOriginalFilename());
				
				InputStream is = file.getInputStream();
				
				int data;
				byte[] buffer = new byte[4096];
				
				while((data = is.read(buffer, 0, buffer.length)) != -1) {
					
					fos.write(buffer, 0, data);
				}
				is.close();
				fos.close();
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		return "uploadResult";//jsp����
	}
	
	
	 @RequestMapping(value = "/downloadView.action")
	 public ModelAndView getDownloadView() throws Exception {
		 
		 ModelAndView mav = new ModelAndView();
		 
		 mav.setView(new CustomDownloadView());
		 
		 return mav;
	  
	 }
	 
		
}
