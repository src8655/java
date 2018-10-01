<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>답글 작성</title>
<style type="text/css">
body {
margin:0px;
padding:0px;
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
	opener.view_qna_answer_result(result);	//결과를 리턴
	self.close();	//창닫기
}
</script>
</head>
<body>
  <div class="view_qna_write">
  	<div class="view_qna_write_h"><h1>답글 작성</h1></div>
  	<form action="view_qna_answer_post.o" method="post" id="view_qna_write_form">
  		<input type="hidden" name="product_no" value="${product_no}" />
  		<input type="hidden" name="pages" value="${pages}" />
  		<input type="hidden" name="no" value="${no}" />
	  	<table cellspacing="0" cellpadding="5" border="0">
	  		<col width="100px" />
	  		<col width="500px" />
	  		<tr>
	  			<th>답글</th>
	  			<td>
	  				<textarea name="memo"></textarea>
	  			</td>
	  		</tr>
	  	</table>
	  	<div class="view_qna_write_b">
	  		<a href="#10" class="view_qna_write_btn1" onclick="view_qna_write_form.submit();">등록</a>
	  		<a href="#10" class="view_qna_write_btn2" onclick="returnValue('0');">취소</a>
	  	</div>
  	</form>
  </div>
</body>
</html>