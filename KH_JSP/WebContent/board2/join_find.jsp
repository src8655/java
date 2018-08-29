<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page import="java.util.*" %>
<%@ page import="board2.Addr_Data_Bean" %>
<%@ page import="board2.Addr_DB_Bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>우편번호 검색</title>
<script type="text/javascript">
//값 리턴해주기
function returnValue(num, addr){
	opener.btn_find_return(num, addr);	//결과를 리턴
	self.close();	//창닫기
}
</script>
</head>
<body style="font-size:12px;">
<%
//검색어를 받아온다.
String search = request.getParameter("search");
if(search == null) search = "";
%>
<form action="join_find.jsp" method="post">
<table cellpadding="10" cellspacing="0" border="0" 
style="width:100%;margin:0 0 10px 0;border-bottom:1px solid #676767;">
<col width="30%" />
<col width="70%" />
	<tr>
		<th>주소</th>
		<td>
			<input type="text" name="search" value="<%=search %>" />
			<input type="submit" value="검색하기" />
		</td>
	</tr>
</table>
</form>
<%
//검색값이 존재할때만
if(!search.equals("")) {
%>
<div style="width:100%;height:400px;overflow-y:scroll;">
<table cellpadding="5" cellspacing="0" border="1" 
style="width:100%;border-collapse:collapse;">
<col width="15%" />
<col width="15%" />
<col width="70%" />
<%
	Addr_DB_Bean adb = Addr_DB_Bean.getInstance();
	List list = adb.getArticles(search);
	for(int i=0;i<list.size();i++) {
		Addr_Data_Bean adata = (Addr_Data_Bean)list.get(i);
%>
	<tr>
		<th><input type="button" 
			onclick="returnValue('<%=adata.getZipcode() %>','<%=adata.getAddr1()+" "+adata.getAddr2()+" "+adata.getAddr3()+" "+adata.getAddr4() %>');" 
			value="선택" /></th>
		<th><%=adata.getZipcode() %></th>
		<td><%=adata.getAddr1()+" "+adata.getAddr2()+" "+adata.getAddr3()+" "+adata.getAddr4() %></td>
	</tr>
<% } %>
</table>
</div>
<% } %>
</body>
</html>