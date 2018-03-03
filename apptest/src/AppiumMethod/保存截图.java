package AppiumMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class 保存截图 {
	//使用方法 snapshot((TakesScreenshot) driver, "firstjt.png");

/**

       * This Method create for take screenshot

       * 捕获截图功能

       * @author Young

       * @param drivername

       * @param filename

       * 调用snapshot((TakesScreenshot) driver, "zhihu_showClose.png");

       */
      public static void snapshot(TakesScreenshot drivername, String filename) {

          // this method will take screen shot ,require two parameters ,one is

          // driver name, another is file name

          String currentPath = System.getProperty("user.dir"); // get current work
                                                               // folde
          File scrFile = drivername.getScreenshotAs(OutputType.FILE);

          // Now you can do whatever you need to do with it, for example copy

          // somewhere

          try {

              System.out.println("save snapshot path is:" + currentPath + "/"

                      + filename);

              FileUtils.copyFile(scrFile, new File(currentPath + "\\" + filename));

          } catch (IOException e) {

              System.out.println("Can't save screenshot");

              e.printStackTrace();

          } finally {

              System.out.println("screen shot finished, it's in " + currentPath

                      + " folder");

          }

      } 

}
