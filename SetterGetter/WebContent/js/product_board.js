function product_board(){
	if($.trim($("#cont").val())==""){
		alert("내용을 입력하시오.");
		$("#cont").val("").focus();
		return false;
	}
	if($.trim($("#name").val())==""){
		alert("이름을 입력하시오.");
		$("#name").val("").focus();
		return false;
	}
	if(((document.getElementById("appraisal1").checked) || (document.getElementById("appraisal2").checked) || (document.getElementById("appraisal3").checked) || (document.getElementById("appraisal4").checked) || (document.getElementById("appraisal5").checked)) != true){
		alert("평점 선택하시오.");
		document.getElementById("appraisal1").focus();
		return false;
	}
}


/* checkBox 하나만 선택가능하게 */
function checkBoxValidate(check) {
	for (j = 0; j < 5; j++) {
		if (eval("document.product_f.appraisal[" + j + "].checked") == true) {
			document.product_f.appraisal[j].checked = false;
			if (j == check) {
				document.product_f.appraisal[j].checked = true;
			}
		}
	}
}

/* 삭제 메소드 post방식으로 넘길때 */
function productDel(){
	var product_del = document.product_f;
	product_del.action = "product_comment_del.do";
	product_del.method = "post";
	product_del.submit();
}

