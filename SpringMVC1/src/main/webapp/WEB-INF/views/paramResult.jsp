<%@page import="com.exe.springmvc.PersonDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	
	//넘어오는 dto를 받는다
	PersonDTO dto = (PersonDTO)request.getAttribute("dto");
	//나중에 EL로 받을 예정(아래 <%=%부분)
	//나중에 boot 할 때 modelAndView 많이 사용
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Param Result</title>
</head>
<body>

<h2>Param Result</h2>
이름: <%=name %><br/>
전화: <%=phone %><br/>
이메일: <%=email %><br/>

<br/><br/>

<h2>ModelAndView</h2>

<%if(dto != null){%>
	
	이름: <%=dto.getName() %><br/>
	전화: <%=dto.getPhone() %><br/>
	이메일: <%=dto.getEmail() %><br/>	
	
<%}else{%>

	데이터 없음<br/>
	
<%}%>

</body>
</html>