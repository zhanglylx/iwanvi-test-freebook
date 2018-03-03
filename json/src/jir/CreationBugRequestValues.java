package jir;

public class CreationBugRequestValues {
	String request;

	public CreationBugRequestValues() {
		// TODO 自动生成的方法存根
		JirExcel cel = new JirExcel();

		for (int i = 0; i < cel.Key.length; i++) {
			cel.Key[i] = transformKey(cel.Key[i]);
			cel.Values[i] = transformValues(cel.Key[i], cel.Values[i]);
			request = request + cel.Key[i] + "=" + cel.Values[i]// 转码
					+ "&";

		}
		request = request
				+ "pid=10810&issuetype=10214&customfield_10677=-1&customfield_10676=-1&customfield_10323=10168&customfield_10661=&assignee=-1&dnd-dropzone=&customfield_10202=&issuelinks=issuelinks&"
				+ "issuelinks-linktype=blocks&customfield_10365=-1&"
				+ "fieldsToRetain=project&fieldsToRetain=issuetype&fieldsToRetain=versions&"
				+ "fieldsToRetain=fixVersions&fieldsToRetain=customfield_10344&"
				+ "fieldsToRetain=customfield_10321&"
				+ "fieldsToRetain=customfield_10379&fieldsToRetain=customfield_10677&"
				+ "fieldsToRetain=components&fieldsToRetain=customfield_10676&"
				+ "fieldsToRetain=customfield_10323&fieldsToRetain=customfield_10325&"
				+ "fieldsToRetain=customfield_10661&fieldsToRetain=assignee&"
				+ "fieldsToRetain=customfield_10202&fieldsToRetain=issuelinks&"
				+ "fieldsToRetain=customfield_10365&fieldsToRetain=labels&"
				+ "fieldsToRetain=customfield_10772&fieldsToRetain=customfield_10800"
				;
		request = request.substring(4, request.length());
	}

	public String transformKey(String key) {// 给模块名称转换
		key = key.trim();
		if (("影响版本").equals(key)) {
			key = "versions";
		} else if (("修复版本").equals(key)) {
			key = "fixVersions";
		} else if (("测试环境").equals(key)) {
			key = "customfield_10344";
		} else if (("测试平台").equals(key)) {
			key = "customfield_10321";
		} else if (("严重程度").equals(key)) {
			key = "customfield_10379";
		} else if (("模块").equals(key)) {
			key = "components";
		} else if (("摘要").equals(key)) {
			key = "summary";
		} else if (("优先级别").equals(key)) {
			key = "customfield_10325";
		} else if (("描述").equals(key)) {
			key = "description";
		} else if (("标签").equals(key)) {
			key = "labels";
		} else if (("影响平台").equals(key)) {
			key = "customfield_10772";
		} else if (("复现概率").equals(key)) {
			key = "customfield_10800";
		} else {
			errorPrint(key, "(key)", "key");
		}
		return key;
	}

	public String transformValues(String key, String values) {// 给模块的值转换
		values = values.trim();
		if((key).equals("versions")==true) {
			return values;
		}else if ( "fixVersions".equals(key)==true){
			return values;
		}
		if ("customfield_10344".equals(key)) {
			switch (values) {
			case "集成测试":
				values = "10199";
				break;
			case "生产环境":
				values = "10200";
				break;
			case "预发布环境":
				values = "10201";
				break;
			case "联调环境":
				values = "10202";
				break;
			case "UAT环境 ":
				values = "12300";
				break;
			default:
				errorPrint(key, values, "values");
				break;
			}
		} else if ("customfield_10379".equals(key)) {
			switch (values) {
			case "Blocker":
				values = "10319";
				break;
			case "Critical":
				values = "10320";
				break;
			case "Major":
				values = "10321";
				break;
			case "Minor":
				values = "10322";
				break;
			default:
				errorPrint(key, values, "values");
				break;
			}
		} else if ("components".equals(key)) {// 模块
			switch (values) {
			case "定位":
				values = "12407";
				break;
			case "地图":
				values = "12406";
				break;
			case "大屏地图":
				values = "13131";
				break;	
			case "招商编辑平台":
				values = "13199";
				break;	
			default:
				errorPrint(key, values, "values");
				break;
			}
		} else if ("customfield_10325".equals(key)) {// 优先级别
			switch (values) {
			case "高":
				values = "10208";
				break;
			case "中":
				values = "10185";
				break;
			case "低":
				values = "10186";
				break;
			default:
				errorPrint(key, values, "values");
				break;
			}
		} else if ("customfield_10772".equals(key)) {// 影响平台
			switch (values) {
			case "后台服务":
				values = "11041";
				break;
			case "Web":
				values = "12037";
				break;
			case "IOS":
				values = "11024";
				break;
			case "H5":
				values = "11026";
				break;
			case "XAPI":
				values = "11025";
				break;
			case "Android":
				values = "11023";
				break;
			default:
				errorPrint(key, values, "values");
				break;
			}
		} else if ("customfield_10800".equals(key)) {// 复现概率
			switch (values) {
			case "必现":
				values = "11165";
				break;
			case "80":
				values = "11166";
				break;
			case "50":
				values = "11167";
				break;
			case "30":
				values = "11168";
				break;
			case "偶现":
				values = "11169";
				break;
			default:
				errorPrint(key, values, "values");
				break;
			}
		} else if ("customfield_10321".equals(key) || "summary".equals(key) || "description".equals(key)
				|| "labels".equals(key)) {// 测试平台
			values = Transcoding.getURLEncoderString(values);
		} else {			
				System.out.println();
				errorPrint(key, values, "key未命中00");			
		}
		return values;
	}

	public void errorPrint(String key, String values, String type) {
		System.out.println("字段解析失败: Key:" + key + " 值:" + values + ";未命中:" + type);
		System.exit(0);
	}
}