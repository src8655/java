<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
font-family:'돋움';
margin:0px;
padding:0px;
font-size:12px;
}
.boards {
font-size:12px;
width:100%;
margin:0px;
border-collapse:collapse;
}
.boards th {
border-top:2px solid #122942;
border-bottom:1px solid #A0A0A0;
height:35px;
line-height:35px;
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
height:26px;
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
height:25px;
line-height:25px;
font-size:15px;
margin:0px;
padding:0px;
overflow:hidden;
}
.btn_st {
border:1px solid #cccccc;
background:#eeeeee;
color:#000000;
padding:0px;
width:78px;
height:24px;
line-height:24px;
text-decoration:none;
display:block;
font-size:12px;
text-align:center;
overflow:hidden;
}
.b_memo {
border:1px solid #cccccc;
width:99%;
height:200px;
font-size:15px;
margin:0px;
padding:0px;
}
</style>
</head>
<body>