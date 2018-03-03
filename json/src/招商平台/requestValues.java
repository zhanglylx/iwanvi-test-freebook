package 招商平台;

import java.util.HashMap;
import java.util.Map;

import Methods_summarize.转码;

public class requestValues {
	public static String request(HashMap<String, Object> parameter){
		String request = "";
		StringBuffer bull = new StringBuffer();
		for (Map.Entry<String, Object> s : parameter.entrySet()) { // 拼接字符串为form格式
			bull.append(s.getKey());
			bull.append("=");
			bull.append(转码.getURLEncoderString(s.getValue().toString()));
			bull.append("&");
		}
		if (bull.lastIndexOf("&") > -1) {// 去掉字符串尾椎的&
			request = bull.substring(0, bull.length() - 1);
		}	
		return request;
	}
}
