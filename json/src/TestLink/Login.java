package TestLink;

import jir.JirPath;
import jir.HttpRequest;
import jir.LocalProxy;

public class Login {
	public static void main (String [] args){
		LocalProxy.LocalProxy();//设置请求时通过本地代理方式连接
	//while(true){
		boolean AuserName = false;
	boolean XRequestedWith = false;
	boolean AcceptEncoding = true;
	//登录
	String Referer = "http://testlink.intra.ffan.com/testlink/login.php";
    //获取CSRF
	String CSRF=GetCSRF.getCSRF(HttpRequest.sendGet("http://testlink.intra.ffan.com/testlink/login.php", "",Referer,AcceptEncoding));
	Referer = "http://testlink.intra.ffan.com/testlink/login.php";	
	//发送post开始登录
	AcceptEncoding=false;
	HttpRequest.sendPost("http://testlink.intra.ffan.com/testlink/login.php",form(CSRF),
  		  Referer,JirPath.userAgent,XRequestedWith,AuserName,TestLinkPath.Origin,AcceptEncoding);  
	//登录到主页
	Referer = "http://testlink.intra.ffan.com/testlink/login.php";	
	HttpRequest.sendGet("http://testlink.intra.ffan.com/testlink/index.php", "caller=login",Referer,AcceptEncoding);
	//主页内容
	Referer = "http://testlink.intra.ffan.com/testlink/index.php?caller=login";	
	HttpRequest.sendGet("http://testlink.intra.ffan.com/testlink/lib/general/navBar.php", "tproject_id=0&tplan_id=0&updateMainPage=1",Referer,AcceptEncoding);	
	HttpRequest.sendGet("http://testlink.intra.ffan.com/testlink/lib/general/mainPage.php", "",Referer,AcceptEncoding);	
	http://testlink.intra.ffan.com/testlink/lib/general/navBar.php?CSRFName=CSRFGuard_554984095&CSRFToken=15ba149fbcbdccad863e9de1645ab5ceccd79e39acbfe0abd055ca5d9b514e6e6c4f1b0d6fb310faa5c4dcbd74f1269b280192cfec54711a3459c327eefcb90b
	//跳转到智能硬件
	Referer = "http://testlink.intra.ffan.com/testlink/lib/general/navBar.php?tproject_id=0&tplan_id=0&updateMainPage=1";
	HttpRequest.sendGet("http://testlink.intra.ffan.com/testlink/lib/general/navBar.php", CSRF+"&testproject=69223",Referer,AcceptEncoding);
	Referer = "http://testlink.intra.ffan.com/testlink/lib/general/navBar.php?"+CSRF+"&testproject=69223";
	HttpRequest.sendGet("http://testlink.intra.ffan.com/testlink/lib/general/mainPage.php", "",Referer,AcceptEncoding);
	//浏览测试用例
	Referer = "http://testlink.intra.ffan.com/testlink/lib/general/mainPage.php";
	HttpRequest.sendGet("http://testlink.intra.ffan.com/testlink/lib/general/frmWorkArea.php", "feature=editTc",Referer,AcceptEncoding);
	Referer = "http://testlink.intra.ffan.com/testlink/lib/general/frmWorkArea.php?feature=editTc";
	HttpRequest.sendGet("http://testlink.intra.ffan.com/testlink/lib/testcases/listTestCases.php", "feature=edit_tc",Referer,AcceptEncoding);
	Referer = "http://testlink.intra.ffan.com/testlink/lib/general/frmWorkArea.php?feature=editTc";
	HttpRequest.sendGet("	http://testlink.intra.ffan.com/testlink/lib/testcases/archiveData.php", "edit=testproject&id=69223",Referer,AcceptEncoding);
	Referer = "http://testlink.intra.ffan.com/testlink/lib/testcases/listTestCases.php?feature=edit_tc";
	XRequestedWith = true;
	System.out.println(HttpRequest.sendPost("http://testlink.intra.ffan.com/testlink/lib/ajax/gettprojectnodes.php?root_node=69223&tcprefix=ZNYJ-", "node=69223", 
			Referer, JirPath.userAgent, XRequestedWith, AuserName, TestLinkPath.Origin,AcceptEncoding));
	}
	//}
	public static String form(String CSRF){
	return	CSRF+"&"+"tl_login="+TestLinkPath.tl_user+"&"+"tl_password="+TestLinkPath.tl_password+"&reqURI=&destination=&login_submit=%E7%99%BB%E5%BD%95";
	}
}
