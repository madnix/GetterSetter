<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/productok.css" />

<script type="text/javascript" src="./js/product_input_view_ok.js"></script>
<script type="text/javascript" src="./js/jquery.js"></script>

<script type="text/javascript">
	// ------------------
	// 새로운 배송지 입력
	// ------------------
	jQuery(document).ready(function(){
		jQuery("#order_check").click(function(){
			if($("input:checkbox[name=order_check]").is(":checked")==true){
				$("#order_name").val("");				$("#order_zip1").val("");
				$("#order_zip2").val("");				$("#order_addr1").val("");
				$("#order_addr2").val("");
				$("#order_phone1").val("010");				$("#order_phone2").val("");
				$("#order_phone3").val("");
			}else if($("input:checkbox[name=order_check]").is(":checked")==false){
				$("#order_name").val($("#name").val());				$("#order_zip1").val($("#zip1").val());
				$("#order_zip2").val($("#zip2").val());				$("#order_addr1").val($("#addr1").val());
				$("#order_addr2").val($("#addr2").val());
				$("#order_phone1").val($("#phone1").val());			$("#order_phone2").val($("#phone2").val());
				$("#order_phone3").val($("#phone3").val());
			}
		});
	});
</script>


<!-- =========================================  header 시작 ========================================= -->
<jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->
 <div id="product_ok">	
	<c:set var="final_price2" value="0" scope="session" />	
	<form action="order_ask.do" method="post" onsubmit="return check()" name="f">
		<input type="hidden" name="cart_order_type" id="cart_order_type" value="${ cart_order_type }" />	<!-- 장바구니에서 주문 1, 바로직접구매 2 -->
		<input type="hidden" name="kkValue" id="kkValue" value="${ kkValue }" />	<!-- 장바구니일 경우 장바구니 제품 번호(문자열) -->
		<div id="p_list">					
		<table border="0" cellspacing="0" width="100%" summary="결재상품리스트">
			<caption>결재페이지</caption>
			<colgroup>
				<col width="10%" />
				<col width="*" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
			</colgroup>
			<thead>
				<tr>
					<th scope="col">이미지</th>
					<th scope="col">상품명</th>
					<th scope="col">가격</th>
					<th scope="col">수량</th>
					<th scope="col">소계금액</th>
					<th scope="col">판매자</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ prolist }" var="item">
				<!-- 루프만큼 jstl 태그로 합계더하기 -->
				<c:set var="final_price" value="${item.product_count * item.product_price}"/> 
				<c:set var="final_price2" value="${final_price2 + final_price }" />
				
				<!-- 바로구매에서 넘어올 때  hidden으로 감춤-->
				<input type="hidden" name="product_id" id="product_id" value="${ item.product_id }" />
				<input type="hidden" name="product_listImg" id="product_listImg" value="${ item.product_listImg }" />
				<input type="hidden" name="product_name" id="product_name" value="${ item.product_name }" />
				<input type="hidden" name="product_price" id="product_price" value="${ item.product_price }" />
				<input type="hidden" name="product_count" id="product_count" value="${ item.product_count }" />
				<input type="hidden" name="seller_user" id="seller_user" value="${ item.seller_user }" />
				<!-- 바로구매에서 넘어올 때  hidden으로 감춤-->
				
				<tr>
					<td>
						<img src="./Upload/${ item.product_listImg }" width="50" height="50">
					</td>
					<td>${item.product_name }</td>
					<td>￦ ${item.product_price }</td>
					<td>${item.product_count}</td>
					<td>
						<span id="result">
							￦ ${item.product_count * item.product_price}
						</span>
					</td>
					<td align="center">${item.seller_user}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

<!-- 주문하시는 분 -->
	<div id="oder_add">
	<h3>주문자 정보</h3>
		<table  border="0" cellspacing="0" summary="주문자정보입력폼" class="o_info">
		<caption>주문자정보 입력폼</caption>
		<tbody>
			<tr>
				<th scope="row">주문자</th>
				<td>${ userlist.name }
					<input type="hidden" id="name" class="textBox" value="${ userlist.name }" /></td>
			</tr>
			
			<tr>
				<th>주소</th>
				<td><input name="zip1" id="zip1" class="textBox" maxlength="3" size="4" value="${userlist.zip1 }" readonly="readonly"/> -
					<input name="zip2" id="zip2" class="textBox" maxlength="3" size="4" value="${userlist.zip2 }" readonly="readonly"/>
					<input type="button" id="zip_btn" value="우편번호" onclick="post_check(1)" disabled="disabled"/><br/>
					<input name="addr1" id="addr1" class="textBox" size="30" value="${userlist.addr1 }" readonly="readonly" /><br/>
					<input name="addr2" id="addr2" class="textBox" size="30" value="${userlist.addr2 }" readonly="readonly"/>
				</td>
			</tr>
			
			<tr>
				<th class="info_list">이메일</th>
				<td><input name="email1" id="email1" class="textBox" value="${ userlist.email1 }" /> @ <input name="email2" id="email2" class="textBox" value="${ userlist.email2 }"/></td>
			</tr>
			
			<tr>
				<th>휴대전화</th>
				<td><select name="phone1" id="phone1">
					<option value="010" <c:if test="${ userlist.phone1 == '010' }"><c:out value="selected" /></c:if>>010</option>
					<option value="011" <c:if test="${ userlist.phone1 == '011' }"><c:out value="selected" /></c:if>>011</option>
					<option value="016" <c:if test="${ userlist.phone1 == '016' }"><c:out value="selected" /></c:if>>016</option>
					<option value="019" <c:if test="${ userlist.phone1 == '019' }"><c:out value="selected" /></c:if>>019</option>
				</select>-<input name="phone2" id="phone2" class="textBox" value="${ userlist.phone2 }" maxlength="4"/> - <input name="phone3" id="phone3" class="textBox" value="${ userlist.phone3 }" maxlength="4"/>
				</td>
			</tr>		
			</tbody>
		</table>
		</div>

