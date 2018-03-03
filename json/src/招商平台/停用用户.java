package 招商平台;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;

public class 停用用户 {
	static final String sit = "http://zseditor.sit.ffan.com/zseditor/user/v1/logoff";
	static Map<String, List<String>> m = new  HashMap<String, List<String>>();//记录不合格的case，在case执行完成后打印
	static List<String> list = new LinkedList<String>();//记录不合格的test集合
	public static void main(String[] args) {
		String test;
		HashMap<String, Object> mapTest = new HashMap<String, Object>();
		test = "不添加参数直接访问URL，提示错误";
		response(mapTest, test);
		mapTest.clear();
		
		 //id
		 test = "id更改为int，提示成功";
		 mapTest.put("id", 7);
		 response(mapTest,test);
		 
		 test = "id更改为长整数，提示成功";
		 mapTest.put("id", 222222222);
		 response(mapTest,test);
		 
		 test = "id更改为长整数超过限制，提示错误";
		 mapTest.put("id", "222222222222222222222");
		 response(mapTest,test);
		 
		 test = "id更改为0，提示成功";
		 mapTest.put("id", 0);
		 response(mapTest,test);
		 
		 test = "id更改为非int值，提示错误";
		 mapTest.put("id", "32.0");
		 response(mapTest,test);
		 
		 mapTest.put("id", "阿斯蒂芬-1.0");
		 response(mapTest,test);	
		 
		 test = "id为空，提示错误";
		 mapTest.put("id", "");
		 response(mapTest,test);
		 
		 
		 test = "id为key空，提示错误";
		 mapTest.remove("id");
		 response(mapTest,test);
		 
		 test = "id在数据库中不存在，提示成功";
		 mapTest.put("id", System.currentTimeMillis());
		 
		 response(mapTest,test);
		 
		 
		 
		 new printErr(list);
		 
	}

	public static HashMap<String, Object> response(HashMap<String, Object> parameter, String test) {
//		if(test.contains("=")){
//			
//		}else{
//			return null;
//		}
		String request=requestValues.request(parameter);
		String response = post.sendPost(sit, request); // 发送请求
		JSONObject jsonObj = JSONObject.fromObject(response);// 接收请求
		@SuppressWarnings("unchecked")
		// 将响应添加到map
		HashMap<String, Object> map = new HashMap<String, Object>(jsonObj);
		list=checkStatus.checkStatus(response, test,list);	
		System.out.println(request);
		System.out.println();
		return map;
	}
}
