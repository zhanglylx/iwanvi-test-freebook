package 招商平台;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 新增用户 {
	static final String sit = "http://zseditor.sit.ffan.com/zseditor/user/v1/add";
	static List<String> list = new LinkedList<String>();//记录不合格的test集合
	public static void main(String[] args) {
		String test;
		HashMap<String, Object> mapTest = new HashMap<String, Object>();
		test = "不添加参数直接访问URL，提示错误";
	    response(mapTest, test);
		mapTest.clear();
		 test = "添加全部正确参数，提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("userName", "张连宇");
		 mapTest.put("password", "123456");
		 mapTest.put("roleIds", "1");
		 mapTest.put("remark", "张连宇测试新增用户接口");
		 mapTest.put("status", "1");
		 response(mapTest,test);
		
		 test = "缺少手机号key，提示错误";
		 mapTest.remove("phone");
		 response(mapTest,test);
		
		 test = "手机号为空，提示错误";
		 mapTest.put("phone", "");
		
		 response(mapTest,test);
		 test = "长字符手机号，提示成功";
		 mapTest.put("phone", System.currentTimeMillis()+System.currentTimeMillis());
		 response(mapTest,test);
		
		 test = "重复手机号，提示错误";
		 response(mapTest,test);
		 test = "手机号为特殊字符，汉字，字符，保存成功";
		 mapTest.put("phone", System.currentTimeMillis()+"在%#s");
		 response(mapTest,test);
		
		 //userName
		 mapTest.put("phone", "1342628325");
		 mapTest.put("userName", "张连宇");
		 mapTest.put("password", "123456");
		 mapTest.put("roleIds", "1");
		 mapTest.put("remark", "张连宇测试新增用户接口");
		 mapTest.put("status", "1");
		
		
		
		 test = "userName为空，提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("userName", "");
		 response(mapTest,test);
		
		 test = "userName为key空，提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.remove("userName");
		 response(mapTest,test);
		
		 test = "userName超过限制字符，提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("userName",
		 "张连宇张连宇张暗室逢灯的萨芬撒地方撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方的萨芬撒地方撒地方撒旦的啥地方撒旦飞洒地方撒旦飞洒地方撒旦啥地方撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方撒旦发地方撒旦飞洒地方撒旦"
		 +"发斯蒂芬撒旦飞洒地方撒旦连宇张连宇张连宇张连宇张连宇张连宇张发发是飞洒发士大夫撒打发斯蒂芬发生的范德萨连宇张连宇张连宇张连宇张连宇张连宇张连宇");
		 response(mapTest,test);
		
		 test = "userName为重复名称，提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("userName", "@#@#adsfas3323#测试测试测试测试测试测试测试测试测试测试测试");
		 response(mapTest,test);
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("userName", "@#@#adsfas3323#测试测试测试测试测试测试测试测试测试测试测试");
		 response(mapTest,test);
		 mapTest.clear();
		
		 //password
		 mapTest.put("phone", "134262832415455");
		 mapTest.put("userName", "张");
		 mapTest.put("password", "123");
		 mapTest.put("roleIds", "2");
		 mapTest.put("remark", "张连宇测试新增用户接口");
		 mapTest.put("status", "1");
		
		
		
		
		 test = "password为空，提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("password", "");
		 response(mapTest,test);
		
		
		 test = "password为key空，提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.remove("password");
		 response(mapTest,test);
		
		
		 test = "password超长字符，提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("password", "ad飞洒地方撒旦飞洒地方撒旦范德萨发撒的是飞洒大多是法第三方");
		 response(mapTest,test);
		
		
		 test = "password超过限制字符，提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("password",
		 "ad飞洒地方撒旦飞洒地士大夫撒飞洒地方士大夫啥地方撒旦飞洒地方撒旦飞洒地方撒旦防守打法撒旦飞洒地方撒旦飞洒地方撒旦发多少方撒旦范德萨发撒的是飞洒大多是法第三方");
		 response(mapTest,test);
		
		
		 test = "password汉字，特殊字符，数字，提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("password", "ad飞洒地#@@#方撒旦（&*……99558.362多是法第三方");
		 response(mapTest,test);
		
		 test = "password汉字，特殊字符，数字，提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("password", "ad飞洒地#@@#方撒旦（&*……99558.362多是法第三方");
		 response(mapTest,test);
		
		
		 //roleIds
		 mapTest.put("phone", "1342628325");
		 mapTest.put("userName", "张连宇");
		 mapTest.put("password", "123456");
		 mapTest.put("roleIds", "1");
		 mapTest.put("remark", "张连宇测试新增用户接口");
		 mapTest.put("status", "1");
		
		
		
		 test = "roleIds为1,提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "1");
		 response(mapTest,test);
		
		
		 test = "roleIds为2,提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("userName","a#@FREWR32432432");
		 mapTest.put("roleIds", "2");
		 response(mapTest,test);
		
		 test = "roleIds为3,提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "3");
		 response(mapTest,test);
		
		 test = "roleIds为4,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "4");
		 response(mapTest,test);
		
		 test = "roleIds为0,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "0");
		 response(mapTest,test);
		
		
		 test = "roleIds为int类型的1,提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", 1);
		 response(mapTest,test);
		
		 test = "roleIds为double类型,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "1.0");
		 response(mapTest,test);
		
		 test = "roleIds为汉字,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "测试");
		 response(mapTest,test);
		
		 test = "roleIds为字母,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "adf");
		 response(mapTest,test);
		
		
		 test = "roleIds为特殊字符,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "@#@");
		 response(mapTest,test);
		
		
		 test = "roleIds为组合字符,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "1.05@#adf啊");
		 response(mapTest,test);
		
		 test = "roleIds为组合字符,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "1.05@#adf啊");
		 response(mapTest,test);
		
		 test = "roleIds为超长字符,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds",
		 "1.05@#a阿发撒旦飞洒地方士大夫撒旦发斯蒂芬撒旦飞洒地方撒旦撒旦飞洒地方撒旦飞洒地方df啊");
		 response(mapTest,test);
		
		 test = "roleIds为空,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("roleIds", "");
		 response(mapTest,test);
		
		 test = "roleIds为key空,提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.remove("roleIds");
		 response(mapTest,test);
		 mapTest.clear();
		
		 //remark
		 mapTest.put("phone", "1342628325");
		 mapTest.put("userName", "张连宇");
		 mapTest.put("password", "123456");
		 mapTest.put("roleIds", "1");
		 mapTest.put("remark", "张连宇测试新增用户接口");
		 mapTest.put("status", "1");
		
		 test = "remark为key空，提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.remove("remark");
		 response(mapTest,test);
		
		 test = "remark为空，提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("remark", "张连宇测试新增用户接口");
		 response(mapTest,test);
		
		 test = "remark为超长字符，提示成功";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("remark",
		 "张连宇安抚撒旦飞洒地方撒旦飞洒地方撒旦撒旦撒发地方撒旦飞洒地方撒旦@@#@#sfddsafsa3213213试新增用户接口");
		 response(mapTest,test);
		
		 test = "remark为超过限制字符，提示错误";
		 mapTest.put("phone", System.currentTimeMillis());
		 mapTest.put("remark",
		 "张连宇安抚撒旦飞洒地阿双方撒旦飞洒地方撒旦飞洒地方撒旦恢复了就是大发货撒地方撒大黄蜂撒娇的房间的萨芬进口量撒旦啥地方叫撒地方叫撒地方哈撒地方和撒旦啥地方啥地方撒旦发的撒的发生方撒旦飞洒地方撒旦撒旦撒发地方撒旦飞洒地方撒旦@@#@#sfddsafsa3213213试新增用户接口");
		 response(mapTest,test);

		// status
		mapTest.put("phone", "1342628325");
		mapTest.put("userName", "张连宇");
		mapTest.put("password", "123456");
		mapTest.put("roleIds", "1");
		mapTest.put("remark", "张连宇测试新增用户接口");
		mapTest.put("status", "1");

		test = "status不携带参数，提示错误";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("status", "");
		response(mapTest, test);

		test = "status为key为空，提示错误";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.remove("status");
		response(mapTest, test);

		test = "status为1，提示成功";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("status", "1");
		response(mapTest, test);

		test = "status为int1，提示成功";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("status", 1);
		response(mapTest, test);

		test = "status为0，提示成功";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("status", "0");
		response(mapTest, test);

		test = "status为-1，提示错误";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("status", "-1");
		response(mapTest, test);
		
		test = "status为2，提示错误";
		mapTest.put("phone", System.currentTimeMillis()+"测试测试");
		mapTest.put("status", 2);
		response(mapTest, test);
		
		test = "status为10，提示错误";
		mapTest.put("phone", System.currentTimeMillis()+"测试");
		mapTest.put("status", 10);
		response(mapTest, test);
		
		
		
		test = "status为3，提示错误";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("status", 3);
		response(mapTest, test);
		
		
		test = "status为4，提示错误";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("status", 4);
		response(mapTest, test);
		
		test = "status为汉字，提示错误";
		mapTest.put("phone", System.currentTimeMillis());
		mapTest.put("status", "a");
		response(mapTest, test);
		
		
		// post
		mapTest.put("phone", "1342628325");
		mapTest.put("userName", "张连宇");
		mapTest.put("password", "123456");
		mapTest.put("roleIds", "1");
		mapTest.put("remark", "张连宇测试新增用户接口");
		mapTest.put("status", "1");
		mapTest.put("post", "1");
		
		test = "post为空，提示成功";
		mapTest.put("phone", System.currentTimeMillis()+"post");
		mapTest.put("post", "");
		response(mapTest, test);
		
		test = "post为key空，提示成功";
		mapTest.put("phone", System.currentTimeMillis()+"post");
		mapTest.remove("post");
		response(mapTest, test);
		
		test = "post为字符串，提示成功";
		mapTest.put("phone", System.currentTimeMillis()+"post");
		mapTest.put("post", "岗位");
		response(mapTest, test);
		
		test = "post为长字符串，提示成功";
		mapTest.put("phone", System.currentTimeMillis()+"post");
		mapTest.put("post", "岗位@#@#发送到发送到aasdf1545445……￥……&");
		response(mapTest, test);
		
		test = "post为超过限制字符串，提示错误";
		mapTest.put("phone", System.currentTimeMillis()+"post");
		mapTest.put("post", "岗位@#@发大水发撒旦飞洒地方撒旦发撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方撒旦发的萨芬撒地方撒旦飞洒地方撒旦#发送到发送到aasdf1545445……￥……&");
		response(mapTest, test);
		
		 new printErr(list);
		
	}

	public static void response(HashMap<String, Object> parameter, String test) {
		String request=requestValues.request(parameter);
		String response = post.sendPost(sit, request); // 发送请求
		list=checkStatus.checkStatus(response, test,list);	
		System.out.println(request);
		System.out.println();
	}
}
