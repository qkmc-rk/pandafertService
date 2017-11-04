package org.arc.servlet.appapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.arc.entity.Record;
import org.arc.service.RecordService;
import org.arc.service.UserService;
import org.arc.service.impl.RecordServiceImpl;
import org.arc.service.impl.UserServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class RecordServlet
 */
@WebServlet({ "/RecordServlet", "/record" })
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private UserService us = new UserServiceImpl();
	private RecordService rs = new RecordServiceImpl();
	
	String negetiveResult = "{\"result\":\"false\"}";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordServlet() {
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
		//ҵ����
		//�����ж��û��Ƿ�Ƿ�
		String toekenString = request.getParameter("token");
		if(us.findToken(toekenString) == null){
			pw.write(negetiveResult);
			pw.close();
			return;
		}else{
			//�Ϸ��û��õ�record��¼ ��ѯ����record��ֵ
			List<Record> recordList = rs.getAllRecords();
			//��recordֵת��Ϊjson
			ObjectMapper mapper = new ObjectMapper();
			String recordJson = mapper.writeValueAsString(recordList);
			//���ظ��ͻ���json����
			pw.write(recordJson);
		}
		pw.close();
	}

}
