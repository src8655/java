<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head2.jsp" %>

<%
%>

	<div id="noticech">
		<h1>공지사항</h1>
		<ul>
<c:forEach items="${list}" var="bdb">
	<c:if test="${bdb.deletes ne 2}">
			<li>
				<a href="board_view.do?id=${bdb.id}&amp;no=${bdb.no}">
				  <span style="font-weight:bold;">[${bdb.name}]</span>
				  ${bdb.subject}
				  <c:if test="${bdb.dates eq date}"><span style="font-size:11px;color:red;">New</span></c:if>
				</a>
				  <p style="float:right;">[${bdb.dates}]</p>
			</li>
	</c:if>
</c:forEach>
		</ul>
	</div>
	<div class="icons" id="icons_1">
		<a href="board_write.do?id=q">온라인문의</a>
	</div>
	<div class="icons" id="icons_2">
		<a href="map.do?id=map">오시는길</a>
	</div>
	<div class="icons" id="icons_3">
		<a href="#">전화문의</a>
	</div>
<%@ include file="foot2.jsp" %>