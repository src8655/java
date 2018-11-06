<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title><tiles:getAsString name="title" /></title>
<script src="./jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="./ckeditor/ckeditor.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="./Itinerary.css" rel="stylesheet" type="text/css" />
<style type="text/css">
img {
border:0px;
}
body{
background:url(./images/top_bg.jpg) left top repeat-x;
margin:0px;
padding:0px;
font-family:'돋움';
}
#header {
margin:0 auto;
padding:0px;
width:1148px;
height:91px;
overflow:hidden;
}
#header_l {
width:480px;
height:13px;
line-height:13px;
float:left;
margin:66px 0 0 0;
padding:0px;
overflow:hidden;
}
#header_l a {
text-decoration:none;
width:93px;
height:15px;
margin:0px;
padding:0px;
overflow:hidden;
}
#header h1 {
float:left;
width:188px;
height:32px;
margin-top:30px;
padding:0px;
text-align:center;
overflow:hidden;
}
#header h1 a {
width:153px;
height:32px;
margin:0px;
padding:0px;
overflow:hidden;
}
#header ul {
float:right;
width:480px;
list-style:none;
margin:66px 0 0 0;
padding:0px;
overflow:hidden;
}
#header ul li {
height:13px;
line-height:13px;
border-right:1px solid #666666;
float:right;
margin:0px;
padding:0 12px 0 12px;
overflow:hidden;
}
#header ul li a {
font-family:'Arial';
height:13px;
line-height:13px;
color:#151d31;
text-decoration:none;
font-size:12px;
font-weight:bold;
margin:0px;
padding:0px;
overflow:hidden;
}
#main_menu {
margin:0 auto;
padding:0px;
width:1148px;
height:49px;
overflow:hidden;
}
#main_menu ul {
float:left;
width:911px;
height:49px;
list-style:none;
margin:0px;
padding:0px;
overflow:hidden;
}
#main_menu ul li {
height:49px;
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
#main_menu ul li a {
text-decoration:none;
height:49px;
line-height:55px;
display:block;
overflow:hidden;
}
.main_menu_line {
width:1px;
height:49px;
line-height:49px;
}
.main_menu_a {
padding:0 23px 0 23px;
}
.main_menu_a_hover {
background:#3aabc6;
padding:0 23px 0 23px;
}
.main_menu_a:hover {
background:#3aabc6;
padding:0 23px 0 23px;
}
.main_menu_a_sitemap {
background:#4bc9e7;
padding:0 23px 0 23px;
}
#main_menu_form {
float:right;
width:237px;
height:30px;
margin:9px 0 0 0;
padding:0px;
overflow:hidden;
}
#main_menu_form_l {
float:left;
width:181px;
height:30px;
overflow:hidden;
}
#main_menu_form_l input {
background:#535968;
border:0px;
width:181px;
height:30px;
line-height:30px;
font-size:14px;
color:#ffffff;
margin:0px;
padding:0px;
overflow:hidden;
}
#main_menu_form_r {
float:right;
width:56px;
height:30px;
overflow:hidden;
}
#main_menu_form_r input {
background:url(./images/menu_search.jpg) no-repeat left top;
border:0px;
width:56px;
height:30px;
overflow:hidden;
}
#contents {
margin:0 auto;
width:1148px;
overflow:hidden;
}
.con_line {
width:1148px;
margin:30px 0 0 0;
padding:0px;
overflow:hidden;
}
#con_hot {
float:left;
border:1px solid #c8c8c8;
width:308px;
height:200px;
overflow:hidden;
}
#con_hot h1 {
border-bottom:1px solid #e9e9e9;
font-size:12px;
margin:26px 10px 11px 10px;
padding:0 0 8px 0;
overflow:hidden;
}
#con_hot div {
width:289px;
height:110px;
margin:0 0 0 10px;
padding:0px;
overflow:hidden;
}
#con_hot div a {
width:289px;
height:110px;
text-decoration:none;
margin:0px;
padding:0px;
overflow:hidden;
}
#con_search {
border:5px solid #1286d7;
float:left;
width:503px;
height:192px;
margin:0 0 0 20px;
padding:0px;
overflow:hidden;
}
#con_search_top {
border-bottom:1px solid #2bb7df;
background:#0b70de;
height:48px;
margin:0 0 31px 0;
padding:0px;
overflow:hidden;
}
#con_search_top h1 {
font-size:12px;
width:121px;
height:24px;
line-height:24px;
float:left;
margin:16px 0 0 17px;
padding:0px;
overflow:hidden;
}
#con_search_top p {
float:right;
width:95px;
height:30px;
line-height:30px;
margin:18px 13px 0 0;
padding:0px;
overflow:hidden;
}
.con_search_line {
margin:0px;
padding:0px;
overflow:hidden;
}
.con_search_line div {
width:205px;
float:left;
margin:0 0 11px 17px;
padding:0px;
overflow:hidden;
}
.con_search_line div h1 {
float:left;
width:52px;
height:20px;
line-height:20px;
font-size:12px;
font-weight:bold;
margin:0px;
padding:0px;
overflow:hidden;
}
.con_search_line div p {
float:right;
width:146px;
height:20px;
line-height:1px;
margin:0px;
padding:0px;
overflow:hidden;
}
.con_search_line div p input {
border:1px solid #7f9db9;
width:144px;
height:18px;
line-height:20px;
font-size:12px;
margin:0px;
padding:0px;
overflow:hidden;
}
.con_search_line div p select {
border:1px solid #7f9db9;
width:146px;
height:20px;
line-height:20px;
font-size:12px;
margin:0px;
padding:0px;
overflow:hidden;
}
.con_search_btn {
float:right;
background:url(./images/main_search_button.jpg) no-repeat left top;
border:0px;
width:114px;
height:27px;
margin:0 60px 0 0;
padding:0px;
overflow:hidden;
}
#con_special {
float:right;
border:1px solid #e8e8e8;
width:284px;
height:200px;
margin:0px;
padding:0px;
overflow:hidden;
}
#con_special h1 {
font-size:12px;
line-height:1px;
margin:21px 15px 23px 15px;
padding:0 0 8px 0;
border-bottom:1px solid #e9e9e9;
overflow:hidden;
}
#con_special ul {
list-style:none;
margin:0 15px 0 15px;
padding:0px;
overflow:hidden;
}
#con_special ul li {
margin:0 0 10px 0;
padding:0px;
overflow:hidden;
}
#con_special ul li div {
float:left;
background:#666666;
width:1px;
height:1px;
margin:5px 5px 0 5px;
padding:0px;
overflow:hidden;
}
#con_special ul li a {
width:240px;
float:left;
font-size:12px;
text-decoration:none;
color:#666666;
margin:0px;
padding:0px;
overflow:hidden;
}
#con_special ul li a p {
margin:0px;
padding:0px;
overflow:hidden;
}
#con_notice {
float:left;
width:310px;
margin:0px;
padding:0px;
overflow:hidden;
}
#con_notice h1 {
border:1px solid #cbcbcb;
width:308px;
height:28px;
line-height:0px;
font-size:0px;
margin:0px;
padding:0px;
overflow:hidden;
}
#con_notice h1 p {
float:left;
width:46px;
height:12px;
line-height:0px;
font-size:0px;
margin:8px 0 0 11px;
padding:0px;
overflow:hidden;
}
#con_notice h1 a {
float:right;
display:block;
width:34px;
height:8px;
line-height:0px;
font-size:0px;
margin:12px 7px 0 0;
padding:0px;
overflow:hidden;
}
#con_notice ul {
width:310px;
list-style:none;
margin:0px;
padding:0px;
overflow:hidden;
}
#con_notice li {
width:310px;
margin:15px 0 0 0;
padding:0px;
overflow:hidden;
}
#con_notice li div {
float:left;
background:#a0a0a0;
width:2px;
height:2px;
margin:5px 10px 0 0;
padding:0px;
overflow:hidden;
}
#con_notice li a {
width:298px;
float:left;
font-size:12px;
color:#666666;
text-decoration:none;
margin:0px;
padding:0px;
overflow:hidden;
}
#con_notice li a p {
margin:0px;
padding:0px;
overflow:hidden;
}
.con_tab {
float:right;
width:819px;
overflow:hidden;
}
.con_tab_ul {
background:url(./images/main_tab_bg.jpg) repeat-x left top;
width:819px;
height:34px;
list-style:none;
margin:0px;
padding:0px;
overflow:hidden;
}
.con_tab_ul li {
float:right;
margin:0px;
padding:0px;
overflow:hidden;
}
.con_tab_ul li a {
display:block;
text-align:center;
margin:0 1px 0 1px;
padding:0px;
overflow:hidden;
}
.con_tab_a {
width:84px;
height:32px;
line-height:32px;
border-top:1px solid #b1b1b1;
border-right:1px solid #b1b1b1;
border-left:1px solid #b1b1b1;
}
.con_tab_a_hover {
background:#ffffff;
width:84px;
height:33px;
line-height:32px;
border-top:1px solid #636363;
border-right:1px solid #636363;
border-left:1px solid #636363;
}
.con_tab_data_ul {
width:819px;
list-style:none;
margin:25px 0 0 0;
padding:0px;
overflow:hidden;
}
.con_tab_data_ul li {
float:left;
width:185px;
text-align:center;
margin:0 0 0 15px;
padding:0px;
overflow:hidden;
}
.con_tab_data_ul li a {
width:185px;
text-align:center;
font-size:12px;
text-decoration:none;
color:#000000;
line-height:20px;
margin:0px;
padding:0px;
overflow:hidden;
}
#main_phone {
float:left;
width:309px;
height:230px;
margin:0px;
padding:0px;
overflow:hidden;
}
#copy_bg {
background:url(./images/bottom_bg.jpg) repeat-x left top;
width:100%;
height:155px;
margin:0px;
padding:0px;
overflow:hidden;
}
#copy_bg ul {
margin:0 auto;
padding:9px 0 0 0;
width:1148px;
height:25px;
text-align:center;
list-style:none;
overflow:hidden;
}
#copy_bg ul li {
border-right:1px solid #b8b8b8;
height:12px;
line-height:12px;
display:inline;
margin:0px;
padding:0 26px 0 26px;
overflow:hidden;
}
#copy {
margin:0 auto;
padding:0px;
width:1148px;
height:121px;
overflow:hidden;
}
#copy h1 {
float:left;
margin:30px 0 0 54px;
padding:0px;
width:153px;
height:32px;
overflow:hidden;
}
#copy p {
float:left;
margin:25px 0 0 128px;
padding:0px;
width:500px;
height:42px;
overflow:hidden;
}







