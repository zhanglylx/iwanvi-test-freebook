package monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class totalRAM {
	public static int totalRAM(){
	 //public  static void main(StringText [] args){
		// TODO 自动生成的方法存根
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell cat /proc/meminfo");				
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
		String ary1 ="MemTotal:         0 kB" ;
		if(ary[0]==null){
			ary[0]="MemTotal:         0 kB";
			System.out.println("没有获取到手机总内存，给0值");
		}
		int index=0;//记录数组插入的index	
		for(int m=0;m<ary.length;m++){
		ary[m] = ary[m].trim();
		}
	 //   for(int i=0;i<ary.length;i++){
	//    	System.out.println(ary[i]);
	//    }
	  //  StringText arr = Arrays.toString(ary);
	//    ary =arr.split("Total RAM");
		/*
		No1:for(int i=0;i<ary.length;i++){
			 
			//System.out.println(ary[i]);
			for(int q=0;q<ary.length;q++){
			
				if( ary[i].contains("MemTotal:") ){
					int num=0;
					for(int k=0;k<ary1.length;k++){  //检查ary1中是否已经存入符合条件的数据
						if(ary[i].equals(ary1[k])){  //如果已经存入了数据，num=1，不在存入数据
							num=1;
						}
					}
					
					if(num==0){
						if(index==0){
							ary1[index]=ary[i];
						}else if(index>0){
							ary1=Arrays.copyOf(ary1, ary1.length+1);
							ary1[ary1.length-1]=ary[i];
						}
						index++;				
					}
				}
			}
		}
		*/
		for(int m=0;m<ary.length;m++){
			if(ary[m].contains("MemTotal:")){
				ary1=ary[m];
			}
			
			}
		
		
			ary= ary1.split("MemTotal:");  //第一遍过滤
			ary[1] =ary[1].trim();   //去除首位空格
			//System.out.println(ary[1]);
			ary1=ary[1];
			ary= ary1.split(" "); 
			int a = Integer.parseInt(ary[0]);
			return a;
			
			}
	}



