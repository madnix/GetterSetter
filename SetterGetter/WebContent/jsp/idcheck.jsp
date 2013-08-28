<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = (String) request.getAttribute("id");
	if(id==null){
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 체크</title>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/join_buy_form.js"></script>
</head>
<body onload="f.idcheck.focus()">
	<form method="post" name="f" action="idcheck.do" onsubmit="return check()">
		<table>
			<tr>
				<td>
					<span>원하시는 아이디를 입력하세요.</span>
					<input type="text" name="idcheck" id="idcheck" maxlength="15" />
					<input type="submit" value="확인" />				
				</td>
			</tr>
		
		</table>
	</form>
</body>
</html>
<%
	} else {
%>
<html>
<head>
<title>아이디 중복 체크</title>
<script type="text/javascript" >
function id_close(id){
	opener.document.f.id.value = id;
	self.close();
}
</script>
</head>
<body>
	<table>
		<tr>
			<td>입력하신 [ ${ id } ]는 사용하실 수 있는 아이디입니다.
		</tr>
		<tr>
			<td><input type="button" value="사용하기" onclick="id_close('${ id }');" />
		</tr>
	</table>
</body>
</html>
<% } %>