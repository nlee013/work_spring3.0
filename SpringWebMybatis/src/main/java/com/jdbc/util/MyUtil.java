package com.jdbc.util;
//Paging ���ִ� ��
public class MyUtil {

	//��ü ������ ���ϱ�
	public int getPageCount(int numPerPage, int dataCount) {
		
		//��ü ������ ������ �ϳ��� �������� ��� �����͸� ������� ���
		int pageCount = 0;
		
		pageCount = dataCount/numPerPage;
		
		//���� ���� 0�� �ƴҶ�
		if(dataCount%numPerPage != 0) {
			
			//������ �� �ø���
			pageCount++;
		}
		return pageCount;
	}
	
	//������ ó�� method-���ڷ� ó��
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {
		
		int numPerBlock = 5;//������ 6 7 8 9 10 ������
		int currentPageSetup;//���� �� ��
		int page;//6 7 8 9 10 ��
		
		StringBuffer sb = new StringBuffer();
		//StringBuffer�� StringBuilder�� �ִ�
		
		if(currentPage == 0 || totalPage ==0) {
			
			return "";
		}
		
		//��ü �˻�->list.jsp?pageNum=2
		//����ǥ�� ������ list.jsp?searchKey=subject&searchValue=aa&pageNum=2
		
		//���� ������~
		if(listUrl.indexOf("?") != -1) {
			listUrl = listUrl + "&";
			
		}else {
			listUrl = listUrl + "?";
		}
		
		//1 2 3 4 5 ������
		//������ 6 7 8 9 10 ������
		//������ 11 12 13 14 15 ������
		//������ �������� ���� ����
		//�������� '����'�� ���� ��
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		if(currentPage % numPerBlock == 0) {
			
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		//������
		if(totalPage > numPerBlock && currentPageSetup > 0) {
			
			//�տ� ��������\�� ���� ������ �տ� �ִ� "�� �� �ڿ� �ִ� "�� �������� ���ؼ�
			sb.append("<a href=\"" + listUrl + "pageNum =" + currentPageSetup + "\">������</a>&nbsp;");
			//<a href="list.jsp?pageNum=5>������</a>
		}
		
		//�ٷ� ���� ������
		//������ 6 7 8 9 10 �������� 6 7 8 9 10 �����
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
		
		//������
		//������ 6 7 8 9 10 ������
		//������ 11 12 13 14 15 ������
		if(totalPage - currentPageSetup > numPerBlock) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">������</a>&nbsp;");
			//<a href="list.jsp?pageNum=11">������</a>&nbsp;
		}
		
		return sb.toString();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
