package MB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class uninstall {

	public static byte uninstall() {
//	public static void main(StringText [] args) {
		 BufferedReader br = null;
		int j=0;
		String[] ary=MB.String_ary.ary();
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb uninstall com.sogou.novel");				
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
	//	if(ary.length<3){ //如果有设备，数组长度大于等于3
		MB.devicesFound.devicesfound(ary);//检测设备是否中断
		
			for(int i=0;i<ary.length;i++){
			
				//System.out.println(ary[i]+"---");
				if(ary[i].contains("Success")){
					
					return 0;
					
				}else
				if(ary[i].contains("Failure") || ary[i].contains("not installed for 0") ){
					
					
					return 1;
					
				}
				
			}
			
			
			return 2;						
}
}

