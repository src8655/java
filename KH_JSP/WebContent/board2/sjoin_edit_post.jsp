<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.util.*" %>
<%@ page import = "board2.*" %>
<%
//공통으로 받는 파라미터
String id = "";
String pages = "1";
String searchs = "";
String searchs_value = "";

if(request.getParameter("id") != null)
	id = request.getParameter("id");
if(request.getParameter("pages") != null)
	pages = request.getParameter("pages");
if(request.getParameter("searchs") != null)			//검색
	searchs = request.getParameter("searchs");
if(request.getParameter("searchs_value") != null)	//검색어
	searchs_value = request.getParameter("searchs_value");



//Admin정보 불러오기
Admin_DB_Bean admin_manager = Admin_DB_Bean.getInstance();
Admin_Data_Bean adata = admin_manager.getArticle(id);

//로그인정보 불러오기
Member_DB_Bean mem_db = Member_DB_Bean.getInstance();
Member_Data_Bean member_info = mem_db.getLogin(session);

//공통
request.setAttribute("id", id);
request.setAttribute("pages", pages);
request.setAttribute("pages_int", Integer.parseInt(pages));
request.setAttribute("searchs", searchs);
request.setAttribute("searchs_value", searchs_value);

request.setAttribute("adata", adata);
request.setAttribute("member_info", member_info);
////////////////////////////////////////////////////////////////

//비로그인 접근금지
if(member_info == null) {
	out.println("<script>");
	out.println("alert('잘못된 접근입니다.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}

if(request.getParameter("passwords").equals("")) {
	out.println("<script>");
	out.println("alert('비밀번호를 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
if(request.getParameter("name").equals("")) {
	out.println("<script>");
	out.println("alert('이름을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
if(request.getParameter("email").equals("")) {
	out.println("<script>");
	out.println("alert('이메일을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}







Member_Data_Bean mdata = new Member_Data_Bean();
mdata.setUser_id(request.getParameter("user_id"));
mdata.setPasswords(request.getParameter("passwords"));
mdata.setName(request.getParameter("name"));
mdata.setEmail(request.getParameter("email"));
mdata.setBirthy(request.getParameter("birthy"));
mdata.setBirthm(request.getParameter("birthm"));
mdata.setBirthd(request.getParameter("birthd"));
mdata.setAddr_code(request.getParameter("addr_code"));
mdata.setAddr(request.getParameter("addr"));
mdata.setPhone1(request.getParameter("phone1"));
mdata.setPhone2(request.getParameter("phone2"));
mdata.setPhone3(request.getParameter("phone3"));
mdata.setKakao(Integer.parseInt(request.getParameter("kakao")));
mdata.setNo(Integer.parseInt(request.getParameter("no")));


//회원no전달

Member_DB_Bean manager = Member_DB_Bean.getInstance();

//성공시 1
int res = 0;
if(manager.update(mdata)) {
	res = 1;
}


request.setAttribute("res", res);
%>
<jsp:forward page="join_edit_post.jsp" />