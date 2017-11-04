package org.arc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��29�� ����11:18:42
 */
public class JdbcUtilC3p0 {
	
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	//��������
	public static Connection getConn(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//�������ӳض���
	public static DataSource getDataSource(){
		return ds;
	}
}
