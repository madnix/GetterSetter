<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 탑부분시작 -->
<jsp:include page="Top.jsp" />
<!-- 탑부분 끝 -->
</head>
<body>
<%-- <c:set var="user_id" value="${cuserdetail[0].id }"/> --%>
	<table align="center" width="80%">
		<%-- <c:forEach items="${cuserdetail}" var="userlist"> --%>
			<tr>
				<td align="right" width="10%">아이디:</td>
				<td align="left" width="30%">${usermassage.id }</td>
				<td align="right" width="10%">이름:</td>
				<td align="left" width="30%">${usermassage.name }</td>
			</tr>
			<tr>
				<td align="right">비밀번호 :</td>
				<td>${usermassage.pwd }</td>
				<td align="right">질문 :</td>
				<td>${usermassage.pwd_q }</td>
			</tr>
			<tr>
				<td align="right">답변 :</td>
				<td>${usermassage.pwd_a }</td>
				<td align="right">우편번호 :</td>
				<td>${usermassage.zip1 }-${usermassage.zip2 }</td>
			</tr>
			<tr>
				<td align="right">주소 :</td>
				<td colspan="3">${usermassage.addr1 }-${usermassage.addr2 }</td>
			</tr>
			<tr>
				<td align="right">핸드폰 :</td>
				<td>0${usermassage.phone1 }-${usermassage.phone2 }-${usermassage.phone3
					}</td>
				<td align="right">이메일 :</td>
				<td>${usermassage.email1 }@${usermassage.email2 }</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>

				<td colspan="2" align="center"><a
					href="cuserdetaillist.do?user_id=${usermassage.id }"> 구매성공리스트 </a></td>
				<td colspan="2" align="center"><a
					href="cuserdetaillistok.do?user_id=${usermassage.id }"> 구매신청리스트 </a></td>
			</tr>

		<%-- </c:forEach> --%>
	</table>

	<table align="center" width="70%">
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		<tr>
			<td width="10%" align="center">PROID</td>
			<td width="10%" align="center">PROUSER</td>
			<td width="10%" align="center">COUNT</td>
			<td width="10%" align="center">PRICE</td>
			<td width="10%" align="center">BANKNAME</td>
			<td width="10%" align="center">BANK</td>
			<td width="10%" align="center">DATE</td>
			<td width="10%"></td>
		</tr>
		<c:forEach items="${allproduct}" var="proout">
			<tr>
				<td align="center">${proout.product_id}</td>
				<td align="center">${proout.seller_user}</td>
				<td align="center">${proout.product_count}</td>
				<td align="center">${proout.product_count * proout.product_price}</td>
				<td align="center">${proout.buyer_name}</td>
				<td align="center">${proout.buyer_bank}</td>
				<td align="center">${fn:substring(proout.recevier_cartdate,0,10)}</td>
				<td align="center"><a
					href="productdetailepage.do?pro_id=${proout.product_id}&order_no=${proout.order_no}"> 상세보기 </a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center"><c:if test="${ count > 0 }">
					<c:set var="pageCount"
						value="${ count / pageSize + (count % pageSize == 0 ? 0 : 1)}" />

					<c:set var="startPage"
						value="${ pageGroupSize * ( numPageGroup-1) + 1 }" />
					<c:set var="endPage" value="${ startPage + pageGroupSize - 1 }" />

					<c:if test="${ endPage > pageCount }">
						<c:set var="endPage" value="${ pageCount }" />
					</c:if>

					<c:if test="${numPageGroup > 1}">
						<a
							href="./cuserdetaillistok.do?user_id=${usermassage.id}&pageNum=${(numPageGroup-2)*pageGroupSize+1 }">[이전]</a>
					</c:if>

					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="cuserdetaillistok.do?user_id=${usermassage.id}&pageNum=${i}"> [ <c:if
								test="${currentPage == i}"></c:if> ${i} ]
						</a>
					</c:forEach>

					<c:if test="${numPageGroup < pageGroupCount}">
						<a
							href="cuserdetaillistok.do?user_id=${usermassage.id}&pageNum=${numPageGroup*pageGroupSize+1}">[다음]</a>
					</c:if>
				</c:if></td>
		</tr>
	</table>

	<table align="center" width="80%">
		<tr>
			<td colspan="4" align="right"><a
				href="outmember.do?user_id=${usermassage.id }"> 회원탈퉤 </a></td>
		</tr>
	</table>
</body>
</html>