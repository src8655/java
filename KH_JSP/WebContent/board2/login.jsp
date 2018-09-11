<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head2.jsp" %>

<div id="login_oo">
  <h1>LOGIN</h1>
  <form action="login_post.do" id="logins">
	<input type="hidden" name="id" value="${id}" />
	<input type="hidden" name="pages" value="${pages}" />
	<input type="hidden" name="name" id="login_name" value="" />
	<input type="hidden" name="kakao" id="login_kakao" value="0" />
  	<fieldset>
  		<legend>회원 로그인</legend>
  		<p class="login_oo_l">
				<label for="huiz">ID&nbsp;:</label>&nbsp;<input type="text" name="user_id" id="huiz" value="${user_id}" /><br />
				<label for="hpz">PW&nbsp;:</label>&nbsp;<input type="password" name="passwords" id="hpz" />
			</p>
  		<p class="login_oo_r">
				<input type="submit" value="LOGIN" id="login_bu_oo" />
		</p>
		</fieldset>
  		<p class="login_oo_b" style="text-align:left;padding:0 0 0 38px;">
			<input type="checkbox" name="auto_id" value="1" id="auto_id" <c:if test="${user_id ne ''}">checked</c:if> /><label for="auto_id">아이디 저장</label>
		</p>
  		<p class="login_oo_b">
			<a id="kakao-login-btn"></a>
			<a href="http://developers.kakao.com/logout"></a>
		</p>
	</form>
</div>
<script type='text/javascript'>
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
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {

  			var token = JSON.stringify(authObj);
        	Kakao.Auth.setAccessToken(authObj.access_token);
    	  Kakao.API.request({
              url: '/v1/user/me',
              success: function(res) {
            	  var ids = res.id;
            	  var passwords = res.uuid;
            	  var names = res.properties.nickname;
            	  name.replaceAll("\"","");
            	  passwords.replaceAll("\"","");
            	  
                  document.getElementById("login_name").value = names;
                  document.getElementById("login_kakao").value = 1;
                  document.getElementById("huiz").value = ids;
                  document.getElementById("hpz").value = passwords;
                  document.getElementById("logins").submit();
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
  //]]>
</script>
<%@ include file="foot2.jsp" %>