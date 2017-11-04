package org.arc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.arc.entity.Order;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 下午12:57:51
 */
public class OrderHandler implements ResultSetHandler<List<Order>> {

	@Override
	public List<Order> handle(ResultSet rs) throws SQLException {
		List<Order> orderList= new ArrayList<>();
		Order order;
		while(rs.next()){
			order = new Order();
			order.setOrderId(rs.getInt(1));
			order.setOrderNumber(rs.getInt(2));
			order.setCreTime(rs.getDate(3));
			order.setFertA(rs.getInt(4));
			order.setFertB(rs.getInt(5));
			order.setFertC(rs.getInt(6));
			order.setCrePersonId(rs.getInt(7));
			orderList.add(order);
			order = null;
		}
		return orderList;
	}

}
