package TestLink;

public class GetCSRF {
	public static String getCSRF(String response) {
		String[] split;
		response = response.substring(response.indexOf("<input type='hidden'"), response.length());
		split = response.split("/>");
		String s = "";
		for (String c : split) {
			if (c.contains("input type='hidden'") && c.contains("CSRF")) {
				c = c.replace("'", "").replace(" ", "").replace("<inputtype=hidden", "").replace("=", "")
						.replace("name", "").replaceAll("id", "");
				if (c.indexOf("Name") >= 0) {
					c = c.substring(c.indexOf("value") + 5, c.length());
					c = "CSRFName=" + c;
				} else if (c.indexOf("Token") >= 0) {
					c = c.substring(c.indexOf("value") + 5, c.length());
					c = "CSRFToken=" + c;
				} else {
					System.out.println("获取CSRF失败"+c);
					System.exit(0);
				}
				s = s+c+"&";
			}
			
		}
		if(s.contains("CSRFToken") && s.contains("CSRFName")){
		return s.substring(0,s.length()-1);
		}else{
			System.out.println("返回获取的CSRF失败");
			System.exit(0);
			return null;
		}
	}
}
