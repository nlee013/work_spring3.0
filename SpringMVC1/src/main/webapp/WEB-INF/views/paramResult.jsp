<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
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

</body>
</html>