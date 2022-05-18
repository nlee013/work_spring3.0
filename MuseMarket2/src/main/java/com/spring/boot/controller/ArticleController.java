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

		String userId  = articleService.getUserId(dto.getUserNo()); // 판매자 아이디
		
		int reviewCount = articleService.getReviewCount(prodNo);
		
		int heartCount = articleService.heartCount(prodNo);
		
		dto.setUserNo(1);
		
		int myHeartCount = articleService.myHeartCount(dto);
		
		System.out.println(myHeartCount);

		
		// String userId = session.getAttribute("userId");
		
		String reviewUserId = "hyemin"; // 리뷰작성자 아이디 (세션)
		
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
		 
		  

		
			
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("heartCount",heartCount);
		mav.addObject("myHeartCount",myHeartCount);
		mav.addObject("reviewCount",reviewCount);
		mav.addObject("userId",userId);
		//mav.addObject("lists",lists);
		mav.addObject("reviewUserId",reviewUserId);
		mav.addObject("dto", dto);
		//mav.addObject("params", param);
		mav.addObject("lineSu", lineSu);
		//mav.addObject("pageNum", pageNum);
		
		mav.setViewName("article/article");
		
		
		return mav;
	}

	@RequestMapping(value = "/sale_list.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(HttpServletRequest request) throws Exception{
		
		
		//int prodNo = Integer.parseInt(request.getParameter("prodNo")); 

		int prodNo = 1;
		List<ArticleDTO> lists = articleService.listData(prodNo);
		
		for(int i=0;i<lists.size();i++) {
			
			int reviewUserNo = lists.get(i).getUserNo();
			
			String reviewUserId = articleService.getUserId(reviewUserNo);
			
			lists.get(i).setReviewUserId(reviewUserId);
			
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("lists",lists);
		
		mav.setViewName("article/list");
		
		return mav;
	}
	
	@RequestMapping(value = "/sale_create.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView create(ArticleDTO dto, HttpServletRequest request) throws Exception{
		
		  //int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		  //int userNo = Integer.parseInt(request.getParameter("userNo"));
			
	
		
		int prodNo = 1;
		int userNo = 1;
		
		String userId = articleService.getUserId(userNo);
		int numMax = articleService.numMax();
		
		
		dto.setReviewNo(numMax + 1);
		dto.setProdNo(prodNo);
		dto.setUserNo(userNo);
		dto.setReviewIpAddr(request.getRemoteAddr());
			
//			reviewGroupNo,
//			reviewDepth,
//			reviewOrderNo,
//			reviewParent,
			
			
		articleService.insertData(dto);
	
		 
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/sale_list.action");
		
		return mav;
	}
	
	@RequestMapping(value = "/sale_delete.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView delete(ArticleDTO dto, HttpServletRequest request) throws Exception{
		
		  //int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		  //int userNo = Integer.parseInt(request.getParameter("userNo"));
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		System.out.println("여기까지");
		System.out.println(reviewNo);
		
		articleService.deleteData(reviewNo);
	
		 
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/sale_list.action");
		
		return mav;
	}
	
	@RequestMapping(value = "/heartData.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView heartIn(ArticleDTO dto,HttpServletRequest request) throws Exception{
	
		dto.setProdNo(1);
		dto.setUserNo(1);
		
		int myHeartCount = articleService.myHeartCount(dto); // 빈하트 : 0,2
		
		if(myHeartCount==0) {
		
			dto.setHeartCheck(1);
			
			articleService.heartUpdate(dto);
			 
		}
		
		if(myHeartCount==1) {
			
			dto.setHeartCheck(0);
			
			articleService.heartUpdate(dto);
			 
		}
		
		if(myHeartCount==2) {
			
			int heartNo = articleService.heartNumMax();
			
			dto.setHeartNo(heartNo + 1);
			
			articleService.heartIn(dto);
		}
		
		System.out.println("dfdfdfdf");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("article/heartData");
		
		return mav;
		
	}
	
}
