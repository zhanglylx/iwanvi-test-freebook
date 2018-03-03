package novel_delete;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

import GifBrewery.*;
public class adb_novel_delete {
	
	 public static void main(String[] args) throws AWTException, IOException, InterruptedException{
		System.out.println("==");
		 Runtime runtime =Runtime.getRuntime();
		 boolean device=devices.devices();//检测devices是否存在	 	
			 if(device==false){
				 System.out.println("没有找到设备");
				 JOptionPane.showMessageDialog(null, "没有找到设备", "提示", JOptionPane.WARNING_MESSAGE); 
	  			System.exit(0);
			 }	
			 Robot robot = new Robot();
			 while(true){
				 int i=0;
		int unin=uninstall.uninstall();
		System.out.println("正在卸载:");
		if(unin==0){
			System.out.println("卸载成功");
			i=1+i;
		}else if(unin==2){
			 System.out.println("卸载失败，从新尝试卸载");
			 i=1+i;
		}else if(unin==1){
				 //JOptionPane.showMessageDialog(null, "没有安装", "提示", JOptionPane.WARNING_MESSAGE); 
			System.out.println("没有安装");
			i=1+i;
		}
		System.out.println("正在删除.novel目录:");
		if(unin==0){
		 Thread.sleep(2000);
		}
			 int rm=RmNoveldata.RmNovel();//获取删除.novel文件状态
			 
			 if(rm==0){
				 System.out.println("删除成功");
				 i=1+i;
			 }else if(rm ==1){
				 System.out.println("目录删除失败，请手动删除.novel文件"); 
				 i=1+i;
			 }else if(rm ==2){
				 System.out.println("删除异常，从新尝试删除");			 
			 }else if(rm==3){
				 System.out.println("没有权限，无法删除.novel");
				 i=1+i;
			 	}
			 if(i>1){
				 break;
			 }
			 }
		
			 runtime.exec("cmd /k start ");
			 Thread.sleep(300);
			GifBrewery.StartGifBrewery.keyPressString(robot,"adb install -r  ");
			 Thread.sleep(6000);
			
			 
			 
			 
			 
			 
		}
	
	 public static void shift() throws AWTException{
		 Robot robot = new Robot();
		 keyPress(robot,KeyEvent.VK_SHIFT);
	 }
     public static void keyPress(Robot r,int key){
         r.keyPress(key);
         r.keyRelease(key);
         r.delay(100);
}
}	 
