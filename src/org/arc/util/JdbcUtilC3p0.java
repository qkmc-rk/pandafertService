package org.arc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 上午11:18:42
 */
public class JdbcUtilC3p0 {
	
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	
	//返回链接
	public static Connection getConn(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//返回连接池对象
	public static DataSource getDataSource(){
		return ds;
	}
}
