package 品牌地图联动查询;

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

public class post {
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
	public static String sendPost(String url, String param) {
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
			conn.setRequestProperty("accept", "*/*");// 接受类型，*/*代表任何类型
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type", "application/json");
			// 可接受内容编码，服务器会返回相对应的编码
			conn.setRequestProperty("Accept-Encoding", "chunked");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");// 指定一种自然语言,浏览器支持的语言分别是中文和简体中文，优先支持简体中文。
			conn.setRequestProperty("Cookie", CookiesUpdata.Cookies);
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
			// 获取Accept-Encoding编码格式
			Map<String, List<String>> map = conn.getHeaderFields();			
			setCookies(map);
			int getResponseCode = 0;
			// 获取响应是否成功
			getResponseCode = ((HttpURLConnection) conn).getResponseCode();
			if (getResponseCode != 200) {// 检查服务器响应
				System.out.println("服务器响应不是200" + "；响应：" + getResponseCode);
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