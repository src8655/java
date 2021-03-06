<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${order eq 1}">
<div class="basket_top" style="width:965px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:300px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;베스트셀러</p>
	</h1>
	<div class="basket_b" style="float:right;width:152px;height:42px;">
		<a href="list.o" onclick="buys.submit()" style="width:150px;height:40px;line-height:40px;margin:0px;padding:0px;text-align:center;">모두보기</a>
	</div>
</div>
</c:if>
<c:if test="${order eq 2}">
<div class="basket_top" style="width:965px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:500px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;영카트 추천상품</p>
	</h1>
	<div class="basket_b" style="float:right;width:152px;height:42px;">
		<a href="list.o" onclick="buys.submit()" style="width:150px;height:40px;line-height:40px;margin:0px;padding:0px;text-align:center;">모두보기</a>
	</div>
</div>
</c:if>
<c:if test="${order eq 3}">
<div class="basket_top" style="width:965px;margin:0 auto;margin-top:10px;margin-bottom:20px;">
	<h1 style="width:300px;">
		<div><img src="./images/basket.jpg" alt="장바구니" /></div>
		<p>&nbsp;무료배송</p>
	</h1>
	<div class="basket_b" style="float:right;width:152px;height:42px;">
		<a href="list.o" onclick="buys.submit()" style="width:150px;height:40px;line-height:40px;margin:0px;padding:0px;text-align:center;">모두보기</a>
	</div>
</div>
</c:if>

  <ul id="list_tab">
    <li><a href="list.o?searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs ne -1}">class="list_tab_a"</c:if> <c:if test="${searchs eq -1}">class="list_tab_a_hover"</c:if>>전체상품</a></li>
    <li><a href="list.o?searchs=1&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 1}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 1}">class="list_tab_a"</c:if>>쌀/잡곡</a></li>
    <li><a href="list.o?searchs=2&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 2}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 2}">class="list_tab_a"</c:if>>과일/채소</a></li>
    <li><a href="list.o?searchs=3&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 3}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 3}">class="list_tab_a"</c:if>>축산물</a></li>
    <li><a href="list.o?searchs=4&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 4}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 4}">class="list_tab_a"</c:if>>건강식품</a></li>
    <li><a href="list.o?searchs=5&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 5}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 5}">class="list_tab_a"</c:if>>가공식품</a></li>
    <li><a href="list.o?searchs=6&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 6}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 6}">class="list_tab_a"</c:if>>수산물</a></li>
    <li><a href="list.o?searchs=7&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 7}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 7}">class="list_tab_a"</c:if>>김치/장류</a></li>
    <li><a href="list.o?searchs=8&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${searchs eq 8}">class="list_tab_a_hover"</c:if><c:if test="${searchs ne 8}">class="list_tab_a"</c:if>>공예/공산품</a></li>
  </ul>
  <ul class="list_data">
<c:forEach var="ldata" items="${list}">
    <li <c:if test="${ldata.cnt eq 5}">style="border-right:none"</c:if>>
      <a href="view.o?no=${ldata.no}&amp;searchs=${searchs}&amp;searchs_value=${searchs_values}&order=${order}">
      	<c:if test="${ldata.file1 eq null}"><img src="./images/noimg.jpg" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <c:if test="${ldata.file1 ne null}"><img src="./upload/${ldata.file1}" width="120px" height="120px" alt="${ldata.name}" /></c:if>
        <br />
        <c:if test="${ldata.ship_money eq 0}"><img src="./images/free.jpg" alt="무료배송" /></c:if><br />
        <c:if test="${ldata.buy ge 10}"><img src="./images/m_l_best.jpg" alt="best" /></c:if>
        <c:if test="${ldata.hit ge 10}"><img src="./images/m_l_plus.jpg" alt="plus" /></c:if><br />
        <p style="height:15px;padding:0 10px 0 10px;margin:0px;overflow:hidden;">${ldata.name}</p>
        <span style="font-size:12px;color:#666666;">
        	<s>${ldata.moneys}원</s>
        </span><br />
        <span style="font-weight:bold;">${ldata.rmoneys}원</span>
      </a>
    </li>
</c:forEach>
  </ul>


  <div class="list_page">
	<a href="list.o?pages=1&amp;searchs=${searchs}&amp;searchs_value=${searchs_values}&order=${order}" class="list_page_a">◀</a>
	<c:forEach begin="${paging.pstarts}" end="${paging.pends}" step="1" var="i">
		<a href="list.o?pages=${i}&amp;searchs=${searchs}&amp;searchs_value=${searchs_values}&order=${order}" <c:if test="${i ne pages_int}"> class="list_page_a"</c:if> <c:if test="${i eq pages_int}"> class="list_page_a_hover"</c:if>>${i}</a>
	</c:forEach>
	<a href="list.o?pages=${paging.board_paging}&amp;searchs=${searchs}&amp;searchs_value=${searchs_values}&order=${order}" class="list_page_a">▶</a>
  </div>
