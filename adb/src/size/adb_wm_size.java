package size;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JOptionPane;

import GifBrewery.devices;
public class adb_wm_size {
	//public static   boolean devices() {
	public static void main(String[] args){
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		boolean device = devices.devices();
		if(device==false){ //检测是否有设备连接
			System.out.println("没有找到设备");
			JOptionPane.showMessageDialog(null, "没有找到设备", "提示", JOptionPane.WARNING_MESSAGE); 
			System.exit(0);
		}
		try {
			
			Process p = Runtime.getRuntime().exec("cmd /c  adb shell wm size");				
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
		String arr =ary[0];
		ary= arr.split(" ");
		String arrSplit = ary[2];
		ary= arrSplit.split("x");
			for(int i=0;i<ary.length;i++){
				System.out.println(ary[i]);
			}
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "宽度为:"+ary[0]+"; 高度为:"+ary[1], "提示", JOptionPane.PLAIN_MESSAGE);  
}
}
//int contains