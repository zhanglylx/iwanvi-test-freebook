package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import net.sf.json.JSONObject;

public class test {
	public static void main(String[] args) {

			String url = "http://ot.yuedu.sogou.com/abs/android/config?cli=0&token=80d459bffda94cdf1b15963858ca23c8&sdkandroid=5.1.1&eid=9999&ppid=ED24262194467D6B2E266753BBA8086C%40visitor.com&versioncode=3800&gender=0&uid=869709029030307&choosecates=0&cuuid=869709029030307";          
			String json = loadJSON(url);// 访问url并获取json
			String arrjson[];
			String arr[];
			String reward;	
				arrjson = json.split("start_ad");
				arrjson = arrjson[1].split("}");
				reward = arrjson[0].trim();
				reward = reward + "}";
				System.out.println(reward);

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