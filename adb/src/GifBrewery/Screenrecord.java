package GifBrewery;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class  Screenrecord {
	public static String[] screenrecord() {
//	public static void (StringText[] args){
		BufferedReader br = null;
		int j=0;
		String[] ary=new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c start adb shell screenrecord /sdcard/aa.mp4");				
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
		return ary;
	}
	 public static void keyPressString(Robot r, String str){
         Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();//获取剪切板
         Transferable tText = new StringSelection(str);
         clip.setContents(tText, null); //设置剪切板内容
         keyPressWithCtrl(r, KeyEvent.VK_V);//粘贴
         r.delay(100);
     }
	 public static void keyPressWithCtrl(Robot r, int key) {
         r.keyPress(KeyEvent.VK_CONTROL);
         r.keyPress(key);
         r.keyRelease(key);
         r.keyRelease(KeyEvent.VK_CONTROL);
         r.delay(100);
 }
}