.contents_color {
background:#f5f6f8;
width:100%;
margin:0px;
padding:0px;
overflow:hidden;
}
.tour_list {
background:#ffffff;
border:1px solid #cccccc;
width:1097px;
list-style:none;
margin:0 auto;
margin-top:30px;
padding:0px;
overflow:hidden;
}
.tour_list li {
border-right:1px solid #cccccc;
float:left;
width:325px;
margin:0px;
padding:20px 19px 20px 20px;
overflow:hidden;
}
.tour_list li a {
text-decoration:none;
color:#111111;
font-size:12px;
line-height:12px;
width:325px;
margin:0px;
padding:0px;
overflow:hidden;
}
.tour_list li a p {
text-decoration:none;
color:#111111;
font-size:15px;
line-height:15px;
width:325px;
margin:10px 0 10px;
padding:0px;
overflow:hidden;
}
.list_page {
margin:0 auto;
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
.tour_list_floating {
position:absolute;
background:#000000;
opacity:0.5;
width:325px;
height:219px;
overflow:hidden;
}
.tour_list_floating_btn {
position:absolute;
border:2px solid #ffffff;
color:#ffffff;
width:142px;
height:40px;
line-height:40px;
font-size:15px;
font-weight:bold;
font-family:'Arial';
text-align:center;
margin:90px 0 0 85px;
padding:0px;
overflow:hidden;
}
.tour_floating {
position:absolute;
background:#000000;
opacity:0.5;
width:185px;
height:125px;
overflow:hidden;
}
.tour_floating_btn {
position:absolute;
border:2px solid #ffffff;
color:#ffffff;
width:142px;
height:40px;
line-height:40px;
font-size:15px;
font-weight:bold;
font-family:'Arial';
text-align:center;
margin:40px 0 0 20px;
padding:0px;
overflow:hidden;
}










.tour_view_bg {
width:1100px;
margin:0 auto;
margin-top:30px;
margin-bottom:50px;
padding:0px;
overflow:hidden;
}
.tour_view_bg h1 {
width:1098px;
height:60px;
line-height:60px;
font-size:21px;
margin:0px;
padding:0px;
overflow:hidden;
}
.tour_view {
background:#ffffff;
border-top:2px solid #111111;
border-right:1px solid #bebebe;
border-bottom:1px solid #bebebe;
border-left:1px solid #bebebe;
width:1098px;
margin:0px;
padding:0px;
overflow:hidden;
}
.tour_view_l {
float:left;
width:332px;
margin:0px;
padding:30px;
overflow:hidden;
}
.tour_view_l img {
width:325px;
height:219px;
margin:0 0 15px 0;
padding:0px;
overflow:hidden;
}
.tour_view_l p {
font-size:12px;
line-height:12px;
padding:15px 0 0 0;
margin:0px;
overflow:hidden;
}
.tour_view_r {
border-left:1px solid #bebebe;
float:right;
width:685px;
height:500px;
margin:0px;
padding:10px;
overflow-y:scroll;
}
.tour_view_r table {
width:100%;
border-collapse:collapse;
margin:0px;
padding:0px;
overflow:hidden;
}
.tour_view_r table tr th {
background:#3f4b5b;
border:1px solid #36404d;
color:#ffffff;
font-size:14px;
height:52px;
margin:0px;
padding:0px;
}
.tour_view_r table tr td {
border:1px solid #cccccc;
margin:0px;
padding:10px;
color:#555555;
font-size:12px;
line-height:17px;
text-align:center;
}
.tour_view_contents {
background:#ffffff;
border-right:1px solid #bebebe;
border-bottom:1px solid #bebebe;
border-left:1px solid #bebebe;
width:1038px;
margin:0px;
padding:30px;
overflow:hidden;
}
.tour_view_input {
width:98%;
margin:0 0 3px 0;
padding:0px;
height:25px;
line-height:25px;
font-size:12px;
overflow:hidden;
}
.tour_view_btn {
background:#ffffff;
border:1px solid #cccccc;
margin:0 0 3px 0;
padding:0px;
width:98%;
height:30px;
line-height:30px;
font-size:12px;
font-weight:bold;
overflow:hidden;
}
.bottom_btn {
margin:0 auto;
margin-top:30px;
margin-bottom:60px;
width:1148px;
text-align:center;
overflow:hidden;
}
.bottom_btn a {
background:#eb2b2b;
font-size:15px;
font-weight:bold;
color:#ffffff;
text-decoration:none;
display:inline-block;
width:150px;
height:45px;
line-height:45px;
text-align:center;
margin:0px;
border-top:1px solid #d81818;
border-right:1px solid #d81818;
border-bottom:1px solid #9e1212;
border-left:1px solid #d81818;
}
.tour_write_input {
color:#666666;
width:98%;
margin:0 0 3px 0;
padding:0px;
height:33px;
line-height:33px;
font-size:17px;
overflow:hidden;
}
.tour_write_textarea {
margin:0 auto;
padding:0px;
width:1038px;
height:800px;
}
.tour_write_textarea1 {
margin:0 auto;
padding:0px;
width:98%;
height:200px;
}







.login_bg {
width:694px;
margin:0 auto;
margin-top:40px;
margin-bottom:40px;
overflow:hidden;
}
.login_bg h1 {
font-family:'Arial';
font-weight:bold;
width:694px;
font-size:40px;
color:#f43030;
margin:0px;
padding:0 0 15px 0;
border-bottom:5px solid #616161;
overflow:hidden;
}
.login {
margin:0px;
padding:35px 0 35px 0;
background:#f7f7f7;
border-right:1px solid #e8e8e8;
border-bottom:1px solid #e8e8e8;
border-left:1px solid #e8e8e8;
overflow:hidden;
}
.login_box {
background:#ffffff;
width:445px;
margin:0 auto;
padding:30px 0 30px 0;
border:1px solid #dcdcdc;
overflow:hidden;
}
.login_box_t {
margin:0 80px 0 80px;
overflow:hidden;
}
.login_box_t_l {
float:left;
width:200px;
overflow:hidden;
}
.login_box_t_l input {
border:1px solid #b4b4b4;
margin:0px;
padding:0px;
width:195px;
height:25px;
font-size:12px;
color:#757575;
overflow:hidden;
}
.login_box_t a {
float:right;
background:#ec2d2d;
border-top:1px solid #c41617;
border-right:1px solid #c41617;
border-bottom:1px solid #90100f;
border-left:1px solid #c41617;
width:82px;
height:55px;
line-height:55px;
text-align:center;
font-size:14px;
font-weight:bold;
text-decoration:none;
color:#ffffff;
display:block;
overflow:hidden;
}
.login_box_c {
font-size:12px;
margin:10px 80px 10px 80px;
overflow:hidden;
}
.login_box ul {
list-style:none;
margin:0 0 0 80px;
padding:0px;
overflow:hidden;
}
.login_box ul li {
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
.login_box ul li a {
display:block;
margin:0 5px 0 0;
padding:0px;
width:89px;
height:18px;
line-height:18px;
text-align:center;
color:#4d4d4d;
text-decoration:none;
font-size:11px;
border:1px solid #bdbdbd;
background:#f5f5f5;
overflow:hidden;
}








.join_agree {
margin:0 auto;
margin-top:10px;
margin-bottom:40px;
padding:0px;
width:800px;
overflow:hidden;
}
.join_agree_header {
width:800px;
padding:20px 0 20px 0;
border-bottom:1px solid #c4c5c7;
overflow:hidden;
}
.join_agree_header h1 {
float:left;
font-family:'Arial';
font-size:25px;
margin:0px;
padding:0px;
width:300px;
overflow:hidden;
}
.join_agree_header ul {
float:right;
margin:0px;
padding:0px;
list-style:none;
width:500px;
overflow:hidden;
}
.join_agree_header ul li {
float:right;
margin:5px 0 0 20px;
padding:0 0 3px 0;
font-size:17px;
font-weight:bold;
font-family:'Arial';
color:#999999;
overflow:hidden;
}
.join_agree_c {
margin:10px 0 10px 0;
padding:0px;
font-size:14px;
color:#999999;
overflow:hidden;
}
.join_agree_b {
background:#ffffff;
width:800px;
margin:20px 0 0 0;
padding:0px;
overflow:hidden;
}
.join_agree_b_t {
background:#555555;
width:800px;
padding:10px 0 10px 0;
overflow:hidden;
}
.join_agree_b_t h1 {
font-family:'Arial';
float:left;
font-size:17px;
line-height:25px;
height:25px;
color:#ffffff;
margin:0 0 0 30px;
padding:0px;
overflow:hidden;
}
.join_agree_b_t input {
display:none;
}
.join_agree_b_t label {
float:right;
margin:0 30px 0 0;
background:url(./images/check1.jpg) no-repeat left top;
display:block;
border:0px;
width:25px;
height:25px;
overflow:hidden;
}
.join_agree_b_t label:hover {
background:url(./images/check1.jpg) no-repeat left top;
}
.join_agree_b_t input[type=checkbox]:checked + label {
background:url(./images/check2.jpg) no-repeat left top;
}
.join_agree_b_t p {
float:right;
font-size:17px;
font-weight:bold;
font-family:'Arial';
line-height:25px;
height:25px;
color:#ffffff;
margin:0 3px 0 0;
padding:0px;
overflow:hidden;
}
.join_agree_b_b {
width:738px;
padding:30px;
border-right:1px solid #dcdcdc;
border-bottom:1px solid #dcdcdc;
border-left:1px solid #dcdcdc;
overflow:hidden;
}
.join_agree_b_b div {
border:1px solid #dcdcdc;
width:716;
height:200px;
font-size:12px;
color:#555555;
padding:10px;
overflow-y:scroll;
}
.join_red_button {
width:800px;
overflow:hidden;
}
.join_red_button a {
background:#eb2b2b;
font-size:15px;
font-weight:bold;
color:#ffffff;
text-decoration:none;
display:block;
width:150px;
height:45px;
line-height:45px;
text-align:center;
margin:0 auto;
margin-top:20px;
border-top:1px solid #d81818;
border-right:1px solid #d81818;
border-bottom:1px solid #9e1212;
border-left:1px solid #d81818;
}










.joins {
width:700px;
margin:0 auto;
border:0px;
}
.joins tr th {
text-align:left;
font-weight:normal;
font-size:15px;
color:#4d4d4d;
}
.join_input {
font-size:15px;
padding:0 10px 0 10px;
margin:0px;
height:35px;
line-height:35px;
color:#666666;
width:70%;
}
.join_id_button {
padding:0 10px 0 10px;
margin:0px;
text-align:center;
height:37px;
line-height:37px;
font-size:12px;
font-weight:bold;
color:#ffffff;
background:#7c7c7c;
border-top:1px solid #676767;
border-right:1px solid #676767;
border-bottom:1px solid #4c4c4c;
border-left:1px solid #676767;
}
.join_agree_end {
width:100%;
margin:0px;
padding:100px 0 100px 0;
text-align:center;
font-size:25px;
font-weight:bold;
font-family:'Arial';
overflow:hidden;
}








.login_find_bg {
border-top:3px solid #444444;
border-right:1px solid #e5e5e5;
border-bottom:1px solid #e5e5e5;
border-left:1px solid #e5e5e5;
width:430px;
margin:0 auto;
margin-top:40px;
margin-bottom:40px;
padding:30px;
overflow:hidden;
}
.login_find_bg h1 {
text-align:center;
width:100%;
font-size:17px;
margin:15px 0 30px 0;
padding:0px;
overflow:hidden;
}
.login_find_p {
font-size:12px;
color:#4d4d4d;
margin:0 0 30px 0;
padding:0 20px 0 20px;
overflow:hidden;
}
.login_find_c {
width:390px;
margin:0 0 8px 0;
padding:0 20px 0 20px;
overflow:hidden;
}
.login_find_c_l {
float:left;
height:26px;
line-height:26px;
font-weight:bold;
font-size:12px;
color:#4c4c4c;
width:100px;
overflow:hidden;
}
.login_find_c_r {
float:right;
height:26px;
width:290px;
overflow:hidden;
}
.login_find_input {
border-top:1px solid #a4a4a4;
border-right:1px solid #dbdbdb;
border-bottom:1px solid #dbdbdb;
border-left:1px solid #a4a4a4;
width:288px;
height:24px;
line-height:24px;
font-size:12px;
margin:0px;
padding:0px;
overflow:hidden;
}
.login_find_b {
width:100%;
border-top:1px solid #cccccc;
margin:35px 0 20px 0;
padding:30px 0 0 0;
text-align:center;
overflow:hidden;
}
.login_find_b input {
border-top:1px solid #586c93;
border-right:1px solid #586c93;
border-bottom:1px solid #414f6c;
border-left:1px solid #586c93;
background:#64779c;
height:43px;
line-height:43px;
text-align:center;
font-size:15px;
font-weight:bold;
color:#ffffff;
margin:0px;
padding:0 30px 0 30px;
}












.basket_top {
margin:0 auto;
width:770px;
border-bottom:5px solid #444444;
margin-top:20px;
margin-bottom:20px;
padding:15px 0 15px 0;
overflow:hidden;
}
.basket_top h1 {
float:left;
width:250px;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_top div {
float:left;
width:45px;
height:45px;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_top h1 p {
float:left;
height:45px;
line-height:45px;
font-size:35px;
font-family:'Arial';
margin:0 0 0 5px;
padding:0px;
overflow:hidden;
}
.basket_top_p {
float:right;
height:45px;
line-height:45px;
font-size:17px;
font-family:'Arial';
font-weight:bold;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_top ul {
float:right;
width:500px;
list-style:none;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_top li {
float:right;
margin:0px;
padding:0 5px 0 5px;
height:32px;
line-height:32px;
font-size:20px;
font-family:'Arial';
font-weight:bold;
overflow:hidden;
}











.basket_con {
margin:0 auto;
margin-bottom:40px;
padding:0px;
width:770px;
overflow:hidden;
}
.basket_con_h {
background:url(./images/basket_top_bg.jpg) repeat-x left top;
border-top:1px solid #008a05;
border-right:1px solid #008a05;
border-bottom:1px solid #00670c;
border-left:1px solid #008a05;
width:768px;
height:38px;
line-height:38px;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_con_h div {
background:url(./images/basket_top_h.jpg) no-repeat left top;
float:left;
width:10px;
height:15px;
line-height:15px;
margin:11px 10px 0 15px;
padding:0px;
overflow:hidden;
}
.basket_con_h div img {
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_con_h p {
float:left;
font-size:17px;
font-family:'Arial';
color:#ffffff;
height:38px;
line-height:38px;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_con_data {
width:728px;
border-right:1px solid #cccccc;
border-bottom:1px solid #cccccc;
border-left:1px solid #cccccc;
margin:0px;
padding:20px;
overflow:hidden;
}
.basket_con_data h1 {
font-size:18px;
margin:0px 0 15px 0;
padding:0px;
overflow:hidden;
}
.basket_con_data_l {
float:left;
width:200px;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_btn1 {
background:url(./images/basket_btn.jpg) repeat-x left top;
border-top:1px solid #eb5f01;
border-right:1px solid #eb5f01;
border-bottom:1px solid #e60612;
border-left:1px solid #eb5f01;
width:150px;
height:20px;
line-height:20px;
display:block;
text-decoration:none;
text-align:center;
font-size:12px;
font-weight:bold;
color:#ffffff;
margin:0 auto;
margin-top:5px;
padding:0px;
overflow:hidden;
}
.basket_btn2 {
background:url(./images/basket_btn_del.jpg) repeat-x left top;
border-top:1px solid #cecece;
border-right:1px solid #cecece;
border-bottom:1px solid #b0b0b0;
border-left:1px solid #cecece;
width:150px;
height:20px;
line-height:20px;
display:block;
text-decoration:none;
text-align:center;
font-size:12px;
font-weight:bold;
color:#666666;
margin:0 auto;
margin-top:5px;
padding:0px;
overflow:hidden;
}
.basket_con_data_r {
float:right;
width:518px;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_con_data_r table {
width:100%;
border-collapse:collapse;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_con_data_r table tr th {
border-bottom:1px solid #eeeeee;
background:#f1fbea;
font-size:12px;
text-align:left;
}
.basket_con_data_r table tr td {
border-bottom:1px solid #eeeeee;
background:#ffffff;
font-size:12px;
text-align:left;
}
.basket_con_data_r table tr td select {
font-size:12px;
border:1px solid #cccccc;
width:50px;
height:20px;
margin-right:3px;
}
.basket_con_data_r table tr td input {
font-size:12px;
border:1px solid #cccccc;
font-weight:bold;
line-height:18px;
width:50px;
height:20px;
}

.basket_b {
width:965px;
margin:0 auto;
text-align:center;
overflow:hidden;
}
.basket_b a {
background:#eb2b2b;
font-size:15px;
font-weight:bold;
color:#ffffff;
text-decoration:none;
display:inline-block;
width:150px;
height:45px;
line-height:45px;
text-align:center;
margin:0 auto;
margin:20px 0 20px 0;
border-top:1px solid #d81818;
border-right:1px solid #d81818;
border-bottom:1px solid #9e1212;
border-left:1px solid #d81818;
}












.mypage_h {
width:770px;
height:20px;
font-size:18px;
margin:0 auto;
margin-top:10px;
margin-bottom:10px;
padding:0px;
overflow:hidden;
}
.mypage_p {
margin:0 auto;
padding:0 0 0 100px;
list-style:none;
width:670px;
height:85px;
border:2px solid #767676;
overflow:hidden;
}
.mypage_p li {
height:85px;
float:left;
overflow:hidden;
}
.mypage_p_01 {
width:85px;
margin:10px 0 0 25px;
padding:0px;
}
.mypage_p_02 {
background:url(./images/mypage_t_06.jpg) no-repeat left top;
width:14px;
height:85px;
margin:0 0 0 25px;
padding:0px;
}
.mypage_p_01 div {
width:100%;
height:30px;
margin:10px 0 0 0;
padding:0px;
overflow:hidden;
}
.mypage_p_01 div p {
width:50%;
height:30px;
line-height:30px;
font-size:30px;
font-family:'Arial';
font-weight:bold;
color:#f23a3a;
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
.mypage_p_01 div img {
float:right;
}











.basket_table {
width:100%;
border-collapse:collapse;
border:1px solid #cccccc;
font-size:12px;
color:#4d4d4d;
}
.basket_table th {
background:#ebebeb;
border:1px solid #cccccc;
}
.basket_table td {
text-align:center;
background:#ffffff;
border:1px solid #cccccc;
}
.basket_table td a {
color:#4d4d4d;
text-decoration:none;
}
.basket_table td a:hover {
color:#000000;
}
.basket_input {
border:1px solid #bdbdbd;
width:35px;
height:18px;
line-height:18px;
margin:0 0 2px 0;
padding:0px;
overflow:hidden;
}
.basket_button {
background:#ffffff;
border-top:1px solid #bdbdbd;
border-right:1px solid #bdbdbd;
border-bottom:1px solid #828282;
border-left:1px solid #bdbdbd;
color:#757575;
width:37px;
height:20px;
line-height:18px;
font-size:11px;
margin:0px;
padding:0px;
overflow:hidden;
}
.basket_order{
background:#e11616;
border-top:1px solid #d81818;
border-right:1px solid #d81818;
border-bottom:1px solid #9e1212;
border-left:1px solid #d81818;
color:#ffffff;
width:70px;
height:20px;
line-height:18px;
font-size:11px;
margin:0 0 2px 0;
padding:0px;
overflow:hidden;
}
.basket_delete {
background:#ffffff;
border-top:1px solid #bdbdbd;
border-right:1px solid #bdbdbd;
border-bottom:1px solid #828282;
border-left:1px solid #bdbdbd;
color:#757575;
width:70px;
height:20px;
line-height:18px;
font-size:11px;
margin:0px;
padding:0px;
overflow:hidden;
}










.mypage_bg {
width:800px;
list-style:none;
margin:0 auto;
padding:0px;
overflow:hidden;
}
.mypage_bg li {
float:left;
font-family:'Arial';
background:#4c71d0;
color:#ffffff;
width:200px;
height:273px;
margin:0px;
padding:0px;
overflow:hidden;
}
.mypage_bg li div {
background:#ffffff;
margin:28px 0 0 28px;
padding:0px;
width:24px;
height:1px;
overflow:hidden;
}
.mypage_bg li p {
margin:20px 0 0 28px;
font-size:25px;
}
.mypage_bg li a {
border:1px solid #6081df;
background:#ffffff;
text-decoration:none;
display:block;
color:#4d6bcc;
font-size:11px;
width:58px;
height:22px;
text-align:center;
line-height:22px;
margin:60px 0 0 28px;
padding:0px;
}













.qna_board {
border-collapse:collapse;
width:750px;
margin:0 auto;
margin-top:10px;
}
.qna_board tr th {
border-top:1px solid #b2ddfc;
border-bottom:1px solid #ededed;
background:#f6f6f6;
font-size:12px;
}
.qna_board tr td {
border-bottom:1px solid #ededed;
font-size:12px;
text-align:center;
overflow:hidden;
}
.qna_board tr td a {
text-decoration:none;
color:#000000;
}
.qna_board tr td a:hover {
color:#666666;
}
.boards_bsearch {
margin:0 auto;
margin-top:20px;
margin-bottom:20px;
width:300px;
overflow:hidden;
}
.boards_bsearch_l {
width:80px;
float:left;
overflow:hidden;
}
.boards_bsearch_l select {
border:1px solid #cccccc;
width:80px;
height:26px;
}
.boards_bsearch_c {
width:140px;
float:left;
}
.boards_bsearch_c input {
border:1px solid #cccccc;
border-left:0px;
border-right:0px;
width:140px;
padding:0px;
line-height:24px;
height:24px;
}
.boards_bsearch_r {
width:80px;
float:right;
}
.boards_bsearch_r input {
background:#b2ddfc;
color:#000000;
border:1px solid #cccccc;
width:80px;
height:26px;
line-height:24px;
font-size:12px;
}
.view_qna_table_label1 {
border:1px solid #e1e6f8;
background:#ffffff;
font-size:11px;
color:#536dfe;
margin:0 auto;
padding:0px;
width:50px;
height:20px;
line-height:20px;
text-align:center;
overflow:hidden;
}
.view_qna_table_label2 {
border:1px solid #536dfe;
background:#e1e6f8;
font-size:11px;
color:#536dfe;
margin:0 auto;
padding:0px;
width:50px;
height:20px;
line-height:20px;
text-align:center;
overflow:hidden;
}
.customer_center_h {
border-bottom:2px solid #83b9e0;
margin:0 auto;
margin-top:30px;
padding:0 0 10px 0;
width:750px;
overflow:hidden;
}
.customer_center_btn {
width:750px;
margin:0 auto;
margin-top:20px;
text-align:center;
}
.customer_center_btn1 {
display:inline-block;
border:1px solid #2c6bbc;
background:#397fd9;
width:138px;
height:38px;
line-height:38px;
font-size:14px;
color:#ffffff;
font-weight:bold;
font-family:'Arial';
text-decoration:none;
text-align:center;
}
.customer_center_btn2 {
display:inline-block;
border:1px solid #cbcbcb;
background:#ffffff;
width:138px;
height:38px;
line-height:38px;
font-size:14px;
color:#444444;
font-weight:bold;
font-family:'Arial';
text-decoration:none;
text-align:center;
}









.customer_menu {
border-bottom:1px solid #dadada;
border-left:1px solid #dadada;
width:749px;
list-style:none;
margin:0 auto;
margin-top:30px;
padding:0px;
overflow:hidden;
}
.customer_menu li {
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
.customer_menu li a {
text-align:center;
width:373px;
float:left;
display:block;
margin:0px;
text-decoration:none;
border-right:1px solid #dadada;
font-size:14px;
font-weight:bold;
}
.customer_menu_li_a {
background:#f5f5f5;
border-top:1px solid #dadada;
border-bottom:1px solid #dadada;
padding:15px 0 15px 0;
color:#666666;
}
.customer_menu_li_a_hover {
background:#ffffff;
border-top:2px solid #575757;
border-bottom:0px;
padding:14px 0 16px 0;
color:#111111;
}











.qna_write_board {
border-collapse:collapse;
width:750px;
margin:0 auto;
margin-top:10px;
}
.qna_write_board tr th {
border:1px solid #d9dfe1;
background:#f7f7f7;
font-size:12px;
text-align:left;
color:#474646;
}
.qna_write_board tr td {
border:1px solid #d9dfe1;
font-size:12px;
color:#474646;
text-align:left;
}
.qna_write_board tr td a {
text-decoration:none;
color:#000000;
}
.qna_write_board tr td a:hover {
color:#666666;
}

.qna_write_board tr th a {
text-decoration:none;
color:#000000;
}
.qna_write_board tr th a:hover {
color:#666666;
}
.qna_write_board tr td input {
border:1px solid #aaabab;
background:#f7f7f7;
font-size:12px;
color:#474646;
text-align:left;
margin:0px;
padding:0 0 0 5px;
height:25px;
line-height:25px;
width:98%;
}
.qna_write_board tr td select {
border:1px solid #aaabab;
background:#f7f7f7;
font-size:12px;
color:#474646;
text-align:left;
margin:0px;
padding:0 0 0 5px;
height:25px;
line-height:25px;
width:150px;
}
.qna_write_board tr td textarea {
border:1px solid #aaabab;
background:#f7f7f7;
font-size:12px;
color:#474646;
text-align:left;
margin:0px;
padding:5px;
height:300px;
width:98%;
}


















.view_tab {
background:#ffffff;
border-left:1px solid #bebebe;
border-right:1px solid #bebebe;
width:1098px;
height:65px;
list-style:none;
margin:10px 0 0 0;
padding:0px;
overflow:hidden;
}
.view_tab li {
width:25%;
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
.view_tab li a {
border-top:1px solid #bebebe;
display:block;
float:left;
width:100%;
line-height:63px;
font-size:22px;
text-align:center;
text-decoration:none;
font-family:'Arial';
font-weight:bold;
margin:0px;
padding:0px;
overflow:hidden;
}
.view_tab_li_a {
border-bottom:1px solid #bebebe;
height:63px;
color:#333333;
}
.view_tab_li_a_hover {
border-bottom:4px solid #f80727;
height:60px;
color:#f80727;
}
.view_tab_li_a:hover {
border-bottom:4px solid #f80727;
height:60px;
color:#f80727;
}








#tour_review_h {
border-top:2px solid #8186ae;
background:url(./images/review_h2.jpg) no-repeat left top;
background-position:10px 13px;
background-color:#f3f6fd;
width:1003px;
height:47px;
line-height:47px;
margin:0px;
padding:0 0 0 35px;
font-size:15px;
font-family:'Arial';
color:#2a2927;
overflow:hidden;
}
.tour_review_table {
border-collapse:collapse;
width:1038px;
}
.tour_review_table tr th {
border-top:2px solid #e1e2e4;
border-bottom:1px solid #e1e1e1;
background:#f8f8f8;
font-size:12px;
padding:13px;
}
.tour_review_table tr td {
border-bottom:1px solid #e1e1e1;
font-size:12px;
padding:13px;
text-align:center;
}



















.list_page_rv {
margin:0 auto;
margin-top:30px;
margin-bottom:20px;
padding:0px;
width:965px;
text-align:center;
overflow:hidden;
}
.list_page_rv a {
text-decoration:none;
display:inline-block;
padding:4px 7px 4px 7px;
margin:0 3px 0 0;
font-size:11px;
}
.list_page_rv a:hover {
color:#435f87;
border:1px solid #435f87;
}
.list_page_a_hover_rv {
color:#435f87;
border:1px solid #435f87;
}
.list_page_a_rv {
color:#666666;
border:1px solid #d7d7d7;
}




















#floating_bg {
top:170px;
margin:0 0 0 1158px;
position:absolute;
width:80px;
overflow:hidden;
}
#floating {
background:#ffffff;
width:72px;
padding:10px 3px 3px 3px;
border:1px solid #cccccc;
border-radius:15px;
overflow:hidden;
}
#floating h1 {
font-size:11px;
font-weight:normal;
font-family:'Arial';
margin:5px 0 0 0;
padding:0px;
color:#666666;
width:72px;
text-align:center;
overflow:hidden;
}
#floating ul {
width:72px;
list-style:none;
margin:10px 0 0 0;
padding:0px;
overflow:hidden;
}
#floating ul li {
border:1px solid #cccccc;
width:70px;
height:70px;
margin:0 0 5px 0;
padding:0px;
overflow:hidden;
}
#floating ul li a {
width:70px;
height:70px;
margin:0px;
padding:0px;
overflow:hidden;
}
#floating_top {
background:#ffffff;
width:78px;
height:27px;
color:#666666;
border:1px solid #cccccc;
border-radius:15px;
margin:5px 0 0 0;
padding:0px;
overflow:hidden;
}
#floating_top a {
display:block;
width:78px;
height:27px;
line-height:27px;
text-align:center;
font-size:12px;
font-weight:bold;
font-family:'Arial';
text-decoration:none;
color:#666666;
margin:0px;
padding:0px;
overflow:hidden;
}
#floating_more {
border:1px solid #cccccc;
border-radius:15px;
display:block;
width:70px;
height:27px;
line-height:27px;
text-align:center;
font-size:12px;
font-weight:bold;
font-family:'Arial';
text-decoration:none;
color:#666666;
margin:0px;
padding:0px;
overflow:hidden;
}
#floating_body_bg {
top:170px;
margin:0 0 0 823px;
position:absolute;
width:327px;
overflow:hidden;
}
#floating_body {
background:#ffffff;
border:1px solid #cccccc;
border-radius:15px;
width:285px;
padding:20px;
overflow:hidden;
}
#floating_body ul {
width:285px;
height:400px;
list-style:none;
margin:0px;
padding:0px;
overflow-y:scroll;
}
#floating_body ul li {
margin:0px;
padding:0px;
overflow:hidden;
}
#floating_body ul li a {
border-bottom:1px solid #cccccc;
text-decoration:none;
font-size:12px;
color:#666666;
display:block;
width:270px;
height:72px;
padding:10px 0 10px 0;
overflow:hidden;
}
#floating_body ul li a img {
border:1px solid #cccccc;
float:left;
width:70px;
height:70px;
}
#floating_body ul li a div {
float:right;
width:178px;
height:52px;
margin:0px;
padding:10px;
overflow:hidden;
}
#floating_body_x {
margin:0px;
padding:0 5px 10px 0;
text-align:right;
overflow:hidden;
}
#floating_body_x a {
font-size:25px;
font-weight:bold;
text-decoration:none;
color:#666666;
font-family:'Arial';
margin:0px;
padding:0px;
overflow:hidden;
}
</style>

