package org.arc.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.arc.service.OrderService;
import org.arc.service.RecordService;
import org.arc.service.UserService;
import org.arc.service.impl.OrderServiceImpl;
import org.arc.service.impl.RecordServiceImpl;
import org.arc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet({ "/DeleteServlet", "/delete" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String negetiveResult = "{\"result\":\"false\"}";
	String positiveResult = "{\"result\":\"true\"}";
	
	UserService us = new UserServiceImpl();
	OrderService os = new OrderServiceImpl();
	RecordService rs = new RecordServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
			int id = Integer.parseInt(request.getParameter("userid"));
			if(us.deleteUserById(id))
				pw.write(positiveResult);
			else
				pw.write(negetiveResult);
		}else if(type.equals("token")){
			int id = Integer.parseInt(request.getParameter("tokenid"));
			if(us.deleteTokenById(id))
				pw.write(positiveResult);
			else
				pw.write(negetiveResult);
		}else if(type.equals("order")){
			int id = Integer.parseInt(request.getParameter("orderid"));
			
			if(os.deleteOrderByOrderId(id))
				pw.write(positiveResult);
			else
				pw.write(negetiveResult);
		}else if(type.equals("record")){
			int id = Integer.parseInt(request.getParameter("recordid"));
			
			if(rs.deleteOneRecordById(id))
				pw.write(positiveResult);
			else
				pw.write(negetiveResult);
		}else{
			pw.write(negetiveResult);
		}
		pw.close();
	}

}
