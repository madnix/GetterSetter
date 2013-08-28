<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="./css/main.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript" src="./js/main.js" ></script>
<script type="text/javascript" src="./js/jquery.js" ></script>
<script type="text/javascript" src="./js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="./js/banner.js" ></script>
<title>main</title>
	
<!-- =========================================  header 시작 ========================================= -->
	   <jsp:include page="header.jsp" />
<!-- =========================================  header 끝 ========================================= -->

		<!-- article -->
		<div id="articleWrap">
			<div id="article">
				<div id="visual">
					<!--<h3><img src="./images/main/main_image_01.gif" alt="쇼핑몰메인이미지" /></h3>-->
					<ul class="visual_list">
						<li><img src="./images/main/main_visual_01.jpg" alt="marry me 가구" id="visual_Img1" /></li>
                        <li><img src="./images/main/main_visual_02.jpg" alt="가방" id="visual_Img2" /></li>
                        <li><img src="./images/main/main_visual_03.jpg" alt="향수" id="visual_Img3" /></li>

					</ul>
				</div>		
				<div id="line_list">
					<ul>
						<li><a href="#"><img src="./images/main/list_01.gif" alt="Notice&Event" /></a></li>
						<li><a href="#"><img src="./images/main/list_02.gif" alt="Notice&Event" /></a></li>
						<li><a href="#"><img src="./images/main/list_03.gif" alt="Notice&Event" /></a></li>
						<li><a href="#"><img src="./images/main/list_04.gif" alt="Notice&Event" /></a></li>
					</ul>
				</div>	
			</div>
			<!-- //article -->
		</div>
		
		<hr />
		<div id="maincontents">
			<!-- maincontents -->
			<div id="best_item">
			<h3><img src="./images/main/best_product.gif" alt="Top5 현재 스토어에서 가장잘 팔리는 제품입니다." /></h3>
			<div class="viewer">
			<ul id="banner">
			
				<li><a href="product_view.do?pro_id=${ best_bean0.pro_id }"><img src="./Upload/${ best_bean0.pro_listImg }" width="230" height="250" alt="베스트상품1"/></a>
					<p><c:out value="${ best_bean0.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ best_bean0.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ best_bean1.pro_id }"><img src="./Upload/${ best_bean1.pro_listImg }" width="230" height="250" alt="베스트상품2"/></a>
					<p><c:out value="${ best_bean1.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ best_bean1.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ best_bean2.pro_id }"><img src="./Upload/${ best_bean2.pro_listImg }" width="230" height="250" alt="베스트상품3"/></a>
					<p><c:out value="${ best_bean2.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ best_bean2.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ best_bean3.pro_id }"><img src="./Upload/${ best_bean3.pro_listImg }" width="230" height="250" alt="베스트상품4"/></a>
					<p><c:out value="${ best_bean3.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ best_bean3.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ best_bean4.pro_id }"><img src="./Upload/${ best_bean4.pro_listImg }" width="230" height="250" alt="베스트상품5"/></a>
					<p><c:out value="${ best_bean4.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ best_bean4.user_price }"></c:out> </p>
				</li>
			</ul>
			</div>
			</div>
			
			
<!-- 제일 잘 팔리는 상품 리스트 시작 -->
			<div id="new_item">
			<h3>현재 스토어에 새로들어온 상품입니다.</h3>
			<ul>
				<li class="first"><a href="product_view.do?pro_id=${ pro_bean0.pro_id }"><img src="./Upload/${ pro_bean0.pro_listImg }" width="230" height="250" alt="상품1"/></a>
					<p><c:out value="${ pro_bean0.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean0.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean1.pro_id }"><img src="./Upload/${ pro_bean1.pro_listImg }" width="230" height="250" alt="상품2"/></a>
					<p><c:out value="${ pro_bean1.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean1.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean2.pro_id }"><img src="./Upload/${ pro_bean2.pro_listImg }" width="230" height="250" alt="상품3"/></a>
					<p><c:out value="${ pro_bean2.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean2.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean3.pro_id }"><img src="./Upload/${ pro_bean3.pro_listImg }" width="230" height="250" alt="상품4"/></a>
					<p><c:out value="${ pro_bean3.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean3.user_price }"></c:out> </p>
				</li>
			</ul>
			
			<ul>
				<li class="first"><a href="product_view.do?pro_id=${ pro_bean4.pro_id }"><img src="./Upload/${ pro_bean4.pro_listImg }" width="230" height="250" alt="상품1"/></a>
					<p><c:out value="${ pro_bean4.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean4.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean5.pro_id }"><img src="./Upload/${ pro_bean5.pro_listImg }" width="230" height="250" alt="상품2"/></a>
					<p><c:out value="${ pro_bean5.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean5.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean6.pro_id }"><img src="./Upload/${ pro_bean6.pro_listImg }" width="230" height="250" alt="상품3"/></a>
					<p><c:out value="${ pro_bean6.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean6.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean7.pro_id }"><img src="./Upload/${ pro_bean7.pro_listImg }" width="230" height="250" alt="상품4"/></a>
					<p><c:out value="${ pro_bean7.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean7.user_price }"></c:out> </p>
				</li>
			</ul>
			
			<ul>
				<li class="first"><a href="product_view.do?pro_id=${ pro_bean8.pro_id }"><img src="./Upload/${ pro_bean8.pro_listImg }" width="230" height="250" alt="상품1"/></a>
					<p><c:out value="${ pro_bean8.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean8.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean9.pro_id }"><img src="./Upload/${ pro_bean9.pro_listImg }" width="230" height="250" alt="상품2"/></a>
					<p><c:out value="${ pro_bean9.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean9.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean10.pro_id }"><img src="./Upload/${ pro_bean10.pro_listImg }" width="230" height="250" alt="상품3"/></a>
					<p><c:out value="${ pro_bean10.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean10.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean11.pro_id }"><img src="./Upload/${ pro_bean11.pro_listImg }" width="230" height="250" alt="상품4"/></a>
					<p><c:out value="${ pro_bean11.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean11.user_price }"></c:out> </p>
				</li>
			</ul>
			
			<ul>
				<li class="first"><a href="product_view.do?pro_id=${ pro_bean12.pro_id }"><img src="./Upload/${ pro_bean12.pro_listImg }" width="230" height="250" alt="상품1"/></a>
					<p><c:out value="${ pro_bean12.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean12.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean13.pro_id }"><img src="./Upload/${ pro_bean13.pro_listImg }" width="230" height="250" alt="상품2"/></a>
					<p><c:out value="${ pro_bean13.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean13.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean14.pro_id }"><img src="./Upload/${ pro_bean14.pro_listImg }" width="230" height="250" alt="상품3"/></a>
					<p><c:out value="${ pro_bean14.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean14.user_price }"></c:out> </p>
				</li>
				<li><a href="product_view.do?pro_id=${ pro_bean15.pro_id }"><img src="./Upload/${ pro_bean15.pro_listImg }" width="230" height="250" alt="상품4"/></a>
					<p><c:out value="${ pro_bean15.pro_title }"></c:out> </p>
					<p><c:out value="￦ ${ pro_bean15.user_price }"></c:out> </p>
				</li>
			</ul>
			</div>
		</div>
<!-- 제일 잘 팔리는 상품 리스트 끝 -->
	
<!-- =============================== footer 시작 ===============================-->
<jsp:include page="footer.jsp" />	
<!-- =============================== footer 끝 ===============================-->
