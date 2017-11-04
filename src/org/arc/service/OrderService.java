package org.arc.service;

import java.util.List;

import org.arc.entity.Order;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��30�� ����4:28:50
 */
public interface OrderService {
	
	boolean saveOrder(Order order);
	
	boolean deleteOrderByOrderId(int orderId);
	
	boolean updateOrder(Order order);
	
	List<Order> querryAllOrders();
	
	Order querryOneOrderByOrderId(int orderId);
	
}
