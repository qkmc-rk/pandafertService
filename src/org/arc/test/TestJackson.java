package org.arc.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.arc.entity.Order;
import org.arc.service.OrderService;
import org.arc.service.impl.OrderServiceImpl;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��30�� ����8:02:09
 */
public class TestJackson {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void m1(){
		OrderService os = new OrderServiceImpl();
		List<Order> orderList = os.querryAllOrders();
		//��order��Ϣ��װ��json�ַ���
		ObjectMapper mapper = new ObjectMapper();
		try {
			String ordersJson = mapper.writeValueAsString(orderList);
			System.out.println(ordersJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
