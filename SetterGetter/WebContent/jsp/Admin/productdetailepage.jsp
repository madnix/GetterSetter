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
							<td align="right" width="20%">거래수:</td>
							<td align="center" width="30%">${productMassage.pro_num}</td>
							<td align="right" width="20%">등록자:</td>
							<td align="center" width="30%">${productMassage.user_id}</td>

						</tr>
						<tr>
							<td align="center" colspan="4">
								상세정보
							</td>
						</tr>
						<tr>
							<td align="right" width="20%">수취인이름:</td>
							<td align="center" width="30%">${order.recevier_name}</td>
							<td align="right" width="20%">수취인전화:</td>
							<td align="center" width="30%">0${order.recevier_tel1}-${order.recevier_tel2}-${order.recevier_tel3}</td>
						</tr>
						<tr>
							<td align="right" width="20%">우편번호:</td>
							<td align="center" width="30%">${order.recevier_zip1}-${order.recevier_zip2}</td>
							<td align="right" width="20%">배송정보:</td>
							<td align="center" width="30%">${order.recevier_help}</td>
						</tr>
						<tr>
							<td align="right" width="20%">구매수량:</td>
							<td align="center" width="30%">${order.product_count}</td>
							<td align="right" width="20%">결제금액:</td>
							<td align="center" width="30%">${order.product_count * order.product_price}</td>
						</tr>
						<tr>
							<td align="right" width="20%">입금자명:</td>
							<td align="center" width="30%">${order.buyer_name}</td>
							<td align="right" width="20%">계좌번호:</td>
							<td align="center" width="30%">${order.buyer_banknumber}</td>
						</tr>
						<tr>
							<td align="right" width="20%">주소:</td>
							<td align="center" width="30%" colspan="3">${order.recevier_addr1}-${order.recevier_addr2}</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr>
				<td colspan="5" align="center">
					<a href="#" onclick="history.back()">
						돌아가기
					</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="deletesomedate.do?order_no=${order.order_no}" >
						삭제하기
					</a>
				</td>
			</tr>
		</table>
</body>
</html>