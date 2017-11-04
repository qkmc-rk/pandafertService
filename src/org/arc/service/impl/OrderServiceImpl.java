package org.arc.service.impl;

import java.util.List;

import org.arc.dao.OrderDao;
import org.arc.dao.impl.OrderDaoImpl;
import org.arc.entity.Order;
import org.arc.service.OrderService;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月30日 下午4:29:35
 */
public class OrderServiceImpl implements OrderService{

	OrderDao od = new OrderDaoImpl();
	
	@Override
	public boolean saveOrder(Order order) {
		if(od.addOneOrder(order) < 1)
			return false;
		return true;
	}

	@Override
	public List<Order> querryAllOrders() {
		List<Order> orders = od.querryAll();
		return orders;
	}

	@Override
	public Order querryOneOrderByOrderId(int orderId) {
		Order order = od.queryOneOrderByOrderId(orderId);
		return order;
	}

	@Override
	public boolean deleteOrderByOrderId(int orderId) {
		if(od.deleteOrderByOrderId(orderId) < 1)
			return false;
		return true;
	}

	@Override
	public boolean updateOrder(Order order) {
		int rs = od.updateOneOrder(order);
		if(rs < 1){
			return false;
		}
		return true;
	}

}
