<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${adata.title}</title>
<link href="tboard_css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="./ckeditor/contents.css">
<script src="./jquery/jquery-1.4.2.min.js" type="text/javascript"></script>

<script type="text/javascript" src="tboard_js.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="./ckeditor/ckeditor.js"></script>

</head>
<body>
<div id="header">
	<ul id="tmenu">
		<li><a href="map.do?id=map"><img src="./images/tmenu3.jpg" alt="오시는길" /></a></li>
		<c:if test="${member_info ne null}">
		<li><a href="logout.do"><img src="./images/tmenu4.jpg" alt="로그아웃" /></a></li>
		</c:if>
		<c:if test="${member_info eq null}">
		<li><a href="join.do?id=join"><img src="./images/tmenu2.jpg" alt="회원가입" /></a></li>
		<li><a href="login.do"><img src="./images/tmenu1.jpg" alt="로그인" /></a></li>
		</c:if>
	</ul>
	<h1><a href="index.do">로타리종합물류</a></h1>
	<ul id="mainmenu">
		<li class="mainm1"><a href="companyh.do?id=companyh">회사소개</a></li>
		<li class="mainm2"><a href="board.do?id=notice">공지사항</a></li>
		<li class="mainm3"><a href="map.do?id=map">오시는길</a></li>
		<li class="mainm4"><a href="carinfo.do?id=carinfo">차량정보</a></li>
		<li class="mainm5"><a href="board.do?id=q">고객센터</a></li>
		<li style="float:right;" class="mainm6"><a href="sitemap.do" style="width:190px;">사이트맵</a></li>
	</ul>
</div>
<div id="main_sub">
5톤 윙바디 카고 화물 운송주선 업체
1톤~25톤 화물 5톤 윙바디
</div>
<div id="contents">
	<div id="con1">
		${adata.submenu}
  	<div class="icons" id="icons_3" style="border-bottom:0px;margin:0px;padding:0 15px 0 15px;">
  		  <a href="#">전화문의</a>
  	</div>
  	  	<div class="icons" id="icons_1" style="margin:0px;padding:0 15px 0 15px;">
  		<a href="board_write.do?id=q">온라인문의</a>
  		</div>
		<div class="icons" id="icons_2" style="display:none;margin:0 0 10px 0;padding:0 15px 0 15px;">
  		<a href="map.do?id=map">오시는길</a>
  		</div>
	</div>
	<div id="con2">
		${adata.sitemap}

  	
  	

  
