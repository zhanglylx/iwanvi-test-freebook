package christmas;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

import net.sf.json.JSONObject;

public class teee {
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int rewardGridID = 0;
		int rewardID= 0;
		int id = 0;
		int gl= 0;
		int type= 0;
		int huidaoqidian=0;
		while(true){
		int n = 4;
		String ppid="o9t2luI1dz61r7-8xyppuD9KiGsE@weixin.sohu.com";
		loadJSON(
				"http://ot.yuedu.sogou.com/abs/activity/christmas/ajax/clearCache?key=user_reward" + ppid);
		String url = "http://ot.yuedu.sogou.com/abs/activity/christmas/ajax/lottery?" + "ppid=" + ppid
				+ "&token=bfc51a7f4a65d77a38170417517a9125&eid=1268&versioncode=3700&cli=0&gender=0&uuid=89948f15-e6ba-440b-a50f-0f6e1de0d44e&imsi=460031697518567"
				 +"&pos="+n
				;  
		System.out.println(loadJSON(url));
		loadJSON("http://ot.yuedu.sogou.com" + "/abs/activity/christmas/ajax/"
				+ "clearCache?key=chance2017-04-02" + ppid);											
		}
		
	}
	public static String loadJSON(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine = null;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return json.toString();
	}
}
