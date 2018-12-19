<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


</div>
  	<div class="contents_color">
  	<!--  -->
  	

  	
  	<ul class="tour_list" style="margin-top:50px;">
  	<c:forEach items="${list}" var="ldata">
  		<c:if test="${cnt eq 3}">
	  		</ul>
	  		<ul class="tour_list">
  		</c:if>
  		
  		<li <c:if test="${cnt eq 2}">style="border:0px;"</c:if>><a href="view.o?no=${ldata.no}&pages=${pages}&category=${category}&searchs=${searchs_utf}" onmouseenter="tour_show('tour_list_f_${ldata.no}','tour_list_ff_${ldata.no}')" onmouseleave="tour_hide('tour_list_f_${ldata.no}','tour_list_ff_${ldata.no}')">
  			<div class="tour_list_floating" style="display:none;" id="tour_list_f_${ldata.no}"></div>
  			<div class="tour_list_floating_btn" style="display:none;" id="tour_list_ff_${ldata.no}">자세히보기</div>
  			<img src="./upload/${ldata.file1}" alt="data1" width="325px" height="219px" />
  			<p>${ldata.subject}</p>
  			<span style="color:#ed4949;font-weight:bold;font-size:17px;">${ldata.moneys}원~</span>
  		</a></li>
  		
  		<c:set var="cnt" value="${cnt+1}" scope="request"></c:set>
  	</c:forEach>
  	</ul>
	 <div class="list_page">
		<a href="list.o?pages=1&amp;searchs=${searchs_utf}&category=${category}" class="list_page_a">◀</a>
		<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
			<a href="list.o?pages=${i}&amp;searchs=${searchs_utf}&category=${category}" <c:if test="${i ne pages}"> class="list_page_a"</c:if> <c:if test="${i eq pages}"> class="list_page_a_hover"</c:if>>${i}</a>
		</c:forEach>
		<a href="list.o?pages=${paging.board_paging}&amp;searchs=${searchs_utf}&category=${category}" class="list_page_a">▶</a>
	</div>

