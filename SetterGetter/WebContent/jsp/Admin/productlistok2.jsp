<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
							<td colspan="2" align="center"><a
								href="productlistok.do?pro_id=${productMassage.pro_id}"> 구매성공리스트 </a>
							</td>
							<td colspan="2" align="center"><a
								href="productlistok2.do?pro_id=${productMassage.pro_id}"> 구매신청리스트 </a></td>
						</tr>
					</table>
				</td>
			</tr>
			
		</table>
	<%-- </c:forEach> --%>
		<table align="center" width="72%" >
		<tr>
			<td colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<td width="8%" align="center">판매자</td>
			<td width="8%" align="center">구매자</td>
			<td width="8%" align="center">구매수량</td>
			<td width="8%" align="center">구매가격</td>
			<td width="8%" align="center">결제금액</td>
			<td width="8%" align="center">입금자</td>
			<td width="8%" align="center">계좌번호</td>
			<td width="8%" align="center">거래은행</td>
			<td width="8%"></td>
		</tr>
		<c:forEach items="${prolist}" var="proout">
			<tr>
				<td align="center">${proout.seller_user}</td>
				<td align="center">${proout.customer_id}</td>
				<td align="center">${proout.product_count}</td>
				<td align="center">${proout.product_price}</td>
				<td align="center">${proout.product_price * proout.product_count}</td>
				<td align="center">${proout.buyer_name}</td>
				<td align="center">${proout.buyer_banknumber}</td>
				<td align="center">${proout.buyer_bank}</td>
				<td align="center">
					<a href="productdetailepage.do?pro_id=${proout.product_id}&order_no=${proout.order_no}">
						상세보기
					</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9" align="center">
			<c:if test="${ count > 0 }">
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
						href="./productlistok2.do?pro_id=${productMassage.pro_id}&pageNum=${(numPageGroup-2)*pageGroupSize+1 }">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="productlistok2.do?pro_id=${productMassage.pro_id}&pageNum=${i}"> [ <c:if
							test="${currentPage == i}"></c:if> ${i} ]
					</a>
				</c:forEach>

				<c:if test="${numPageGroup < pageGroupCount}">
					<a href="productlistok2.do?pro_id=${productMassage.pro_id}&pageNum=${numPageGroup*pageGroupSize+1}">[다음]</a>
				</c:if>
			</c:if>
			</td>
		</tr>
	</table>
</body>
</html>