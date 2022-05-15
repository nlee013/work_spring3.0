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

import com.spring.boot.dto.QaContactDTO;
import com.spring.boot.service.ContactService;
import com.spring.boot.util.MyUtil;

@RestController
public class ContactController {

	@Resource
	private ContactService contactService;
	
	@Autowired
	MyUtil myUtil;

	@RequestMapping(value = "/qa_contact.action",method = {RequestMethod.GET})
	public ModelAndView qa_upload() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("bbs/qa_contact");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/qa_contact_ok.action",method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView created_ok(QaContactDTO dto, 
			HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		int maxNum = contactService.maxNum();
		
		dto.setQa_conNo(maxNum + 1);
				
		contactService.insertData(dto);
		
		mav.setViewName("redirect:/contact_list.action");
		//mav.setViewName("bbs/contact_list");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/contact_list.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView list(HttpServletRequest request) throws Exception{
		
		String pageNum = request.getParameter("pageNum");
		
		int currentPage = 1;
		
		if(pageNum!=null)
			currentPage = Integer.parseInt(pageNum);
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue==null) {
			searchKey = "cSubject";
			searchValue = "";
		}else {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
		}
		
		int dataCount = contactService.getDataCount(searchKey, searchValue);
		
		int numPerPage = 5;
		int totalPage = myUtil.getPageCount(numPerPage, dataCount);
		
		if(currentPage>totalPage)
			currentPage = totalPage;
		
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;
		
		List<QaContactDTO> lists = 
				contactService.getList(start, end, searchKey, searchValue);
		
		String param = "";
		if(searchValue!=null&&!searchValue.equals("")) {
			param = "searchKey=" + searchKey;
			param+= "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		String listUrl = "/contact_list.action";
		
		if(!param.equals("")) {
			listUrl += "?" + param;
		}
		
		String pageIndexList = 
				myUtil.pageIndexList(currentPage, totalPage, listUrl);
		
		String articleUrl = "/contact_article.action?pageNum=" + currentPage;
		
		if(!param.equals("")) {
			articleUrl += "&" + param;
		}
				
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("lists", lists);
		mav.addObject("articleUrl", articleUrl);
		mav.addObject("pageIndexList", pageIndexList);
		mav.addObject("dataCount", dataCount);
		
		mav.setViewName("bbs/contact_list");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/contact_article.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView article(HttpServletRequest request) throws Exception{
		
		int num = Integer.parseInt(request.getParameter("qa_conNo"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue!=null) {
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
		//contactService.updateHitCount(num);
		
		QaContactDTO dto = contactService.getReadData(num);
		
		if(dto==null) {			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/contact_list.action?pageNum=" + pageNum);
			return mav;
		}
		
		int lineSu = dto.getMessage().split("\n").length;
		
		//dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		String param = "pageNum=" + pageNum;
		if(searchValue!=null&&!searchValue.equals("")) {
			
			param += "&searchKey=" + searchKey;
			param += "&searchValue=" + 
					URLEncoder.encode(searchValue, "UTF-8");
			
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("dto", dto);
		mav.addObject("params", param);
		mav.addObject("lineSu", lineSu);
		mav.addObject("pageNum", pageNum);
		
		mav.setViewName("bbs/contact_article");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/contact_updated.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updated(HttpServletRequest request) throws Exception{
		
		int num = Integer.parseInt(request.getParameter("qa_conNo"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue!=null) {
			searchValue =
					URLDecoder.decode(searchValue, "UTF-8");
		}
		
		QaContactDTO dto = contactService.getReadData(num);
		
		if(dto==null) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/contact_list.action?pageNum=" + pageNum);
			return mav;
		}
		
		String param = "pageNum=" + pageNum;
		
		if(searchValue!=null&&!searchValue.equals("")) {
			param += "&searchKey=" + searchKey;
			param += "&searchValue=" +
					URLEncoder.encode(searchValue, "UTF-8");
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("dto", dto);
		mav.addObject("pageNum", pageNum);
		mav.addObject("params", param);
		mav.addObject("searchKey", searchKey);
		mav.addObject("searchValue", searchValue);
		
		mav.setViewName("bbs/contact_updated");
		
		return mav;		
		
	}
		
	@RequestMapping(value = "/contact_updated_ok.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updated_ok(QaContactDTO dto,HttpServletRequest request) throws Exception{
	
		String pageNum = request.getParameter("pageNum");		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
				
		dto.setMessage(dto.getMessage().replaceAll("<br/>", "\r\n"));
		
		contactService.updateData(dto);
		
		String param = "pageNum=" + pageNum;
		
		if(searchValue!=null&&!searchValue.equals("")) {
			param += "&searchKey=" + searchKey;
			param += "&searchValue=" +
					URLEncoder.encode(searchValue, "UTF-8");
		}
			
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/contact_list.action?" + param);
				
		return mav;
		
	}
	
	@RequestMapping(value = "/con_deleted_ok.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView deleted_ok(HttpServletRequest request) throws Exception{
	
		int num = Integer.parseInt(request.getParameter("qa_conNo"));
		String pageNum = request.getParameter("pageNum");		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
				
		contactService.deleteData(num);
		
		String param = "pageNum=" + pageNum;
		
		if(searchValue!=null&&!searchValue.equals("")) {
			param += "&searchKey=" + searchKey;
			param += "&searchValue=" +
					URLEncoder.encode(searchValue, "UTF-8");
		}
			
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/contact_list.action?" + param);		
				
		return mav;
		
	}
	
	
}






