var match = /[^0-9]/;

function checkcount(){
	var userCount = parseInt(document.f.count.value);
	var price = parseInt($("#price").text());
	$("#result").text(userCount * price);
}

function optionChk(){
	
	if($.trim($("#count").val()) == 0){
		alert("구매수를 선택하세요");
		$("#count").val("").focus();
		return false;
	}
	
	if(parseInt($.trim($("#count").val())) > parseInt($.trim($("#allcount").text()))) {
		alert("구매수가 초과 했습니다");
		$("#count").val("").focus();
		return false;
	}
	var var_value = document.getElementById("count").value;
	if (match.test(var_value) == true) {
		alert("개수는 숫자만 입력할수 있습니다!");
		$("#count").val("").focus();
		return false;
	}
	
}

