<script type="text/javascript">
function con_tab_hover(tabs, datas) {
	var i;
	for(i=1;i<=8;i++) {
		document.getElementById("con_tab_a"+i).setAttribute("class","con_tab_a");
		document.getElementById("con_tab_data_0"+i).style.display = "none";
	}
	tabs.setAttribute("class","con_tab_a_hover");
	document.getElementById("con_tab_data_0"+datas).style.display = "";
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





//회원가입 약관동의 버튼
function join_agree_next() {
	var inputs = document.getElementById("agrees");
	
	if(inputs.checked == false) {
		alert("약관에 동의해주세요.");
		return ;
	}
	
	location.href="join_write.o";
}

//다음우편번호
function btn_find_daum() {
	new daum.Postcode({
	    oncomplete: function(data) {
	        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	        // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	    	document.getElementById("addr_code").value = data.postcode;
	    	document.getElementById("addr").value = data.address+" "+data.buildingName;
	    }
	}).open();
}


var id_check = 0;	//아이디 검사 여부

//아이디 중복확인 버튼 눌렀을때
function btn_check(){
	//input의 아이디값을 찾아서 GET방식으로 팝업창 오픈
	var user_id = document.getElementById("user_ids").value;
	var url = "./join_id_check.o?user_id="+user_id;
	
	if(user_id != "")
	window.open(url, 'form', 'width=520, height=210, '
			+'toolbar=no, scrollbars=yes, resizable=no');
	else alert("아이디를 입력해 주세요.");
}
//아이디 중복확인 팝업창 결과
function btn_check_return(result) {
	id_check = result;	//아이디가 비정상이면 0, 정상이면 1
	if(result == 1)
		document.getElementById("id_ch_value").innerHTML="사용 가능한 아이디입니다.";
	else 
		document.getElementById("id_ch_value").innerHTML="중복 확인 절차를 거쳐야 합니다.";
}
//아이디 중복확인 여부
function join_submit() {
	if(id_check == 0) alert("아이디 중복확인을 해주세요.");
	else document.getElementById("join").submit();
}
//리뷰작성
function view_review(url){
	window.open(url, 'form', 'width=650, height=550, '
			+'toolbar=no, scrollbars=yes, resizable=no');
}
function view_review_result(result) {
	if(result == '0')
		alert("리뷰작성을 취소하였습니다.");
	else
		location.href="mypage.o?pages="+result;
}


//셀렉트 컨트롤
function ctrl_select(var1, var2) {
	location.href=var1+var2.value;
}


//무조건 보이기
function tour_show(var1, var2) {
	document.getElementById(var1).style.display = "";
	document.getElementById(var2).style.display = "";
}
//무조건 숨기기
function tour_hide(var1, var2) {
	document.getElementById(var1).style.display = "none";
	document.getElementById(var2).style.display = "none";
}




//리뷰 탭
function tour_tab(var1, var2) {
	document.getElementById("v_t_m1").setAttribute("class","view_tab_li_a");
	document.getElementById("v_t_m2").setAttribute("class","view_tab_li_a");
	document.getElementById("tour_view_tab1").style.display = "none";
	document.getElementById("tour_view_tab2").style.display = "none";
	
	var1.setAttribute("class","view_tab_li_a_hover");
	document.getElementById(var2).style.display = "";
}










//떠있는 메뉴
function floatingMenu() {
	var tmp = document.documentElement.scrollTop;
	var menu1 = document.getElementById("floating_bg");
	var menu2 = document.getElementById("floating_body_bg");
	
	if(tmp < 180) {
		menu1.style.top = 170+"px";
		menu2.style.top = 170+"px";
	}else{
		menu1.style.top = tmp+20+"px";
		menu2.style.top = tmp+20+"px";
	}
	
	setTimeout ("floatingMenu();", 10); 
}
//떠있는 메뉴 TOP
function floatingTop() {
	document.documentElement.scrollTop = 0;
}
//생겼다가 사라졌다가 하기
function showhide(var1) {
	var tmp = document.getElementById(var1);
	if(tmp.style.display == "none")
		tmp.style.display = "";
	else
		tmp.style.display = "none";
}
</script>
</head>
<body onload="floatingMenu();">

<tiles:insertAttribute name="header" />

<div id="contents">
	<div id="floating_body_bg" style="display:none;">
		<div id="floating_body">
			<div id="floating_body_x"><a href="#10" onclick="showhide('floating_body_bg');">X</a></div>
			<ul>
				<c:forEach var="ldata" items="${viewed_list_all}">
					<li>
						<a href="view.o?no=${ldata.no}">
							<img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="70px" height="70px" />
							<div style="float:right;">
								${ldata.subject}<br />
								<span style="color:red;font-weight:bold;">${ldata.moneys}원~</span>
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
				<span style="color:red;font-weight:bold;">(${viewed_list_cnt})</span>
			</h1>
			<ul>
				<c:forEach var="ldata" items="${viewed_list}">
					<li><a href="view.o?no=${ldata.no}"><img src="./upload/${ldata.file1}" alt="${ldata.subject}" width="70px" height="70px" /></a></li>
				</c:forEach>
			</ul>
			<a href="#10" id="floating_more" onclick="showhide('floating_body_bg');">더보기</a>
		</div>
		<div id="floating_top"><a href="#10" onclick="floatingTop();">↑ TOP</a></div>
	</div>








<tiles:insertAttribute name="body" />
</div>

<tiles:insertAttribute name="footer" />

</body>
</html>