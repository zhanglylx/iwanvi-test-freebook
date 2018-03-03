package 招商平台;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class 角色查询 {
	static final String sit = "http://zseditor.sit.ffan.com/zseditor/role/v1/roles";
	static List<String> list = new LinkedList<String>();//记录不合格的test集合
	static int total = 0;
	public static void main(String[] args) {
		String test;
		HashMap<String, Object> mapTest = new HashMap<String, Object>();
		JSONArray jsonArray = new JSONArray();
		test = "不添加参数直接访问URL，提示成功，返回全部角色";
		response(mapTest, test);
		mapTest.clear();
		
		//roleName
		test = "roleName为空值，提示成功，返回页数为1，笔数为20条结果";
		mapTest.put("roleName", "");
		response(mapTest, test);
		if(jsonArray.size()>20){
			list.add(test+"   jsonArray.size:"+jsonArray.size()+" 实际返回了结果\n");
		} 
		
		 
		test = "roleName查询库中不存在的角色，提示成功，返回无结果";
		mapTest.put("roleName", "adf@#@#$%%#$fasdf");
		jsonArray=response(mapTest, test);
		if(jsonArray.size()>0){
			list.add(test+"   jsonArray.size:"+jsonArray.size()+" 实际返回了结果\n");
		} 
		
		test = "roleName模糊查询角色，提示成功，返回相应结果";
		mapTest.put("roleName", "管理");
		jsonArray=response(mapTest, test);
		if(jsonArray.size()<1){
			list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
		} 
		
		test = "roleName模糊查询角色，提示成功，返回相应结果";
		mapTest.put("roleName", "发");
		jsonArray=response(mapTest, test);
		if(jsonArray.size()<1){
			list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
		} 
		
		test = "roleName精确查询角色，提示成功，返回相应结果";
		mapTest.put("roleName", "编辑");
		jsonArray=response(mapTest, test);
		if(jsonArray.size()!=1){
			list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
		} 
		 
		
		test = "roleName为超长字符，提示成功，返回相应结果";
		String str ="fsadfsadf方啥地方撒旦发地方撒旦发的发的萨芬撒旦飞洒地方撒旦发地方啥地方撒旦发撒旦飞洒地方撒旦飞洒打发点发斯蒂芬撒旦飞洒地方撒旦发阿双方扫地发撒旦飞洒地方撒旦飞洒地方啥地方撒旦飞洒地方撒旦啥地方撒旦飞洒地方撒旦发撒旦飞洒地方啥地方撒旦飞洒地方撒旦发是地方撒地方啥地方撒旦飞洒地方萨芬撒发地方撒旦发地方撒旦发地方撒地方撒sfadsj发发生地方萨芬暗示法撒旦发的发地方啥地方啥地方撒旦发地方撒旦发撒旦飞洒地方是发地方啥地方啥地方撒旦飞洒地方撒旦防守打法撒旦飞洒地方啥地方啥地方撒旦发地方撒旦发地方啥地方撒旦发撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方第三方士大夫撒旦飞洒地方撒旦飞洒地方撒旦飞洒发撒旦飞洒地方撒地方撒旦法撒旦飞洒地方撒旦范德萨发士大夫撒地方的萨芬撒地方的萨芬撒旦飞洒地方撒旦飞洒地方沙发啥地方撒旦飞洒地方撒旦飞洒地方撒旦飞洒地方fsahdf大家发生纠纷撒很多事都发生地萨芬撒低价爱的世界大数据啥地方剪短发撒地方科技ad萨芬撒低价法撒旦加急发货撒旦飞洒地方杀多了几分撒地方发生劳动力发货撒多了几分sad辣椒粉撒大家都辅路就";
		mapTest.put("roleName",str);
		jsonArray=response(mapTest, test);
		if(jsonArray.size()!=0){
			list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
		} 
		
		
		//curPage
			mapTest.clear();
				test = "curPage为空值，提示成功，返回默认值为1页的内容";
				mapTest.put("curPage", "");
				jsonArray=response(mapTest, test);
				if(jsonArray.size()>20){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
							
				test = "curPage为1，提示成功，返回第1页";
				mapTest.put("curPage", "1");
				mapTest.put("pageSize", "1");
				jsonArray=response(mapTest, test);				
				if(jsonArray.size()!=1){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				test = "curPage为2，提示成功，返回第2页";
				mapTest.put("curPage", "2");
				mapTest.put("pageSize", "1");
				jsonArray=response(mapTest, test);			
				if(jsonArray.size()!=1){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				test = "curPage为3，提示成功，返回第3页";
				mapTest.put("curPage", "3");
				mapTest.put("pageSize", "1");
				jsonArray=response(mapTest, test);			
				if(jsonArray.size()!=1){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				}	
			
				test = "curPage为超过页数限制，提示成功，返回无结果";
				mapTest.clear();
				mapTest.put("curPage", "100000");//此为固定值，后期如果发现报错，请检查页数是否已经达到第4页内容
				jsonArray=response(mapTest, test);
				if(jsonArray.size()!=0){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 		
				
				test = "curPage为非int值，提示错误，返回无结果";
				mapTest.put("curPage", "发送");//此为固定值，后期如果发现报错，请检查页数是否已经达到第4页内容
				mapTest.put("pageSize", "10000");
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size()!=0 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
		
				test = "curPage为0值，提示错误，返回无结果";
				mapTest.put("curPage", 0);//此为固定值，后期如果发现报错，请检查页数是否已经达到第4页内容
				mapTest.put("pageSize", "10000");
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size()!=0 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				//pageSize
				mapTest.clear();
				test = "pageSize为0值，提示成功，返回无内容";
				mapTest.put("pageSize", 0);
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() >20 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
		
				test = "pageSize为10值，提示成功，返回10条数";
				mapTest.put("pageSize",10);
				jsonArray=response(mapTest, test);			
				if( jsonArray !=null && jsonArray.size() >10 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
		
				test = "pageSize为大于库中的所有数据，提示成功，返回库中所有数据";
				mapTest.put("pageSize",1000);
				jsonArray=response(mapTest, test);			
				if( jsonArray !=null && jsonArray.size() >1000 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
		

				test = "pageSize为空，提示成功，返回库中20条数据";
				mapTest.remove("pageSize");
				jsonArray=response(mapTest, test);			
				if( jsonArray !=null && jsonArray.size() >20 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
		
				
				test = "pageSize为非int值，提示错误，返回无结果";
				mapTest.put("pageSize", "10000突然#￥告诉.0");
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size()!=0 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				//组合查询
				mapTest.clear();
				test = "roleName为模糊查询,curPage为1，pageSize为10，提示成功，返回roleName第1页面10条内容";
				mapTest.put("roleName", "测试");	
				mapTest.put("curPage", "1");	
				mapTest.put("pageSize", "10");	
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() >10 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				
				
				
				
				test = "roleName为模糊查询,curPage为2，pageSize为30，提示成功，返回roleName第1页面30条后剩余的第二页30条内容";
				mapTest.put("roleName", "测试");	
				mapTest.put("curPage", "2");	
				mapTest.put("pageSize", "30");	
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() >30 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				test = "roleName为精确查询,curPage为2，pageSize为1，提示成功，返回无内容";
				mapTest.put("roleName", "管理员");	
				mapTest.put("curPage", "2");	
				mapTest.put("pageSize", "1");	
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() >30 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				test = "roleName为空,curPage为10，pageSize为1，提示成功，返回全部内容中的第10页第一条内容";
				mapTest.put("roleName", "");	
				mapTest.put("curPage", "10");	
				mapTest.put("pageSize", "1");	
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() >1 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				mapTest.clear();
				test = "roleName为模糊查询,curPage为2，pageSize为空，提示成功，返回相应内容";
				mapTest.put("roleName", "测试");	
				mapTest.put("curPage", "2");	
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() >20 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				mapTest.clear();
				test = "roleName为模糊查询,curPage为空，pageSize为3，提示成功，返回相应内容";
				mapTest.put("roleName", "测试");	
				mapTest.put("pageSize", 3);	
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() >3 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				
				mapTest.clear();
				test = "roleName为模糊查询,curPage为非int值，pageSize为非int值，提示错误，返回相应内容";
				mapTest.put("roleName", "测试");	
				mapTest.put("pageSize", "阿发达");	
				mapTest.put("curPage", "2.00");	
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() >0 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				
				mapTest.clear();
				test = "在第一页返回全部角色，提示成功";
				mapTest.put("pageSize", 1000);	
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() <1 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
				if((total == jsonArray.size())==false){
					list.add("total数量检查不正确"+jsonArray);
				}
				
				test="查询最后一页最后一条数据，提示成功";
				mapTest.put("curPage", total);	
				mapTest.put("pageSize", 1);	
				jsonArray=response(mapTest, test);
				if( jsonArray !=null && jsonArray.size() !=1 ){
					list.add(test+"   jsonArray.size:"+jsonArray.size()+" 返回的长度与预期值不相同\n");
				} 
						
				 new printErr(list);
		 
	}

	public static JSONArray response(HashMap<String, Object> parameter, String test) {
//		if(test.contains("=")){
//			
//		}else{
//			return null;
//		}
		String request=requestValues.request(parameter);
		String response = get.sendGet(sit, request); // 发送请求
		JSONObject jsonObj = JSONObject.fromObject(response);// 接收请求
		@SuppressWarnings("unchecked")
		// 将响应添加到map
		HashMap<String, Object> map = new HashMap<String, Object>(jsonObj);
		list=checkStatus.checkStatus(response, test,list);	
		if(map.get("status").equals(200)==false){
			System.out.println();
			return null;
		}
		jsonObj = JSONObject.fromObject(jsonObj.get("data"));// 处理请求
		 total = (int) jsonObj.get("total");
		JSONArray jsonArray = JSONArray.fromObject(jsonObj.get("roles"));
		
		//检查total的值与内容中的数量是否相同
		System.out.println("request:"+request);
		for(int i=0;i<jsonArray.size();i++){
			System.out.println(jsonArray.get(i));
			checkForm(jsonArray.get(i).toString());
		}
		System.out.println("jsonArray大小:"+jsonArray.size());
		System.out.println(response);
		System.out.println();
		return jsonArray;
	}
	public static void checkForm(String json){
		JSONObject js = JSONObject.fromObject(json);
		try {
			Pattern pattern = Pattern.compile("[0-9]+"); // 使用正则表达式
			Matcher isNum = pattern.matcher(js.get("id").toString());
			if(js.containsKey("id")==false || isNum.matches()==false){
				list.add("格式id检查不正确:"+js);
			}
			 pattern = Pattern.compile(".+"); // 使用正则表达式
			 isNum = pattern.matcher(js.get("roleName").toString());
			if(js.containsKey("id")==false || isNum.matches()==false){
				list.add("格式id检查不正确:"+js);
			}									
		} catch (Exception e) {
			list.add("格式检查发生异常:"+js+"\n");
		}
		
		
	}
	
	
}
