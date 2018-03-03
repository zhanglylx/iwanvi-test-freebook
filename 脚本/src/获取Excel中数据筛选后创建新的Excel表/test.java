package 获取Excel中数据筛选后创建新的Excel表;
/**
 * 用于筛选Excel中的数据并创建新的数据
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) throws Exception {
		//创建GetExcel实例并初始构造器
		GetExcel excel = new GetExcel("F:\\test.xlsx",0); 
		//创建一个list，用于接受GetExcel中的Excel数据
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		ArrayList<ArrayList<String>> exceldate = excel.getExceldata();
		String[] title = excel.getHeadline();
		int index = 0;
		int err4 = 0;
		int passes = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		String regStr= "^(问题)[1-6]：.+";
		Pattern pattern = Pattern.compile(regStr);
		//匹配字符串，返回描述匹配结果的Matcher实例

		for(int j=0;j<title.length;j++){
			if(title[j].contains("test")){
				index=j;
			}
			Matcher matcher = pattern.matcher(title[j]);
			if(matcher.find() && title[j].contains("问题4")==false){
				arr.add(j);
			}
			if(title[j].contains("问题4")){
				err4=j;
			}
			if(title[j].contains("是否通过")){
				passes=j;
			}
		}		
		for(int i=0;i<exceldate.size();i++){
			ArrayList<String> ls = exceldate.get(i);
			boolean err = false;
			for(int n=0;n<arr.size();n++){
				if("1".equals(ls.get(arr.get(n)))){
					err = true;
					break;
				}
				
			}
			if(err==false && ls.get(passes).contains("不通过") && ls.get(err4).contains("1")
					&& ls.get(index).contains("未部署区域为非部署区域")){
				ls.set(passes, "通过");
				System.out.println(ls);
			}
			list.add(ls);
			
//			if(Integer.toString(1).equals(ls.get(4))){
//				list.add(ls);
//			}
		}
		System.out.println(createExcel.create("F:\\E.xls", excel.getHeadline(), list,true));
	}

}
