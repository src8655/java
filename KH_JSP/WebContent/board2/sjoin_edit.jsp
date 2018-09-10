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


Calendar cal = Calendar.getInstance();

//날짜 가져오기
int datey = cal.get(Calendar.YEAR);
int datem = cal.get(Calendar.MONTH)+1;
int dated = cal.get(Calendar.DATE);



request.setAttribute("datey", datey);
request.setAttribute("datem", datem);
request.setAttribute("dated", dated);

%>
<jsp:forward page="join_edit.jsp" />