package jir;

import jir.CookiesUpdata;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HttpRequest {
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            :StringText 发送请求的URL
	 * @param param
	 *            :StringText 请求参数，请求参数应该是 name1=value1&name2=value2 的形式，不要带？。
	 * @param Referer
	 *            :StringText 为请求的从哪一个地址发送
	 * @param AcceptEncoding
	 *            :boolean 为true代码像服务器索要chunked
	 * 
	 * @return URL 所代表远程资源的响应结果 :StringText
	 */

	public static String sendGet(String url, String param, String Referer, boolean AcceptEncoding) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			// 不能使用缓存
			connection.setUseCaches(false);
			connection.setRequestProperty("Referer", Referer);
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");
			((HttpURLConnection) connection).setRequestMethod("GET");
			if (AcceptEncoding) {
				connection.setRequestProperty("Accept-Encoding", "chunked");
			} else {
				System.out.println(url);
				connection.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
			}

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
			setCookies(map);
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

	/**
	 * 向指定 URL 发送POST方法的请求 本方法暂不支持GZIP解压
	 * 
	 * @param url
	 *            :StringText 发送请求的 URL
	 * @param param
	 *            :StringText 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @param Referer
	 *            :StringText 上一个页面的地址
	 * @param userAgent
	 *            :StringText 用户标识
	 * @param XMLHttpRequest
	 *            :boolean 发送请求是否需要X-Requested-With
	 * @author ZhangLianYu
	 * 
	 * @param AcceptEncoding
	 *            :boolean 为true代码像服务器索要chunked,否则向服务器发送gzip, deflate, sdch
	 * @return 所代表远程资源的响应结果 :StringText
	 */
	public static String sendPost(String url, String param, String Referer, String userAgent, boolean XMLHttpRequest,
			boolean AUSERNAME, String Origin, boolean AcceptEncoding) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			// Post 请求不能使用缓存
			conn.setUseCaches(false);
			((HttpURLConnection) conn).setInstanceFollowRedirects(false);// 302重定向
			conn.setRequestProperty("Cache-Control", "max-age=0");
			conn.setRequestProperty("Origin", Origin);
			if (XMLHttpRequest) {
				conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			}
			if (AUSERNAME) {
				conn.setRequestProperty("X-AUSERNAME", "v_liming");
			}
			conn.setRequestProperty("accept", "*/*");// 接受类型，*/*代表任何类型
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", userAgent);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Referer", Referer);
			// 可接受内容编码，服务器会返回相对应的编码
			if (AcceptEncoding) {
				conn.setRequestProperty("Accept-Encoding", "chunked");
			} else {
				conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
			}
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");// 指定一种自然语言,浏览器支持的语言分别是中文和简体中文，优先支持简体中文。
			conn.setRequestProperty("Cookie", CookiesUpdata.Cookies);
			// 设置连接主机超时（单位：毫秒）
			// conn.setConnectTimeout(30);
			// 设置从主机读取数据超时（单位：毫秒）
			// conn.setReadTimeout(300);
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 建立实际的连接
			conn.connect();
			// StringText encoding = conn.getContentEncoding();//
			// 获取Accept-Encoding编码格式
			Map<String, List<String>> map = conn.getHeaderFields();			
			// System.out.println(conn.getOutputStream());
			// 遍历所有的响应头字段
			// for (StringText key : map.keySet()) {
			// if(map.get("Set-Cookie")==null){break;}
			// System.out.println(conn.getHeaderField("Set-Cookie"));
			setCookies(map);
			// }
			int getResponseCode = 0;
			// 获取响应是否成功
			getResponseCode = ((HttpURLConnection) conn).getResponseCode();
			if (getResponseCode != 200) {// 检查服务器响应
				System.out.println("服务器响应不是200" + "；响应：" + getResponseCode);
			}
			if (getResponseCode == 302) {
				// 如果会重定向，保存302重定向地址，以及Cookies,然后重新发送请求(模拟请求)
				String location = conn.getHeaderField("Location");
				// StringText cookies = conn.getHeaderField("Set-Cookie");
				if ("/".equals(location)) {
					location = "http://jira.ffan.biz" + location;
				}
				realUrl = new URL(location);
				conn = (HttpURLConnection) realUrl.openConnection();
				conn.setRequestProperty("Cookie", CookiesUpdata.Cookies);
				conn.addRequestProperty("Accept-Charset", "UTF-8;");
				conn.setRequestProperty("accept", "*/*");
				conn.addRequestProperty("User-Agent", userAgent);
				conn.addRequestProperty("Referer", Referer);
				conn.setRequestProperty("Accept-Encoding", "chunked");
				conn.connect();
				System.out.println("跳转地址:" + location);
				map = conn.getHeaderFields();
				setCookies(map);
			}
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	public static void setCookies(Map<String, List<String>> map) throws Exception {
		String sendGet;
		if (map.get("Set-Cookie") != null) {
			sendGet = (map.get("Set-Cookie")).toString();
			sendGet = sendGet.replace(",", ";");
			sendGet = sendGet.substring(sendGet.indexOf("[") + 1, sendGet.indexOf("]"));
			CookiesUpdata.Check(sendGet); // 调用Cheack方法检查Cookie使用有更新
		}
	}
}