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

<link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/created.css"/>

<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript">

	function sendIt(){
		
		var f = document.myForm;
		
		
		str = f.qSubject.value;
		str = str.trim();
		if(!str){
			alert("\n제목을 입력하세요.");
			f.qSubject.focus();
			return;
		}
		f.qSubject.value = str;
		
		str = f.userId.value;
		str = str.trim();
		if(!str){
			alert("\n이름을 입력하세요.");
			f.userId.focus();
			return;
		}		
		
		/* if(!isValidKorean(str)){
			alert("\n이름을 정확히 입력하세요.");
			f.name.focus()
			return;
		}		 */
		f.userId.value = str;
		
		str = f.qContent.value;
		str = str.trim();
		if(!str){
			alert("\n내용을 입력하세요.");
			f.qContent.focus();
			return;
		}
		f.qContent.value = str;
		
		str = f.userPwd.value;
		str = str.trim();
		if(!str){
			alert("\n비밀번호를 입력하세요.");
			f.userPwd.focus();
			return;
		}
		f.userPwd.value = str;
		
		f.action = "<%=cp%>/qa_upload_ok.action";
		f.submit();
		
	}

</script>


</head>
<body>

<div id="bbs">
	<div id="bbs_title">
		Q A 게 시 판
	</div>
	
	<!-- form 시작 -->
	<form action="" method="post" name="myForm">
	
	<!-- 제목 -->
	<div id="bbsCreated">
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				<dd>
				<input type="text" name="qSubject" size="60" 
				maxlength="100" class="boxTF"/>
				</dd>
			</dl>		
		</div>
		
		<!-- 작성자 -->
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>
				<input type="text" name="userId" size="35" 
				maxlength="20" class="boxTF"
				value=" "/>
				</dd>
			</dl>		
		</div>
		
		<!-- 내용 -->
		<div id="bbsCreated_content">
			<dl>
				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
				<dd>
				<textarea rows="12" cols="63" name="qContent"
				class="boxTA"></textarea>
				</dd>
			</dl>
		</div>
		
		<!-- 비밀번호 -->
		<div class="bbsCreated_noLine">
			<dl>
				<dt>비밀번호</dt>
				<dd>
				<input type="password" name="userPwd" size="35" 
				maxlength="7" class="boxTF"/>
				&nbsp;(게시물 수정 및 삭제시 필요!!)
				</dd>
			</dl>		
		</div>	
	
	</div>
	
	<!-- 버튼 -->
	<div id="bbsCreated_footer">
		<input type="button" value=" 등록하기 " class="btn2" onclick="sendIt();"/>
		<input type="reset" value=" 다시입력 " class="btn2" 
		onclick="document.myForm.subject.focus();"/>
		<input type="button" value=" 작성취소 " class="btn2"
		onclick="javascript:location.href='<%=cp%>/qa_list.action';"/>	
	</div>
	
	</form>

</div>


</body>
</html>





























