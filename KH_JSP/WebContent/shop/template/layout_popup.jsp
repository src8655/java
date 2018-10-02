<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:getAsString name="title" /></title>
<style type="text/css">
body {
margin:0px;
padding:0px;
}
.red_button {
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
.view_qna_write {
width:100%;
margin:0px;
padding:0px;
overflow:hidden;
}
.view_qna_write_h {
border:1px solid #ca0000;
background:#e12323;
height:32px;
margin:0px;
padding:0px;
overflow:hidden;
}
.view_qna_write_h h1 {
border:1px solid #e55151;
height:30px;
line-height:30px;
margin:0px;
padding:0 0 0 20px;
color:#ffffff;
font-size:13px;
font-family:'Arial';
overflow:hidden;
}
.view_qna_write table {
border-collapse:collapse;
margin:15px;
padding:0px;
}
.view_qna_write table tr th {
border-bottom:1px solid #b9b9b9;
border-right:1px solid #e7e7e7;
background:#f8f8f8;
font-size:12px;
color:#4d4d4d;
}
.view_qna_write table tr td {
border-bottom:1px solid #e7e7e7;
font-size:12px;
color:#4d4d4d;
}
.view_qna_write table tr td textarea {
border:1px solid #bbbbbb;
width:100%;
height:200px;
font-size:12px;
color:#4d4d4d;
}
.view_qna_write_b {
margin:0px;
padding:0px;
text-align:center;
overflow:hidden;
}
.view_qna_write_btn1 {
display:inline-block;
border-top:1px solid #ec2e2e;
border-right:1px solid #ec2e2e;
border-bottom:1px solid #cd2828;
border-left:1px solid #ec2e2e;
background:#f6f6f6;
width:62px;
height:24px;
line-height:24px;
font-size:12px;
color:#ea1717;
text-decoration:none;
font-family:'Arial';
}
.view_qna_write_btn2 {
display:inline-block;
border-top:1px solid #bdbdbd;
border-right:1px solid #bdbdbd;
border-bottom:1px solid #828282;
border-left:1px solid #bdbdbd;
background:#f3f3f3;
width:62px;
height:24px;
line-height:24px;
font-size:12px;
color:#4d4d4d;
text-decoration:none;
font-family:'Arial';
}
</style>
<script type="text/javascript">
//값 리턴해주기
function returnValue(result){
	opener.btn_check_return(result);	//결과를 리턴
	self.close();	//창닫기
}
function returnValue2(result){
	opener.view_qna_answer_result(result);	//결과를 리턴
	self.close();	//창닫기
}
function returnValue3(result){
	opener.view_qna_write_result(result);	//결과를 리턴
	self.close();	//창닫기
}
function returnValue4(result){
	opener.view_review_result(result);	//결과를 리턴
	self.close();	//창닫기
}


//리뷰별컨트롤
function view_review_star(var1) {
	var i;
	
	//모든별 흑백
	for(i=1;i<=5;i++) {
		document.getElementById("star_img"+i).setAttribute("src","./images/star_02.jpg");
	}
	//선택별까지 컬러
	for(i=1;i<=var1;i++) {
		document.getElementById("star_img"+i).setAttribute("src","./images/star_01.jpg");
	}
	document.getElementById("stars").value = var1;
}
</script>
</head>
<body>

<tiles:insertAttribute name="body" />

</body>
</html>