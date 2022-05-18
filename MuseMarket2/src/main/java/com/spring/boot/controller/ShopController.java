package com.spring.boot.controller;


import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boot.dto.ShopDTO;
import com.spring.boot.service.ShopService;
import com.spring.boot.util.MyUtil;

@RestController
public class ShopController {

	
	@Resource
	private ShopService shopService;
	
	@Autowired
	MyUtil myUtil;

	  //여기서 list에서 넘어오는 데이터를 받고,,
	  
	  @RequestMapping(value = "/upload.action", method = {RequestMethod.GET})
	  public ModelAndView upload() throws Exception{
	  
	  ModelAndView mav = new ModelAndView();
	  
	  mav.setViewName("shop/write");
	  
	  return mav;
	  }
		
	
	  @RequestMapping(value = "/upload_ok.action", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView upload_ok(@RequestParam("upfiles")MultipartFile[] mFile,@RequestParam("tupload")MultipartFile tmFile,HttpServletRequest request, ShopDTO dto) 
			throws Exception{
		
		String UPLOAD_PATH = "D:\\sts-bundle\\work\\MuseMarket2\\src\\main\\resources\\static\\upload"; // 업로드 할 위치
		
		int maxNum = shopService.maxNum();
		
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("bbb");
		
		System.out.println(dto.getProdSale());
		System.out.println(dto.getProdSale());
		System.out.println(dto.getProdSubject());
		
		System.out.println("aaa");
		
		System.out.println(dto.getProdAddr());
		System.out.println(mFile[0].getOriginalFilename());
		System.out.println(tmFile.getOriginalFilename());
		
		
		try {
			
		dto.setProdNo(maxNum + 1);
		shopService.insertData(dto);
		
		System.out.println(dto.getProdNo());
			
			//multifile insert

			for(int i=0;i<mFile.length;i++) {				
				
				//data insert

				//체크
				System.out.println(mFile.length);

				
				MultipartFile file = mFile[i];	

				String files = (new Date().getTime()) + "" + (new Random().ints(1000, 9999).findAny().getAsInt());
				
				System.out.println("abc"+files);
				System.out.println("def"+file);
				
				String originFile = file.getOriginalFilename();
				
				String fileExtension = originFile.substring(originFile.lastIndexOf(".") + 1);
				
				System.out.println(originFile + "ggg");

				System.out.println("cccccc");
				
				originFile = originFile.substring(0, originFile.lastIndexOf(".")); 
				
				System.out.println("ddddd");
				
				long fileSize = file.getSize();			
				
				File fileSave = new File(UPLOAD_PATH, files + "." + fileExtension);
				
				if(!fileSave.exists()) {
					fileSave.mkdirs();
					System.out.println("폴더 생성완료");
				}
				
							
				
				file.transferTo(fileSave);
							
				System.out.println("files=" + files);
				System.out.println("originFile=" + originFile);
				System.out.println("fileExtension=" + fileExtension);
				System.out.println("fileSize=" + fileSize);
				
				dto.setSaveFileName(files + "." + fileExtension);
				dto.setOriginalFileName(originFile);
				
				int maxImgNo = shopService.maxImgNum();
				dto.setImgNo(maxImgNo + 1);
				shopService.insertFile(dto);				
				
				System.out.println(mFile[i].getOriginalFilename());				
				
				MultipartFile tfile = tmFile;
				String tfiles = ("t" + new Date().getTime()) + "" + (new Random().ints(1000, 9999).findAny().getAsInt());
				String toriginFile= tfile.getOriginalFilename();
				String tfileExtension = toriginFile.substring(toriginFile.lastIndexOf(".") + 1);
				toriginFile = toriginFile.substring(0, toriginFile.lastIndexOf("."));
				long tfileSize = tfile.getSize();
				File tfileSave = new File(UPLOAD_PATH, tfiles + "." + tfileExtension);
				tfileSave.mkdirs();
				
				tfile.transferTo(tfileSave);
				dto.setOriginalFileName(toriginFile);
				dto.setTmImg(tfiles + "." + tfileExtension);
				shopService.insertTmFile(dto);
			} 
			
			
			

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		mav.setViewName("redirect:/shop.action");	
		
		
		return mav;

		
	}
	
	

	@RequestMapping(value = "/shop.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView shop(HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		ShopDTO dto = new ShopDTO();
		
		List<ShopDTO> lists = shopService.getList(dto.getProdNo(), dto);
		
		/*
		 * //아트와 뮤직 나누기..? int artProd = lists.indexOf(dto.getProdSelect(
		 * "POSTER","PIGURE","GOODS","ETC")); int musicProd =
		 * lists.indexOf(dto.getProdSelect( "LP","TAPE","DVD","INSTRUMENT"));
		 */
		
		
		mav.addObject("lists", lists);
		/*
		 * mav.addObject("artProd", artProd); mav.addObject("musicProd", musicProd);
		 */
		
		mav.setViewName("shop/shop");
		
		return mav;
		
		
	}
	
	@RequestMapping(value = "/selecshop.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView selecshop(HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		ShopDTO dto = new ShopDTO();
		
		List<ShopDTO> alists = shopService.getSelectLists(dto.getProdNo(), dto);
		
		
		 //아트와 뮤직 나누기..? 
		int artProd = alists.indexOf(dto.getProdSelect( "POSTER","PIGURE","GOODS","ETC")); 
		int musicProd = alists.indexOf(dto.getProdSelect( "LP","TAPE","DVD","INSTRUMENT"));
		 
		
		mav.addObject("lists", alists);
		
		mav.addObject("artProd", artProd); 
		mav.addObject("musicProd", musicProd);
		
		
		mav.setViewName("shop/artshop");
		
		return mav;
		
		
	}


}
