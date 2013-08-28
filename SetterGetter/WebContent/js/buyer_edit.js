function cancel_check(){
	alert('정보수정을 취소합니다.');
	location.href="main.do";
	return false;
}
function check(){
	if($.trim($("#id").val())==""){
		alert("아이디를 입력하세요.");	
		$("#id").focus();	return false;
	}
	if($.trim($("#p_check").val())==""){
		alert("기존 비밀번호를 입력하세요.");
		$("#pwd").focus();	return false;
	}
	if($.trim($("#pwd").val())==""){
		alert("새로운 비밀번호를 입력하세요.");
		$("#pwd").focus();	return false;
	}
	if($.trim($("#pwd").val()) != $.trim($("#pwd_check").val())){
		alert("새로운 비밀번호가 일치하지 않습니다.");
		$("#pwd_check").val("");		$("#pwd").val("").focus();	
		return false;
	}
	if($.trim($("#pwd_q").val())==""){
		alert("비밀번호 확인 질문을 선택해주세요.");
		$("#pwd_q").focus();	return false;
	}
	if($.trim($("#pwd_a").val())==""){
		alert("비밀번호 확인 답변을 입력해주세요.");
		$("#pwd_a").focus();	return false;
	}
	if($.trim($("#name").val())==""){
		alert("이름을 입력해주세요.");
		$("#name").focus();	return false;
	}
	if($.trim($("#zip1").val())=="" || $.trim($("#zip2").val())==""){
		alert("우편번호를 입력해주세요.");
		$("#zip_btn").focus();	return false;
	}
	if($.trim($("#addr2").val())=="" || $.trim($("#addr2").val())==""){
		alert("상세주소를 입력해주세요.");
		$("#addr2").focus();	return false;
	}
	if($.trim($("#phone2").val())=="" && $.trim($("#phone2").val())==""){
		alert("휴대전화를 입력해주세요.");
		$("#phone2").focus(); return false;
	}
	if($.trim($("#email1").val())=="" || $.trim($("#email2").val())==""){
		alert("이메일을 입력해주세요.");
		$("#email1").focus(); return false;
	}
}

/* =============== 이메일 도메인 선택 시 =============== */
function select_email(){
	var selectObj = document.getElementById("email3");		// selectbox 개체를 가져온다.
	var idx = selectObj.selectedIndex;		// 현재 선택 되어진 seelctbox 인덱스값을 구한다.
	document.getElementById("email2").value = selectObj.options[idx].value;		// 인덱스의 값을 가져와서 값 대입
}


/* =============== 우편번호 검색 창 ===============*/
function post_check(chk){
	$("#zipbtnchk").val(chk);
	var win = window.open("zipcode.do", "zip2", "width=450, height=200");
}
function test(zip1, zip2, addr){
	document.f.zip1.value = zip1;
	document.f.zip2.value = zip2;
	document.f.addr1.value = addr;
}


