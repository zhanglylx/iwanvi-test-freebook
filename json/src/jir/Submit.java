package jir;

import net.sf.json.JSONObject;

public class Submit {

	public static void main(String[] args) {
		LocalProxy.LocalProxy();//设置请求时通过本地代理方式连接
		CreationBugRequestValues quest = new CreationBugRequestValues();
		System.out.println(quest.request);
		 //获取登录中的set_Cookies
          String Referer="http://jira.ffan.biz/login.jsp";
		  boolean XRequestedWith = false;
		  boolean AuserName = false;
		  boolean AcceptEncoding =false;
         HttpRequest.sendPost("http://jira.ffan.biz/login.jsp", "os_username=v_liming&os_password=123456&os_cookie=true&os_destination=&user_role=&atl_token=&login=%E7%99%BB%E5%BD%95",
       		  Referer,JirPath.userAgent,XRequestedWith,AuserName,JirPath.Origin,AcceptEncoding);//登录,登录不需要X-Requested-With
          
          //发送创建请求
          XRequestedWith=true;
          Referer="http://jira.ffan.biz/secure/Dashboard.jspa";
          AcceptEncoding = true;
          String Token= HttpRequest.sendPost("http://jira.ffan.biz/secure/QuickCreateIssue!default.jspa?decorator=none","",
        		  Referer,JirPath.userAgent,XRequestedWith,AuserName,JirPath.Origin,AcceptEncoding);  
                  Referer= "http://jira.ffan.biz/issues/?filter=-2";
         AuserName = true;      
         quest.request = quest.request+"&"+ atl_token_formToken.atl_token_formToken(Token);         
         System.out.println( quest.request);
          //提交bug
       System.out.println(HttpRequest.sendPost("http://jira.ffan.biz/secure/QuickCreateIssue.jspa?decorator=none",quest.request,
           Referer,JirPath.userAgent,XRequestedWith,AuserName,JirPath.Origin,AcceptEncoding));  
        
	} 

}
