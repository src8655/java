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



String no = request.getParameter("no");
String data_no = request.getParameter("data_no");



//멤버일 경우
String passwords_tmp = "";
if(member_info != null) {
	passwords_tmp = member_info.getPasswords();
}else{
	passwords_tmp = request.getParameter("passwords");
}


//암호화
passwords_tmp = Md5Enc.getEncMD5(passwords_tmp.getBytes());



int res = 0;	//성공인지 실패인지
Comment_DB_Bean cdb = Comment_DB_Bean.getInstance();
if(cdb.delete(Integer.parseInt(no), passwords_tmp)) {
	//댓글카운트갱신
	Board_DB_Bean bdb = Board_DB_Bean.getInstance();
	bdb.updateComment(Integer.parseInt(data_no));
	
	res = 1;
}




request.setAttribute("no", no);
request.setAttribute("data_no", data_no);
request.setAttribute("res", res);
%>
<jsp:forward page="board_comment_del_post.jsp" />