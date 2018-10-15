package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Join_Edit_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
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

		int quest = -1;
		String answer = "";

		if(request.getParameter("quest") != null)
			if(!request.getParameter("quest").equals(""))
				quest = Integer.parseInt(request.getParameter("quest"));
		if(request.getParameter("answer") != null)
			answer = request.getParameter("answer");
		
		
		if(member_info.getOrders() == 2 && company_number.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('����ڵ�Ϲ�ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() == 2 && bank.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�Ա������� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() == 2 && bank_num.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���¹�ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(name.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�̸��� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		if(!user_pw.equals(user_pw2) && (!user_pw.equals("") || !user_pw2.equals(""))) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('��й�ȣ�� �ٸ��ϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		if(email.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�̸����� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(zipcode.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�����ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(addr.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�ּҸ� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone1.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('��ȭ��ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone2.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('��ȭ��ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone3.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('��ȭ��ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		if(quest == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('������ �Է����ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(answer.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�亯�� �Է����ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setCompany_number(company_number);
		mdata.setName(name);
		mdata.setUser_id(member_info.getUser_id());
		if(!user_pw.equals("") || !user_pw2.equals(""))
			mdata.setUser_pw(Md5Enc.getEncMD5(user_pw.getBytes()));
		else mdata.setUser_pw("");
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setOrders(member_info.getOrders());
		mdata.setBank(bank);
		mdata.setBank_num(bank_num);
		mdata.setNo(member_info.getNo());
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		
		int res = 0;	//1���� 0����
		if(mdb.update(mdata)) res = 1;

		if(res == 1) {
			//��й�ȣ ������ ������ ��α���
			if(!user_pw.equals("") || !user_pw2.equals("")) {
				session.setAttribute("user_pw", mdata.getUser_pw());
			}
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���� ����.')");
			response.getWriter().println("location.href='index.o';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���� ����.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");

			return null;
		}
		
		return null;
	}


}
