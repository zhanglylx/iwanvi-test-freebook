package 免费追书;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class 刷新后台 {
	public static void main(String[] args) {
		while (true) {
			System.out.println(Post(
					"http://192.168.1.249:8080/view/%E5%88%9B%E6%96%B0%E7%89%88/job/android-freebook-3.9.3-zhuishu/buildHistory/ajax",
					"http://192.168.1.249:8080/view/%E5%88%9B%E6%96%B0%E7%89%88/job/android-freebook-3.9.3-zhuishu/",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0"));

			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 向指定 URL 发送POST方法的请求 本方法暂不支持GZIP解压，所以没有设置Accept-Encoding
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @param Referer
	 *            上一个页面的地址
	 * @param userAgent
	 *            用户标识
	 * @param type
	 *            发送请求是否需要X-Requested-With
	 * @author ZhangLianYu
	 * 
	 * @return 所代表远程资源的响应结果
	 */
	public static String Post(String url, String Referer, String userAgent) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			((HttpURLConnection) conn).setInstanceFollowRedirects(false);// 302重定向
			// conn.setRequestProperty("Cache-Control", "max-age=0");
			conn.setRequestProperty("Origin", "http://192.168.1.249:8080");
			conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			conn.setRequestProperty("X-Prototype-Version", "1.7");
			conn.setRequestProperty("accept", "*/*");// 接受类型，*/*代表任何类型
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", userAgent);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			conn.setRequestProperty("Referer", Referer);
			// 可接受内容编码，服务器会返回相对应的编码
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
			conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");// 指定一种自然语言,浏览器支持的语言分别是中文和简体中文，优先支持简体中文。
			conn.setRequestProperty("Cookie",
					"screenResolution=1366x768; JSESSIONID.036c70e7=node0lyb3y9vv201m1ovd297st2ib865.node0");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print("");
			// flush输出流的缓冲
			out.flush();
			// 建立实际的连接
			conn.connect();
			// StringText encoding = conn.getContentEncoding();//
			// 获取Accept-Encoding编码格式
			Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
			// for (StringText key : map.keySet()) {
			// if(map.get("Set-Cookie")==null){break;}
			// System.out.println(conn.getHeaderField("Set-Cookie"));
			// setCookies(map);
			// }
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
}
