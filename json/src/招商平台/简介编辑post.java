package 招商平台;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class 简介编辑post {
	static final String sit = "http://zseditor.sit.ffan.com/zseditor/brief";
	static Map<String, List<String>> m = new HashMap<String, List<String>>();// 记录不合格的case，在case执行完成后打印
	static List<String> list = new LinkedList<String>();// 记录不合格的test集合
	public static void main(String[] args) {
		String test;
		HashMap<String, Object> mapTest = new HashMap<String, Object>();
		List<String> listFiles = new LinkedList<String>();
		JSONObject json = new JSONObject();
		test = "不添加参数直接访问URL，提示错误，返回错误信息";
		json = response(mapTest, test);
		if (json != null && ("服务错误".equals(json.get("message")) == false)) {
			listAddJson(test, json);
		}
		mapTest.clear();

		// key为空
		test = "briefTitle为KEY空，提示错误";
		mapTest.put("briefContent", "");
		json = response(mapTest, test);
		if (json != null && ("服务错误".equals(json.get("message")) == false)) {
			listAddJson(test, json);
		}

		mapTest.clear();
		test = "briefContent为KEY空，提示错误";
		mapTest.put("briefTitle", "");
		json = response(mapTest, test);
		if (json != null && ("服务错误".equals(json.get("message")) == false)) {
			listAddJson(test, json);
		}

		// values为空
		mapTest.clear();

		test = "briefTitle为空，提示成功";
		mapTest.put("briefTitle", "");
		mapTest.put("briefContent", "测试" + System.currentTimeMillis());
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("briefTitle").equals(json.get("briefTitle")) == false)) {
			listAddJson(test + "===", json);
		}

		test = "briefContent为空，提示成功";
		mapTest.put("briefTitle", "测试" + System.currentTimeMillis());
		mapTest.put("briefContent", "");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("briefContent").equals(json.get("briefContent")) == false)) {
			listAddJson(test, json);
		}

		// 修改正确参数

		test = "briefContent和briefTitle为正确值，提示成功";
		mapTest.put("briefTitle", "测试briefTitle" + System.currentTimeMillis());
		mapTest.put("briefContent", "测试briefContent" + System.currentTimeMillis());
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("briefTitle").equals(json.get("briefTitle")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("briefContent").equals(json.get("briefContent")) == false)) {
			listAddJson(test, json);
		}

		test = "files为单一正确值，提示成功";
		mapTest.put("briefTitle", "测试briefTitle" + System.currentTimeMillis());
		mapTest.put("briefContent", "测试briefContent" + System.currentTimeMillis());
		listFiles.add("https://www.hao123.com/" + System.currentTimeMillis());
		mapTest = map(mapTest, listFiles);
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("briefTitle").equals(json.get("briefTitle")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("briefContent").equals(json.get("briefContent")) == false)) {
			listAddJson(test, json);
		}
		checkFiles(listFiles, json);

		test = "files为多个正确值，提示成功";
		listFiles.clear();
		mapTest.put("briefTitle", "测试briefTitle" + System.currentTimeMillis());
		mapTest.put("briefContent", "测试briefContent" + System.currentTimeMillis());
		listFiles.add("https://www.hao123.com/" + System.currentTimeMillis());
		listFiles.add("http://wiki.ffan.biz/pages/viewpage.action?pageId=18909632" + System.currentTimeMillis());
		mapTest = map(mapTest, listFiles);
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("briefTitle").equals(json.get("briefTitle")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("briefContent").equals(json.get("briefContent")) == false)) {
			listAddJson(test, json);
		}
		checkFiles(listFiles, json);

		test = "files为空值，提示成功";
		listFiles.clear();
		mapTest.put("briefTitle", "测试briefTitle" + System.currentTimeMillis());
		mapTest.put("briefContent", "测试briefContent" + System.currentTimeMillis());
		listFiles.add("");
		mapTest = map(mapTest, listFiles);
		json = dataResponse(mapTest, test);
		if (json != null && ("[]".equals(json.get("mediaUrlList").toString()) == false)) {

			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("briefTitle").equals(json.get("briefTitle")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("briefContent").equals(json.get("briefContent")) == false)) {
			listAddJson(test, json);
		}

		test = "不上传files，库中值files清空，提示成功";
		listFiles.clear();
		mapTest.put("briefTitle", "测试briefTitle" + System.currentTimeMillis());
		mapTest.put("briefContent", "测试briefContent" + System.currentTimeMillis());
		listFiles.add("https://www.hao123.com/" + System.currentTimeMillis());
		mapTest = map(mapTest, listFiles);
		json = dataResponse(mapTest, test);
		mapTest.clear();
		mapTest.put("briefTitle", "测试briefTitle" + System.currentTimeMillis());
		mapTest.put("briefContent", "测试briefContent" + System.currentTimeMillis());
		json = dataResponse(mapTest, test);
		if (json != null && ("[]".equals(json.get("mediaUrlList").toString()) == false)) {
			listAddJson(test, json);
		}

		test = "所有参数为超长字符串，提示成功=";
		listFiles.clear();
		mapTest.put("briefTitle",
				"测试briefTitle" + System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis());
		mapTest.put("briefContent",
				"测试briefContent" + System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis());
		listFiles.add("https://www.hao123.com/" + System.currentTimeMillis() + System.currentTimeMillis()
				+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
				+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
				+ System.currentTimeMillis());
		listFiles.add("http://wiki.ffan.biz/pages/viewpage.action?pageId=18909632" + System.currentTimeMillis()
				+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
				+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis());
		listFiles.add(
				"http://wiki.ffan.biz/pages#@#@#aerea啊发放/viewpage.action?pageId=18909632" + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis());
		listFiles.add(
				"http://wiki.ffan.biz/pages#@#@#aerea啊发放/viewpage.action?pageId=18909632" + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis());
		listFiles.add(
				"http://wiki.ffan.biz/pages#@#@#aerea啊发放/viewpage.action?pageId=18909632" + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis());
		listFiles.add(
				"http://wiki.ffan.biz/pages#@#@#aerea啊发放/viewpage.action?pageId=18909632" + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis()
						+ System.currentTimeMillis() + System.currentTimeMillis() + System.currentTimeMillis());
		mapTest = map(mapTest, listFiles);
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("briefTitle").equals(json.get("briefTitle")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("briefContent").equals(json.get("briefContent")) == false)) {
			listAddJson(test, json);
		}
		checkFiles(listFiles, json);
		json = response(mapTest, test);
		checkForm(json, test);

		 new printErr(list);

	}

	public static JSONObject response(HashMap<String, Object> parameter, String test) {
		// if (test.contains("=")) {
		// } else {
		// return null;
		// }
		String request = requestValues.request(parameter);
		String response = post.sendPost(sit, request); // 发送请求
		System.out.println("request:" + request);
		JSONObject jsonObj = JSONObject.fromObject(response);// 接收请求
		list = checkStatus.checkStatus(response, test, list);
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

	public static void checkFiles(List<String> listFiles, JSONObject json) {
		boolean boo = false;

		if (json != null) {
			JSONObject s = json;
			JSONArray arr = JSONArray.fromObject(json.get("mediaUrlList"));
			boolean[] err = new boolean[arr.size()];
			for (int i = 0; i < listFiles.size(); i++) {
				for (int j = 0; j < arr.size(); j++) {
					json = JSONObject.fromObject(arr.get(j));
					if (listFiles.get(i).equals(json.get("mediaUrl"))) {
						err[j] = true;
						boo = true;
					}

					if ("3".equals(json.get("sourceType").toString()) == false) {
						listAddJson("sourceType检查不正确" + listFiles.get(i), json);
					}
				}
				if (boo == false) {
					listAddJson("listFiles检查不正确" + listFiles.get(i), json);
				}
				boo = false;
			}

			for (int i = 0; i < err.length; i++) {
				if (err[i] == false) {
					arr = JSONArray.fromObject(s.get("mediaUrlList"));
					json = JSONObject.fromObject(arr.get(i));
					listAddJson("mediaUrl存在多出的值" + listFiles, json);
				}
			}
		}
	}

	public static HashMap<String, Object> map(HashMap<String, Object> mapTest, List<String> listFiles) {
		if (listFiles.size() != 0) {
			String str = "";
			for (int i = 0; i < listFiles.size(); i++) {

				if (i == listFiles.size() - 1) {
					str = str + listFiles.get(i);
					continue;
				}
				str = str + listFiles.get(i) + ",";

			}
			mapTest.put("files", str);
		}
		return mapTest;
	}

	public static void checkForm(JSONObject json, String test) {
		try {

			json = JSONObject.fromObject(json.get("data"));
			Pattern pattern = Pattern.compile("[0-9]+"); // 使用正则表达式
			Matcher isNum = pattern.matcher(json.get("plazaId").toString());
			if (json != null && (json.containsKey("plazaId") == false || isNum.matches() == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("logoImageUrl") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("mainTitle") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("secondTitle") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("hintButtonTxt") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			pattern = Pattern.compile(".+"); // 使用正则表达式
			isNum = pattern.matcher(json.get("bgImageUrl").toString());
			if (json != null && (json.containsKey("bgImageUrl") == false || isNum.matches() == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("rqCodeUrl") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("briefTitle") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("createTime") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("updateTime") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("briefContent") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
			if (json != null && (json.containsKey("mediaUrlList") == false)) {
				listAddJson("缺少参数:" + test, json);
			}
		} catch (Exception e) {
			listAddJson("data中缺少参数:" + test, json);
		}
	}

}
