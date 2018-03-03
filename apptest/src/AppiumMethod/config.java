package AppiumMethod;

import java.io.File;
import javax.swing.filechooser.FileSystemView;

public class config {
	// adb.exe文件地址,不用动，已经配置好，自动搜索，如果不需要请填写路径
	public static final String ADB_PUTH =GetLocalityFilePuth.getPuth("adb.exe");
	
	// app文件包名
	public static final String APP_PACKAGE = "com.mianfeia.book";
	
	// app启动Activity
	public static final String APP_ACTIVITY = "com.chineseall.reader.ui.FlashActivity";
	
	// 截图是否替换
	public static final boolean SCREEN_SHOTS_REPLACE = true;
	
	// app在本地的名称，用于安装app，请将文件放置在桌面或子文件夹中
	public static final String APP_FILE_NAME = "1063.apk";
	
	// 是否覆盖手机中的包
	public static final boolean PHONE_REPLACE_PACKAGE = false;

	// 保存截图地址,默认地址是桌面log文件夹
	public static final String IMAGES_B = FileSystemView.getFileSystemView().getHomeDirectory() + File.separator
			+ "log";
	
	
	static {
		if (installAPPPackage.isChinese(APP_FILE_NAME) || !APP_FILE_NAME.matches("[0-9A-Za-z-()_]+(\\.apk)")) {
			print(APP_FILE_NAME);
		}
		if (installAPPPackage.isChinese(IMAGES_B)) {
			print(IMAGES_B);
		}
	}
	
	private static void print(String errName){
		Tooltip.errHint(errName+"名字不合法， 包含中文或者特殊字符");
	}
}
