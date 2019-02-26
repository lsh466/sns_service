<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${member.USER_ID}</h1>
	<br>
	<ol>
		<li>이름 ${member.USER_NAME}</li>
		<li>비밀번호 ${member.USER_PW}</li>
		<li>이메일 ${member.USER_EMAIL}</li>
		<li>가입날짜 ${member.USER_REGDATE}</li>
	</ol>
	
	<a href="logout.do">로그아웃</a>
</body>
</html>