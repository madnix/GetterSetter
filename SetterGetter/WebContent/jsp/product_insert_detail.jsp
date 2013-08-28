<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product delete View</title>
<link rel="stylesheet" type="text/css" href="./css/detail.css" />

</head>
<body>
	<!-- =========================================  header 시작 ========================================= -->
	<jsp:include page="header.jsp" />
	<!-- =========================================  header 끝 ========================================= -->

	<jsp:include page="menu.jsp" />
	<div id="detail">
		<c:forEach items="${userlist }" var="pro_bean">

			<a href="product_application_delete.do?id=${ pro_bean.pro_id }">물품삭제</a> &nbsp;
		
	      	
			<div id="product_view">
				<p>조회수 : ${ pro_bean.pro_hit }</p>
				<p>
					<img src="./Upload/${ pro_bean.pro_listImg }" alt="상품이미지"
						width="526" height="324" />
				</p>
			</div>
			<div id="product_add">
				<br />
				<p>${ pro_bean.pro_title }</p>
				<form action="product_view.do" method="post" name="f"
					onsubmit="return optionChk()">
					<input type="hidden" name="pro_id" value="${ pro_bean.pro_id }">
					<fieldset>
						<legend>상품구해하기 폼 </legend>
						<table summary="상품 구매 선택 목록입니다.">
							<caption>상품구매폼</caption>
							<tbody>
								<tr>
									<th scope="row"><strong>*</strong>판매가</th>
									<td>￦ <span id="price"> ${ pro_bean.pro_price } </span>
									</td>
								</tr>
								<tr>
									<th scope="row"><strong>*</strong>소비자</th>
									<td>￦ ${ pro_bean.user_price }</td>
								</tr>
								<tr>
									<th scope="row"><strong>*</strong>갯수</th>
									<td><span id="allcount"> ${ pro_bean.pro_count } </span>개
									</td>
								</tr>
								<tr>
									<th scope="row"><strong>*</strong>상품코드</th>
									<td>${ pro_bean.pro_id }</td>
								</tr>
								<tr>
									<th scope="row">관리자답변:</th>
									<td>등록성공</td>
								</tr>
								<tr>
									<th scope="row">상품설명:</th>
									<td id="pro_cont"><c:out
											value="${fn:replace(item.pro_cont, ' ', '&nbsp;')}"
											escapeXml="false" /></td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</form>
			</div>

			<!-- p_info -->
			<div id="p_info">
				<table summary="상품정보리스트">
					<caption>상품상세보기</caption>
					<tbody>
						<tr>
							<th><strong>*</strong>상품종류</th>
							<td><c:out value="${ pro_bean.species_id }"></c:out></td>

							<th><strong>*</strong>상품상태</th>
							<td class="end"><c:out value="${ pro_bean.pro_status }"></c:out></td>
						</tr>

						<tr>
							<th><strong>*</strong>원산지</th>
							<td><c:out value="${ pro_bean.pro_origin }"></c:out></td>

							<th><strong>*</strong>브랜드</th>
							<td class="end"><c:out value="${ pro_bean.pro_brand }"></c:out>
							</td>
						</tr>
						<tr>
							<th><strong>*</strong>영수증 발급</th>
							<td><c:out value="${ pro_bean.pro_receipt }"></c:out></td>

							<th><strong>*</strong>제조사</th>
							<td class="end"><c:out value="${ pro_bean.pro_make }"></c:out>
							</td>
						</tr>
						<tr class="botton">
							<th><strong>*</strong>A/S안내</th>
							<td><c:out value="${ pro_bean.pro_as }"></c:out></td>

							<th><strong>*</strong>콜센터</th>
							<td class="end"></td>
						</tr>
						<tr>
							<th><strong>*</strong>거래수</th>
							<td class="end"><c:out value="${ pro_bean.pro_num }"></c:out></td>

							<th><strong>*</strong>조회수</th>
							<td><c:out value="${ pro_bean.pro_hit }"></c:out></td>
						</tr>
						<tr>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- //p_info --- -->
			<p>
				<img src="./Upload/${ pro_bean.pro_detailImg }" alt="상품 상세이미지 " />
			</p>
		</c:forEach>
	</div>

	<!-- =============================== footer 시작 ===============================-->
	<jsp:include page="footer.jsp" />
	<!-- =============================== footer 끝 ===============================-->
</body>
</html>