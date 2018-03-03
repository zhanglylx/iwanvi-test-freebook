package AppiumMethod;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class 验证元素是否存在 {
	// 使用方法：isElementExsitAndroid(driver,By.id("com.zhanglb.yijiebao:id/editRemark"));

       //验证登录元素是否存在

public static boolean isElementExsitAndroid(AndroidDriver driver,By elemnt){ 
          boolean flag = false;  
           try {  
               WebElement element=driver.findElement(elemnt);  
               flag=null!=element;  
           } catch (org.openqa.selenium.NoSuchElementException e) {  
               System.out.println("Element:" + elemnt.toString()  

                       + " is not exsit!"); 
               flag=false;          
           }  
           return flag;  
      }  
}
