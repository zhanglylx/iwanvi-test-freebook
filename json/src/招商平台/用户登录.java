package 招商平台;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Methods_summarize.转码;
import net.sf.json.JSONObject;

public class 用户登录 {
	static final String sit = "http://zseditor.sit.ffan.com/zseditor/user/v1/login";
	static Map<String, List<String>> m = new HashMap<String, List<String>>();// 记录不合格的case，在case执行完成后打印
	static List<String> list = new LinkedList<String>();// 记录不合格的test集合

	public static void main(String[] args) {
		String test;
		HashMap<String, Object> mapTest = new HashMap<String, Object>();
		JSONObject json = new JSONObject();
		test = "不添加参数直接访问URL，提示错误，返回错误信息";
		json = response(mapTest, test);
		if (json != null && (json.get("message").toString().contains("password:参数错误：密码不能为空") == false
				|| json.get("message").toString().contains("phone:参数错误：手机号不能为空") == false)) {
			listAddJson(test, json);
		}
		mapTest.clear();

		test = "填写phone,不填写的password，提示错误，返回错误信息";
		mapTest.put("phone", "152");
		json = response(mapTest, test);
		if (json != null && ("password:参数错误：密码不能为空".equals(json.get("message")) == false)) {
			listAddJson(test, json);
		}

		test = "填写password,不填写的phone，提示错误，返回错误信息";
		mapTest.clear();
		mapTest.put("password", "152");
		json = response(mapTest, test);

		if (json != null && ("phone:参数错误：手机号不能为空".equals(json.get("message").toString()) == false)) {
			listAddJson(test, json);
		}

		// 填写错误的用户名或密码
		test = "填写库中不存在的phone，提示错误，返回错误信息";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("password", "152");
		json = response(mapTest, test);
		if (json != null && "用户名或密码错误，请重新输入".equals(json.get("message")) == false) {
			listAddJson(test, json);
		}

		test = "填写正确的phone错误的密码，提示错误，返回错误信息";
		mapTest.put("phone", "17710893436");
		mapTest.put("password", "152");
		json = response(mapTest, test);
		if (json != null && "用户名或密码错误，请重新输入".equals(json.get("message")) == false) {
			listAddJson(test, json);
		}

		test = "填写正确的密码错误的phone，提示错误，返回错误信息";
		mapTest.put("phone", "17710893");
		mapTest.put("password", "96e79218965eb72c92a549dd5a330112");
		json = response(mapTest, test);
		if (json != null && "用户名或密码错误，请重新输入".equals(json.get("message")) == false) {
			listAddJson(test, json);
		}

		test = "填写错误的phone和密码，提示错误，返回错误信息";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("password", System.currentTimeMillis());
		json = response(mapTest, test);
		if (json != null && "用户名或密码错误，请重新输入".equals(json.get("message")) == false) {
			listAddJson(test, json);
		}

		test = "填写错误超长字符串的phone和密码，提示错误，返回错误信息";
		mapTest.put("phone", System.currentTimeMillis()
				+ "法师打发是分散的@#@#@￥%%%#￥#@#@#@Fdfafasfsadfsd #@@#@#@#@#5141541455f5asf5as4f1sad5f4adf1a5f1sadf1sadf4ads45f");
		mapTest.put("password", System.currentTimeMillis()
				+ "法师打发是分散的@#@#@￥%%%#￥#@#@#@Fdfafasfsadfsd #@@#@#@#@#5141541455f5asf5as4f1sad5f4adf1a5f1sadf1sadf4ads45f");
		json = response(mapTest, test);
		if (json != null && "用户名或密码错误，请重新输入".equals(json.get("message")) == false) {
			listAddJson(test, json);
		}

		// 填写正确的用户名和密码
		test = "填写正确的phone和密码，提示成功，返回用户信息";
		mapTest.put("phone", "17710893436");
		mapTest.put("password", "96e79218965eb72c92a549dd5a330112");
		json = dataResponse(mapTest, test);
		if (json != null && (json.containsKey("id") && json.containsKey("id") && json.containsKey("userName")
				&& json.containsKey("uuid") && json.containsKey("roleIds") && json.containsKey("status")
				&& json.containsKey("lastLogin") && json.containsKey("gmtCreate") && json.containsKey("gmtModified")
				&& json.containsKey("creatorUuid") && json.containsKey("creatorName") && json.containsKey("remark")
				&& json.containsKey("post"))) {
			Pattern pattern = Pattern.compile("[0-9]+"); // 使用正则表达式
			Matcher isNum = pattern.matcher(json.get("id").toString());
			String check = "格式检查不正确";
			if (isNum.matches() == false) {
				listAddJson(check + json.get("id"), json);
			}
			isNum = pattern.matcher(json.get("roleIds").toString());
			if (isNum.matches() == false) {
				listAddJson(check + json.get("roleIds"), json);
			}
			isNum = pattern.matcher(json.get("status").toString());
			if (isNum.matches() == false) {
				listAddJson(check + json.get("status"), json);
			}

			pattern = Pattern.compile(".+"); // 使用正则表达式
			isNum = pattern.matcher(json.get("userName").toString());
			if (isNum.matches() == false) {
				listAddJson(check + json.get("userName"), json);
			}
			isNum = pattern.matcher(json.get("uuid").toString());
			if (isNum.matches() == false) {
				listAddJson(check + json.get("uuid"), json);
			}
		} else {
			if (json != null) {
				listAddJson(test, json);
			}
		}

		 new printErr(list);

	}

	public static JSONObject response(HashMap<String, Object> parameter, String test) {
		// if (test.contains("=")) {
		// } else {
		// return null;
		// }
		String request=requestValues.request(parameter);
		String response = post.sendPost(sit, request); // 发送请求
		System.out.println("request:" + request);
		list = checkStatus.checkStatus(response, test, list);
		JSONObject jsonObj = JSONObject.fromObject(response);// 接收请求
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
		if ((parameter.get("phone").equals(jsonObj.get("phone"))) == false) {
			listAddJson(test, jsonObj);
		}
		System.out.println(jsonObj.toString());
		System.out.println();
		return jsonObj;
	}

	public static void listAddJson(String test, JSONObject json) {
		list.add("返回结果不正确:" + test + "   json:" + json.toString() + " 实际返回结果\n");
	}

}
