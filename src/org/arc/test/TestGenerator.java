package org.arc.test;

import java.util.Date;

import org.junit.Test;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月29日 上午3:41:37
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
