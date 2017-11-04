package org.arc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��28�� ����5:40:52
 * @useable Desperated
 */
public class JdbcUtil {
	
	private static Connection conn = null;
	
	//��������Ҫ������ӻ�ȡ��ʹ�õ���ģʽ����֤����û�ʱ���ᷢ������
	public static Connection getConn(){
		try {
			//���ȼ�������
			Class.forName(ConstantSet.JDBC_DRIVER);
			//��ȡ����
			if(conn == null){
				conn = DriverManager.getConnection(ConstantSet.JDBC_URL
						, ConstantSet.DB_USER_NAME, ConstantSet.DB_USER_PWD);
			}
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("some problems with jdbc driver load or connection got");
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	 * �ر�����
	 * */
	public static void close(){
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("close conn with problem"); 
			e.printStackTrace();
		}
		conn = null;
	}
}
