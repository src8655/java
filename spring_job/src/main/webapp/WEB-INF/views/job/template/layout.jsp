<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:getAsString name="title" /></title>
    <!-- 부트스트랩 css -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,600" rel="stylesheet" type="text/css">
	  <link href="css/bootstrap.min.css" rel="stylesheet" />
	  <link href="css/style.css" rel="stylesheet" />
    <script type="text/javascript" src="js/loader.js"></script>
    <script src="js/jquery-2.1.3.min.js"></script>
    <script src="js/script.js"></script>
<script type="text/javascript">



//회원가입
var join_email = false;
var join_password = false;
var join_password2 = false;
var join_name = false;
var join_phone1 = false;
var join_phone2 = false;
var join_phone3 = false;
var join_quest = false;
var join_answer = false;
var join_company = false;
var join_company_cate = false;
var join_company_num = false;

//회원가입 탭
function join_tab(var1, var2) {
	document.getElementById("join_btn_01").setAttribute("class","join_t_li_a");
	document.getElementById("join_btn_02").setAttribute("class","join_t_li_a");
	
	var1.setAttribute("class","join_t_li_a_hover");

	if(!var2) {
		document.getElementById("join_02").style.display = "none";
		document.getElementById("join_orders").value = 1;
	}else {
		document.getElementById("join_02").style.display = "";
		document.getElementById("join_orders").value = 2;
	}
}

//이메일 유효성 검사
function email_check(var1) {
	var email = var1.value;
	$.ajax({
		url:'join_email_check_ajax.o',
		method:'GET',
		datatype : "json",
		contentType: "application/json; charset=utf-8",
		data:{
			email:email
		},
		success:function(result){
			join_email = result.result;
			var htmls = "";
			if(join_email == false) htmls = '<span style="color:red;">';
			else htmls = '<span style="color:blue;">';
			htmls += result.msg;
			htmls += '</span>';
			$("#email_msg").html(htmls);
		},
		error:function(r,s,e) {
			alert('error');
		}
	});
}
function password_check(var1) {
	join_password_v = var1.value;
	document.getElementById("password2_msg").innerHTML = "";
	join_password2 = false;
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "비밀번호를 입력해주세요.";
		htmls += '</span>';
		document.getElementById("password_msg").innerHTML = htmls;
		join_password = false;
		join_password2 = false;
	}else
	if(join_password_v.length < 5) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "비밀번호가 짧습니다.";
		htmls += '</span>';
		document.getElementById("password_msg").innerHTML = htmls;
		join_password = false;
	}else{
		var htmls = "";
		htmls = '<span style="color:blue;">';
		htmls += "사용할 수 있는 비밀번호입니다.";
		htmls += '</span>';
		document.getElementById("password_msg").innerHTML = htmls;
		join_password = true;
	}
}
function password2_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "비밀번호를 입력해주세요.";
		htmls += '</span>';
		document.getElementById("password2_msg").innerHTML = htmls;
		join_password2 = false;
	}else
	if(var1.value != join_password_v) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "비밀번호가 다릅니다.";
		htmls += '</span>';
		document.getElementById("password2_msg").innerHTML = htmls;
		join_password2 = false;
	}else{
		var htmls = "";
		htmls = '<span style="color:blue;">';
		htmls += "비밀번호가 같습니다.";
		htmls += '</span>';
		document.getElementById("password2_msg").innerHTML = htmls;
		join_password2 = true;
	}
}
function name_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "이름을 입력해주세요.";
		htmls += '</span>';
		document.getElementById("name_msg").innerHTML = htmls;
		join_name = false;
	}else{
		document.getElementById("name_msg").innerHTML = "";
		join_name = true;
	}
}
function phone1_check(var1) {
	if(var1.value == "") join_phone1 = false;
	else join_phone1 = true;
	
	if(!join_phone1 || !join_phone2 || !join_phone3) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "전화번호가 올바르지 않습니다.";
		htmls += '</span>';
		document.getElementById("phone_msg").innerHTML = htmls;
	}else{
		document.getElementById("phone_msg").innerHTML = "";
	}
}
function phone2_check(var1) {
	if(var1.value == "") join_phone2 = false;
	else join_phone2 = true;
	
	if(!join_phone1 || !join_phone2 || !join_phone3) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "전화번호가 올바르지 않습니다.";
		htmls += '</span>';
		document.getElementById("phone_msg").innerHTML = htmls;
	}else{
		document.getElementById("phone_msg").innerHTML = "";
	}
}
function phone3_check(var1) {
	if(var1.value == "") join_phone3 = false;
	else join_phone3 = true;
	
	if(!join_phone1 || !join_phone2 || !join_phone3) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "전화번호가 올바르지 않습니다.";
		htmls += '</span>';
		document.getElementById("phone_msg").innerHTML = htmls;
	}else{
		document.getElementById("phone_msg").innerHTML = "";
	}
}
function quest_check(var1) {
	if(var1.value == -1) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "질문을 선택해주세요.";
		htmls += '</span>';
		document.getElementById("quest_msg").innerHTML = htmls;
		join_quest = false;
	}else{
		document.getElementById("quest_msg").innerHTML = "";
		join_quest = true;
	}
}
function answer_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "답변을 작성해주세요.";
		htmls += '</span>';
		document.getElementById("answer_msg").innerHTML = htmls;
		join_answer = false;
	}else{
		document.getElementById("answer_msg").innerHTML = "";
		join_answer = true;
	}
}
function company_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "기업명을 입력해주세요.";
		htmls += '</span>';
		document.getElementById("company_msg").innerHTML = htmls;
		join_company = false;
	}else{
		document.getElementById("company_msg").innerHTML = "";
		join_company = true;
	}
}
function company_cate_check(var1) {
	if(var1.value == -1) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "산업군을 선택해주세요.";
		htmls += '</span>';
		document.getElementById("company_cate_msg").innerHTML = htmls;
		join_company_cate = false;
	}else{
		document.getElementById("company_cate_msg").innerHTML = "";
		join_company_cate = true;
	}
}
function company_num_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "사업자번호를 입력해주세요.";
		htmls += '</span>';
		document.getElementById("company_num_msg").innerHTML = htmls;
		join_company_num = false;
	}else{
		document.getElementById("company_num_msg").innerHTML = "";
		join_company_num = true;
	}
}
function join_submit(var1) {
	var result = true;
	if(!join_email
			|| !join_password
			|| !join_password2
			|| !join_name
			|| !join_phone1
			|| !join_phone2
			|| !join_phone3
			|| !join_quest
			|| !join_answer) {
		email_check(var1.email);
		password_check(var1.password);
		password2_check(var1.password2);
		name_check(var1.name);
		phone1_check(var1.phone1);
		phone2_check(var1.phone2);
		phone3_check(var1.phone3);
		quest_check(var1.quest);
		answer_check(var1.answer);
		
		result = false;
	}
	if(var1.orders.value == 2) {
		if(!join_company
				|| !join_company_cate
				|| !join_company_num){
			company_check(var1.company);
			company_cate_check(var1.company_cate);
			company_num_check(var1.company_num);
			result = false;
		}
	}
	
	return result;
}
/////////////////////////








