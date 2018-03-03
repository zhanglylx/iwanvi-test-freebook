package monitor;
//没用
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class monitor {
	
	 
	public static int monitor() {
		// TODO 自动生成的方法存根
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell dumpsys meminfo "+Package.Package(0));				
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
		String arr =Arrays.toString(ary);  //将ary转换为字符串，用来分割字符串
		MB.devicesFound.devicesfound(ary);
		ary = arr.split("Total");  //第一遍过滤出Stack字符，在赋值给ary
		ary = ary[1].split("TOTAL");//第二遍过滤出TOTAL字符，在赋值给ary
		arr =ary[1];//将第二遍过滤的信息再次复制给arr，准备第三遍过滤
		arr = arr.trim();   //去除首位空格
		ary = arr.split(" ");//再次进行第三遍过滤
		int a = Integer.parseInt(ary[0]);
		return a;
		
		}
	}
	



