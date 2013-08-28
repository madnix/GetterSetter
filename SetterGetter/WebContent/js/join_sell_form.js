function reset_check(){
	document.f.reset(); //전체 리셋
}

function join_check(){
	if($.trim($("#id").val())==""){
		alert("아이디를 입력하세요.");
		$("#id").focus();	return false;
	}
	if($.trim($("#pwd").val())==""){
		alert("비밀번호를 입력하세요.");
		$("#pwd").focus();	return false;
	}
	if($.trim($("#pwd").val()) != $.trim($("#pwd_check").val())){
		alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
		$("#pwd_check").val("");		$("#pwd").val("").focus();	
		return false;0
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
	if($.trim($("#cor").val())==""){
		alert("회사명을 입력해주세요.");
		$("#cor").focus(); return false;
	}
	if($.trim($("#cor_name").val())==""){
		alert("대표자 이름을 입력해주세요.");
		$("#cor_name").focus(); return false;
	}
	if($.trim($("#cor_number").val())==""){
		alert("사업자번호를 입력해주세요.");
		$("#cor_number").focus(); return false;
	}
	if($.trim($("#cor_zip1").val())=="" || $.trim($("#cor_zip2").val())==""){
		alert("회사 소재지 우편번호를 선택해주세요.");
		$("#cor_btn").focus();	return false;
	}
	if($.trim($("#cor_addr2").val())=="" || $.trim($("#cor_addr2").val())==""){
		alert("상세주소를 입력해주세요.");
		$("#cor_addr2").focus();	return false;
	}
	if($.trim($("#cor_tel2").val())=="" && $.trim($("#cor_tel3").val())==""){
		alert("회사 전화번호를 입력해주세요.");
		$("#cor_tel2").focus(); return false;
	}
	if($.trim($("#cor_mail1").val())=="" || $.trim($("#cor_mail2").val())==""){
		alert("회사 이메일을 입력해주세요.");
		$("#cor_mail1").focus(); return false;
	}
	if(document.getElementById("checkbox").checked != true){
		alert("이용 약관에 동의하셔야 회원 가입이 가능합니다.");
		document.getElementById("checkbox").focus();
		return false;
	}
}


/* =============== 이메일 도메인 선택 시 =============== */
function select_email(){
	var selectObj = document.getElementById("email3");		// selectbox 개체를 가져온다.
	var idx = selectObj.selectedIndex;		// 현재 선택 되어진 seelctbox 인덱스값을 구한다.
	document.getElementById("email2").value = selectObj.options[idx].value;		// 인덱스의 값을 가져와서 값 대입
}

function select_cor_email(){
	var selectObj = document.getElementById("cor_mail3");
	var idx = selectObj.selectedIndex;
	document.getElementById("cor_mail2").value = selectObj.options[idx].value;
}

/* =============== 아이디 중복 체크 창 =============== */
function id_search(){
		alert("아이디 중복 체크를 해주세요.");
}
function id_check(){
	var win = window.open("idcheck.do", "id1", "width=450, height=164");
}

/* =============== 아이디 유효성체크 시작 ===============*/
var alogin = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
function checktype(v, alogin){
	var i;
	for(i=0; i<v.length; i++){
		if(alogin.indexOf(v.substring(i, i+1)) < 0){
			return false;
		}
	}
	return true;
}
function check(){
	var v = document.f.idcheck.value;
	var s = v.substr(0, 1);
	if($.trim($("#idcheck").val()) == ""){
		alert("아이디를 입력해주세요.");
		$("#idcheck").val("").focus();
		return false;
	}else if($.trim($("#idcheck").val()).length < 6){
		alert("아이디는 6자 이상입니다.")
		$("#idcheck").val("").focus();
		return false;
	}else if($.trim($("#idcheck").val()).length > 15){
		alert("아이디는 15자 미만입니다.")
		$("#idcheck").val("").focus();
		return false;
	}else if(!checktype(v, alogin)){
		alert("영문대소문자, 숫자, '_' 조합으로 입력해 주세요.");
		$("#idcheck").val("").focus();
		return false;
	}
}
/* =============== 아이디 유효성체크 끝 ===============*/



/* =============== 우편번호 검색 창 ===============*/
function post_check(chk){
	$("#zipbtnchk").val(chk);			// hidden으로 누른 button의 값을 저장해 논 상태. 위치를 알 수 있다. 
	var win = window.open("zipcode.do", "zip2", "width=450, height=200");
}

function test(zip1, zip2, addr) {
	if ($("#zipbtnchk").val() == 1){		// 만약 button의 onclick 옵션으로 1이 넘어오면
		document.f.zip1.value = zip1;
		document.f.zip2.value = zip2;
		document.f.addr1.value = addr;
	}else if($("#zipbtnchk").val() == 2){
		document.f.cor_zip1.value = zip1;
		document.f.cor_zip2.value = zip2;
		document.f.cor_addr1.value = addr;
	}
}


