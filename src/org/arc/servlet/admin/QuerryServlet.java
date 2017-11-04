package org.arc.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class QuerryServlet
 */
@WebServlet({ "/QuerryServlet", "/querry" })
public class QuerryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String negetiveResult = "{\"result\":\"false\"}";
	
	UserService us = new UserServiceImpl();
	OrderService os = new OrderServiceImpl();
	RecordService rs = new RecordServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuerryServlet() {
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
		String type = request.getParameter("type");
		
		if(type.equals("user")){
			List<User> users = us.querryAllUsers();
			
			ObjectMapper mapper = new ObjectMapper();
			String usersJson = mapper.writeValueAsString(users);
			pw.write(usersJson);
		}else if(type.equals("token")){
			List<Token> tokens = us.querryAllToken();
			
			ObjectMapper mapper = new ObjectMapper();
			String tokensJson = mapper.writeValueAsString(tokens);
			pw.write(tokensJson);
		}else if(type.equals("order")){
			List<Order> orders = os.querryAllOrders();
			
			ObjectMapper mapper = new ObjectMapper();
			String ordersJson = mapper.writeValueAsString(orders);
			pw.write(ordersJson);
		}else if(type.equals("record")){
			List<Record> records = rs.getAllRecords();
			
			ObjectMapper mapper = new ObjectMapper();
			String recordsJson = mapper.writeValueAsString(records);
			pw.write(recordsJson);
		}else{
			pw.write(negetiveResult);
		}
		pw.close();
		
	}

}





