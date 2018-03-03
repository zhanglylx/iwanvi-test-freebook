package AppiumMethod;

import io.appium.java_client.android.AndroidDriver;

public class 滑动屏幕 {
	/**
	 * 向左滑动
	 */
	public static void swipeToLeft2(AndroidDriver driver2, int during) {
		int width = driver2.manage().window().getSize().width;
		System.out.println("width:"+width);
		int height = driver2.manage().window().getSize().height;
		System.out.println("height:"+height);
		// driver2.swipe(width * 3 / 4, height / 2, width / 4, height / 2,
		// during);
//		driver2.swipe(width * 8 / 9, height / 2, width / 8, height / 2, during);
		System.out.println("----");
		driver2.swipe(1354, 521,67, 462, during);
		System.out.println("===");
		// wait for page loading
	}
	 /**
     * Swipe up on the screen
     */
  public static void swipeToUp(AndroidDriver driver, int time) {
       int width = driver.manage().window().getSize().width;
       int height = driver.manage().window().getSize().height;
       driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, time);
   }

   /**
     *  Swipe to right on the screen
     */
   public static void swipeToRight(AndroidDriver driver, int time) {
       int width = driver.manage().window().getSize().width;
       int height = driver.manage().window().getSize().height;
       driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, time);
   }
}
