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
			<li><a href="#100" class="admin_menu_ul_li_a_hover" onclick="$('#main_load').load('adminpage_member.o');">회원관리</a></li>
			<li><a href="#100" class="admin_menu_ul_li_a" onclick="$('#main_load').load('adminpage_report_r.o?tab=1');">리뷰 신고내역</a></li>
			<li><a href="#100" class="admin_menu_ul_li_a" onclick="$('#main_load').load('adminpage_report_r.o?tab=2');">면접 신고내역</a></li>
		</ul>
    
    </div>
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
  </div>
</div>
</div>



<!-- 회원관리 상세보기 영역 -->
<div id="adminpage_member_edit_hidden"></div>







<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
    <div class="col-sm-10 col-md-10 col-lg-8">
    
    
    <div class="admin_member">
    	<h2>회원관리</h2>
    	<h5><span>${count}</span>명의 회원이 있습니다.</h5>
    	<table cellpadding="0" cellspacing="0" class="admin_member_table">
    	<col width="80" />
    	<col width="120" />
    	<col width="100" />
    	<col width="120" />
    	<col width="80" />
    		<tr>
    			<th><span class="hidden-xs">회원</span>번호</th>
    			<th>이메일</th>
    			<th>이름</th>
    			<th class="hidden-xs">전화번호</th>
    			<th>편집</th>
    		</tr>
    	<c:forEach items="${list}" var="mdata">
    		<tr>
    			<td>${mdata.no}</td>
    			
    			<c:if test="${mdata.kakao eq -1}">
    			<td>${mdata.email}</td>
    			</c:if>
    			<c:if test="${mdata.kakao eq 1}">
    			<td>카카오계정</td>
    			</c:if>
    			<c:if test="${mdata.kakao eq 2}">
    			<td>구글계정</td>
    			</c:if>
    			
    			<td>${mdata.name}</td>
    			<td class="hidden-xs">${mdata.phone1}-${mdata.phone2}-${mdata.phone3}</td>
    			<td><a href="#100" onclick="adminpage_member_edit_show_ajax(${mdata.no},${pages_r},'${adminSearchV_utf}',${adminSearch});">상세보기</a></td>
    		</tr>
    	</c:forEach>
    	</table>
    	
    	<div class="admin_search_bg">
    		<form id="admin_search_forms" onsubmit="return false;">
    			<div class="admin_search_l">
    				<select name="adminSearch">
    					<option value="1" <c:if test="${adminSearch eq 1}">selected</c:if>>이름</option>
    					<option value="2" <c:if test="${adminSearch eq 2}">selected</c:if>>회원번호</option>
    				</select>
    			</div>
    			<div class="admin_search_c">
    				<input type="text" name="adminSearchV" value="${adminSearchV}" />
    			</div>
    			<div class="admin_search_r">
    				<input type="button" value="검색" onclick="admin_search(document.getElementById('admin_search_forms'));" />
    			</div>
    		</form>
    	</div>
    	
    	<div class="paging">
        <a href="#100" onclick="$('#main_load').load('adminpage_member.o?pages_r=1&adminSearchV=${adminSearchV_utf}&adminSearch=${adminSearch}');" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>
        <c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
        	<a href="#100" onclick="$('#main_load').load('adminpage_member.o?pages_r=${i}&adminSearchV=${adminSearchV_utf}&adminSearch=${adminSearch}');" 
        		<c:if test="${i ne pages_r}"> class="paging_a"</c:if> <c:if test="${i eq pages_r}"> class="paging_a_hover"</c:if>>
        		${i}
        	</a>
        </c:forEach>
        <a href="#100" onclick="$('#main_load').load('adminpage_member.o?pages_r=${paging.board_paging}&adminSearchV=${adminSearchV_utf}&adminSearch=${adminSearch}');" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>
      </div>
    </div>
    
    
    </div>
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
  </div>
</div>