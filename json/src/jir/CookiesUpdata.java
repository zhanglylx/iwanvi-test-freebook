package jir;
import java.util.Arrays;

import 万达.Ary;
import 万达.Excel;
public class CookiesUpdata {
	public static String Cookies;

	public CookiesUpdata(){
		HttpRequest.sendGet("http://jira.ffan.biz/login.jsp", "","",true); //打开登录页	
	}
	/*
	 * 将需要保存的cookies存入到Excel中，访问Cookies时，通过获取Excel表获取
	 * 
	 */
	/**
	 * @param s //set中的cookies字符串
	 * @throws Exception
	 * @author zhanglianyu 2017/7/26
	 */
	public static  void Cookies(String s) throws Exception{	
		/**
		 * @param title  数组，用户记录服务器返回的Set_Cookies中的信息
		 * @param arr    数组，记录过来出来的set_cookies
		 */

		String title[] = new String[0];  
		String arr[];
		arr=s.split(";"); //将cookies进行分割用户提取	
		for(int i = 0 ;i < arr.length;i++){ //提取set_cookies
			arr[i]=arr[i].trim();
			//将字符转换为小写比对
			if(arr[i].toLowerCase().contains("path".toLowerCase()) || arr[i].toLowerCase().contains("HttpOnly".toLowerCase()) ||
					arr[i].toLowerCase().contains("Expires".toLowerCase()) || arr[i].toLowerCase().contains("GMT".toLowerCase())	){
				continue;
			}
			title=Ary.ArrayCapacity(title); //给数组扩容
			title[title.length-1]=arr[i];//给数组赋值过滤出的set_cookies
		}
		createExcel(title,s);//在电脑中创建Cookies
		Cookies = "";//给cookies默认值		
		if(ExcelWrite.fileExist(JirPath.ExcelWritePath)){ //检测文件是否存在
			String[] ExcelJSESSIONID =Excel.ExcelNative(JirPath.ExcelWritePath,"获取标题","");	
			Cookies="";
			for(int i=0;i<ExcelJSESSIONID.length;i++){
				Cookies = Cookies+ExcelJSESSIONID[i]+"; ";
			}
		}	    			 				 	
	}
	public static void createExcel(String[] Cookies,String s) throws Exception{
		if(Cookies.length<0){  //增加判断，如果title没有检测有setCookies还执行了语句，报告错误
			System.out.println("更新titleCookies异常:"+s);
			System.exit(0);;
		}else{
			if(ExcelWrite.fileExist(JirPath.ExcelWritePath)==false){ //检测文件是否存在
				ExcelWrite.createExcel(JirPath.ExcelWritePath,"Cookies",Cookies); //创建本地cookies
			}else{	

				String ExcelExcelNative[] =Excel.ExcelNative(JirPath.ExcelWritePath, "获取标题","");
				//获取本地的cookies
				//	if(Cookies.length > ExcelExcelNative.length){  //检查两个数组是否一样，不一样扩容相同数组
				//		ExcelExcelNative = Arrays.copyOf(ExcelExcelNative, Cookies.length);//只检查线上数据对比本地
				//	}
				boolean[] checkOnline = new boolean[Cookies.length];
				boolean[] checkNative = new boolean[ExcelExcelNative.length];
				//检查线上cookies和线下cookies有无相同，有相同更新本地cookies。没有相同像下循环执行
				for(int i=0;i<Cookies.length;i++){
					String [] Online;
					String [] Native;
					Online = Cookies[i].split("=");
					for(int j=0;j<ExcelExcelNative.length;j++){
						Native = ExcelExcelNative[j].split("=");
						if(Native[0].contains(Online[0])){
							ExcelExcelNative[j]=Cookies[i];
							checkOnline[i]=true;
							checkNative[j]=true;

						}
					}
				}

				//检查线上Cookies和线下Cookies没有匹配项后向本地cookies插入新的的值
				for(int i=0;i<Cookies.length;i++){
					if(checkOnline[i]){continue;}
					for(int j =0;j<ExcelExcelNative.length;j++){
						if(checkNative[j]){continue;}
						ExcelExcelNative = Arrays.copyOf(ExcelExcelNative, ExcelExcelNative.length+1);
						ExcelExcelNative[ExcelExcelNative.length-1]=Cookies[i];
						checkNative[j]=true;
						break;
					}
				}							
				ExcelWrite.createExcel(JirPath.ExcelWritePath,"Cookies",ExcelExcelNative); //创建本地cookies
			}
		}
	}

	public static void Check(String s) throws Exception{
		if(s==null){
		}else{
			//System.out.println(s);
			Cookies(s);
		}
	}

}

