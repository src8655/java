package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Admin_Member_Edit_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('로그인 해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() != 3) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		int no = Integer.parseInt(request.getParameter("no"));
		int orders = Integer.parseInt(request.getParameter("orders"));
		String company_number = "";
		String name = "";
		String user_pw = "";
		String user_pw2 = "";
		String email = "";
		String zipcode = "";
		String addr = "";
		String phone1 = "";
		String phone2 = "";
		String phone3 = "";
		String bank = "";
		String bank_num = "";

		if(request.getParameter("company_number") != null) company_number = request.getParameter("company_number");
		if(request.getParameter("name") != null) name = request.getParameter("name");
		if(request.getParameter("user_pw") != null) user_pw = request.getParameter("user_pw");
		if(request.getParameter("user_pw2") != null) user_pw2 = request.getParameter("user_pw2");
		if(request.getParameter("email") != null) email = request.getParameter("email");
		if(request.getParameter("zipcode") != null) zipcode = request.getParameter("zipcode");
		if(request.getParameter("addr") != null) addr = request.getParameter("addr");
		if(request.getParameter("phone1") != null) phone1 = request.getParameter("phone1");
		if(request.getParameter("phone2") != null) phone2 = request.getParameter("phone2");
		if(request.getParameter("phone3") != null) phone3 = request.getParameter("phone3");
		if(request.getParameter("bank") != null) bank = request.getParameter("bank");
		if(request.getParameter("bank_num") != null) bank_num = request.getParameter("bank_num");
		

		int quest = -1;
		String answer = "";

		if(request.getParameter("quest") != null)
			if(!request.getParameter("quest").equals(""))
				quest = Integer.parseInt(request.getParameter("quest"));
		if(request.getParameter("answer") != null)
			answer = request.getParameter("answer");

		if(quest == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('질문을 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(answer.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('답변을 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		
		//만약 비밀번호 둘중 하나라도 적혀있으면
		if(!user_pw.equals("") || !user_pw2.equals("")) {
			if(!user_pw.equals(user_pw2)) {
				//두 값이 다르면 경고
				response.getWriter().println("<script>");
				response.getWriter().println("alert('비밀번호가 다릅니다.')");
				response.getWriter().println("history.go(-1)");
				response.getWriter().println("</script>");
				
				return null;
			}
			user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		}
		
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setNo(no);
		mdata.setOrders(orders);
		mdata.setCompany_number(company_number);
		mdata.setName(name);
		mdata.setUser_pw(user_pw);
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setBank(bank);
		mdata.setBank_num(bank_num);
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		
		int res = 0;
		if(mdb.update(mdata)) res = 1;
		
		
		request.setAttribute("res", res);
		
		
		
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('수정 성공.')");
			response.getWriter().println("location.href='mypage_admin_member.o?pages="+pages+"';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('수정 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
		//return "mypage_admin_member_edit_post.jsp";
	}


}
