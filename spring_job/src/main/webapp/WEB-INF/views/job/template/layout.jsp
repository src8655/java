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
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
  <script src="https://apis.google.com/js/api:client.js"></script>
  
	
<script type="text/javascript">

var save_id_auths = '';
//변수 초기화
function setinitvar(var1) {
	save_id_auths = var1;
}


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
var join_password_v = "";

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






function password_checks(var1) {
	join_password_v = var1.value;
	document.getElementById("password2_msg").innerHTML = "";
	join_password2 = false;
	if(var1.value == "") {
		document.getElementById("password_msg").innerHTML = "";
		join_password = true;
		join_password2 = false;
	}else if(join_password_v.length < 5) {
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
function password2_checks(var1) {
	if(var1.value == "") {
		if(join_password_v != "") {
			var htmls = "";
			htmls = '<span style="color:red;">';
			htmls += "비밀번호를 입력해주세요.";
			htmls += '</span>';
			document.getElementById("password2_msg").innerHTML = htmls;
			join_password2 = false;
		}else{
			join_password2 = true;
			document.getElementById("password2_msg").innerHTML = "";
		}
	}else if(var1.value != join_password_v) {
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
function login_edit_submit(var1) {
	
	password_checks(var1.password);
	password2_checks(var1.password2);
	name_check(var1.name);
	phone1_check(var1.phone1);
	phone2_check(var1.phone2);
	phone3_check(var1.phone3);
	quest_check(var1.quest);
	answer_check(var1.answer);
	
	if(var1.orders.value == 2) {
	company_check(var1.company);
	company_cate_check(var1.company_cate);
	company_num_check(var1.company_num);
	}
	var result = true;
	if(!join_password
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
function login_submit(var1, member_no) {
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
				login_ajax(var1, member_no);
			}
		},
		error:function(r,s,e) {
			alert('error');
		}
	});
	return false;
}
/////////////////////////









//파일처리1 이미지
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
//파일처리2 기타파일
function open_file2(files) {
	document.getElementById(files).click();
}
function change_file2(var1, files) {
	document.getElementById(var1).value = files.value;
}



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
function show2(var1) {
	$("#"+var1).fadeIn(100);
	
}
function hide2(var1) {
	$("#"+var1).fadeOut(100);
}
function toggle2(var1) {
	$("#"+var1).slideToggle(100);
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
var rw_prof = false;
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
function rw_prof_check(var1) {
	if(var1.value == -1) {
		document.getElementById("prof_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		rw_prof = false;
	}else{
		document.getElementById("prof_msg").innerHTML = "";
		rw_prof = true;
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
	rw_prof_check(var1.prof);
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
		!rw_prof  || 
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









//연봉 입력 유효성검사
var iw_positions = false;
var iw_money = false;
var iw_prof = false;
var iw_empl = false;

function iw_prof_check(var1) {
	if(var1.value == -1) {
		document.getElementById("iw_prof_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		iw_prof = false;
	}else{
		document.getElementById("iw_prof_msg").innerHTML = "";
		iw_prof = true;
	}
}
function iw_positions_check(var1) {
	if(var1.value == -1) {
		document.getElementById("iw_positions_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		iw_positions = false;
	}else{
		document.getElementById("iw_positions_msg").innerHTML = "";
		iw_positions = true;
	}
}
function iw_empl_check(var1) {
	if(var1.value == -1) {
		document.getElementById("iw_empl_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		iw_empl = false;
	}else{
		document.getElementById("iw_empl_msg").innerHTML = "";
		iw_empl = true;
	}
}
function iw_money_check(var1) {
	if(var1.value == "") {
		document.getElementById("iw_money_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		iw_money = false;
	}else{
		document.getElementById("iw_money_msg").innerHTML = "";
		iw_money = true;
	}
}
function income_write_submit(var1) {
	iw_prof_check(var1.prof);
	iw_positions_check(var1.positions);
	iw_empl_check(var1.empl);
	iw_money_check(var1.money);
	if(!iw_positions || !iw_money || !iw_prof || !iw_empl) {
		return false;
	}else return true;
}
////////////////////////////////////////////







//면접난이도

function itw_difficulty_btn(stars_num, stars_id, stars_input, stars_msg) {
	var i=0;
	
	for(i=1;i<=5;i++) document.getElementById(stars_id+""+i).setAttribute("class","interview_bk_0");			//전부 흑백으로
	for(i=1;i<=stars_num;i++) document.getElementById(stars_id+""+i).setAttribute("class","interview_bk_"+i);	//선택한 번호까지 컬러로
	
	document.getElementById(stars_input).value = stars_num;		//input에 값넣기

	var msg = "";
	var color = "";
	switch(stars_num) {
	case 1:
		msg = "매우 쉬움";
		color = "#6fba1f";
		break;
	case 2:
		msg = "쉬움";
		color = "#8ad43b";
		break;
	case 3:
		msg = "보통";
		color = "#fb9f00";
		break;
	case 4:
		msg = "어려움";
		color = "#fb6400";
		break;
	case 5:
		msg = "매우어려움";
		color = "#e62b0d";
		break;
		default:
			break;
	}
	document.getElementById(stars_msg).innerHTML = "<span style='color:"+color+";'>"+msg+"</span>";
}
//////////////////////////////////////////


//면접후기 유효성검사
var itw_prof = false;
var itw_positions = false;
var itw_difficulty = false;
var itw_interviewdate = false;
var itw_interviewdir = false;
var itw_memo1 = false;
var itw_memo2 = false;
var itw_memo3 = false;
var itw_memo4 = false;
var itw_memo5 = false;
var itw_interviewresult = false;
var itw_interviewex = false;


function itw_prof_check(var1) {
	if(var1.value == -1) {
		document.getElementById("itw_prof_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		itw_prof = false;
	}else{
		document.getElementById("itw_prof_msg").innerHTML = "";
		itw_prof = true;
	}
}
function itw_positions_check(var1) {
	if(var1.value == -1) {
		document.getElementById("itw_positions_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		itw_positions = false;
	}else{
		document.getElementById("itw_positions_msg").innerHTML = "";
		itw_positions = true;
	}
}
function itw_difficulty_check(var1) {
	if(var1.value == -1) {
		document.getElementById("itw_difficulty_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		itw_difficulty = false;
	}else{
		document.getElementById("itw_difficulty_msg").innerHTML = "";
		itw_difficulty = true;
	}
}
function itw_interviewdate_check(var1) {
	if(var1.value == -1) {
		document.getElementById("itw_interviewdate_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		itw_interviewdate = false;
	}else{
		document.getElementById("itw_interviewdate_msg").innerHTML = "";
		itw_interviewdate = true;
	}
}
function itw_interviewdir_check(var1) {
	if(var1.value == -1) {
		document.getElementById("itw_interviewdir_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		itw_interviewdir = false;
	}else{
		document.getElementById("itw_interviewdir_msg").innerHTML = "";
		itw_interviewdir = true;
	}
}
function itw_memo1_check(var1) {
	if(var1.value == "") {
		document.getElementById("itw_memo1_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		itw_memo1 = false;
	}else{
		document.getElementById("itw_memo1_msg").innerHTML = "";
		itw_memo1 = true;
	}
}
function itw_memo2_check(var1) {
	if(var1.value == "") {
		document.getElementById("itw_memo2_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		itw_memo2 = false;
	}else{
		document.getElementById("itw_memo2_msg").innerHTML = "";
		itw_memo2 = true;
	}
}
function itw_memo3_check(var1) {
	if(var1.value == "") {
		document.getElementById("itw_memo3_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		itw_memo3 = false;
	}else{
		document.getElementById("itw_memo3_msg").innerHTML = "";
		itw_memo3 = true;
	}
}
function itw_memo4_check(var1) {
	if(var1.value == "") {
		document.getElementById("itw_memo4_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		itw_memo4 = false;
	}else{
		document.getElementById("itw_memo4_msg").innerHTML = "";
		itw_memo4 = true;
	}
}
function itw_memo5_check(var1) {
	if(var1.value == "") {
		document.getElementById("itw_memo5_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		itw_memo5 = false;
	}else{
		document.getElementById("itw_memo5_msg").innerHTML = "";
		itw_memo5 = true;
	}
}
function itw_interviewresult_check(var1) {
	if(var1.value == -1) {
		document.getElementById("itw_interviewresult_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		itw_interviewresult = false;
	}else{
		document.getElementById("itw_interviewresult_msg").innerHTML = "";
		itw_interviewresult = true;
	}
}
function itw_interviewex_check(var1) {
	if(var1.value == -1) {
		document.getElementById("itw_interviewex_msg").innerHTML = "<span style='color:red;'>선택해주세요.</span>";
		itw_interviewex = false;
	}else{
		document.getElementById("itw_interviewex_msg").innerHTML = "";
		itw_interviewex = true;
	}
}
function interview_write_submit(var1) {
	itw_prof_check(var1.prof);
	itw_positions_check(var1.positions);
	itw_difficulty_check(var1.difficulty);
	itw_interviewdate_check(var1.interviewdate);
	itw_interviewdir_check(var1.interviewdir);
	itw_memo1_check(var1.memo1);
	itw_memo2_check(var1.memo2);
	itw_memo3_check(var1.memo3);
	itw_memo4_check(var1.memo4);
	itw_memo5_check(var1.memo5);
	itw_interviewresult_check(var1.interviewresult);
	itw_interviewex_check(var1.interviewex);
	
	if(!itw_prof ||
			!itw_positions ||
			!itw_difficulty ||
			!itw_interviewdate ||
			!itw_interviewdir ||
			!itw_memo1 ||
			!itw_memo2 ||
			!itw_memo3 ||
			!itw_memo4 ||
			!itw_memo5 ||
			!itw_interviewresult ||
			!itw_interviewex) {
		return false;
	}else return true;
}
////////////////////////////////////////








//채용정보 유효성검사
var rc_subject = false;
var rc_enddates = false;
var rc_keyword = false;
var rc_memo1 = true;
var rc_memo2 = true;
var rc_memo3 = true;
var rc_memo4 = true;
var rc_memo5 = true;
var rc_contact = false;
var rc_prof = false;
var rc_empl = false;
var rc_grade = false;
var rc_money = false;
var rc_positions1 = false;
var rc_positions2 = false;

function rc_subject_check(var1) {
	var temp = "rc_subject";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_subject = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc_subject = true;
	}
}
function rc_enddates_check(var1) {
	var temp = "rc_enddates";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_enddates = false;
	}else{
		var tmp = var1.value.split("-");
		if(tmp.length != 3) {
			document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>잘못된 날짜 형식입니다.</span>";
			rc_enddates = false;
		}else{
			document.getElementById(temp+"_msg").innerHTML = "";
			rc_enddates = true;
		}
	}
}
function rc_keyword_check(var1) {
	var temp = "rc_keyword";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_keyword = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc_keyword = true;
	}
}

function rc_memo1_check(var1) {}
function rc_memo2_check(var1) {}
function rc_memo3_check(var1) {}
function rc_memo4_check(var1) {}
function rc_memo5_check(var1) {}

function rc_contact_check(var1) {
	var temp = "rc_contact";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_contact = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc_contact = true;
	}
}
function rc_prof_check(var1) {
	var temp = "rc_prof";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_prof = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc_prof = true;
	}
}
function rc_empl_check(var1) {
	var temp = "rc_empl";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_empl = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc_empl = true;
	}
}
function rc_grade_check(var1) {
	var temp = "rc_grade";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_grade = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc_grade = true;
	}
}
function rc_money_check(var1) {
	var temp = "rc_money";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_money = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc_money = true;
	}
}
function rc_positions1_check(var1) {
	var temp = "rc_positions1";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_positions1 = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc_positions1 = true;
	}
}
function rc_positions2_check(var1) {
	var temp = "rc_positions2";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc_positions2 = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc_positions2 = true;
	}
}
function recruit_write_submit(var1) {
	rc_subject_check(var1.subject);
	rc_enddates_check(var1.enddates);
	rc_keyword_check(var1.keyword);
	rc_memo1_check(var1.memo1);
	rc_memo2_check(var1.memo2);
	rc_memo3_check(var1.memo3);
	rc_memo4_check(var1.memo4);
	rc_memo5_check(var1.memo5);
	rc_contact_check(var1.contact);
	rc_prof_check(var1.prof);
	rc_empl_check(var1.empl);
	rc_grade_check(var1.grade);
	rc_money_check(var1.money);
	rc_positions1_check(var1.positions1);
	rc_positions2_check(var1.positions2);
	
	if(
			!rc_subject  ||
			!rc_enddates  ||
			!rc_keyword  ||
			!rc_memo1  ||
			!rc_memo2  ||
			!rc_memo3  ||
			!rc_memo4  ||
			!rc_memo5  ||
			!rc_contact  ||
			!rc_prof ||
			!rc_empl ||
			!rc_grade ||
			!rc_money ||
			!rc_positions1 ||
			!rc_positions2
	){
		return false;
	} else return true;
}
////////////////////////////////////////







//채용정보 수정 유효성검사
var rc2_subject = false;
var rc2_enddates = false;
var rc2_keyword = false;
var rc2_memo1 = true;
var rc2_memo2 = true;
var rc2_memo3 = true;
var rc2_memo4 = true;
var rc2_memo5 = true;
var rc2_contact = false;
var rc2_prof = false;
var rc2_empl = false;
var rc2_grade = false;
var rc2_money = false;
var rc2_positions1 = false;
var rc2_positions2 = false;

function rc2_subject_check(var1) {
	var temp = "rc2_subject";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_subject = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc2_subject = true;
	}
}
function rc2_enddates_check(var1) {
	var temp = "rc2_enddates";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_enddates = false;
	}else{
		var tmp = var1.value.split("-");
		if(tmp.length != 3) {
			document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>잘못된 날짜 형식입니다.</span>";
			rc2_enddates = false;
		}else{
			document.getElementById(temp+"_msg").innerHTML = "";
			rc2_enddates = true;
		}
	}
}
function rc2_keyword_check(var1) {
	var temp = "rc2_keyword";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_keyword = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc2_keyword = true;
	}
}

function rc2_memo1_check(var1) {}
function rc2_memo2_check(var1) {}
function rc2_memo3_check(var1) {}
function rc2_memo4_check(var1) {}
function rc2_memo5_check(var1) {}

function rc2_contact_check(var1) {
	var temp = "rc2_contact";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_contact = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc2_contact = true;
	}
}
function rc2_prof_check(var1) {
	var temp = "rc2_prof";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_prof = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc2_prof = true;
	}
}
function rc2_empl_check(var1) {
	var temp = "rc2_empl";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_empl = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc2_empl = true;
	}
}
function rc2_grade_check(var1) {
	var temp = "rc2_grade";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_grade = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc2_grade = true;
	}
}
function rc2_money_check(var1) {
	var temp = "rc2_money";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_money = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc2_money = true;
	}
}
function rc2_positions1_check(var1) {
	var temp = "rc2_positions1";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_positions1 = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc2_positions1 = true;
	}
}
function rc2_positions2_check(var1) {
	var temp = "rc2_positions2";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rc2_positions2 = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rc2_positions2 = true;
	}
}
function recruit_edit_submit(var1) {
	rc2_subject_check(var1.subject);
	rc2_enddates_check(var1.enddates);
	rc2_keyword_check(var1.keyword);
	rc2_memo1_check(var1.memo1);
	rc2_memo2_check(var1.memo2);
	rc2_memo3_check(var1.memo3);
	rc2_memo4_check(var1.memo4);
	rc2_memo5_check(var1.memo5);
	rc2_contact_check(var1.contact);
	rc2_prof_check(var1.prof);
	rc2_empl_check(var1.empl);
	rc2_grade_check(var1.grade);
	rc2_money_check(var1.money);
	rc2_positions1_check(var1.positions1);
	rc2_positions2_check(var1.positions2);
	
	if(
			!rc2_subject  ||
			!rc2_enddates  ||
			!rc2_keyword  ||
			!rc2_memo1  ||
			!rc2_memo2  ||
			!rc2_memo3  ||
			!rc2_memo4  ||
			!rc2_memo5  ||
			!rc2_contact  ||
			!rc2_prof ||
			!rc2_empl ||
			!rc2_grade ||
			!rc2_money ||
			!rc2_positions1 ||
			!rc2_positions2
	){
		return false;
	} else return true;
}
/////////////////////////////////////////







//다이어로그
function dialog(var1, var2) {
	var reVal = confirm(var1);
	if(reVal == true) {
		location.href=var2;
	}
}
/////////////////////////////////////////









//지원서 작성 유효성검사
var rca_name = false;
var rca_phone1 = false;
var rca_phone2 = false;
var rca_phone3 = false;
var rca_email = false;
var rca_files1 = false;
var rca_files3 = false;

function rca_name_check(var1) {
	var temp = "rca_name";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rca_name = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rca_name = true;
	}
}
function rca_phone1_check(var1) {
	var temp = "rca_phone";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rca_phone1 = false;
	}else{
		rca_phone1 = true;
		if(!rca_phone2 || !rca_phone3) {
			document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		}else{
			document.getElementById(temp+"_msg").innerHTML = "";
		}
	}
}
function rca_phone2_check(var1) {
	var temp = "rca_phone";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rca_phone2 = false;
	}else{
		rca_phone2 = true;
		if(!rca_phone1 || !rca_phone3) {
			document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		}else{
			document.getElementById(temp+"_msg").innerHTML = "";
		}
	}
}
function rca_phone3_check(var1) {
	var temp = "rca_phone";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rca_phone3 = false;
	}else{
		rca_phone3 = true;
		if(!rca_phone1 || !rca_phone2) {
			document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		}else{
			document.getElementById(temp+"_msg").innerHTML = "";
		}
	}
}
function rca_email_check(var1) {
	var temp = "rca_email";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rca_email = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rca_email = true;
	}
}
function rca_files1_check(var1) {
	var temp = "rca_files1";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rca_files1 = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rca_files1 = true;
	}
}
function rca_files3_check(var1) {
	var temp = "rca_files3";
	if(var1.value == "") {
		document.getElementById(temp+"_msg").innerHTML = "<span style='color:red;'>입력해주세요.</span>";
		rca_files3 = false;
	}else{
		document.getElementById(temp+"_msg").innerHTML = "";
		rca_files3 = true;
	}
}
function recruit_add_submit(var1) {
	rca_name_check(var1.name);
	rca_phone1_check(var1.phone1);
	rca_phone2_check(var1.phone2);
	rca_phone3_check(var1.phone3);
	rca_email_check(var1.email);
	rca_files1_check(var1.files1);
	rca_files3_check(var1.files3);
	
	if(!rca_name ||
			!rca_phone1 ||
			!rca_phone2 ||
			!rca_phone3 ||
			!rca_email ||
			!rca_files1 ||
			!rca_files3){
		return false;
	}else return true;
}
/////////////////////////////////////////















//팔로우 ajax
function follow_ajax(var1, var2) {
	$.ajax({
		url:'follow_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			member_no:var1
		},
		success:function(result){
			alert(result.msg);
			if(result.result == 1)
				document.getElementById(var2).setAttribute("src","./images/heart.jpg");
			else if(result.result == 2)
				document.getElementById(var2).setAttribute("src","./images/heart2.jpg");
		},
		error:function(r,s,e) {
			alert('error');
		}
	});
}

//////////////////////////////////////////








//메뉴
function setmenu(var1) {
	document.getElementById("nav_btn1").setAttribute("class","nav_ul_li_a");
	document.getElementById("nav_btn2").setAttribute("class","nav_ul_li_a");
	document.getElementById("nav_btn3").setAttribute("class","nav_ul_li_a");
	document.getElementById("nav_btn4").setAttribute("class","nav_ul_li_a");
	document.getElementById("nav_btn5").setAttribute("class","nav_ul_li_a");
	

	var1.setAttribute("class","nav_ul_li_a_hover");
}









//view ajax

