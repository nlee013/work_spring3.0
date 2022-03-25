<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

<P> ${serverTime}. </P>

<h2>Spring MVC Controller Test</h2>

<h3>1. <a href="test/param.action?name=suzi&phone=010-123-1234&email=suzi@naver.com">GET 방식 테스트</a></h3>

<h3>2. Post 방식 테스트</h3>
<form action="test/param.action" method="post">

이름: <input type="text" name="name"/><br/>
전화: <input type="text" name="phone"/><br/>
이메일: <input type="text" name="email"/><br/>

<input type="submit" value="전송"/><br/>

</form>
<br/>

<h3>3. <a href="test/mav.action?name=inna$phone=010-222-3333&email=inna@naver.com">ModelAndView GET 테스트</a></h3>

<h3>4. ModelAndView POST 테스트</h3>
<form action="test/mav.action" method="post">

이름: <input type="text" name="name"/><br/>
전화: <input type="text" name="phone"/><br/>
이메일: <input type="text" name="email"/><br/>

<input type="submit" value="전송"/><br/>

</form>

<h3>5. <a href="test/redirect.action">Redirect 테스트</a></h3>
</body>
</html>
