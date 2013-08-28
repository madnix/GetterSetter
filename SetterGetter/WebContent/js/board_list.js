//function boardSearch(){
//	var board_s = document.f;
//	board_s.action = "board_search.do";
//	board_s.method = "post";
//	board_s.submit();
//}
function boardSearch(){
	if($.trim($("#search").val())==""){
		alert("검색어를 입력하시오");
		$("#search").val("").focus();
		return false;
	}
}