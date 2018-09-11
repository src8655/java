<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="boards_header">
	<p style="float:left;width:30%;">전체게시물 : ${board_total}</p>
	<p style="float:right;width:70%;text-align:right;">
<c:if test="${member_info eq null}">
		<a href="login.do?id=${id}&pages=${pages}">로그인</a>
		&nbsp;
		<a href="join.do?id=join&pages=${pages}">회원가입</a>
</c:if>
<c:if test="${!(member_info eq null)}">
		<span style="font-weight:bold;">${member_info.name}</span>님 환영합니다.
		<a href="join_edit.do?id=join&pages=${pages}">[정보수정]</a>
		<a href="logout.do?id=${id}&pages=${pages}">[로그아웃]</a>
</c:if>
	</p>
</div>