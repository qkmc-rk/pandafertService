package org.arc.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.arc.entity.User;
import org.arc.service.UserService;
import org.arc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AadminLoginServlet
 */
@WebServlet({ "/AadminLoginServlet", "/adminlogin" })
public class AadminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String negetiveResult = "{\"result\":\"false\"}";
    
	UserService us = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AadminLoginServlet() {
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
		//request.getRequestDispatcher("/login").forward(request, response);
		//���Ȼ�ȡ�û���¼����Ϣ
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		//�����ݿ��в����û���Ϣ
		User user = us.getUserByUserAccount(username);
		//ȡ���û���������Ϣ
		if(user == null){
			request.getRequestDispatcher("/WEB-INF/admin/error.jsp").forward(request, response);
		}
		String userDbPassword = user.getuPassword();
		if(userDbPassword.equals(userpwd)){
			//����session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//��ת��jspҳ��
			request.getRequestDispatcher("/WEB-INF/admin/user.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/admin/error.jsp").forward(request, response);
		}
	}

}
