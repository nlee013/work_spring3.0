package com.spring.boot.controller;

import com.spring.boot.dto.UsersDTO;
import com.spring.boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLDecoder;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class UsersController {
	
	//자동DI
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
	public boolean login(@RequestBody UsersDTO dto,HttpSession session, HttpServletResponse response) throws Exception{

		UsersDTO usersDTO = service.login(dto);
		if (ObjectUtils.isEmpty(usersDTO)) {
			return false;
		}
		session.setAttribute("login", usersDTO);
		//session.setAttribute("userEmail", userEmail);
		return true;
	}

	//로그아웃 처리
	@RequestMapping(value = "/logout.action")
	public ModelAndView logout(HttpSession session, HttpServletResponse response) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("login");
		
		mav.setViewName("redirect:/");
		
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

	
	
	//마이페이지 
	
	@RequestMapping(value = "/mypage.action",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mypage(UsersDTO dto, HttpSession session,HttpServletRequest request) throws Exception{
		
		int userNo = 1; 
		//int userNo = Integer.parseInt(request.getParameter("userNo"));
		//UsersDTO users = service.getReadData(userNo);
		ModelAndView mav = new ModelAndView();

		//mav.addObject("users", users);
//		session.setAttribute("dto", users);
		
		service.getReadData(userNo);
		
		mav.addObject("dto",dto);
		//mav.setViewName("signup/mypage");
		mav.setViewName("mypage/mypage");
		
		return mav;
		
	}
	
	//개인 정보 수정 
	
	  @RequestMapping(value = "/mypage_updated.action",
			  method = {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView my_updated(HttpSession session,HttpServletRequest request) throws Exception{
	  
		 	
		  int userNo = 1;  
		  //int userNo = Integer.parseInt(request.getParameter("userNo"));
		  
		  session = request.getSession();
		  
		  
		  UsersDTO dto = service.getReadData(userNo);
		  
		  if(dto==null) {
			  ModelAndView mav = new ModelAndView();
			  mav.setViewName("redirect:/index.action");
			  return mav;
		 }
		  
		  ModelAndView mav = new ModelAndView();
		  
		  mav.addObject("dto", dto);		  
		  //mav.setViewName("signup/updated");
		  mav.setViewName("mypage/updated");
		  
		  return mav;
	  
	  }
	  
	@ResponseBody
	@RequestMapping(value = "/mypage_updated_ok.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView my_updated_ok(UsersDTO dto,HttpServletRequest request) throws Exception{
	
		
		service.updateData(dto);

		ModelAndView mav = new ModelAndView();
		

		mav.setViewName("redirect:/mypage_updated_ok.action");
				
		return mav;
		
	}
	
}