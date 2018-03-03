package MB;

import javax.swing.JOptionPane;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import MB.devices;
import MB.path;
import MB.FileTime;
import MB.CreateFile;
import MB.androidversion;
public class cmd {	
	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		// TODO 自动生成的方法存根		
		Runtime runtime=Runtime.getRuntime();
					
		Robot robot = new Robot();
		String Gif = "\\aa.gif";
		String mp4 = "\\aa.mp4";
		String NoTime = FileTime.timeGif(Gif);//获取文件修改之前的时间
		String NoMp4 = FileTime.timeGif(mp4);
		boolean device=devices.devices();//检测devices是否存在	
		if(device==false){ //检测是否有设备连接
			JOptionPane.showMessageDialog(null, "没有找到设备", "提示", JOptionPane.WARNING_MESSAGE); 
			System.exit(0);
		}	
		if(androidversion.androidversions() == false){
			JOptionPane.showMessageDialog(null, "软件版本不正确，4.4以上\nandroid才能够录制屏幕", "提示", JOptionPane.WARNING_MESSAGE); 
			System.exit(0);
		}
			try{	
			
				// keyPressWithCtrl(robot,KeyEvent.VK_SPACE);  //春霞电脑代码
				runtime.exec("cmd /k start ");//打开控制台,打开目录		
				Thread.sleep(1000);
				keyPressString(robot,"adb shell screenrecord /sdcard/aa.mp4");	//输入录制命令	
				/*
				adb();
				space();
				shell();
				space();
				screenrecord();
				space();
				sdcard();
				aamp4();
				*/
				//aryScreenrecord =Screenrecord.screenrecord();
				enter();
				System.out.println("开始录制手机屏幕");	
				JOptionPane.showMessageDialog(null, "开始录制视频，结束请按确定", "警告", JOptionPane.WARNING_MESSAGE); 
				keyPressWithCtrl(robot,KeyEvent.VK_C);
				Thread.sleep(1000);
				keyPressString(robot,path.pathbase());			
				enter();			
				keyPressString(robot,"cd "+path.path());
				enter();
				Thread.sleep(100);
				//adb shell screenrecord /sdcard/aa.mp4	  				
				/**
				adb();
				space();
				pull();
				space();
				sdcard();
				aamp4();  //春霞电脑代码
				**/
				keyPressString(robot, "adb pull /sdcard/aa.mp4 "+path.path());//拉取文件到电脑		    
				enter(); 
				Thread.sleep(1000);
				if(NoMp4.equals(FileTime.timeGif(mp4))){
					System.out.println("拉取文件失败");
					JOptionPane.showMessageDialog(null, "文件拉取失败啦", "提示", JOptionPane.WARNING_MESSAGE); 
					System.exit(0);
				}
				System.out.println("将录制的MP4文件导入到电脑"); 	  
				//ffmpeg -i aa.mp4 aa.gif
				keyPressString(robot,"cd "+path.path()+"\\ffmpeg\\bin");
				enter();
				keyPressString(robot, "ffmpeg -i "+path.path()+"\\aa.mp4 "
									+ path.path()+"\\aa.gif");//进行MP4转换为gif
				enter();    
				System.out.println("将录制的MP4文件转换为gif");
				
				if(fileExists()){ //检查目录下是否存在文件，如果存在，在cmd中输入y并回车
					Thread.sleep(1000);
					for(int i=0;i<3;i++){
						keyPress(robot, KeyEvent.VK_Y);
						enter();
						enter(); 
						Thread.sleep(500);
						}   	 
					}	  	     	     	   	     
				
				while(true){
					String YesTime = FileTime.timeGif(Gif);//获取文件修改之后的时间			
					boolean a =CreateFile.fileExists();
				
					if(YesTime.equals(NoTime)==false && a == true){			
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, "操作完成", "提示", JOptionPane.PLAIN_MESSAGE);                
						runtime.exec("cmd /c start "+path.path());//打开转换完成目录
						break;
					}			
					System.out.println(a);
					if(a == true  && YesTime.equals(NoTime)==true ){						
					System.out.println("转换失败");
					JOptionPane.showMessageDialog(null, "转换失败", "提示", JOptionPane.PLAIN_MESSAGE);
					break;
					}

					
				}		
				
			
		}catch(Exception e){
		System.out.println("Error!");
		}
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
		}
		
	
	public static boolean fileExists(){ //检查目录
		File file=new File(path.path()+"\\aa.gif"); 
		return file.exists();
	}	
	public static void MINUS() throws AWTException{  //-i
		Robot robot = new Robot();
		 keyPress(robot, KeyEvent.VK_MINUS);
		 keyPress(robot, KeyEvent.VK_I);
	}
	public static void ffmpeg()throws AWTException{ //ffmpeg
		Robot robot = new Robot();
		 keyPress(robot, KeyEvent.VK_F);
		 keyPress(robot, KeyEvent.VK_F);
		 keyPress(robot, KeyEvent.VK_M);
		 keyPress(robot, KeyEvent.VK_P);
		 keyPress(robot, KeyEvent.VK_E);
		 keyPress(robot, KeyEvent.VK_G);
	}
	public static void pull() throws AWTException{
		//pull
		Robot robot = new Robot();
		 keyPress(robot, KeyEvent.VK_P);
	     keyPress(robot, KeyEvent.VK_U);
	     keyPress(robot, KeyEvent.VK_L);
	     keyPress(robot, KeyEvent.VK_L);
	}
	public static void sdcard() throws AWTException{
		 ///sdcard/
		Robot robot = new Robot();
		 keyPress(robot, KeyEvent.VK_DIVIDE); 
	     keyPress(robot, KeyEvent.VK_S);
	     keyPress(robot, KeyEvent.VK_D);
	     keyPress(robot, KeyEvent.VK_C);
	     keyPress(robot, KeyEvent.VK_A);
	     keyPress(robot, KeyEvent.VK_R);
	     keyPress(robot, KeyEvent.VK_D);
	     keyPress(robot, KeyEvent.VK_DIVIDE);  
	     
	}
	public static void aamp4()throws AWTException{
		//aa.mp4
		Robot robot = new Robot();
		 keyPress(robot, KeyEvent.VK_A);
	     keyPress(robot, KeyEvent.VK_A);
	     keyPress(robot, KeyEvent.VK_DECIMAL);
	     keyPress(robot, KeyEvent.VK_M);
	     keyPress(robot, KeyEvent.VK_P);
	     keyPress(robot, KeyEvent.VK_4);
	     
	}
	public static void aagif() throws AWTException{
		Robot robot = new Robot();
		 keyPress(robot, KeyEvent.VK_A);
	     keyPress(robot, KeyEvent.VK_A);
	     keyPress(robot, KeyEvent.VK_DECIMAL);
	     keyPress(robot, KeyEvent.VK_G);
	     keyPress(robot, KeyEvent.VK_I);
	     keyPress(robot, KeyEvent.VK_F);
	     
	}
	public static void enter()throws AWTException{
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_ENTER);
	}
	public static void screenrecord()throws AWTException{
		Robot robot = new Robot();
		//SCREENRECORD 
	     keyPress(robot, KeyEvent.VK_S);
	     keyPress(robot, KeyEvent.VK_C);
	     keyPress(robot, KeyEvent.VK_R);
	     keyPress(robot, KeyEvent.VK_E);
	     keyPress(robot, KeyEvent.VK_E);
	     keyPress(robot, KeyEvent.VK_N);
	     keyPress(robot, KeyEvent.VK_R);
	     keyPress(robot, KeyEvent.VK_E);
	     keyPress(robot, KeyEvent.VK_C);
	     keyPress(robot, KeyEvent.VK_O);
	     keyPress(robot, KeyEvent.VK_R);
	     keyPress(robot, KeyEvent.VK_D);
	}
	public static void adb() throws AWTException{
		  //ADB
		Robot robot = new Robot();
				keyPress(robot, KeyEvent.VK_A);
			     keyPress(robot, KeyEvent.VK_D);
			     keyPress(robot, KeyEvent.VK_B);		    
	}
	public static void shell() throws AWTException {//shell
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_S);
	     keyPress(robot, KeyEvent.VK_H);
	     keyPress(robot, KeyEvent.VK_E);
	     keyPress(robot, KeyEvent.VK_L);
	     keyPress(robot, KeyEvent.VK_L);
	}
	public static void space() throws AWTException{
		Robot robot = new Robot();
				keyPress(robot, KeyEvent.VK_SPACE);
	}
	
	   // shift+ 按键
		        public static void keyPressWithShift(Robot r, int key) {
		                r.keyPress(KeyEvent.VK_SHIFT);
		                r.keyPress(key);
	                r.keyRelease(key);
		                r.keyRelease(KeyEvent.VK_SHIFT);
		                r.delay(100);
		        }
		 
		        // ctrl+ 按键
		        public static void keyPressWithCtrl(Robot r, int key) {
		                r.keyPress(KeyEvent.VK_CONTROL);
		                r.keyPress(key);
		                r.keyRelease(key);
		                r.keyRelease(KeyEvent.VK_CONTROL);
		                r.delay(100);
		        }
		 
		        // alt+ 按键
		        public static void keyPressWithAlt(Robot r, int key) {
		                r.keyPress(KeyEvent.VK_ALT);
		                r.keyPress(key);
		                r.keyRelease(key);
		                r.keyRelease(KeyEvent.VK_ALT);
	                r.delay(100);
	        }
	        //打印出字符串
	        public static void keyPressString(Robot r, String str){
	                Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();//获取剪切板
	                Transferable tText = new StringSelection(str);
	                clip.setContents(tText, null); //设置剪切板内容
	                keyPressWithCtrl(r, KeyEvent.VK_V);//粘贴
	                r.delay(100);
		        }
		         
	        //单个 按键
		        public static void keyPress(Robot r,int key){
		                r.keyPress(key);
		                r.keyRelease(key);
		                r.delay(100);
  }

}
