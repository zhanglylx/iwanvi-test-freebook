package Methods_summarize;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import jir.CookiesUpdata;

public class 发送GET请求 {
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */

	public static String Get(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");
			((HttpURLConnection) connection).setRequestMethod("GET");
			connection.setRequestProperty("Accept-Encoding", "chunked");
			connection.setRequestProperty("Cookie", CookiesUpdata.Cookies);			
			// 建立实际的连接
			connection.connect();
			int getResponseCode = 0;
			getResponseCode = ((HttpURLConnection) connection).getResponseCode();
			if (getResponseCode != 200) {// 检查服务器响应
				System.out.println("服务器响应不是200" + "；响应：" + getResponseCode + "URL:" + url);
			}
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			//setCookies(map);
			// for (StringText key : map.keySet()) {
			// if(map.get("Set-Cookie")==null){break;}
			// sendGet=sendGet.substring(1, sendGet.length()-1); //去掉中括号
			// StringBuilder sb = new
			// StringBuilder(sendGet);//构造一个StringBuilder对象
			// sb.insert(1, "正在学习");//在指定的位置1，插入指定的字符串
			// str1 = sb.toString();
			// }
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
		return result.toString();

	}
}
