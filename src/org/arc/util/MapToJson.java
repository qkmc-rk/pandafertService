package org.arc.util;

import java.util.Map;

/**
 * @author Mrruan  E-mail:qkmc@outlook.com
 * @version 创建时间：2017年10月30日 下午1:00:37
 * @Test {"ruankun":"18岁","ruanyun":"1岁","niejiao":"18岁"}
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
