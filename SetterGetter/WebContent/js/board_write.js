//function reset_check(){
//	document.firstChild.reset();	//전체 리셋
//}

function reset_check(){
	document.getElementById("f").reset();
}

function board_write(){
	if($.trim($("#title").val())==""){
		alert("제목을 입력하시오.");
		$("#title").val("").focus();
		return false;
	}
	if($.trim($("#name").val())==""){
		alert("이름을 입력하시오.");
		$("#name").val("").focus();
		return false;
	}
	if($.trim($("#email1").val())==""){
		alert("메일주소를 입력하시오.");
		$("#email1").val("").focus();
		return false;
	}
	if($.trim($("#email2").val())==""){
		alert("메일주소를 입력하시오.");
		$("#email2").val("").focus();
		return false;
	}
	if($.trim($("#cont").val())==""){
		alert("내용을 입력하시오.");
		$("#cont").val("").focus();
		return false;
	}
	if($.trim($("#pwd").val())==""){
		alert("비밀번호를 입력하시오.");
		$("#pwd").val("").focus();
		return false;
	}
	if(((document.getElementById("secret1").checked) || (document.getElementById("secret2").checked)) != true){
		alert("비밀글을 설정하시오.");
		document.getElementById("secret1").focus();
		document.getElementById("secret2").focus();
		return false;
	}
	if(((document.getElementById("secret1").checked) ^ (document.getElementById("secret2").checked)) != true){
		alert("둘중 하나만 설정하시오.");
		document.getElementById("secret1").focus();
		document.getElementById("secret2").focus();
		return false;
	}
	if((document.getElementById("check").checked) != true){
		alert("개인 정보취급방침에 동의하시오.");
		document.getElementById("check").focus();
		return false;
	}
}


/*	=======================	이메일 도메인 선택	===========================	*/
function select_email(){
	var selectObj = document.getElementById("email3");	//selectbox 객체를 가져온다.
	var idx = selectObj.selectedIndex;					//현재 선택 되어진 selectbox 인덱스 값을 구한다.
	document.getElementById("email2").value = selectObj.options[idx].value;	//인덱스의 값을 가져와서 값 대입
}