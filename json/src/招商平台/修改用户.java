package 招商平台;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import net.sf.json.JSONObject;

public class 修改用户 {
	static final String sit = "http://zseditor.sit.ffan.com/zseditor/user/v1/update";
	static List<String> list = new LinkedList<String>();//记录不合格的test集合
	public static void main(String[] args) {
		String test;
		HashMap<String, Object> mapTest = new HashMap<String, Object>();
		test = "不添加参数直接访问URL，提示错误";
		response(mapTest, test);
		mapTest.clear();
		
		 test = "添加全部正确参数，提示成功";
		 mapTest.put("id", "9");
		 mapTest.put("userName", "张连宇测");
		 mapTest.put("password", "1");
		 mapTest.put("roleIds", "2");
		 mapTest.put("remark", "张连宇测试修改用户接口");
		 mapTest.put("status", "0");
		 response(mapTest,test);
		
		 //id
		 test = "id更改为int，提示成功";
		 mapTest.put("id", 9);
		 response(mapTest,test);
		 
		 test = "id更改为长整数且在库中不存在此id，提示错误";
		 mapTest.put("id", 255156156);
		 response(mapTest,test);
		 
		 test = "id更改为长整数超过限制，提示错误";
		 mapTest.put("id", "222222222222222222222");
		 response(mapTest,test);
		 
		 test = "id更改为0，提示错误";
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
		 
		 test = "id在数据库中不存在，提示错误";
		 mapTest.put("id", System.currentTimeMillis());
		 response(mapTest,test);
		 
		 
		 //userName
		 mapTest.put("id", "9");
		 mapTest.put("userName", "张连宇测");
		 mapTest.put("password", "1");
		 mapTest.put("roleIds", "2");
		 mapTest.put("remark", "张连宇测试修改用户接口");
		 mapTest.put("status", "0");
		 
		 
		 test = "userName更改，提示成功";
		 mapTest.put("userName", System.currentTimeMillis()+"");
		 response(mapTest,test);
		 
		 test = "userName更改为空，提示错误";
		 mapTest.put("userName","");
		 response(mapTest,test);
		 
		 test = "userName为key空，提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.remove("userName");
		 response(mapTest,test);
		
		 test = "userName超过限制字符，提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("userName",
		 "张连宇张连宇张暗室逢灯的萨芬撒地方撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方的萨芬撒地方撒地方撒旦的啥地方撒旦飞洒地方撒旦飞洒地方撒旦啥地方撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方撒旦发地方撒旦飞洒地方撒旦"
		 +"发斯蒂芬撒旦飞洒地方撒旦连宇张连宇张连宇张连宇张连宇张连宇张发发是飞洒发士大夫撒打发斯蒂芬发生的范德萨连宇张连宇张连宇张连宇张连宇张连宇张连宇");
		 response(mapTest,test);
		 
		 //password
		 mapTest.put("id", "7");
		 mapTest.put("userName", "张连宇测");
		 mapTest.put("password", "1afas@#@kjk34");
		 mapTest.put("roleIds", "2");
		 mapTest.put("remark", "张连宇测试修改用户接口");
		 mapTest.put("status", "0");
		 
		 	 
		 test = "password更改，提示成功";
		 mapTest.put("password", "auserName0%E8%BF%9E%E5%AE%87%E6%B5%8B%E8"+System.currentTimeMillis());
		 response(mapTest,test);
		
		 
		 test = "password更改为空，提示成功，库中密码未更改";
		 mapTest.put("password","");
		 response(mapTest,test);
		 
		 test = "password为key空，提示成功";
		 mapTest.remove("password");
		 response(mapTest,test);
		
		 test = "password超过限制字符，提示错误";
		 mapTest.put("password",
		 "张连宇张连宇张暗室逢灯的萨芬撒地方撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方的萨芬撒地方撒地方撒旦的啥地方撒旦飞洒地方撒旦飞洒地方撒旦啥地方撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方撒旦发地方撒旦飞洒地方撒旦"
		 +"发斯蒂芬撒旦飞洒地方撒旦连宇张连宇张连宇张连宇张连宇张连宇张发发是飞洒发士大夫撒打发斯蒂芬发生的范德萨连宇张连宇张连宇张连宇张连宇张连宇张连宇");
		 response(mapTest,test);
		 
		 //roleIds
		 mapTest.put("id", "7");
		 mapTest.put("userName", "测测");
		 mapTest.put("password", "1afas@#@kjk34");
		 mapTest.put("roleIds", "2");
		 mapTest.put("remark", "测试修改用户接口");
		 mapTest.put("status", "1");
		 
		 
		
		 test = "roleIds更改1，提示成功";
		 mapTest.put("roleIds", "1");
		 response(mapTest,test);
		 
