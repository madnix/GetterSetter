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
	 <table width="95%" align="center">
		<tr>
			<td align="center" width="10%">ID</td>
			<td align="center" width="25%">TITLE</td>
			<td align="center" width="5%">COUNT</td>
			<td align="center" width="5%">PRICE</td>
			<td align="center" width="5%">PUSER</td>
			<td align="center" width="5%">CUSER</td>
			<td align="center" width="10%">BANK</td>
			<td align="center" width="10%">BANKNAME</td>
			<td align="center" width="10%">DATE</td>
			<td align="center" width="10%"></td>
		</tr>
		<c:forEach items="${receptionList}" var="rlist">
			<tr>
				<td align="center">${rlist.product_id }</td>
				<td align="center">${rlist.product_name }</td>
				<td align="center">${rlist.product_count }</td>
				<td align="center">${rlist.product_price }</td>
				<td align="center">${rlist.customer_id }</td>
				<td align="center">${rlist.seller_user }</td>
				<td align="center">${rlist.buyer_bank }</td>
				<td align="center">${rlist.buyer_name }</td>
				<th align="center">${fn:substring(rlist.recevier_cartdate,2,10)}</th>
				<td align="center">
					<a href="checkoutlistdetail.do?pro_id=${rlist.product_id }&cart_no=${rlist.order_no }">
						상세보기
					</a>
				</td>
			</tr>
		</c:forEach>

		<tr align="center">
			<td colspan="10"><c:if test="${ count > 0 }">
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
							href="./checkout.do?pageNum=${(numPageGroup-2)*pageGroupSize+1 }">[이전]</a>
					</c:if>

					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="checkout.do?pageNum=${i}"> [ <c:if
								test="${currentPage == i}"></c:if> ${i} ]
						</a>
					</c:forEach>

					<c:if test="${numPageGroup < pageGroupCount}">
						<a href="checkout.do?pageNum=${numPageGroup*pageGroupSize+1}">[다음]</a>
					</c:if>
				</c:if></td>
		</tr>

	</table> 

</body>
</html>