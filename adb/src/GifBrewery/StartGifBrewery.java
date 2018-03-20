package GifBrewery;

import javax.swing.JOptionPane;

import GifBrewery.CreateFile;
import GifBrewery.FileTime;
import GifBrewery.androidversion;
import GifBrewery.devices;
import GifBrewery.path;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

public class StartGifBrewery {
	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		// 检查是否连接设备
		new CheckDevices();
		Runtime runtime = Runtime.getRuntime();
		path path = new path();
		String GifName = path.getGifName();
		String Mp4Name = path.getMp4Name();
		Robot robot = new Robot();
		String GifPath = GifBrewery.path.pullPath + GifName;
		String mp4Path = GifBrewery.path.pullPath + Mp4Name;
		String NoTime = FileTime.timeGif(GifPath);// 获取文件修改之前的时间
		String NoMp4 = FileTime.timeGif(mp4Path);

		try {		
			// 启动前cmd进程计数
			int startingPeriodPrior = getCourse.getCMDOpenNumber();
			runtime.exec("cmd /k start ");// 打开控制台,打开目录
			Thread.sleep(2000);
			//检测cmd进程是否打开
			while (true) {
				if (getCourse.getCMDOpenNumber() >startingPeriodPrior ) {
					break;
				}else{
					runtime.exec("cmd /k start ");// 打开控制台,打开目录
					break;
				}
			}
			keyPressWithAlt(robot, KeyEvent.VK_SPACE); // 按下 alt+ 空格
			keyPress(robot, KeyEvent.VK_X); // 按下x键
			// adb shell screenrecord /sdcard/aa.mp4
			Thread.sleep(1000);
			keyPressString(robot, "adb shell screenrecord /sdcard/" + Mp4Name); // 输入录制命令
			enter();
			System.out.println("开始录制手机屏幕");
			Object[] options = { "取消", "录制结束" }; // 自定义按钮上的文字
			int m = JOptionPane.showOptionDialog(null, "开始录制视频", "标题", JOptionPane.YES_NO_OPTION,
					JOptionPane.CANCEL_OPTION, null, options, options[1]);
			System.out.println(m);
			if (m == 1) {
				Thread.sleep(500);
			} else {
				keyPressWithCtrl(robot, KeyEvent.VK_C);
				System.exit(0);
			}

			// adb shell screenrecord /sdcard/.mp4
			keyPressString(robot, "adb pull /sdcard/" + Mp4Name + " " + GifBrewery.path.pullPath);// 拉取文件到电脑
			enter();
			// 检查mp4导入是否成功
			new CheckPullFile(NoMp4, mp4Path);
			// 检查mp4是否导入完成
			while (true) {
				File file = new File(mp4Path);
				long before = file.length();
				Thread.sleep(100);
				long later = file.length();
				if (before == later) {
					break;
				}
			}
			Thread.sleep(100);

			System.out.println("将录制的MP4文件导入到电脑");
			// ffmpeg -i aa.mp4 aa.gif
			// keyPressString(robot, "cd " + path.ffmpegPatb);
			// enter();
			boolean checkFileGif = fileExists(GifName);
			keyPressString(robot, "ffmpeg -i " + GifBrewery.path.pullPath + Mp4Name + " -s 250x400  -b:v 1500k "
					+ GifBrewery.path.pullPath + GifName);// 进行MP4转换为gif
			enter();
			System.out.println("将录制的MP4文件转换为gif");
			if (checkFileGif) { // 检查目录下是否存在文件，如果存在，在cmd中输入y并回车
				Thread.sleep(1000);
				for (int i = 0; i < 3; i++) {
					keyPress(robot, KeyEvent.VK_Y);
					enter();
					enter();
					Thread.sleep(500);
				}
			}
			while (true) {
				String YesTime = FileTime.timeGif(GifPath);// 获取文件修改之后的时间
				// 记录转换是否完毕状态
				// 通过持续输入创建文本获取文件是否存在，如果检测到创建的文件已存在，代表转换已执行完毕
				// boolean executingState = CreateFile.fileExists();
				boolean executingState = getCourse.getFfmpegCourse();
				if (YesTime.equals(NoTime) == false && executingState == /* true */ false) {
					openFileMenu(path.getGifName());
					break;
				}
				Thread.sleep(200);
				if (executingState == /* true */ false && YesTime.equals(NoTime) == true) {
					System.out.println("转换失败");
					JOptionPane.showMessageDialog(null, "转换失败", "提示", JOptionPane.PLAIN_MESSAGE);
					break;
				}

			}
			Thread.sleep(500);
			System.exit(0);

		} catch (Exception e) {
			System.out.println("Error!");
		}

	}

	public static boolean fileExists(String GifName) { // 检查目录
		File file = new File(path.pullPath + "\\" + GifName);
		return file.exists();
	}

	public static void MINUS() throws AWTException { // -i
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_MINUS);
		keyPress(robot, KeyEvent.VK_I);
	}

	public static void ffmpeg() throws AWTException { // ffmpeg
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_F);
		keyPress(robot, KeyEvent.VK_F);
		keyPress(robot, KeyEvent.VK_M);
		keyPress(robot, KeyEvent.VK_P);
		keyPress(robot, KeyEvent.VK_E);
		keyPress(robot, KeyEvent.VK_G);
	}

	public static void pull() throws AWTException {
		// pull
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_P);
		keyPress(robot, KeyEvent.VK_U);
		keyPress(robot, KeyEvent.VK_L);
		keyPress(robot, KeyEvent.VK_L);
	}

	public static void sdcard() throws AWTException {
		/// sdcard/
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

	public static void aamp4() throws AWTException {
		// aa.mp4
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_A);
		keyPress(robot, KeyEvent.VK_A);
		keyPress(robot, KeyEvent.VK_DECIMAL);
		keyPress(robot, KeyEvent.VK_M);
		keyPress(robot, KeyEvent.VK_P);
		keyPress(robot, KeyEvent.VK_4);

	}

	public static void aagif() throws AWTException {
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_A);
		keyPress(robot, KeyEvent.VK_A);
		keyPress(robot, KeyEvent.VK_DECIMAL);
		keyPress(robot, KeyEvent.VK_G);
		keyPress(robot, KeyEvent.VK_I);
		keyPress(robot, KeyEvent.VK_F);

	}

	public static void enter() throws AWTException {
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_ENTER);
	}

	public static void screenrecord() throws AWTException {
		Robot robot = new Robot();
		// SCREENRECORD
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

	public static void adb() throws AWTException {
		// ADB
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_A);
		keyPress(robot, KeyEvent.VK_D);
		keyPress(robot, KeyEvent.VK_B);
	}

	public static void shell() throws AWTException {// shell
		Robot robot = new Robot();
		keyPress(robot, KeyEvent.VK_S);
		keyPress(robot, KeyEvent.VK_H);
		keyPress(robot, KeyEvent.VK_E);
		keyPress(robot, KeyEvent.VK_L);
		keyPress(robot, KeyEvent.VK_L);
	}

	public static void space() throws AWTException {
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

	// 打印出字符串
	public static void keyPressString(Robot r, String str) {
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();// 获取剪切板
		Transferable tText = new StringSelection(str);
		clip.setContents(tText, null); // 设置剪切板内容
		keyPressWithCtrl(r, KeyEvent.VK_V);// 粘贴
		r.delay(100);
	}

	// 单个 按键
	public static void keyPress(Robot r, int key) {
		r.keyPress(key);
		r.keyRelease(key);
		r.delay(100);
	}

	public static long FileSize(String path) {
		File file = new File(path);
		return file.length();

	}

	public static void openFileMenu(String gifName) {
		// TODO 自动生成的方法存根
		// int a =0;
		Thread t = new Thread(new Runnable() {
			public void run() {
				// 代码块
				Runtime runtime = Runtime.getRuntime();
				try {
					runtime.exec("cmd /c explorer /select, " + path.pullPath + gifName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 打开转换完成目录
			}
		});
		Thread s = new Thread(new Runnable() {
			public void run() {
				// 播放系统提示音
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "操作完成", "提示", JOptionPane.PLAIN_MESSAGE);
			}
		});
		t.start();
		s.start();
	}

}