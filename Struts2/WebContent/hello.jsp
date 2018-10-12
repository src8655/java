<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form action="/Struts2/hello.action">
	Input Your Name : <input type="text" name="name" value="${msg}" />
	<input type="submit" />
</form>
</body>
</html>