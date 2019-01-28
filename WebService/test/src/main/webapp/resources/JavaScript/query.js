/**
 * 
 */

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

function Reg(){
	document.location.href = "loginForm.do";
}

function goReg(){
	var data={};
	data = $("#dataFrm").serialize();
	alert(data);
	if($("#id").val()==null || $("#id").val() ==""){
		alert("아이디를 입력해주세요");
		return false;
	}
	if($("#pw1").val()==null || $("#pw1").val()==""){
		alert("패스워드를 입력해주세요");
		return false;
	}
	if($("#email").val()==null || $("#email").val()==""){
		alert("이메일을 입력해주세요");
		return false;
	}
	if($("#name").val()==null || $("#name").val()==""){
		alert("이름을 입력해주세요");
		return false;
	}
	
	$.ajax({
		async:false,
		type:"GET",
		dataType: "json",
		url:"/loginForm/MemberJoin.do",
		data:data,
		success:function(result){
			alert("회원가입이 됐습니다!");
			if(result.RESULT_CODE == "SUCCESS"){
			location.href="";
			}
		},
		error:function(erro){
			if(erro.RESULT_CODE == "FAILURE"){
				alert("아이디가 중복됩니다. 다시 입력해주세요");
			}
		}
	});
}