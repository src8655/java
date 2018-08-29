<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import = "board2.Member_Data_Bean" %>
<%@ page import = "board2.Member_DB_Bean" %>
<%
//로그인정보 불러오기
Member_Data_Bean member_info = null;
if(session.getAttribute("user_id") != null && session.getAttribute("user_pw") != null) {
	Member_DB_Bean mem_db = Member_DB_Bean.getInstance();
	member_info = mem_db.login_info((String)session.getAttribute("user_id"), (String)session.getAttribute("user_pw"));
}

%>
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
#join_b {
width:100%;
text-align:center;
margin:20px 0 20px 0;
overflow:hidden;
}
.joins {
width:100%;
margin:0px;
border:1px solid #BDBDBD;
border-collapse:collapse;
}
.joins td {
border:1px solid #BDBDBD;
}
.joins th {
background:url(./images/submenubg.gif) repeat-x left bottom;
border:1px solid #BDBDBD;
height:35px;
}
.jinput {
background:#ffffff;
border:1px solid #BDBDBD;
margin:0px;
padding:0px;
width:130px;
height:25px;
line-height:25px;
font-size:15px;
}
.join_header {
font-size:13px;
margin:20px 0 5px 0;
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
.comments {
width:100%;
padding:10px;
margin:10px 0 0 0;
border-collapse:collapse;
}
.comments tr th {
border-top:1px solid #122942;
}
.comments tr td {
border:1px solid #bbbbbb;
}
.comments input {
background:#ffffff;
width:98%;
height:20px;
line-height:20px;
border:1px solid #cccccc;
font-size:15px;
}
.comments textarea {
width:99%;
font-size:15px;
}
.comments a {
font-size:12px;
color:#676767;
text-decoration:none;
}
#login_oo {
border:2px solid #B4BFCC;
padding:20px 50px 50px 50px;
width:270px;
margin:0 auto;
margin-top:30px;
margin-bottom:30px;
overflow:hidden;
}
#login_oo h1 {
font-size:20px;
border-bottom:1px solid #B4BFCC;
margin:0 0 20px 0;
padding:0 0 10px 0;
font-family:'Arial';
overflow:hidden;
}
#login_oo fieldset {
border:0px;
margin:0px;
padding:0px;
overflow:hidden;
}
#login_oo legend {
font-size:0px;
margin:0px;
padding:0px;
overflow:hidden;
}
.login_oo_l {
width:195px;
text-align:right;
float:left;
margin:0px;
padding:0px;
overflow:hidden;
}
.login_oo_l label {
font-family:'Arial';
font-weight:bold;
font-size:13px;
line-height:31px;
}
.login_oo_l input {
border:1px solid #B4BFCC;
height:31px;
line-height:31px;
width:150px;
font-size:17px;
margin:0 0 3px 0;
padding:0px;
overflow:hidden;
}
.login_oo_r {
width:70px;
float:right;
margin:0px;
padding:0px;
overflow:hidden;
}
#login_bu_oo {
margin:0px;
padding:0px;
width:70px;
height:70px;
background:#ECECEC;
font-size:13px;
font-family:'Arial';
font-weight:bold;
border:2px solid #B4BFCC;
overflow:hidden;
}
#login_t_oo {
width:100%;
overflow:hidden;
}
#login_b_oo {
padding:15px 0 0 0;
text-align:center;
font-size:15px;
overflow:hidden;
}
#login_b_oo a {
text-decoration:none;
color:#000000;
}
</style>
<script type="text/javascript">
var id_check = 0;	//아이디 검사 여부

//아이디 중복확인 버튼 눌렀을때sdf
function btn_check(){
	//input의 아이디값을 찾아서 GET방식으로 팝업창 오픈
	var user_id = document.getElementById("user_ids").value;
	var url = "./join_check.jsp?user_id="+user_id;
	
	if(user_id != "")
  	window.open(url, 'form', 'width=520, height=110, '
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
//우편번호 검색 버튼 눌렀을때
function btn_find(){
	//팝업창 오픈
	var url = "./join_find.jsp"
	window.open(url, 'form', 'width=520, height=480, '
			+'toolbar=no, scrollbars=yes, resizable=no');
}
//우편번호 검색 팝업창 결과
function btn_find_return(num, addr) {
	//찾은 우편번호와 주소를 input에 입력
	document.getElementById("addr_code").value = num;
	document.getElementById("addr").value = addr;
}
</script>
</head>
<body>
