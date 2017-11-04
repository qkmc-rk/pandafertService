package org.arc.servlet.appapi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.arc.entity.User;
import org.arc.service.UserService;
import org.arc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet({ "/RegServlet", "/reg" })
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService us = new UserServiceImpl();
	
	String positiveResult = "{\"result\":\"true\"}";
	String negetiveResult = "{\"result\":\"false\"}";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write(negetiveResult);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		//��ȡǰ�˴��͹�����ע������ �п����ǿյ����� ��Ҫ�пմ���
		String neckname = request.getParameter("neckname");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String userphone = request.getParameter("userphone");
		String usermail = request.getParameter("usermail");
		
		int userPhoneInt = 0;
		try {
			userPhoneInt = Integer.parseInt(userphone);
		} catch (Exception e) {
			//�����ȡʧ��˵���û��Ƿ�����
			e.printStackTrace();
			pw.write(negetiveResult);
			return;
		}
		
		//�������һ�����ַ�����˵���û������Ƿ�����
		if((neckname.equals("") || neckname == null) ||
				username.equals("") || username == null ||
				neckname.equals("") || neckname == null ||
				userpwd.equals("") || userpwd == null ||
				userphone.equals("") || userphone == null ||
				usermail.equals("") || usermail == null){
			pw.write(negetiveResult);
			return;
		}
		//����ע�����
		User user = new User();
		user.setuNeckName(neckname);
		user.setuAccount(username);
		user.setuOldPwd("null");
		user.setuPassword(userpwd);
		user.setuPhone(userPhoneInt);
		user.setuMail(usermail);
		//����ע��
		if(us.saveUser(user)){
			//֪ͨ�ͻ��˲����ɹ�
			pw.write(positiveResult);
		}else{
			//ע��ʧ��
			pw.write(negetiveResult);
		}
		pw.close();
	}

}



