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

	email_check(var1.email);
	password_check(var1.password);
	password2_check(var1.password2);
	name_check(var1.name);
	phone1_check(var1.phone1);
	phone2_check(var1.phone2);
	phone3_check(var1.phone3);
	quest_check(var1.quest);
	answer_check(var1.answer);
	company_check(var1.company);
	company_cate_check(var1.company_cate);
	company_num_check(var1.company_num);
	
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
		
		result = false;
	}
	if(var1.orders.value == 2) {
		if(!join_company
				|| !join_company_cate
				|| !join_company_num){
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
/////////////////////////





//기업관리
var name_edit = false;
var founding_edit = false;
var count_edit = false;
var money_edit = false;
var url_edit = false;
var addr_edit = false;
var company_type_edit = false;

function name_edit_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "대표를 입력해주세요.";
		htmls += '</span>';
		document.getElementById("name_edit_msg").innerHTML = htmls;
		name_edit = false;
	}else{
		document.getElementById("name_edit_msg").innerHTML = "";
		name_edit = true;
	}
}
function founding_edit_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "설립일을 입력해주세요.";
		htmls += '</span>';
		document.getElementById("founding_edit_msg").innerHTML = htmls;
		founding_edit = false;
	}else{
		document.getElementById("founding_edit_msg").innerHTML = "";
		founding_edit = true;
	}
}
function count_edit_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "사원수를 입력해주세요.";
		htmls += '</span>';
		document.getElementById("count_edit_msg").innerHTML = htmls;
		count_edit = false;
	}else{
		document.getElementById("count_edit_msg").innerHTML = "";
		count_edit = true;
	}
}
function money_edit_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "매출액을 입력해주세요.";
		htmls += '</span>';
		document.getElementById("money_edit_msg").innerHTML = htmls;
		money_edit = false;
	}else{
		document.getElementById("money_edit_msg").innerHTML = "";
		money_edit = true;
	}
}
function url_edit_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "웹사이트를 입력해주세요.";
		htmls += '</span>';
		document.getElementById("url_edit_msg").innerHTML = htmls;
		url_edit = false;
	}else{
		document.getElementById("url_edit_msg").innerHTML = "";
		url_edit = true;
	}
}
function addr_edit_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "본사를 입력해주세요.";
		htmls += '</span>';
		document.getElementById("addr_edit_msg").innerHTML = htmls;
		addr_edit = false;
	}else{
		document.getElementById("addr_edit_msg").innerHTML = "";
		addr_edit = true;
	}
}
function company_type_edit_check(var1) {
	if(var1.value == -1) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "기업형태를 선택해주세요.";
		htmls += '</span>';
		document.getElementById("company_type_edit_msg").innerHTML = htmls;
		company_type_edit = false;
	}else{
		document.getElementById("company_type_edit_msg").innerHTML = "";
		company_type_edit = true;
	}
}
function edit_submit(var1) {
	name_edit_check(var1.name);
	founding_edit_check(var1.founding);
	count_edit_check(var1.count);
	money_edit_check(var1.money);
	url_edit_check(var1.url);
	addr_edit_check(var1.addr);
	company_type_edit_check(var1.company_type);
	
	if(!name_edit ||
		!founding_edit ||
		!count_edit ||
		!money_edit ||
		!url_edit ||
		!addr_edit ||
		!company_type_edit) {
		return false;
	}
	return true;
}
///////////////////////////////////




////////////////////////////////////
function show(var1) {
	document.getElementById(var1).style.display="";
}
function hide(var1) {
	document.getElementById(var1).style.display="none";
}
////////////////////////////////////




//리뷰작성 별컨트롤
function rw_stars_btn(stars_num, stars_id, stars_input, stars_msg) {
	var i=0;
	
	for(i=1;i<=5;i++) document.getElementById(stars_id+""+i).setAttribute("src","./images/rw_star1.jpg");			//전부 흑백으로
	for(i=1;i<=stars_num;i++) document.getElementById(stars_id+""+i).setAttribute("src","./images/rw_star0.jpg");	//선택한 번호까지 컬러로
	
	document.getElementById(stars_input).value = stars_num;		//input에 값넣기
	
	var msg = "";
	switch(stars_num) {
	case 1:
		msg = "매우 불만족";
		break;
	case 2:
		msg = "불만족";
		break;
	case 3:
		msg = "보통";
		break;
	case 4:
		msg = "만족";
		break;
	case 5:
		msg = "매우 만족";
		break;
		default:
			break;
	}
	document.getElementById(stars_msg).innerHTML = msg;
}
///////////////////////////////////






