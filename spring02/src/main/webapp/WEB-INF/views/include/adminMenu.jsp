<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="${path}/board/list.do">게시판</a> |
<!--  
<a href="${path}/upload/uploadForm">업로드</a> |
<a href="${path}/upload/uploadAjax">업로드(AJAX)</a> |
-->
<a href="${path}/shop/product/list.do">상품목록</a> |
<a href="${path}/shop/product/write.do">상품등록</a> |
<c:choose>
	<c:when test="${sessionScope.adminId == null}">
		<a href="${path}/admin/login.do">관리자 로그인</a>
	</c:when>
	<c:otherwise>
		<a href="${path}/member/list.do">회원 목록</a> |
		관리자(${sessionScope.adminName}) 로그인 중
		<a href="${path}/admin/logout.do">로그아웃</a>
	</c:otherwise>
</c:choose>
	
<hr>