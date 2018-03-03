package 品牌地图联动查询;

import java.util.HashMap;

public class testData {
	/**
	 * 
	 * @param i  获取第几条用例，为0时的key为for，值为用例存在多少条+1
	 * @return 返回map集合，集合中包含测试用例说明Key:data
	 */
	public static HashMap<String, Object> data(int i){
		HashMap<String,Object> map = new HashMap<String,Object>();
		switch (i) {
		case 1:
			map.put("searchKey", "ad");
			map.put("size", 0);
			map.put("data", "size有效等价类:0");
			break;
		case 2:
			map.put("searchKey", "ad");
			map.put("size", 100);
			map.put("data", "size有效等价类:100");
			break;
		case 3:
			map.put("searchKey", "ad");
			map.put("size", 1);
			map.put("data", "size有效等价类:1");
			break;
		case 4:
			map.put("searchKey", "ad");
			map.put("size", Integer.MAX_VALUE);
			map.put("data", "size有效等价类:Integer.MAX_VALUE");
			break;
		case 5:
			map.put("searchKey", "ad");
			map.put("size", "");
			map.put("data", "size有效等价类:\"\"");
			break;
		case 6:
			map.put("searchKey", "ad");
			map.put("data", "size有效等价类:不携带Key");
			break;
		case 7:
			map.put("searchKey", "ad");
			map.put("size", null);
			map.put("data", "size有效等价类:"+null);
			break;
		case 8:
			map.put("searchKey", "ad");
			map.put("size", "15");
			map.put("data", "size有效等价类:\"15\"");
			break;
		case 9:
			map.put("searchKey", "ad");
			map.put("size", -1);
			map.put("data", "size无效等价类:-1");
			break;
		case 10:
			map.put("searchKey", "ad");
			map.put("size", Integer.MAX_VALUE+1);
			map.put("data", "size无效等价类:Integer.MAX_VALUE+1");
			break;
		case 11:
			map.put("searchKey", "ad");
			map.put("size", "ceshi");
			map.put("data", "size无效等价类:ceshi");
			break;
		case 12:
			map.put("searchKey", "ad");
			map.put("size", "中文");
			map.put("data", "size无效等价类:中文");
			break;
		case 13:
			map.put("searchKey", "ad");
			map.put("size", "@#@#@￥￥@！%");
			map.put("data", "size无效等价类:@#@#@￥￥@！%");
			break;
		case 14:
			map.put("searchKey", "ad");
			map.put("size", "5hghg#@afg地方");
			map.put("data", "size无效等价类:5hghg#@afg地方");
			break;
		//searchKey
		case 15:
			map.put("searchKey", "");
			map.put("size", 100);
			map.put("data", "searchKey有效等价类:\"\"");
			break;
		case 16:
			map.put("searchKey", "北京万达广场");
			map.put("size", 100);
			map.put("data", "searchKey有效等价类:北京万达广场");
			break;
		case 17:
			map.put("searchKey", "wanda");
			map.put("size", 100);
			map.put("data", "searchKey有效等价类:wanda");
			break;
		case 18:
			map.put("searchKey", "安抚撒旦飞洒地方撒旦飞洒地方撒旦嘎嘎撒地方3#@#@#tafsadf5641465454654545");
			map.put("size", 100);
			map.put("data", "searchKey有效等价类:超长有效范围字符串");
			break;
		case 19:
			map.put("searchKey", null);
			map.put("size", 100);
			map.put("data", "searchKey无效等价类:null");
			break;
		case 20:
			map.put("size", 100);
			map.put("data", "searchKey无效等价类:不携带key");
			break;
		case 21:
			map.put("searchKey", "ad");
			map.put("size", 90);
			map.put("data", "组合输入有效等价类");
			break;
		case 22:
			map.put("searchKey", "ad");
			map.put("data", "组合输入有效等价类:不携带size");
			break;
		case 23:
			map.put("searchKey", null);
			map.put("size", "测试");
			map.put("data", "组合输入无效等价类:size和searchKey输入错误数据");
			break;
		case 0://用例条数+1
			map.put("for", 24);
			break;	
		default:
			System.out.println("data没有匹配到数据:"+i);
			System.exit(0);
			break;
		}	
	
		return map;
		
	}
}
