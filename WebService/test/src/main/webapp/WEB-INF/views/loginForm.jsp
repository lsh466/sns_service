<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
 <script type="text/javascript" src="/resources/JavaScript/query.js"></script> 
</head>
<body>
	<form name ="dataFrm" id="dataFrm" action="">
	<div>
	아이디 : <input type="text" name="id" id="id"/><br>
	패스워드 : <input type="password" name="pw1" id="pw1"/><br>
	패스워드 중복확인 : <input type="password" name="pw2" id="pw2"/><br>
	이름 : <input type="text" name="name" id="name"/><br>
	이메일  : <input type="text" name="email" id="email"/><br>
	<input type="button" name="btnReg" id="btnReg" value="회원가입"/>
	</div>
	</form>
</body>
</html>