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
			<li><a href="#100" class="admin_menu_ul_li_a" onclick="$('#main_load').load('adminpage_member.o');">회원관리</a></li>
			<li><a href="#100" <c:if test="${tab eq 1}">class="admin_menu_ul_li_a_hover"</c:if> <c:if test="${tab ne 1}">class="admin_menu_ul_li_a"</c:if> onclick="$('#main_load').load('adminpage_report_r.o?tab=1');">리뷰 신고내역</a></li>
			<li><a href="#100" <c:if test="${tab eq 2}">class="admin_menu_ul_li_a_hover"</c:if> <c:if test="${tab ne 2}">class="admin_menu_ul_li_a"</c:if> onclick="$('#main_load').load('adminpage_report_r.o?tab=2');">면접 신고내역</a></li>
		</ul>
    
    </div>
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
  </div>
</div>
</div>



<!-- 리뷰신고 상세보기 영역 -->
<div id="adminpage_report_r_hidden"></div>







<div class="container">
  <div class="row">
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
    <div class="col-sm-10 col-md-10 col-lg-8">
    
    
    <div class="admin_member">
    	<h2>
    		<c:if test="${tab eq 1}">리뷰신고</c:if>
    		<c:if test="${tab eq 2}">면접후기신고</c:if>
    	</h2>
    	<h5><span>${count}</span>건의 신고내용이 있습니다</h5>
    	<table cellpadding="0" cellspacing="0" class="admin_member_table">
    	<col width="80" />
    	<col width="80" />
    	<col width="150" />
    	<col width="80" />
    		<tr>
    			<th>회원번호</th>
    			<th>이름</th>
    			<th>사유</th>
    			<th>편집</th>
    		</tr>
    	<c:forEach items="${list}" var="rpdata">
    		<tr>
    			<td>${rpdata.mdata.no}</td>
    			<td>${rpdata.mdata.name}</td>
    			<td style="text-align:left;">
    				<c:if test="${rpdata.report_value eq 1}">비하/비방의 의미를 가진 저속한 표현</c:if>
					<c:if test="${rpdata.report_value eq 2}">오타, 내용 반복, 무의미한 단어 나열</c:if>
					<c:if test="${rpdata.report_value eq 3}">다른 게시물을 도용</c:if>
					<c:if test="${rpdata.report_value eq 4}">기업명, 산업군, 직무가 다르게 선택</c:if>
					<c:if test="${rpdata.report_value eq 5}">특정기업이나 상품의 광고/홍보</c:if>
					<c:if test="${rpdata.report_value eq 6}">명예훼손, 사생활 침해, 개인정보 노출</c:if>
					<c:if test="${rpdata.report_value eq 7}">기타 권리침해 또는 기업기밀 누설</c:if>
    			</td>
    			<c:if test="${tab eq 1}">
    			<td><a href="#100" onclick="adminpage_report_r_show_ajax(${rpdata.no},${pages_r},${tab});">상세보기</a></td>
    			</c:if>
    			<c:if test="${tab eq 2}">
    			<td><a href="#100" onclick="adminpage_report_i_show_ajax(${rpdata.no},${pages_r},${tab});">상세보기</a></td>
    			</c:if>
    		</tr>
    	</c:forEach>
    	</table>
    	
    	
    	<div class="paging">
        <a href="#100" onclick="$('#main_load').load('adminpage_report_r.o?pages_r=1&adminSearchV=${adminSearchV_utf}&adminSearch=${adminSearch}&tab=${tab}');" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>
        <c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
        	<a href="#100" onclick="$('#main_load').load('adminpage_report_r.o?pages_r=${i}&adminSearchV=${adminSearchV_utf}&adminSearch=${adminSearch}&tab=${tab}');" 
        		<c:if test="${i ne pages_r}"> class="paging_a"</c:if> <c:if test="${i eq pages_r}"> class="paging_a_hover"</c:if>>
        		${i}
        	</a>
        </c:forEach>
        <a href="#100" onclick="$('#main_load').load('adminpage_report_r.o?pages_r=${paging.board_paging}&adminSearchV=${adminSearchV_utf}&adminSearch=${adminSearch}&tab=${tab}');" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>
      </div>
    </div>
    
    
    </div>
    <div class="col-sm-1 col-md-1 col-lg-2"></div>
  </div>
</div>