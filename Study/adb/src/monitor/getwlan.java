package monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class getwlan {

	public static Long getwlan(int[] args) {
		// TODO 自动生成的方法存根
		int [] uid =args;//获取程序UID的值	
	    int 	number=0;
	    String[] wlan=new String[1];
	    long sumWlan=0;
		for(int n=0;n<uid.length;n++){
		BufferedReader br = null;
		if(uid[0]==-1){
			System.out.println("没有获取到"+Package.Package(1)+":流量默认为:0");
			return sumWlan=(long) 0;
		}
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell cat /proc/net/xt_qtaguid/stats | find " +"\""+uid[n]+"\"");				
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
		String[] ary1=new String[1];
		if(ary[0]==null){
			System.out.println("没有获取到"+Package.Package(1)+":流量默认为:0");
			return sumWlan=(long) 0;
		}
		int index=0;
		for(int i=0;i<ary.length;i++){//去除空行
			if(ary[i].contains("1") ||
					ary[i].contains("2")||
					ary[i].contains("3")||
					ary[i].contains("4")||
					ary[i].contains("5")||
					ary[i].contains("6")||
					ary[i].contains("7")||
					ary[i].contains("8")||
					ary[i].contains("9")
					){
				if(index==0){
					ary1[0]=ary[i];
				}else if(index>0){
					ary1=Arrays.copyOf(ary1, ary1.length+1);
					ary1[ary1.length-1]=ary[i];
				}
				index++;
			}
		}
		String str;
		//MB.devicesFound.devicesfound(ary);		
		for(int i=0;i<ary1.length;i++){//去除无效的,只保留wlan的有效数据
			str=ary1[i];
			if(str.contains("wlan0")){				
				if(number==0){
					wlan[0]=ary1[i];			
				}else if(number>0){
					wlan=Arrays.copyOf(wlan, wlan.length+1);
					wlan[wlan.length-1]=ary1[i];	
				}
				number++;
			}			
		}
		}
		String [] arywlan;
		long initialWlan= 0;
		for(int i=0;i<wlan.length;i++){//计算出下载流量
			String str =wlan[i];
		    System.out.println(str);
			arywlan = str.split(" ");
			initialWlan =Long.parseLong(arywlan[5]);
			sumWlan =sumWlan+initialWlan;
		}	
			return sumWlan;
	}
	}


