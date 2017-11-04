package org.arc.servlet.appapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.arc.entity.Token;
import org.arc.entity.User;
import org.arc.service.UserService;
import org.arc.service.impl.UserServiceImpl;
import org.arc.util.MapToJson;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		description = "loginReq", 
		urlPatterns = { 
				"/LoginServlet", 
				"/login"
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService us = new UserServiceImpl();
	
	String negetiveResult = "{\"result\":\"false\"}";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//首先获取用户登录的信息
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		System.out.println("username:"+username+"\n"+"userpwd"+ userpwd);
		//在数据库中查找用户信息
		User user = us.getUserByUserAccount(username);
		//取出用户的密码信息
		String userDbPassword = user.getuPassword();
		Map<String,String> jsonMap = new HashMap<>();
		String jsonResult = "";
		
		if(userDbPassword.equals(userpwd)){
			//登录成功
			//查找用户的token
			int userId = user.getuId();
			Token token = us.getTokenByUserId(userId);
			//返回登录成功和用户的token格式：json
			jsonMap.put("token", token.getToken());
			jsonMap.put("result", "true");
			jsonResult = MapToJson.mapToJson(jsonMap);
		}else{
			//登陆失败 直接返回result
			jsonMap.put("result", "false");
			jsonResult = MapToJson.mapToJson(jsonMap);
		}
		pw.write(jsonResult);
		pw.close();
	}

}






