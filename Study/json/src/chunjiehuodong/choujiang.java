package chunjiehuodong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import net.sf.json.JSONObject;

/**
 * author:zhanglianyu date:以下代码测试春节活动抽奖接口，测试实物奖和搜豆的获取概率和获取限制是否正确
 * 主要以预先写入参数，对比抽奖接口返回json中参数是否和预先设定好的参数相等
 */
public class choujiang {
	public static void main(String[] args) throws InterruptedException {
		
		while (true) {
			Date dt = new Date();
			SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(matter1.format(dt));
			//Thread.sleep(10000);
			if (matter1.format(dt).contains("0123")) { // 检查日期
				break;
			}
		}

		String[] sgid = { "AVh8f4ZGURdp8gLR7NpvEia0", "AVh9rh2ltqkTqDKIcdhacVI","AVhibBo2dCWttiaE5hKfKfpkI" }; // wap网页登录的sgid，需手动配置
		String[] sgidUser = { "17710893436@sohu.com", "13426283025@sohu.com","15110143307@sohu.com" };// 需要手动配置
		String date = "2017-01-23";// 需要手动配置
		int num = 0;
		boolean loop = true;
		int sgidNum = 0;
		String url;
		int user = 1;
		int[] userErr = new int[53];
		//int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// --------限制的礼物变量-------
		int UpanCount = 0;
		int weidanCount = 0;
		int chongzhika50Count = 0;
		int xiaomi5Count = 0;
		int iphone7Count = 0;
		int vivoCount = 0;
		int yusanCount = 0;
		int tailiCount = 0;
		// 每日的限额
		if (date.equals("2017-01-23") || date.equals("2017-01-24") || date.equals("2017-01-25")
				|| date.equals("2017-01-26")) {
			UpanCount = 2;
			weidanCount = 0;
			chongzhika50Count = 20;
			xiaomi5Count = 0;
			iphone7Count = 0;
			vivoCount = 0;
			yusanCount = 3;
			tailiCount = 5;
			System.out.println("获取到的日期:23,24,25,26");
		} else if (date.equals("2017-01-27") || date.equals("2017-01-28")) {
			UpanCount = 2;
			weidanCount = 1;
			chongzhika50Count = 30;
			xiaomi5Count = 1;
			iphone7Count = 0;
			vivoCount = 0;
			yusanCount = 3;
			tailiCount = 5;
			System.out.println("获取到的日期:27,28");
		} else if (date.equals("2017-01-29") || date.equals("2017-01-30") || date.equals("2017-01-31")
				|| date.equals("2017-02-01") || date.equals("2017-02-02") || date.equals("2017-02-03")
				|| date.equals("2017-02-04")) {
			UpanCount = 2;
			weidanCount = 0;
			chongzhika50Count = 20;
			if (date.equals("2017-01-29")) {
				xiaomi5Count = 1;
				System.out.println("获取到的日期:29");
			} else {
				xiaomi5Count = 0;
				System.out.println("获取到的日期:30,31,01,02,03,04");
			}
			iphone7Count = 0;
			vivoCount = 0;
			yusanCount = 3;
			tailiCount = 5;
		} else if (date.equals("2017-02-05")) {
			UpanCount = 4;
			weidanCount = 0;
			chongzhika50Count = 20;
			xiaomi5Count = 0;
			iphone7Count = 0;
			vivoCount = 0;
			yusanCount = 1;
			tailiCount = 5;
			System.out.println("获取到的日期:05");
		} else {
			System.out.println("没有选择到日期，程序关闭");
			System.exit(0);
		}
		// -------获取到的礼物变量------
		int sodou5 = 0;
		int sodou10 = 0;
		int sodou20 = 0;
		int Upan = 0;
		int weidan = 0;
		int chongzhika50 = 0;
		int xiaomi5 = 0;
		int iphone7 = 0;
		int vivo = 0;
		int yusan = 0;
		int taili = 0;
		int n = 0;
		String ppid = null;
		while (true) {
			System.out.println("--------------------------------------");
			if (loop == true) { // 使用app接口和wap接口测试，这次为app，下次为wap，通过loop判断
				if (user == 52) {
					user = 1;
				}

				if (userErr[user] == user) { // 如果是无效用户，下次循环不在使用此用户
					user = user + 1;
					continue;
				}
				
				ppid = "zhanglianyu" + user + "@sogou.com";
				url = "http://k.sogou.com/abs/activity/spring/ajax/lottery?cuuid=868029027305523&imsi=&ppid="
						+ ppid + "&versioncode=3800&s=&token=b996e0f704387ca40b3544879ff1c6d2&eid=9999&gender=0";
				System.out.println("ppid:" + ppid);
				user = user + 1;
				loop = false; // 下一次走wap接口//loop

			} else {
				System.out.println("sgid:" + sgid[sgidNum]);
				n = sgidNum;
				url = "https://read.sogou.com/h5/activity/spring/ajax/lottery?gf=e-d-pother-i&uID=ibs4P6XcOXRJQAq_&sgid="
						+ sgid[sgidNum];
				loop = true;// 下一次走app接口
				sgidNum = sgidNum + 1;
				if (sgidNum == sgid.length) {
					sgidNum = 0;
				}
			}

			String str = loadJSON(url);// 访问抽奖接口
			// 获取json中的字段
			if (str.contains("succ")) {
			} else if (str.contains("没有抽奖机会了")) {
				System.out.println("没有抽奖机会了:" + str);
				if (loop == false) { // 清缓存//loop== false
					loadJSON("http://10.142.110.234:8080/abs/activity/spring/ajax/clearCache?key=spring_user_chance"
							+ date + ppid);
					loadJSON("http://10.142.110.234:8080/abs/activity/spring/ajax/clearCache?key=spring_user_reward"
							+ ppid);
					System.out.println("清除app抽奖机会：" + ppid);
				} else {
					loadJSON("http://10.142.78.208:8080/h5/activity/spring/ajax/clearCache?key=spring_user_chance"
							+ date + sgidUser[n]);
					if (sgidUser[n].equals("15210873667@sohu.com") == false) {
						loadJSON("http://10.142.78.208:8080/h5/activity/spring/ajax/clearCache?key=spring_user_reward"
								+ sgidUser[n]);
					}
					System.out.println("清除wap抽奖机会：" + sgidUser[n]);
				}
				continue;
			} else if (str.contains("无效") && loop == false) {//loop == false
				System.out.println("用户无效:" + str);
				userErr[user - 1] = user - 1;
				continue;
			} else if (str.contains("登录后才能参与游戏")) {
				if (loop == false) {
					System.out.println("当前账号未登录：" + ppid);
				} else {
					System.out.println("当前账号未登录：" + sgidUser[n]);
				}
				continue;
			} else {
				System.out.println("str有错误：" + str);
				continue;
			}
			String[] arr;
			/*
			JSONObject st = JSONObject.fromObject(str);
			int start = 0;
			start = (int) st.get("start");
			System.out.println("start:"+start);
			if (start != 1 && start != 2 && start != 3 && start != 4 && start != 5 && start != 6 && start != 7
					&& start != 8 && start != 9) {
				JOptionPane.showMessageDialog(null, "start数字不正确，json" + str, "提示", JOptionPane.WARNING_MESSAGE);
			}
			*/
			arr = str.split("\"reward\":");
			str = arr[1];
			arr = str.split(",\"chance\"");
			str = arr[0];
			System.out.println(str);
			JSONObject json = JSONObject.fromObject(str);
			int rewardId = 0;
			rewardId = (int) json.get("rewardId");
			int type = 0;
			type = (int) json.get("type");
			int gl = 0;
			gl = (int) json.get("gl");
			int gridId = 0;
			gridId = (int) json.get("gridId");
			String name = "name";
			name = json.getString("name");
			// 判断json返回的参数是否正确
			if (gridId == 6 && rewardId == 6 && type == 3 && gl == 5 && name.contains("5搜豆")) {
				sodou5 = sodou5 + 1;
				System.out.println("获取到5搜豆");
			} else if (gridId == 2 && rewardId == 2 && type == 3 && gl == 10 && name.contains("10搜豆")) {
				sodou10 = sodou10 + 1;
				System.out.println("获取到10搜豆");

			} else if (gridId == 4 && rewardId == 4 && type == 3 && gl == 20 && name.contains("20搜豆")) {
				sodou20 = sodou20 + 1;
				System.out.println("获取到20搜豆");

			} else if (gridId == 1 && rewardId == 1 && type == 2 && gl == 0 && name.contains("搜狗汪仔U盘")) {
				Upan = Upan + 1;
				System.out.println("获取到搜狗汪仔U盘");

			} else if (gridId == 8 && rewardId == 8 && type == 2 && gl == 0 && name.contains("三星微单")) {
				weidan = weidan + 1;
				System.out.println("获取到三星微单");

			} else if (gridId == 7 && rewardId == 7 && type == 2 && gl == 0 && name.contains("50元话费充值卡")) {
				chongzhika50 = chongzhika50 + 1;
				System.out.println("获取到50元话费充值卡");

			} else if (gridId == 5 && rewardId == 5 && type == 2 && gl == 0 && name.contains("小米5")) {
				xiaomi5 = xiaomi5 + 1;
				System.out.println("获取到小米5");

			} else if (gridId == 9 && rewardId == 9 && type == 2 && gl == 0 && name.contains("iPhone")) {
				iphone7 = iphone7 + 1;
				System.out.println("获取到iPhone 7 Plus");

			} else if (gridId == 3 && rewardId == 3 && type == 2 && gl == 0 && name.contains("vivo")) {
				vivo = vivo + 1;
				System.out.println("获取到vivo");

			} else if (gridId == 1 && rewardId == 10 && type == 2 && gl == 0 && name.contains("汪仔雨伞")) {
				yusan = yusan + 1;
				System.out.println("获取到汪仔雨伞");

			} else if (gridId == 1 && rewardId == 11 && type == 2 && gl == 0 && name.contains("汪仔台历")) {
				taili = taili + 1;
				System.out.println("获取到2017汪仔台历");

			} else {
				JOptionPane.showMessageDialog(null, "获取的信息不再判断条件内，gridId：" + gridId + ",rewardId:" + rewardId + ",type:"
						+ type + ",gl:" + gl + ",name:" + name, "提示", JOptionPane.WARNING_MESSAGE);
			}
			System.out.println("5搜豆获得次数:" + sodou5 + ", 10搜豆获得次数" + sodou10 + ", 20搜豆获得次数:" + sodou20);
			System.out.println("U盘获得次数:" + Upan + ", 微单获得次数:" + weidan + ", 充值卡获得次数:" + chongzhika50);
			System.out.println("小米5获得次数:" + xiaomi5 + ", iphone7获得次数:" + iphone7 + ", vivo获得次数:" + vivo);
			System.out.println("雨伞获得次数:" + yusan + ", 台历获取次数：" + taili);
			// 判断是否超出限额
			if (Upan > UpanCount) {
				JOptionPane.showMessageDialog(null, "Upan超出限额，Upan" + Upan + ",UpanCount:" + UpanCount, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (weidan > weidanCount) {
				JOptionPane.showMessageDialog(null, "weidan超出限额，weidan" + weidan + ",weidanCount:" + weidanCount, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (chongzhika50 > chongzhika50Count) {
				JOptionPane.showMessageDialog(null,
						"chongzhika50超出限额，chongzhika50" + chongzhika50 + ",chongzhika50Count:" + chongzhika50Count,
						"提示", JOptionPane.WARNING_MESSAGE);
			}
			if (xiaomi5 > xiaomi5Count) {
				JOptionPane.showMessageDialog(null, "xiaomi5超出限额，xiaomi5" + xiaomi5 + ",xiaomi5Count:" + xiaomi5Count,
						"提示", JOptionPane.WARNING_MESSAGE);
			}
			if (iphone7 > iphone7Count) {
				JOptionPane.showMessageDialog(null, "iphone7超出限额，xiaomi5" + iphone7 + ",iphone7Count:" + iphone7Count,
						"提示", JOptionPane.WARNING_MESSAGE);
			}
			if (vivo > vivoCount) {
				JOptionPane.showMessageDialog(null, "vivo超出限额，xiaomi5" + vivo + ",vivoCount:" + vivoCount, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (yusan > yusanCount) {
				JOptionPane.showMessageDialog(null, "yusan超出限额，xiaomi5" + yusan + ",yusanCount:" + yusanCount, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			if (taili > tailiCount) {
				JOptionPane.showMessageDialog(null, "taili超出限额，taili" + taili + ",tailiCount:" + tailiCount, "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			num = num + 1;
			System.out.println("循环次数:" + num);
			 //Thread.sleep(500);
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