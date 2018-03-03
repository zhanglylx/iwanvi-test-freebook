package CoworkingSpaces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import Methods_summarize.*;
import net.sf.json.JSONObject;

public class get2 {
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	String s;
	long time;
	int timeTask;
	boolean run = false;

	public get2() {
	}

	public get2(long time, int timeTask) {
		this.time = time;
		this.timeTask = timeTask;
	}

	public void run(int GetId, int officeId, String startTimeDate, String endTimeDate, String token) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				check n = new check();
				n.setCheck(GetId - 1, check(get(officeId, startTimeDate, endTimeDate, GetId, token)));
			}
		});
		t.start();
	}

	public boolean checkTime() {
		this.time += this.timeTask;
		while (true) {
			if (System.currentTimeMillis() == this.time) {
				return true;
			}
		}
	}

	public String get(int officeId, String startTimeDate, String endTimeDate, int GetId, String token) {
		check check = new check();
		check.setRunCheck(GetId - 1, true);
		this.run = true;
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = "http://imap.sit.ffan.com/office/book?data="
					+ 转码.getURLEncoderString("{\"officeId\":\"" + officeId + "\",\"useTime\":[{" + "\"startTime\":"
							+ startTimeDate + ",\"endTime\":" + endTimeDate + "}]}")
					+ "&token=" + token;
			// StringText urlNameString =
			// "http://imap.sit.ffan.com/office/cancel?data="+
			// 转码.getURLEncoderString( "{\"startTime\":"+startTimeDate
			// + ",\"endTime\":"+endTimeDate
			// + ",\"bookIds\":\"5"//+officeId
			// + "\",\"orderId\":\"567\"}")+"&"
			// + "token="+token;
			Date dt = new Date();
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			while (true) {
				if (check.checkRun()) {
					break;
				}
			}
			SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
			System.out.println("get" + GetId + ":" + matter1.format(dt));
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			// 建立实际的连接
			connection.connect();
			int getResponseCode = 0;
			getResponseCode = ((HttpURLConnection) connection).getResponseCode();
			// 检查服务器响应
			if (getResponseCode != 200) {
				System.out.println("服务器响应不是200" + "；响应：" + getResponseCode);
			}
			Map<String, List<String>> map = connection.getHeaderFields();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println(GetId - 1 + ":" + result);
		return result;
	}

	public boolean check(String line) {
		JSONObject json = JSONObject.fromObject(line);
		if (json.get("status").equals(200)) {
			return true;
		}
		return false;
	}
}
