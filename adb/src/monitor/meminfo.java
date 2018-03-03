package monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import monitor.containsSogou;
public class meminfo {
	
	 public  static int meminfo(){
		// TODO 自动生成的方法存根
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell dumpsys meminfo | find "+Package.Package(0));				
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
		
			while ((line = br.readLine()) != null) {
				
				if(j==0){
					ary[0]=line;
				}else if(j>0){
				ary=Arrays.copyOf(ary,ary.length+1);
				ary[ary.length-1]=line;	
				}
				j++;
				}				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Arrays.sort(ary);
		
		String[] ary1;
		if(ary[0]==null){
			ary[0]="0 kB: "+Package.Package(1)+" (pid 27265)";
			System.out.println("没有开启搜狗阅读客户端,内存给默认值:0");
		}	
		for(int m=0;m<ary.length;m++){
		ary[m] = ary[m].trim();
		}
		ary1 = containsSogou.SogouAry(ary);
		//for(int m=0;m<ary1.length;m++){
		//	System.out.println(ary1[m]);
		//	}
		int info=0;
		for(int m=0;m<ary1.length;m++){
			String arr =ary1[m];  //将ary值赋值给arr,用来分割字符串
			String[] ary2 =new String[2];
			ary2 = arr.split("kB");  //第一遍过滤
			String trim =ary2[0].trim();   //去除首位空格
			if(trim.contains("(")){
				ary2 =trim.split("\\(");
			}
			trim =ary2[0].trim();
			int a = Integer.parseInt(trim);
			info =info+a;
		}
		return info;
			}
	}



