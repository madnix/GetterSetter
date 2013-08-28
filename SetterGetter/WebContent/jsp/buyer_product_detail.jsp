<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/detail.css" />

<title>Product View</title>

<!-- =========================================  header 시작 ========================================= -->
<jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->


<!-- detail list -->

<form action="buyer_product_detail_ok.do" method="post" name="f">
	<input type="hidden" name="order_no" value="${order_bean.order_no }">
	<input type="hidden" name="pro_id" value="${pro_bean.pro_id }">
	<input type="hidden" name="pro_count" value="${ order_bean.product_count }">
	<div id="detail">
		<div id="product_view">
			<p>조회수 : ${ pro_bean.pro_hit }</p>
			<p>
				<img src="./Upload/${ pro_bean.pro_detailTopImg }" alt="상품이미지"
					width="526" height="324" />
			</p>
		</div>
		<div id="product_add">
			<br />
			<p>${ pro_bean.pro_title }</p>
			<fieldset>
				<legend>상품구해하기 폼 </legend>
				<table summary="상품 구매 선택 목록입니다.">
					<caption>상품구매폼</caption>
					<tbody>
						<tr>
							<th scope="row"><strong>*</strong>소비자</th>
							<td>￦ ${ pro_bean.user_price }</td>
						</tr>
						<tr>
							<th scope="row"><strong>*</strong>남은 갯수</th>
							<td><span id="allcount"> ${ pro_bean.pro_count } </span>개</td>
						</tr>
						<tr>
							<th scope="row"><strong>*</strong>상품코드</th>
							<td>${ pro_bean.pro_id }</td>
						</tr>
						<tr>
							<th><strong>*</strong>거래수</th>
							<td class="end"><c:out value="${ pro_bean.pro_num }"></c:out></td>
						</tr>
						<tr>
							<th><strong>*</strong>조회수</th>
							<td><c:out value="${ pro_bean.pro_hit }"></c:out></td>
						</tr>
						<tr>
							<th><strong>*</strong>내용</th>
							<td>
							<c:out value="${fn:replace(item.pro_cont, ' ', '&nbsp;')}"escapeXml="false" />
							</td>
						</tr>
						
						
					</tbody>
				</table>
			</fieldset>

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
					</tr>
				</tbody>
			</table>
		</div>

		<div id="p_info">
			<table summary="구매자수정정보" border="1">
				<caption>상품상세보기</caption>
				<tbody>
					<tr>
						<th><strong>*</strong>수취인이름</th>
						<td class="end"><c:out value="${ order_bean.recevier_name }"></c:out></td>

						<th><strong>*</strong>전화번호</th>
						<td><c:out
								value="0${ order_bean.recevier_tel1 }-${ order_bean.recevier_tel2 }-${ order_bean.recevier_tel3 }"></c:out></td>
					</tr>
					<tr>
						<th scope="row"><strong>*</strong>구매수량</th>
							<td>${ order_bean.product_count }</td>
							
							<th scope="row"><strong>*</strong>결제금액</th>
							<td>${ order_bean.product_count *  order_bean.product_price}</td>
					</tr>
					<tr>
							<th scope="row"><strong>*</strong>거래은행</th>
							<td>${ order_bean.buyer_bank }</td>
				
							<th scope="row"><strong>*</strong>입금자명</th>
							<td>${ order_bean.buyer_name }</td>
						</tr>
					<tr>
						<th scope="row"><strong>*</strong>계좌번호</th>
						<td>${ order_bean.buyer_banknumber }</td>
							
						<th><strong>*</strong>우편번호</th>
						<td class="end"><c:out
								value="${ order_bean.recevier_zip1 }-${ order_bean.recevier_zip2 }"></c:out>
						</td>
					</tr>
					<tr class="botton">
						<th><strong>*</strong>주소</th>
						<td colspan="3"><c:out
								value="${ order_bean.recevier_addr1 }-${ order_bean.recevier_addr2 }"></c:out></td>

					</tr>
					<tr>
						<th><strong>*</strong>배송내용</th>
						<td colspan="3"><c:out value="${ order_bean.recevier_help }"></c:out></td>
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
	</div>
	<p>
		<input type="submit" value="등록하기" class="submit" >
	</p>
</form>
<!-- //detail list -->


<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />
<!-- =============================== footer 끝 ===============================-->