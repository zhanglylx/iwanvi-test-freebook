package 招商平台;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import Methods_summarize.转码;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class 查询首页信息 {
	static final String sit = "http://zseditor.sit.ffan.com/zseditor/homePage/q";
	static Map<String, List<String>> m = new HashMap<String, List<String>>();// 记录不合格的case，在case执行完成后打印
	static List<String> list = new LinkedList<String>();// 记录不合格的test集合

	public static void main(String[] args) {
		String test;
		HashMap<String, Object> mapTest = new HashMap<String, Object>();
		JSONObject json = new JSONObject();
		new reminder("请确认数据库中是否存在首页信息并根据测试用例进行更改");
		
		test = "库中不存在首页信息，提示成功，返回信息";
		json = response(mapTest, test);
		if (json != null && ("success".equals(json.get("message")) == false || json.containsKey("data") == false)) {
			listAddJson(test, json);
		}
		mapTest.clear();

		test = "库中存在首页信息，提示成功，返回信息";
		json = response(mapTest, test);
		if (json != null && ("success".equals(json.get("message")) == false || json.containsKey("data") == false)) {
			listAddJson(test, json);
		}
		try{
			
		json = JSONObject.fromObject(json.get("data"));
		Pattern pattern = Pattern.compile("[0-9]+"); // 使用正则表达式
		Matcher isNum = pattern.matcher(json.get("plazaId").toString());	
		if (json != null && (json.containsKey("plazaId") == false || isNum.matches()==false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("logoImageUrl") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("mainTitle") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("secondTitle") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("hintButtonTxt") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		pattern = Pattern.compile(".+"); // 使用正则表达式
		isNum = pattern.matcher(json.get("bgImageUrl").toString());
		if (json != null && (json.containsKey("bgImageUrl") == false || isNum.matches()==false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("rqCodeUrl") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("briefTitle") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("createTime") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("updateTime") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("briefContent") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		if (json != null && (json.containsKey("mediaUrlList") == false)) {
			listAddJson("缺少参数:"+test, json);
		}
		}catch (Exception e) {
			listAddJson("data中缺少参数:"+test, json);
		}
		mapTest.clear();

		 new printErr(list);

	}

	public static JSONObject response(HashMap<String, Object> parameter, String test) {
//		if (test.contains("=")) {
//		} else {
//			return null;
//		}
		String request=requestValues.request(parameter); 
		String response = get.sendGet(sit, request); // 发送请求
		System.out.println("request:" + request);
		JSONObject jsonObj = JSONObject.fromObject(response);// 接收请求
		list=checkStatus.checkStatus(response, test,list);	
		System.out.println(response);
		return jsonObj;

	}

	public static JSONObject dataResponse(HashMap<String, Object> parameter, String test) {
		JSONObject jsonObj = response(parameter, test);
		if (jsonObj == null) {
			return null;
		}

		@SuppressWarnings("unchecked")
		HashMap<String, Object> map = new HashMap<String, Object>(jsonObj);
		if (map.get("status").equals(200) == false) {
			System.out.println();
			return null;
		}
		jsonObj = JSONObject.fromObject(jsonObj.get("data"));// 处理请求
		System.out.println(jsonObj.toString());
		System.out.println();
		
		return jsonObj;
	}

	public static void listAddJson(String test, JSONObject json) {
		list.add("返回结果不正确:" + test + "   json:" + json.toString() + " 实际返回结果\n");
	}
	

}
