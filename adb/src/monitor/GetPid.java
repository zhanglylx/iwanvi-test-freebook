package monitor;
//获取包名在进程中的pid
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetPid {
		public static int[] getPid(){
	 //public  static void main(StringText [] args){
		// TODO 自动生成的方法存根
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell   top -n 1 | find "+Package.Package(0));		
	
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
			ary[0]="-1  0   0% R    92 1781152K  19300K  bg u0_a1316 "+Package.Package(1);
		}	
		for(int m=0;m<ary.length;m++){
		ary[m] = ary[m].trim();
		}
		ary1 =containsSogou.SogouAry(ary);				
		int[] pid = new int[1];
		int index=0;
		for(int m=0;m<ary1.length;m++){
			String arr =ary1[m];//将ary值赋值给arr,用来分割字符串
			ary = arr.split(" ");  //第一遍过滤		
			int num = Integer.parseInt(ary[0]);
			if(index==0){
				pid[m]=num;
				}else if(index>0){
					pid =Arrays.copyOf(pid, pid.length+1);
					pid[pid.length-1]=num;
				}
			index++;
		}
		//System.out.println(pid[0]);
		//for(int s:pid){System.out.println("-----------"+s);}
		return pid;
			}
	}



