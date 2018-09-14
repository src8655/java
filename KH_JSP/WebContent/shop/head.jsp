<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./ckeditor/ckeditor.js"></script>
<style type="text/css">
img {
border:0px;
}
body{
background:url(./images/header_bg.jpg) left top repeat-x;
margin:0px;
padding:0px;
font-family:'돋움';
}
#top_bg {
background:#f2f2f2;
margin:0px;
padding:0px;
width:100%;
height:25px;
border-bottom:1px solid #e2e2e2;
overflow:hidden;
}
#top_bg ul {
margin:0 auto;
padding:0px;
list-style:none;
width:965px;
height:25px;
overflow:hidden;
}
#top_bg ul li {
float:right;
height:25px;
line-height:23px;
margin:0px;
padding:0px;
overflow:hidden;
}
#top_bg ul li a {
border-left:1px solid #c1c1c1;
text-decoration:none;
color:#666666;
font-size:11px;
margin:0 0 0 10px;
padding:0 0 0 10px;
}
#header {
background:url(./images/header.jpg) left top no-repeat;
width:965px;
height:128px;
margin:0 auto;
padding:0px;
overflow:hidden;
}
#header h1 {
float:left;
width:250px;
height:128px;
margin:0px;
padding:0px;
overflow:hidden;
}
#header h1 a {
width:91px;
height:38px;
text-decoration:none;
margin:50px 0 0 60px;
display:block;
}
#header_c {
float:left;
width:465px;
height:128px;
overflow:hidden;
}
#header_r {
float:right;
width:250px;
height:128px;
overflow:hidden;
}
#header_r a {
width:199px;
height:61px;
margin:35px 20px 0 0;
text-decoration:none;
display:block;
}
#header_c_t {
margin:0 auto;
margin-top:27px;
padding:0px;
width:295px;
height:20px;
list-style:none;
overflow:hidden;
}
#header_c_t li {
float:left;
height:20px;
overflow:hidden;
}
#header_c_t li a {
border-right:1px solid #c1c1c1;
text-decoration:none;
color:#666666;
font-size:11px;
margin:0 5px 0 0;
padding:0 5px 0 0;
}
#header_c_c {
margin:0 auto;
margin-top:15px;
padding:0px;
width:397px;
height:30px;
overflow:hidden;
}
#header_c_c_l {
float:left;
width:356px;
height:30px;
margin:0px;
padding:0px;
overflow:hidden;
}
#header_c_c_r {
float:right;
width:38px;
height:30px;
margin:0px;
padding:0px;
overflow:hidden;
}
#header_c_c_l_text {
border:3px solid #fc3500;
margin:0px;
padding:0px;
width:350px;
height:24px;
overflow:hidden;
}
#header_c_c_l_button {
background:url(./images/top_search.jpg) left top no-repeat;
border:0px;
width:38px;
height:30px;
margin:0px;
padding:0px;
overflow:hidden;
}
#header_c_b {
width:250px;
height:15px;
list-style:none;
margin:0 auto;
margin-top:10px;
padding:0px;
overflow:hidden;
}
#header_c_b li {
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
#header_c_b li a {
border-right:1px solid #c1c1c1;
margin:0 7px 0 0;
padding:0 7px 0 0;
}
#contents {
width:965px;
margin:0 auto;
}
#main {
width:965px;
margin:0px;
padding:0px;
overflow:hidden;
}
.main_menu {
float:left;
list-style:none;
width:202px;
margin:30px 0 0 0;
padding:0px;
overflow:hidden;
}
.main_menu li {
border-bottom:1px solid #e8e8e8;
margin:0px;
padding:5px 0 5px 0;
overflow:hidden;
}
.main_menu li a {
text-decoration:none;
margin:0 0 0 10px;
}
.main_best {
float:right;
width:748px;
margin:40px 0 0 0;
padding:0px;
overflow:hidden;
}
.main_best_top {
background:url(./images/tab.jpg) left top repeat-x;
width:748px;
height:27px;
margin:0px;
padding:0px;
overflow:hidden;
}
.main_best_top h1 {
float:left;
width:61px;
height:15px;
margin:0 0 0 5px;
padding:0px;
overflow:hidden;
}
.main_best_top h1 img {
display:block;
width:61px;
height:15px;
margin:0px;
padding:0px;
}
.main_best_top ul {
display:block;
float:right;
width:682px;
height:27px;
list-style:none;
margin:0px;
padding:0px;
overflow:hidden;
}
.main_best_top ul li {
float:right;
margin:0px;
padding:0px;
overflow:hidden;
}
.main_best_top_a {
border-left:1px solid #cccccc;
text-decoration:none;
font-size:11px;
color:#858585;
margin:5px 0 0 0;
padding:0 10px 0 10px;
height:12px;
display:block;
}
.main_best_top ul li a:hover {
background:#ffffff;
border:1px solid #c7c7c7;
display:block;
color:#626262;
height:27px;
line-height:27px;
margin:0px;
}
.main_best_top_hover {
text-decoration:none;
font-size:11px;
color:#858585;
background:#ffffff;
border:1px solid #c7c7c7;
display:block;
color:#626262;
height:27px;
line-height:27px;
margin:0px;
padding:0 10px 0 10px;
font-weight:bold;
}
.main_best_top_a_noborder {
text-decoration:none;
font-size:11px;
color:#858585;
margin:5px 0 0 0;
padding:0 10px 0 10px;
height:12px;
display:block;
}
.main_best_bottom {
list-style:none;
margin:20px 0 0 0;
padding:0px;
overflow:hidden;
}
.main_best_bottom li {
float:left;
text-align:center;
margin:0 17px 0 17px;
padding:0px;
overflow:hidden;
}
.main_best_bottom li a {
text-decoration:none;
margin:0px;
padding:0px;
color:#666666;
font-size:12px;
}
.main_list {
border-top:2px solid #aaaaaa;
border-bottom:1px solid #e4e4e4;
width:965px;
height:223px;
margin:10px 0 5px 0;
padding:0px;
overflow:hidden;
}
.main_list h1 {
float:left;
width:202px;
height:223px;
margin:0px;
padding:0px;
overflow:hidden;
}
.main_list ul {
float:right;
width:763px;
list-style:none;
margin:0px;
padding:0px;
overflow:hidden;
}
.main_list ul li {
border-right:1px solid #e4e4e4;
float:left;
text-align:center;
margin:0px;
padding:10px 0 0 0;
width:151px;
height:223px;
overflow:hidden;
}
.main_list ul li a {
font-size:12px;
text-decoration:none;
color:#666666;
margin:0px;
overflow:hidden;
}
#copy_bg {
background:url(./images/bottom_bg.jpg) left top repeat-x;
width:100%;
margin:35px 0 0 0;
padding:35px 0 0 0;
overflow:hidden;
}
#copy {
margin:0 auto;
margin-bottom:30px;
padding:0px;
width:965px;
overflow:hidden;
}
#copy h1 {
float:left;
width:200px;
height:110px;
margin:0px;
padding:0px;
border-right:1px solid #e5e5e5;
overflow:hidden;
}
#copy h1 img {
margin:30px 0 0 50px;
}
#copy_c {
float:left;
width:539px;
margin:10px 0 0 20px;
padding:0px;
overflow:hidden;
}
#copy_c ul {
list-style:none;
width:100%;
margin:0px;
padding:0px;
overflow:hidden;
}
#copy_c ul li {
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
#copy_c ul li a {
border-right:1px solid #dedede;
text-decoration:none;
color:#8e8e8e;
padding:0 15px 0 0;
margin:0 15px 0 0;
font-size:11px;
}
#copy_c p {
background:url(./images/copyright.jpg) left top no-repeat;
font-size:0px;
line-height:5000px;
width:539px;
height:56px;
margin:10px 0 0 0;
padding:0px;
overflow:hidden;
}
#copy_r {
float:right;
background:url(./images/copy_mark.jpg) left top no-repeat;
width:185px;
height:46px;
margin:45px 0 0 0;
padding:0px;
overflow:hidden;
}


