$(document).ready( function(){
	//로그인 버튼
	$("#btnLogin").click(function(){
		goLogin();
	})
	//회원가입하기 버튼
	$("#btnLoginFrm").click(function(){
		Reg();
	})
	//사용자등록 버튼
	$("#btnReg").click(function(){
		goReg();
	})
});


//로그인하기
function goLogin(){

	if($("#id").val()==null || $("#id").val() ==""){
		alert("아이디를 입력해주세요");
		$("#id").focus();
		return false;
	}
	if($("#password").val()==null || $("#password").val()==""){
		alert("패스워드를 입력해주세요");
		$("#password").focus();
		return false;
	}
	
	var data = $("#loginFrm").serialize();

	$.ajax({
		type: "POST",
		dataType : "json",
		url : "/goLogin.do",
		data : data,
		success:function(result){
			if(result.RESULT_CODE == "SUCCESS"){
//				alert(result.RESULT_MSG);
//				location.href="main.do"
			}else{
				alert(result.RESULT_MSG);
			}
		},
		error:function(error){
			if(result.RESULT_CODE =="FAILURE"){
				alert(result.RESULT_MSG);
			}
		}
	});//Ajax 통신 끝
}
//회원가입 폼으로 가기
function Reg(){
	
	document.location.href = "loginForm.do";
}

//회원가입하기
function goReg(){
	var data={}; //data-> form에 적은 놈들
	data = $("#dataFrm").serialize();
	alert(data);
	
	if($("#id").val()==null || $("#id").val() ==""){
		alert("아이디를 입력해주세요");
		$("#id").focus();
		return false;
	}
	if($("#pw1").val()==null || $("#pw1").val()==""){
		alert("패스워드를 입력해주세요");
		$("#pw1").focus();
		return false;
	}
	if($("#email").val()==null || $("#email").val()==""){
		alert("이메일을 입력해주세요");
		$("#email").focus();
		return false;
	}
	if($("#name").val()==null || $("#name").val()==""){
		alert("이름을 입력해주세요");
		$("#name").focus();
		return false;
	}
	
	$.ajax({
		async:false,
		type:"POST",
		dataType: "json",
		url:"/loginForm/MemberJoin.do",
		data:data,   //form에 적었던 애들
		success:function(result){
			if(result.RESULT_CODE == "SUCCESS"){
				alert(result.RESULT_MSG);
				location.href="login.do";
			}else if(result.RESULT_CODE == "FAILURE"){
				alert(result.RESULT_MSG);
				$("#id").val('');
				$("#pw1").val('');
				$("#pw2").val('');
				$("#email").val('');
				$("#name").val('');
				$("#id").focus();
			}
		},
		error:function(error){
			if(error.RESULT_CODE == "FAILURE"){
				alert(error.RESULT_MSG);
			}
		}
	});//Ajax 통신 끝
}