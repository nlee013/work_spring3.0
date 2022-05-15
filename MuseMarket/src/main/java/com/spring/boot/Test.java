//package com.spring.boot;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.spring.boot.dto.CommRipDTO;
//import com.spring.boot.dto.CommuDTO;
//import com.spring.boot.service.CommRipService;
//import com.spring.boot.util.MyUtil;
//
//@SpringBooTest
//class CommentTests {
//
//	@Autowired
//	private CommRipService commripService;
//	
//	@Autowired
//	MyUtil myUtil;
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Test
//	public void registerComments() {
//		int number = 20;
//
//		for (int i = 1; i <= number; i++) {
//			CommRipDTO dto = new CommRipDTO();
//			dto.setCommuNo((int) 6529); // 댓글을 추가할 게시글 번호
//			dto.setCrContent(i + "번 댓글을 추가합니다!");
//			dto.setUserId(i + "번 회원");
//			commripService.registerComment(dto);
//		}
//
//		logger.debug("댓글 " + number + "개가 등록되었습니다.");
//	}
//
//	@Test
//	public void deleteComment(HttpServletRequest request ) {
//		commripService.deleteComment((int) 10); // 삭제할 댓글 번호
//
//		getCommentList(request);
//	}
//
//	@Test
//	public void getCommentList(HttpServletRequest request) {
//		
//		CommRipDTO dto = new CommRipDTO();
//		
//		dto.setCommuNo((int) 6529); // 댓글을 추가할 게시글 번호
//		
//		String pageNum = request.getParameter("pageNum");
//		String searchKey = request.getParameter("searchKey");
//		String searchValue = request.getParameter("searchValue");
//
//		List<CommuDTO> lists = 
//				commripService.getList(dto, start, end, searchKey, searchValue);
//	}
//
//}