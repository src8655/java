<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>회원가입</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function checkIt() {
	var userinput = eval("document.userinput");
	if(!userinput.id.value) {
		alert("ID를 입력하세요!");
		return false;
	}
	if(!userinput.passwd.value) {
		alert("비밀번호를 입력하세요!");
		return false;
	}
	if(userinput.passwd.value != userinput.passwd2.value) {
		alert("비밀번호가 같지 않아요");
		return false;
	}
	if(!userinput.jumin1.value || !userinput.jumin2.value) {
		alert("주민등록번호를 입력하세요.");
		return false;
	}
}
</script>
</head>
<body>

<div id="wrap">
	<form action="inputPro.jsp" name="userinput" onsubmit="return checkIt()" method="post">
		<h1>★회원가입★</h1>
		<div id="body">
			<table width="500px">
				<colgroup>
					<col width="20%" />
					<col width="*" />
				</colgroup>
				<tr>
					<th colspan="2" class="subTitle">*아이디 입력</th>
				</tr>
				<tr>
					<th>사용자 ID</th>
					<td>
						<input type="text" name="id" maxlength="12" />
						<input type="button" name="confirm_id" value="ID 중복확인" class="inputBtn" onclick="javascript:openConfirmid(this.form);" /> 
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="passwd" maxlength="12" /></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="passwd2" maxlength="12" /></td>
				</tr>
				<tr>
					<th colspan="2" class="subTitle">*개인정보 입력</th>
				</tr>
				<tr>
					<th>사용자 이름</th>
					<td><input type="text" name="name" maxlength="10" /></td>
				</tr>
				<tr>
					<th>주민등록 번호</th>
					<td>
						<input type="text" name="jumin" maxlength="6" /> - 
						<input type="password" name="jumin2" maxlength="7" />
					</td>
				</tr>
				<tr>
					<th>E-Mail</th>
					<td><input type="text" name="email" class="w300" maxlength="30" /></td>
				</tr>
				<tr>
					<th>Blog</th>
					<td><input type="text" name="blog" class="w300" maxlength="50" /></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td>
						<input type="text" name="zipcode" />
						<input type="button" value="우편번호 검색" class="inputBtn" onclick="javascript:zipCheck();" />
						<span>우편번호를 입력하세요.</span>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="address" class="w380" />
						<span class="descB">주소를 입력하세요.</span>
					</td>
				</tr>
				
			</table>
		</div>
		<div id="footer">
			<input type="submit" name="confirm" class="inputBtn" value="등 록" />
			<input type="reset" name="reset" class="inputBtn" value="다시입력" />
			<input type="button" class="inputBtn" value="취소" onclick="javascript:window.location='main.jsp'" />
		</div>
	</form>
</div>
</body>
</html>