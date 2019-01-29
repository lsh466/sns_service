<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 화면</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
 <script type="text/javascript" src="/resources/JavaScript/query.js"></script> 
</head>
<body>
	<form name = "loginFrm" id = "loginFrm" action="">
		<div>
			아이디 : <input type="text" name="id" id="id"/><br>
			패스워드 : <input type="password" name="password" id="password"/><br>
			<input type="button" name="btnLogin" id="btnLogin" value="로그인"/>
			<input type="button" name="btnLoginFrm" id="btnLoginFrm" value="회원가입하기"/>
		</div>
	</form>
</body>
</html>