package com.spring.boot.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.dto.ArticleDTO;
import com.spring.boot.service.ArticleService;
import com.spring.boot.util.MyUtil;

@RestController
public class ArticleController {
	
	@Resource
	private ArticleService articleService;
	
	@Autowired
	MyUtil myUtil;
	
	//spring boot에서는 무조건 modelAndView 사용
	@RequestMapping(value = "/")
	public ModelAndView index() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");//index.html index.jsp
		
		return mav;
	}
	
	@RequestMapping(value = "/sale_article.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView article(HttpServletRequest request) throws Exception{
		
		
		  //int prodNo = Integer.parseInt(request.getParameter("prodNo")); 
		  String pageNum = request.getParameter("pageNum");
		  
		  String searchKey = request.getParameter("searchKey"); 
		  String searchValue = request.getParameter("searchValue");
		  
		  if(searchValue != null) {
		  
		  searchValue = URLDecoder.decode(searchValue, "UTF-8");
		  
		  }
		 
		
		// 나중에 없앨 친구 : 시작
		int prodNo = 1;
		// 나중에 없앨 친구 : 끝
		
		articleService.updateHitCount(prodNo);
		
		ArticleDTO dto = articleService.getReadData(prodNo);

		ArticleDTO userDto = articleService.getUserId(dto.getUserNo());
	
		
		
		  if(dto == null) {
		  
		  ModelAndView mav = new ModelAndView();
		  
		  mav.setViewName("redirect:/sale_list.action?pageNum=" + pageNum);
		  
		  return mav; 
		  
		  }
		
		dto.setProdContent(dto.getProdContent().replaceAll("<br/>", "\n"));
		
		int lineSu = dto.getProdContent().split("\n").length;
		
		// 왜 두개가 있는거지..?
		//dto.setContent(dto.getContent().replaceAll("\n", "\r\n"));
		
		
		  String param = "pageNum=" + pageNum;
		  
		  if(searchValue != null && !searchValue.equals("")) {
		  
		  param += "&searchKey=" + searchKey; 
		  param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); }
		 
		  
		  // 여기부터는 리뷰창 구현용..
		 
		
			
			/*
			 * List<ArticleDTO> lists = (List<ArticleDTO>) articleService.listData();
			 */
		
			
		ModelAndView mav = new ModelAndView();
		
		//mav.addObject("lists",lists);
		mav.addObject("userDto",userDto);
		mav.addObject("dto", dto);
		//mav.addObject("params", param);
		mav.addObject("lineSu", lineSu);
		//mav.addObject("pageNum", pageNum);
		
		mav.setViewName("article/article");
		
		System.out.println("여기여기로로로");
		
		return mav;
	}

	@RequestMapping(value = "/sale_list.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(HttpServletRequest request) throws Exception{
		
		List<ArticleDTO> lists = articleService.listData();
		 
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("lists",lists);
		
		mav.setViewName("article/list");
		
		return mav;
	}
	
	@RequestMapping(value = "/sale_create.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView create(ArticleDTO dto, HttpServletRequest request) throws Exception{

		System.out.println("안녕:)");
		
		int numMax = articleService.numMax();
		
		dto.setNum(numMax+1);
		dto.setIpAddr(request.getRemoteAddr());
		
		articleService.insertData(dto);
		 
		System.out.println(dto.getNum());
		System.out.println(dto.getName());
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/sale_list.action");
		
		return mav;
	}
	
}
