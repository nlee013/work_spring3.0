//package com.spring.boot.service;
//
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.spring.boot.dto.CommRipDTO;
//import com.spring.boot.mapper.CommRipMapper;
//import com.spring.boot.mapper.CommuMapper;
//
//@Service("CommRipService")
//public class CommRipServiceImpl implements CommuService{
//
//	@Autowired
//	private CommRipMapper commripMapper;//commuMapper DI 의존성 주입
//
//	@Override
//	public boolean registerComment(CommRipDTO dto) throws Exception {
//		
//		int queryResult = 0;
//
//		if (dto.getCrNo() == 0) {
//			queryResult = commripMapper.insertData(dto);
//		} else {
//			queryResult = commripMapper.updateData(dto);
//		}
//
//		return (queryResult == 1) ? true : false;
//	}
//
//	@Override
//	public boolean deleteComment(int crNo) throws Exception {
//		
//		int queryResult = 0;
//
//		CommuDTO comment = commripMapper.getReadData(crNo);
//
//		if (comment != null && "N".equals(comment.getDelete_yn())) {
//			queryResult = commripMapper.deleteComment(crNo);
//		}
//
//		return (queryResult == 1) ? true : false;
//	}
//
//	@Override
//	public List<CommRipDTO> getCommentList(CommuDTO dto,
//			int start, int end, String searchKey, String searchValue) throws Exception {
//		
//		List<CommRipDTO> commentList = Collections.emptyList();
//
//		int commentTotalCount = commripMapper.getDataCount(searchKey, searchValue);
//		
//		if (commentTotalCount > 0) {
//			commentList = commripMapper.getList(start, end, searchKey, searchValue);
//		}
//
//		return commentList;
//		
//	}
//	
//	
//	//찾아가는 순서
//	//BoardController -> BoardService(Interface) -> BoardServiceImpl(Class) -> BoardMapper(I) -> boardMapper.xml
//	
//	
//}
