package 免费电子书;

import java.util.List;

import javax.swing.JOptionPane;

import net.sf.json.JSONObject;

public class requestUrl {
	public static String getAdRequest(int gG,int userIdData){
		return "cnid="+config.CNID+"&umeng=test_test&version="+config.VERSION+"&vercode=64&imei=865736034224322&imsi=&uid=19355701&packname=com.mianfeia.book&oscode=25&model=MIX+2&other=a&vcode=64&channelId=1062&mac=a3d76e202891719e398052c0a29e272e&platform=android&appname=cxb&brand=Xiaomi&"
				+ "advId=GG-" + gG + "&userId=" + userIdData + "&" + "currId=-1&net=WIFI";
	}
	public static String getAdRequestCurrId(int gG,int userIdData,int CurrId){
		return "cnid="+config.CNID+"&umeng=test_test&version="+config.VERSION+"&vercode=64&imei=865736034224322&imsi=&uid=19355701&packname=com.mianfeia.book&oscode=25&model=MIX+2&other=a&vcode=64&channelId=1062&mac=a3d76e202891719e398052c0a29e272e&platform=android&appname=cxb&brand=Xiaomi&"
				+ "advId=GG-" + gG + "&userId=" + userIdData + "&" + "currId="+CurrId+"&net=WIFI";
	}
	public static String exposureRequest(JSONObject jsonObj,int type,int id,int userIdData){
		if(jsonObj.get("advId")==null){
			errorPopupWindow("返回的advId为空");
		}
		if(jsonObj.get("adId")==null ){
			errorPopupWindow("返回的adId为空");
		}
		return  "appname=cxb&packname=com.mianfeia.book&version="+config.VERSION+"&cnid="+config.CNID+"&advId="
					+ jsonObj.get("advId") + "&type="+type+"&adId=" + jsonObj.get("adId") + "&id=" + id + "&userId="
					+ userIdData + "&platform=android";
	}
	public static void errorPopupWindow(String err) {
		Point list = Point.getPoint();
		JOptionPane.showMessageDialog(null, err, "发现运行错误，程序即将关闭",JOptionPane.ERROR_MESSAGE); 
		list.printlnList();
	}
}
