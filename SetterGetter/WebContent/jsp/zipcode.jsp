<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>
<%
	String zipcode, addr1, addr2;
	String dong = (String)request.getAttribute("dong");
	List zipcodeList = (ArrayList)request.getAttribute("zipcodeList");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript">
function selectnow(){
	var zip = document.postform.post_list.value;
	var zip1 = zip.substring(0, 3);
	var zip2 = zip.substring(4, 7);
	var addr2 = zip.substring(7, (zip.length));
	
	//opener.document.f.zip1.value = zip1;
	//opener.document.f.zip2.value = zip2;
	//opener.document.f.addr1.value = addr2;
	opener.test(zip1, zip2, addr2);		// 상위 자바스크립 test function 에 주소값을 전달하고
	parent.window.close();				// 창을 닫는다
}
function check(){
	if($.trim($("#dong").val()) == ""){
		alert("읍, 면, 동, 리를 입력해주세요.");
		$("#dong").val("").focus();
		return false;
	}
}
</script>
<title>우편번호 검색</title>
</head>
<body onload="postform.dong.focus()">
	<form method="post" action="zipcode.do" name="postform" onsubmit="return check()">
		<table>
			<tr>
				<td>
					<span>거주지의 읍, 면, 동, 리를 입력하고 '찾기' 버튼을 누르세요.</span>
					<span>예)서울시 성동구 행당2동  ---->  행당2동</span>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" name="dong" id="dong" maxlength="10"/>&nbsp;&nbsp;
					<input type="submit" value="찾기" />
				</td>
			</tr>
			
			<%
				if( dong != null){
			%>
			<%
				if(zipcodeList != null && zipcodeList.size() != 0) {
			%>			
			<tr>
				<td>
					<select name="post_list" onchange="selectnow()" >
						<option value="">주소를 선택하세요</option>
						<%
							for(int i=0; i<zipcodeList.size(); i++){
								String data = (String)zipcodeList.get(i);
								StringTokenizer st = new StringTokenizer(data, ",");
								
								zipcode = st.nextToken();
								addr1 = st.nextToken();
								addr2 = st.nextToken();
								String totaladdr = zipcode + addr1;
						%>
						<option value="<%= totaladdr %>">
							[<%= zipcode %>]&nbsp;<%= addr2 %></option>
						<%
							}
						%>
					</select></td>
			</tr>
			<%
				} else {
			%>
			<tr>
				<td>
					<span>검색 결과가 없습니다.</span>
				</td>
			</tr>
		<% }} %>
		</table>
	
	</form>
	

</body>
</html>












