function fileUploadPreview(thisObj, preViewer) {
	if (!/(\.gif|\.jpg|\.jpeg|\.png)$/i.test(thisObj.value)) {
		alert("이미지 형식의 파일을 선택하십시오");
		thisObj.value.focus();
		return false;
	}

	preViewer = (typeof (preViewer) == "object") ? preViewer : document
			.getElementById(preViewer); //div id
	var ua = window.navigator.userAgent;

	if (ua.indexOf("MSIE") > -1) { //ie일때
		var img_path = "";
		if (thisObj.value.indexOf("\\fakepath\\") < 0) {
			img_path = thisObj.value;
		} else {
			thisObj.select();
			var selectionRange = document.selection.createRange();
			img_path = selectionRange.text.toString();
			thisObj.blur();
		}
		preViewer.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='fi"
				+ "le://" + img_path + "', sizingMethod='scale')";
	} else {
		preViewer.innerHTML = "";
		var W = preViewer.offsetWidth;
		var H = preViewer.offsetHeight;
		var tmpImage = document.createElement("img");
		preViewer.appendChild(tmpImage);

		tmpImage.onerror = function() {
			return preViewer.innerHTML = "";
		}

		tmpImage.onload = function() {
			if (this.width > W) {
				this.height = this.height / (this.width / W);
				this.width = W;
			}
			if (this.height > H) {
				this.width = this.width / (this.height / H);
				this.height = H;
			}
		}
		if (ua.indexOf("Firefox/3") > -1) {
			var picData = thisObj.files.item(0).getAsDataURL();
			tmpImage.src = picData;
		} else {
			tmpImage.src = "file://" + thisObj.value;
		}
	}
}

var match = /[^0-9]/;
var match2 = /^[0-9]-[0-9]-[0-9]-[0-9]$/;
function check() {
	if(document.getElementById("listImg").value == ""){
		alert("리스트 이미지를 확인하세요");
		document.getElementById("listImg").focus();
		return false;
	}
	
	if(document.getElementById("detailTopImg").value == ""){
		alert("상세정보 이미지를 확인하세요");
		document.getElementById("detailTopImg").focus();
		return false;
	}
	
	if(document.getElementById("pro_title").value == ""){
		alert("제목을 입력하세요");
		document.getElementById("pro_title").focus();
		return false;
	}
	
	if (document.getElementById("pro_title").value.length >= 15) {
		alert("제목은 15자이내 입니다.");
		document.getElementById("pro_title").focus();
		return false;
	}
	
	if (document.getElementById("pro_price").value == "") {
		alert("가격을 입력하세요");
		document.getElementById("pro_price").focus();
		return false;
	}
	
	var var_value = document.getElementById("pro_price").value;
	if (match.test(var_value) == true) {
		alert("가격은 숫자만 입력할수 있습니다!");
		document.getElementById("pro_price").focus();
		return false;
	}
	
	if (document.getElementById("user_price").value == "") {
		alert("소비자 가격을 입력하세요");
		document.getElementById("user_price").focus();
		return false;
	}
	
	var var_value = document.getElementById("user_price").value;
	if (match.test(var_value) == true) {
		alert("소비자 가격은 숫자만 입력할수 있습니다!");
		document.getElementById("user_price").focus();
		return false;
	}
	
	if (document.getElementById("pro_count").value == "") {
		alert("개수를 입력하세요");
		document.getElementById("pro_count").focus();
		return false;
	}
	
	var var_value = document.getElementById("pro_count").value;
	if (match.test(var_value) == true) {
		alert("개수는 숫자만 입력할수 있습니다!");
		document.getElementById("pro_count").focus();
		return false;
	}
	
	if (document.getElementById("pro_cont").value.length > 40) {
		alert("내용은 40자 이내입니다");
		document.getElementById("pro_cont").focus();
		return false;
	}
	
	if (document.getElementById("species_id").value=="") {
		alert("제품종류를 선택하세요");
		document.getElementById("species_id").focus();
		return false;
	}
	
	if (document.getElementById("pro_status").value=="") {
		alert("제품상태를 선택하세요");
		document.getElementById("pro_status").focus();
		return false;
	}
	
	if (document.getElementById("pro_origin").value=="") {
		alert("원산지를 선택하세요");
		document.getElementById("pro_origin").focus();
		return false;
	}
	
	if (document.getElementById("pro_brand").value=="") {
		alert("브랜드를 입력하세요");
		document.getElementById("pro_brand").focus();
		return false;
	}
	
	if (document.getElementById("pro_receipt").value=="") {
		alert("영수증 발급을 선택하세요");
		document.getElementById("pro_receipt").focus();
		return false;
	}
	
	if (document.getElementById("pro_make").value=="") {
		alert("제조사를 입력하세요");
		document.getElementById("pro_make").focus();
		return false;
	}
	
	if (document.getElementById("pro_as").value=="") {
		alert("A/S 를 선택하세요");
		document.getElementById("pro_as").focus();
		return false;
	}
	
	if (document.getElementById("detaileImg").value=="") {
		alert("상세 이미지를 선택하세요");
		document.getElementById("detaileImg").focus();
		return false;
	}
	
	if (document.getElementById("pro_banknum").value=="") {
		alert("계좌번호를 입력하세요 ");
		document.getElementById("pro_banknum").focus();
		return false;
	}
	
	var var_value = document.getElementById("pro_banknum").value;
	if (match.test(var_value) == true) {
		alert("계좌번호는 숫자만 입력가능 합니다");
		document.getElementById("pro_banknum").focus();
		return false;
	}
	
	var var_value = document.getElementById("pro_banknum").value;
	if (match2.test(var_value) == true) {
		alert("계좌번호의 형식을 확인하세요");
		document.getElementById("pro_banknum").focus();
		return false;
	}
	
	if (document.getElementById("pro_bank").value=="") {
		alert("거래 은행을 선택하세요");
		document.getElementById("pro_bank").focus();
		return false;
	}
}
