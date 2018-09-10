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


String data_no = request.getParameter("data_no");

if(request.getParameter("name").equals("")) {
	out.println("<script>");
	out.println("alert('이름을 입력하세요.')");
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
if(request.getParameter("memo").equals("")) {
	out.println("<script>");
	out.println("alert('내용을 입력하세요.')");
	out.println("history.go(-1)");
	out.println("</script>");
	
	return;
}


Comment_Data_Bean cdata = new Comment_Data_Bean();
cdata.setRt_no(Integer.parseInt(request.getParameter("rt_no")));
cdata.setData_no(Integer.parseInt(request.getParameter("data_no")));
cdata.setName(request.getParameter("name"));
cdata.setPasswords(request.getParameter("passwords"));
cdata.setMemo(request.getParameter("memo"));

//암호화
cdata.setPasswords(Md5Enc.getEncMD5(cdata.getPasswords().getBytes()));


Comment_DB_Bean manager = Comment_DB_Bean.getInstance();
manager.insert(cdata);


//댓글카운트갱신
Board_DB_Bean bdb = Board_DB_Bean.getInstance();
bdb.updateComment(Integer.parseInt(data_no));


request.setAttribute("data_no", data_no);
%>
<jsp:forward page="board_comment_post.jsp" />