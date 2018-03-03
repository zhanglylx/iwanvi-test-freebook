package apptest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import AppiumMethod.验证元素是否存在;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class test3 {
	static AndroidDriver driver;
	public static void main(String[] args) throws Exception {	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("automationName", "Appium");// appium做自动化
		// cap.setCapability("app", "C:\\software\\jrtt.apk");//安装apk
		// cap.setCapability("browserName", "chrome");//设置HTML5的自动化，打开谷歌浏览器
		cap.setCapability("deviceName", "03157df3d9998625");// 设备名称
		cap.setCapability("platformName", "Android"); // 安卓自动化还是IOS自动化
		cap.setCapability("platformVersion", "6.0.1"); // 安卓操作系统版本
		// cap.setCapability("udid", "03157df3d9998625"); // 设备的udid (adb
		// // devices 查看到的)
		cap.setCapability("appPackage", "com.mianfeia.book");// 被测app的包名
		cap.setCapability("appActivity", "com.chineseall.reader.ui.FlashActivity");// 被测app的入口Activity名称
		cap.setCapability("unicodeKeyboard", "True"); // 支持中文输入
		cap.setCapability("resetKeyboard", "True"); // 支持中文输入，必须两条都配置
		cap.setCapability("noSign", "True"); // 不重新签名apk
		cap.setCapability("newCommandTimeout", "30"); // 没有新命令，appium30秒退出
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);// 把以上配置传到appium服务端并连接手机
	   System.out.println("====");


		Thread.sleep(5000);
		// 通过id点击元素
		System.out.println("=====");
//		driver.findElement(By.id("com.sogou.novel:id/navigation_bar_rlayout_mine")).click();
		//
//		driver.findElement(By.id("com.mianfeia.book:id/tab_me_view")).click();
		
//		driver.findElement(By.id("com.sogou.novel:id/rl_search_et")).sendKeys("好");
//		clickScreen(1008,970,1,driver);
		Thread.sleep(1000);
//		System.out.println(driver.findElement(By.id("com.mianfeia.book:id/do_click_ad_layout")).isDisplayed());
//		driver.findElement(By.id("com.mianfeia.book:id/do_click_ad_layout")).click();
		Thread.sleep(1000);
//		clickScreen(711,342,1,driver);
		List list = new ArrayList();
		//通过xPath定位元素
		System.out.println(driver.findElementsByXPath("//android.widget.TextView").get(0));
		
	}
	
}
