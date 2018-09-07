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
////////////////////////////////////////////////////////////////


Board_DB_Bean board_manager = Board_DB_Bean.getInstance();
int board_total = board_manager.getCount(id, searchs, searchs_value);	//총 개수

request.setAttribute("board_total", board_total);


String rt_no = "1";
String subject = "";
if(request.getParameter("rt_no") != null) {
	rt_no = request.getParameter("rt_no");
	Board_DB_Bean bdb = Board_DB_Bean.getInstance();
	Board_Data_Bean bdata = bdb.getArticle(Integer.parseInt(rt_no));
	subject = bdata.getSubject();
}


String name_tmp = "";
String passwords_tmp = "";
if(member_info != null) {
	name_tmp = member_info.getName();
	passwords_tmp = member_info.getPasswords();
}




request.setAttribute("rt_no", rt_no);
request.setAttribute("subject", subject);
request.setAttribute("name_tmp", name_tmp);
request.setAttribute("passwords_tmp", passwords_tmp);

%>
<jsp:forward page="board_write.jsp" />