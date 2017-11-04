package org.arc.util;

import java.util.Map;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version ����ʱ�䣺2017��10��30�� ����1:00:37
 * @Test {"ruankun":"18��","ruanyun":"1��","niejiao":"18��"}
 */
public class MapToJson {
	
	public static String mapToJson(Map<String,String> map){
		String json = "{";
		for(Map.Entry<String, String>m :map.entrySet()){
			json += "\"" + m.getKey() + "\":\"" + m.getValue() + "\",";
		}
		json = json.substring(0,json.length()-1);
		json += "}";
		return json;
	}
}
