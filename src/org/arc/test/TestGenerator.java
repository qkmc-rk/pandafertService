package org.arc.test;

import java.util.Date;

import org.junit.Test;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��29�� ����3:41:37
 */
public class TestGenerator {

	@Test
	public void test() {
		int orderId = 5;
		Date date = new Date();
		String gened = "";
		gened += date.hashCode();
		gened += orderId;
		System.out.print(gened);
	}

}