#list_tab {
border-bottom:1px solid #dadada;
border-left:1px solid #dadada;
width:963px;
list-style:none;
margin:40px 0 0 0;
padding:0px;
overflow:hidden;
}
#list_tab li {
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
#list_tab li a {
text-align:center;
width:106px;
float:left;
display:block;
margin:0px;
text-decoration:none;
border-right:1px solid #dadada;
font-size:14px;
}
#list_tab li a:hover {
background:#ffffff;
border-top:2px solid #575757;
border-bottom:0px;
padding:14px 0 16px 0;
color:#111111;
font-weight:bold;
}
.list_tab_a_hover {
background:#ffffff;
border-top:2px solid #575757;
border-bottom:0px;
padding:14px 0 16px 0;
color:#111111;
font-weight:bold;
}
.list_tab_a {
background:#f5f5f5;
border-top:1px solid #dadada;
border-bottom:1px solid #dadada;
padding:15px 0 15px 0;
color:#666666;
}
.list_data {
width:965px;
list-style:none;
margin:0px;
padding:0px;
overflow:hidden;
}
.list_data li {
border-right:1px solid #dddddd;
border-bottom:1px solid #dddddd;
float:left;
margin:0px;
padding:20px 0px 20px 0px;
width:192px;
text-align:center;
overflow:hidden;
}
.list_data li a {
text-decoration:none;
font-size:12px;
color:#666666;
}
.list_page {
margin-top:30px;
margin-bottom:20px;
padding:0px;
width:965px;
text-align:center;
overflow:hidden;
}
.list_page a {
text-decoration:none;
display:inline-block;
padding:8px 10px 8px 10px;
margin:0 3px 0 0;
font-size:11px;
}
.list_page a:hover {
background:#f62e3d;
color:#ffffff;
border:1px solid #b70922;
}
.list_page_a_hover {
background:#f62e3d;
color:#ffffff;
border:1px solid #b70922;
}
.list_page_a {
background:#ffffff;
color:#666666;
border:1px solid #c7c7c7;
}


