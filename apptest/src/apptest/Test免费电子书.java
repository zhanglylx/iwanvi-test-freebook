package apptest;

import org.openqa.selenium.By;
/**
 * 测试免费电子书
 * 测试步骤: 打开appium服务
 *          连接一台手机
 *          配置AppiumMethod中的config
 *          
 * 		在类中进行创建Devices对象
 * 		使用Devices中的方法通过元素进行屏幕的操作和判断
 * @author 张连宇
 *
 */
public class Test免费电子书 {
	Devices	devices = Devices.getDevices("等待主页展现");
	public static void main(String[] args) {
		//初始化免费电子书进入到书架
		Test免费电子书 te = new Test免费电子书();
		te.waitHomePage();
		//执行第一条case
		new Text1();
		
	}
	
	
	
	
	
	
	
	/**
	 * 等待主页展示
	 */
	private void waitHomePage() {
		System.out.println("等待主页展示.....");
		while (true) {
			if (devices.isElementExsitAndroid(By.id("com.mianfeia.book:id/tab_shelf_view"))) {
				devices.snapshot("主页展现");
				break;
			}else if (devices.isElementExsitAndroid(By.id("com.mianfeia.book:id/img_ad_detail")) 
					|| devices.isElementExsitAndroid(By.id("com.mianfeia.book:id/tab_comp_view"))
					){
				devices.snapshot("当前未在主页");
				backBookRack();
				break;
				
			}
		}
			try {
				Thread.sleep(1500);
				System.out.println("主页展示");
				System.out.println();
			} catch (InterruptedException e) {
				System.out.println("等待主页展示时发生异常");
				e.printStackTrace();
			}
			

	}
	/**
	 * 返回到书架
	 */
	private void backBookRack(){
		while(true){
			devices.backspace();
			if(devices.isElementExsitAndroid(By.id("com.mianfeia.book:id/message_two_tip"))){
				devices.backspace();
				break;
			}
		}
	}
}
