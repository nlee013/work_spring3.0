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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping
public class UsersController {
	
	//자동DI
	@Autowired
	private UsersService service;
	
	
	//로그인폼
	@GetMapping("/loginForm")
	public String loginForm() throws Exception{
		return "loginForm";
	}

	//회원가입폼
	@GetMapping("/signupForm")
	public String writeForm() throws Exception{
		return "signupForm";
	}

	//아이디찾기폼
	@GetMapping("/findUserIdForm")
	public String findUserIdForm() throws Exception{
		return "findUserIdForm";
	}

	//비밀번호찾기폼
	@GetMapping("/findUserPwdForm")
	public String findUserPwdForm() throws Exception{
		return "findUserPwdForm";
	}

	//로그인 처리
	@PostMapping("/login.do")
	@ResponseBody
	public boolean login(@RequestBody LoginDTO dto,HttpSession session, HttpServletResponse response) throws Exception{

		LoginDTO loginDTO = service.login(dto);
		if (ObjectUtils.isEmpty(loginDTO)) {
			return false;
		}
		session.setAttribute("login", loginDTO);
		
		return true;
	}

	//로그아웃 처리
	@GetMapping("/logout.do")
	public String logout(HttpSession session, HttpServletResponse response) throws Exception{
		
		session.removeAttribute("login");
			
		//return "redirect:/users/list";
		return "redirect:/index.action";
		
	}
	
	//회원가입처리
	@PostMapping("/signup.do")
	@ResponseBody
	public void write(@RequestBody UsersDTO dto) throws Exception {
		service.write(dto);
	}

	// 유저 아이디 중복 체크
	@PostMapping("/isUserId.do")
	@ResponseBody
	public boolean isUserId(@RequestBody UsersDTO dto) throws Exception{
		return service.isUserId(dto);
	}

	
}