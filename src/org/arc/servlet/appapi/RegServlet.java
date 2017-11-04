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
		
		//获取前端穿送过来的注册数据 有可能是空的数据 需要判空处理
		String neckname = request.getParameter("neckname");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		String userphone = request.getParameter("userphone");
		String usermail = request.getParameter("usermail");
		
		int userPhoneInt = 0;
		try {
			userPhoneInt = Integer.parseInt(userphone);
		} catch (Exception e) {
			//号码获取失败说明用户非法操作
			e.printStackTrace();
			pw.write(negetiveResult);
			return;
		}
		
		//如果发现一个空字符串，说明用户在作非法请求
		if((neckname.equals("") || neckname == null) ||
				username.equals("") || username == null ||
				neckname.equals("") || neckname == null ||
				userpwd.equals("") || userpwd == null ||
				userphone.equals("") || userphone == null ||
				usermail.equals("") || usermail == null){
			pw.write(negetiveResult);
			return;
		}
		//进行注册服务
		User user = new User();
		user.setuNeckName(neckname);
		user.setuAccount(username);
		user.setuOldPwd("null");
		user.setuPassword(userpwd);
		user.setuPhone(userPhoneInt);
		user.setuMail(usermail);
		//马上注册
		if(us.saveUser(user)){
			//通知客户端操作成功
			pw.write(positiveResult);
		}else{
			//注册失败
			pw.write(negetiveResult);
		}
		pw.close();
	}

}