//리뷰작성 유효성체크
var rw_stars = false;
var rw_types = false;
var rw_memo1 = false;
var rw_memo2 = false;
var rw_memo3 = false;
var rw_stars1 = false;
var rw_stars2 = false;
var rw_stars3 = false;
var rw_stars4 = false;
var rw_stars5 = false;

function rw_stars_check(var1) {
	if(var1.value == -1) {
		document.getElementById("stars_msg").innerHTML = "<span style='color:red;'>평가해주세요.</span>";
		rw_stars = false;
	}else{
		rw_stars = true;
	}	
}

function rw_types_check(var1) {
	if(var1.value == -1) {
		document.getElementById("types_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		rw_types = false;
	}else{
		document.getElementById("types_msg").innerHTML = "";
		rw_types = true;
	}	
}
function rw_memo1_check(var1) {
	if(var1.value == "") {
		document.getElementById("memo1_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rw_memo1 = false;
	}else if(var1.value.length < 20){
		document.getElementById("memo1_msg").innerHTML = "<span style='color:red;'>20자 이상 작성해주세요.</span>";
		rw_memo1 = false;
	}else{
		document.getElementById("memo1_msg").innerHTML = "";
		rw_memo1 = true;
	}	
}
function rw_memo2_check(var1) {
	if(var1.value == "") {
		document.getElementById("memo2_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rw_memo2 = false;
	}else if(var1.value.length < 30){
		document.getElementById("memo2_msg").innerHTML = "<span style='color:red;'>30자 이상 작성해주세요.</span>";
		rw_memo2 = false;
	}else{
		document.getElementById("memo2_msg").innerHTML = "";
		rw_memo2 = true;
	}	
}
function rw_memo3_check(var1) {
	if(var1.value == "") {
		document.getElementById("memo3_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rw_memo3 = false;
	}else if(var1.value.length < 30){
		document.getElementById("memo3_msg").innerHTML = "<span style='color:red;'>30자 이상 작성해주세요.</span>";
		rw_memo3 = false;
	}else{
		document.getElementById("memo3_msg").innerHTML = "";
		rw_memo3 = true;
	}	
}
function rw_stars1_check(var1) {
	if(var1.value == -1) {
		document.getElementById("stars_msg1").innerHTML = "<span style='color:red;'>평가해주세요.</span>";
		rw_stars1 = false;
	}else{
		rw_stars1 = true;
	}	
}
function rw_stars2_check(var1) {
	if(var1.value == -1) {
		document.getElementById("stars_msg2").innerHTML = "<span style='color:red;'>평가해주세요.</span>";
		rw_stars2 = false;
	}else{
		rw_stars2 = true;
	}	
}
function rw_stars3_check(var1) {
	if(var1.value == -1) {
		document.getElementById("stars_msg3").innerHTML = "<span style='color:red;'>평가해주세요.</span>";
		rw_stars3 = false;
	}else{
		rw_stars3 = true;
	}	
}
function rw_stars4_check(var1) {
	if(var1.value == -1) {
		document.getElementById("stars_msg4").innerHTML = "<span style='color:red;'>평가해주세요.</span>";
		rw_stars4 = false;
	}else{
		rw_stars4 = true;
	}	
}
function rw_stars5_check(var1) {
	if(var1.value == -1) {
		document.getElementById("stars_msg5").innerHTML = "<span style='color:red;'>평가해주세요.</span>";
		rw_stars5 = false;
	}else{
		rw_stars5 = true;
	}	
}
function review_write_submit(var1) {
	rw_stars_check(var1.stars);
	rw_types_check(var1.types);
	rw_memo1_check(var1.memo1);
	rw_memo2_check(var1.memo2);
	rw_memo3_check(var1.memo3);
	rw_stars1_check(var1.stars1);
	rw_stars2_check(var1.stars2);
	rw_stars3_check(var1.stars3);
	rw_stars4_check(var1.stars4);
	rw_stars5_check(var1.stars5);
	
	if(!rw_stars || 
		!rw_types || 
		!rw_memo1 || 
		!rw_memo2 || 
		!rw_memo3 || 
		!rw_stars1 || 
		!rw_stars2 || 
		!rw_stars3 || 
		!rw_stars4 || 
		!rw_stars5) {
		return false;
	}else return true;
}




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