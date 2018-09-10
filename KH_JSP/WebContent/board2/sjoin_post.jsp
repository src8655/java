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

if(request.getParameter("user_id").equals("")) {
	out.println("<script>");
	out.println("alert('아이디를 입력하세요.')");
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
if(request.getParameter("passwords2").equals("")) {
	out.println("<script>");
	out.println("alert('비밀번호 확인을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}
if(!request.getParameter("passwords").equals(request.getParameter("passwords2"))) {
	out.println("<script>");
	out.println("alert('비밀번호가 다릅니다.')");
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


//중복확인된 아이디인지 확인
Member_DB_Bean mdb = Member_DB_Bean.getInstance();
int count = mdb.selectId(mdata.getUser_id());
	
if(count != 0) {
	out.println("<script>");
	out.println("alert('이미 존재하는 아이디 입니다.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}

//암호화
mdata.setPasswords(Md5Enc.getEncMD5(mdata.getPasswords().getBytes()));

Member_DB_Bean manager = Member_DB_Bean.getInstance();
manager.insert(mdata);

%>
<jsp:forward page="join_post.jsp" />