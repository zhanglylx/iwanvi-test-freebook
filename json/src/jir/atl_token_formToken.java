package jir;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class atl_token_formToken {
	String atl_token_formToken;
	public static String atl_token_formToken(String Responder){
		JSONObject jsonObj = JSONObject.fromObject(Responder);
		String formToken =jsonObj.getString("formToken");
		String atl_token =jsonObj.getString("atl_token");	
		return "formToken="+formToken+"&"+"atl_token="+atl_token;
	}
}
