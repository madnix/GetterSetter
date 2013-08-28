function login_check(){
	
	if($.trim($("#id").val())==""){
		alert("아이디를 입력하세요.");	
		$("#id").focus();	
		return false;
	}

	if($.trim($("#pwd").val())==""){
		alert("비밀번호를 입력하세요.");
		$("#pwd").focus();	
		return false;
	}
}