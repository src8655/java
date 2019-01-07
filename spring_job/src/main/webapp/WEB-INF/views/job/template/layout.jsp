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
function recruit_add_submit(var1) {
	rca_name_check(var1.name);
	rca_phone1_check(var1.phone1);
	rca_phone2_check(var1.phone2);
	rca_phone3_check(var1.phone3);
	rca_email_check(var1.email);
	rca_files1_check(var1.file1);
	
	if(!rca_name ||
			!rca_phone1 ||
			!rca_phone2 ||
			!rca_phone3 ||
			!rca_email ||
			!rca_files1){
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
	nav_btn1////dfsdf
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
			htmls += '	          ${cdata.info}	';
			htmls += '	        </p>	';
			htmls += '	        <table cellspacing="0" cellpadding="0" class="info_table">	';
			htmls += '	          <tr>	';
			htmls += '	            <th width="10%"><div style="width:60px;overflow:hidden;">대표</div></th>	';
			htmls += '	            <td width="40%">${cdata.name}</td>	';
			htmls += '	            <th width="10%"><div style="width:50px;overflow:hidden;">설립일</div></th>	';
			htmls += '	            <td width="40%">${cdata.founding}</td>	';
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
			
			document.getElementById("hitcount_bg").style.display = "";
			drawChart();
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
			
			if(result.memberInfo == null) {
				htmls += '    <div class="review_write">';
				htmls += '    	<a href="login.o">새로운리뷰 작성하기</a>';
				htmls += '    </div>';
			}else if(result.memberInfo.orders == 1) {
				htmls += '    <div class="review_write">';
				htmls += '    	<a href="#100" onclick="show2(\'review_write\');document.body.style.overflow = \'hidden\';">새로운리뷰 작성하기</a>';
				htmls += '    </div>';
			}
			
			
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
			
			document.getElementById('hitcount_bg').style.display='none';
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
			htmls += '<div class="write_hide" id="review_write" style="display:none;">';
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
			htmls += '	      <input type="button" value="닫기" onclick="hide2(\'review_write\');document.body.style.overflow = \'scroll\';" class="review_write_btn2" />';
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

			if(result.memberInfo == null) {
				htmls += '    <div class="review_write">';
				htmls += '    	<a href="login.o">새로운 연봉정보 작성하기</a>';
				htmls += '    </div>';
			}else if(result.memberInfo.orders == 1) {
				htmls += '    <div class="review_write">';
				htmls += '    	<a href="#100" onclick="show2(\'review_write\');document.body.style.overflow = \'hidden\';">새로운 연봉정보 작성하기</a>';
				htmls += '    </div>'
			}
			
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
			
			document.getElementById('hitcount_bg').style.display='none';
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
					income_ajax('+member_no+');
					alert('작성완료');
					document.body.style.overflow = 'scroll';
				}
			},
			error:function(r,s,e) {
				alert('통신에러');
			}
		});
	}
}
//////////////////////////////////////////


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