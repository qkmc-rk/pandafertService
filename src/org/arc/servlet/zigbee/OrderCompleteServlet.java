package org.arc.servlet.zigbee;

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
import org.arc.service.OrderService;
import org.arc.service.RecordService;
import org.arc.service.UserService;
import org.arc.service.impl.OrderServiceImpl;
import org.arc.service.impl.RecordServiceImpl;
import org.arc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class OrderCompleteServlet
 */
@WebServlet({ "/OrderCompleteServlet", "/completeorder" })
public class OrderCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService us = new UserServiceImpl();
	private OrderService os = new OrderServiceImpl();
	private RecordService rs = new RecordServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCompleteServlet() {
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
		String positiveResult = "{\"result\":\"true\"}";
		String negetiveResult = "{\"result\":\"false\"}";
		
		//��ȡ�������жϻ����ĺϷ���
		String machineToken = request.getParameter("machinetoken");
		String orderId = request.getParameter("orderid");
		String result = request.getParameter("result");
		
		//����ת��
		int orderIdInt = Integer.parseInt(orderId);
		int resultInt = Integer.parseInt(result);
		if(us.findToken(machineToken) == null){
			pw.write("{\"result\":\"false\"}");
			pw.close();
			return;
		}else{
			//���order,Ȼ����result��ϳ�record.
			Order order = os.querryOneOrderByOrderId(orderIdInt);
			Record record = new Record();
			record.setRecordNumber(order.getOrderNumber());
			record.setResult(resultInt);
			record.setFinishTime(new Date());
			record.setFertA(order.getFertA());
			record.setFertB(order.getFertB());
			record.setFertC(order.getFertC());
			//����record��ɾ��order��Ӧ��
			if(rs.saveOneRecord(record)){
				//ɾ��order
				if(os.deleteOrderByOrderId(order.getOrderId())){
					//���سɹ�
					pw.write(positiveResult);
				}else{
					pw.write(negetiveResult);
				}
			}else{
				pw.write(negetiveResult);
			}
		}
		pw.close();
	}
}
