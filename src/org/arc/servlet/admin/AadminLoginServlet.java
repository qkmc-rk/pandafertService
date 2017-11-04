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
		//首先获取用户登录的信息
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		//在数据库中查找用户信息
		User user = us.getUserByUserAccount(username);
		//取出用户的密码信息
		if(user == null){
			request.getRequestDispatcher("/WEB-INF/admin/error.jsp").forward(request, response);
		}
		String userDbPassword = user.getuPassword();
		if(userDbPassword.equals(userpwd)){
			//保存session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//跳转到jsp页面
			request.getRequestDispatcher("/WEB-INF/admin/user.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/admin/error.jsp").forward(request, response);
		}
	}

}
