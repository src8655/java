package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Join_Write_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int order = Integer.parseInt(request.getParameter("order"));
		String company_number = request.getParameter("company_number");
		String bank = request.getParameter("bank");
		String bank_num = request.getParameter("bank_num");
		String name = request.getParameter("name");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_pw2 = request.getParameter("user_pw2");
		String email = request.getParameter("email");
		String zipcode = request.getParameter("zipcode");
		String addr = request.getParameter("addr");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		
		if(order == 2 && company_number.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('사업자등록번호를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(order == 2 && bank.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('입금은행을 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(order == 2 && bank_num.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('계좌번호를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(name.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이름을 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(user_id.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('아이디를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(user_pw.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(user_pw2.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호 확인을 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(!user_pw.equals(user_pw2)) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호가 다릅니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(email.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이메일을 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(zipcode.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('우편번호를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(addr.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('주소를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone1.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('전화번호를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone2.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('전화번호를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone3.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('전화번호를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		int count = mdb.selectId(user_id);
		if(count != 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이미 존재하는 아이디입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setCompany_number(company_number);
		mdata.setName(name);
		mdata.setUser_id(user_id);
		mdata.setUser_pw(Md5Enc.getEncMD5(user_pw.getBytes()));
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setOrders(order);
		mdata.setBank(bank);
		mdata.setBank_num(bank_num);
		
		int res = 0;	//1성공 0실패
		if(mdb.insert(mdata)) res = 1;

		request.setAttribute("res", res);
		request.setAttribute("name", name);
		request.setAttribute("order", order);
		
		return "join_write_post.tiles";
	}


}
