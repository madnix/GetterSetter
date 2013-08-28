<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="././js/jquery.js"></script>
<script type="text/javascript">
	function check(){
		if($.trim($("#adminreply").val()) == ""){
			alert("관리자 답변을 입력하세요");
			$("#adminreply").val("").focus();
			return false;
		}
	}
</script>
<!-- 탑부분시작 -->
<jsp:include page="Top.jsp" />
<!-- 탑부분 끝 -->

</head>
<body>
<form action="receptproduct.do" method="post">
	<input type="hidden" name="pro_id" value="${productMassage.pro_id}">
	<%-- <c:set var="pro_id" value="${prolist[0].pro_id }"/>
	<c:forEach items="${prolist }" var="item"> --%>
		<table align="center" width="80%" >
		
			<tr>
				<td align="left"> 
					<img src="Upload${productMassage.pro_listImg }" width="230" height="250">
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" >
						<tr>
							<td rowspan="6" width="40%">
								<img src="Upload${productMassage.pro_detailTopImg }" width="526" height="324">							
							</td>
						</tr>
						<tr>
							<th width="15%" align="right">제목:</th>
							<td width="45%">${productMassage.pro_title }</td>
						</tr>
						<tr>
							<th align="right">판매가:</th>
							<td>${productMassage.pro_price } 원</td>
						</tr>
						<tr>
							<th align="right">소비자가:</th>
							<td>${productMassage.user_price } 원</td>
						</tr>
						<tr>
							<th align="right">수량:</th>
							<td>${productMassage.pro_count } 개</td>
						</tr>
						<tr>
							<th rowspan="3" align="right">설명:</th>
							<td rowspan="3"><c:out
									value="${fn:replace(productMassage.pro_cont, ' ', '&nbsp;')}"
									escapeXml="false" /></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<table width="100%" >
						<tr>
							<td align="right" width="20%">상품종류:</td>
							<td align="center" width="30%">${productMassage.species_id}</td>
							<td align="right" width="20%">상품상태:</td>
							<td align="center" width="30%">${item.pro_status }</td>
							
						</tr>
						<tr>
							<td align="right" width="20%">원산지:</td>
							<td align="center" width="30%">${productMassage.pro_origin }</td>
							<td align="right" width="20%">브랜드:</td>
							<td align="center" width="30%">${productMassage.pro_brand }</td>
						</tr>
						<tr>
							<td align="right" width="20%">영수증:</td>
							<td align="center" width="30%">${productMassage.pro_receipt }</td>
							<td align="right" width="20%">제조사:</td>
							<td align="center" width="30%">${productMassage.pro_make }</td>
						</tr>
						<tr>
							<td align="right" width="20%">A/S안내:</td>
							<td align="center" width="30%">${productMassage.pro_as}</td>
							<td align="right" width="20%">제품번호:</td>
							<td align="center" width="30%">${productMassage.pro_id}</td>
						</tr>
						<tr>
							<td align="right" width="20%">거래은행:</td>
							<td align="center" width="30%">${productMassage.pro_bank}</td>
							<td align="right" width="20%">계좌번호:</td>
							<td align="center" width="30%">${productMassage.pro_banknum}</td>
						</tr>
						<tr>
							<td align="right" width="20%" >관리자답변:</td>
							<td align="center" width="30%">
								<input name = "adminreply" id="adminreply" size="50">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<img  src="Upload${productMassage.pro_detailImg }" width="866" height="3132">
				</td>
			</tr>
			<tr>
				<td colspan="5" align="center">
					<input type="button" value="등록" onclick="location='insertproductok.do?pro_id=${productMassage.pro_id}'">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="취소" onclick="return check()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>