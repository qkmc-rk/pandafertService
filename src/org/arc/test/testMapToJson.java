package org.arc.test;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.arc.util.MapToJson;
import org.junit.Test;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��30�� ����1:08:12
 */
public class testMapToJson {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void m1(){
		Map<String ,String> map = new HashMap<>();
		/*map.put("ruankun", "18��");
		map.put("niejiao", "18��");
		map.put("ruanyun", "1��");*/
		map.put("result", "false");
		//MapToJson mtj = new MapToJson();
		System.out.println(MapToJson.mapToJson(map));
	}
}
