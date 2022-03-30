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
		
		//.jsp파일로 보냄
		//mav.setViewName("simpleCustomView");
		
		//Class(.java)로 data를 넘김
		mav.setView(new SimpleCustomView());//class이름 넣기 + 객체 생성
		mav.addObject("message", "SimpleCustomView Class 입니다.");
		
		return mav;
	}
	
	@RequestMapping(value = "/pdfView.action")
	public ModelAndView getPdfView() {
		
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("pdfView");
		
		mav.setView(new CustomPdfView());
		mav.addObject("message", "pdfView Class 입니다.");
		
		return mav;
	}
	
	@RequestMapping(value = "/excelView.action")
	public ModelAndView getExcelView() {
		
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("excelView");
		
		mav.setView(new CustomExcelView());
		mav.addObject("message", "excelView Class 입니다.");
				
		return mav;
	}
	
	@RequestMapping(value = "/uploadView.action", method = {RequestMethod.POST, RequestMethod.GET})
	public String getUploadView(MultipartHttpServletRequest request, String str) throws Exception {
		
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/files");//저장 경로
		
		//WEB_INF는 외부에서 접근 금지 영역이므로
		//이미지를 보기 위해 (일반적으로 홈페이지에 띄어지는 이미지를 말함)
		//왼쪽(이 프로그램) webapp 폴더 아래 폴더(image)를 생성하거나 resources폴더에 만들어 준다.
		
		//getServletContext().getRealPath("/resources/image");-resources 폴더 안에 생성시
		//getServletContext().getRealPath("/image");-webapp 폴더 안에 생성시
		
		//image폴더를 만든 경우 servlet-context.xml에서
		//<resources mapping"/resources**" location="/resources/" />를
		//<resources mapping"/**" loaction="/" />로 수정
		
		//String path = cp + "/resources/image" 경로로 넘김-resources 폴더 안에 생성시
		
		MultipartFile file = request.getFile("upload");//home.jsp에 name="upload"를 씀
		
		if(file != null && file.getSize() > 0) {
			
			try {
				
				//내보낼 위치
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
		return "uploadResult";//jsp파일
	}
	
	
	 @RequestMapping(value = "/downloadView.action")
	 public ModelAndView getDownloadView() throws Exception {
		 
		 ModelAndView mav = new ModelAndView();
		 
		 mav.setView(new CustomDownloadView());
		 
		 return mav;
	  
	 }
	 
		
}
