package com.exe.springwebview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomViewController {

	@RequestMapping(value = "/simpleCustomView.action")
	public ModelAndView customView() {
		
		ModelAndView mav = new ModelAndView();
		
		//jsp파일로 보냄
		//mav.setViewName("simpleCustomView");
		
		//Class로 data를 넘김
		mav.setView(new SimpleCustomView());//class이름 넣기 + 객체 생성
		mav.addObject("message", "SimpleCustomView Class 입니다.");
		
		return mav;
	}
}
