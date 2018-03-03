package apptest;

import org.openqa.selenium.By;

public class Text1 {
	private Devices devices;

	public Text1() {
		while (true) {
			String text = "龙血";
			devices = Devices.getDevices("测试搜索一本书籍加入书架并可以打开");
			System.out.println("执行测试搜索一本书籍加入书架并可以打开");
			devices.snapshot("从书架进入搜索");
			devices.clickfindElement(By.id("com.mianfeia.book:id/title_right_view_2"));
			devices.snapshot("点击书架的搜索按钮");
			devices.inputCharacter(By.className("android.widget.EditText"), text);
			devices.snapshot("搜索框中输入" + text);
			// 点击搜索按钮
			devices.clickfindElement(By.id("com.mianfeia.book:id/title_right_view"));
			// 检查在线阅读按钮
			if (!devices.isElementExsitAndroid(By.id("com.mianfeia.book:id/search_result_to_read_btn"))) {
				System.out.println("在线阅读按钮不存在");
				devices.snapshot("在线阅读按钮不存在");
				break;
			}
			devices.snapshot("搜索结果页");
			// 检查加入书架按钮
			if (!devices.isElementExsitAndroid(By.id("com.mianfeia.book:id/search_result_to_add_btn"))) {
				System.out.println("加入书架按钮不存在");
				devices.snapshot("加入书架按钮不存在");
				break;
			}
			// 检查搜索的第一个结果是否正确
			if (!"龙血战神".equals(devices.getText(By.id("com.mianfeia.book:id/search_result_title_view")))) {
				System.out.println("搜索的结果检查不正确,没有检测到:" + text);
				devices.snapshot("搜索结果不正确");
				break;
			}
			// 点击加入书架按钮
			devices.clickfindElement(By.id("com.mianfeia.book:id/search_result_to_add_btn"));
			devices.snapshot("点击加入书架按钮");
			// 检查加入书架按钮
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (devices.isElementExsitAndroid(By.id("com.mianfeia.book:id/search_result_to_add_btn"))) {
				System.out.println("点击加入书架按钮后加入书架按钮没有消失");
				devices.snapshot("点击加入书架按钮后加入书架按钮没有消失");
				break;
			}
			//点击返回键
			devices.backspace();
			devices.backspace();
			devices.snapshot("点击返回键到书架");
			break;
		}
	}
}
