function searchid_check(){
	
	if($.trim($("#name").val())==""){
		alert("이름을 입력하세요!");
		$("#name").val("").focus();
		return false;
	}
	
	var regExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	
	if($.trim($("#email").val())==""){
		alert("이메일을 입력하세요!");
		$("#email").val("").focus();
		return false;
	}else if(!regExp.test($("#email").val())) {
		alert("이메일형식이 올바르지 않습니다.");
        return false;
    }else{
    	return true;
    }
}