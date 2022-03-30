package com.spring.boot.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.dto.BoardDTO;
import com.spring.boot.service.BoardService;
import com.spring.boot.util.MyUtil;

@RestController//일반 @controller 사용불가
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	@Autowired
	MyUtil myUtil;
	
	//spring boot에서는 무조건 modelAndView 사용
	@RequestMapping(value = "/")
	public ModelAndView index() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");//index.html index.jsp
		
		return mav;
	}
	
	@RequestMapping(value = "/created.action", method = {RequestMethod.GET})
	public ModelAndView created() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("bbs/created");//index.html index.jsp
		
		return mav;
		
	}
	
	@RequestMapping(value = "/created.action", method = {RequestMethod.POST})
	public ModelAndView created_ok(BoardDTO dto, HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		int maxNum = boardService.maxNum();
		
		dto.setNum(maxNum + 1);
		dto.setIpAddr(request.getRemoteAddr());
		
		boardService.insertData(dto);
		
		mav.setViewName("redirect:/list.action");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/list.action", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(HttpServletRequest request) throws Exception{
		
		String cp = request.getContextPath();
		
		String pageNum = request.getParameter("pageNum");
	
		int currentPage = 1;
	
		if(pageNum != null) {
		
			currentPage = Integer.parseInt(pageNum);
		}	
	
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		//나중에는 searchValue.equals("")과 같이 사용
		if(searchValue == null) {
			
			searchKey = "subject";
			searchValue = "";

		}else {
			
			if(request.getMethod().equals("GET")) {
				
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
		}
		
		int dataCount = boardService.getDataCount(searchKey, searchValue);
		
		int numPerPage = 5;
		int totalPage = myUtil.getPageCount(numPerPage, dataCount);
		
		if(currentPage > totalPage) {
			
			currentPage = totalPage;
		}
	
		int start = (currentPage - 1)*numPerPage + 1;
		int end = currentPage*numPerPage;
		
		List<BoardDTO> lists = boardService.getlistList(start, end, searchKey, searchValue);
		
		String param = "";
		
		if(searchValue != null && !searchValue.equals("")) {
			
			param = "searchKey=" + searchKey;
			param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		String listUrl = "/list.action";
		
		if(!param.equals("")) {
			
			listUrl += "?" + param;
		}
		
		String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, listUrl);
	
		String articleUrl = "/article.action?pageNum=" + currentPage;
	
		if(!param.equals("")) {
		
			articleUrl += "&" + param;
		
		}
	
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("lists", lists);
		mav.addObject("articleUrl", articleUrl);
		mav.addObject("pageIndexList", pageIndexList);
		mav.addObject("dataCount", dataCount);
		
		mav.setViewName("bbs/list");
		
		return mav;
	}
		

}