		 test = "roleIds更改2，提示成功";
		 mapTest.put("roleIds", "2");
		 response(mapTest,test);
		 
		 test = "roleIds更改3，提示成功";
		 mapTest.put("roleIds", "3");
		 response(mapTest,test);
		 
		 test = "roleIds更改为空，提示错误";
		 mapTest.put("roleIds", "");
		 response(mapTest,test);
		 
		 test = "roleIds更改key为空，提示成功";
		 mapTest.remove("roleIds");
		 response(mapTest,test);
		 
		 
		 test = "roleIds更改非int值，提示错误";
		 mapTest.put("roleIds", "1l说的");
		 response(mapTest,test);
		 
		 //remark
		 mapTest.put("id", "7");
		 mapTest.put("userName", "测测测测测");
		 mapTest.put("password", "1afas@#@kjk34");
		 mapTest.put("roleIds", "2");
		 mapTest.put("remark", "测试修改用户接口");
		 mapTest.put("status", "1");		 
		 
		 test = "remark更改，提示成功";
		 mapTest.put("remark", "userName成功--------------"+System.currentTimeMillis());
		 response(mapTest,test);
		 mapTest.put("remark", "u");
		 response(mapTest,test);

		 
		 test = "remark更改为空，提示成功";
		 mapTest.put("remark","");
		 response(mapTest,test);
		 
		 test = "remark为key空，提示成功";
		 mapTest.remove("remark");
		 response(mapTest,test);
		 
		 
		 test = "remark超过限制字符，提示错误";
		 mapTest.put("remark",
		 ("张连宇张连宇张暗室逢灯的萨芬撒地方撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方的萨芬撒地方撒地方撒旦的啥地方撒旦飞洒地方撒旦飞洒地方撒旦啥地方撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方撒旦发地方撒旦飞洒地方撒旦"
		 +"发斯蒂芬撒旦飞洒地方撒旦连宇张连宇张连宇张连宇张连宇张连宇张发发是飞洒发士大夫撒打发斯蒂芬发生的范德萨连宇张连宇张连宇张连宇张连宇张连宇张连宇"));
		 response(mapTest,test);
		 	 
		 
		 //status
		 mapTest.put("id", "7");
		 mapTest.put("userName", "测测测测");
		 mapTest.put("password", "1a#@kjk34");
		 mapTest.put("roleIds", "3");
		 mapTest.put("remark", "测试修改用户");
		 mapTest.put("status", "1");	
		 	 
		 test = "status更改1，提示成功";
		 mapTest.put("status", "1");
		 response(mapTest,test);
		 
		 test = "status更改0，提示成功";
		 mapTest.put("status", "0");
		 response(mapTest,test);
		 
		 test = "status不携带参数，提示成功";
		 mapTest.put("status", "");
		 response(mapTest,test);
		 
		 test = "status不携带参key，提示成功";
		 mapTest.remove("status");
		 response(mapTest,test);
		 
		 test = "status为2，提示错误";
		 mapTest.put("status", 2);
		 response(mapTest,test);
		 
		 test = "status为-1，提示错误";
		 mapTest.put("status", -1);
		 response(mapTest,test);
		 
		 test = "status为非int值，提示错误";
		 mapTest.put("status", "1.0");
		 response(mapTest,test);
		 
		 mapTest.put("status", "撒的发生221@f");
		 response(mapTest,test);
		 
		 //post
		 mapTest.put("id", "7");
		 mapTest.put("userName", "测试post");
		 mapTest.put("password", "post#@post");
		 mapTest.put("roleIds", "2");
		 mapTest.put("remark", "测试修改用户");
		 mapTest.put("status", "1");	
		 mapTest.put("post", "1");	
		 
		 test="post输入正确，提示成功";
		 mapTest.put("post", "1");	
		 response(mapTest,test);
		 
		 test="post输入长字符不超过限制，提示成功";
		 mapTest.put("post", "安抚撒的发生打发打发第三方撒旦飞洒地方撒旦飞洒地方撒旦发大发发撒的发斯蒂芬");	
		 response(mapTest,test);
		 
		 test="post输入为空，提示成功";
		 mapTest.put("post", "");	
		 response(mapTest,test);
		 
		 test="post输入key为空，提示成功";
		 mapTest.remove("post");	
		 response(mapTest,test);
		 
		 test="post输入超过限制字符，提示错误";
		 mapTest.put("post", "啥地方撒旦发发呆是范德萨发发的撒会计法是分散的啥地方撒旦发地方撒旦飞洒地方家地方撒打开房间傻掉了口袋里看风景撒代理费啥的六块腹肌当上了飞机撒旦了撒旦飞洒地方世纪东方撒代理费见识到了房间打开了房间sadsadly萨顶顶发地方撒娇的撒旦法撒旦是代理方式");		
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
