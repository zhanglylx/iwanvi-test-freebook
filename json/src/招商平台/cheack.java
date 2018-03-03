package 招商平台;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class cheack {
	static final String sit = "http://zseditor.intra.sit.ffan.com/zseditor/user/v1/users";
	public static void cheack(){
		String response = get.sendGet(sit, ""); // 发送请求
		JSONObject json = JSONObject.fromObject(response);
		json = JSONObject.fromObject(json.get("list"));
		JSONArray array = JSONArray.fromObject(json);
		for(int i=0;i<array.size();i++){
			
		}
	}
}
