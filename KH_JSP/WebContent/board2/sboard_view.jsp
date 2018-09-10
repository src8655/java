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


Board_DB_Bean board_manager = Board_DB_Bean.getInstance();
int board_total = board_manager.getCount(id, searchs, searchs_value);	//총 개수


String no = request.getParameter("no");


//쿠키설정
Cookie_Bean cmanager = Cookie_Bean.getInstance();
cmanager.view_cookie(no, request, response);


//데이터받기
Board_DB_Bean manager = Board_DB_Bean.getInstance();
Board_Data_Bean bdb = manager.getArticle(Integer.parseInt(no));

//1이 아니라는 것은 이 글은 답글이라는것
String rt_no = no;
if(bdb.getRt_no() != 1)	rt_no = Integer.toString(bdb.getRt_no());

//멤버일 경우 댓글로 받기
String name_tmp = "";
String passwords_tmp = "";
if(member_info != null) {
	name_tmp = member_info.getName();
	passwords_tmp = member_info.getPasswords();
}


//댓글
Comment_DB_Bean cdb = Comment_DB_Bean.getInstance();
List list = cdb.getArticles(Integer.parseInt(no));
for(int i=0;i<list.size();i++) {
	Comment_Data_Bean data = (Comment_Data_Bean)list.get(i);
	String c_memos = data.getMemo().replaceAll("\n", "<br />");
	data.setMemo(c_memos);
	list.set(i, data);
}



request.setAttribute("no", no);
request.setAttribute("board_total", board_total);
request.setAttribute("bdb", bdb);
request.setAttribute("rt_no", rt_no);

request.setAttribute("list", list);
request.setAttribute("name_tmp", name_tmp);
request.setAttribute("passwords_tmp", passwords_tmp);




%>
<jsp:forward page="board_view.jsp" />