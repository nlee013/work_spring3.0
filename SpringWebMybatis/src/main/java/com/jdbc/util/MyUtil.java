package com.jdbc.util;
//Paging 해주는 애
public class MyUtil {

	//전체 페이지 구하기
	public int getPageCount(int numPerPage, int dataCount) {
		
		//전체 데이터 갯수와 하나의 페이지에 몇개의 데이터를 출력할지 계산
		int pageCount = 0;
		
		pageCount = dataCount/numPerPage;
		
		//나눈 몫이 0이 아닐때
		if(dataCount%numPerPage != 0) {
			
			//페이지 수 늘리기
			pageCount++;
		}
		return pageCount;
	}
	
	//페이지 처리 method-문자로 처리
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {
		
		int numPerBlock = 5;//◀이전 6 7 8 9 10 다음▶
		int currentPageSetup;//◀에 들어간 값
		int page;//6 7 8 9 10 값
		
		StringBuffer sb = new StringBuffer();
		//StringBuffer와 StringBuilder가 있다
		
		if(currentPage == 0 || totalPage ==0) {
			
			return "";
		}
		
		//전체 검색->list.jsp?pageNum=2
		//물음표가 있으면 list.jsp?searchKey=subject&searchValue=aa&pageNum=2
		
		//값이 있으면~
		if(listUrl.indexOf("?") != -1) {
			listUrl = listUrl + "&";
			
		}else {
			listUrl = listUrl + "?";
		}
		
		//1 2 3 4 5 다음▶
		//◀이전 6 7 8 9 10 다음▶
		//◀이전 11 12 13 14 15 다음▶
		//◀이전 페이지에 들어가는 공식
		//◀이전의 '이전'에 들어가는 값
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		if(currentPage % numPerBlock == 0) {
			
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		//◀이전
		if(totalPage > numPerBlock && currentPageSetup > 0) {
			
			//앞에 역슬러쉬\를 쓰는 이유는 앞에 있는 "를 맨 뒤에 있는 "와 연결짓기 위해서
			sb.append("<a href=\"" + listUrl + "pageNum =" + currentPageSetup + "\">◀이전</a>&nbsp;");
			//<a href="list.jsp?pageNum=5>◀이전</a>
		}
		
		//바로 가기 페이지
		//◀이전 6 7 8 9 10 다음▶의 6 7 8 9 10 만들기
		page = currentPageSetup + 1;
		
		while(page <= totalPage && page <= (currentPageSetup + numPerBlock)) {
			
			if(page == currentPage) {
				
				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
				//<font color=\"Fuchsia\">9</font>&nbsp;
			}else {
				
				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>&nbsp;");
				//<a href="list.jsp?pageNum=7>7</a>&nbsp;"
			}
			page++;
		}
		
		//다음▶
		//◀이전 6 7 8 9 10 다음▶
		//◀이전 11 12 13 14 15 다음▶
		if(totalPage - currentPageSetup > numPerBlock) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">다음▶</a>&nbsp;");
			//<a href="list.jsp?pageNum=11">다음▶</a>&nbsp;
		}
		
		return sb.toString();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