.list_v_t {
border-bottom:1px solid #adadad;
margin:40px 0 10px 0;
padding:0 0 10px 0;
overflow:hidden;
}
.list_v_t h1 {
border-bottom:2px solid #5c5c5c;
width:955px;
margin:0px;
padding:0 0 15px 10px;
font-size:30px;
overflow:hidden;
}
.list_v_t_l {
float:left;
width:400px;
height:400px;
margin:0px;
padding:0 10px 0 10px;
overflow:hidden;
}
.list_v_t_l img {
margin:10px 0 0 0;
}
.list_v_t_r {
float:right;
width:545px;
margin:0px;
padding:0px;
overflow:hidden;
}
.list_v_t_r_t {
background:#f3f3f3;
width:565px;
margin:0px;
padding:40px;
overflow:hidden;
}
.list_v_dcl {
float:left;
color:#f43142;
font-weight:bold;
font-size:50px;
font-family:'Arial';
width:100px;
margin:0px;
padding:0px;
}
.list_v_dcr {
font-family:'Arial';
float:left;
margin:0px;
padding:0px;
font-size:34px;
}
.list_v_t_r_box1 {
background:#fafafa;
width:100%;
height:50px;
line-height:50px;
font-size:17px;
font-weight:bold;
padding:0 0 0 40px;
}
.list_v_t_r_box2 {
background:#f3f3f3;
width:100%;
height:50px;
line-height:50px;
font-size:17px;
font-weight:bold;
padding:0 0 0 40px;
}
.list_v_t_r_box2_l {
float:left;
width:120px;
margin:0px;
padding:0px;
overflow:hidden;
}
.list_v_t_r_box2_r {
float:left;
text-align:center;
margin:0px;
padding:0px;
overflow:hidden;
}
.view_btn {
background:#ffffff;
width:22px;
height:22px;
font-size:15px;
margin:0px;
padding:0px;
border:1px solid #a1a1a1;
}
.view_input {
background:#ffffff;
width:30px;
height:20px;
font-size:15px;
margin:0px;
padding:0 3px 0 3px;
border:1px solid #a1a1a1;
}
.list_v_t_r_btn {
width:355px;
margin:0 auto;
margin-top:30px;
padding:0px;
overflow:hidden;
}
.list_v_t_r_btn a {
float:left;
height:50px
display:block;
margin:0px;
padding:0px;
overflow:hidden;
}


.boards {
font-size:17px;
width:100%;
margin:40px 0 0 0;
border-collapse:collapse;
}
.boards th {
border-top:2px solid #122942;
border-bottom:1px solid #A0A0A0;
height:45px;
line-height:45px;
margin:0px;
padding:0px;
}
.boards td {
border-bottom:1px solid #A0A0A0;
padding:10px 3px 10px 3px;
}
.boards td a {
text-decoration:none;
color:#000000;
}
.boards_b {
width:100%;
margin:10px 0 0 0;
padding:0px;
overflow:hidden;
}
.boards_bl {
width:30%;
float:left;
text-align:left;
overflow:hidden;
}
.boards_br {
width:30%;
float:right;
text-align:right;
overflow:hidden;
}
.boards_bc {
width:40%;
height:26px;
line-height:26px;
float:left;
text-align:center;
overflow:hidden;
}
.boards_bc a {
text-decoration:none;
color:#000000;
margin:0 3px 0 0;
}
.boards input {
border:1px solid #cccccc;
width:150px;
height:30px;
line-height:30px;
font-size:17px;
margin:0px;
padding:0px;
overflow:hidden;
}
.boards_header {
width:100%;
margin:10px 0 3px 0;
padding:0px;
overflow:hidden;
}
.boards_header p {
margin:0px;
padding:0px;
width:230px;
}
.boards_header p a {
text-decoration:none;
color:#000000;
}
.btn_st {
border:1px solid #cccccc;
background:#eeeeee;
color:#000000;
padding:0px;
width:78px;
height:35px;
line-height:35px;
text-decoration:none;
display:block;
font-size:15px;
text-align:center;
overflow:hidden;
}
.selects {
font-size:17px;
width:150px;
height:30px;
}
.b_memo {
border:1px solid #cccccc;
width:99%;
height:350px;
font-size:15px;
margin:0px;
padding:0px;
}
.file_img_bg {
width:235px;
height:235px;
overflow:hidden;
}
.file_img_btn a {
float:left;
margin:0 2px 0 2px;
}
.hides {
display:none;
}
.list_v_c {
width:965px;
text-align:center;
overflow:hidden;
}
</style>
<script type="text/javascript">
function tab(vars, vars_this, vars_right) {
  //모든 탭, 탭내용 초기화
  var i;
  for(i=1;i<=8;i++){
    document.getElementById("tab_"+i).style.display = "none";
    document.getElementById("mbt"+i).setAttribute("class","main_best_top_a");
  }
  document.getElementById(vars).style.display = "block";
  
  if(vars_right != "none") {
    document.getElementById(vars_right).setAttribute("class","main_best_top_a_noborder");
  }
  
  vars_this.setAttribute("class","main_best_top_hover");
}
function counts_p() {
  var cnt = document.getElementById("counts").value;
  cnt++;
  document.getElementById("counts").value = cnt;
}
function counts_m() {
  var cnt = document.getElementById("counts").value;
  cnt--;
  if(cnt < 1) cnt = 1;
  document.getElementById("counts").value = cnt;
}




