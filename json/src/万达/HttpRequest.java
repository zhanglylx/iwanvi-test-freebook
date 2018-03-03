package 万达;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpRequest {
	  public static void main(String[] args) {
	        //发送 GET 请求
	     //   StringText s=HttpRequest.sendGet("https://api.ffan.com/ihos/beacon/v1/beaconsByUMM", "key=123&v=456");
	       // System.out.println(s);
	      //  System.out.println("----------");
	        //发送 POST 请求
		  System.setProperty("http.proxySet", "true"); 
		  System.setProperty("http.proxyHost", "127.0.0.1"); 
		  System.setProperty("http.proxyPort", "8888");
	        String sr=HttpRequest.sendPost("http://jira.ffan.biz/secure/QuickCreateIssue.jspa?decorator=none", "&issuetype=10214&atl_token=B8UR-6F8R-T56C-8GMD%7C0f0d2137c82938fa507383c75ce3ecf7ef014521%7Clin&formToken=47c99937466798c26f677796baec2ddd1bdc6ff3&versions=11287&fixVersions=11287&customfield_10344=10199&customfield_10321=chrome_windows&customfield_10379=10321&customfield_10677=-1&components=12407&customfield_10676=-1&customfield_10323=10168&summary=%E3%80%90%E5%9C%B0%E5%9B%BE%E7%BC%96%E8%BE%91%E5%99%A81.0%E3%80%91%E6%96%B0%E5%A2%9E%E6%97%B6%E7%BB%98%E7%94%BB%E4%B8%80%E4%B8%AA%E7%82%B9%E5%90%8E%E7%82%B9%E5%87%BB%E4%BF%9D%E5%AD%98%EF%BC%8C%E5%BC%B9%E5%87%BA%E5%88%B0%E7%99%BB%E5%BD%95&customfield_10325=10186&customfield_10661=&description=%5B%E6%93%8D%E4%BD%9C%E6%AD%A5%E9%AA%A4%5D+1.%E6%96%B0%E5%A2%9E%E7%BB%98%E7%94%BB%E4%B8%80%E4%B8%AA%E7%82%B9%0D%0A+++++++++++++++++2.%E7%82%B9%E5%87%BB%E4%BF%9D%E5%AD%98%E6%8C%89%E9%92%AE%0D%0A%5B%E9%A2%84%E6%9C%9F%E7%BB%93%E6%9E%9C%5D+1.%E6%8F%90%E7%A4%BA%E4%B8%8D%E5%AD%98%E5%9C%A8%E6%9C%AA%E4%BF%9D%E5%AD%98%E6%95%B0%E6%8D%AE%0D%0A%5B%E5%AE%9E%E9%99%85%E7%BB%93%E6%9E%9C%5D+1.%E8%B7%B3%E8%BD%AC%E5%88%B0%E7%99%BB%E5%BD%95%0D%0A&assignee=-1&dnd-dropzone=&customfield_10202=&issuelinks=issuelinks&issuelinks-linktype=blocks&customfield_10365=-1&labels=%E5%9C%B0%E5%9B%BE%E7%BC%96%E8%BE%91%E5%99%A8&customfield_10772=11041&customfield_10800=11165&fieldsToRetain=project&fieldsToRetain=issuetype&fieldsToRetain=versions&fieldsToRetain=fixVersions&fieldsToRetain=customfield_10344&fieldsToRetain=customfield_10321&fieldsToRetain=customfield_10379&fieldsToRetain=customfield_10677&fieldsToRetain=components&fieldsToRetain=customfield_10676&fieldsToRetain=customfield_10323&fieldsToRetain=customfield_10325&fieldsToRetain=customfield_10661&fieldsToRetain=assignee&fieldsToRetain=customfield_10202&fieldsToRetain=issuelinks&fieldsToRetain=customfield_10365&fieldsToRetain=labels&fieldsToRetain=customfield_10772&fieldsToRetain=customfield_10800");
	        System.out.println(sr);
	    }
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
//	 
//    public static StringText sendGet(StringText url, StringText param) {
//        StringText result = "";
//        BufferedReader in = null;
//        try {
//            StringText urlNameString = url + "?" + param;
//            URL realUrl = new URL(urlNameString);
//            // 打开和URL之间的连接
//            URLConnection connection = realUrl.openConnection();
//            // 设置通用的请求属性
//             
//             
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            // 建立实际的连接
//            connection.connect();
//            // 获取所有响应头字段
//            Map<StringText, List<StringText>> map = connection.getHeaderFields();
//            // 遍历所有的响应头字段
//            for (StringText key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//               
//            }
//            // 定义 BufferedReader输入流来读取URL的响应
//            in = new BufferedReader(new InputStreamReader(
//                    connection.getInputStream()));
//            StringText line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
//        } catch (Exception e) {
//            System.out.println("发送GET请求出现异常！" + e);
//            e.printStackTrace();
//        }
//        // 使用finally块来关闭输入流
//        finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//        return result.toString();
//    }
//    
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
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
            conn.setRequestProperty("Host", "jira.ffan.biz");
            conn.setRequestProperty("Content-Length", "1084");
            conn.setRequestProperty("Origin", "http://jira.ffan.biz");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setRequestProperty("accept", "*/*");//接受类型，*/*代表任何类型
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0"
                    + "X-AUSERNAME: v_liming");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("Referer","http://jira.ffan.biz/browse/ZNDT-506");
            conn.setRequestProperty("Accept-Encoding","gzip, deflate");//可接受内容编码
            conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");//指定一种自然语言,浏览器支持的语言分别是中文和简体中文，优先支持简体中文。
            conn.setRequestProperty("Cookie","JSESSIONID=94AAA800F6A0EC44C97041AA84F2BC2D; seraph.rememberme.cookie=36992%3A2dbf78ef6365498bdfdf2b761ed9d62b6cad8b2d; atlassian.xsrf.token=B8UR-6F8R-T56C-8GMD|550d9176d33ab9febd8d645e7b2ecf8fbed2880c||lin");      
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
            if(((HttpURLConnection) conn).getResponseCode() != 200){//检查服务器响应
         	   System.out.println("系统错误，不等于200");
            }  
            
        
            Map<String, List<String>> map = conn.getHeaderFields();
            // 遍历所有的响应头字段
           
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));  
                
                
            }
            
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();  
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
                
            }
       
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result.toString();
    }    
}