<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import = "java.util.*" %>



<%

%>
<div id="login_oo">
  <h1>LOGIN</h1>
  <form action="login_post.jsp">
	<input type="hidden" name="id" value="<%=id %>" />
	<input type="hidden" name="pages" value="<%=pages %>" />
  	<fieldset>
  		<legend>회원 로그인</legend>
  		<p class="login_oo_l">
				<label for="huiz">ID&nbsp;:</label>&nbsp;<input type="text" name="user_id" id="huiz" /><br />
				<label for="hpz">PW&nbsp;:</label>&nbsp;<input type="password" name="passwords" id="hpz" />
			</p>
  		<p class="login_oo_r">
				<input type="submit" value="LOGIN" id="login_bu_oo" />
			</p>
  			<p class="login_oo_b" style="text-align:center;">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<a id="kakao-login-btn"></a>
<a href="http://developers.kakao.com/logout"></a>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('http://localhost:8080');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        alert(JSON.stringify(authObj));
      },
      fail: function(err) {
         alert(JSON.stringify(err));
      }
    });
  //]]>
</script>
			</p>
		</fieldset>
	</form>
</div>

<%@ include file="foot.jsp" %>