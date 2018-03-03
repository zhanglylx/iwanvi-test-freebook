package monitor;
//获取包名在进程中的pid
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetPidPs {
		public static int[] getPidPs(){
	 //public  static void main(StringText [] args){
		// TODO 自动生成的方法存根
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell   ps | find "+Package.Package(0));		
	
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
			ary[0]="u0_a333   -1  314   1331556 44144 ffffffff 00000000 S "+Package.Package(1);
		
		}	
		for(int m=0;m<ary.length;m++){
		ary[m] = ary[m].trim();
		}
		ary1 =containsSogou.SogouAry(ary);				
		int[] pid = new int[1];//初始pid数组
		int number=0;//用来赋值给pid的数组下标
		for(int m=0;m<ary1.length;m++){
			String arr =ary1[m];  //将ary值赋值给arr,用来分割字符串
			String[] ary2 =new String[2];
			ary2 = arr.split(" ");  //第一遍过滤	
			int index=0;//用来赋值给sogouAry的数组下标
			String[] sogouAry =new String[1];
			for(int i=0;i<ary2.length;i++){//去除空行				
				if(ary2[i].contains("1") ||
						ary2[i].contains("2")||
						ary2[i].contains("3")||
						ary2[i].contains("4")||
						ary2[i].contains("5")||
						ary2[i].contains("6")||
						ary2[i].contains("7")||
						ary2[i].contains("8")||
						ary2[i].contains("9")||
						ary2[i].contains("_")||
						ary2[i].contains("0")
						){
					if(index==0){
						sogouAry[0]=ary2[i];
					
					}else if(index>0){
						sogouAry=Arrays.copyOf(sogouAry, sogouAry.length+1);
						sogouAry[sogouAry.length-1]=ary2[i];
					
					}
					index++;
				}
			}			
			String trim =sogouAry[1].trim();		
			if(number==0){//将获取到pid赋值给pid数组
				pid[m]=Integer.parseInt(trim);;
			
			}else if(number>0){
				pid=Arrays.copyOf(pid, pid.length+1);
				pid[pid.length-1]=Integer.parseInt(trim);			
			}
			number++;			
		}
		
		//System.out.println(pid[0]);
		//for(int s:pid){System.out.println("-"+s);}
		return pid;
			}
	}



