var match = /[^0-9]/;

function checkbank(){
	if($.trim($("#bankname").val()) == ""){
		alert("입금자 명을 입력하세요");
		$("#bankname").val("").focus();
		return false;
	}
	
	if($.trim($("#bank").val()) == ""){
		alert("은행을 선택하세요");
		$("#bank").val("").focus();
		return false;
	}
	
	if(document.f.bank.value == "우리은행"){
		window.open("http://pib.wooribank.com/common/remoteLoginCtl.jsp?target=http://pib.wooribank.com/pib/cus/wpcus900_01t.jsp");
		return false;
	}
	
	if(document.f.bank.value == "국민은행"){
		window.open("https://obank.kbstar.com/quics?page=obank");
		return false;
	}
	
	if(document.f.bank.value == "기업은행"){
		window.open("http://mybank.ibk.co.kr/");
		return false;
	}
	
	if(document.f.bank.value == "농협은행"){
		window.open("http://banking.nonghyup.com/nhbank.html");
		return false;
	}
}

function check(){
	if($.trim($("#bankname").val()) == ""){
		alert("입금자 명을 입력하세요");
		$("#bankname").val("").focus();
		return false;
	}
	
	if($.trim($("#bank").val()) == ""){
		alert("은행을 선택하세요");
		$("#bank").val("").focus();
		return false;
	}

}

function post_check(chk){
	$("#zipbtnchk").val(chk);
	var win = window.open("zipcode.do", "zip2", "width=450, height=200");
}
function test(zip1, zip2, addr){
	document.f.order_zip1.value = zip1;
	document.f.order_zip2.value = zip2;
	document.f.order_addr1.value = addr;
}


