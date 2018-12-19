<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


  	</div>
  	<div class="contents_color">
  	<!--  -->
  	
  	
  	
  	
	<div class="join_agree">
		<div class="join_agree_header">
			<h1>
				회원 가입
			</h1>
			<ul>
				<li>3 가입완료</li>
				<li>2 정보입력</li>
				<li style="color:#ea0000;border-bottom:2px solid #ea0000;">1 약관동의</li>
			</ul>
		</div>
		<p class="join_agree_c">개인정보 수집 및 이용에 동의하셔야 회원가입이 가능합니다.</p>
		<div class="join_agree_b">
			<div class="join_agree_b_t">
				<h1>KH TOUR 개인정보 이용 약관 동의</h1>
				<input type="checkbox" name="agrees" id="agrees" />
				<label for="agrees"></label>
				<p>모두동의</p>
			</div>
			<div class="join_agree_b_b">
				<div>
					<%@ include file="agrees.jsp" %>
				</div>
			</div>
		</div>
		<div class="join_red_button">
			<a href="#10" onclick="join_agree_next();">다음</a>
		</div>
	</div>
  	
  	
  	
  	
  	<!--  -->