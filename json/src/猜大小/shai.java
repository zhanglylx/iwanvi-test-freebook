package 猜大小;
import org.omg.Messaging.SyncScopeHelper;

import net.sf.json.JSONObject;
import 轻客户端.api;
public class shai {

	@SuppressWarnings({ "static-access", "null" })
	public static void main(String[] args) {
		String url ;
		String Response;
		shuju user = new shuju();
		int a = 0;
		int num0 =0;
		int num1 = 0 ;
		int conunt = 0;
		byte guess=0;
		int  gl = 6;
		float g=0;
		int userid=0;
		
		

		while(true){
			if((user.user(0)[1]).equals(Integer.toString(userid))){				
				break;
			}
			/*
			url= "https://read.sogou.com/yd/activity/"
					+ "caidaxiao/lottery?channel=w"
					+ "ap&eid=&userid="+(user.user(userid))[0]
					+ "&callback=lotteryCb&guess="+guess;			
			if(guess ==1){
				guess =0;
			}else{
				guess =1;
			}

	    Response = api.loadJSON(url);
		if(Response.contains("no chance")){
			api.loadJSON("https://read.sogou.com/yd/activity/cai"
				+"daxiao/clearCacheByType?userid="+(user.user(userid))[0]
				+"&type=jihui&rewardId=");
			Response = api.loadJSON(url);
		}
		Response = Response.replace("lotteryCb({\"chance\":\"chance\",\"lottery\":","");
		Response = Response.substring(0, Response.length()-1);
		//JSONObject arr = JSONObject.fromObject(Response);
		// gl = arr.getInt("gl");
		 conunt++;
		/*
		if(gl == 0 ){
			num0++;
			
		}else if (gl == 2){
			num1++;
			
		}else{
			System.out.print("json有问题"+Response+"  ");
			System.exit(0);
		}
		*/
		/**
		System.out.print("num0:  "+ num0 +"  ");
		System.out.print("num0的概率为:"+(StringText .format("%.2f",(float) (num0*1.0/conunt*1.0)))+"%"+"  ");
		System.out.print("num1:  "+ num1+"  ");
		System.out.print("num1的概率为:"+(StringText .format("%.2f",(float) (num1*1.0/conunt*1.0))+"%"+"  "));
		System.out.println("循环总次数: "+conunt);
		*/	
		
		if((user.user(userid))[0].contains("@visitor.com")){
			userid++;
		}else{
				System.out.println("\""+(user.user(userid))[0]+"\",");
			userid++;
			num1=0;			
			conunt=0;
			continue;			
		}
				
		}
	}

}