<!-- 받으실 분 -->
		
		<div id="send_add">
		<p class="jumun"><input type="checkbox" name="order_check" id="order_check" /> 새로운 주소</p>
		<h3>배송지 정보</h3>
		<table  border="0" cellspacing="0" summary="받는사람정보입력" class="s_info">
		<caption>받는분 입력폼</caption>
		<tbody>
			<tr>
				<th scope="row">받으실 분</th>
				<td><input name="order_name" id="order_name" class="textBox" value="${ userlist.name }"/></td>
			</tr>
			
			<tr>
				<th>주소</th>
				<td><input name="order_zip1" id="order_zip1" class="textBox" maxlength="3" size="4" value="${userlist.zip1 }" /> -
					<input name="order_zip2" id="order_zip2" class="textBox" maxlength="3" size="4" value="${userlist.zip2 }" />
					<input type="button" id="order_zip_btn" value="우편번호" onclick="post_check(1)" /><br/>
					<input name="order_addr1" id="order_addr1" class="textBox" size="30" value="${userlist.addr1 }" /><br/>
					<input name="order_addr2" id="order_addr2" class="textBox" size="30" value="${userlist.addr2 }" />
			    </td>
			</tr>
						
			<tr>
				<th>휴대전화</th>
				<td><select name="order_phone1" id="order_phone1">
					<option value="010" <c:if test="${ userlist.phone1 == '010' }"><c:out value="selected" /></c:if>>010</option>
					<option value="011" <c:if test="${ userlist.phone1 == '011' }"><c:out value="selected" /></c:if>>011</option>
					<option value="016" <c:if test="${ userlist.phone1 == '016' }"><c:out value="selected" /></c:if>>016</option>
					<option value="019" <c:if test="${ userlist.phone1 == '019' }"><c:out value="selected" /></c:if>>019</option>
				</select>-<input name="order_phone2" id="order_phone2" class="textBox" value="${ userlist.phone2 }" maxlength="4"/> - <input name="order_phone3" id="order_phone3" value="${ userlist.phone3 }" maxlength="4"/>
				</td>
			</tr>
			<tr>
				<th>배송지 유의사항</th>
				<td><input name="order_help" id="order_help" class="textBox" /></td>
			</tr>	
			</tbody>	
		</table>
		</div>

<!-- 결제정보 -->		
		<div id="sell_info">
		<h3>결제 정보</h3>
			<table border="0" cellspacing="0" summary="결제정보입력란" class="p_info">
			<caption>결제 입력폼</caption>
			<tbody>
			<tr>
				<th scope="row">최종결제금액</th>
					<td>￦ ${ final_price2 }</td>
				</tr>
				<tr>
					<th>거래은행</th>
					<td>우리은행 : 266-458625-4451<br/>
					      국민은행 : 232-345346-4343<br/>
					      하나은행 : 435-642344-2934<br/>
					     기업은행 : 445-992834-5887</td>
				</tr>
				<tr>
					<th>입금자: </th>
						 <td><input name="bankname" id="bankname" class="textBox"/></td>
				</tr>
				<tr>
					<th>거래은행:</th>
					<td>
						<select name="bank" id="bank">
							<option value="">==선택==</option>
							<option value="우리은행">우리은행</option>
							<option value="국민은행">국민은행</option>
							<option value="기업은행">기업은행</option>
							<option value="농협은행">농협은행</option>
					</select>
					<input type="submit" value="뱅킹바로가기" onclick="return checkbank()" />
					</td>
				</tr>
				<tr>
					<th>계좌번호:</th>
						<td><input name="banknumber" id="banknumber" class="textBox"/> </td>
				</tr>
			</table>
		</div>
		<p class="p_btn"><input type="submit" value="구매신청" /></p>
	</form>
	
	</div>
<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />
<!-- =============================== footer 끝 ===============================-->
