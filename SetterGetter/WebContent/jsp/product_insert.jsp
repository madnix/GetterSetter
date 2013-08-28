<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String id = (String)session.getAttribute("id");
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/selleradd.css" />
<script type="text/javascript" src="./js/seller_add.js" ></script>
<title>Product View</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->


		<!-- detail list -->
		<div id="detail">
			<form action="" method="post" onsubmit="return check()" enctype="multipart/form-data">
			<input type="hidden" name="user_id" id="user_id" value="<%=id %>">
			<p><input id="listImg" name="listImg" type="file" onchange="fileUploadPreview(this, 'imgView')" />※상품 리스트에 보여질 이미지입니다.</p>
				<div id="imgView" class="imgView">이미지 사이즈 230*250</div>
			<p class="list_img" />
			<br/>
			
			<hr/>
			
				<p><input id="detailTopImg" name="detailTopImg" type="file" onchange="fileUploadPreview(this, 'preView')" />※ 상품 상세보기 상단에 보여질 이미지입니다.</p>
				<div id="preView" class="preView">이미지 사이즈 526*324</div>
			
			<div id="product_add">
				<p><strong>*</strong>제목<input type="text" name="pro_title" id="pro_title" />※ 제목은 15자 이내로 입력하여주세요 </p>
				
					<fieldset>
						<legend>상품구해하기 폼  </legend>
						<table summary="상품 구매 선택 목록입니다." >
							<caption>상품구매폼 </caption>
							<tbody>
								<tr>
									<th scope="row"><strong>*</strong>판매가</th>
									<td><input type="text" name="pro_price" id="pro_price"/>원</td>
								</tr>
								<tr>
									<th scope="row"><strong>*</strong>소비자</th>
									<td><input type="text" name="user_price" id="user_price" />원</td>
								</tr>
								<tr>
									<th scope="row"><strong>*</strong>수량</th>
									<td><input type="text" name="pro_count" id="pro_count"/>개</td>
								</tr>
								<tr>
									<th scope="row">상품설명</th>
									<td><textarea cols="19" rows="4" name="pro_cont" id="pro_cont"></textarea>간단한 설명을 입력하세요</td>
								</tr>
							</tbody>
						</table>
						<br/>
					</fieldset>
			</div><!-- //product_add -->
			
			<div id="info"> <!-- info -->
			<table summary="물품에 대한정보를 알려주는 표" class="board">
			<caption>물품정보입니다.</caption>
			<colgroup>
			<col width="10%">
			<col width="40%">
			<col width="10%">
			<col width="40%">
			</colgroup>
			
			<tbody>
				<tr>
					
					<th><strong>*</strong>상품종류</th>
					<td>
						<select name="species_id" id="species_id">
		            	    <option value="">=선택=</option>
		            	    <option value="의류">의류</option>
		            	    <option value="패션잡화">패션잡화</option>
		            	    <option value="식품">식품</option>
		            	    <option value="생활">생활</option>
		            	    <option value="가전">가전</option>
						</select>
					</td>
					<th><strong>*</strong>상품상태</th>
					<td><input type="text" name="pro_status" id="pro_status"/></td>
				</tr>
				<tr>
					<th><strong>*</strong>원산지</th>
					<td>
						<select name="pro_origin" id="pro_origin">
							<option value="">=선택=</option>
		            	    <option value="미국">미국</option>
		            	    <option value="일본">일본</option>
		            	    <option value="한국">한국</option>
		            	    <option value="중국">중국</option>
		            	    <option value="기타">기타</option>
						</select>
					</td>
					<th><strong>*</strong>브랜드</th>
					<td><input type="text" name="pro_brand" id="pro_brand"/></td>
				</tr>
				<tr>
					<th><strong>*</strong>영수증 발급</th>
					<td>
						<select name="pro_receipt" id="pro_receipt">
							<option value="">=선택=</option>
		            	    <option value="법인영수증">법인영수증</option>
		            	    <option value="현금영수증">현금영수증</option>
		            	    <option value="공인영수증">공인영수증</option>
		            	    <option value="없음">없음</option>
						</select>
					</td>
					<th><strong>*</strong>제조사</th>
					<td><input type="text" name="pro_make" id="pro_make"/></td>
				</tr>
				<tr class="botton">
					<th><strong>*</strong>A/S안내</th>
					<td>
						<select name="pro_as" id="pro_as">
							<option value="">=선택=</option>
		            	    <option value="1년">1년</option>
		            	    <option value="2년">2년</option>
		            	    <option value="3년">3년</option>
		            	    <option value="없음">없음</option>
						</select>
					</td>
					<th>관리자답변:</th>
					<td></td>
				</tr>
				<tr>
					<th><strong>*</strong>거래은행</th>
					<td>
						<select name="pro_bank" id="pro_bank">
							<option value="">==선택==</option>
							<option value="우리은행">우리은행</option>
							<option value="국민은행">국민은행</option>
							<option value="기업은행">기업은행</option>
							<option value="농협은행">농협은행</option>
						</select>
					</td>
					<th><strong>*</strong>계좌번호</th>
					<td>
						<input name="pro_banknum" id="pro_banknum"> 예: 00-000-0000
					</td>
				</tr>
				<tr>
				</tr>
			</tbody>
			</table>
			</div>	 <!-- //info -->
			<p><input id="detaileImg" name="detaileImg" type="file" onchange="fileUploadPreview(this, 'detailView')" />※ 상품에 대한 자세한 정보를 알려주는 이미지입니다.</p>
			<div id="detailView" class="detailView">이미지 사이즈 866*3132</div>
			
			<div id="info_btn">
			<p><input type="image" src="./images/join/join_img22.jpg" alt="상품등록" /></p>
			<p><input type="image" src="./images/join/join_img23.jpg" alt="상품등록 취소" /></p>
			</div>
			</form>
		</div>
		
			<!-- //detail list -->


<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->



