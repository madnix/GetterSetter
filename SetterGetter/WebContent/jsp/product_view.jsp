<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/detail.css" />
<script type="text/javascript" src="./js/product_input_view.js"></script>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/product_board.js"></script>
<script src="./js/jquery-spin.js"></script>

<title>Product View</title>
<script type="text/javascript">

$(document).ready(function(){
	$.spin.imageBasePath = './images/spin1/';
	$('#count').spin({
		max: $('#allcount').text(),
		min: 1
	});
});

function getSelectedValue(selectBox){
	var selectedIndex = selectBox.options.selectedIndex;
	return selectBox.options[selectedIndex].value;
}
function cart(msg){
	var ch;
	ch = confirm(msg);
	
	var count = f.count.value; 
	
	if(ch == true){
		
		var frm = document.f;
		frm.action="cart.do?pro_id=${ pro_bean.pro_id }&count="+count;
		frm.method="post";
		frm.submit();
//		location.href="cart.do?pro_id=${ pro_bean.pro_id }&count="+count;
	}
}
</script>	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->


		<!-- detail list -->
		
		<div id="detail">
			<div id="product_view">
				<p>조회수 : ${ pro_bean.pro_hit }</p>
				<p><img src="./Upload/${ pro_bean.pro_detailTopImg }" alt="상품이미지" width="526" height="324"/></p>
			</div>
			<div id="product_add"><br/>
				<p>${ pro_bean.pro_title }</p>
				<form action="product_view.do" method="post" name="f" onsubmit="return optionChk()">
					<input type="hidden" name="pro_id" value="${ pro_bean.pro_id }" />
					<fieldset>
						<legend>상품구해하기 폼  </legend>
						<table summary="상품 구매 선택 목록입니다." >
							<caption>상품구매폼 </caption>
							<tbody>
								<tr>
									<th scope="row"><strong>*</strong>판매가</th>
									<td>￦ 
										<span id="price">
											${ pro_bean.pro_price }
										</span>
									</td>
								</tr>
								<tr>
									<th scope="row"><strong>*</strong>소비자</th>
									<td>￦ ${ pro_bean.user_price }</td>
								</tr>
								<tr>
									<th scope="row"><strong>*</strong>남은 갯수 </th>
									<td>
										<span id="allcount"> 
											${ pro_bean.pro_count }
										</span>개
									</td>
								</tr>
								<tr>
									<th scope="row"><strong>*</strong>상품코드</th>
									<td>${ pro_bean.pro_id }</td>
								</tr>
								<tr>
									<th scope="row">구매수량</th>
									<td><input type="text" id="count" name="count" value="0"
										onchange="checkcount()" /></td>
								</tr>
							</tbody>
						</table>
						<p><input type="image" src="./images/product_view/add.jpg" /></p>
						<p><a href="javascript:cart('장바구니에 담겠습니까?')" >
						<img src="./images/product_view/cartbtn.JPG" alt="장바구니담기" /></a></p>
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
							<td class="end"><c:out value="${ pro_bean.pro_brand }"></c:out> </td>
						</tr>
						<tr>
							<th><strong>*</strong>영수증 발급</th>
							<td><c:out value="${ pro_bean.pro_receipt }"></c:out> </td>
							
							<th><strong>*</strong>제조사</th>
							<td class="end"><c:out value="${ pro_bean.pro_make }"></c:out> </td>
						</tr>
						<tr class="botton">
							<th><strong>*</strong>A/S안내</th>
							<td><c:out value="${ pro_bean.pro_as }"></c:out></td>
							
							<th><strong>*</strong>콜센터</th>
							<td class="end"></td>
						</tr>
						<tr>
							<th><strong>*</strong>거래은행</th>
							<td><c:out value="${ pro_bean.pro_bank }"></c:out></td>
							
							<th><strong>*</strong>계좌번호</th>
							<td class="end"><c:out value="${ pro_bean.pro_banknum }"></c:out></td>
						</tr>
						<tr>
						</tr>
					</tbody>
			</table>
			</div>
         <!-- //p_info --- -->		
			<p><img src="./Upload/${ pro_bean.pro_detailImg }" alt="상품 상세이미지 " /></p>
		</div>
		
			<!-- //detail list -->

		
	<!-- =============================  상품 평가 하기 ============================= -->
	
	<form method="post" name="product_f" action="product_comment.do?pro_id=${pro_id}&pageNum=${pageNum}" onsubmit="return product_board()">
		<div id="comment_wrap">
		
		<div id="comment_write_wrap">
		
		<input type="hidden" id="" name="secret" value="0">
		<input type="hidden" id="" name="commentList" value="${commentList }">
		<input type="hidden" id="" name="pro_id" value="${pro_id }">
		<input type="hidden" id="" name="pageNum" value="${pageNum }">
		
			<div id="comment_table">
				<div id="top_box" >
				<table>	
					<tr>
							<th><strong>평 점 선 택</strong></th>
					</tr>
				</table>	
				</div>
				<div id="bottom_box">
				<table>
					<tr>					
							<th>
							<input type="checkbox" name="appraisal" id="appraisal1" onClick="javascript:checkBoxValidate(0)" value="1" class="checkbox"/>&nbsp;
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star_gray.jpg">
								<img alt="평점" src="./images/product_view/star_gray.jpg"> 
								<img alt="평점" src="./images/product_view/star_gray.jpg"> 
								<img alt="평점" src="./images/product_view/star_gray.jpg"> 
							</th>
					</tr>
					<tr><td>
					<div id="star_line"></div>
					</td></tr>
					<tr>					
						<th>
							<input type="checkbox" name="appraisal" id="appraisal2" onClick="javascript:checkBoxValidate(1)" value="2" class="checkbox" />&nbsp;
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star_gray.jpg">
								<img alt="평점" src="./images/product_view/star_gray.jpg">
								<img alt="평점" src="./images/product_view/star_gray.jpg"> 
						</th>
					</tr>
					<tr><td>
										<div id="star_line"></div>
					</td></tr>					
					<tr>					
						<th>
							<input type="checkbox" name="appraisal" id="appraisal3" onClick="javascript:checkBoxValidate(2)" value="3" class="checkbox" />&nbsp;
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star_gray.jpg">
								<img alt="평점" src="./images/product_view/star_gray.jpg"> 
						</th>
					</tr>
					<tr><td>
										<div id="star_line"></div>
					</td></tr>
					<tr>					
						<th>
							<input type="checkbox" name="appraisal" id="appraisal4" onClick="javascript:checkBoxValidate(3)" value="4" class="checkbox" />&nbsp;
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star_gray.jpg"> 
						</th>
					</tr><tr><td>
										<div id="star_line"></div>
					</td></tr>
					<tr>					
						<th>
							<input type="checkbox" name="appraisal" id="appraisal5" onClick="javascript:checkBoxValidate(4)" value="5" class="checkbox" />&nbsp;
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
								<img alt="평점" src="./images/product_view/star.jpg">
						</th>
					</tr>
				</table>
				</div>
			</div>
			
			<div id="comment_write">
				<textarea id="cont" name="cont" rows="6" cols="70"></textarea>
			</div>
			
			<div id="appraisal_id">
				<th>
					<strong>이름 : </strong><input type="text" id="name" name="name" size="22" value="${infoName.name }">
				</th>
			</div>
			
			<div id="comment_ok">
				<div>
					<p><input type="image" src="./images/product_view/comment_ok.jpg" alt="댓글입력" ></p>
				</div>
			</div>
			
		</div>
		
		<div id="comment_space"></div>
		<div id="comment_line"></div>
			<table id="comment_title" width="700" height="45">
				<tr>
					<th width="10%" align="center"><strong>NO&nbsp;&nbsp;&nbsp;</strong></th>
					<th width="50%" align="center"><strong>내용</strong></th>
					<th width="10%" align="center"><strong>이름</strong></th>
					<th width="12%" align="center"><strong>날짜</strong></th>
					<th width="18%" align="center"><strong>평점</strong></th>
				</tr>
			</table>

		<div id="comment_line"></div>
	<c:if test="${commentList == null }">
		<input type="hidden" value="${commentList }" name="commentList">
		<table id="comment_cont" width="700" height="30" align="center">
		<tr>
			<th width="70%"><strong>내용이 없습니다.</strong></th>
			<th width="10%"align="center"><strong></strong></th>
			<th width="20%"><strong></strong></th>
		</tr>
		</table>
		<div id="comment_line"></div>
	</c:if>
	<c:if test="${commentList != null }">
	
		<c:forEach items="${commentList}" var="b">

			<table id="comment_cont" width="700" height="40">
				<tr>
					<th width="10%" align="center"><strong>
					${b.no }
					
					&nbsp;&nbsp;&nbsp;</strong></th>
				
			<!-- 관리자 일 경우 강제 삭제 가능 -->
				<c:if test="${b.comment_section == 3 }">
						<th width="40%" align="left">${b.comment_cont }</th>
						<th width="10%" align="right" onclick="comment_del()"></th>
				</c:if>	
				
			<!-- 판매자 및 일반회원일경우 삭제는 해당회원만 가능 -->
				<c:if test="${b.comment_section != 3 }">
					<c:if test="${b.comment_id != id }">
						<th width="50%" align="left">${b.comment_cont }</th>
					</c:if>
					<c:if test="${b.comment_id == id }">
						<th width="40%" align="left">${b.comment_cont }</th>
						<th width="10%" align="right">
						<p><a href="#" value="삭제"  onclick="productDel()"><strong>[삭제]</strong></a></p></th>
						<input type="hidden" value="${b.no}" id="no" name="no" >
					</c:if>
				</c:if>
					
					<th width="10%" align="center">${b.comment_name }</th>
					
				<!-- fn 태그를 사용하여 substring 으로 출력 시간 표시  
				오늘 작성한 글은 시간:분:초 출력 전날 작성한 글은 년 월 일 출력 -->
					<th width="12%" align="center">
						<c:set var="date" value="${b.comment_date }"/>
						
						<c:if test="${toDay == fn:substring(date,0,10) }">
							<c:out value="${fn:substring(date,11,19)}"/>
						</c:if>

						<c:if test="${toDay != fn:substring(date,0,10) }">
							<c:out value="${fn:substring(date,0,10)}"/>
						</c:if>
					</th>

				<!-- 평점 별 개수 구하기 -->
					<th width="18%" align="center">
						<c:forEach begin="1" end="${b.product_appraisal }" var="c">
							<img alt="평점" src="./images/product_view/star.jpg">
						</c:forEach>

						<c:forEach begin="1" end="${(5 - b.product_appraisal) }" var="c">
							<img alt="평점" src="./images/product_view/star_gray.jpg">
						</c:forEach>
					</th>
				</tr>
			</table>
		<div id="comment_line"></div>
		</c:forEach>
	</c:if>
	
