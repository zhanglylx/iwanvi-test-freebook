package monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dfsdfdsf {
	//public static int totalRAM(){
	 public  static void main(String [] args){
		// TODO 自动生成的方法存根
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell top -n 1");		
	
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
		String ary1 ="" ;
		int index=0;
		for(int m=0;m<ary.length;m++){
			if(ary[m].contains("com.sogou.novel")){
				ary1=ary[m];
				index=1;
				break;
			}
			
			}
		if(index==0){
			System.out.println("没有开启搜狗阅读客户端，没有抓取到UID");
		}
		ary= ary1.split("com.sogou"); 
		
		ary1=ary[0];
		ary=(ary1.trim()).split(" ");
		System.out.println(ary[0]);
		//for(int i=0;i<ary.length;i++){System.out.println(ary[i]);}
		ary1=ary[ary.length-1];
		System.out.println(ary1);
	
			}
	}



