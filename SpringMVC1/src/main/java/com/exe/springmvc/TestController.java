package com.exe.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("testController")
public class TestController{
	
	/*
	@RequestMapping(value = "/test/param.action", method = RequestMethod.GET)
	public String processGetRequest() {
		
		System.out.println("GET ��� Request");
		
		return "paramResult";
	}
	
	@RequestMapping(value = "/test/param.action", method = RequestMethod.POST)
	public String processPostRequest() {
		
		System.out.println("POST ��� Request");
		
		return "paramResult";
		
	}
*/
	
	@RequestMapping(value = "/test/param.action",
				    method = {RequestMethod.GET ,RequestMethod.POST})
	public String processBothRequest(String name, HttpServletRequest request) {
		/*
		 * if(request.getMethod().equalsIgnoreCase("GET ��� Request");
		 * 
		 * return "paramResult";
		 * 
		 * else {
		 * 
		 * System.out.println("POST ��� Request");
		 * 
		 * return "paramResult2"; }
		 */
		
		System.out.println("GET/POST ��� Request");
		
		System.out.println(name);
		System.out.println(request.getParameter("phone"));
		
		return "paramResult";
	}
}