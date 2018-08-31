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
		</fieldset>
	</form>
</div>

<%@ include file="foot.jsp" %>