<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
<%-- <c:set var="user_id" value="${puserdetail[0].id }"/> --%>
<table align="center" width="80%" >
<%-- 	<c:forEach items="${puserdetail}" var="userlist"> --%>
	<tr>
		<td align="right" width="10%">아이디:</td>
		<td align="center" width="30%">${usermassage.id }</td>
		<td align="right" width="10%">이름: </td>
		<td align="center" width="30%">${usermassage.name }</td>
	</tr>
	<tr>
		<td align="right">비밀번호 : </td>
		<td align="center">${usermassage.pwd }</td>
		<td align="right">질문 : </td>
		<td align="center">${usermassage.pwd_q }</td>
	</tr>
	<tr>
		<td align="right">우편번호 : </td>
		<td align="center">${usermassage.zip1 }-${usermassage.zip2 }</td>
		<td align="right">답변 : </td>
		<td align="center">${usermassage.pwd_a }</td>
	</tr>
	<tr>
		<td align="right">주소 : </td>
		<td colspan="3" align="center">${usermassage.addr1 }-${usermassage.addr2 }</td>
	</tr>
	<tr>
		<td align="right">주택전화 : </td>
		<td align="center">0${usermassage.tel1 }-${usermassage.tel2 }-${usermassage.tel3 }</td>
		<td align="right">핸드폰 : </td>
		<td align="center">0${usermassage.phone1 }-${usermassage.phone2 }-${usermassage.phone3 }</td>
	</tr>
	<tr>
		<td align="right">이메일 : </td>
		<td align="center">${usermassage.email1 }@${usermassage.email2 }</td>
		<td align="right">회사명 : </td>
		<td align="center">${usermassage.cor }</td>
	</tr>
	<tr>
		<td align="right">대표자이름 : </td>
		<td align="center">${usermassage.cor_name }</td>
		<td align="right">사업자번호 : </td>
		<td align="center">${usermassage.cor_number }</td>
	</tr>
	<tr>
		<td align="right">회사우편번호 : </td>
		<td align="center">${usermassage.cor_zip1}-${usermassage.cor_zip2}</td>
		<td align="right">회사메일 : </td>
		<td align="center">${usermassage.cor_mail1 }@${usermassage.cor_mail2 }</td>
	</tr>
	<tr>
		<td align="right">회사전화번호 : </td>
		<td align="center">0${usermassage.cor_tel1 }-${usermassage.cor_tel2 }-${usermassage.cor_tel3 }</td>
		<td align="right">회사팩스 : </td>
		<td align="center">0${usermassage.cor_fax1 }-${usermassage.cor_fax2 }-${usermassage.cor_fax3 }</td>
	</tr>
	<tr>
		<td align="right">회사주소 : </td>
		<td align="center" colspan="3">${usermassage.cor_addr1 }-${usermassage.cor_addr2 }</td>
	</tr>
<%-- 	</c:forEach> --%>
</table>
<table align="center" width="80%" >
		<tr>
			<td colspan="8">&nbsp;</td>
		</tr>
		<tr>
			<td width="10%" align="center">PROID</td>
			<td width="10%" align="center">SPEIES</td>
			<td width="10%" align="center">PROCOUNT</td>
			<td width="10%" align="center">PROPRICE</td>
			<td width="10%" align="center">PROHIT</td>
			<td width="10%" align="center">PRONUM</td>
			<td width="10%" align="center">DATE</td>
			<td width="10%"></td>
		</tr>
		<c:forEach items="${allproduct}" var="proout">
			<tr>
				<td align="center">${proout.pro_id}</td>
				<td align="center">${proout.species_id}</td>
				<td align="center">${proout.pro_count}</td>
				<td align="center">${proout.pro_price}</td>
				<td align="center">${proout.pro_hit}</td>
				<td align="center">${proout.pro_num}</td>
				<td align="center">${proout.pro_date}</td>
				<td align="center"><a
					href="productlistok.do?pro_id=${proout.pro_id}"> 상세보기 </a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8" align="center"><c:if test="${ count > 0 }">
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
							href="./puserdetaillist.do?user_id=${usermassage.id}&pageNum=${(numPageGroup-2)*pageGroupSize+1 }">[이전]</a>
					</c:if>

					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="puserdetaillist.do?user_id=${usermassage.id}&pageNum=${i}"> [ <c:if
								test="${currentPage == i}"></c:if> ${i} ]
						</a>
					</c:forEach>

					<c:if test="${numPageGroup < pageGroupCount}">
						<a
							href="puserdetaillist.do?user_id=${usermassage.id}&pageNum=${numPageGroup*pageGroupSize+1}">[다음]</a>
					</c:if>
				</c:if></td>
		</tr>
	</table>
<table align="center" width="75%">
	<tr>
		<td colspan="2" align="right"><a
			href="deleteuser.do?user_id=${usermassage.id }"> 회원탈퉤 </a></td>
	</tr>
</table>


</body>
</html>