package novel_delete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AdbCatNovel {

	//public static byte uninstall() {
	public static int adbcatNovel() {
		 BufferedReader br = null;
		int j=0;
		String[] ary=GifBrewery.String_ary.ary();
		try {
			Process p = Runtime.getRuntime().exec("adb shell cat /storage/sdcard0/.novel");				
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
		//MB.devicesFound.devicesfound(ary);//检测设备是否中断
			for(int i=0;i<ary.length;i++){
			
				//System.out.println(ary[i]);
				if(ary[i].contains("No such file or directory")   ){
					
					
					return 0;
					
				}
				if(ary[i].contains("Permission denied")){
					return 3;
				}
				if(ary[i].contains("Is a directory")){
				return 1;
				}
			}
			
			
			return 2;						
}
}

