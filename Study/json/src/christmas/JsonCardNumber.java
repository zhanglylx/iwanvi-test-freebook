package christmas;

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

//
//23号24号已测试完毕
public class JsonCardNumber {
	public static void main(String[] args) throws InterruptedException {
		int so = 0;
		int gou = 0;
		int yue = 0;
		int du = 0;
		int da = 0;
		int li = 0;
		int bao = 0;
		int so1 = 0;
		int gou1 = 0;
		int yue1 = 0;
		int du1 = 0;
		int da1 = 0;
		int li1 = 0;
		int bao1 = 0;
		int num = 0;
		int number = 1;
		while (true) {
			num = num + 1;
			String urlDuiHuan = "http://ot.yuedu.sogou.com/abs/activity/christmas/ajax/exchange?cuuid=869042020141273&imsi=&ppid=zhanglianyu2@sogou.com&versioncode=3701&s=&token=e4da66f2057dcd220d8e17889350e067&eid=9999&gender=0";
			String json = loadJSON(urlDuiHuan);

			System.out.println(json);
			String arrjson[];
			String reward;
			arrjson = json.split("\"cards\":");
			arrjson = arrjson[1].split("}");
			reward = arrjson[0].trim();
			reward = reward + "}";
			JSONObject a = JSONObject.fromObject(reward);

			so = (int) a.get("so");
			gou = (int) a.get("gou");
			yue = (int) a.get("yue");
			du = (int) a.get("du");
			da = (int) a.get("da");
			li = (int) a.get("li");
			bao = (int) a.get("bao");
			System.out.println("so:" + so);
			System.out.println("gou:" + gou);
			System.out.println("yue:" + yue);
			System.out.println("du:" + du);
			System.out.println("da:" + da);
			System.out.println("li:" + li);
			System.out.println("bao:" + bao);

			if (so == 0 || gou == 0 || yue == 0 || du == 0) {
				if (json.contains("机会")) {

				} else {
					JOptionPane.showMessageDialog(null, "搜狗阅读为0时返回不正确:json=" + json, "提示", JOptionPane.WARNING_MESSAGE);
				}
			}
			if (da == 0 || li == 0 || bao == 0) {
				if (json.contains("大礼包")) {
					JOptionPane.showMessageDialog(null, "搜狗阅读大礼包为0时返回不正确:json=" + json, "提示",
							JOptionPane.WARNING_MESSAGE);

				}
			}

			if (num < 2) {
				if (number == 1) {
					so1 = so;
					gou1 = gou;
					yue1 = yue;
					du1 = du;
					da1 = da;
					li1 = li;
					bao1 = bao;
					number = 2;
				}
			}
			if (num > 1) {
				if (so1 != 0) {
					so1 = so1 - 1;
				}
				if (gou1 != 0) {
					gou1 = gou1 - 1;
				}
				if (yue1 != 0) {
					yue1 = yue1 - 1;
				}
				if (du1 != 0) {
					du1 = du1 - 1;
				}
				if (da != 0 && li != 0 && bao != 0) {
					if (da1 != 0) {
						da1 = da1 - 1;
					}
					if (li1 != 0) {
						li1 = li1 - 1;
					}
					if (bao1 != 0) {
						bao1 = bao1 - 1;
					}
				}
				if (so1 != so) {
					JOptionPane.showMessageDialog(null, "so不正确:SO=" + so + "；so1:" + so1, "提示",
							JOptionPane.WARNING_MESSAGE);
				}

				if (gou1 != gou) {
					JOptionPane.showMessageDialog(null, "gou不正确:gou=" + gou + "；gou1:" + gou1, "提示",
							JOptionPane.WARNING_MESSAGE);
				}

				if (yue1 != yue) {
					JOptionPane.showMessageDialog(null, "yue不正确:yue=" + yue + "；yue1:" + yue1, "提示",
							JOptionPane.WARNING_MESSAGE);
				}

				if (du1 != du) {
					JOptionPane.showMessageDialog(null, "du不正确:du=" + du + "；du1:" + du1, "提示",
							JOptionPane.WARNING_MESSAGE);
				}



				if (da1 != da) {
					JOptionPane.showMessageDialog(null, "da不正确:da=" + da + "；da1:" + da1, "提示",
							JOptionPane.WARNING_MESSAGE);
				}

				if (li1 != li) {
					JOptionPane.showMessageDialog(null, "li不正确:li=" + li + "；li1:" + li1, "提示",
							JOptionPane.WARNING_MESSAGE);
				}

				if (bao1 != bao) {
					JOptionPane.showMessageDialog(null, "bao不正确:bao=" + bao + "；bao1:" + bao1, "提示",
							JOptionPane.WARNING_MESSAGE);
				}


				so = so1;
				gou = gou1;
				yue = yue1;
				du = du1;
				da = da1;
				li = li1;
				bao = bao1;
				number = 1;

			}

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