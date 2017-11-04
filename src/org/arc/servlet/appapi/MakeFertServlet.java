package org.arc.servlet.appapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.arc.entity.Order;
import org.arc.entity.Token;
import org.arc.service.OrderService;
import org.arc.service.UserService;
import org.arc.service.impl.OrderServiceImpl;
import org.arc.service.impl.UserServiceImpl;
import org.arc.util.OrderNumberGenerator;

/**
 * Servlet implementation class MakeFertServlet
 */
@WebServlet({ "/MakeFertServlet", "/makefert" })
public class MakeFertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService us = new UserServiceImpl();
	private OrderService os = new OrderServiceImpl();
	
	String positiveResult = "{\"result\":\"true\"}";
	String negetiveResult = "{\"result\":\"false\"}";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeFertServlet() {
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
		//��ȡ4������ token fertabc
		String token = request.getParameter("token");
		String ferta = request.getParameter("ferta");
		String fertb = request.getParameter("fertb");
		String fertc = request.getParameter("fertc");
		int fertaInt = 0;
		int fertbInt = 0;
		int fertcInt = 0;
		//����ת��
		try {
			fertaInt = Integer.parseInt(ferta);
			fertbInt = Integer.parseInt(fertb);
			fertcInt = Integer.parseInt(fertc);
		} catch (Exception e) {
			e.printStackTrace();
			pw.print(negetiveResult);
			pw.close();
			return;
		}
		//�Բ��������пմ�������ǿյģ����ǷǷ�����
		if(token == null || token.equals("") ||
				ferta == null || ferta.equals("") ||
				fertb == null || fertb.equals("") ||
				fertc == null || fertc.equals("")){
			pw.write(negetiveResult);
			return;
		}
		//�ж�token�Ϸ�
		Token t = us.findToken(token);
		if(t != null){
			//���ɶ���
			int orderNumber = OrderNumberGenerator.generate(new Date());
			Order order = new Order();
			order.setCrePersonId(t.getUserId());
			order.setCreTime(new Date());
			order.setFertA(fertaInt);
			order.setFertB(fertbInt);
			order.setFertC(fertcInt);
			order.setOrderNumber(orderNumber);
			//�洢����
			if(os.saveOrder(order)){
				pw.write(positiveResult);
			}else{
				pw.write(negetiveResult);
			}
		}
		pw.close();
	}

}