//뷰
function view_ajax(member_no) {
	$.ajax({
		url:'view_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			member_no:member_no
		},
		success:function(result){
			var htmls = "";
			var cdata = result.cdata;
			htmls += '	<div class="container">	';
			htmls += '	  <div class="row">	';
			htmls += '	    <div class="col-sm-1"></div>	';
			htmls += '	    <div class="col-sm-10">	';
			htmls += '	    	';
			htmls += '	    	';
			htmls += '	    	';
			htmls += '	    	';
			htmls += '	      <div class="contents">	';
			htmls += '	        	';
			htmls += '	        <h3>기업정보</h3>	';
			htmls += '	        <p>	';
			htmls += '	          '+cdata.info;
			htmls += '	        </p>	';
			htmls += '	        <table cellspacing="0" cellpadding="0" class="info_table">	';
			htmls += '	          <tr>	';
			htmls += '	            <th width="10%"><div style="width:60px;overflow:hidden;">대표</div></th>	';
			htmls += '	            <td width="40%">'+cdata.name+'</td>	';
			htmls += '	            <th width="10%"><div style="width:50px;overflow:hidden;">설립일</div></th>	';
			htmls += '	            <td width="40%">'+cdata.founding+'</td>	';
			htmls += '	          </tr>	';
			htmls += '	          <tr>	';
			htmls += '	            <th>카테고리</th>	';
			htmls += '	            <td>	';
			
			if(cdata.company_cate == 1) htmls += '			서비스업"	';
			if(cdata.company_cate == 2) htmls += '	              제조/화학	';
			if(cdata.company_cate == 3) htmls += '	              의료/제약/복지	';
			if(cdata.company_cate == 4) htmls += '	              유통/무역/운송	';
			if(cdata.company_cate == 5) htmls += '	              교육업	';
			if(cdata.company_cate == 6) htmls += '	              건설업	';
			if(cdata.company_cate == 7) htmls += '	        IT/웹/통신	';
			if(cdata.company_cate == 8) htmls += '	              미디어/디자인	';
			if(cdata.company_cate == 9) htmls += '	              은행/금융업	';
			if(cdata.company_cate == 10) htmls += '	              기관/협회	';
			htmls += '				</td>	';
			htmls += '	            <th>사원수</th>	';
			htmls += '	            <td>${cdata.count}</td>	';
			htmls += '	          </tr>	';
			htmls += '	          <tr>	';
			htmls += '	            <th>기업형태</th>	';
			htmls += '	            <td>	';
			if(cdata.company_type == 1) htmls += '	            	대기업	';
			if(cdata.company_type == 2) htmls += '		  			중소기업	';
			if(cdata.company_type == 3) htmls += '		  			벤처기업	';
			htmls += '	            </td>	';
			htmls += '	            <th>매출액</th>	';
			htmls += '	            <td>'+cdata.money+'</td>	';
			htmls += '	          </tr>	';
			htmls += '	          <tr>	';
			htmls += '	            <th>웹사이트</th>	';
			htmls += '	            <td colspan="3">'+cdata.url+'</td>	';
			htmls += '	          </tr>	';
			htmls += '	          <tr>	';
			htmls += '	            <th>본사</th>	';
			htmls += '	            <td colspan="3">'+cdata.addr+'</td>	';
			htmls += '	          </tr>	';
			htmls += '	        </table>	';
			htmls += '	      </div>	';
			htmls += '	      	';
			htmls += '	      	';
			htmls += '	      	';
			htmls += '	      	';
			htmls += '	      	';
			htmls += '	    </div>	';
			htmls += '	    <div class="col-sm-1"></div>	';
			htmls += '	  </div>	';
			htmls += '	</div>	';
			
			document.getElementById('interview_all').style.display='none';
			document.getElementById("hitcount_bg").style.display = "";
			drawChart();
			document.getElementById("view_contents2").innerHTML = "";
			document.getElementById("view_contents").innerHTML = htmls;

		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//리뷰
function review_ajax(pages_r, member_no) {
	$.ajax({
		url:'review_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			pages_r:pages_r,
			member_no:member_no
		},
		success:function(result){
			var htmls = "";
			
			//작성폼
			htmls += '<div class="write_hide" id="review_write" style="display:none;">';
			htmls += '<div class="write_hide_scroll">';
			htmls += '    <form id="review_forms">';
			htmls += '    <div class="write_hide_scroll2">';
			htmls += '    <div class="review_write_box">';
			htmls += '      <h1>기업리뷰 작성</h1>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	기업 총 평점<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(1,\'rw_star\',\'stars\',\'stars_msg\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(2,\'rw_star\',\'stars\',\'stars_msg\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(3,\'rw_star\',\'stars\',\'stars_msg\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(4,\'rw_star\',\'stars\',\'stars_msg\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(5,\'rw_star\',\'stars\',\'stars_msg\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5" /></a>';
			htmls += '	        <input type="hidden" name="stars" id="stars" value="-1" onchange="rw_stars_check(this);" />';
			htmls += '	        <span id="stars_msg" style="font-weight:bold;">평가해주세요.</span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	현 직장/전 직장<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="types" class="join_select" onchange="rw_types_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">현 직장</option>';
			htmls += '	  			<option value="2" >전 직장</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="types_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	직종<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="prof" class="join_select" onchange="rw_prof_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">IT/인터넷</option>';
			htmls += '	  			<option value="2" >경영/기획/컨설팅</option>';
			htmls += '	  			<option value="3" >교육</option>';
			htmls += '	  			<option value="4" >금융/재무</option>';
			htmls += '	  			<option value="5" >디자인</option>';
			htmls += '	  			<option value="6" >마케팅/시장조사</option>';
			htmls += '	  			<option value="7" >미디어/홍보</option>';
			htmls += '	  			<option value="8" >법률/법무</option>';
			htmls += '	  			<option value="9" >생산/제조</option>';
			htmls += '	  			<option value="10" >기타</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="prof_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	기업한줄평<br />';
			htmls += '	    	<span>최소 20자</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <textarea rows="100" cols="100" class="edit_textarea" name="memo1" onchange="rw_memo1_check(this);" placeholder="예) 개발자가 대우받으며 보람차게 일할 수 있는 곳. 다양한 개발 환경을 경험하고, 서버와 클라이언트 양쪽에서 커리어를 쌓고 싶은 사람에게 추천."></textarea>';
			htmls += '      		<span id="memo1_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	기업의 장점<br />';
			htmls += '	    	<span>최소 30자</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <textarea rows="100" cols="100" class="edit_textarea" name="memo2" onchange="rw_memo2_check(this);" placeholder="예) 연차를 윗사람 눈치 안 보고 쓸 수 있음, 도서구입비, 학원 수강료 등 자기 계발 비용 지원, 야근 식대 1만원까지 제공, 수평적인 사무실 분위기. 업무 분담 체계가 확실해 자기 분야 전문성을 기를 수 있음."></textarea>';
			htmls += '	      	<span id="memo2_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	기업의 단점<br />';
			htmls += '	    	<span>최소 30자</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <textarea rows="100" cols="100" class="edit_textarea" name="memo3" onchange="rw_memo3_check(this);" placeholder="예) 단순 보고를 위한 문서 작업이 많아 비효율적. 복지 제도가 다양하지만 실제로 쓸 수 없음. 출근 시간은 8시인데 퇴근 시간은 ???. 연봉이 많다지만 시간급은 형편없음. 과장 차장이 많아 승진이 힘들다."></textarea>';
			htmls += '	      	<span id="memo3_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	승진기회 및 가능성';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(1,\'rw_star1_\',\'stars1\',\'stars_msg1\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_1" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(2,\'rw_star1_\',\'stars1\',\'stars_msg1\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_2" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(3,\'rw_star1_\',\'stars1\',\'stars_msg1\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_3" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(4,\'rw_star1_\',\'stars1\',\'stars_msg1\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_4" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(5,\'rw_star1_\',\'stars1\',\'stars_msg1\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star1_5" /></a>';
			htmls += '	        <input type="hidden" name="stars1" id="stars1" value="-1" onchange="rw_stars1_check(this);" />';
			htmls += '	        <span id="stars_msg1" style="font-weight:bold;">평가해주세요.</span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	복지 및 급여';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(1,\'rw_star2_\',\'stars2\',\'stars_msg2\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_1" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(2,\'rw_star2_\',\'stars2\',\'stars_msg2\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_2" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(3,\'rw_star2_\',\'stars2\',\'stars_msg2\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_3" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(4,\'rw_star2_\',\'stars2\',\'stars_msg2\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_4" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(5,\'rw_star2_\',\'stars2\',\'stars_msg2\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star2_5" /></a>';
			htmls += '	        <input type="hidden" name="stars2" id="stars2" value="-1" onchange="rw_stars2_check(this);" />';
			htmls += '	        <span id="stars_msg2" style="font-weight:bold;">평가해주세요.</span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	업무와 삶의 균형';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(1,\'rw_star3_\',\'stars3\',\'stars_msg3\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_1" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(2,\'rw_star3_\',\'stars3\',\'stars_msg3\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_2" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(3,\'rw_star3_\',\'stars3\',\'stars_msg3\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_3" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(4,\'rw_star3_\',\'stars3\',\'stars_msg3\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_4" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(5,\'rw_star3_\',\'stars3\',\'stars_msg3\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star3_5" /></a>';
			htmls += '	        <input type="hidden" name="stars3" id="stars3" value="-1" onchange="rw_stars3_check(this);" />';
			htmls += '	        <span id="stars_msg3" style="font-weight:bold;">평가해주세요.</span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	사내문화';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(1,\'rw_star4_\',\'stars4\',\'stars_msg4\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_1" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(2,\'rw_star4_\',\'stars4\',\'stars_msg4\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_2" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(3,\'rw_star4_\',\'stars4\',\'stars_msg4\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_3" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(4,\'rw_star4_\',\'stars4\',\'stars_msg4\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_4" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(5,\'rw_star4_\',\'stars4\',\'stars_msg4\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star4_5" /></a>';
			htmls += '	        <input type="hidden" name="stars4" id="stars4" value="-1" onchange="rw_stars4_check(this);" />';
			htmls += '	        <span id="stars_msg4" style="font-weight:bold;">평가해주세요.</span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	경영진';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(1,\'rw_star5_\',\'stars5\',\'stars_msg5\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_1" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(2,\'rw_star5_\',\'stars5\',\'stars_msg5\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_2" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(3,\'rw_star5_\',\'stars5\',\'stars_msg5\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_3" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(4,\'rw_star5_\',\'stars5\',\'stars_msg5\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_4" /></a>';
			htmls += '	        <a href="#100" onclick="rw_stars_btn(5,\'rw_star5_\',\'stars5\',\'stars_msg5\');"><img src="./images/rw_star1.jpg" alt="별점" id="rw_star5_5" /></a>';
			htmls += '	        <input type="hidden" name="stars5" id="stars5" value="-1" onchange="rw_stars5_check(this);" />';
			htmls += '	        <span id="stars_msg5" style="font-weight:bold;">평가해주세요.</span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line align-center">';
			htmls += '	      <input type="button" value="닫기" onclick="hide2(\'review_write\');document.body.style.overflow = \'scroll\';" class="review_write_btn2" />';
			htmls += '	      <input type="button" value="제출하기" class="review_write_btn1" onclick="review_post_ajax(document.getElementById(\'review_forms\'),'+member_no+');" />';
			htmls += '      </div>';
			htmls += '    </div>';
			htmls += '    </div>';
			htmls += '    </form>';
			htmls += '</div>';
			htmls += '</div>';
			
			
			
			
			
			
			htmls += '<div class="container">';
			htmls += '  <div class="row">';
			htmls += '    <div class="col-sm-1"></div>';
			htmls += '    <div class="col-sm-10">';
			
			htmls += '    <div class="review_write log_1" ';
			if(result.memberInfo == null || (result.memberInfo != null && result.memberInfo.orders != 1)) {
				htmls += ' style="display:none;" ';
			}
			htmls += ' id="review_write_btn_bg">';
			htmls += '    	<a href="#100" onclick="show2(\'review_write\');document.body.style.overflow = \'hidden\';">새로운리뷰 작성하기</a>';
			htmls += '    </div>';
			
			
			//총 리뷰
			htmls += '<div class="contents">';
			htmls += '  <div class="container">';
			htmls += '    <div class="row">';
			htmls += '        <div class="col-sm-4" style="width:220px;">';
			htmls += '          <h1><img src="./images/review_h.jpg" alt="전체 리뷰 통계" /><span>전체</span> 리뷰 통계 ('+result.count2+'명)</h1>';
			htmls += '          <p>';
			htmls += '            <div class="review_star_l">'+result.stars+'</div>';
			htmls += '            <div class="review_star_r">';
			htmls += '                <div class="review_star_line0"></div>';
			htmls += '                <!-- 68px -->';
			htmls += '                <div class="review_star_line1" style="width:'+result.stars_bar+'px;"></div>';
			htmls += '                <div class="review_star_line_b">총 만족도</div>';
			htmls += '            </div>';
			htmls += '          </p>';
			htmls += '        </div>';
			htmls += '        <div class="col-sm-5 col-md-6 col-lg-7">';
			htmls += '          <h5>승진 기회 및 가능성</h5>';
			htmls += '          <div class="r_bar_bg">';
			htmls += '            <div class="r_bar1"><div class="r_bar2" style="width:'+result.stars_bar1+'%;"></div></div>';
			htmls += '            <div class="r_bar_score">'+result.stars1+'</div>';
			htmls += '          </div>';
			htmls += '          <div class="r_bar_bg">';
			htmls += '            <h5>복지 및 급여</h5>';
			htmls += '            <div class="r_bar1"><div class="r_bar2" style="width:'+result.stars_bar2+'%;"></div></div>';
			htmls += '            <div class="r_bar_score">'+result.stars2+'</div>';
			htmls += '          </div>';
			htmls += '          <div class="r_bar_bg">';
			htmls += '            <h5>업무와 삶의 균형</h5>';
			htmls += '            <div class="r_bar1"><div class="r_bar2" style="width:'+result.stars_bar3+'%;"></div></div>';
			htmls += '            <div class="r_bar_score">'+result.stars3+'</div>';
			htmls += '          </div>';
			htmls += '          <div class="r_bar_bg">';
			htmls += '            <h5>사내문화</h5>';
			htmls += '            <div class="r_bar1"><div class="r_bar2" style="width:'+result.stars_bar4+'%;"></div></div>';
			htmls += '            <div class="r_bar_score">'+result.stars4+'</div>';
			htmls += '          </div>';
			htmls += '          <div class="r_bar_bg">';
			htmls += '            <h5>경영진</h5>';
			htmls += '            <div class="r_bar1"><div class="r_bar2" style="width:'+result.stars_bar5+'%;"></div></div>';
			htmls += '            <div class="r_bar_score">'+result.stars5+'</div>';
			htmls += '          </div>';
			htmls += '        </div>';
			htmls += '    </div>';
			htmls += '  </div>';
			htmls += '</div>';
			
			
			
			
			
			
			
			
			
			//리스트
			var list = result.list;
			var list_length = Object.keys(list).length;
			
			var i = 0;
			for(i=0;i<list_length;i++) {
				var rdata = list[i];
				htmls += '<div class="contents">';
				htmls += '      <div class="review_header">';
				if(rdata.prof == 1) htmls += '     	IT/인터넷';
				if(rdata.prof == 2) htmls += '	  	경영/기획/컨설팅';
				if(rdata.prof == 3) htmls += '	  	교육';
				if(rdata.prof == 4) htmls += '	  	금융/재무';
				if(rdata.prof == 5) htmls += '	  	디자인';
				if(rdata.prof == 6) htmls += '	  	마케팅/시장조사';
				if(rdata.prof == 7) htmls += '	  	미디어/홍보';
				if(rdata.prof == 8) htmls += '	  	법률/법무';
				if(rdata.prof == 9) htmls += '	  	생산/제조';
				if(rdata.prof == 10) htmls += '	  	기타';
				htmls += '         | ';
				if(rdata.types == 1) htmls += '	  	현 직장';
				if(rdata.types == 2) htmls += '	  	전 직장';
				htmls += '         | '+rdata.dates;
				htmls += '      </div>';
				htmls += '      <div class="container">';
				htmls += '        <div class="row">';
				htmls += '          <div class="review_l col-sm-2 col-md-2">';
				htmls += '            <div class="review_l_star">';
				var j = 0;
				for(j=1;j<=rdata.stars;j++) {
					htmls += '              <img src="./images/stars00.jpg" alt="star" />';
				}
				for(j=1;j<=(5-rdata.stars);j++) {
					htmls += '              <img src="./images/stars11.jpg" alt="star" />';
				}
				htmls += '            </div>';
				htmls += '            <div class="review_l_list hidden-xs">';
				htmls += '              <h5>승진 기회 및 가능성</h5>';
				htmls += '              <ul>';
				for(j=1;j<=rdata.stars1;j++) {
					htmls += '              <li></li>';
				}
				for(j=1;j<=(5-rdata.stars1);j++) {
					htmls += '              <li style="background:#dddddd;"></li>';
				}
				htmls += '              </ul>';
				htmls += '              <h5>복지 및 급여</h5>';
				htmls += '              <ul>';
				for(j=1;j<=rdata.stars2;j++) {
					htmls += '              <li></li>';
				}
				for(j=1;j<=(5-rdata.stars2);j++) {
					htmls += '              <li style="background:#dddddd;"></li>';
				}
				htmls += '              </ul>';
				htmls += '              <h5>업무와 삶의 균형</h5>';
				htmls += '              <ul>';
				for(j=1;j<=rdata.stars3;j++) {
					htmls += '              <li></li>';
				}
				for(j=1;j<=(5-rdata.stars3);j++) {
					htmls += '              <li style="background:#dddddd;"></li>';
				}
				htmls += '              </ul>';
				htmls += '              <h5>사내문화</h5>';
				htmls += '              <ul>';
				for(j=1;j<=rdata.stars4;j++) {
					htmls += '              <li></li>';
				}
				for(j=1;j<=(5-rdata.stars4);j++) {
					htmls += '              <li style="background:#dddddd;"></li>';
				}
				htmls += '              </ul>';
				htmls += '              <h5>경영진</h5>';
				htmls += '              <ul>';
				for(j=1;j<=rdata.stars5;j++) {
					htmls += '              <li></li>';
				}
				for(j=1;j<=(5-rdata.stars5);j++) {
					htmls += '              <li style="background:#dddddd;"></li>';
				}
				htmls += '              </ul>';
				htmls += '            </div>';
				htmls += '          </div>';
				htmls += '          <div class="review_r col-sm-6 col-md-7">';
				htmls += '            <h3>"'+rdata.memo1+'"</h3>';
				htmls += '            <h5 style="color:#0f7ccf;">장점</h5>';
				htmls += '            <p>';
				htmls += '              '+rdata.memo2;
				htmls += '            </p>';
				htmls += '            <h5 style="color:#fc4a13;">단점</h5>';
				htmls += '            <p>';
				htmls += '              '+rdata.memo3;
				htmls += '            </p>';
				htmls += '          </div>';
				htmls += '        </div>';
				htmls += '      </div>';
				htmls += '    </div>';
				
				
			}

			
			//페이징
			var paging = result.paging;
			htmls += '		<div class="paging">';
			htmls += '        <a href="#100" onclick="review_ajax(1,'+member_no+')" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>';
			var j = 0;
			for(j=paging.pstarts;j<=paging.pends;j++) {
				htmls += '        	<a href="#100" onclick="review_ajax('+j+','+member_no+')"';
				if(j == pages_r) htmls += ' class="paging_a_hover" ';
				else htmls += ' class="paging_a" ';
				htmls += '> '+j;
				htmls += '        	</a>';
			}
			htmls += '        <a href="#100" onclick="review_ajax('+paging.board_paging+','+member_no+')" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>';
			htmls += '      </div>';
			
			
			
			
			
			
			
			
			
			
			
			htmls += '    </div>';
			htmls += '    <div class="col-sm-1"></div>';
			htmls += '  </div>';
			htmls += '</div>';
			
			document.getElementById('interview_all').style.display='none';
			document.getElementById('hitcount_bg').style.display='none';
			document.getElementById("view_contents2").innerHTML = "";
			document.getElementById("view_contents").innerHTML = htmls;
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//리뷰 작성하기
function review_post_ajax(forms, member_no) {
	//유효성검사 통과시에만 실행
	if(review_write_submit(forms) == true) {
		$.ajax({
			url:'review_write_post_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				member_no:member_no,
				stars:forms.stars.value,
				types:forms.types.value,
				prof:forms.prof.value,
				memo1:forms.memo1.value,
				memo2:forms.memo2.value,
				memo3:forms.memo3.value,
				stars1:forms.stars1.value,
				stars2:forms.stars2.value,
				stars3:forms.stars3.value,
				stars4:forms.stars4.value,
				stars5:forms.stars5.value
			},
			success:function(result){
				if(result.result != true) {
					alert(result.msg);
				}else{
					review_ajax(1, member_no);
					alert('작성완료');
					document.body.style.overflow = 'scroll';
					view_menu_count_ajax(member_no);
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}
//연봉
function income_ajax(member_no) {
	$.ajax({
		url:'income_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			member_no:member_no
		},
		success:function(result){
			var htmls = "";
			htmls += '<div class="write_hide" id="income_write" style="display:none;">';
			htmls += '<div class="write_hide_scroll">';
			htmls += '    <form id="income_forms">';
			htmls += '    <div class="write_hide_scroll2">';
			htmls += '    <div class="review_write_box">';
			htmls += '      <h1>기업연봉 작성</h1>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	직종<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="prof" class="join_select" onchange="iw_prof_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">IT/인터넷</option>';
			htmls += '	  			<option value="2" >경영/기획/컨설팅</option>';
			htmls += '	  			<option value="3" >교육</option>';
			htmls += '	  			<option value="4" >금융/재무</option>';
			htmls += '	  			<option value="5" >디자인</option>';
			htmls += '	  			<option value="6" >마케팅/시장조사</option>';
			htmls += '	  			<option value="7" >미디어/홍보</option>';
			htmls += '	  			<option value="8" >법률/법무</option>';
			htmls += '	  			<option value="9" >생산/제조</option>';
			htmls += '	  			<option value="10" >기타</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="iw_prof_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	직급<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="positions" class="join_select" onchange="iw_positions_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">사원-대졸</option>';
			htmls += '	  			<option value="2">사원-전문대졸</option>';
			htmls += '	  			<option value="3">사원-고졸</option>';
			htmls += '	  			<option value="4">주임/계장</option>';
			htmls += '	  			<option value="5">대리</option>';
			htmls += '	  			<option value="6">과장</option>';
			htmls += '	  			<option value="7">차장</option>';
			htmls += '	  			<option value="8">부장</option>';
			htmls += '	  			<option value="9">이사</option>';
			htmls += '	  			<option value="10">기타</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="iw_positions_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	고용형태<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="empl" class="join_select" onchange="iw_empl_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">인턴직</option>';
			htmls += '	  			<option value="2" >아르바이트</option>';
			htmls += '	  			<option value="3" >정규직</option>';
			htmls += '	  			<option value="4" >계약직</option>';
			htmls += '	  			<option value="5" >프리렌서</option>';
			htmls += '	  			<option value="6" >기타</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="iw_empl_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	기본급여(연봉)<br />';
			htmls += '	    	<span>(만원)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <input type="text" name="money" placeholder="기본급여 (연봉)" class="login_input" onchange="iw_money_check(this);" />';
			htmls += '      		<span id="iw_money_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line align-center">';
			htmls += '	      <input type="button" value="닫기" onclick="hide2(\'income_write\');document.body.style.overflow = \'scroll\';" class="review_write_btn2" />';
			htmls += '	      <input type="button" value="제출하기" class="review_write_btn1" onclick="income_post_ajax(document.getElementById(\'income_forms\'),'+member_no+')" />';
			htmls += '      </div>';
			htmls += '    </div>';
			htmls += '    </div>';
			htmls += '    </form>';
			htmls += '</div>';
			htmls += '</div>';

			
			
			
			
			
			
			
			
			
			
			htmls += '<div class="container">';
			htmls += '  <div class="row">';
			htmls += '    <div class="col-sm-1 col-md-2 col-lg-2"></div>';
			htmls += '    <div class="col-sm-10 col-md-8 col-lg-8">';

			htmls += '    <div class="review_write log_1" ';
			if(result.memberInfo == null || (result.memberInfo != null && result.memberInfo.orders != 1)) {
				htmls += ' style="display:none;" ';
			}
			htmls += ' id="income_write_btn_bg">';
			htmls += '    	<a href="#100" onclick="show2(\'income_write\');document.body.style.overflow = \'hidden\';">새로운 연봉정보 작성하기</a>';
			htmls += '    </div>'
				
			
			htmls += '    <div class="income_header">';
			htmls += '      <div class="income_header_l">';
			htmls += '        <h5>평균연봉</h5>';
			htmls += '        <p>';
			htmls += '          '+result.avgs;
			htmls += '          <span>만원</span>';
			htmls += '        </p>';
			htmls += '      </div>';
			htmls += '      <div class="income_header_r">';
			htmls += '        <h5>전체 순위</h5>';
			htmls += '        <p>';
			htmls += '          '+result.rank;
			htmls += '          <span>위</span>';
			htmls += '        </p>';
			htmls += '      </div>';
			htmls += '    </div>';
			
			
			
			
			htmls += '    <div class="contents income">';
			htmls += '      <h2>연봉 평균 통계</h2>';
			htmls += '      <h6>만원/단위</h6>';
			htmls += '      <table cellspacing="0" cellpadding="0" class="income_table">';
			var list = result.list;
			var list_length = Object.keys(list).length;
			var i = 0;
			for(i=0;i<list_length;i++) {
				var idata = list[i];
				htmls += '        <tr class="income_table_b_0">';
				htmls += '          <th style="width:150px;border-top:1px solid #777777;">';
				if(idata.positions == 1) htmls += '	  		사원-대졸';
				if(idata.positions == 2) htmls += '	  		사원-전문대졸';
				if(idata.positions == 3) htmls += '	  		사원-고졸';
				if(idata.positions == 4) htmls += '	  		주임/계장';
				if(idata.positions == 5) htmls += '	  		대리';
				if(idata.positions == 6) htmls += '	  		과장';
				if(idata.positions == 7) htmls += '	  		차장';
				if(idata.positions == 8) htmls += '	  		부장';
				if(idata.positions == 9) htmls += '	  		이사';
				if(idata.positions == 10) htmls += '	  	기타';
				htmls += '	  		<br />';
				htmls += '            <span>'+idata.count+' 연봉정보</span>';
				htmls += '          </th>';
				htmls += '          <td style="border-top:1px solid #777777;">';
				htmls += '            <div class="income_td_l col-sm-1">';
				htmls += '              '+idata.moneys+' 만원';
				htmls += '            </div>';
				htmls += '            <div class="col-sm-8 col-md-8 col-lg-9">';
				htmls += '              <div class="income_bar_bg1"><div class="income_bar_bg2"><div class="income_bar_bg3">';
				htmls += '                <div class="income_bar" style="width:'+idata.barline+'%;"><div></div></div>';
				htmls += '              </div></div></div>';
				htmls += '              <div class="income_bar_l">';
				htmls += '                '+result.mins;
				htmls += '              </div>';
				htmls += '              <div class="income_bar_r">';
				htmls += '                '+result.maxs;
				htmls += '              </div>';
				htmls += '            </div>';
				htmls += '          </td>';
				htmls += '        </tr>';
			}
			htmls += '      </table>';
			htmls += '    </div>';
			    
			htmls += '    </div>';
			htmls += '    <div class="col-sm-1 col-md-2 col-lg-2"></div>';
			htmls += '  </div>';
			htmls += '</div>';

			document.getElementById('interview_all').style.display='none';
			document.getElementById('hitcount_bg').style.display='none';
			document.getElementById("view_contents2").innerHTML = "";
			document.getElementById("view_contents").innerHTML = htmls;
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//연봉 작성하기
function income_post_ajax(forms, member_no) {
	//유효성검사 통과시에만 실행
	if(income_write_submit(forms) == true) {
		$.ajax({
			url:'income_write_post_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				member_no:member_no,
				prof:forms.prof.value,
				positions:forms.positions.value,
				empl:forms.empl.value,
				money:forms.money.value
			},
			success:function(result){
				if(result.result != true) {
					alert(result.msg);
				}else{
					income_ajax(member_no);
					alert('작성완료');
					document.body.style.overflow = 'scroll';
					view_menu_count_ajax(member_no);
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}

var datas1 = 0;
var datas2 = 0;
var datas3 = 0;

var datas_r1 = 0;
var datas_r2 = 0;
var datas_r3 = 0;
//면접
function interview_ajax(pages_r, member_no) {
	$.ajax({
		url:'interview_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			pages_r:pages_r,
			member_no:member_no
		},
		success:function(result){
			var htmls = "";
			htmls += '<div class="write_hide" id="interview_write" style="display:none;">';
			htmls += '<div class="write_hide_scroll">';
			htmls += '    <form id="interview_forms">';
			htmls += '    <div class="write_hide_scroll2">';
			htmls += '    <div class="review_write_box">';
			htmls += '      <h1>면접후기 작성</h1>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	직종<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="prof" class="join_select" onchange="itw_prof_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">IT/인터넷</option>';
			htmls += '	  			<option value="2" >경영/기획/컨설팅</option>';
			htmls += '	  			<option value="3" >교육</option>';
			htmls += '	  			<option value="4" >금융/재무</option>';
			htmls += '	  			<option value="5" >디자인</option>';
			htmls += '	  			<option value="6" >마케팅/시장조사</option>';
			htmls += '	  			<option value="7" >미디어/홍보</option>';
			htmls += '	  			<option value="8" >법률/법무</option>';
			htmls += '	  			<option value="9" >생산/제조</option>';
			htmls += '	  			<option value="10" >기타</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="itw_prof_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	직급<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="positions" class="join_select" onchange="itw_positions_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">사원-대졸</option>';
			htmls += '	  			<option value="2">사원-전문대졸</option>';
			htmls += '	  			<option value="3">사원-고졸</option>';
			htmls += '	  			<option value="4">주임/계장</option>';
			htmls += '	  			<option value="5">대리</option>';
			htmls += '	  			<option value="6">과장</option>';
			htmls += '	  			<option value="7">차장</option>';
			htmls += '	  			<option value="8">부장</option>';
			htmls += '	  			<option value="9">이사</option>';
			htmls += '	  			<option value="10">기타</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="itw_positions_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	면접난이도<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	      	<ul class="interview_write_bar">';
			htmls += '			  <li class="interview_bk_0" id="itw_difficulty_1"><a href="#100" onclick="itw_difficulty_btn(1,\'itw_difficulty_\',\'itw_difficulty\',\'itw_difficulty_msg\');"></a></li>';
			htmls += '			  <li class="interview_bk_0" id="itw_difficulty_2"><a href="#100" onclick="itw_difficulty_btn(2,\'itw_difficulty_\',\'itw_difficulty\',\'itw_difficulty_msg\');"></a></li>';
			htmls += '			  <li class="interview_bk_0" id="itw_difficulty_3"><a href="#100" onclick="itw_difficulty_btn(3,\'itw_difficulty_\',\'itw_difficulty\',\'itw_difficulty_msg\');"></a></li>';
			htmls += '			  <li class="interview_bk_0" id="itw_difficulty_4"><a href="#100" onclick="itw_difficulty_btn(4,\'itw_difficulty_\',\'itw_difficulty\',\'itw_difficulty_msg\');"></a></li>';
			htmls += '			  <li class="interview_bk_0" id="itw_difficulty_5"><a href="#100" onclick="itw_difficulty_btn(5,\'itw_difficulty_\',\'itw_difficulty\',\'itw_difficulty_msg\');"></a></li>';
			htmls += '		    </ul>';
			htmls += '		    <input type="hidden" name="difficulty" id="itw_difficulty" value="-1" onchange="itw_difficulty_check(this);" />';
			htmls += '  			<span id="itw_difficulty_msg">선택해주세요.</span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	면접일자<br />';
			htmls += '	    	<span>(0000-00)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <input type="text" name="interviewdate" placeholder="면접일자(0000-00)" class="login_input" onchange="itw_interviewdate_check(this);" />';
			htmls += '  			<span id="itw_interviewdate_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	면접경로<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="interviewdir" class="join_select" onchange="itw_interviewdir_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">온라인 지원</option>';
			htmls += '	  			<option value="2">직원추천</option>';
			htmls += '	  			<option value="3">헤드헌터</option>';
			htmls += '	  			<option value="4">공개채용</option>';
			htmls += '	  			<option value="5">학교 취업지원 센터</option>';
			htmls += '	  			<option value="6">기타</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="itw_interviewdir_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	면접에서 채용까지의 과정 요약';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <textarea rows="100" cols="100" class="edit_textarea" name="memo1" onchange="itw_memo1_check(this);" placeholder="최대한 자세하게 작성해주세요. 최초 연락부터 인터뷰 횟수, 분위기, 면접관의 특징, 면접 팁 등"></textarea>';
			htmls += '	      	<span id="itw_memo1_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	면접질문 입력하기';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <textarea rows="100" cols="100" class="edit_textarea" name="memo2" onchange="itw_memo2_check(this);" placeholder="조별 주제, 개별 과제, 대면 질문 등 가장 어려웠던 질문을 정확하고 구체적으로 작성해 주세요."></textarea>';
			htmls += '	      	<span id="itw_memo2_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	작성한 면접질문에 대한 답변을 입력하세요.';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <textarea rows="100" cols="100" class="edit_textarea" name="memo3" onchange="itw_memo3_check(this);" placeholder="작성한 면접질문에 대한 답변을 입력하세요."></textarea>';
			htmls += '	      	<span id="itw_memo3_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	채용방식';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <input type="text" name="memo4" placeholder="예) 필기시험, 논술 시험, PT면접, 그룹면접, 토론면접, 개인면접, 산행, 체육대회" class="login_input" onchange="itw_memo4_check(this);" />';
			htmls += '  			<span id="itw_memo4_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	발표시기';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <input type="text" name="memo5" placeholder="예) 10일 후, 일주일 후" class="login_input" onchange="itw_memo5_check(this);" />';
			htmls += '  			<span id="itw_memo5_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	이 기업에 합격하셨나요?<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="interviewresult" class="join_select" onchange="itw_interviewresult_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">합격</option>';
			htmls += '	  			<option value="2">불합격</option>';
			htmls += '	  			<option value="3">대기중</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="itw_interviewresult_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';
			htmls += '      <div class="review_write_box_line">';
			htmls += '	      <div>';
			htmls += '	    	면접경험<br />';
			htmls += '	    	<span>(선택)</span>';
			htmls += '	      </div>';
			htmls += '	      <p>';
			htmls += '	        <select name="interviewex" class="join_select" onchange="itw_interviewex_check(this);">';
			htmls += '	  			<option value="-1">선택</option>';
			htmls += '	  			<option value="1">긍정적</option>';
			htmls += '	  			<option value="2">보통</option>';
			htmls += '	  			<option value="3">부정적</option>';
			htmls += '  			</select>';
			htmls += '  			<span id="itw_interviewex_msg"></span>';
			htmls += '	      </p>';
			htmls += '      </div>';

			htmls += '      <div class="review_write_box_line align-center">';
			htmls += '	      <input type="button" value="닫기" onclick="hide2(\'interview_write\');document.body.style.overflow = \'scroll\';" class="review_write_btn2" />';
			htmls += '	      <input type="button" value="제출하기" class="review_write_btn1" onclick="interview_post_ajax(document.getElementById(\'interview_forms\'),'+member_no+')" />';
			htmls += '      </div>';
			htmls += '    </div>';
			htmls += '    </div>';
			htmls += '    </form>';

			htmls += '</div>';
			htmls += '</div>';
			
			
			htmls += ' <div class="container">';
			htmls += '  <div class="row">';
			htmls += '    <div class="col-sm-1"></div>';
			htmls += '    <div class="col-sm-10">';
			
			
			htmls += '    <div class="review_write log_1" ';
			if(result.memberInfo == null || (result.memberInfo != null && result.memberInfo.orders != 1)) {
				htmls += ' style="display:none;" ';
			}
			htmls += ' id="interview_write_btn_bg">';
				htmls += '    	<a href="#100" onclick="show2(\'interview_write\');document.body.style.overflow = \'hidden\';">새로운 면접후기 작성하기</a>';
				htmls += '    </div>';
			
			htmls += '    <div class="income_header" style="margin-bottom:0px;border-bottom:1px solid #e6e6e6;">';
			htmls += '      <div class="income_header_l">';
			htmls += '        <h5>면접 난이도</h5>';
			htmls += '        <div class="interview_bar_bg">';
			htmls += '          <h1>'+result.difficulty+'</h1>';
			htmls += '          <span>'+result.difficultys+'</span>';
			htmls += '          <div class="interview_bar">';
			htmls += '            <div class="income_bar_l" style="color:#0f7ccf;">쉬움</div>';
			htmls += '            <div class="income_bar_r" style="color:#fd4a12;">어려움</div>';
			htmls += '            <div class="income_bar_bg1" style="overflow:hidden;"><div class="income_bar_bg2"><div class="income_bar_bg3">';
			htmls += '              <div class="income_bar" style="width:'+result.difficultybar+'%;"><div></div></div>';
			htmls += '            </div></div></div>';
			htmls += '            <div class="income_bar_l" style="color:#0f7ccf;">0</div>';
			htmls += '            <div class="income_bar_r" style="color:#fd4a12;">5</div>';
			htmls += '          </div>';
			htmls += '        </div>';
			htmls += '      </div>';
			htmls += '      <div class="income_header_r">';
			htmls += '        <h5>면접경로</h5>';
			htmls += '        <div class="interview_table">';
			htmls += '          <table cellspacing="0" cellpadding="0">';
			htmls += '            <tr>';
			htmls += '              <th>온라인 지원</th>';
			htmls += '              <td>'+result.dirs1+'%</td>';
			htmls += '              <th>직원추천</th>';
			htmls += '              <td>'+result.dirs2+'%</td>';
			htmls += '            </tr>';
			htmls += '            <tr>';
			htmls += '              <th>헤드헌터</th>';
			htmls += '              <td>'+result.dirs3+'%</td>';
			htmls += '              <th>공개채용</th>';
			htmls += '              <td>'+result.dirs4+'%</td>';
			htmls += '            </tr>';
			htmls += '            <tr>';
			htmls += '              <th>학교 취업지원 센터</th>';
			htmls += '              <td>'+result.dirs5+'%</td>';
			htmls += '              <th>기타</th>';
			htmls += '              <td>'+result.dirs6+'%</td>';
			htmls += '            </tr>';
			htmls += '          </table>';
			htmls += '        </div>';
			htmls += '      </div>';
			htmls += '    </div>';
			
			htmls += '    </div>';
			htmls += '    <div class="col-sm-1"></div>';
			htmls += '  </div>';
			htmls += '</div>';

			datas1 = result.ex[0];
			datas2 = result.ex[2];
			datas3 = result.ex[1];

			datas_r1 = result.result[0];
			datas_r2 = result.result[1];
			datas_r3 = result.result[2];
			document.getElementById("interview_all").style.display = "";
			document.getElementById('hitcount_bg').style.display='none';
			drawPieChart_1();
			drawPieChart_2();
			
			document.getElementById("view_contents").innerHTML = htmls;
			htmls = "";
			
			
			htmls += ' <div class="container">';
			htmls += '  <div class="row">';
			htmls += '    <div class="col-sm-1"></div>';
			htmls += '    <div class="col-sm-10">';
			
			
			var list = result.list;
			var list_length = Object.keys(list).length;
			var i = 0;
			for(i=0;i<list_length;i++) {
				var itdata = list[i];
				htmls += '    <div class="contents">';
				htmls += '      <div class="review_header">';
				if(itdata.prof == 1) htmls += '     IT/인터넷';
				if(itdata.prof == 2) htmls += '		경영/기획/컨설팅';
				if(itdata.prof == 3) htmls += '		교육';
				if(itdata.prof == 4) htmls += '		금융/재무';
				if(itdata.prof == 5) htmls += '		디자인';
				if(itdata.prof == 6) htmls += '		마케팅/시장조사';
				if(itdata.prof == 7) htmls += '		미디어/홍보';
				if(itdata.prof == 8) htmls += '		법률/법무';
				if(itdata.prof == 9) htmls += '		생산/제조';
				if(itdata.prof == 10) htmls += '	기타';
				htmls += '         / ';
				if(itdata.positions == 1) htmls += '		사원-대졸';
				if(itdata.positions == 2) htmls += '		사원-전문대졸';
				if(itdata.positions == 3) htmls += '		사원-고졸';
				if(itdata.positions == 4) htmls += '		주임/계장';
				if(itdata.positions == 5) htmls += '		대리';
				if(itdata.positions == 6) htmls += '		과장';
				if(itdata.positions == 7) htmls += '		차장';
				if(itdata.positions == 8) htmls += '		부장';
				if(itdata.positions == 9) htmls += '		이사';
				if(itdata.positions == 10) htmls += '		기타';
				htmls += '        | ';
				htmls += '        '+itdata.dates;
				htmls += '      </div>';
				htmls += '      <div class="container">';
				htmls += '        <div class="row">';
				htmls += '          <div class="interview_l col-sm-2 col-md-2">';
				htmls += '            <div class="interview_l_list">';
				htmls += '              <div>';
				htmls += '                <h5>면접난이도</h5>';
				htmls += '                <h6>';
				if(itdata.difficulty == 1) htmls += '매우쉬움';
				if(itdata.difficulty == 2) htmls += '쉬움';
				if(itdata.difficulty == 3) htmls += '보통';
				if(itdata.difficulty == 4) htmls += '어려움';
				if(itdata.difficulty == 5) htmls += '매우어려움';
				htmls += '                </h6>';
				htmls += '                <ul>';
				var j = 0;
				for(j=1;j<=itdata.difficulty;j++) {
					htmls += '                  <li class="interview_bk_'+j+'"></li>';
				}
				for(j=1;j<=(5-itdata.difficulty);j++) {
					htmls += '                  <li class="interview_bk_0"></li>';
				}
				htmls += '                </ul>';
				htmls += '              </div>';
				htmls += '              <div class="hidden-xs" style="margin-top:20px;"></div>';
				htmls += '              <div>';
				htmls += '                <h5>면접일자</h5>';
				htmls += '                <h6>'+itdata.interviewdate+'</h6>';
				htmls += '              </div>';
				htmls += '              <div class="hidden-xs" style="margin-top:20px;"></div>';
				htmls += '              <div>';
				htmls += '                <h5>면접경로</h5>';
				htmls += '                <h6>';
				if(itdata.interviewdir == 1) htmls += '                	온라인 지원';
				if(itdata.interviewdir == 2) htmls += '					직원추천';
				if(itdata.interviewdir == 3) htmls += '					헤드헌터';
				if(itdata.interviewdir == 4) htmls += '					공개채용';
				if(itdata.interviewdir == 5) htmls += '					학교 취업지원 센터';
				if(itdata.interviewdir == 6) htmls += '					기타';
				htmls += '                </h6>';
				htmls += '              </div>';
				htmls += '            </div>';
				htmls += '          </div>';
				htmls += '          <div class="review_r col-sm-6 col-md-7">';
				htmls += '            <h3>"'+itdata.memo1+'"</h3>';
				htmls += '            <h5>면접질문</h5>';
				htmls += '            <p>'+itdata.memo2+'</p>';
				htmls += '            <h5>면접답변</h5>';
				htmls += '            <p>'+itdata.memo3+'</p>';
				htmls += '            <h5>채용방식</h5>';
				htmls += '            <p>'+itdata.memo4+'</p>';
				htmls += '            <h5>발표시기</h5>';
				htmls += '            <p>'+itdata.memo5+'</p>';
				htmls += '            <table cellspacing="0" cellpadding="0" class="interview_b_table">';
				htmls += '              <tr>';
				htmls += '                <th>면접결과</th>';
				htmls += '                <td>';
				if(itdata.interviewresult == 1) htmls += '	                <img src="./images/interview_l_1.jpg" alt="img" /> 합격';
				if(itdata.interviewresult == 2) htmls += '					<img src="./images/interview_l_2.jpg" alt="img" /> 불합격';
				if(itdata.interviewresult == 3) htmls += '					<img src="./images/interview_l_3.jpg" alt="img" /> 대기중';
				htmls += '                </td>';
				htmls += '                <th>면접경험</th>';
				htmls += '                <td>';
				if(itdata.interviewex == 1) htmls += '	                <img src="./images/interview_r_1.jpg" alt="img" /> 긍정적';
				if(itdata.interviewex == 2) htmls += '					<img src="./images/interview_r_3.jpg" alt="img" /> 보통';
				if(itdata.interviewex == 3) htmls += '					<img src="./images/interview_r_2.jpg" alt="img" /> 부정적';
				htmls += '                </td>';
				htmls += '              </tr>';
				htmls += '            </table>';
				htmls += '          </div>';
				htmls += '        </div>';
				htmls += '      </div>';
				htmls += '    </div>';
			}
			
			var paging = result.paging;
			htmls += '      <div class="paging">';
			htmls += '        <a href="#100" onclick="interview_ajax(1,'+member_no+');" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>';
			var j = 0;
			for(j=paging.pstarts;j<=paging.pends;j++) {
				htmls += '        	<a href="#100" onclick="interview_ajax('+j+','+member_no+');"';
				if(j == pages_r) 	htmls += ' class="paging_a_hover"> ';
				else 				htmls += ' class="paging_a"> ';
				htmls += '        		'+j;
				htmls += '        	</a>';
			}
			htmls += '        <a href="#100" onclick="interview_ajax('+paging.board_paging+','+member_no+');" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>';
			htmls += '      </div>';
			
			
			htmls += '    </div>';
			htmls += '    <div class="col-sm-1"></div>';
			htmls += '  </div>';
			htmls += '</div>';
			
			document.getElementById("view_contents2").innerHTML = htmls;
			
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//면접 작성하기
function interview_post_ajax(forms, member_no) {
	//유효성검사 통과시에만 실행
	if(interview_write_submit(forms) == true) {
		$.ajax({
			url:'interview_write_post_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				member_no:member_no,
				prof:forms.prof.value,
				positions:forms.positions.value,
				difficulty:forms.difficulty.value,
				interviewdate:forms.interviewdate.value,
				interviewdir:forms.interviewdir.value,
				memo1:forms.memo1.value,
				memo2:forms.memo2.value,
				memo3:forms.memo3.value,
				memo4:forms.memo4.value,
				memo5:forms.memo5.value,
				interviewresult:forms.interviewresult.value,
				interviewex:forms.interviewex.value
			},
			success:function(result){
				if(result.result != true) {
					alert(result.msg);
				}else{
					interview_ajax(1,member_no);
					alert('작성완료');
					document.body.style.overflow = 'scroll';
					view_menu_count_ajax(member_no);
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}
//채용
function recruit_ajax(pages_r, member_no, status) {
	$.ajax({
		url:'recruit_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			member_no:member_no,
			pages_r:pages_r,
			status:status
		},
		success:function(result){
			var htmls = "";
			
				htmls += '	<div class="write_hide" id="recruit_write" style="display:none;">	';
				htmls += '	<div class="write_hide_scroll">	';
				htmls += '	<form id="recruit_write_forms">	';
				htmls += '	<div class="write_hide_scroll2">	';
				htmls += '	<div class="review_write_box">	';
				htmls += '	<h1 id="rc_h">채용정보 작성</h1>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	채용 제목	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="subject" placeholder="채용 제목" class="login_input" onchange="rc_subject_check(this);" />	';
				htmls += '	<span id="rc_subject_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	마감일<br />	';
				htmls += '	<span>날짜입력</span>	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="enddates" placeholder="예) 2000-00-00" class="login_input" onchange="rc_enddates_check(this);" />	';
				htmls += '	<span id="rc_enddates_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	키워드<br />	';
				htmls += '	<span>쉼표(,)로 구분</span>	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="keyword" placeholder="예) SW엔지니어,웹개발,서울,정규직" class="login_input" onchange="rc_keyword_check(this);" />	';
				htmls += '	<span id="rc_keyword_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '		';
				htmls += '		';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	기업소개	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo1" id="memo1" onchange="rc_memo1_check(this);" style="height:300px;" placeholder="예) 코인 전문 암호화폐 거래소 00000 입니다. "></textarea>	';
				htmls += '	<span id="rc_memo1_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	주요업무	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo2" onchange="rc_memo2_check(this);" style="height:300px;" placeholder="예) 백엔드개발. "></textarea>	';
				htmls += '	<span id="rc_memo2_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	자격요건	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo3" onchange="rc_memo3_check(this);" style="height:300px;" placeholder="핵심 직무 역량과 우대 사항 입력 "></textarea>	';
				htmls += '	<span id="rc_memo3_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	채용절차	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo4" onchange="rc_memo4_check(this);" style="height:300px;" placeholder="예) 서류전형 - 임원면접 - 합격통보 "></textarea>	';
				htmls += '	<span id="rc_memo4_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	복리후생	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo5" onchange="rc_memo5_check(this);" style="height:300px;" placeholder="혜택 및 복지 "></textarea>	';
				htmls += '	<span id="rc_memo5_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '		';
				htmls += '		';
				htmls += '		';
				htmls += '		';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	문의처<br />	';
				htmls += '	<span>쉼표(,)로 구분</span>	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="contact" placeholder="예) 00000@naver.com,02-000-0000,http://naver.com/" class="login_input" onchange="rc_contact_check(this);" />	';
				htmls += '	<span id="rc_contact_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	직종	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="prof" placeholder="예) SW엔지니어,시스템엔지니어,웹개발" class="login_input" onchange="rc_prof_check(this);" />	';
				htmls += '	<span id="rc_prof_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	고용형태	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="empl" placeholder="예) 정규직" class="login_input" onchange="rc_empl_check(this);" />	';
				htmls += '	<span id="rc_empl_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	최종 학력	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="grade" placeholder="예) 해당없음 고졸이상 대졸이상" class="login_input" onchange="rc_grade_check(this);" />	';
				htmls += '	<span id="rc_grade_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	급여	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="money" placeholder="예) 연봉(최소 3,000만원 ~ 최대 5,000만원)" class="login_input" onchange="rc_money_check(this);" />	';
				htmls += '	<span id="rc_money_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	직급	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="positions1" placeholder="예) 사원 주임 대리" class="login_input" onchange="rc_positions1_check(this);" />	';
				htmls += '	<span id="rc_positions1_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	직책	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="positions2" placeholder="예) 팀장 실장 팀장급" class="login_input" onchange="rc_positions2_check(this);" />	';
				htmls += '	<span id="rc_positions2_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '		';
				htmls += '	<div class="review_write_box_line align-center">	';
				htmls += '	<input type="button" value="닫기" onclick="hide2(\'recruit_write\');document.body.style.overflow = \'scroll\';" class="review_write_btn2" />	';
				htmls += '	<input type="button" value="제출하기" class="review_write_btn1" onclick="recruit_post_ajax(document.getElementById(\'recruit_write_forms\'),'+member_no+');" />	';
				htmls += '	</div>	';
				htmls += '	</div>	';
				htmls += '	</div>	';
				htmls += '	</form> 	';
				htmls += '	</div>	';
				htmls += '	</div>	';
			
			
			
			
			
			
			
			htmls += '	<div class="container">	';
			htmls += '	<div class="row">	';
			htmls += '	<div class="col-sm-1 col-md-2 col-lg-2"></div>	';
			htmls += '	<div class="col-sm-10 col-md-8 col-lg-8">	';
			htmls += '		';
			
			
			htmls += '    <div class="review_write log_same" ';
			if(result.memberInfo == null || (result.memberInfo != null && result.memberInfo.no != member_no)) {
				htmls += ' style="display:none;" ';
			}
			htmls += ' id="recruit_write_btn_bg">';
				htmls += '	<a href="#100" onclick="show2(\'recruit_write\');document.body.style.overflow = \'hidden\';">새로운 채용정보 작성하기</a>	';
				htmls += '	</div>	';
			
			
			
			htmls += '	<ul class="recruit_tab">	';
			htmls += '		<li><a href="#100" onclick="recruit_ajax(1,'+member_no+',1);" ';
			if(status == 1) htmls += ' 			class="recruit_tab_li_a_hover"';
			else			htmls += ' 			class="recruit_tab_li_a"';
			htmls += '			>진행중</a></li>	';
			htmls += '		<li><a href="#100" onclick="recruit_ajax(1,'+member_no+',2);" ';
			if(status == 2) htmls += ' 			class="recruit_tab_li_a_hover"';
			else			htmls += ' 			class="recruit_tab_li_a"';
			htmls += '			>마감</a></li>	';
			htmls += '	</ul>	';
			
			
			
			
			htmls += '		';
			htmls += '	<div class="recruit_list">	';
			htmls += '	<ul>	';
			
			var list = result.list;
			var list_length = Object.keys(list).length;
			
			var i = 0;
			for(i=0;i<list_length;i++) {
				var rcdatas = list[i];
				htmls += '	<li>	';
				htmls += '	<a href="#100" onclick="recruit_view_ajax('+pages_r+','+rcdatas.no+','+member_no+','+status+');">	';
				
				
				if(rcdatas.status == 1) htmls += '	<div class="recruit_list_dday">D-'+rcdatas.dday+'</div>	';
				else htmls += '	<div class="recruit_list_dday">마감</div>	';
				
				htmls += '	<h4>'+rcdatas.subject+'</h4>	';
				htmls += '	<p>'+rcdatas.prof+'</p>	';
				htmls += '	<div class="recruit_list_keywords">	';
				
				var k_list = rcdatas.keywords;
				var k_list_length = Object.keys(k_list).length;
				
				var k = 0;
				for(k=0;k<k_list_length;k++) {
					var kw = k_list[k];
					htmls += '	<div>'+kw+'</div>	';
				}
				htmls += '	</div>	';
				htmls += '	</a>	';
				htmls += '	</li>	';
			}
			htmls += '	</ul>	';
			htmls += '	</div>	';
			
			
			htmls += '	<div class="paging">	';
			htmls += '	<a href="#100" onclick="recruit_ajax(1,'+member_no+','+status+');" style="color:#d0d0d0;" class="paging_radius_l">&lt;</a>	';
			var j = 0;
			for(j=result.paging.pstarts;j<=result.paging.pends;j++) {
				htmls += '	<a href="#100"  onclick="recruit_ajax('+j+','+member_no+','+status+');" ';
				if(j == pages_r) 	htmls += ' class="paging_a_hover"> ';
				else 				htmls += ' class="paging_a"> ';
				htmls += '		'+j;
				htmls += '	</a>	';
			}
			htmls += '	<a href="#100" onclick="recruit_ajax('+result.paging.board_paging+','+member_no+','+status+');" style="color:#d0d0d0;" class="paging_radius_r">&gt;</a>	';
			htmls += '	</div>	';
			htmls += '		';
			htmls += '	</div>	';
			htmls += '	<div class="col-sm-1 col-md-2 col-lg-2"></div>	';
			htmls += '	</div>	';
			htmls += '	</div>	';


			document.getElementById('interview_all').style.display='none';
			document.getElementById('hitcount_bg').style.display='none';
			document.getElementById("view_contents2").innerHTML = "";
			document.getElementById("view_contents").innerHTML = htmls;
			
			
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//채용 작성하기
function recruit_post_ajax(forms, member_no) {
	//유효성검사 통과시에만 실행
	if(recruit_write_submit(forms) == true) {
		$.ajax({
			url:'recruit_write_post_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				member_no:member_no,
				subject:forms.subject.value,
				enddates:forms.enddates.value,
				keyword:forms.keyword.value,
				memo1:forms.memo1.value,
				memo2:forms.memo2.value,
				memo3:forms.memo3.value,
				memo4:forms.memo4.value,
				memo5:forms.memo5.value,
				contact:forms.contact.value,
				prof:forms.prof.value,
				empl:forms.empl.value,
				grade:forms.grade.value,
				money:forms.money.value,
				positions1:forms.positions1.value,
				positions2:forms.positions2.value
			},
			success:function(result){
				if(result.result != true) {
					alert(result.msg);
				}else{
					recruit_ajax(1,member_no,1);
					alert('작성완료');
					document.body.style.overflow = 'scroll';
					view_menu_count_ajax(member_no);
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}
//채용 보기
function recruit_view_ajax(pages_r,recruit_no,member_no,status) {
	$.ajax({
		url:'recruit_view_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			member_no:member_no,
			recruit_no:recruit_no
		},
		success:function(result){
			var htmls = "";
			
				var rcdata = result.rcdata;
				htmls += '	<!-- 수정 -->	';
				htmls += '	<div class="write_hide" id="recruit_edit" style="display:none;">	';
				htmls += '	<div class="write_hide_scroll">	';
				htmls += '	<form id="recruit_edit_forms">	';
				htmls += '	<div class="write_hide_scroll2">	';
				htmls += '	<div class="review_write_box">	';
				htmls += '	<h1>채용정보 수정</h1>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	채용 제목	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="subject" placeholder="채용 제목" class="login_input" onchange="rc2_subject_check(this);" value="'+rcdata.subject+'" />	';
				htmls += '	<span id="rc2_subject_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	마감일<br />	';
				htmls += '	<span>날짜입력</span>	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="enddates" placeholder="예) 2000-00-00" class="login_input" onchange="rc2_enddates_check(this);" value="'+rcdata.enddates+'" />	';
				htmls += '	<span id="rc2_enddates_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	키워드<br />	';
				htmls += '	<span>쉼표(,)로 구분</span>	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="keyword" placeholder="예) SW엔지니어,웹개발,서울,정규직" class="login_input" onchange="rc2_keyword_check(this);" value="'+rcdata.keyword+'" />	';
				htmls += '	<span id="rc2_keyword_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '		';
				htmls += '		';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	기업소개	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo1" id="memo1" onchange="rc2_memo1_check(this);" style="height:300px;" placeholder="예) 코인 전문 암호화폐 거래소 00000 입니다. ">'+rcdata.memo1+'</textarea>	';
				htmls += '	<span id="rc2_memo1_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	주요업무	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo2" onchange="rc2_memo2_check(this);" style="height:300px;" placeholder="예) 백엔드개발. ">'+rcdata.memo2+'</textarea>	';
				htmls += '	<span id="rc2_memo2_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	자격요건	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo3" onchange="rc2_memo3_check(this);" style="height:300px;" placeholder="핵심 직무 역량과 우대 사항 입력 ">'+rcdata.memo3+'</textarea>	';
				htmls += '	<span id="rc2_memo3_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	채용절차	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo4" onchange="rc2_memo4_check(this);" style="height:300px;" placeholder="예) 서류전형 - 임원면접 - 합격통보 ">'+rcdata.memo4+'</textarea>	';
				htmls += '	<span id="rc2_memo4_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	복리후생	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<textarea rows="100" cols="100" class="edit_textarea" name="memo5" onchange="rc2_memo5_check(this);" style="height:300px;" placeholder="혜택 및 복지 ">'+rcdata.memo5+'</textarea>	';
				htmls += '	<span id="rc2_memo5_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '		';
				htmls += '		';
				htmls += '		';
				htmls += '		';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	문의처<br />	';
				htmls += '	<span>쉼표(,)로 구분</span>	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="contact" placeholder="예) 00000@naver.com,02-000-0000,http://naver.com/" class="login_input" onchange="rc2_contact_check(this);" value="'+rcdata.contact+'" />	';
				htmls += '	<span id="rc2_contact_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	직종	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="prof" placeholder="예) SW엔지니어,시스템엔지니어,웹개발" class="login_input" onchange="rc2_prof_check(this);" value="'+rcdata.prof+'" />	';
				htmls += '	<span id="rc2_prof_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	고용형태	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="empl" placeholder="예) 정규직" class="login_input" onchange="rc2_empl_check(this);" value="'+rcdata.empl+'" />	';
				htmls += '	<span id="rc2_empl_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	최종 학력	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="grade" placeholder="예) 해당없음 고졸이상 대졸이상" class="login_input" onchange="rc2_grade_check(this);" value="'+rcdata.grade+'" />	';
				htmls += '	<span id="rc2_grade_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	급여	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="money" placeholder="예) 연봉(최소 3,000만원 ~ 최대 5,000만원)" class="login_input" onchange="rc2_money_check(this);" value="'+rcdata.money+'" />	';
				htmls += '	<span id="rc2_money_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	직급	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="positions1" placeholder="예) 사원 주임 대리" class="login_input" onchange="rc2_positions1_check(this);" value="'+rcdata.positions1+'" />	';
				htmls += '	<span id="rc2_positions1_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '	<div class="review_write_box_line">	';
				htmls += '	<div>	';
				htmls += '	직책	';
				htmls += '	</div>	';
				htmls += '	<p>	';
				htmls += '	<input type="text" name="positions2" placeholder="예) 팀장 실장 팀장급" class="login_input" onchange="rc2_positions2_check(this);" value="'+rcdata.positions2+'" />	';
				htmls += '	<span id="rc2_positions2_msg"></span>	';
				htmls += '	</p>	';
				htmls += '	</div>	';
				htmls += '		';
				htmls += '	<div class="review_write_box_line align-center">	';
				htmls += '	<input type="button" value="닫기" onclick="hide2(\'recruit_edit\');document.body.style.overflow = \'scroll\';" class="review_write_btn2" />	';
				htmls += '	<input type="button" value="수정하기" class="review_write_btn1" onclick="recruit_edit_post_ajax(document.getElementById(\'recruit_edit_forms\'),'+recruit_no+','+pages_r+','+member_no+','+status+');" />	';
				htmls += '	</div>	';
				htmls += '	</div>	';
				htmls += '	</div>	';
				htmls += '	</form>	';
				htmls += '	</div>	';
				htmls += '	</div>	';
				htmls += '		';

			
			
			
			
			
			htmls += '	<!--입사지원-->	';
			htmls += '	<div class="write_hide" id="recruit_add" style="display:none;">	';
			htmls += '	<div class="write_hide_scroll">	';
			htmls += '	<form id="recruit_add_forms" enctype="multipart/form-data" method="POST">	';
			htmls += '	<input type="hidden" name="member_no" value="'+member_no+'" />';
			htmls += '	<input type="hidden" name="recruit_no" value="'+recruit_no+'" />';
			htmls += '	<div class="write_hide_scroll2s">	';
			htmls += '	<div class="review_write_box">	';
			htmls += '	<h1 id="rc_h">지원서 작성</h1>	';
			htmls += '	<div class="recruit_add_box_line">	';
			htmls += '	<h4>	';
			htmls += '	이름	';
			htmls += '	</h4>	';
			htmls += '	<div class="recruit_phone">	';
			htmls += '	<input type="text" name="name" placeholder="이름을 입력해주세요." class="login_input" onchange="rca_name_check(this);" />	';
			htmls += '	</div>	';
			htmls += '	<p id="rca_name_msg" class="join_msg"></p>	';
			htmls += '	</div>	';
			htmls += '	<div class="recruit_add_box_line">	';
			htmls += '	<h4>	';
			htmls += '	연락처	';
			htmls += '	</h4>	';
			htmls += '	<div class="recruit_phone">	';
			htmls += '	<input type="text" name="phone1" placeholder="010" class="login_input" style="padding-left:3px;width:25%;float:left;" onchange="rca_phone1_check(this);" />	';
			htmls += '	<div>-</div>	';
			htmls += '	<input type="text" name="phone2" placeholder="0000" class="login_input" style="padding-left:3px;width:25%;float:left;" onchange="rca_phone2_check(this);" />	';
			htmls += '	<div>-</div>	';
			htmls += '	<input type="text" name="phone3" placeholder="0000" class="login_input" style="padding-left:3px;width:25%;float:left;" onchange="rca_phone3_check(this);" />	';
			htmls += '	</div>	';
			htmls += '	<p id="rca_phone_msg" class="join_msg"></p>	';
			htmls += '	</div>	';
			htmls += '	<div class="recruit_add_box_line">	';
			htmls += '	<h4>	';
			htmls += '	이메일	';
			htmls += '	</h4>	';
			htmls += '	<div class="recruit_phone">	';
			htmls += '	<input type="text" name="email" placeholder="이메일을 입력해주세요." class="login_input" onchange="rca_email_check(this);" />	';
			htmls += '	</div>	';
			htmls += '	<p id="rca_email_msg" class="join_msg"></p>	';
			htmls += '	</div>	';
			

			htmls += '	<div class="recruit_add_box_line">	';
			htmls += '	<h4>	';
			htmls += '	이력서사진	250x300px';
			htmls += '	</h4>	';
			htmls += '	<div class="recruit_phone">	';
			htmls += '	<input type="button" value="이력서사진 첨부하기" class="login_input" id="files3_btn" onclick="open_file2(\'files3\');" />	';
			htmls += '	<input type="file" name="files3" id="files3" class="login_input" onchange="change_file2(\'files3_btn\',this);rca_files3_check(this);" style="display:none;" />	';
			htmls += '	</div>	';
			htmls += '	<p id="rca_files3_msg" class="join_msg"></p>	';
			htmls += '	</div>	';
			
			
			htmls += '	<div class="recruit_add_box_line">	';
			htmls += '	<h4>	';
			htmls += '	이력서	';
			htmls += '	</h4>	';
			htmls += '	<div class="recruit_phone">	';
			htmls += '	<input type="button" value="이력서 첨부하기" class="login_input" id="files1_btn" onclick="open_file2(\'files1\');" />	';
			htmls += '	<input type="file" name="files1" id="files1" class="login_input" onchange="change_file2(\'files1_btn\',this);rca_files1_check(this);" style="display:none;" />	';
			htmls += '	</div>	';
			htmls += '	<p id="rca_files1_msg" class="join_msg"></p>	';
			htmls += '	</div>	';
			
			
			htmls += '	<div class="recruit_add_box_line">	';
			htmls += '	<h4>	';
			htmls += '	첨부파일	';
			htmls += '	</h4>	';
			htmls += '	<div class="recruit_phone">	';
			htmls += '	<input type="button" value="자격증사본,증명서 등 첨부하기" class="login_input" id="files2_btn" onclick="open_file2(\'files2\');" />	';
			htmls += '	<input type="file" name="files2" id="files2" class="login_input" onchange="change_file2(\'files2_btn\',this);" style="display:none;" />	';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '		';
			htmls += '	<div class="review_write_box_line align-center">	';
			htmls += '	<input type="button" value="닫기" onclick="hide2(\'recruit_add\');document.body.style.overflow = \'scroll\';" class="review_write_btn2" />	';
			htmls += '	<input type="button" value="지원하기" class="review_write_btn1" onclick="recruit_add_post_ajax(document.getElementById(\'recruit_add_forms\'),'+recruit_no+','+pages_r+','+member_no+');" />	';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '	</form> 	';
			htmls += '	</div>	';
			htmls += '	</div>	';

			
			
			htmls += '<div id="recruit_mylist_bg"></div>';
			
			
			
			
			htmls += '	<div class="container">	';
			htmls += '	<div class="row">	';
			htmls += '	<div class="col-sm-1 col-md-2 col-lg-2"></div>	';
			htmls += '	<div class="col-sm-10 col-md-8 col-lg-8">	';


			
			htmls += '		';
			htmls += '    <div class="review_write log_1" ';
			if(result.memberInfo == null || (result.memberInfo != null && result.memberInfo.orders != 1)) {
				htmls += ' style="display:none;" ';
			}else {
				if(rcdata.status != 1) htmls += ' style="display:none;" ';
			}
			htmls += ' id="recruit_add_btn_bg">';
				htmls += '	<a href="#100" onclick="show2(\'recruit_add\');document.body.style.overflow = \'hidden\';" style="background:#219bf0;border:1px solid #219bf0;">지원하기</a>	';
				htmls += '	</div>	';
			
			htmls += '	<div class="recruit_subject" style="line-height:25px;">	';
			htmls += '	<div class="recruit_dates">	';
			
			
			if(rcdata.status == 1) htmls += '	<span>D-'+rcdata.dday+'</span> '+rcdata.dates+' ~ '+rcdata.enddates;
			else htmls += '	<span>마감</span> '+rcdata.dates+' ~ '+rcdata.enddates;
			
			
			htmls += '	&nbsp;&nbsp;	';
			htmls += '	<div>'+rcdata.dates+' 등록</div>	';
			htmls += '	<a href="#100" onclick="recruit_ajax('+pages_r+','+member_no+','+status+')" class="recruit_a">목록보기</a>	';
			
			
			htmls += '    <div class="log_same" style="border:0px;';
			if(result.memberInfo == null || (result.memberInfo != null && result.memberInfo.no != member_no)) {
				htmls += ' display:none;';
			}
			htmls += '" id="recruit_edit_btn_bg">';
			if(rcdata.status == 1) htmls += '	<a href="#100" onclick="show2(\'recruit_edit\');document.body.style.overflow = \'hidden\';" class="recruit_a">수정</a>	';
			htmls += '	<a href="#100" onclick="dialog_del(\'정말로 삭제하시겠습니까?\','+recruit_no+','+pages_r+','+member_no+','+status+');" class="recruit_a">삭제</a>	';
			if(rcdata.status == 1) htmls += '	<a href="#100" onclick="dialog_end(\'정말로 마감하시겠습니까?\','+recruit_no+','+pages_r+','+member_no+','+status+');" class="recruit_a">마감</a>	';
				htmls += '	<a href="#100" onclick="recruit_mylist_ajax(1,'+recruit_no+','+member_no+');show2(\'recruit_mylist\');document.body.style.overflow = \'hidden\';" class="recruit_a" style="background:#219bf0;">지원자리스트</a>	';
				htmls += '</div>';
			
			
			htmls += '	</div>	';
			htmls += '	<h2>'+rcdata.subject+'</h2>	';
			htmls += '	</div>	';
			
			var k_list = result.keyword;
			var k_list_length = Object.keys(k_list).length;
			
			var k = 0;
			htmls += '	<div class="recruit_keyword">	';
			for(k=0;k<k_list_length;k++) {
				var kw = k_list[k];
				htmls += '	<div>'+kw+'</div>	';
			}
			htmls += '	</div>	';
			
			htmls += '	<div class="recruit_body">	';
			htmls += '		';
			htmls += '	<h3>기업 소개</h3>	';
			htmls += '	<p>'+result.memo1+'</p>	';
			htmls += '	<h3>주요 업무</h3>	';
			htmls += '	<p>'+result.memo2+'</p>	';
			htmls += '	<h3>자격 요건</h3>	';
			htmls += '	<p>'+result.memo3+'</p>	';
			htmls += '	<h3>채용절차</h3>	';
			htmls += '	<p>'+result.memo4+'</p>	';
			htmls += '	<h3>복리후생</h3>	';
			htmls += '	<p>'+result.memo5+'</p>	';
			htmls += '	<h3>문의처</h3>	';
			htmls += '	<div class="recruit_contact">	';
			
			var c_list = result.contact;
			var c_list_length = Object.keys(c_list).length;
			
			var c = 0;
			for(c=0;c<c_list_length;c++) {
				var ct = c_list[c]
				htmls += '	<div>'+ct+'</div>	';
			}
			
			htmls += '	</div>	';
			htmls += '	<h3>상세정보</h3>	';
			htmls += '	<table cellspacing="0" cellpadding="0" class="recruit_table">	';
			htmls += '	<col width="50%" />	';
			htmls += '	<col width="50%" />	';
			htmls += '	<tr>	';
			htmls += '	<th>직종</th>	';
			htmls += '	<th>고용형태</th>	';
			htmls += '	</tr>	';
			htmls += '	<td>'+rcdata.prof+'</td>	';
			htmls += '	<td>'+rcdata.empl+'</td>	';
			htmls += '	<tr>	';
			htmls += '	<th>최종 학력</th>	';
			htmls += '	<th>급여</th>	';
			htmls += '	</tr>	';
			htmls += '	<tr>	';
			htmls += '	<td>'+rcdata.grade+'</td>	';
			htmls += '	<td>'+rcdata.money+'</td>	';
			htmls += '	</tr>	';
			htmls += '	<tr>	';
			htmls += '	<th>직급</th>	';
			htmls += '	<th>직책</th>	';
			htmls += '	</tr>	';
			htmls += '	<tr>	';
			htmls += '	<td>'+rcdata.positions1+'</td>	';
			htmls += '	<td>'+rcdata.positions2+'</td>	';
			htmls += '	</tr>	';
			htmls += '	</table>	';
			htmls += '	</div>	';
			htmls += '		';
			htmls += '	</div>	';
			htmls += '	<div class="col-sm-1 col-md-2 col-lg-2"></div>	';
			htmls += '	</div>	';
			htmls += '	</div>	';

			
			
			
			document.getElementById('interview_all').style.display='none';
			document.getElementById('hitcount_bg').style.display='none';
			document.getElementById("view_contents2").innerHTML = "";
			document.getElementById("view_contents").innerHTML = htmls;
			
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//다이어로그
function dialog_end(var1,recruit_no,pages_r,member_no,status) {
	var reVal = confirm(var1);
	if(reVal == true) {
		recruit_end_ajax(recruit_no, pages_r, member_no,status);
	}
}
//채용 삭제
function recruit_end_ajax(recruit_no, pages_r, member_no,status) {
	$.ajax({
		url:'recruit_end_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			member_no:member_no,
			recruit_no:recruit_no
		},
		success:function(result){
			if(result.result != true) {
				alert(result.msg);
			}else{
				recruit_ajax(pages_r,member_no,status);
				alert('마감완료');
				document.body.style.overflow = 'scroll';
			}
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//다이어로그
function dialog_del(var1,recruit_no,pages_r,member_no,status) {
	var reVal = confirm(var1);
	if(reVal == true) {
		recruit_del_ajax(recruit_no, pages_r, member_no,status);
	}
}
//채용 수정완료
function recruit_edit_post_ajax(forms, recruit_no, pages_r, member_no,status) {
	//유효성검사 통과시에만 실행
	if(recruit_edit_submit(forms) == true) {
		$.ajax({
			url:'recruit_edit_post_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				member_no:member_no,
				recruit_no:recruit_no,
				subject:forms.subject.value,
				enddates:forms.enddates.value,
				keyword:forms.keyword.value,
				memo1:forms.memo1.value,
				memo2:forms.memo2.value,
				memo3:forms.memo3.value,
				memo4:forms.memo4.value,
				memo5:forms.memo5.value,
				contact:forms.contact.value,
				prof:forms.prof.value,
				empl:forms.empl.value,
				grade:forms.grade.value,
				money:forms.money.value,
				positions1:forms.positions1.value,
				positions2:forms.positions2.value
			},
			success:function(result){
				if(result.result != true) {
					alert(result.msg);
				}else{
					recruit_view_ajax(pages_r,recruit_no,member_no,status);
					alert('수정완료');
					document.body.style.overflow = 'scroll';
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}
//채용 삭제
function recruit_del_ajax(recruit_no, pages_r, member_no,status) {
	$.ajax({
		url:'recruit_del_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			member_no:member_no,
			recruit_no:recruit_no
		},
		success:function(result){
			if(result.result != true) {
				alert(result.msg);
			}else{
				recruit_ajax(pages_r,member_no,status);
				alert('삭제완료');
				document.body.style.overflow = 'scroll';
			}
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//입사 지원완료
function recruit_add_post_ajax(forms, recruit_no, pages_r, member_no) {
	var formData = new FormData(forms);
	
	//유효성검사 통과시에만 실행
	if(recruit_add_submit(forms) == true) {
		$.ajax({
			url:'recruit_add_post_ajax.o',
			method:'POST',
			data:formData,
			processData: false,
			contentType: false,
			success:function(result){
				if(result.result != true) {
					alert(result.msg);
				}else{
					recruit_view_ajax(pages_r,recruit_no,member_no);
					alert('지원완료');
					document.body.style.overflow = 'scroll';
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}
//회사정보 수정완료
function edit_post_ajax(forms, member_no) {
	var formData = new FormData(forms);
	
	//유효성검사 통과시에만 실행
	if(edit_submit(forms) == true) {
		$.ajax({
			url:'edit_post_ajax.o',
			method:'POST',
			data:formData,
			processData: false,
			contentType: false,
			success:function(result){
				if(result.result != true) {
					alert(result.msg);
				}else{
					alert('수정완료');
					document.body.style.overflow = 'scroll';
					hide2('view_edit_bg');
					view_header_ajax(member_no);
					setmenu(document.getElementById("nav_btn1"));
					view_ajax(member_no);
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}
//회사 헤더 새로고침
function view_header_ajax(member_no) {
	$.ajax({
		url:'view_header_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			member_no:member_no
		},
		success:function(result){
			var htmls = "";
			
			var cdata = result.cdata;
			if(cdata.file2 == "" || cdata.file2 == null) htmls += '	<div class="main_subject_bg" style="background:url(./images/office_bk.jpg) no-repeat center center;">	';
			else htmls += '	<div class="main_subject_bg" style="background:url(./upload/'+cdata.file2+') no-repeat center center">	';
			htmls += '	<div class="main_subject">	';
			htmls += '	<div class="container">	';
			htmls += '	<div class="row">	';
			htmls += '		';
			htmls += '	<div class="col-sm-1"></div>	';
			htmls += '	<div class="col-sm-7">	';
			htmls += '	<p class="m_s_left">	';
			if(cdata.file1 == "" || cdata.file1 == null) htmls += '	<img src="./images/company_logo.jpg" width="100px" height="100px" alt="logo" />	';
			else htmls += '	<img src="./upload/'+cdata.file1+'" width="100px" height="100px" alt="logo" />	';
			htmls += '	</p>	';
			htmls += '	<p class="m_s_right">	';
			htmls += '	<h3>'+cdata.company+'</h3>	';
			if(cdata.company_cate == 1) htmls += '	서비스업	';
			if(cdata.company_cate == 2) htmls += '	제조/화학	';
			if(cdata.company_cate == 3) htmls += '	의료/제약/복지	';
			if(cdata.company_cate == 4) htmls += '	유통/무역/운송	';
			if(cdata.company_cate == 5) htmls += '	교육업	';
			if(cdata.company_cate == 6) htmls += '	건설업	';
			if(cdata.company_cate == 7) htmls += '	IT/웹/통신	';
			if(cdata.company_cate == 8) htmls += '	미디어/디자인	';
			if(cdata.company_cate == 9) htmls += '	은행/금융업	';
			if(cdata.company_cate == 10) htmls += '	기관/협회	';
			htmls += '	<br />	';
			if(result.memberInfo == null) {
				htmls += '	<a href="login.o" class="follow_btn"><img src="./images/heart.jpg" alt="heart" />팔로우</a>	';
			}else {
				htmls += '	<a href="#100" onclick="follow_ajax('+member_no+',\'follow_heart\');" class="follow_btn">	';
				if(cdata.isfollow == -1) htmls += '	<img src="./images/heart.jpg" alt="heart" id="follow_heart" />	';
				else htmls += '	<img src="./images/heart2.jpg" alt="heart" id="follow_heart" />	';
				htmls += '	팔로우	';
				htmls += '	</a>	';
			}
			
			htmls += '	<img src="./images/star.png" alt="star" /> '+cdata.avg_stars;
			htmls += '	<br />	';
			htmls += '	<a href="'+cdata.url+'" class="url_btn">'+cdata.url+'</a>	';
			htmls += '	</p>	';
			htmls += '	</div>	';
			htmls += '	<div class="col-sm-3 cover_img_align">	';
			if(result.memberInfo != null && result.memberInfo.no == cdata.member_no) {
				htmls += '	<a href="#100" class="cover_img_btn" onclick="show2(\'view_edit_bg\');document.body.style.overflow = \'hidden\';">	';
				htmls += '	기업정보 관리</a>	';
			}
			htmls += '	</div>	';
			htmls += '	<div class="col-sm-1"></div>	';
			htmls += '		';
			htmls += '		';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '	</div>	';

			document.getElementById("ajax_header_bg").innerHTML = htmls;
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//로그인 ajax
function login_ajax(forms, member_no) {
	var ischecked = -1;
	if(forms.save_id.checked == true)
		ischecked = 1;
	$.ajax({
		url:'login_post_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			email:forms.email.value,
			password:forms.password.value,
			save_id:ischecked,
			kakao:forms.kakao.value,
			name:forms.name.value
		},
		success:function(result){
			if(result.result == false){
				alert(result.msg);
			} else{
				if(ischecked == 1) {
					save_id_auths = forms.email.value;
				}else{
					save_id_auths = '';
				}
				
				if(result.kakao != -1) {
					save_id_auths = '';
				}
				
				var htmls = "";
				
				var memberInfo = result.memberInfo;
				htmls += '          <li class="header_ul_li" onmousemove="show(\'top_sub_id\');" onmouseleave="hide(\'top_sub_id\')"><a href="#100" class="header_ul_li_a">'+memberInfo.name+' 님</a>';
				htmls += '          	<div id="top_sub_id" class="top_sub" style="display:none;">';
				htmls += '          		<a href="#100" onclick="logout_ajax('+member_no+');">로그아웃</a>';
				htmls += '          		<a href="#100" onclick="login_edit_btn_ajax();">회원수정</a>';
				htmls += '          	</div>';
				htmls += '          </li>';
				if(memberInfo.orders == 1) htmls += '            <li class="header_ul_li"><a href="mypage.o?mypage=1" class="header_ul_li_a">마이페이지</a></li>';
				if(memberInfo.orders == 2) htmls += '            <li class="header_ul_li"><a href="view.o?member_no='+memberInfo.no+'" class="header_ul_li_a">내 기업</a></li>';
				
				document.getElementById("login_btn_bg").innerHTML = htmls;
				
				
				htmls = "";
				htmls += '<li><a href="#100" onclick="hide2(\'xs_menu_id\');document.body.style.overflow=\'scroll\';" style="color:#666666;font-weight:bold;padding:5px 0 5px 0;text-align:center;font-size:20px;">X</a></li>';
				htmls += '          <li onclick="toggle2(\'top_sub_id2\');">';
				htmls += '            <a href="#100">'+memberInfo.name+' 님</a>';
				htmls += '          </li>';
				htmls += '          <div id="top_sub_id2" style="display:none;">';
				htmls += '          	<li><a href="#100" style="background:#e6e6e6;" onclick="logout_ajax('+member_no+');">&nbsp;&nbsp;로그아웃</a></li>';
				htmls += '          	<li><a href="#100" style="background:#e6e6e6;" onclick="login_edit_btn_ajax();hide2(\'xs_menu_id\');">&nbsp;&nbsp;회원수정</a></li>';
				htmls += '          </div>';
				if(memberInfo.orders == 1) htmls += '            <li><a href="mypage.o?mypage=1">마이페이지</a></li>';
				if(memberInfo.orders == 2) htmls += '            <li><a href="view.o?member_no='+memberInfo.no+'">내 기업</a></li>';
				htmls += '	    <li><a href="list.o?search=1">기업정보</a></li>';
				htmls += '	    <li><a href="list.o?search=2">채용정보</a></li>';
	
				document.getElementById("login_btn_bg2").innerHTML = htmls;
				
				
				
				
				
				hide2('login_float_bg');document.body.style.overflow = 'scroll';
				
				
				
				if(memberInfo.orders == 1) {
					$(".log_1").each(function(){
						$(this).css("display","");
					});
				}
				if(memberInfo.no == member_no) {
					$(".log_same").each(function(){
						$(this).css("display","");
					});
				}
				
				//팔로우 처리
				var list = result.list;
				var list_length = Object.keys(list).length;
				
				var i = 0;
				for(i=0;i<list_length;i++) {
					var data = parseInt(list[i]);
					if(member_no == data) {
						document.getElementById('follow_heart').setAttribute("src","./images/heart2.jpg");
					}
					$(".list_follow_img_"+data).each(function(){
						$(this).attr("src","./images/list_heart2.jpg");
					});
				}
			}
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//로그아웃 ajax
function logout_ajax(member_no) {
	$.ajax({
		url:'logout_ajax.o',
		method:'POST',
		datatype : "json",
		data:{},
		success:function(result){
			var htmls = "";
			
			htmls += '<li class="header_ul_li"><a href="#100" class="header_ul_li_a" onclick="addloginbg('+member_no+');hide2(\'xs_menu_id\');">로그인</a></li>';
			htmls += '<li class="header_ul_li"><a href="#100" class="header_ul_li_a" onclick="show2(\'join_float_bg\');document.body.style.overflow = \'hidden\';">회원가입</a></li>';
			
			
			document.getElementById("login_btn_bg").innerHTML = htmls;
			
			htmls = "";
			htmls += '<li><a href="#100" onclick="hide2(\'xs_menu_id\');document.body.style.overflow=\'scroll\';" style="color:#666666;font-weight:bold;padding:5px 0 5px 0;text-align:center;font-size:20px;">X</a></li>';
			htmls += '<li><a href="#100" onclick="addloginbg('+member_no+');hide2(\'xs_menu_id\');">로그인</a></li>';
			htmls += '<li><a href="#100" onclick="show2(\'join_float_bg\');document.body.style.overflow = \'hidden\';hide2(\'xs_menu_id\');">회원가입</a></li>';
			htmls += '	    <li><a href="list.o?search=1">기업정보</a></li>';
			htmls += '	    <li><a href="list.o?search=2">채용정보</a></li>';

			document.getElementById("login_btn_bg2").innerHTML = htmls;
			
			hide2('xs_menu_id');
			document.body.style.overflow='scroll';
			
			$(".log_1").each(function(){
				$(this).css("display","none");
			});
			$(".log_same").each(function(){
				$(this).css("display","none");
			});

			//view의 팔로우
			$("#follow_heart").attr("src","./images/heart.jpg");
			
			//index와 list의 팔로우
			$(".list_follow_img").each(function(){
				$(this).attr("src","./images/list_heart.jpg");
			});
			

			var mypage = ${mypage};
			if(mypage == 1) {
				alert("로그아웃 성공");
				location.href="index.o";
			}
			
			
			
			document.getElementById("login_edit_hidden").innerHTML = "";
			
			
			
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//회원 가입완료
function join_ajax(forms) {
	//유효성검사 통과시에만 실행
	if(join_submit(forms) == true) {
		$.ajax({
			url:'join_post_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				orders:forms.orders.value,
				email:forms.email.value,
				password:forms.password.value,
				password2:forms.password2.value,
				company:forms.company.value,
				company_cate:forms.company_cate.value,
				company_num:forms.company_num.value,
				name:forms.name.value,
				phone1:forms.phone1.value,
				phone2:forms.phone2.value,
				phone3:forms.phone3.value,
				quest:forms.quest.value,
				answer:forms.answer.value
			},
			success:function(result){
				if(result.result != true) {
					alert(result.msg);
				}else{
					alert('가입완료');
					document.body.style.overflow = 'scroll';
					hide2('join_float_bg');
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}
//로그인정보를 불러와 로그인 수정폼 생성해서 보여주기
function login_edit_btn_ajax() {
	$.ajax({
		url:'login_info_ajax.o',
		method:'POST',
		datatype : "json",
		data:null,
		success:function(result){
			var htmls = "";
			var memberInfo = result.memberInfo;
			htmls += '	<!--회원수정-->	';
			htmls += '	<div class="write_hide" id="login_edit_bg" style="display:none;">	';
			htmls += '	<div class="write_hide_scroll">	';
			htmls += '		';
			htmls += '	<div class="write_hide_scroll2s">	';
			htmls += '	<div class="review_write_box">	';
			htmls += '	<div style="overflow:hidden;">	';
			htmls += '	<div style="width:50%;float:left;"><h1 id="rc_h">회원수정</h1></div>	';
			htmls += '	<div style="width:50%;float:right;text-align:right;">	';
			htmls += '	<a href="#100" class="review_write_btn2" style="width:85%;" onclick="hide2(\'login_edit_bg\');document.body.style.overflow = \'scroll\';document.getElementById(\'login_edit_hidden\').innerHTML = \'\';">닫기</a>	';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '		';
			htmls += '	<form id="login_edit_forms" action="login_edit_post.o" method="post" onsubmit="return login_edit_submit(this);">	';
			htmls += '	<input type="hidden" name="orders" value="'+memberInfo.orders+'" />	';
			
			if(memberInfo.kakao == -1) htmls += '	'+memberInfo.email;
			else if(memberInfo.kakao == 1) htmls += '	<a class="login_btn" style="border:1px solid #ffeb00;background-color:#ffeb00;background-image:url(./images/kakao_login_btn.jpg);background-repeat:no-repeat;background-position:25px 9px;color:#3c1e1e;display:block;line-height:43px;text-align:center;">카카오계정</a>	';
			else if(memberInfo.kakao == 2) htmls += '	<a class="login_btn" style="border:1px solid #cccccc;background-color:#ffffff;background-image:url(./images/google_login_btn.jpg);background-repeat:no-repeat;background-position:25px 9px;color:#3c1e1e;display:block;line-height:43px;text-align:center;color:#333333;">구글계정</a>	';
			
			
			
			
			htmls += '	<div id="email_msg" class="join_msg"></div>	';
			htmls += '	<input type="password" name="password" placeholder="비밀번호" class="login_input" ';
			if(memberInfo.kakao != -1) htmls += ' style="display:none;"';
			htmls += ' onchange="password_checks(this);" />	';
			htmls += '	<div id="password_msg" class="join_msg"></div>	';
			htmls += '	<input type="password" name="password2" placeholder="비밀번호 확인" class="login_input" ';
			if(memberInfo.kakao != -1) htmls += ' style="display:none;"';
			htmls += ' onchange="password2_checks(this);" />	';
			htmls += '	<div id="password2_msg" class="join_msg"></div>	';
			htmls += '		';
			if(memberInfo.orders == 2) htmls += '	<div id="join_02">	';
			else htmls += '	<div id="join_02s" style="display:none;">	';
				htmls += '	<br /><br />	';
				htmls += '	<input type="text" name="company" placeholder="기업명" class="login_input" onchange="company_check(this);" value="'+memberInfo.company+'" />	';
				htmls += '	<div id="company_msg" class="join_msg"></div>	';
				htmls += '	<select name="company_cate" class="join_select" onchange="company_cate_check(this);">	';
				htmls += '	<option value="-1">산업군</option>	';
				htmls += '	<option value="1" ';
				if(memberInfo.company_cate == 1) htmls += ' selected ';
				htmls += '  >서비스업</option>	';
				htmls += '	<option value="2" ';
				if(memberInfo.company_cate == 2) htmls += ' selected ';
				htmls += '  >제조/화학</option>	';
				htmls += '	<option value="3" ';
				if(memberInfo.company_cate == 3) htmls += ' selected ';
				htmls += '  >의료/제약/복지</option>	';
				htmls += '	<option value="4" ';
				if(memberInfo.company_cate == 4) htmls += ' selected ';
				htmls += '  >유통/무역/운송</option>	';
				htmls += '	<option value="5" ';
				if(memberInfo.company_cate == 5) htmls += ' selected ';
				htmls += '  >교육업</option>	';
				htmls += '	<option value="6" ';
				if(memberInfo.company_cate == 6) htmls += ' selected ';
				htmls += '  >건설업</option>	';
				htmls += '	<option value="7" ';
				if(memberInfo.company_cate == 7) htmls += ' selected ';
				htmls += '  >IT/웹/통신</option>	';
				htmls += '	<option value="8" ';
				if(memberInfo.company_cate == 8) htmls += ' selected ';
				htmls += '  >미디어/디자인</option>	';
				htmls += '	<option value="9" ';
				if(memberInfo.company_cate == 9) htmls += ' selected ';
				htmls += '  >은행/금융업</option>	';
				htmls += '	<option value="10" ';
				if(memberInfo.company_cate == 10) htmls += ' selected ';
				htmls += '  >기관/협회</option>	';
				htmls += '	</select>	';
				htmls += '	<div id="company_cate_msg" class="join_msg"></div>	';
				htmls += '	<input type="text" name="company_num" placeholder="사업자등록번호" class="login_input" onchange="company_num_check(this);" value="'+memberInfo.company_num+'" />	';
				htmls += '	<div id="company_num_msg" class="join_msg"></div>	';
				htmls += '	<br /><br />	';
				htmls += '	</div>	';
			
			htmls += '		';
			htmls += '	<input type="text" name="name" placeholder="이름" class="login_input" onchange="name_check(this);" value="'+memberInfo.name+'" />	';
			htmls += '	<div id="name_msg" class="join_msg"></div>	';
			htmls += '	<div class="join_phone" style="overflow:hidden;">	';
			htmls += '	<h4>전화번호</h4>	';
			htmls += '	<input type="text" name="phone1" placeholder="010" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="phone1_check(this);" value="'+memberInfo.phone1+'" />	';
			htmls += '	<div>-</div>	';
			htmls += '	<input type="text" name="phone2" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="phone2_check(this);" value="'+memberInfo.phone2+'" />	';
			htmls += '	<div>-</div>	';
			htmls += '	<input type="text" name="phone3" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="phone3_check(this);" value="'+memberInfo.phone3+'" />	';
			htmls += '	</div>	';
			htmls += '	<div id="phone_msg" class="join_msg"></div>	';
			htmls += '	<div class="join_quest">	';
			htmls += '	<h4>질문/답변</h4>	';
			htmls += '	<select name="quest" class="join_select" onchange="quest_check(this);">	';
			htmls += '	<option value="-1">질문을 선택해 주세요.</option>	';
			htmls += '	<option value="1" ';
			if(memberInfo.quest == 1) htmls += ' selected ';
			htmls += '  >나의 아버지 이름은?</option>	';
			htmls += '	<option value="2" ';
			if(memberInfo.quest == 2) htmls += ' selected ';
			htmls += '  >내가 다니던 학교 이름은?</option>	';
			htmls += '	<option value="3" ';
			if(memberInfo.quest == 3) htmls += ' selected ';
			htmls += '  >나의 취미는?</option>	';
			htmls += '	<option value="4" ';
			if(memberInfo.quest == 4) htmls += ' selected ';
			htmls += '  >내가 좋아하던 게임은?</option>	';
			htmls += '	<option value="5" ';
			if(memberInfo.quest == 5) htmls += ' selected ';
			htmls += '  >나의 직업은?</option>	';
			htmls += '	</select>	';
			htmls += '	<div id="quest_msg" class="join_msg"></div>	';
			htmls += '	<input type="text" name="answer" placeholder="답변" class="login_input" onchange="answer_check(this);" value="'+memberInfo.answer+'" />	';
			htmls += '	<div id="answer_msg" class="join_msg"></div>	';
			htmls += '	</div>	';
			htmls += '	<input type="button" value="수정완료" class="login_btn" onclick="login_edit_ajax(document.getElementById(\'login_edit_forms\'))" />	';
			htmls += '	<input type="button" value="회원탈퇴" class="login_btn" style="background:#fc4b3d;border:1px solid #fc4b3d;" onclick="login_exit_show();hide2(\'login_edit_bg\')" />	';
			htmls += '	</form>	';
			htmls += '		';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '	</div>	';

			document.getElementById("login_edit_hidden").innerHTML = htmls;
			
			
			show2("login_edit_bg");
			document.body.style.overflow = "hidden";
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//회원 수정완료
function login_edit_ajax(forms) {
	//유효성검사 통과시에만 실행
	if(login_edit_submit(forms) == true) {
		$.ajax({
			url:'login_edit_post_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				orders:forms.orders.value,
				password:forms.password.value,
				password2:forms.password2.value,
				company:forms.company.value,
				company_cate:forms.company_cate.value,
				company_num:forms.company_num.value,
				name:forms.name.value,
				phone1:forms.phone1.value,
				phone2:forms.phone2.value,
				phone3:forms.phone3.value,
				quest:forms.quest.value,
				answer:forms.answer.value
			},
			success:function(result){
				if(result.result != true) {
					alert(result.msg);
				}else{
					alert('수정완료');
					
					
					//로그인버튼부분 갱신
					var htmls = "";
					
					var memberInfo = result.memberInfo;
					htmls += '          <li class="header_ul_li" onmousemove="show(\'top_sub_id\');" onmouseleave="hide(\'top_sub_id\')"><a href="#100" class="header_ul_li_a">'+memberInfo.name+' 님</a>';
					htmls += '          	<div id="top_sub_id" class="top_sub" style="display:none;">';
					htmls += '          		<a href="#100" onclick="logout_ajax('+result.member_no+');">로그아웃</a>';
					htmls += '          		<a href="#100" onclick="login_edit_btn_ajax();">회원수정</a>';
					htmls += '          	</div>';
					htmls += '          </li>';
					if(memberInfo.orders == 1) htmls += '            <li class="header_ul_li"><a href="mypage.o?mypage=1" class="header_ul_li_a">마이페이지</a></li>';
					if(memberInfo.orders == 2) htmls += '            <li class="header_ul_li"><a href="view.o?member_no='+memberInfo.no+'" class="header_ul_li_a">내 기업</a></li>';
					
					document.getElementById("login_btn_bg").innerHTML = htmls;
					
					
					htmls = "";
					htmls += '<li><a href="#100" onclick="hide2(\'xs_menu_id\');document.body.style.overflow=\'scroll\';" style="color:#666666;font-weight:bold;padding:5px 0 5px 0;text-align:center;font-size:20px;">X</a></li>';
					htmls += '          <li onclick="toggle2(\'top_sub_id2\');">';
					htmls += '            <a href="#100">'+memberInfo.name+' 님</a>';
					htmls += '          </li>';
					htmls += '          <div id="top_sub_id2" style="display:none;">';
					htmls += '          	<li><a href="#100" style="background:#e6e6e6;" onclick="logout_ajax('+result.member_no+');">&nbsp;&nbsp;로그아웃</a></li>';
					htmls += '          	<li><a href="#100" style="background:#e6e6e6;" onclick="login_edit_btn_ajax();">&nbsp;&nbsp;회원수정</a></li>';
					htmls += '          </div>';
					if(memberInfo.orders == 1) htmls += '            <li><a href="mypage.o?mypage=1">마이페이지</a></li>';
					if(memberInfo.orders == 2) htmls += '            <li><a href="view.o?member_no='+memberInfo.no+'">내 기업</a></li>';
					htmls += '	    <li><a href="list.o?search=1">기업정보</a></li>';
					htmls += '	    <li><a href="list.o?search=2">채용정보</a></li>';

					document.getElementById("login_btn_bg2").innerHTML = htmls;
					

					document.body.style.overflow = 'scroll';
					hide2('login_edit_bg');
					document.getElementById("login_edit_hidden").innerHTML = "";
					
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}

//지원자리스트
function recruit_mylist_ajax(pages, recruit_no, member_no) {
	 $.ajax({
		url:'recruit_mylist_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			pages:pages,
			recruit_no:recruit_no,
			member_no:member_no
		},
		success:function(result){
			var htmls = "";
			htmls += '	<div class="write_hide" id="recruit_mylist">	';
			htmls += '	<div class="write_hide_scroll">	';
			htmls += '		';
			htmls += '	<div class="write_hide_scroll2s">	';
			htmls += '	<div class="review_write_box">	';
			htmls += '	<div style="border-bottom:1px solid #e6e6e6;overflow:hidden;">	';
			htmls += '	<div style="width:50%;float:left;"><h1 id="rc_h">지원자</h1></div>	';
			htmls += '	<div style="width:50%;float:right;text-align:right;">	';
			htmls += '	<a href="#100" class="review_write_btn2" style="width:85%;" onclick="hide2(\'recruit_mylist\');document.body.style.overflow = \'scroll\';">닫기</a>	';
			htmls += '	</div>	';
			htmls += '	</div>	'; 
			
			

			var list = result.list;
			var list_length = Object.keys(list).length;
			var i = 0;
			for(i=0;i<list_length;i++) {
				var rldata = list[i];
				htmls += '	<div class="recruit_mylist_box" style="overflow:hidden">	';
				
				htmls += '	<div style="margin-right:10px;width:79px;height:110px;float:left;overflow:hidden">	';
				htmls += '    <img src="./upload/'+rldata.file3+'" width="79px" height="110px" />';
				htmls += '  </div>';
				
				htmls += '	<div style="float:left;overflow:hidden">	';
				htmls += '	<span style="font-weight:bold;">이름</span> : '+rldata.name+'<br />	';
				htmls += '	<span style="font-weight:bold;">연락처</span> : '+rldata.phone1+'-'+rldata.phone2+'-'+rldata.phone3+'<br />	';
				htmls += '	<span style="font-weight:bold;">이메일</span> : '+rldata.email+'<br />	';
				htmls += '	<a href="download.o?filename='+rldata.file1+'" style="">이력서</a>';
				if(rldata.file2 != null && rldata.file2 != '') htmls += '  <a href="download.o?filename='+rldata.file2+'" style="">첨부파일</a>	';
				htmls += '	</div>	';
				
				htmls += '	</div>	';
			}
			
			htmls += '	<div class="paging">	';
			htmls += '	<a href="#100" style="color:#d0d0d0;" class="paging_radius_l" onclick="recruit_mylist_ajax(1,'+recruit_no+','+member_no+');">&lt;</a>	';
			
			var paging = result.paging;
			for(i=paging.pstarts;i<=paging.pends;i++) {
				htmls += '	<a href="#100" onclick="recruit_mylist_ajax('+i+','+recruit_no+','+member_no+');"	';
				if(i == pages) htmls += '	class="paging_a_hover">	';
				else htmls += '	class="paging_a">	';
				htmls += '	'+i;
				htmls += '	</a>	';
			}
			htmls += '	<a href="#100" style="color:#d0d0d0;" class="paging_radius_r" onclick="recruit_mylist_ajax('+paging.board_paging+','+recruit_no+','+member_no+');">&gt;</a>	';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '	</div>	';
			htmls += '	</div>	'; 

			
			document.getElementById("recruit_mylist_bg").innerHTML = htmls;
				

			
			
			
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}




//구글로그인
var google_login_member_no = -1;
var googleUser = {};
var startApp = function() {
  gapi.load('auth2', function(){
    // Retrieve the singleton for the GoogleAuth library and set up the client.
    auth2 = gapi.auth2.init({
      client_id: '395192667762-gppc4u7fgg05tcn1o867b9js7g25p7vb.apps.googleusercontent.com',
      cookiepolicy: 'single_host_origin',
      // Request scopes in addition to 'profile' and 'email'
      //scope: 'additional_scope'
    });
    attachSignin(document.getElementById('customBtn'));
  });
};

function attachSignin(element) {
  console.log(element.id);
  auth2.attachClickHandler(element, {},
      function(googleUser) {
	  	var profile = googleUser.getBasicProfile();
		//alert('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
		//alert('Name: ' + profile.getName());
		//alert('Image URL: ' + profile.getImageUrl());
		//alert('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
		  
		var forms = document.getElementById("login_forms");
		forms.name.value = profile.getName();
	   	forms.kakao.value = 2;
	   	forms.email.value = profile.getId();
	   	forms.password.value = profile.getId();
	   
	   	login_ajax(forms,google_login_member_no);
      }, function(error) {
        alert("구글로그인 취소");
      });
}

 /*
function onSuccess(googleUser) {
	var profile = googleUser.getBasicProfile();
	//alert('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	//alert('Name: ' + profile.getName());
	//alert('Image URL: ' + profile.getImageUrl());
	//alert('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	  
	var forms = document.getElementById("login_forms");
	forms.name.value = profile.getName();
   	forms.kakao.value = 2;
   	forms.email.value = profile.getId();
   	forms.password.value = profile.getId();
   
   	login_ajax(forms,google_login_member_no);
}
function onFailure(error) {
	alert("실패");
}
  function renderButton() {
    gapi.signin2.render('my-signin2', {
      'scope': 'profile email',
      'width': 240,
      'height': 50,
      'longtitle': true,
      'theme': 'dark',
      'onsuccess': onSuccess,
      'onfailure': onFailure
    });
  } */
  
//로그인창 생성
function addloginbg(member_no) {
	google_login_member_no = member_no;
	var htmls = "";
	htmls += '	<div class="write_hide" id="login_float_bg" style="display:none;z-index:6700;">	';
	htmls += '	<div class="write_hide_scroll">	';
	htmls += '		';
	htmls += '	<div class="write_hide_scroll2s">	';
	htmls += '	<div class="review_write_box">	';
	htmls += '	<div style="overflow:hidden;">	';
	htmls += '	<div style="width:50%;float:left;"><h1 id="rc_h">로그인</h1></div>	';
	htmls += '	<div style="width:50%;float:right;text-align:right;">	';
	htmls += '	<a href="#100" class="review_write_btn2" style="width:85%;" onclick="hide2(\'login_float_bg\');document.body.style.overflow = \'scroll\';">닫기</a>	';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	<div class="recruit_add_box_line">	';
	htmls += '	<form id="login_forms" action="login_post.o" method="post" onsubmit="return login_submit(this)">	';
	htmls += '	<input type="text" name="kakao" value="-1" style="display:none;" />	';
	htmls += '	<input type="text" name="name" value="" style="display:none;" />	';
	htmls += '	<input type="text" name="email" placeholder="이메일 주소" class="login_input" value="'+save_id_auths+'" onchange="login_email_check(this);" />	';
	htmls += '	<div id="login_email_msg" class="join_msg"></div>	';
	htmls += '	<input type="password" name="password" placeholder="비밀번호" class="login_input" onchange="login_password_check(this);" />	';
	htmls += '	<div id="login_password_msg" class="join_msg"></div>	';
	htmls += '	<input type="button" value="로그인" class="login_btn" onclick="login_submit(document.getElementById(\'login_forms\'),'+member_no+');" />	';
	htmls += '	<input type="button" value="카카오계정으로 로그인" class="login_btn" onclick="loginWithKakao('+member_no+')" style="border:1px solid #ffeb00;background-color:#ffeb00;background-image:url(./images/kakao_login_btn.jpg);background-repeat:no-repeat;background-position:25px 9px;color:#3c1e1e;" />	';

	//구글로그인부분
	htmls += '	<input type="button" value="구글계정으로 로그인" id="customBtn" class="login_btn customGPlusSignIn" onclick="" style="color:#333333;border:1px solid #cccccc;background-color:#ffffff;background-image:url(./images/google_login_btn.jpg);background-repeat:no-repeat;background-position:25px 9px;" />	';
	//htmls += '<div id="my-signin2" style="display:none;"></div>';
	//htmls += '<div id="customBtn" class="customGPlusSignIn">sss</div>';
	
	htmls += '	<div id="login_msg" class="join_msg"></div>	';
	htmls += '	<input type="checkbox" name="save_id" id="save_id" value="1" ';
	if(save_id_auths != '') htmls += '  checked ';
	htmls += '  />	';
	htmls += '	<label for="save_id">아이디 저장</label>	';
	htmls += '	</form>	';
	htmls += '	<div class="login_find">	';
	htmls += '	<a href="#100" onclick="email_find_show();">이메일 찾기</a> /	';
	htmls += '	<a href="#100" onclick="pw_find_show();">비밀번호 찾기</a>	';
	htmls += '	</div>	';
	htmls += '	<div class="login_box_b">	';
	htmls += '	아직 회원이 아니세요?	';
	htmls += '	&nbsp;&nbsp;	';
	htmls += '	<a href="#100" onclick="hide2(\'login_float_bg\');show2(\'join_float_bg\');document.body.style.overflow = \'hidden\';">회원가입</a>	';
	htmls += '	</div>	';
	htmls += '		';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';
	
	Kakao.Auth.logout();
	Kakao.Auth.cleanup();
	Kakao.cleanup();
	Kakao.init('b85b67c68bb32038acd5d82c790bb2ab');
	document.getElementById("login_forms_hidden").innerHTML = htmls;
	
	startApp();

	show2("login_float_bg");
	document.body.style.overflow = 'hidden';
}
//view 메뉴 개수 구하기

//지원자리스트
function view_menu_count_ajax(member_no) {
	 $.ajax({
		url:'view_menu_count_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			member_no:member_no
		},
		success:function(result){
			document.getElementById("cont2").innerHTML = ''+result.count2;
			document.getElementById("cont3").innerHTML = ''+result.count3;
			document.getElementById("cont4").innerHTML = ''+result.count4;
			document.getElementById("cont5").innerHTML = ''+result.count5;
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
//////////////////////////////////////////











//채용정보 보기 로딩
function recruit_view_load(member_no, recruit_no) {
	if(member_no != -1 && recruit_no != -1) {
		recruit_view_ajax(1,recruit_no,member_no,1);
		setmenu(document.getElementById("nav_btn5"));
	}
}





/////////////////////////////////////////////







//카카오로그인
String.prototype.trim = function()
{
  return this.replace(/(^\s*)|(\s*$)/gi, "");
}

String.prototype.replaceAll = function(str1, str2)
{
  var temp_str = this.trim();
  temp_str = temp_str.replace(eval("/" + str1 + "/gi"), str2);
  return temp_str;
}




//<![CDATA[
// 사용할 앱의 JavaScript 키를 설정해 주세요.
Kakao.init('b85b67c68bb32038acd5d82c790bb2ab');
function loginWithKakao(member_no) {
  // 로그인 창을 띄웁니다.
  Kakao.Auth.login({
    success: function(authObj) {
    	//alert(JSON.stringify(authObj));
    	
    	var kakao_password = authObj.refresh_token_expires_in;
    	
    	var token = JSON.stringify(authObj);
     	Kakao.Auth.setAccessToken(authObj.access_token);
 	    Kakao.API.request({
           url: '/v1/user/me',
           success: function(res) {
        	    //alert(JSON.stringify(res));
        	  	var kakao_id = res.id;
          	  	var kakao_name = res.properties.nickname;
       	   	  
       	   		var forms = document.getElementById("login_forms");
               	forms.name.value = kakao_name;
               	forms.kakao.value = 1;
               	forms.email.value = kakao_id;
               	forms.password.value = kakao_id;
               
               	login_ajax(forms,member_no);
           },
           fail: function(error) {
             alert(JSON.stringify(error));
           }
         });
 	    
    },
    fail: function(err) {
      alert(JSON.stringify(err));
    }
  });
};
//]]>
///////////////////////////////////////////










//이메일 찾기
var email_find_name = false;
var email_find_phone1 = false;
var email_find_phone2 = false;
var email_find_phone3 = false;

function email_find_name_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "이름을 작성해주세요.";
		htmls += '</span>';
		document.getElementById("email_find_name_msg").innerHTML = htmls;
		email_find_name = false;
	}else{
		document.getElementById("email_find_name_msg").innerHTML = "";
		email_find_name = true;
	}
}
function email_find_phone1_check(var1) {
	if(var1.value == "") email_find_phone1 = false;
	else email_find_phone1 = true;
	
	if(!email_find_phone1 || !email_find_phone2 || !email_find_phone3) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "전화번호가 올바르지 않습니다.";
		htmls += '</span>';
		document.getElementById("email_find_phone_msg").innerHTML = htmls;
	}else{
		document.getElementById("email_find_phone_msg").innerHTML = "";
	}
}
function email_find_phone2_check(var1) {
	if(var1.value == "") email_find_phone2 = false;
	else email_find_phone2 = true;
	
	if(!email_find_phone1 || !email_find_phone2 || !email_find_phone3) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "전화번호가 올바르지 않습니다.";
		htmls += '</span>';
		document.getElementById("email_find_phone_msg").innerHTML = htmls;
	}else{
		document.getElementById("email_find_phone_msg").innerHTML = "";
	}
}
function email_find_phone3_check(var1) {
	if(var1.value == "") email_find_phone3 = false;
	else email_find_phone3 = true;
	
	if(!email_find_phone1 || !email_find_phone2 || !email_find_phone3) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "전화번호가 올바르지 않습니다.";
		htmls += '</span>';
		document.getElementById("email_find_phone_msg").innerHTML = htmls;
	}else{
		document.getElementById("email_find_phone_msg").innerHTML = "";
	}
}
function email_find_submit(forms) {
	email_find_name_check(forms.name);
	email_find_phone1_check(forms.phone1);
	email_find_phone2_check(forms.phone2);
	email_find_phone3_check(forms.phone3);
	
	if(
			!email_find_name || 
			!email_find_phone1 || 
			!email_find_phone2 || 
			!email_find_phone3
	) {
		return false;
	}else{
		return true;
	}
	
}
function email_find_ajax(forms) {
	if(email_find_submit(forms) == true) {
		$.ajax({
			url:'email_find_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				name:forms.name.value,
				phone1:forms.phone1.value,
				phone2:forms.phone2.value,
				phone3:forms.phone3.value
			},
			success:function(result){
				var htmls1 = "";
				var htmls2 = "";

				htmls2 += '<input type="button" value="닫기" onclick="hide2(\'email_find_float_bg\');" class="review_write_btn2" />';
				if(result.result == false) {
					htmls1 += '이메일을 찾을 수 없습니다.';
				}else{
					htmls1 += '이메일은 <span style="font-weight:bold;">'+result.email+'</span> 입니다.';
					htmls2 += '<input type="button" value="비밀번호 찾기" class="review_write_btn1" onclick="hide2(\'email_find_float_bg\');pw_find_show();" />';
				}

				
				document.getElementById("email_find_result").innerHTML = htmls1;
				document.getElementById("email_find_btn").innerHTML = htmls2;

				
				
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}

function email_find_show() {
	var htmls = "";
	
	htmls += '	<div class="write_hide" id="email_find_float_bg" style="display:none;z-index:7000;">	';
	htmls += '	<div class="write_hide_scroll">	';
	htmls += '		';
	htmls += '	<div class="write_hide_scroll2s">	';
	htmls += '	<div class="review_write_box">	';
	htmls += '	<div style="overflow:hidden;">	';
	htmls += '	<div><h1 id="rc_h">이메일찾기</h1></div>	';
	htmls += '	</div>	';
	htmls += '	<div class="recruit_add_box_line" id="email_find_result">	';
	htmls += '	<form id="email_find_forms">	';
	htmls += '	<input type="text" name="name" placeholder="이름" class="login_input" onchange="email_find_name_check(this);" />	';
	htmls += '	<div id="email_find_name_msg" class="join_msg"></div>	';
	htmls += '	<div class="join_phone" style="overflow:hidden;">	';
	htmls += '	<h4>전화번호</h4>	';
	htmls += '	<input type="text" name="phone1" placeholder="010" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="email_find_phone1_check(this);" />	';
	htmls += '	<div>-</div>	';
	htmls += '	<input type="text" name="phone2" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="email_find_phone2_check(this);" />	';
	htmls += '	<div>-</div>	';
	htmls += '	<input type="text" name="phone3" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="email_find_phone3_check(this);" />	';
	htmls += '	</div>	';
	htmls += '	<div id="email_find_phone_msg" class="join_msg"></div>	';
	htmls += '	</form>	';
	htmls += '	</div>	';
	htmls += '		';
	htmls += '	<div class="review_write_box_line align-center" id="email_find_btn">	';
	htmls += '	<input type="button" value="닫기" onclick="hide2(\'email_find_float_bg\');" class="review_write_btn2" />	';
	htmls += '	<input type="button" value="이메일 찾기" class="review_write_btn1" onclick="email_find_ajax(document.getElementById(\'email_find_forms\'));" />	';
	htmls += '	</div>	';
	htmls += '		';
	htmls += '		';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';
	
	document.getElementById("email_find_hidden").innerHTML = htmls;
	
	show2("email_find_float_bg");
}
//////////////////////////////////////////







//비밀번호 찾기
var pw_find_email = false;
var pw_find_name = false;
var pw_find_phone1 = false;
var pw_find_phone2 = false;
var pw_find_phone3 = false;
var pw_find_quest = false;
var pw_find_answer = false;

function pw_find_email_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "이메일을 작성해주세요.";
		htmls += '</span>';
		document.getElementById("pw_find_email_msg").innerHTML = htmls;
		pw_find_email = false;
	}else{
		document.getElementById("pw_find_email_msg").innerHTML = "";
		pw_find_email = true;
	}
}
function pw_find_name_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "이름을 작성해주세요.";
		htmls += '</span>';
		document.getElementById("pw_find_name_msg").innerHTML = htmls;
		pw_find_name = false;
	}else{
		document.getElementById("pw_find_name_msg").innerHTML = "";
		pw_find_name = true;
	}
}
function pw_find_phone1_check(var1) {
	if(var1.value == "") pw_find_phone1 = false;
	else pw_find_phone1 = true;
	
	if(!pw_find_phone1 || !pw_find_phone2 || !pw_find_phone3) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "전화번호가 올바르지 않습니다.";
		htmls += '</span>';
		document.getElementById("pw_find_phone_msg").innerHTML = htmls;
	}else{
		document.getElementById("pw_find_phone_msg").innerHTML = "";
	}
}
function pw_find_phone2_check(var1) {
	if(var1.value == "") pw_find_phone2 = false;
	else pw_find_phone2 = true;
	
	if(!pw_find_phone1 || !pw_find_phone2 || !pw_find_phone3) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "전화번호가 올바르지 않습니다.";
		htmls += '</span>';
		document.getElementById("pw_find_phone_msg").innerHTML = htmls;
	}else{
		document.getElementById("pw_find_phone_msg").innerHTML = "";
	}
}
function pw_find_phone3_check(var1) {
	if(var1.value == "") pw_find_phone3 = false;
	else pw_find_phone3 = true;
	
	if(!pw_find_phone1 || !pw_find_phone2 || !pw_find_phone3) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "전화번호가 올바르지 않습니다.";
		htmls += '</span>';
		document.getElementById("pw_find_phone_msg").innerHTML = htmls;
	}else{
		document.getElementById("pw_find_phone_msg").innerHTML = "";
	}
}

function pw_find_quest_check(var1) {
	if(var1.value == -1) {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "질문을 선택해주세요.";
		htmls += '</span>';
		document.getElementById("pw_find_quest_msg").innerHTML = htmls;
		pw_find_quest = false;
	}else{
		document.getElementById("pw_find_quest_msg").innerHTML = "";
		pw_find_quest = true;
	}
}

function pw_find_answer_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "답변을 작성해주세요.";
		htmls += '</span>';
		document.getElementById("pw_find_answer_msg").innerHTML = htmls;
		pw_find_answer = false;
	}else{
		document.getElementById("pw_find_answer_msg").innerHTML = "";
		pw_find_answer = true;
	}
}
function pw_find_submit(forms) {
	pw_find_email_check(forms.email);
	pw_find_name_check(forms.name);
	pw_find_phone1_check(forms.phone1);
	pw_find_phone2_check(forms.phone2);
	pw_find_phone3_check(forms.phone3);
	pw_find_quest_check(forms.quest);
	pw_find_answer_check(forms.answer);
	
	if(
			!pw_find_email || 
			!pw_find_name || 
			!pw_find_phone1 || 
			!pw_find_phone2 || 
			!pw_find_phone3 || 
			!pw_find_quest || 
			!pw_find_answer
	) {
		return false;
	}else{
		return true;
	}
	
}
function pw_find_ajax(forms) {
	if(pw_find_submit(forms) == true) {
		$.ajax({
			url:'pw_find_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				email:forms.email.value,
				name:forms.name.value,
				phone1:forms.phone1.value,
				phone2:forms.phone2.value,
				phone3:forms.phone3.value,
				quest:forms.quest.value,
				answer:forms.answer.value
			},
			success:function(result){
				var htmls1 = "";
				var htmls2 = "";

				htmls2 += '<input type="button" value="닫기" onclick="hide2(\'pw_find_float_bg\');" class="review_write_btn2" />';
				document.getElementById("pw_find_btn").innerHTML = htmls2;
				if(result.result == false) {
					htmls1 += '비밀번호를 찾을 수 없습니다.';
					document.getElementById("pw_find_result").innerHTML = htmls1;
				}else{
					pw_change_show();
					var fo = document.getElementById("pw_change_forms");
					fo.email.value = forms.email.value;
					fo.name.value = forms.name.value;
					fo.phone1.value = forms.phone1.value;
					fo.phone2.value = forms.phone2.value;
					fo.phone3.value = forms.phone3.value;
					fo.quest.value = forms.quest.value;
					fo.answer.value = forms.answer.value;
					hide2("pw_find_float_bg");
				}

			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}

function pw_find_show() {
	var htmls = "";
	
	htmls += '	<div class="write_hide" id="pw_find_float_bg" style="display:none;z-index:7000;">	';
	htmls += '	<div class="write_hide_scroll">	';
	htmls += '		';
	htmls += '	<div class="write_hide_scroll2s">	';
	htmls += '	<div class="review_write_box">	';
	htmls += '	<div style="overflow:hidden;">	';
	htmls += '	<div><h1 id="rc_h">비밀번호찾기</h1></div>	';
	htmls += '	</div>	';
	htmls += '	<div class="recruit_add_box_line" id="pw_find_result">	';
	htmls += '	<form id="pw_find_forms">	';
	htmls += '	<input type="text" name="email" placeholder="이메일" class="login_input" onchange="pw_find_email_check(this);" />	';
	htmls += '	<div id="pw_find_email_msg" class="join_msg"></div>	';
	htmls += '	<input type="text" name="name" placeholder="이름" class="login_input" onchange="pw_find_name_check(this);" />	';
	htmls += '	<div id="pw_find_name_msg" class="join_msg"></div>	';
	htmls += '	<div class="join_phone" style="overflow:hidden;">	';
	htmls += '	<h4>전화번호</h4>	';
	htmls += '	<input type="text" name="phone1" placeholder="010" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="pw_find_phone1_check(this);" />	';
	htmls += '	<div>-</div>	';
	htmls += '	<input type="text" name="phone2" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="pw_find_phone2_check(this);" />	';
	htmls += '	<div>-</div>	';
	htmls += '	<input type="text" name="phone3" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="pw_find_phone3_check(this);" />	';
	htmls += '	</div>	';
	htmls += '	<div id="pw_find_phone_msg" class="join_msg"></div>	';
	htmls += '	<div class="join_quest">	';
	htmls += '	<h4>질문/답변</h4>	';
	htmls += '	<select name="quest" class="join_select" onchange="pw_find_quest_check(this);">	';
	htmls += '	<option value="-1">질문을 선택해 주세요.</option>	';
	htmls += '	<option value="1">나의 아버지 이름은?</option>	';
	htmls += '	<option value="2">내가 다니던 학교 이름은?</option>	';
	htmls += '	<option value="3">나의 취미는?</option>	';
	htmls += '	<option value="4">내가 좋아하던 게임은?</option>	';
	htmls += '	<option value="5">나의 직업은?</option>	';
	htmls += '	</select>	';
	htmls += '	<div id="pw_find_quest_msg" class="join_msg"></div>	';
	htmls += '	<input type="text" name="answer" placeholder="답변" class="login_input" onchange="pw_find_answer_check(this);" />	';
	htmls += '	<div id="pw_find_answer_msg" class="join_msg"></div>	';
	htmls += '	</div>	';
	htmls += '	</form>	';
	htmls += '	</div>	';
	htmls += '		';
	htmls += '	<div class="review_write_box_line align-center" id="pw_find_btn">	';
	htmls += '	<input type="button" value="닫기" onclick="hide2(\'pw_find_float_bg\');" class="review_write_btn2" />	';
	htmls += '	<input type="button" value="비밀번호 찾기" class="review_write_btn1" onclick="pw_find_ajax(document.getElementById(\'pw_find_forms\'));" />	';
	htmls += '	</div>	';
	htmls += '		';
	htmls += '		';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';

	
	document.getElementById("pw_find_hidden").innerHTML = htmls;
	
	show2("pw_find_float_bg");
}
///////////////////////////////////////////










//비밀번호 변경
var pw_change_password = false;
var pw_change_password_value = "";
var pw_change_password2 = false;

function pw_change_password_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "비밀번호를 작성해주세요.";
		htmls += '</span>';
		document.getElementById("pw_change_password_msg").innerHTML = htmls;
		pw_change_password = false;
	}else{
		document.getElementById("pw_change_password_msg").innerHTML = "";
		pw_change_password = true;
		pw_change_password_value = var1.value;
	}
}
function pw_change_password2_check(var1) {
	if(var1.value == "") {
		var htmls = "";
		htmls = '<span style="color:red;">';
		htmls += "비밀번호를 작성해주세요.";
		htmls += '</span>';
		document.getElementById("pw_change_password2_msg").innerHTML = htmls;
		pw_change_password2 = false;
	}else{
		if(pw_change_password == false) {
			var htmls = "";
			htmls = '<span style="color:red;">';
			htmls += "비밀번호를 작성해주세요.";
			htmls += '</span>';
			document.getElementById("pw_change_password2_msg").innerHTML = htmls;
			pw_change_password2 = false;
		}else if(pw_change_password_value != var1.value) {
			var htmls = "";
			htmls = '<span style="color:red;">';
			htmls += "비밀번호가 다릅니다.";
			htmls += '</span>';
			document.getElementById("pw_change_password2_msg").innerHTML = htmls;
			pw_change_password2 = false;
		}else{
			document.getElementById("pw_change_password2_msg").innerHTML = "";
			pw_change_password2 = true;
		}
	}
}
function pw_change_submit(forms) {
	pw_change_password_check(forms.password);
	pw_change_password2_check(forms.password2);
	
	if(
			!pw_change_password || 
			!pw_change_password2
	) {
		return false;
	}else{
		return true;
	}
	
}
function pw_change_ajax(forms) {
	if(pw_change_submit(forms) == true) {
		$.ajax({
			url:'pw_change_ajax.o',
			method:'POST',
			datatype : "json",
			data:{
				email:forms.email.value,
				name:forms.name.value,
				phone1:forms.phone1.value,
				phone2:forms.phone2.value,
				phone3:forms.phone3.value,
				quest:forms.quest.value,
				answer:forms.answer.value,
				password:forms.password.value,
				password2:forms.password2.value
			},
			success:function(result){
				if(result.result == false) {
					alert(result.msg);
				}else {
					alert("수정완료");
					hide2('pw_change_float_bg');
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}
function pw_change_show() {
	var htmls = "";
	
	htmls += '	<div class="write_hide" id="pw_change_float_bg" style="display:none;z-index:7000;">	';
	htmls += '	<div class="write_hide_scroll">	';
	htmls += '		';
	htmls += '	<div class="write_hide_scroll2s">	';
	htmls += '	<div class="review_write_box">	';
	htmls += '	<div style="overflow:hidden;">	';
	htmls += '	<div><h1 id="rc_h">비밀번호 변경</h1></div>	';
	htmls += '	</div>	';
	htmls += '	<div class="recruit_add_box_line" id="pw_change_result">	';
	htmls += '	<form id="pw_change_forms">	';
	htmls += '	<input type="hidden" name="email" />	';
	htmls += '	<input type="hidden" name="name" />	';
	htmls += '	<input type="hidden" name="phone1" />	';
	htmls += '	<input type="hidden" name="phone2" />	';
	htmls += '	<input type="hidden" name="phone3" />	';
	htmls += '	<input type="hidden" name="quest" />	';
	htmls += '	<input type="hidden" name="answer" />	';
	htmls += '	<input type="password" name="password" placeholder="비밀번호" class="login_input" onchange="pw_change_password_check(this);" />	';
	htmls += '	<div id="pw_change_password_msg" class="join_msg"></div>	';
	htmls += '	<input type="password" name="password2" placeholder="비밀번호 확인" class="login_input" onchange="pw_change_password2_check(this);" />	';
	htmls += '	<div id="pw_change_password2_msg" class="join_msg"></div>	';
	htmls += '	</form>	';
	htmls += '	</div>	';
	htmls += '		';
	htmls += '	<div class="review_write_box_line align-center" id="pw_change_btn">	';
	htmls += '	<input type="button" value="닫기" onclick="hide2(\'pw_change_float_bg\');" class="review_write_btn2" />	';
	htmls += '	<input type="button" value="비밀번호 변경" class="review_write_btn1" onclick="pw_change_ajax(document.getElementById(\'pw_change_forms\'));" />	';
	htmls += '	</div>	';
	htmls += '		';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';

	document.getElementById("pw_change_hidden").innerHTML = htmls;
	
	show2("pw_change_float_bg");
}
////////////////////////////////////////////////////









//회원탈퇴
function login_exit_ajax(forms) {
	$.ajax({
		url:'login_exit_ajax.o',
		method:'POST',
		datatype : "json",
		data:{
			password:forms.password.value,
			password2:forms.password2.value
		},
		success:function(result){
			if(result.result == false) {
				alert(result.msg);
			}else {
				alert("회원탈퇴 완료");
				hide2('login_exit_float_bg');
				logout_ajax(-99);
			}
		},
		error:function(r,s,e) {
			alert('통신에러');
		}
	});
}
function login_exit_show() {
	var htmls = "";
	
	htmls += '	<div class="write_hide" id="login_exit_float_bg" style="display:none;z-index:7000;">	';
	htmls += '	<div class="write_hide_scroll">	';
	htmls += '		';
	htmls += '	<div class="write_hide_scroll2s">	';
	htmls += '	<div class="review_write_box">	';
	htmls += '	<div style="overflow:hidden;">	';
	htmls += '	<div><h1 id="rc_h">회원탈퇴</h1></div>	';
	htmls += '	</div>	';
	htmls += '	<div class="recruit_add_box_line">	';
	htmls += '	<form id="login_exit_forms">	';
	htmls += '	<input type="password" name="password" placeholder="비밀번호" class="login_input" />	';
	htmls += '	<input type="password" name="password2" placeholder="비밀번호 확인" class="login_input" />	';
	htmls += '	</form>	';
	htmls += '	</div>	';
	htmls += '		';
	htmls += '	<div class="review_write_box_line align-center">	';
	htmls += '	<input type="button" value="닫기" onclick="hide2(\'login_exit_float_bg\');document.body.style.overflow=\'scroll\';" class="review_write_btn2" />	';
	htmls += '	<input type="button" value="회원탈퇴" class="review_write_btn1" style="background:#fc4b3d;border:1px solid #fc4b3d;" onclick="login_exit_ajax(document.getElementById(\'login_exit_forms\'));" />	';
	htmls += '	</div>	';
	htmls += '		';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';
	htmls += '	</div>	';

	document.getElementById("login_exit_hidden").innerHTML = htmls;
	
	show2("login_exit_float_bg");
}
////////////////////////////////////////////







//메인페이지 더보기/닫기
function best_more(best_scroll, best_scroll_bottom_bg, best_bottom_btn) {
	//스크롤 세로를 자동으로
	document.getElementById(best_scroll).style.height = "auto";
	//하얀 그라데이션 제거
	document.getElementById(best_scroll_bottom_bg).style.display = "none";
	
	var htmls = "";
	htmls += '<a href="#100" onclick="best_close(\''+best_scroll+'\',\''+best_scroll_bottom_bg+'\',\''+best_bottom_btn+'\')">닫기</a>';
	document.getElementById(best_bottom_btn).innerHTML = htmls;
	document.getElementById(best_bottom_btn).style.borderTop = "0px";
}
function best_close(best_scroll, best_scroll_bottom_bg, best_bottom_btn) {
	//스크롤 세로를 자동으로
	document.getElementById(best_scroll).style.height = "500px";
	//하얀 그라데이션 제거
	document.getElementById(best_scroll_bottom_bg).style.display = "";
	
	var htmls = "";
	htmls += '<a href="#100" onclick="best_more(\''+best_scroll+'\',\''+best_scroll_bottom_bg+'\',\''+best_bottom_btn+'\')">더보기</a>';
	document.getElementById(best_bottom_btn).innerHTML = htmls;
	document.getElementById(best_bottom_btn).style.borderTop = "1px solid #e6e6e6";
}
////////////////////////////////////////////












 function test() {
	$.ajax({
 		url:'test.o',
		method:'GET',
		datatype : "xml",
 		data:null
 		,
 		success:function(result){
 			var items = $(result).find("item");	//item 태그를 찾음
 			var length = $(items).length;		//item 태그의 개수를 찾음
 			var i = 0;
			var htmls = "";
			
			htmls += '<table border="1">';
 			for(i=0;i<length;i++) {
 				htmls += '<tr>';
 				htmls += '<td>';
 				htmls += $(items[i]).find("dutyEmcls").text();
 				htmls += '</td>';

 				htmls += '<td>';
 				htmls += $(items[i]).find("dutyName").text();
 				htmls += '</td>';

 				htmls += '<td>';
 				htmls += $(items[i]).find("dutyDivNam").text();
 				htmls += '</td>';

 				htmls += '<td>';
 				htmls += $(items[i]).find("dutyAddr").text();
 				htmls += '</td>';

 				htmls += '<td>';
 				htmls += $(items[i]).find("dutyTel1").text();
 				htmls += '</td>';
 				htmls += '</tr>';
 			}
			htmls += '</table>';
 			document.getElementById("testtest").innerHTML = htmls;	//testtest에 표시함
 			
 		},
 		error:function(r,s,e) {
 			alert('error');
 		}
 	});
} 


</script>
</head>
<body onload="recruit_view_load(${member_no}, ${recruit_no});setinitvar('${save_id_auths}');">
<!-- <input type="button" value="test" onclick="test();" />
<div id="testtest"></div> -->





<!-- 회원탈퇴 영역 -->
<div id="login_exit_hidden"></div>

<!-- 아이디찾기 영역 -->
<div id="email_find_hidden"></div>







<!-- 비밀번호찾기 영역 -->
<div id="pw_find_hidden"></div>



<!-- 비밀번호변경 영역 -->
<div id="pw_change_hidden"></div>




<!-- 회원수정 영역 -->
<div id="login_edit_hidden"></div>



<!-- 로그인영역 -->
<div id="login_forms_hidden"></div>



<!-- 회원가입 -->
<div class="write_hide" id="join_float_bg" style="display:none;">
<div class="write_hide_scroll">

	<div class="write_hide_scroll2s">
    <div class="review_write_box">
    	<ul class="join_t">
	      <li><a href="#" class="join_t_li_a_hover" id="join_btn_01" onclick="join_tab(this, false);">개인회원</a></li>
	      <li><a href="#" class="join_t_li_a" id="join_btn_02" onclick="join_tab(this, true);">기업회원</a></li>
	    </ul>
      <div style="overflow:hidden;">
      	<div style="width:50%;float:left;"><h1 id="rc_h">회원가입</h1></div>
      	<div style="width:50%;float:right;text-align:right;">
			<a href="#100" class="review_write_btn2" style="width:85%;" onclick="hide2('join_float_bg');document.body.style.overflow = 'scroll';">닫기</a>
		</div>
      </div>
      <div class="recruit_add_box_line">
	      <form id="join_forms" action="join_post.o" method="post" onsubmit="return join_submit(this)">
      	<input type="hidden" name="orders" value="1" class="login_input" id="join_orders" />
        <input type="text" name="email" placeholder="이메일 주소" class="login_input" onchange="email_check(this);" />
        <div id="email_msg" class="join_msg"></div>
        <input type="password" name="password" placeholder="비밀번호" class="login_input" onchange="password_check(this);" />
        <div id="password_msg" class="join_msg"></div>
        <input type="password" name="password2" placeholder="비밀번호 확인" class="login_input" onchange="password2_check(this);" />
        <div id="password2_msg" class="join_msg"></div>
        
        <div id="join_02" style="display:none;">
        	<br /><br />
	        <input type="text" name="company" placeholder="기업명" class="login_input" onchange="company_check(this);" />
	        <div id="company_msg" class="join_msg"></div>
	        <select name="company_cate" class="join_select" onchange="company_cate_check(this);">
	          <option value="-1">산업군</option>
	          <option value="1">서비스업</option>
	          <option value="2">제조/화학</option>
	          <option value="3">의료/제약/복지</option>
	          <option value="4">유통/무역/운송</option>
	          <option value="5">교육업</option>
	          <option value="6">건설업</option>
	          <option value="7">IT/웹/통신</option>
	          <option value="8">미디어/디자인</option>
	          <option value="9">은행/금융업</option>
	          <option value="10">기관/협회</option>
	        </select>
	        <div id="company_cate_msg" class="join_msg"></div>
	        <input type="text" name="company_num" placeholder="사업자등록번호" class="login_input" onchange="company_num_check(this);" />
	        <div id="company_num_msg" class="join_msg"></div>
	        <br /><br />
        </div>
        
        <input type="text" name="name" placeholder="이름" class="login_input" onchange="name_check(this);" />
        <div id="name_msg" class="join_msg"></div>
        <div class="join_phone" style="overflow:hidden;">
          <h4>전화번호</h4>
          <input type="text" name="phone1" placeholder="010" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="phone1_check(this);" />
          <div>-</div>
          <input type="text" name="phone2" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="phone2_check(this);" />
          <div>-</div>
          <input type="text" name="phone3" placeholder="0000" class="login_input" style="float:left;padding-left:10px;width:20%;" onchange="phone3_check(this);" />
        </div>
        <div id="phone_msg" class="join_msg"></div>
        <div class="join_quest">
          <h4>질문/답변</h4>
          <select name="quest" class="join_select" onchange="quest_check(this);">
  			<option value="-1">질문을 선택해 주세요.</option>
  			<option value="1">나의 아버지 이름은?</option>
  			<option value="2">내가 다니던 학교 이름은?</option>
  			<option value="3">나의 취미는?</option>
  			<option value="4">내가 좋아하던 게임은?</option>
  			<option value="5">나의 직업은?</option>
  			</select>
        	<div id="quest_msg" class="join_msg"></div>
  			<input type="text" name="answer" placeholder="답변" class="login_input" onchange="answer_check(this);" />
        	<div id="answer_msg" class="join_msg"></div>
        </div>
        <input type="button" value="회원가입" class="login_btn" onclick="join_ajax(document.getElementById('join_forms'));" />
      </form>
      </div>
    </div>
    </div>
</div>
</div>

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