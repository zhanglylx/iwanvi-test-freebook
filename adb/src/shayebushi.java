
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class shayebushi {

	//public static byte uninstall() {
	public static void main(String args[]) {
		 BufferedReader br = null;
		int j=0;
		String[] ary=GifBrewery.String_ary.ary();
		try {
			Process p = Runtime.getRuntime().exec("adb shell monkey -v -p com.sogou.novel 100000");				
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
		
			while ((line = br.readLine()) != null) {
				
				if(j==0){
					ary[0]=line;
				}else if(j>0){
				ary=Arrays.copyOf(ary,ary.length+1);
				ary[ary.length-1]=line;	
				System.out.println(line);
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
						
}
}

