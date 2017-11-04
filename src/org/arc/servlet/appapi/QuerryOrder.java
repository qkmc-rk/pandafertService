package org.arc.servlet.appapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.arc.entity.Order;
import org.arc.service.OrderService;
import org.arc.service.UserService;
import org.arc.service.impl.OrderServiceImpl;
import org.arc.service.impl.UserServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class QuerryOrder
 */
@WebServlet({ "/QuerryOrder", "/querryorder" })
public class QuerryOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderService os = new OrderServiceImpl();
	private UserService us = new UserServiceImpl();
	
	String negetiveResult = "{\"result\":\"false\"}";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuerryOrder() {
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
		//首先获取token判断用户是否非法
		String toekenString = request.getParameter("token");
		if(us.findToken(toekenString) == null){
			pw.write(negetiveResult);
			pw.close();
			return;
		}else{
			//查找所有的order信息
			List<Order> orderList = os.querryAllOrders();
			//将order信息封装成json字符串
			ObjectMapper mapper = new ObjectMapper();
			String ordersJson = mapper.writeValueAsString(orderList);
			//返回json字符串
			pw.write(ordersJson);
		}
		pw.close();
	}

}



