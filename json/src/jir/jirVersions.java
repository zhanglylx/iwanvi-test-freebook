package jir;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.SimpleDateFormat;


import jdk.nashorn.api.scripting.JSObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class jirVersions {

	public static void main(String s) {
		String version = "";
		
		JSONObject json = JSONObject.fromObject(s);
		JSONArray jsonArray = JSONArray.fromObject(json.get("fields"));
		for(int i=0;i<jsonArray.size();i++){
			json = JSONObject.fromObject(jsonArray.get(i));
			if("影响版本".equals(json.get("label"))){
				
				System.out.println(json.get("editHtml").toString().replaceAll("\n", ""));
				version = json.get("editHtml").toString().replaceAll("\n", "")
						.replaceAll(" ", "").replaceAll("<div[^<]+>", "");
				version = version.replaceAll("<labelfor=\"version[^<]+>", "");
				version = version.replaceAll("/", "").replaceAll("影响版本", "");
				version = version.replaceAll("label", "").replaceAll("div", "").replaceAll("<selectc[^<]+>", "");
				version = version.replaceAll("<option>", "");
				version = version.replaceAll("optgroup=", "\"optgroup\":").replaceAll("optionvalue=", "\"optionvalue\":");
				version = version.replaceAll("<optionvalue=\"-1\">未知", "");
				version = version.replaceAll("<optio[.]*<\"optionv", "===");
				System.out.println(version);
			}
		}
		
		
		
		
		
	}

}
