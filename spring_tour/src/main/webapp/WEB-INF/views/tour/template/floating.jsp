<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div id="floating_body_bg" style="display:none;">
		<div id="floating_body">
			<div id="floating_body_x"><a href="#10" onclick="showhide('floating_body_bg');">X</a></div>
			<ul>
				<c:forEach var="ldata" items="${rviewedListAll}">
					<li>
						<a href="view.o?no=${ldata.no}">
							<img src="./upload/${ldata.file1}" alt="${ldata.name}" width="70px" height="70px" />
							<div style="float:right;">
								${ldata.name}<br />
								<span style="color:red;font-weight:bold;">${ldata.rmoneys}원</span>
							</div>
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div id="floating_bg">
		<div id="floating">
			<h1>
				최근 본 상품<br />
				<span style="color:red;font-weight:bold;">(${rviewed_count})</span>
			</h1>
			<ul>
				<c:forEach var="ldata" items="${rviewedList}">
					<li><a href="view.o?no=${ldata.no}"><img src="./upload/${ldata.file1}" alt="${ldata.name}" width="70px" height="70px" /></a></li>
				</c:forEach>
			</ul>
			<a href="#10" id="floating_more" onclick="showhide('floating_body_bg');">더보기</a>
		</div>
		<div id="floating_top"><a href="#10" onclick="floatingTop();">↑ TOP</a></div>
	</div>