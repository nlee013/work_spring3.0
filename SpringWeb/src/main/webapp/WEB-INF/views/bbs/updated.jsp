<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게 시 판</title>

<link rel="stylesheet" type="text/css" href="/springweb/resources/css/style.css"/>
<link rel="stylesheet" type="text/css" href="/springweb/resources/css/created.css"/>

<script type="text/javascript" src="springweb/resources/js/util.js"></script>
<script type="text/javascript">

	function sendIt(){
		
		var f = document.myForm;
		
		str = f.subject.value;
		str = str.trim();
		if(!str){
			alert("\n제목을 입력하세요.");
			f.subject.focus();
			return;
		}
		f.subject.value = str;
		
		str = f.name.value;
		str = str.trim();
		if(!str){
			alert("\n이름을 입력하세요.");
			f.name.focus();
			return;
		}		
		
		/* if(!isValidKorean(str)){
			alert("\n이름을 정확히 입력하세요.");
			f.name.focus()
			return;
		}		 */
		f.name.value = str;
		
		if(f.email.value){
			if(!isValidEmail(f.email.value)){
				alert("\n정상적인 E-Mail을 입력하세요.");
				f.email.focus();
				return;
			}
		}
		
		str = f.content.value;
		str = str.trim();
		if(!str){
			alert("\n내용을 입력하세요.");
			f.content.focus();
			return;
		}
		f.content.value = str;
		
		str = f.pwd.value;
		str = str.trim();
		if(!str){
			alert("\n비밀번호를 입력하세요.");
			f.pwd.focus();
			return;
		}
		f.pwd.value = str;
		
		f.action = "<%=cp%>updated_ok.action";
		f.submit();
		
	}

</script>


</head>
<body>

<div id="bbs">
	<div id="bbs_title">
		게 시 판 
	</div>
	
	<!-- form 시작 -->
	<form action="" method="post" name="myForm">
	
	<!-- 제목 -->
	<div id="bbsCreated">
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				<dd>
				<input type="text" name="subject" size="60" value="${dto.subject }"
				maxlength="100" class="boxTF"/>
				</dd>
			</dl>		
		</div>
		
		<!-- 작성자 -->
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>
				<input type="text" name="name" size="35" value="${dto.name }"
				maxlength="20" class="boxTF"/>
				</dd>
			</dl>		
		</div>
		
		<!-- 이메일 -->
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>E-Mail</dt>
				<dd>
				<input type="text" name="email" size="35" value="${dto.email }"
				maxlength="50" class="boxTF"/>
				</dd>
			</dl>		
		</div>
		
		<!-- 내용 -->
		<div id="bbsCreated_content">
			<dl>
				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
				<dd>
				<textarea rows="12" cols="63" name="content"
				class="boxTA">${dto.content }</textarea>
				</dd>
			</dl>
		</div>
		
		<!-- 비밀번호 -->
		<div class="bbsCreated_noLine">
			<dl>
				<dt>비밀번호</dt>
				<dd>
				<input type="password" name="pwd" size="35" value="${dto.pwd }"
				maxlength="7" class="boxTF"/>
				&nbsp;(게시물 수정 및 삭제시 필요!!)
				</dd>
			</dl>		
		</div>	
	
	</div>
	
	<!-- 버튼 -->
	<div id="bbsCreated_footer">
	
		<input type="hidden" name="num" value="${dto.num }"/>
		<input type="hidden" name="pageNum" value="${pageNum }"/>
		<input type="hidden" name="searchKey" value="${searchKey }"/>
		<input type="hidden" name="searchValue" value="${searchValue }"/>
		
		<input type="button" value=" 수정하기 " class="btn2" onclick="sendIt();"/>
		<input type="button" value=" 수정취소 " class="btn2"
		onclick="javascript:location.href='<%=cp%>/list.action?${params }';"/>	
	</div>
	
	</form>

</div>


</body>
</html>





























