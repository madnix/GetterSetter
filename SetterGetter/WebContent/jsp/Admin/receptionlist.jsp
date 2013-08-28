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
	<table width="60%" align="center">
		<tr>
			<td align="center" width="10%">ID</td>
			<td align="center" width="30%">TITLE</td>
			<td align="center" width="5%">COUNT</td>
			<td align="center" width="10%">PUSER</td>
			<td align="center" width="5%">DATE</td>
			<td align="center" width="10%"></td>
		</tr>
		<c:forEach items="${receptionList}" var="rlist">
			<tr>
				<td align="center">${rlist.pro_id }</td>
				<td align="center">${rlist.pro_title }</td>
				<td align="center">${rlist.pro_count }</td>
				<td align="center">${rlist.user_id }</td>
				<td align="center">${rlist.pro_date }</td>
				<td align="center">
					<a href="receptionlistdetail.do?pro_id=${rlist.pro_id }">
						상세보기
					</a>
				</td>
			</tr>
		</c:forEach>

		<tr align="center">
			<td colspan="6"><c:if test="${ count > 0 }">
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
							href="./prolist.do?pageNum=${(numPageGroup-2)*pageGroupSize+1 }">[이전]</a>
					</c:if>

					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<a href="prolist.do?pageNum=${i}"> [ <c:if
								test="${currentPage == i}"></c:if> ${i} ]
						</a>
					</c:forEach>

					<c:if test="${numPageGroup < pageGroupCount}">
						<a href="prolist.do?pageNum=${numPageGroup*pageGroupSize+1}">[다음]</a>
					</c:if>
				</c:if></td>
		</tr>

	</table>
</body>
</html>