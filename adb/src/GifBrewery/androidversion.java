package GifBrewery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class androidversion {

	public static boolean androidversions() {
		// TODO 自动生成的方法存根
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell getprop");				
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
		
		//selinux.policy_version
		Arrays.sort(ary);
			for(int i=0;i<ary.length;i++){
				if((ary[i]).contains("ro.build.version.release")){
					ary = ary[i].split("\\[");	
					ary = ary[2].split("\\]");	
				    String[] arr = ary[0].split("\\.");				    
						if(4<Integer.parseInt(arr[0])){
							return true;
							}else if(4 ==Integer.parseInt(arr[0])
								&& 4 <=Integer.parseInt(arr[1])){
								return true;
							}else{
							System.out.println("录像功能需要4.4以上手机");
							System.out.println("当前系统:"+ary[0]);
							break;
							}
							
						}
						
					}
			return false;
				}					
}


