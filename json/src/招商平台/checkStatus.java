package 招商平台;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import net.sf.json.JSONObject;

public class checkStatus {
	/**
	 * 用来判断response中的status状态码和测试用例中要求的状态码是否一致
	 * 只能处理json数据
	 * 只检查status是200或不是200，不是200的具体状态码没有进行判断
	 * @exception 如果测试用例中包含“错误”，代码中判断status是否200，不是200时验证正确，返回list默认数据
	 * @author 张连宇
	 * @return 返回list<StringText>
	 * @param response json
	 * @param test 测试用例
	 * @param list list列表
	 * 
	 */
	public static List<String> checkStatus(String response,String test,List<String> list){
		JSONObject jsonObj = JSONObject.fromObject(response);// 接收请求
		@SuppressWarnings("unchecked")
		// 将响应添加到map
		HashMap<String, Object> map = new HashMap<String, Object>(jsonObj);
		System.out.println(test + ":\n status: " + map.get("status") + " message:" + map.get("message"));
		if ((test.contains("错误") && map.get("status").equals(200))
				|| (test.contains("成功") && map.get("status").equals(200) == false)) {
			System.out.println("-----staus---------" + test + "检查不成功--------------");
			list.add(test+"；response{ status:"+map.get("status")+", message:"+map.get("message")+"}\n");
		}else{
			if(test.contains("错误")==false && test.contains("成功")==false){
				JOptionPane.showMessageDialog(null, "checkStatus：Test关键字没有找到", "警告",JOptionPane.ERROR_MESSAGE); 
				System.exit(0);
			}
		}
		return list;
	}
}
