package 品牌地图联动查询;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class 品牌地图联动查询 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://gmp-search-service.intra.sit.ffan.com/mapping/brand/linkage";
		HashMap<String, Object> map = new HashMap<String, Object>();
		//获取用例条数
		int num =(int)testData.data(0).get("for"); 
		for(int i=1;i<num;i++){		
		map = testData.data(i);
		//打印执行的测试用例
		System.out.println(map.get("data"));
		//删除执行的测试用例data，将剩余参数作为输入
		map.remove("data");
		JSONObject jsonObject = JSONObject.fromObject(map);
		String json = post.sendPost(url, jsonObject.toString());
		System.out.println(json);
		// 检查返回数据
		status(json);
		message(json);
		result(json);
		System.out.println("--------------------"+i+"----------------------");
	   }
		
	}
	
	public static void status(String response) {
		JSONObject json = JSONObject.fromObject(response);
		if ("20000".equals(json.get("status"))) {
		} else {
			System.out.println("status 【【【【【【状态不是200】】】】】】:" + json.get("status"));
		}
	}
	
	public static void message(String response) {
		JSONObject json = JSONObject.fromObject(response);
		if (json.get("message").equals(null)) {
		} else {
			System.out.println("message 【【【【【【检查不通过】】】】】】:" + json.get("message") + " 检查了是否为null");
		}
	}

	public static void result(String response) {
		JSONObject json = JSONObject.fromObject(response);
		JSONArray jsonArray = JSONArray.fromObject(json.get("result"));
		for (int i = 0; i < jsonArray.size(); i++) {
			json = JSONObject.fromObject(jsonArray.get(i));
			// 检查显示名称,text
			Matcher("text", json);
			// 检查品牌中文名、英文名
			if ((json.get("zhName").equals(null)) == false) {
				Matcher("zhName", json);
			}
			if ((json.get("enName").equals(null)) == false) {
				Matcher("enName", json);
			}
			if ((json.get("totalCount").equals(null)) == false) {
				Matcher("totalCount", json);
			}
			// 检查品牌ID
			Matcher("id", json);
			// 检查业态类型
			Matcher("businessTypeId", json);
			// 检查logo
			Matcher("logo", json);
		}
	}

	public static void Matcher(String Values, JSONObject json) {
		String Matcher = null;
		if ("status".equals(Values)) {
			Matcher = "[2-5][0-9][0-9]*";
		} else if ("text".equals(Values)) {
			Matcher = ".+";
		} else if ("zhName".equals(Values)) {
			Matcher = ".+";
		} else if ("enName".equals(Values)) {
			Matcher = "[a-zA-Z- ]+";
		} else if ("id".equals(Values)) {
			Matcher = ".+";
		} else if ("businessTypeId".equals(Values)) {
			Matcher = "[0-9]+";
		} else if ("totalCount".equals(Values)) {
			Matcher = "[0-9]+";
		} else if ("logo".equals(Values)) {
			Matcher = ".+";
		} else {
			System.out.println("没有找到Values的正则表达式:" + Values);
			System.exit(0);
		}
		Pattern pattern = Pattern.compile(Matcher); // 使用正则表达式至少一个汉字、数字、字母、下划线
		Matcher is = pattern.matcher(json.get(Values).toString());
		if (is.matches() && (json.get(Values).equals(null)) == false) {
		} else {
			System.out.println(Values + "【【【【【【检查不通过】】】】】】:" + json.get(Values) + " id:" + json.get("id"));
		}
	}
	
}
