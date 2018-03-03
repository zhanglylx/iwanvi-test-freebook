package 免费电子书;


import java.util.LinkedHashMap;

import java.util.Map.Entry;
import net.sf.json.JSONObject;

/**
 * 测试广告展现顺序逻辑 测试前需要在后台配置单日广告总量数 在redis中清空缓存
 * getAd请求的广告为写死3位置
 * 用户为单用户
 * 注意：log的显示顺序为执行次数日志，每一次的请求响应，<<>>中的内容为检查不正确项，统计次数
 * 脚本运行机制：
 * 第一步：
 * 		配置环境，发送请求getAd  拼接userId和广告位id
 * 第二步：
 * 		判断响应是否为空，如果为空继续下一次循环
 * 		接收请求的getAd响应，取出id，advId，adId拼接在发送上报请求中
 * 第三步：
 * 		判断上传的响应，如果返回0，给id+1
 * 第四步：
 * 		根据后台配置的数据判断id的总数是否与后台限制相同
 * 第五步：
 * 		打印log
 * @author Administrator
 *
 */
public class 测试后台统计用户点击量_曝光量_广告总点击量_广告总曝光量 {
	
	//单日总单击两  type 1为点击  0为曝光
	final static int type = 1;
	//统计用户获取广告出现的次数
	static LinkedHashMap<String, Integer> userMap = new LinkedHashMap<String, Integer>();
	//获取广告出现的次数
	static LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();	
	public static void main(String[] args) {
		TestPvAndUv pvUv = new TestPvAndUv();
		//弹出提示框处理是否要中途退出
		MedialCadence.runningStatus();
		Point list = Point.getPoint();
		int[] userId = createUserIdAndGG.userId();
		// 统计执行次数
		int i = 1;
		// 请求的广告位
		int[] GG = createUserIdAndGG.GG();
		// 执行过程中的广告位数组索引
		int ggArrayIndex = 0;
		//执行过程中的用户数组索引
		int uesrArrayIndex = 0;
		//广告id
		int id=0;
		try {
			while (true) {
				// 判断是否达到循环次数
				if (i > config.executeCount) {
					break;
				}
				// 检测是否提前停止程序
				if (MedialCadence.getMedialCadence().getI()!=0) {
					break;
				}
				list.add("第" + i + "次测试--------------------------------------" + countMap.date());
				ggArrayIndex = ArrayIndex.index(GG, ggArrayIndex);
				// 判断用户达到最大数后为GG从0开始
				uesrArrayIndex = ArrayIndex.index(userId, uesrArrayIndex);
				int userIdData = userId[uesrArrayIndex];
				int GGData = GG[ggArrayIndex];
				//获取用户上一次请求的广告id
				id = pvUv.getRequestCurrId();
				//拼接请求
				String requestData = requestUrl.getAdRequestCurrId(GGData, userIdData, id);		
				// 发送请求广告
				String response = get.sendGet(config.url, requestData);
				ggArrayIndex++;
				uesrArrayIndex++;
				//记录log
				countMap.getList(requestData, response);
				// 检查返回的是否是一个json格式
				check.checkJson(response);
				JSONObject jsonObj = JSONObject.fromObject(response);// 接收请求
				if (!check.checkId(jsonObj, response, i)) {i++;continue;}
				id = Integer.parseInt(jsonObj.get("id").toString());
				
				String exposureRequest = requestUrl.exposureRequest(jsonObj, 0, id, userIdData);
				//发送请求
				String exposureResponse = get.sendGet(config.superior, exposureRequest);
				//将请求和响应添加到list
				countMap.list(exposureRequest, exposureResponse);
				//第三步：
				// 判断响应的json格式是否正确，不正确跳出循环
				check.checkJson(exposureResponse);
				// 处理上传曝光响应数据
				JSONObject js = JSONObject.fromObject(exposureResponse);
				if (js.get("code") == null) {
					//检查上传曝光或上传点击是否成功
					requestUrl.errorPopupWindow("errorPopupWindow返回的code为空");
				} 
				// 判断上报是否成功
				check.checkCode(Integer.parseInt(js.get("code").toString()));	
				pvUv.setJson(response,userIdData);
				if(userIdData>createUserIdAndGG.getRandNum()){
					 exposureRequest = requestUrl.exposureRequest(jsonObj, 1, id, userIdData);
					//发送请求
					 exposureResponse = get.sendGet(config.superior, exposureRequest);
					//将请求和响应添加到list
					countMap.list(exposureRequest, exposureResponse);
					//第三步：
					// 判断响应的json格式是否正确，不正确跳出循环
					check.checkJson(exposureResponse);
					// 处理上传曝光响应数据
					 js = JSONObject.fromObject(exposureResponse);
					if (js.get("code") == null) {
						//检查上传曝光或上传点击是否成功
						requestUrl.errorPopupWindow("errorPopupWindow返回的code为空");
					} 
					// 判断上报是否成功
					check.checkCode(Integer.parseInt(js.get("code").toString()));
					pvUv.addDj();
				}
				System.out.println("第" + i + "次执行完毕");
				i++;
			}	
		} catch (Exception e) {
			System.out.println("出现了未知错误:");
			e.printStackTrace();

		} finally {
			list.printlnList();
			pvUv.print();
		}
		System.out.println("测试完毕");
		System.exit(0);
	}

	
	public static LinkedHashMap<String, Integer> addUv(LinkedHashMap<String, Integer> userMap, 
			LinkedHashMap<String, Integer> uvMap,int user,String GG,int GGid){
		if(!userMap.containsKey(user+GG)){
			uvMap = countMap.mapAdd(map, GG+":"+GGid);
		}
		return uvMap;
	}
}
