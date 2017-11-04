package org.arc.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.arc.entity.Order;
import org.arc.entity.Record;
import org.arc.entity.Token;
import org.arc.entity.User;
import org.arc.service.OrderService;
import org.arc.service.RecordService;
import org.arc.service.UserService;
import org.arc.service.impl.OrderServiceImpl;
import org.arc.service.impl.RecordServiceImpl;
import org.arc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet({ "/AddServlet", "/add" })
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String negetiveResult = "{\"result\":\"false\"}";
	String positiveResult = "{\"result\":\"true\"}";
	
	UserService us = new UserServiceImpl();
	OrderService os = new OrderServiceImpl();
	RecordService rs = new RecordServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		//根据type判断要增加的类型
		String type = request.getParameter("type");
		if(type.equals("user")){
			//获取用户信息
			String userNeckName = request.getParameter("userneckname");
			String userAccount = request.getParameter("useraccount");
			String userPassword = request.getParameter("userpassword");
			String userOldPwd = request.getParameter("useroldpwd");
			int userPhone = Integer.parseInt(request.getParameter("userphone"));
			String userMail = request.getParameter("usermail");
			
			User user = new User();
			user.setuAccount(userAccount);
			user.setuNeckName(userNeckName);
			user.setuOldPwd(userOldPwd);
			user.setuPassword(userPassword);
			user.setuPhone(userPhone);
			user.setuMail(userMail);
			
			if(us.saveUser(user)){
				pw.write(positiveResult);
			}else{
				pw.write(negetiveResult);
			}
		}else if(type.equals("token")){
			String tokenNum = request.getParameter("token");
			int userId = Integer.parseInt(request.getParameter("userid"));
			
			Token token = new Token();
			token.setToken(tokenNum);
			token.setUserId(userId);
			
			if(us.saveToken(token)){
				pw.write(positiveResult);
			}else{
				pw.write(negetiveResult);
			}
		}else if(type.equals("order")){
			int orderNumber = Integer.parseInt(request.getParameter("ordernumber"));
			int fertA = Integer.parseInt(request.getParameter("ferta"));
			int fertB = Integer.parseInt(request.getParameter("fertb"));
			int fertC = Integer.parseInt(request.getParameter("fertc"));
			int crePersonId = Integer.parseInt(request.getParameter("crepersonid"));

			//创建时间不做修改
			Order order = new Order();
			order.setCrePersonId(crePersonId);
			order.setCreTime(new Date());
			order.setFertA(fertA);
			order.setFertB(fertB);
			order.setFertC(fertC);
			order.setOrderNumber(orderNumber);
			
			if(os.saveOrder(order)){
				pw.write(positiveResult);
			}else{
				pw.write(negetiveResult);
			}
		}else if(type.equals("record")){
			int recordNumber = Integer.parseInt(request.getParameter("recordnumber"));
			int result = Integer.parseInt(request.getParameter("result"));
			int fertA = Integer.parseInt(request.getParameter("ferta"));
			int fertB = Integer.parseInt(request.getParameter("fertb"));
			int fertC = Integer.parseInt(request.getParameter("fertc"));
			
			Record record = new Record();
			record.setRecordNumber(recordNumber);
			record.setFinishTime(new Date());
			record.setResult(result);
			record.setFertA(fertA);
			record.setFertB(fertB);
			record.setFertC(fertC);

			if(rs.saveOneRecord(record)){
				pw.write(positiveResult);
			}else{
				pw.write(negetiveResult);
			}
		}
		pw.close();
	}

}
