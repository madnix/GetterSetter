var match = /[^0-9]/;
var match2 = /^[0-9]{2,3},[0-9]{3,4},[0-9]{4}/; // 나중에 가격 처리 

function check() {

	if ($.trim($("#pro_title").val()) == "") {
		alert("제목을 입력하세요.");
		$("#pro_title").focus();
		return false;
	}

	if (document.getElementById("pro_title").value.length >= 15) {
		alert("제목은 15자이내 입니다.");
		$("#pro_title").focus();
		return false;
	}

	if ($.trim($("#pro_img1").val()) == "") {
		alert("이미지를 확인하세요");
		$("#pro_img1").focus();
		return false;
	}
	
	/*if ($.trim($("#pro_img2").val()) == "") {
		alert("이미지를 확인하세요");
		$("#pro_img2").focus();
		return false;
	}*/

	if ($.trim($("#pro_cont").val()) == "") {
		alert("제품내용을 확인하세요");
		$("#pro_cont").focus();
		return false;
	}

	if ($.trim($("#species_cont").val()) == "") {
		alert("종류 설명이 필요합니다");
		$("#species_cont").focus();
		return false;
	}
	
	if ($.trim($("#species_id").val()) == "") {
		alert("제품 종류를 선택하세요");
		$("#species_id").focus();
		return false;
	}

	if (document.getElementById("species_cont").value.length >= 10) {
		alert("설명은 10자내입니다");
		$("#species_cont").focus();
		return false;
	}

	if ($.trim($("#pro_size").val()) == "") {
		alert("싸이즈를 입력하세요");
		$("#pro_size").focus();
		return false;
	}

	if ($.trim($("#pro_num").val()) == "") {
		alert("개수를 입력하세요");
		$("#pro_num").focus();
		return false;
	}
	
	var var_value = document.getElementById("pro_num").value;
	if (match.test(var_value) == true) {
		alert("개수는 숫자만 입력할수 있습니다!");
		$("#pro_num").focus();
		return false;
	}
	
	if ($.trim($("#pro_price").val()) == "") {
		alert("가격을 입력하세요");
		$("#pro_price").focus();
		return false;
	}
	
	var var_value = document.getElementById("pro_price").value;
	if (match.test(var_value) == true) {
		alert("정확한 가격을 입력하세요");
		$("#pro_price").focus();
		return false;
	}
}