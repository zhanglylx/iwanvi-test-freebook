package 招商平台;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import Methods_summarize.转码;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class 创建或修改首页信息 {
	static final String sit = "http://zseditor.sit.ffan.com/zseditor/homePage";
	static Map<String, List<String>> m = new HashMap<String, List<String>>();// 记录不合格的case，在case执行完成后打印
	static List<String> list = new LinkedList<String>();// 记录不合格的test集合

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test;
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> mapTest = new HashMap<String, Object>();
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();
		test = "不添加参数直接访问URL，提示错误，返回错误信息";
		json = response(mapTest, test);
		if (json != null && ("服务错误".equals(json.get("message")) == false)) {
			listAddJson(test, json);
		}
		mapTest.clear();

		// bgFile
		test = "bgFile为空，提示错误";
		mapTest.put("bgFile", "");
		json = response(mapTest, test);
		if (json != null && ("参数错误|更新首页信息时, bgFile不能为空".equals(json.get("message")) == false)) {
			listAddJson(test, json);
		}

		test = "bgFile为字符串，提示成功";
		mapTest.put("bgFile", "http://www.baidu.com");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("bgFile").toString().equals(json.get("bgImageUrl")) == false)) {
			listAddJson(test, json);
		}
		
		

		test = "bgFile超长字符串，提示成功";
		mapTest.put("bgFile",
				"http://www.baidu.com%%￥￥%￥%￥%￥gs5dfgsdgs4d6g感受到分公司搜狗是梵蒂冈收到各色人特退热贴我让他玩儿童十大歌手放大该公司发的113116454asfsdfsdafdsadfadsfsadfsadf45afd");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("bgFile").toString().equals(json.get("bgImageUrl")) == false)) {
			listAddJson(test, json);
		}

		// hinButtonTxt
		mapTest.clear();
		mapTest.put("bgFile", System.currentTimeMillis());

		test = "hintButtonTxt为空，提示成功";
		mapTest.put("hintButtonTxt", "");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("hintButtonTxt").toString().equals(json.get("hintButtonTxt")) == false)) {
			listAddJson(test, json);
		}

		test = "hintButtonTxt为字符串，提示成功";
		mapTest.put("hintButtonTxt", "http://www.baidu.com");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("hintButtonTxt").toString().equals(json.get("hintButtonTxt")) == false)) {
			listAddJson(test, json);
		}

		test = "hintButtonTxt超长限制字符串，提示错误";
		mapTest.put("hintButtonTxt",
				"http://www.baidu.com%%￥￥%￥%￥%￥gs5dfgsdgs4d6g感受到分公司搜狗是梵蒂冈收到各色人特退热贴我让他玩儿童十大歌手放大该公司发的113116454asfsdfsdafdsadfadsfsadfsadf45afd");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("hintButtonTxt").toString().equals(json.get("hintButtonTxt")) == true)) {
			listAddJson(test, json);
		}

		test = "hintButtonTxt超长字符串，提示成功";
		mapTest.put("hintButtonTxt", "http://法法215212121212大该公司发的11311645adf45afd".substring(0, 32));
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("hintButtonTxt").toString().equals(json.get("hintButtonTxt")) == false)) {
			listAddJson(test, json);
		}

		test = "不携带hintButtonTxt，提示成功,库中值不给改";
		String str = "http://www.baidu.com";
		mapTest.put("hintButtonTxt", str);
		json = dataResponse(mapTest, test);
		mapTest.remove("hintButtonTxt");
		json = dataResponse(mapTest, test);
		if (json != null && (str.equals(json.get("hintButtonTxt")) == false)) {
			listAddJson(test, json);
		}

		// secondTitle
		mapTest.clear();
		mapTest.put("bgFile", System.currentTimeMillis());

		test = "secondTitle为空，提示成功";
		mapTest.put("secondTitle", "");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("secondTitle").toString().equals(json.get("secondTitle")) == false)) {
			listAddJson(test, json);
		}

		test = "secondTitle为字符串，提示成功";
		mapTest.put("secondTitle", "http://www.baidu.com");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("secondTitle").toString().equals(json.get("secondTitle")) == false)) {
			listAddJson(test, json);
		}

		test = "secondTitle超长限制字符串，提示错误";
		mapTest.put("secondTitle",
				"http://www.baidu.com%%￥￥%￥阿法士大夫撒的范德萨发士大夫士大夫撒旦飞洒地方撒旦飞洒地方士大夫撒地方的撒范德萨发生的ad发撒旦飞洒地方的撒发撒旦飞洒地方是大发的发生大阿斯顿发生大发送到发送到啊是发撒旦飞洒地方撒旦飞洒地方收到%￥%￥gs5dfgsdgs4d6g感受到分公司搜狗是梵蒂冈收到各色人特退热贴我让他玩儿童十大歌手放大该公司发的113116454asfsdfsdafdsadfadsfsadfsadf45afd");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("secondTitle").toString().equals(json.get("secondTitle")) == false)) {
			listAddJson(test, json);
		}

		test = "secondTitle超长字符串，提示成功";
		mapTest.put("secondTitle", "http://法法215212121212大该公司发的11311645adf45afd".substring(0, 32));
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("secondTitle").toString().equals(json.get("secondTitle")) == false)) {
			listAddJson(test, json);
		}

		test = "不携带secondTitle，提示成功,库中值不给改";
		str = "http://www.baidu.com";
		mapTest.put("secondTitle", str);
		json = dataResponse(mapTest, test);
		mapTest.remove("secondTitle");
		json = dataResponse(mapTest, test);
		if (json != null && (str.equals(json.get("secondTitle")) == false)) {
			listAddJson(test, json);
		}

		// mainTitle
		mapTest.clear();
		mapTest.put("bgFile", System.currentTimeMillis());

		test = "mainTitle为空，提示成功";
		mapTest.put("mainTitle", "");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("mainTitle").toString().equals(json.get("mainTitle")) == false)) {
			listAddJson(test, json);
		}

		test = "mainTitle为字符串，提示成功";
		mapTest.put("mainTitle", "http://www.baidu.com");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("mainTitle").toString().equals(json.get("mainTitle")) == false)) {
			listAddJson(test, json);
		}

		test = "mainTitle超长限制字符串，提示错误";
		mapTest.put("mainTitle",
				"http://www.baidu.com%%￥￥%￥阿法士大夫撒的范德萨发士大夫士大夫撒旦飞洒地方撒旦飞洒地方士大夫撒地方的撒范德萨发生的ad发撒旦飞洒地方的撒发撒旦飞洒地方是大发的发生大阿斯顿发生大发送到发送到啊是发撒旦飞洒地方撒旦飞洒地方收到%￥%￥gs5dfgsdgs4d6g感受到分公司搜狗是梵蒂冈收到各色人特退热贴我让他玩儿童十大歌手放大该公司发的113116454asfsdfsdafdsadfadsfsadfsadf45afd");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("mainTitle").toString().equals(json.get("mainTitle")) == false)) {
			listAddJson(test, json);
		}

		test = "mainTitle超长字符串，提示成功";
		mapTest.put("mainTitle", "http://法法215212121212大该公司发的11311645adf45afd".substring(0, 32));
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("mainTitle").toString().equals(json.get("mainTitle")) == false)) {
			listAddJson(test, json);
		}

		test = "不携带secondTitle，提示成功,库中值不给改";
		str = "h";
		mapTest.put("mainTitle", str);
		json = dataResponse(mapTest, test);
		mapTest.remove("mainTitle");
		json = dataResponse(mapTest, test);
		if (json != null && (str.equals(json.get("mainTitle")) == false)) {
			listAddJson(test, json);
		}

		// rqCodeFile
		mapTest.clear();
		mapTest.put("bgFile", System.currentTimeMillis());

		test = "rqCodeFile为空，提示成功";
		mapTest.put("rqCodeFile", "");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("rqCodeFile").toString().equals(json.get("rqCodeUrl")) == false)) {
			listAddJson(test, json);
		}

		test = "rqCodeFile为字符串，提示成功";
		mapTest.put("rqCodeFile", "http://www.baidu.com");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("rqCodeFile").toString().equals(json.get("rqCodeUrl")) == false)) {
			listAddJson(test, json);
		}

		test = "rqCodeFile超长字符串，提示成功";
		mapTest.put("rqCodeFile", "http://法法215212121212大该公司发的发发士大夫士大夫士大夫的所发生的11311645adf45afd");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("rqCodeFile").toString().equals(json.get("rqCodeUrl")) == false)) {
			listAddJson(test, json);
		}

		test = "不携带rqCodeFile，提示成功,库中值不给改";
		str = "h#@#@$%%$@#@#" + System.currentTimeMillis();
		mapTest.put("rqCodeFile", str);
		json = dataResponse(mapTest, test);
		mapTest.remove("rqCodeFile");
		json = dataResponse(mapTest, test);
		if (json != null && (str.equals(json.get("rqCodeUrl")) == false)) {
			listAddJson(test, json);
		}

		// logoFile
		mapTest.clear();
		mapTest.put("bgFile", System.currentTimeMillis());

		test = "logoFile为空，提示成功";
		mapTest.put("logoFile", "");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("logoFile").toString().equals(json.get("logoImageUrl")) == false)) {
			listAddJson(test, json);
		}

		test = "logoFile为字符串，提示成功";
		mapTest.put("logoFile", "http://www.baidu.com");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("logoFile").toString().equals(json.get("logoImageUrl")) == false)) {
			listAddJson(test, json);
		}

		test = "logoFile超长字符串，提示成功";
		mapTest.put("logoFile", "http://法法215212121212大该公司发的发发士大夫士大夫士大夫的所发生的11311645adf45afd");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("logoFile").toString().equals(json.get("logoImageUrl")) == false)) {
			listAddJson(test, json);
		}

		test = "不携带logoFile，提示成功,库中值不给改";
		str = "h#@#@$%%$@#@#" + System.currentTimeMillis();
		mapTest.put("logoFile", str);
		json = dataResponse(mapTest, test);
		mapTest.remove("logoFile");
		json = dataResponse(mapTest, test);
		if (json != null && (str.equals(json.get("logoImageUrl")) == false)) {
			listAddJson(test, json);
		}
		
		//修改全部内容
		mapTest.clear();
		test="测试同时修改全部内容，提示成功";
		String bgFile="http://wiki.ffan.biz/pages/viewpage.action?pageId=18909632#id-招商编辑平台-4.楼层相关接口";
		mapTest.put("bgFile", bgFile);
		mapTest.put("hintButtonTxt","错误提示按钮");
		mapTest.put("secondTitle","北京万达广场石景山店");
		mapTest.put("mainTitle","北京万达广场通州店大厦一层招商会议");
		mapTest.put("rqCodeFile","http://www.cnblogs.com/jym-sunshine/p/6256667.html");
		mapTest.put("logoFile","http://blog.csdn.net/weixin_36380516/article/details/58594664");
		json = dataResponse(mapTest, test);
		if (json != null && (mapTest.get("bgFile").toString().equals(json.get("bgImageUrl")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("hintButtonTxt").toString().equals(json.get("hintButtonTxt")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("secondTitle").toString().equals(json.get("secondTitle")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("mainTitle").toString().equals(json.get("mainTitle")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("rqCodeFile").toString().equals(json.get("rqCodeUrl")) == false)) {
			listAddJson(test, json);
		}
		if (json != null && (mapTest.get("logoFile").toString().equals(json.get("logoImageUrl")) == false)) {
			listAddJson(test, json);
		}
		
		//不携带bgFile
				mapTest.clear();
				test="不携带KEY:bgFile，库中已存在值，提示成功";
				mapTest.put("hintButtonTxt","错误提示按钮都会更好");
				mapTest.put("secondTitle","北京万达广场石景山店");
				mapTest.put("mainTitle","北京万达广场通州店大厦一层招商会议");
				mapTest.put("rqCodeFile","");
				mapTest.put("logoFile","http://blog.csdn.net/weixin_36380516/article/details/58594664");
				json=dataResponse(mapTest, test);
				if (json != null && (bgFile.equals(json.get("bgImageUrl")) == false)) {
					listAddJson(test, json);
				}
				if (json != null && (mapTest.get("hintButtonTxt").toString().equals(json.get("hintButtonTxt")) == false)) {
					listAddJson(test, json);
				}
				if (json != null && (mapTest.get("secondTitle").toString().equals(json.get("secondTitle")) == false)) {
					listAddJson(test, json);
				}
				if (json != null && (mapTest.get("mainTitle").toString().equals(json.get("mainTitle")) == false)) {
					listAddJson(test, json);
				}
				if (json != null && (mapTest.get("rqCodeFile").toString().equals(json.get("rqCodeUrl")) == false)) {
					listAddJson(test, json);
				}
				if (json != null && (mapTest.get("logoFile").toString().equals(json.get("logoImageUrl")) == false)) {
					listAddJson(test, json);
				}
		
				mapTest.clear();
				//请到数据库中删除值
				test="不携带KEY:bgFile，库中不存在值，提示错误";
				mapTest.put("hintButtonTxt","错误提示按钮都会更好");
				mapTest.put("secondTitle","北京万达广场石景山店");
				mapTest.put("mainTitle","北京万达广场通州店大厦一层招商会议");
				mapTest.put("rqCodeFile","");
				mapTest.put("logoFile","http://blog.csdn.net/weixin_36380516/article/details/58594664");
				json=dataResponse(mapTest, test);
				

				 new printErr(list);

	}

	public static JSONObject response(HashMap<String, Object> parameter, String test) {
//		if (test.contains("=")) {
//		} else {
//			return null;
//		}
		String request=requestValues.request(parameter);
		String response = post.sendPost(sit, request); // 发送请求
		System.out.println("request:" + request);
		JSONObject jsonObj = JSONObject.fromObject(response);// 接收请求
		list=checkStatus.checkStatus(response, test,list);	
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
		if(test.contains("成功")){
			checkForm(jsonObj,test);
		}
		return jsonObj;
	}

	public static void listAddJson(String test, JSONObject json) {
		list.add("返回结果不正确:" + test + "   json:" + json.toString() + " 实际返回结果\n");
	}
	
	public static void checkForm(JSONObject json,String test){
		try{
			if (json != null && (json.containsKey("plazaId") == false)) {
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
			if (json != null && (json.containsKey("bgImageUrl") == false)) {
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
	}
}
