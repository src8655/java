<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>문의내용 작성</title>
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
	opener.view_qna_write_result(result);	//결과를 리턴
	self.close();	//창닫기
}
</script>
</head>
<body>
  <div class="view_qna_write">
  	<div class="view_qna_write_h"><h1>문의내용 작성</h1></div>
  	<form action="view_qna_write_post.o" method="post" id="view_qna_write_form">
  		<input type="hidden" name="product_no" value="${no}" />
  		<input type="hidden" name="sellers_no" value="${sellers_no}" />
	  	<table cellspacing="0" cellpadding="5" border="0">
	  		<col width="100px" />
	  		<col width="500px" />
	  		<tr>
	  			<th style="border-top:1px solid #b9b9b9;">문의유형</th>
	  			<td style="border-top:1px solid #e7e7e7;">
	  				<input type="radio" name="category" value="1" id="category1" />
	  				<label for="category1">상품</label>
	  				<input type="radio" name="category" value="2" id="category2" />
	  				<label for="category2">배송</label>
	  				<input type="radio" name="category" value="3" id="category3" />
	  				<label for="category3">반품/취소</label>
	  				<input type="radio" name="category" value="4" id="category4" />
	  				<label for="category4">교환/변경</label>
	  				<input type="radio" name="category" value="5" id="category5" />
	  				<label for="category5">기타</label>
	  			</td>
	  		</tr>
	  		<tr>
	  			<th>내용</th>
	  			<td>
	  				<textarea name="memo"></textarea>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="2">
	  				<input type="checkbox" name="secret" value="1" id="secret" />
	  				<label for="secret">비밀글로 문의하기</label>
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