//파일처리
function open_file(files) {
document.getElementById(files).click();
}
function change_img(imgs, files) {
var reader = new FileReader();
reader.onload = function (e) {
  document.getElementById(imgs).setAttribute("src",e.target.result);
}
reader.readAsDataURL(files.files[0]);
}



//작성하기 submit전 체크
function checkIt(targets) {
	if(!targets.name.value) {
		alert("제품명을 입력하세요");
		return false;
	}
	if(!targets.money.value) {
		alert("판매금액을 입력하세요");
		return false;
	}
	if(!targets.discount.value) {
		alert("할인율을 입력하세요");
		return false;
	}
	if(!targets.made.value) {
		alert("원산지를 입력하세요");
		return false;
	}
	if(!targets.ship_money.value) {
		alert("배송비용을 입력하세요");
		return false;
	}
}


//빠른검색
function quick_search(searchs_v) {
	var inp = document.getElementById(header_c_c_l_search);
	inp.searchs.value = "";
	inp.searchs_value.value = searchs_v;
	////////////
	//
}
</script>
</head>
<body>

<div id="top_bg">
  <ul>
    <li><a href="#">고객센터</a></li>
    <li><a href="#" style="color:#adc12c;">나의 쇼핑정보 <img src="./images/myinfo.jpg" alt="나의 쇼핑정보" /></a></li>
    <li><a href="#">장바구니</a></li>
    <li><a href="#">회원가입</a></li>
    <li><a href="#" style="border:0px;">로그인</a></li>
  </ul>
</div>
<div id="header">
  <h1><a href="index.o"><img src="./images/logo.jpg" alt="logo" /></a></h1>
  <div id="header_c">
    <ul id="header_c_t">
      <li><a href="#100" onclick="quick_search('산삼/장뇌삼');">산삼/장뇌삼</a></li>
      <li><a href="#100" onclick="quick_search('약용버섯');">약용버섯</a></li>
      <li><a href="#100" onclick="quick_search('식물');">식물</a></li>
      <li><a href="#100" onclick="quick_search('진액');">진액</a></li>
      <li><a href="#100" onclick="quick_search('액기스');">액기스</a></li>
      <li><a href="#100" onclick="quick_search('홍삼가공');" style="border:0px;">홍삼가공</a></li>
    </ul>
    <div id="header_c_c">
    <form action="list.o" method="get" id="header_c_c_l_search">
      <input type="hidden" name="searchs" value="${searchs}" />
      <div id="header_c_c_l">
        <input type="text" name="searchs_value" value="${searchs_value}" id="header_c_c_l_text" />
      </div>
      <div id="header_c_c_r">
        <input type="submit" value="" id="header_c_c_l_button" />
      </div>
    </form>
    </div>
    <ul id="header_c_b">
      <li><a href="#"><img src="./images/top_menu_01.jpg" alt="베스트셀러" /></a></li>
      <li><a href="#"><img src="./images/top_menu_02.jpg" alt="영카트 추천상품" /></a></li>
      <li><a href="#" style="border:0px;"><img src="./images/top_menu_03.jpg" alt="무료배송상품" /></a></li>
    </ul>
  </div>
  <div id="header_r">
    <a href="#100" onclick="quick_search('박광희김치');"><img src="./images/top_right_menu.jpg" alt="박광희김치" /></a>
  </div>
</div>

<div id="contents">