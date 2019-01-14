<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="admin_menu">
<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
    <div class="col-sm-10 col-md-10 col-lg-8">
    
		<ul>
			<li><a href="#100" class="admin_menu_ul_li_a_hover">회원관리</a></li>
			<li><a href="#100" class="admin_menu_ul_li_a">리뷰 신고내역</a></li>
			<li><a href="#100" class="admin_menu_ul_li_a">면접 신고내역</a></li>
		</ul>
    
    </div>
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
  </div>
</div>
</div>












<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
    <div class="col-sm-10 col-md-10 col-lg-8">
    
    
    <div class="admin_member">
    	<h2>회원관리</h2>
    	<h5><span>3</span>명의 회원이 있습니다.</h5>
    	<table cellpadding="0" cellspacing="0" class="admin_member_table">
    	<col width="80" />
    	<col width="120" />
    	<col width="100" />
    	<col width="120" />
    	<col width="80" />
    		<tr>
    			<th>번호</th>
    			<th>이메일</th>
    			<th>이름</th>
    			<th class="hidden-xs">전화번호</th>
    			<th>편집</th>
    		</tr>
    		<tr>
    			<td>55</td>
    			<td>src8655@naver.com</td>
    			<td>윤민호</td>
    			<td class="hidden-xs">010-5555-6666</td>
    			<td><a href="#100">상세보기</a></td>
    		</tr>
    		<tr>
    			<td>55</td>
    			<td>src8655@naver.com</td>
    			<td>윤민호</td>
    			<td class="hidden-xs">010-5555-6666</td>
    			<td><a href="#100">상세보기</a></td>
    		</tr>
    		<tr>
    			<td>55</td>
    			<td>src8655@naver.com</td>
    			<td>윤민호</td>
    			<td class="hidden-xs">010-5555-6666</td>
    			<td><a href="#100">상세보기</a></td>
    		</tr>
    	</table>
    	
    	<div class="paging">
        <a href="#100" onclick="$('#main_load').load('list.o?pages=1&searchValue=${searchValue_utf}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}');" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>
        <c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
        	<a href="#100" onclick="$('#main_load').load('list.o?pages=${i}&searchValue=${searchValue_utf}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}');" 
        		<c:if test="${i ne pages}"> class="paging_a"</c:if> <c:if test="${i eq pages}"> class="paging_a_hover"</c:if>>
        		${i}
        	</a>
        </c:forEach>
        <a href="#100" onclick="$('#main_load').load('list.o?pages=${paging.board_paging}&searchValue=${searchValue_utf}&search=${search}&searchType=${searchType}&searchSort=${searchSort}&pages_rc=${pages_rc}');" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>
      </div>
    </div>
    
    
    </div>
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
  </div>
</div>