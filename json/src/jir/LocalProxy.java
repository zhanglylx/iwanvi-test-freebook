package jir;

public class LocalProxy {
	public static void LocalProxy(){
	  System.setProperty("http.proxySet", "true"); //将请求通过本地发送
	  System.setProperty("http.proxyHost", "127.0.0.1");  //将请求通过本地发送
	  System.setProperty("http.proxyPort", "8888"); //将请求通过本地发送
	}
}
