<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/myorder.css" />
<title>구매 목록 현황</title>


<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

<div id="myorder">
<table border="0" cellspacing="0" width="100%" summary="내가 주문한 상품리스트" class="order_table">
		<caption>주문리스트</caption>
		<colgroup>
			<col width="10%" />
			<col width="10%" />
			<col width="*" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">이미지</th>
				<th scope="col">상품명</th>
				<th scope="col">판매단가</th>
				<th scope="col">수량</th>
				<th scope="col">소계금액</th>
				<th scope="col">주문날짜</th>
				<th scope="col">주문현황</th>
			</tr>
			<tbody>
			<c:forEach items="${ orderList }" var="list">
				<tr>
					<td>${ list.order_no }</td>
					<td><img src="./Upload/${ list.product_listImg }" width="50"
						height="50"></td>
					<td>${ list.product_name }</td>
					<td>￦ ${ list.product_price }</td>
					<td>${ list.product_count }</td>
					<td>￦ ${ list.product_price * list.product_count }</td>
					<td>${ list.recevier_buydate }</td>
					<c:choose>
						<c:when test="${ list.deal_check == 0}">
							<td>구매신청 중</td>
						</c:when>
						<c:when test="${ list.deal_check == 3}">
							<td>구매완료</td>
						</c:when>
						<c:otherwise>
							<td>구매실패</td>
						</c:otherwise>
					</c:choose>

				</tr>
			</c:forEach>
			</tbody>
	</table>
</div>
<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->
