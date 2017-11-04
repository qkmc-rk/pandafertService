package org.arc.servlet.appapi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.arc.entity.Token;
import org.arc.entity.User;
import org.arc.service.UserService;
import org.arc.service.impl.UserServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet({ "/UserInfoServlet", "/userinfo" })
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService us = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write("{\"result\":\"false\"}");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String negetiveResult = "{\"result\":\"false\"}";
		
		String toekenString = request.getParameter("token");
		
		if(us.findToken(toekenString) == null){
			pw.write(negetiveResult);
			pw.close();
			return;
		}else{
			//从服务器获取个人信息
			Token token = us.findToken(toekenString);
			int userId = 0;
			userId = token.getUserId();
			User user = us.getUserByUserId(userId);
			//将个人信息封装到json
			ObjectMapper mapper = new ObjectMapper();
			String userJson = mapper.writeValueAsString(user);
			//输出json
			pw.write(userJson);
		}
		pw.close();
	}

}
