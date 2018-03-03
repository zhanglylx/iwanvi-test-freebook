package novel_delete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RmNoveldata {

	//public static byte uninstall() {
	public static int RmNovel() {
		BufferedReader br = null;
		int j=0;
		String[] ary=GifBrewery.String_ary.ary();//初始化数组
		try {
			Process p = Runtime.getRuntime().exec("adb shell rm -r /storage/sdcard0/.novel");				
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
		int AdbCat=AdbCatNovel.adbcatNovel();
		//MB.devicesFound.devicesfound(ary);//检测设备是否中断



		for(int i=0;i<ary.length;i++){

			System.out.println(ary[i]);

			if((ary[i]==null && AdbCat==0)||
					((ary[i].contains("No such file or directory")||
							ary[i].contains("rm failed for /storage/sdcard0/.novel"))&&AdbCat==0)){										
				return 0;					
			}


		}

		if((AdbCat==1)||ary[0].contains("error: no devices found") ){			
			return 1;	
		}
		if(AdbCat==3){
        
			return 3;
		}
		return 2;
	}
}

