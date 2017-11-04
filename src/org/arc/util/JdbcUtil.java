package org.arc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月28日 下午5:40:52
 * @useable Desperated
 */
public class JdbcUtil {
	
	private static Connection conn = null;
	
	//工具类需要完成链接获取，使用单例模式，保证多个用户时不会发生错误
	public static Connection getConn(){
		try {
			//首先加载驱动
			Class.forName(ConstantSet.JDBC_DRIVER);
			//获取链接
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
	 * 关闭链接
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
