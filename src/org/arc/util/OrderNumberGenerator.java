package org.arc.util;

import java.util.Date;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��28�� ����6:15:03
 */
public class OrderNumberGenerator {
	
	/*
	 * @ method generate a long number
	 * @ return a long number as a orderNumber
	 * */
	public static int generate(Date date){
		int gened = 0;
		gened += date.hashCode(); 
		gened = Math.abs(gened);
		return gened;
	}
}
