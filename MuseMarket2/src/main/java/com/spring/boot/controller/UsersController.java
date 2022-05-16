package com.spring.boot.controller;

import com.spring.boot.dto.LoginDTO;
import com.spring.boot.dto.UsersDTO;
import com.spring.boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping
public class UsersController {
	
	//자동DI
	@Resource
	@Autowired
	private UsersService service;
	
	
	//로그인폼
	@RequestMapping(value = "/loginForm.action")
	public ModelAndView loginForm() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("signup/loginForm");
		
		return mav;
	
	}

	//회원가입폼
	@RequestMapping(value = "/signupForm.action")
	public ModelAndView writeForm() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("signup/signupForm");
		
		return mav;
	}
	
	//아이디찾기폼
	@RequestMapping("/findUserIdForm.action")
	public String findUserIdForm() throws Exception{
		return "findUserIdForm";
	}

	//비밀번호찾기폼
	@RequestMapping("/findUserPwdForm.action")
	public String findUserPwdForm() throws Exception{
		return "findUserPwdForm";
	}

	//로그인 처리
	@RequestMapping("/login.action")
	@ResponseBody
	public boolean login(@RequestBody LoginDTO dto,HttpSession session, HttpServletResponse response) throws Exception{

		LoginDTO loginDTO = service.login(dto);
		if (ObjectUtils.isEmpty(loginDTO)) {
			return false;
		}
		session.setAttribute("login", loginDTO);
		//session.setAttribute("userEmail", userEmail);
		return true;
	}

	//로그아웃 처리
	@RequestMapping(value = "/logout.action")
	public ModelAndView logout(HttpSession session, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("login");
		
		mav.setViewName("redirect:/index.action");
		
		return mav;	
		
	}
	
	//회원가입처리
	@RequestMapping(value = "/signup.action")
	@ResponseBody
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response,
			UsersDTO dto) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		service.write(dto);
		
		mav.setViewName("redirect:/login.action");
		
		return mav;
	}

	// 유저 아이디 중복 체크
	@RequestMapping(value = "/isUserId.action")
	@ResponseBody
	public boolean isUserId(@RequestBody UsersDTO dto) throws Exception{
		return service.isUserId(dto);
	}
	

	
}