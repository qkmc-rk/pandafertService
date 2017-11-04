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
		//���Ȼ�ȡtoken�ж��û��Ƿ�Ƿ�
		String toekenString = request.getParameter("token");
		if(us.findToken(toekenString) == null){
			pw.write(negetiveResult);
			pw.close();
			return;
		}else{
			//�������е�order��Ϣ
			List<Order> orderList = os.querryAllOrders();
			//��order��Ϣ��װ��json�ַ���
			ObjectMapper mapper = new ObjectMapper();
			String ordersJson = mapper.writeValueAsString(orderList);
			//����json�ַ���
			pw.write(ordersJson);
		}
		pw.close();
	}

}



