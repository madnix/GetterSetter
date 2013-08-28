<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/cart.css" />
<title>장바구니</title>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery("#resum").click(function(){
//		alert("resum");
		var sum = 0;
		$('input[name=userCheck]:checkbox:checked').each(function(){
			var price = $(this).parent().siblings(".tprice_td").find(".tprice");
// 			alert(price.text());
			sum = sum + Number(price.text());
		});
//		alert(sum);
		$("#money").text(sum);
	});
});

	jQuery(document).ready(function(){
		// ---------------------------------------------
		// 체크 박스 클릭시 전체 선택 or 전체 선택 해제
		// ---------------------------------------------
		jQuery("#check_all").click(function(){
			if(jQuery("#check_all:checked").length > 0){
				jQuery('input:checkbox[name=userCheck]:not(checked)').attr("checked", "checked");
			}else{
				jQuery('input:checkbox[name=userCheck]:checked').attr("checked",false);
			}
		});
	});
	
	/* 선택삭제 */
	jQuery(document).ready(function(){
		// -------------------
		// 체크 박스 선택 삭제
		// -------------------
		var kk=document.getElementsByName("userCheck");
		var kkValue="";
		jQuery("#select_delete_check").click(function(){
			for(var i=0; i<$("input:checkbox[name=userCheck]").length; i++){
				if(kk[i].checked == true){
					kkValue += "/" + kk[i].id;					
				}
			}
			if(kkValue == ""){
				alert("해당 물품을 체크해주세요.");
				kkValue="";
			}else{
				var ch = confirm('선택하신 물품을 삭제하시겠습니까?');
				if(ch == true){
					var frm = document.f;
					frm.action="cart_selectdelete.do?kkValue="+kkValue.substring(1);
					frm.method="post";
					frm.submit();
				}
			}

		});
	});

	/* 선택삭주문 */
	jQuery(document).ready(function(){
		// -------------------
		// 체크 박스 선택 주문
		// -------------------
		var kk=document.getElementsByName("userCheck");
		var kkValue="";
		jQuery("#select_order_check").click(function(){
			for(var i=0; i<$("input:checkbox[name=userCheck]").length; i++){
				if(kk[i].checked == true){
					kkValue += "/" + kk[i].id;					
				}
			}
			if(kkValue == ""){
				alert("해당 물품을 체크해주세요.");
				kkValue="";
			}else{
				var ch = confirm('선택하신 물품을 주문하시겠습니까?');
				if(ch == true){
					var frm = document.f;
					frm.action="cart_selectorder.do?kkValue="+kkValue.substring(1);
					frm.method="post";
					frm.submit();
				}
			}

		});
	});
	

	/* 삭제버튼 */
	function delete_check(chk){
//		alert(chk.id);
		if(confirm('해당 물품을 삭제하시겠습니까?')){
			location.href='cart_delete.do?order_no='+chk.id;
		}
	}
	
	/* 주문버튼 */
	function order_check(chk){
//		alert(chk.id);
		if(confirm('해당 물품을 주문하시겠습니까?')){
			location.href='cart_order.do?order_no='+chk.id;
		}	
	}
	
	/* 물품수량 수정 */
	function count_modified(chk){
		var count = jQuery("#count"+chk.id).val();
		if(confirm('해당 물품 수량을 수정하시겠습니까?') == true){
			location.href='cart_countmodify.do?order_no='+chk.id+'&product_count='+count;
		}
	}

</script>

<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->


<div id="product_cart">
	
	<c:choose>
		<c:when test="${ id_count > 0}">
			<form name="f">
				<div id="cart_box_on">
					<table border="0" width="100%" summary="장바구니 리스트">
						<caption>장바구니</caption>
						<colgroup>
							<col width="10%" />
							<col width="10%" />
							<col width="*" />
							<col width="10%" />
							<col width="10%" />
							<col width="20%" />
							<col width="10%" />
						</colgroup>
						<thead>
							<tr>
								<th scope="col">전체선택  <input type="checkbox" id="check_all" checked="checked"></th>
								<th scope="col">이미지</th>
								<th scope="col">상품명</th>
								<th scope="col">가격(판매가)</th>
								<th scope="col">수량</th>
								<th scope="col">소계금액</th>
								<th scope="col">주문/삭제</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${ usercart_list }" var="list">
								<tr>
									<td><input type="checkbox" name="userCheck"
										value="<c:out value='${list.order_no}'/>"
										id="${ list.order_no }" checked="checked"></td>
									<td><img src="./Upload/${ list.product_listImg }"
										width="50" height="50"></td>
									<td class="p_title"><a
										href="product_view.do?pro_id=${ list.product_id }"> ${
											list.product_name }</a></td>
									<td>￦ ${ list.product_price }</td>
									<td><input type="text" class="count_in"
										id="count${ list.order_no }" value="${ list.product_count }" />
										개 <input type="button" id="${ list.order_no }" value="변경"
										onclick="count_modified(this)" /></td>
										
									<td class="tprice_td">￦ <span class="tprice"> ${ list.product_price * list.product_count }</span></td>
									
									<td><input type="button" id="${ list.order_no }" value="주문" onclick="order_check(this)" /> 
										<input type="button" id="${ list.order_no }" value="삭제" onclick="delete_check(this)" /></td>
								</tr>
							</c:forEach>
						</tbody>
						
<!-- 체크 된 상품 계산 -->
						<tfoot>
							<tr>
								<th><input type="button" value="선택한 물품 총가격 재계산" id="resum">
								<th scope="col">총 가격</th>
								<th>￦ <span id="money">${ sum }</span></th>
							</tr>
						</tfoot>
					</table>
					
					<div id="btn_area">
					<p class="first_p">
						<input type="button" id="select_delete_check" value="선택삭제" />
					</p>
					
					<p class="r_p_1">
						<input type="button" value="쇼핑하기"
							onclick="location.href='main.do'" />
					</p>
					<p class="r_p_2">
						<input type="button" id="select_order_check" value="주문하기" />
					</p>
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<div id="cart_box_off">
				<p><img src="./images/cart/noitem.gif" alt="장바구니가 비었습니다" /></p>
			</div>
		</c:otherwise>
	</c:choose>
</div>
<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->
