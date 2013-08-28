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

	<table width="85%" align="center">
		<tr>
			<td align="center" width="10%">ID</td>
			<td align="center" width="10%">NAME</td>
			<td align="center" width="15%">PHONE</td>
			<td align="center" width="15%">TEL</td>
			<td align="center" width="15%">EMAIL</td>
			<td align="center" width="10%">ZIPCODE</td>
			<td align="center" width="10%"></td>
		</tr>
		<c:forEach items="${puserList}" var="puser">

			<tr>
				<td align="center">${puser.id }</td>
				<td align="center">${puser.name }</td>
				<td align="center">0${puser.phone1}-${puser.phone2}-${puser.phone3}</td>
				<td align="center">0${puser.tel1}-${puser.tel2}</td>
				<td align="center">${puser.email1}@${puser.email2}</td>
				<td align="center">${puser.zip1 }-${puser.zip2 }</td>
				<td align="left"><a
					href="puserdetaillist.do?user_id=${puser.id }">상세보기</a></td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="7">
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
							href="./adminpuser.do?pageNum=${(numPageGroup-2)*pageGroupSize+1 }">[이전]</a>
					</c:if>

					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="adminpuser.do?pageNum=${i}"> [ <c:if
								test="${currentPage == i}"></c:if> ${i} ]
						</a>
					</c:forEach>

					<c:if test="${numPageGroup < pageGroupCount}">
						<a href="adminpuser.do?pageNum=${numPageGroup*pageGroupSize+1}">[다음]</a>
					</c:if>
				</c:if></td>
		</tr>
	</table>

</body>
</html>