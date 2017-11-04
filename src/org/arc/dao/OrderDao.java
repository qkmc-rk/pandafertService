package org.arc.dao;

import java.util.List;

import org.arc.entity.Order;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��28�� ����5:27:58
 */
public interface OrderDao {
	
	int addOneOrder(Order order);
	
	int deleteOrderByOrderId(int orderId);
	
	Order queryOneOrderByOrderId(int orderId);
	
	Order queryOneOrderByOrderNumber(int orderNumber);
	
	List<Order> querryAll();

	int updateOneOrder(Order order);
	
}