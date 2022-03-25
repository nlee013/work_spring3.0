package com.exe.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("testController")
public class TestController{
	
	/*
	@RequestMapping(value = "/test/param.action", method = RequestMethod.GET)
	public String processGetRequest() {
		
		System.out.println("GET 방식 Request");
		
		return "paramResult";
	}
	
	@RequestMapping(value = "/test/param.action", method = RequestMethod.POST)
	public String processPostRequest() {
		
		System.out.println("POST 방식 Request");
		
		return "paramResult";
		
	}
*/
	
	@RequestMapping(value = "/test/param.action",
				    method = {RequestMethod.GET ,RequestMethod.POST})
	public String processBothRequest(PersonDTO dto, String name, HttpServletRequest request) {
		/*
		 * if(request.getMethod().equalsIgnoreCase("GET 방식 Request");
		 * 
		 * return "paramResult";
		 * 
		 * else {
		 * 
		 * System.out.println("POST 방식 Request");
		 * 
		 * return "paramResult2"; }
		 */
		
		System.out.println("GET/POST 방식 Request");
		
		System.out.println(name);
		System.out.println(request.getParameter("phone"));
		
		System.out.println(dto);
		System.out.println("dto.getName(): " + dto.getName());
		System.out.println("dto.getPhone(): " + dto.getPhone());
		System.out.println("dto.getEmail(): " + dto.getEmail());
		
		return "paramResult";
	}
	
	@RequestMapping(value = "/test/mav.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mavRequest(PersonDTO dto) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("paramResult"); //데이터를 뿌리는 곳
		
		return mav;
	}
	
	@RequestMapping(value = "/test/redirect.action", method = {RequestMethod.GET, RequestMethod.POST})
	public String mavRedirectRequest() {
		
		//return "redirect:/";
		return "redirect:/hello.action";
	}
}