//로그인
var login_email = false;
var login_password = false;

function login_email_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "이메일을 입력해주세요.";
		htmls += '</span>';
		document.getElementById("login_email_msg").innerHTML = htmls;
		login_email = false;
	}else{
		document.getElementById("login_email_msg").innerHTML = "";
			login_email = true;
	}
}
function login_password_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "비밀번호를 입력해주세요.";
		htmls += '</span>';
		document.getElementById("login_password_msg").innerHTML = htmls;
		login_password = false;
	}else{
		document.getElementById("login_password_msg").innerHTML = "";
			login_password = true;
	}
}
function login_submit(var1) {
	login_email_check(var1.email);
	login_password_check(var1.password);
	
	if(!login_email || !login_password) {
		login_email_check(var1.email);
		login_password_check(var1.password);
		return false;
	}
	
	var email = var1.email.value;
	var password = var1.password.value;
	var res = false;
	var ress = false;
	$.ajax({
		url:'login_check_ajax.o',
		method:'GET',
		datatype : "json",
		contentType: "application/json; charset=utf-8",
		data:{
			email:email,
			password:password
		},
		success:function(result){
			ress = result.result;
			if(ress == false) {
				var htmls = "";
				htmls = '<span style="color:red;">';
				htmls += result.msg;
				htmls += '</span>';
				$("#login_msg").html(htmls);
				res = false;
			}else {
				var1.submit();
			}
		},
		error:function(r,s,e) {
			alert('error');
		}
	});
	return false;
}
/////////////////////////
</script>
</head>
<body>

<tiles:insertAttribute name="header" />

<tiles:insertAttribute name="body" />

<tiles:insertAttribute name="footer" />

	 <!-- jQuery 포함 -->
    <!-- 부트스트랩 플러그인 포함 -->
    <script src="js/bootstrap.min.js"></script> 
		
	<!-- HTML5와 미디어쿼리를 지원하지 않는 IE8 이하 버전을 위해 -->
	<!-- [if lt IE 9]>
		<script src="html5shiv/html5shiv.min.js">
		<script src="respond/respond.min.js">
	<![endif]-->
	
</body>
</html>