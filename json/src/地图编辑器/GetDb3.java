package 地图编辑器;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sun.glass.ui.Clipboard;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import jir.HttpRequest;
import jir.LocalProxy;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import jir.LocalProxy;

public class GetDb3 {
	/**
	 * 商场审核通过后会生成母库DB3文件并生成新的DB3版本号，检查是否生成新的db3版本
	 * 使用plazaIdList查询DB3文件地址,DB3地址直接复制到剪贴板，到浏览器中直接复制url即可
	 * 获取到的DB3检查商场名称和DB3版本号与上一次获取的是否相同并提示
	 */
	private static final String Referer = null;
	private static final boolean XRequestedWith = false;
	private static final boolean AUSERNAME = false;

	public static void main(String[] args) throws Exception {
		LocalProxy.LocalProxy();
		final String ExcelPath = "D:/getDB3.xls";
		String request = "1102649";
		request = "plazaIdList=" + request;
		String userAgent = "";
		// 获取测试环境db3文件
		String jsonstr = (HttpRequest.sendPost("http://indoor.intra.sit.ffan.com/masters/indoor/verDatas", request,
				Referer, userAgent, XRequestedWith, AUSERNAME, "", true));
		JSONObject jsonObj = JSONObject.fromObject(jsonstr);
		JSONArray jsonArray = jsonObj.getJSONArray("data");
		Map<String, String> map = new HashMap<String, String>();
		if (null != jsonArray && jsonArray.size() > 0) {
			for (int i = 0; i < jsonArray.size(); i++) {
				// Object obj = jsonArray.get(i);
				JSONObject json = JSONObject.fromObject(jsonArray.get(i));
				System.out.println(json.getString("plazaDataUrl"));
				// 将字符串添加到系统剪贴板
				StringSelection stringSelection = new StringSelection(json.getString("plazaDataUrl"));
				java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				System.out.println();
				System.out.println(json.getString("plazaName"));
				map.put("masterVer", json.getString("masterVer"));
				map.put("plazaName", json.getString("plazaName"));
			}
		}
		// 检查文件是否存在，不存在直接创建文件
		if (jir.ExcelWrite.fileExist(ExcelPath)) {
			String[] db3;
			db3 = Methods_summarize.getExcelXls.ExcelNative(ExcelPath, "获取所有", "masterVer");
			// 检查本地Excel中的广场名称与获取到的广场名称是否相同
			String NativePlazaName = Methods_summarize.getExcelXls.ExcelNative(ExcelPath, "获取所有", "plazaName")[1];
			System.out.println(NativePlazaName);
			if (NativePlazaName.equals(map.get("plazaName"))) {
				if (db3[1].equals(map.get("masterVer"))) {// 判断线上和本地的masterVer是否相同，如果相同代表db3没有更新
					System.out.println("注意:masterVer版本相同，本地:" + db3[1] + "；线上获取:" + map.get("masterVer"));
				} else {
					System.out.println("版本不相同，检查通过，本地:" + db3[1] + "；线上:" + map.get("masterVer"));
				}
			} else {
				System.out.println("商场名称不相符，本地:" + NativePlazaName + "   线上:" + map.get("plazaName"));
			}
		} else {
			System.out.println("本地没有存放    D:/getDB3.xls");
		}
		Excel.createExcel(ExcelPath, "response", map);

	}
}
