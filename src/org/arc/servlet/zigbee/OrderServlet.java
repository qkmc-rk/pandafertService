package org.arc.servlet.zigbee;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class OrderServlet
 */
@WebServlet({ "/OrderServlet", "/machionquerryorder" })
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService us = new UserServiceImpl();
	private OrderService os = new OrderServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		String negetiveResult = "{\"result\":\"false\"}";
		//��ȡmachinetoken
		String machineToken = request.getParameter("machinetoken");
		//�жϻ��������Ƿ�Ϸ�
		if(us.findToken(machineToken) == null){
			pw.write(negetiveResult);
			pw.close();
			return;
		}else{
			//��ѯ�����ĵ�һ��
			Order order = os.querryAllOrders().get(0);
			//�����������ס��json����
			ObjectMapper mapper = new ObjectMapper();
			String orderJson = mapper.writeValueAsString(order);
			//��json����д��
			pw.write(orderJson);
		}
		pw.close();
	}
	
}
