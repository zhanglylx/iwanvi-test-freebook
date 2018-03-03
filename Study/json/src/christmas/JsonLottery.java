package christmas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import net.sf.json.JSONObject;
/**
 *   author:zhanglianyu
 *   date:2016年12月23日
 *   以下代码测试搜狗阅读圣诞活动抽奖接口，测试实物奖和搜豆的获取概率和获取限制是否正确
 *   主要以预先写入参数，对比抽奖接口返回json中参数是否和预先设定好的参数相等
 */
public class JsonLottery {
	public static void main(String[] args) throws InterruptedException {
		int index = 0; // 循环次数
		int n = 4;// 指定抽奖骰子数 //需要到抽奖URL请求打开pos
		String date = "2017-03-30";
		/////////////// 当前日期限制数量////////
		// 金汪仔
		int sogouwanoNum = 0;
		int dingzhibaozhenNum = 1;
		int sogoubijibenNum = 0;
		int yamaxun50Num = 1;
		int huafei50Num = 5;
		int jinwangzaiCountNum = 7;
		// 卡片
		int gouNum = 0;
		int baoNum = 0;
		// 四字礼包
		int wangzaiyusanNum = 0;
		int aoyunwangzaiNum = 0;
		int yundongerjiNum = 0;
		// 7字礼包
		int TxueNum = 0;
		int UpanNum = 0;
		int yamaxun100Num = 0;
		int lanyaerjiNum = 0;
		int xiaomi5Num = 0;
		int xiaominoteNum = 0;
		int gangbiNum = 0;

		///////////// json中的奖品////////
		// 金汪仔
		int sogouwano = 0; // 搜狗玩偶
		int dingzhibaozhen = 0; // 定制抱枕
		int sogoubijiben = 0; // 搜狗笔记本
		int yamaxun = 0; // 50元亚马逊
		int huafei = 0; // 50元话费
		int jinwangzaisodou15 = 0; // 搜豆奖励15
		int jinwangzaisodou50 = 0; // 搜豆奖励50
		int jinwangzaiCount = 0;
		// 银汪仔
		int xiaofanjiangli[] = new int[53];
		int yinwangzaisodou2 = 0;
		int yinwangzaisodou10 = 0;
		int yinwangzaiCount = 0;

		// 搜豆
		int sodou2 = 0;
		int sodou6 = 0;
		int sodou8 = 0;
		int sodou12 = 0;
		int sogouCount = 0;
		// 红包宝箱卡片
		int so = 0;
		int gou = 0;
		int yue = 0;
		int du = 0;
		int da = 0;
		int li = 0;
		int bao = 0;
		int hongbaobaoxiangCount = 0;
		// 搜狗阅读
		int wangzaiyusan = 0;
		int aoyunwangzai = 0;
		int yundongerji = 0;
		int jihongbaosodou = 0;
		int sogouyueduCount = 0;
		// 搜狗阅读大礼包
		int Txue = 0;
		int Upan = 0;
		int yamaxun100 = 0;
		int lanyaerji = 0;
		int xiaomi5 = 0;
		int xiaominote = 0;
		int gangbi = 0;
		int dalibaosodou = 0;
		int dalibaoCount = 0;
		// 骰子+1
		int touzi1 = 0;
		// 回到起点
		int huidaoqidian = 0;
		// 统计发生抽奖错误
		int err = 0;
		// 随机抽取用户
		int user = 1;
		// 记录用户信息是否切换
		int usercount = 1;
		int ppidCheck = 1;
		// 无效用户
		int[] userErr = new int[53];
		// 记录打印消费次数
		int count = 500;

		while (true) { // 开启循环，一下变量需要初始化
			if (user == 52) {
				user = 1;
				usercount = usercount + 1;
			}
			if (userErr[user] == user) { // 如果是无效用户，下次循环不在使用此用户
				user = user + 1;
				continue;
			}
			String ppid = "zhanglianyu" + user + "@sogou.com";

			System.out.println("循环次数:" + (index = index + 1));// 循环次数
			int rewardID = 0; // json中的ID;
			int type = 0; // json中的type
			int id = 0; // json中的id
			// 奖品type
			byte xiaofanType = 1;
			byte shiwuType = 2;
			byte sodouType = 3;
			byte kapianType = 4;
			byte touziType = 5;
			// json中的gl
			int gl = 9;
			// json中的gridId
			int rewardGridID = 0;
			int gridID = 10;
			// 清消返缓存
			if (ppidCheck == 1 && usercount < 2) { // 只清空一次用户获取消返的机会
				System.out.println(loadJSON(
						"http://ot.yuedu.sogou.com/" + "abs/activity/christmas/ajax/clearCache?key=free" + ppid));
				ppidCheck = 2;
			}
			// 清实物缓存
			System.out.println(loadJSON(
					"http://ot.yuedu.sogou.com/abs/activity/christmas/ajax/clearCache?key=user_reward" + ppid));
			// 抽奖
			String url = "http://ot.yuedu.sogou.com/abs/activity/christmas/ajax/lottery?" + "ppid=" + ppid
					+ "&token=bfc51a7f4a65d77a38170417517a9125&eid=1268&versioncode=3700&cli=0&gender=0&uuid=89948f15-e6ba-440b-a50f-0f6e1de0d44e&imsi=460031697518567"
					 +"&pos="+n
					;          
			String json = loadJSON(url);// 访问url并获取json
			System.out.println(json);
			String arrjson[];
			String reward;
			loadJSON(
					"http://ot.yuedu.sogou.com/abs/activity/christmas/ajax/clearCache?key=user_rewardzhanglianyu1@sogou.com");
			
			byte status = 0; // 判断是否是回到起点
			// 获取reward
			if (json.contains("\"reward\":") && json.contains("gridId")) { // 分割json
				arrjson = json.split("\"reward\":");
				arrjson = arrjson[1].split("},\"gridId\"");
				reward = arrjson[0].trim();
				reward = reward + "}";
				JSONObject a = JSONObject.fromObject(reward);
				rewardGridID = (int) a.get("gridId");
				rewardID = (int) a.get("id");
				id = (int) a.get("rewardId");
				gl = (int) a.get("gl");
				type = (int) a.get("type");
				if (id != rewardID) { // 判断id
					JOptionPane.showMessageDialog(null,
							"rewardGridID与rewardID不相符;rewardGridID:" + rewardGridID + ";rewardID:" + rewardID, "提示",JOptionPane.WARNING_MESSAGE);
				}
			} else if (json.contains("{\"status\":\"succ\",\"startPos\":") && json.contains("\"endPos\":0")) {
				huidaoqidian = huidaoqidian + 1; // 回到起点
				status = 1;
			} else if (json.contains("用户无效")) {// 判断用户信息是否有效
				userErr[user] = user;// 记录是否是无效用户
				user = user + 1; // 切换账户
				System.out.println("无效:--------------------------------------------------" + ppid);
				ppidCheck = 1;
				index = index - 1;

				// 发生错误不计算在index统计中
				continue;
			} else { // 清空抽奖次数

				if (err == index && (json.contains("用户无效") == false) && usercount > 3) {// 连续发生两次错误弹出提示框
					JOptionPane.showMessageDialog(null, "连续发生抽奖错误，请检查", "提示", JOptionPane.WARNING_MESSAGE);
					err = 0;
				}
				err = index;
				index = index - 1; // 发生错误不计算在index统计中
				user = user + 1; // 发生抽奖无效或其他错误时，切换账户
				ppidCheck = 1;
				System.out.println(loadJSON("http://ot.yuedu.sogou.com" + "/abs/activity/christmas/ajax/"
						+ "clearCache?key=chance" + date + ppid));
				continue;
			}
			// 获取gridID中的gridID
			if (status == 0) { // 判断是否是回到起点，如果是，不执行奖品对比操作
				JSONObject a = JSONObject.fromObject(json);
				gridID = (int) a.get("gridId");
				if (rewardGridID == gridID) { // 对比gridId和奖品gridId是否相等
					System.out.println("gridId和奖品gridId相等");
					byte i = 0; // 记录奖品type和gl
					if (rewardGridID == 1) { // 金汪仔
						// 验证id是否是gridID中的奖品
						System.out.println("抽中了金汪仔:" + rewardID);
						jinwangzaiCount = jinwangzaiCount + 1;
						switch (rewardID) {
						case 1:
							if (type != shiwuType || gl != 0) {
								i = 1;
							}
							sogouwano = sogouwano + 1;
							break;
						case 2:
							if (type != shiwuType || gl != 0) {
								i = 2;
							}
							dingzhibaozhen = dingzhibaozhen + 1;
							break;
						case 3:
							if (type != shiwuType || gl != 0) {
								i = 3;
							}
							sogoubijiben = sogoubijiben + 1;
							break;
						case 4:
							if (type != shiwuType || gl != 0) {
								i = 4;
							}
							yamaxun = yamaxun + 1;
							break;
						case 5:
							if (type != shiwuType || gl != 0) {
								i = 5;
							}
							huafei = huafei + 1;
							break;
						case 6:
							if (type != sodouType || gl != 15) {
								i = 6;
							}
							jinwangzaisodou15 = jinwangzaisodou15 + 1;
							break;
						case 7:
							if (type != sodouType || gl != 50) {
								i = 7;
							}
							jinwangzaisodou50 = jinwangzaisodou50 + 1;
							break;
						default:
							JOptionPane.showMessageDialog(null, "gridID:" + gridID + ";rewardGridID:"+ rewardGridID + ";rewardID:" + rewardID, "提示", JOptionPane.WARNING_MESSAGE);
							break;
						}
					} else if (rewardGridID == 2) { // 银汪仔
						System.out.println("抽中了银汪仔:" + rewardID);
						yinwangzaiCount = yinwangzaiCount + 1;
						switch (rewardID) {
						case 8:
							if (type != xiaofanType || gl != 0) {
								i = 8;
							}
							xiaofanjiangli[user] = xiaofanjiangli[user] + 1;
							break;
						case 9:
							if (type != sodouType || gl != 2) {
								i = 9;
							}
							yinwangzaisodou2 = yinwangzaisodou2 + 1;
							break;
						case 10:
							if (type != sodouType || gl != 10) {
								i = 10;
							}
							yinwangzaisodou10 = yinwangzaisodou10 + 1;
							break;
						default:
							JOptionPane.showMessageDialog(null, "gridID:" + gridID + ";rewardGridID:"+ rewardGridID + ";rewardID:" + rewardID, "提示", JOptionPane.WARNING_MESSAGE);
							break;
						}
					} else if (rewardGridID == 3) { // 搜豆
						System.out.println("抽中了搜豆" + rewardID);
						sogouCount = sogouCount + 1;
						switch (rewardID) {
						case 11:
							if (type != sodouType || gl != 2) {
								i = 11;
							}
							sodou2 = sodou2 + 1;
							break;
						case 12:
							if (type != sodouType || gl != 6) {
								i = 12;
							}
							sodou6 = sodou6 + 1;
							break;
						case 13:
							if (type != sodouType || gl != 8) {
								i = 13;
							}
							sodou8 = sodou8 + 1;
							break;
						case 14:
							if (type != sodouType || gl != 12) {
								i = 14;
							}
							sodou12 = sodou12 + 1;
							break;
						default:
							JOptionPane.showMessageDialog(null, "gridID:" + gridID + ";rewardGridID:"+ rewardGridID + ";rewardID:" + rewardID, "提示", JOptionPane.WARNING_MESSAGE);
							break;
						}
					} else if (rewardGridID == 4) { // 红包宝箱
						hongbaobaoxiangCount = hongbaobaoxiangCount + 1;
						System.out.println("抽中了红包宝箱中的卡片：" + rewardID);
						switch (rewardID) {
						case 15:
							if (type != kapianType || gl != 0) {
								i = 15;
							}
							so = so + 1;
							break;
						case 16:
							if (type != kapianType || gl != 0) {
								i = 16;
							}
							gou = gou + 1;
							break;
						case 17:
							if (type != kapianType || gl != 0) {
								i = 17;
							}
							yue = yue + 1;
							break;
						case 18:
							if (type != kapianType || gl != 0) {
								i = 18;
							}
							du = du + 1;
							break;
						case 19:
							if (type != kapianType || gl != 0) {
								i = 19;
							}
							da = da + 1;
							break;
						case 20:
							if (type != kapianType || gl != 0) {
								i = 20;
							}
							li = li + 1;
							break;
						case 21:
							if (type != kapianType || gl != 0) {
								i = 21;
							}
							bao = bao + 1;
							break;
						default:
							JOptionPane.showMessageDialog(null,  "gridID:" + gridID + ";rewardGridID:"+ rewardGridID + ";rewardID:" + rewardID, "提示", JOptionPane.WARNING_MESSAGE);
							break;
						}
					} else if (rewardGridID == 5) { // 搜狗阅读卡片
						sogouyueduCount = sogouyueduCount + 1;
						System.out.println("抽中了搜狗阅读卡片奖:" + rewardID);
						switch (rewardID) {
						case 22:
							if (type != shiwuType || gl != 0) {
								i = 22;
							}
							wangzaiyusan = wangzaiyusan + 1;
							break;
						case 23:
							if (type != shiwuType || gl != 0) {
								i = 23;
							}
							aoyunwangzai = aoyunwangzai + 1;
							break;
						case 24:
							if (type != shiwuType || gl != 0) {
								i = 24;
							}
							yundongerji = yundongerji + 1;
							break;
						case 25:
							if (type != sodouType || gl != 200) {
								i = 25;
							}
							jihongbaosodou = jihongbaosodou + 1;
							break;
						default:
							JOptionPane.showMessageDialog(null,  "gridID:" + gridID + ";rewardGridID:"+ rewardGridID + ";rewardID:" + rewardID, "提示", JOptionPane.WARNING_MESSAGE);
							break;
						}
					} else if (rewardGridID == 6) { // 搜狗阅读大礼包
						System.out.println("抽中了搜狗阅读大礼包" + rewardID);
						dalibaoCount = dalibaoCount + 1;
						switch (rewardID) {
						case 26:
							if (type != shiwuType || gl != 0) {
								i = 26;
							}
							Txue = Txue + 1;
							break;
						case 27:
							if (type != shiwuType || gl != 0) {
								i = 27;
							}
							Upan = Upan + 1;
							break;
						case 28:
							if (type != shiwuType || gl != 0) {
								i = 28;
							}
							yamaxun100 = yamaxun100 + 1;
							break;
						case 29:
							if (type != shiwuType || gl != 0) {
								i = 29;
							}
							lanyaerji = lanyaerji + 1;
							break;
						case 30:
							if (type != shiwuType || gl != 0) {
								i = 30;
							}
							xiaomi5 = xiaomi5 + 1;
							break;
						case 31:
							if (type != shiwuType || gl != 0) {
								i = 31;
							}
							xiaominote = xiaominote + 1;
							break;
						case 32:
							if (type != sodouType || gl != 0) {
								i = 32;
							}
							gangbi = gangbi + 1;
							break;
						case 33:
							if (type != sodouType || gl != 1000) {
								i = 33;
							}
							dalibaosodou = dalibaosodou + 1;
							break;
						default:
							JOptionPane.showMessageDialog(null, "没有找到rewardGridID" + rewardGridID, "提示",JOptionPane.WARNING_MESSAGE);
							break;
						}
					} else if (rewardGridID == 7) { // 骰子+1
						System.out.println("抽中了骰子+1:" + rewardID);
						switch (rewardID) {
						case 34:
							if (type != touziType || gl != 0) {
								i = 34;
							}
							touzi1 = touzi1 + 1;
							break;
						default:
							JOptionPane.showMessageDialog(null, "rewardID:" + "gridID:" + gridID + ";rewardGridID:"+ rewardGridID + ";rewardID:" + rewardID, "提示", JOptionPane.WARNING_MESSAGE);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "rewardID:" + "gridID:" + gridID + ";rewardGridID:"+ rewardGridID + ";rewardID:" + rewardID, "提示", JOptionPane.WARNING_MESSAGE);
					}
					if (i != 0) { // 验证rewardID对应的type类型和gl是否正确
						JOptionPane.showMessageDialog(null,
								"type或gl不正确:" + "gridID:" + gridID + ";rewardGridID:" + rewardGridID + ";rewardID:"+ rewardID + ";type" + type + ";gl:" + gl + ";i:" + i,"提示", JOptionPane.WARNING_MESSAGE);
					} else {
						System.out.println("type和gl验证通过");
					}
				} else {
					JOptionPane.showMessageDialog(null,"gridID不相等:" + "gridID:" + gridID + ";rewardGridID:" + rewardGridID, "提示",JOptionPane.WARNING_MESSAGE);
				}
			}
			// 金汪仔的实物奖励判断
			System.out.println("金汪仔获取的次数:" + jinwangzaiCount);
			System.out.println("搜狗玩偶获取次数:" + sogouwano);
			if (sogouwano > sogouwanoNum) {
				JOptionPane.showMessageDialog(null, "搜狗玩偶赠送超标了,sogouwanoRewardId:" + sogouwano + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("搜狗抱枕获取次数:" + dingzhibaozhen);
			if (dingzhibaozhen > dingzhibaozhenNum) {
				JOptionPane.showMessageDialog(null,"搜狗抱枕赠送超标了,dingzhibaozhenRewardId:" + dingzhibaozhen + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("搜狗笔记本获取次数:" + sogoubijiben);
			if (sogoubijiben > sogoubijibenNum) {
				JOptionPane.showMessageDialog(null, "搜狗笔记本赠送超标了,sogoubijibenRewardId:" + sogoubijiben + ";date:" + date,"提示", JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("搜狗50亚马逊获取次数:" + yamaxun);
			if (yamaxun > yamaxun50Num) {
				JOptionPane.showMessageDialog(null, "搜狗50亚马逊赠送超标了,yamaxunRewardId:" + yamaxun + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("搜狗50话费获取次数:" + huafei);
			if (huafei > huafei50Num) {
				JOptionPane.showMessageDialog(null, "搜狗50话费赠送超标了,huafeiRewardId:" + huafei + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);
			}
			int number = (sogouwano + dingzhibaozhen + sogoubijiben + yamaxun + huafei);
			if (number > jinwangzaiCountNum) {
				JOptionPane.showMessageDialog(null, "搜狗金汪仔总数赠送超标了,count:"+ (sogouwano + dingzhibaozhen + sogoubijiben + yamaxun + huafei) + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("金汪仔搜豆15:" + jinwangzaisodou15);
			System.out.println("金汪仔搜豆50:" + jinwangzaisodou50);
			System.out.println();

			// 银汪仔
			System.out.println("银汪仔获取的次数:" + yinwangzaiCount);
			System.out.println("银汪仔消返:" + "ppid:" + ppid + ":" + xiaofanjiangli[user]);
			System.out.println("银汪仔搜豆奖励2：" + yinwangzaisodou2);
			System.out.println("银汪仔搜豆奖励10:" + yinwangzaisodou10);
			if (index == count) {
				count = index + 500;
				for (int i = 1; i < xiaofanjiangli.length; i++) {
					System.out.println("所有用户获得消返-------------------------------------");
					System.out.println("zhanglianyu" + i + "@sogou.com" + ",消返次数:" + xiaofanjiangli[i] + "-----");
					System.out.println("=========================================");
				}
			}
			if (xiaofanjiangli[user] > 1) {
				JOptionPane.showMessageDialog(null,"银汪仔消费获得次数大于1，" + "xiaofanjiangli:" + xiaofanjiangli[user] + "user:" + ppid + ";date:" + date,"提示", JOptionPane.WARNING_MESSAGE);
			}
			System.out.println();
			// 搜豆
			System.out.print("搜豆获取的次数:" + sogouCount);
			System.out.print("  搜豆2：" + sodou2);
			System.out.print("  搜豆6：" + sodou6);
			System.out.print("  搜豆8：" + sodou8);
			System.out.println("  搜豆12：" + sodou12);
			System.out.println();
			// 卡片
			System.out.println("红包宝箱获取的次数:" + hongbaobaoxiangCount);
			System.out.print("搜:" + so + ",狗:" + gou + ",阅" + yue + ",读:" + du);
			System.out.println("大:" + da + ",礼:" + li + ",包:" + bao);
			System.out.println();
			if (gou > gouNum) {
				JOptionPane.showMessageDialog(null, "狗卡片赠多了，gou" + gou + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);
			}
			if (bao > baoNum) {
				JOptionPane.showMessageDialog(null, "包卡片赠多了，bao" + bao + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);
			}

			// 搜狗阅读卡片兑换
			System.out.println("搜狗阅读集红包获取的次数:" + sogouyueduCount);
			if (wangzaiyusan > wangzaiyusanNum) {
				JOptionPane.showMessageDialog(null, "雨伞赠多了，wangzaiyusan" + wangzaiyusan + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);
			}
			if (aoyunwangzai > aoyunwangzaiNum) {
				JOptionPane.showMessageDialog(null, "奥运赠多了，aoyunwangzai" + aoyunwangzai + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);

			}
			if (yundongerji > yundongerjiNum) {
				JOptionPane.showMessageDialog(null, "运动耳机赠多了，yundongerji" + yundongerji + ";date:" + date, "提示",JOptionPane.WARNING_MESSAGE);
			}
			System.out.print("搜狗阅读集红包实物奖雨伞：" + wangzaiyusan);
			System.out.print("  奥运：" + aoyunwangzai);
			System.out.print("  耳机：" + yundongerji);
			System.out.println("  奖励：" + jihongbaosodou);
			System.out.println();
			// 搜狗大礼包
			System.out.println("大礼包获取的次数" + dalibaoCount);
			if (Txue > TxueNum) {
				JOptionPane.showMessageDialog(null, "T恤赠多了，Txue" + Txue + ";date:" + date, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (Upan > UpanNum) {
				JOptionPane.showMessageDialog(null, "U盘赠多了，Upan" + Upan + ";date:" + date, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (yamaxun100 > yamaxun100Num) {
				JOptionPane.showMessageDialog(null, "亚马逊100赠多了，yamaxun100" + yamaxun100 + ";date:" + date, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (lanyaerji > lanyaerjiNum) {
				JOptionPane.showMessageDialog(null, "蓝牙耳机赠多了，lanyaerji" + lanyaerji + ";date:" + date, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (xiaomi5 > xiaomi5Num) {
				JOptionPane.showMessageDialog(null, "小米5赠多了，xiaomi5" + xiaomi5 + ";date:" + date, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (xiaominote > xiaominoteNum) {
				JOptionPane.showMessageDialog(null, "小米note赠多了，xiaominote" + xiaominote + ";date:" + date, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (gangbi > gangbiNum) {
				JOptionPane.showMessageDialog(null, "钢笔赠多了，gangbi" + gangbi + ";date:" + date, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			System.out.print("大礼包T恤:" + Txue);
			System.out.print("  U盘:" + Upan);
			System.out.print("  亚马逊:" + yamaxun100);
			System.out.print("  小米5:" + xiaomi5);
			System.out.print("  小米note:" + xiaominote);
			System.out.print("  钢笔:" + gangbi);
			System.out.println("  搜豆:" + dalibaosodou);
			System.out.println();
			// 骰子+1
			System.out.print("骰子+1：" + touzi1);
			// 回到起点
			System.out.println("      回到起点:" + huidaoqidian);
			// 用户信息
			System.out.println("账户:" + ppid);
			System.out.println();
			// Thread.sleep(2000);
		}
	}

	public static String loadJSON(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return json.toString();
	}
}
