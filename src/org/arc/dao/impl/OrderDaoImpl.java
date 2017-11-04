package org.arc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.arc.dao.OrderDao;
import org.arc.entity.Order;
import org.arc.util.JdbcUtilC3p0;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 下午12:56:23
 */
public class OrderDaoImpl implements OrderDao{

	@Override
	public int addOneOrder(Order order) {
		//创建qr对象
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		//准备sql
		String sql = "insert into t_order(order_number,cre_time,fert_a,fert_b,fert_c,cre_person_id)"
				+ "values(?,?,?,?,?,?)";
		try {
			int update = qr.update(sql, order.getOrderNumber(), order.getCreTime(), order.getFertA()
					, order.getFertB(), order.getFertC(), order.getCrePersonId());
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteOrderByOrderId(int orderId) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "delete from t_order where order_id = ?";
		try {
			int update = qr.update(sql, orderId);
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Order queryOneOrderByOrderId(int orderId) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_order where order_id = ?";
		try {
			List<Order> orderlist = qr.query(sql, new OrderHandler(),orderId);
			Order order = orderlist.get(0);
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order queryOneOrderByOrderNumber(int orderNumber) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_order where order_number = ?";
		try {
			List<Order> orderlist = qr.query(sql, new OrderHandler(),orderNumber);
			Order order = orderlist.get(0);
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> querryAll() {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "select * from t_order";
		try {
			List<Order> orderlist = qr.query(sql, new OrderHandler());
			return orderlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateOneOrder(Order order) {
		QueryRunner qr = new QueryRunner(JdbcUtilC3p0.getDataSource());
		String sql = "update t_order set order_number = ? ,fert_a = ? ,fert_b = ? ,fert_c = ? ,cre_person_id = ? where order_id = ?";
		try {
			int result = qr.update(sql, order.getOrderNumber(), order.getFertA(), order.getFertB(), order.getFertC(), order.getCrePersonId(), order.getOrderId());
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
