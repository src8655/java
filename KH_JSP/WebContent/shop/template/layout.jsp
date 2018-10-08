<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<script src="./ckeditor/ckeditor.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
width:100px;
height:39px;
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
margin:0 10px 0 10px;
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
padding:20px 0px 0px 0px;
width:192px;
height:230px;
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
.basket_top {
width:965px;
border-bottom:5px solid #444444;
margin:20px 0 20px 0;
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
width:600px;
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
.basket_b_table {
width:100%;
margin:20px 0 0 0;
border-collapse:collapse;
border-top:3px solid #333333;
border-right:1px solid #8d8d8d;
border-bottom:1px solid #8d8d8d;
border-left:1px solid #8d8d8d;
font-size:12px;
color:#333333;
}
.basket_b_table td {
background:#f7f8fc;
text-align:left;
font-weight:bold;
padding:30px 10px 30px 10px;
text-align:center;
}
.basket_b {
width:965px;
overflow:hidden;
}
.basket_b a {
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
margin:20px 0 0 0;
float:right;
border-top:1px solid #d81818;
border-right:1px solid #d81818;
border-bottom:1px solid #9e1212;
border-left:1px solid #d81818;
}
.join_first {
width:965px;
margin:40px 0 0 0;
padding:0px;
overflow:hidden;
}
.join_box1 {
float:left;;
font-family:'Arial';
background:#4c71d0;
color:#ffffff;
width:477px;
height:273px;
overflow:hidden;
}
.join_box1 div {
background:#ffffff;
margin:28px 0 0 28px;
padding:0px;
width:24px;
height:1px;
overflow:hidden;
}
.join_box1 p {
margin:20px 0 0 28px;
font-size:25px;
}
.join_box1 a {
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
.join_box2 {
float:right;;
font-family:'Arial';
background:#4a5d9d;
color:#ffffff;
width:477px;
height:273px;
overflow:hidden;
}
.join_box2 div {
background:#ffffff;
margin:28px 0 0 28px;
padding:0px;
width:24px;
height:1px;
overflow:hidden;
}
.join_box2 p {
margin:20px 0 0 28px;
font-size:25px;
}
.join_box2 a {
border:1px solid #344066;
background:#ffffff;
text-decoration:none;
display:block;
color:#354168;
font-size:11px;
width:58px;
height:22px;
text-align:center;
line-height:22px;
margin:60px 0 0 28px;
padding:0px;
}
.join_agree_bg {
background:#f5f6f8;
width:100%;
margin:3px 0 0 0;
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
.login_bg {
width:694px;
margin:0 auto;
margin-top:40px;
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


.edit_del_checkbox {
width:100%;
background:#555555;
margin:0 auto;
padding:7px 0 7px 0px;
overflow:hidden;
}

.edit_del_checkbox input {
display:none;
}
.edit_del_checkbox label {
float:right;
margin:0 30px 0 0;
background:url(./images/check1.jpg) no-repeat left top;
display:block;
border:0px;
width:25px;
height:25px;
overflow:hidden;
}
.edit_del_checkbox label:hover {
background:url(./images/check1.jpg) no-repeat left top;
}
.edit_del_checkbox input[type=checkbox]:checked + label {
background:url(./images/check2.jpg) no-repeat left top;
}
.edit_del_checkbox p {
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
.mypage_h {
width:800px;
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
padding:0 0 0 35px;
list-style:none;
width:761px;
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
.ship_num_input {
width:130px;
padding:2px 0 2px 0;
margin:3px 0 3px 0;
font-size:12px;
}
.view_tab {
width:100%;
height:65px;
list-style:none;
margin:0 0 10px 0;
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
border-top:1px solid #dadada;
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
border-bottom:1px solid #dadada;
height:63px;
color:#333333;
}
.view_tab_li_a_hover {
border-bottom:4px solid #f80727;
height:60px;
color:#f80727;
}
.view_tab li a:hover {
border-bottom:4px solid #f80727;
height:60px;
color:#f80727;
}
.view_qna_table {
border-collapse:collapse;
width:100%;
}
.view_qna_table tr th {
border-top:1px solid #cccccc;
border-bottom:1px solid #e5e5e5;
background:#f5f5f5;
color:#333333;
font-size:12px;
font-family:'Arial';
}
.view_qna_table tr td {
border-bottom:1px solid #e5e5e5;
font-size:12px;
color:#666666;
font-family:'Arial';
text-align:center;
}
.view_qna_table tr td a {
color:#666666;
text-decoration:none;
}
.view_qna_table tr td a:hover {
color:#555555;
text-decoration:none;
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
.view_qna_b {
width:100%;
margin:10px 0 10px 0;
padding:0px;
overflow:hidden;
}
.view_qna_b a {
float:right;
background:#666666;
display:block;
width:120px;
height:40px;
line-height:40px;
font-size:13px;
font-family:'Arial';
text-decoration:none;
color:#ffffff;
margin:0px;
padding:0px;
overflow:hidden;
}
.review_box_l {
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
.review_box {
float:left;
border-radius: 25px;
background:#f5f5f5;
padding:0 15px 0 15px;
margin:0 0 0 10px;
height:23px;
line-height:23px;
color:#666666;
overflow:hidden;
}
.view_info_table {
border-collapse:collapse;
width:100%;
}
.view_info_table tr th {
background:#f5f5f5;
border-bottom:1px solid #e5e5e5;
color:#333333;
font-weight:normal;
text-align:left;
font-size:12px;
font-family:'Arial';
}
.view_info_table tr td {
border-bottom:1px solid #e5e5e5;
color:#666666;
text-align:left;
font-size:12px;
font-family:'Arial';
}

.customer_center_bg {
width:600px;
list-style:none;
margin:0 auto;
padding:0px;
overflow:hidden;
}
.customer_center_bg li {
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
.customer_center_bg li div {
background:#ffffff;
margin:28px 0 0 28px;
padding:0px;
width:24px;
height:1px;
overflow:hidden;
}
.customer_center_bg li p {
margin:20px 0 0 28px;
font-size:25px;
}
.customer_center_bg li a {
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
.customer_center_h {
border-bottom:2px solid #83b9e0;
margin:0 auto;
margin-top:30px;
padding:0 0 10px 0;
width:750px;
overflow:hidden;
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
.qna_board {
border-collapse:collapse;
width:750px;
margin:0 auto;
margin-top:10px;
overflow:hidden;
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
.sitemap_ul {
width:808px;
list-style:none;
margin:0 auto;
margin-top:30px;
padding:0px;
overflow:hidden;
}
.sitemap_ul li {
float:left;
width:202px;
height:223px;
margin:0px;
padding:0px;
overflow:hidden;
}
.sitemap_ul li a {
float:left;
display:block;
width:202px;
height:223px;
margin:0px;
padding:0px;
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
</style>
<script type="text/javascript">
function tab(vars, vars_this, vars_right) {
  //모든 탭, 탭내용 초기화
  var i;
  for(i=0;i<=8;i++){
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
function quick_search(searchs_v, searchs) {
	var inp = document.getElementById("header_c_c_l_search");
	inp.searchs.value = searchs;
	inp.searchs_value.value = searchs_v;
	inp.submit();
	/////////////////////
	//
}

//장바구니 form
function baskets() {
	var forms = document.getElementById("view_form");
	if(!forms.counts.value) {
		alert("수량 입력하세요");
		return ;
	}
	if(forms.counts.value <= 0) {
		alert("올바른 수량을 입력하세요");
		return ;
	}
	forms.setAttribute("action","basket_add.o");
	forms.submit();
}


//장바구니 개수 수정
function basket_change(nos, inp) {
	var inputs = document.getElementById(inp);
	if(!inputs.value) {
		alert("수량 입력하세요");
		return ;
	}
	if(inputs.value <=0) {
		alert("올바른 수량을 입력하세요");
		return ;
	}
	
	location.href="basket_edit.o?no="+nos+"&counts="+inputs.value;
}


//장바구니 삭제
function basket_delete(nos) {
	location.href="basket_delete.o?no="+nos;
}


//회원가입 약관동의 버튼
function join_agree_next(order) {
	var inputs = document.getElementById("agrees");
	
	if(inputs.checked == false) {
		alert("약관에 동의해주세요.");
		return ;
	}
	
	location.href="join_write.o?order="+order;
}



var id_check = 0;	//아이디 검사 여부

//아이디 중복확인 버튼 눌렀을때sdf
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

//구매버튼 order 1이면 일반구매 2이면 장바구니구매
function buys() {
	var forms = document.getElementById("view_form");
	if(!forms.counts.value) {
		alert("수량 입력하세요");
		return ;
	}
	if(forms.counts.value <= 0) {
		alert("올바른 수량을 입력하세요");
		return ;
	}
	forms.setAttribute("action","buys.o");
	forms.submit();
}


//view의 탭제어
function view_tab(var1, var2) {
	//var1은 this var2는 tab
	//메뉴와 tab을 모두 클릭 전으로
	var i;
	for(i=1;i<=4;i++) {
		document.getElementById("v_t_m"+i).setAttribute("class","view_tab_li_a");
		document.getElementById("view_tab"+i).style.display = "none";
	}
	
	document.getElementById(var1).setAttribute("class","view_tab_li_a_hover");
	document.getElementById(var2).style.display = "";
}


//view의 qna의 작성하기 버튼 눌렀을때
function view_qna_write(no, sellers){
	//product_no를 전달
	var url = "./view_qna_write.o?no="+no+"&sellers_no="+sellers;
	
	window.open(url, 'form', 'width=650, height=450, '
			+'toolbar=no, scrollbars=yes, resizable=no');
}
function view_qna_write_result(result) {
	if(result == '0')
		alert("작성을 취소하였습니다.");
	else
		location.href="view.o?no="+result+"&tab=3";
}

//view의 qna 제목 눌렀을때
function view_qna_view(var1) {
	var tmp = document.getElementById(var1);
	if(tmp.style.display == "none")
		tmp.style.display = "";
	else
		tmp.style.display = "none";
}


//view의 qna의 답글 버튼 눌렀을때
function view_qna_answer(product_no, pages, no){
	//product_no를 전달
	var url = "./view_qna_answer.o?product_no="+product_no+"&pages="+pages+"&no="+no;
	
	window.open(url, 'form', 'width=650, height=450, '
			+'toolbar=no, scrollbars=yes, resizable=no');
}
function view_qna_answer_result(result) {
	if(result == '0')
		alert("답글작성을 취소하였습니다.");
	else
		location.href="view.o?no="+result+"&tab=3";
}

//리뷰작성하기
function view_review(url){
	window.open(url, 'form', 'width=650, height=550, '
			+'toolbar=no, scrollbars=yes, resizable=no');
}
function view_review_result(result) {
	if(result == '0')
		alert("리뷰작성을 취소하였습니다.");
	else
		location.href="mypage_guest.o?pages="+result;
}



//생겼다가 사라졌다가 하기
function showhide(var1) {
	var tmp = document.getElementById(var1);
	if(tmp.style.display == "none")
		tmp.style.display = "";
	else
		tmp.style.display = "none";
}




//포인트사용 체크박스 (체크박스, 내 포인트, 결제할금액, 버튼=1/체크박스=0)
function point_checkbox(var1, var2, var3, var4) {
	var money = 0;
	var use_point = 0;
	//적용버튼
	if(var4 == 0) {
		document.getElementById("point").checked = false;
		use_point = document.getElementById("point_num").value;
		if(use_point == "") use_point = 0;
		//0포인트시 숨기기
		if(use_point == 0 || use_point == '0') {
			document.getElementById("bstable1").style.display = "";
			document.getElementById("bstable2").style.display = "none";
		}
		
		//내 포인트보다 더 많은 금액 썼을때
		if(var2 <= use_point) {
			alert("포인트가 부족합니다.");
			return ;
		}
		
		//써놓은 포인트가 결제금액보다 더 많을때
		if(use_point > var3) {
			alert("포인트는 결제금액보다 더 많을 수 없습니다.");
			return ;
		}else{
			money = var3 - use_point;
			document.getElementById("bstable1").style.display = "none";
			document.getElementById("bstable2").style.display = "";
		}
	}else{
		//체크박스
		//체크시
		if(var1.checked == true) {
			document.getElementById("bstable1").style.display = "none";
			document.getElementById("bstable2").style.display = "";
			
			//결제할금액보다 내 포인트가 더 작거나 같을때
			if(var2 <= var3) {
				use_point = var2;
				money = var3 - var2;
			}else{
				use_point = var3;
				money = 0;
			}
		}
		//아닐시
		else{
			document.getElementById("bstable1").style.display = "";
			document.getElementById("bstable2").style.display = "none";
			use_point = 0;
			money = 0;
		}
		
		
	}

	//td 수정
	document.getElementById("point_num").value = use_point;
	document.getElementById("point_td1").innerHTML = "-"+number_format(use_point+"")+"원";
	document.getElementById("point_td2").innerHTML = number_format(money+"")+"원";
}


//통화형태
function number_format(str) {
	return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}


//셀렉트 컨트롤
function ctrl_select(var1, var2) {
	location.href=var1+var2.value;
}
</script>
</head>
<body>

<tiles:insertAttribute name="header" />

<div id="contents">
<tiles:insertAttribute name="body" />
</div>

<tiles:insertAttribute name="footer" />

</body>
</html>