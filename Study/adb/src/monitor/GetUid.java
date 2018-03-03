package monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetUid {
	  public static int[] getUid(){
	//public static void main(StringText[] args) {
		// TODO 自动生成的方法存根
		  
		int [] pid =GetPidPs.getPidPs();
		int [] getuid=new int[1];
		int [] uid=new int[1];
		int index=0;
		for(int i=0;i<pid.length;i++){
			if(pid[i]==-1){
				uid[0]=-1;
				return uid;
				
				}
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell cat /proc/" + pid[i] + "/status | find \"Uid\"");	
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
		String arr = null ;
		for(int n=0;n<ary.length;n++){
			if(ary[n].contains("id")){
				arr=ary[n];
			}
		}
		ary =arr.split("Uid:");
		arr = ary[1];
		arr=arr.trim();
		ary=arr.split("	");
		int a=Integer.parseInt(ary[0]);
		if(index==0){//将获取到的uid的值插入到getuid数组中
			getuid[0]=a;
			}else if(index>0){
			getuid=Arrays.copyOf(getuid,getuid.length+1);
			getuid[getuid.length-1]=a;
		}
		index++;
	}
		int number=0;
		for(int n=0;n<getuid.length;n++){ //去重，过滤
			int  num=0;//记录是否有相等的数据
			for(int c=0;c<uid.length;c++){//比对uid数组中是否插入了getuid中的数据
					if(uid[c]==getuid[n]){																
						num=1;//如果有相等的数据num=1	
						}
					}
			if(num==0){//如果没有相等的数据，将getuid[n]的值插入uid中
					if(number==0){					
						uid[0]=getuid[n];							
					}else if(number>0){
						uid=Arrays.copyOf(uid, uid.length+1);
						uid[uid.length-1]=getuid[n];							
					}
				number++;
			}							
			}
		return uid;
		}
	}