<!-- =============================  상품 평가 하기 끝 ============================= -->
		
		
		<!-- comment_paging -->
		
<!-- =================  페이징 부분  ================= -->
		<div id="comment_paging">
			<tr>
		
	<c:if test="${ count > 0 }">
		<c:set var="pageCount" value="${ count / pageSize + (count % pageSize == 0 ? 0 : 1)}" />
			 
		<c:set var="startPage" value="${ pageGroupSize * ( numPageGroup-1) + 1 }" />
		<c:set var="endPage" value="${ startPage + pageGroupSize - 1 }" />

		<c:if test="${ endPage > pageCount }">
			<c:set var="endPage" value="${ pageCount }" />
		</c:if>
						
		<c:if test="${numPageGroup > 1}">
			<a href="./product_view.do?pro_id=${pro_id } & pageNum=${(numPageGroup-2)*pageGroupSize+1 }">[이전]</a>
		</c:if>			
			
			
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="product_view.do?pro_id=${pro_id } & pageNum=${i}"> [ 
				<c:if test="${pageNum == i}" ></c:if> ${i} ]
			</a>
		</c:forEach>
		
		<c:if test="${numPageGroup < pageGroupCount}">
			<a href="product_view.do?pro_id=${pro_id } & pageNum=${numPageGroup*pageGroupSize+1}">[다음]</a>
		</c:if>
	</c:if>
		</tr>
		
	</div>
<!-- =================  페이징 끝  ================= -->
		
		</div>
	</form>

<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->