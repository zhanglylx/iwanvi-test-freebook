package AppiumMethod;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.android.AndroidDriver;

public class 图片对比 {
	private static final File F1 = new File("F:\\java学习笔记\\javaSE核心\\设计模式\\dd.png");
	private static final File F2 = new File("F:\\java学习笔记\\javaSE核心\\设计模式\\ss.png");
	/**
	 * 获取本地已保存的文件
	 * @param f
	 * @return
	 */
	public static BufferedImage getImageFromFile(File f){
	    BufferedImage img = null;   
	    try {
	        img = javax.imageio.ImageIO.read(f);
	    }   
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	    return img;
	 }
	/**
	 * 进行图片对比
	 * @param myImage
	 * @param otherImage
	 * @param percent
	 * @return
	 */
	public static boolean sameAs(BufferedImage myImage,BufferedImage otherImage, double percent){

		if (otherImage.getWidth() != myImage.getWidth()) {  
	       return false;    
	    }
	    if (otherImage.getHeight() != myImage.getHeight()) {
	       return false;
	    }
	    int width = myImage.getWidth(); 
	    int height = myImage.getHeight();   
	    int numDiffPixels = 0;  
	    for (int y = 0; y < height; y++) {
	        for (int x = 0; x < width; x++) {
	             if (myImage.getRGB(x, y) != otherImage.getRGB(x, y)) {
	             numDiffPixels++;
	             }
	        }
	    }   
	    double numberPixels = height * width;   
	    double diffPercent = (numDiffPixels*1.0) / numberPixels;  
	    return percent <= (1.0D - diffPercent)*100;
	 }
	/**
	 * 获取图片对比结果
	 * @param driver
	 * @return
	 */
	private static String getResult(){
	    Boolean same;
	    String result=null;
	    String StrJ1 = "click";
	    String StrJ2 = "swipe";
	    Object mstrHI = null;
//		if((StrJ1.equals(mstrHI))||(StrJ2.equals(mstrHI))){
	        try{
	            BufferedImage img1=getImageFromFile(F1);
	            BufferedImage img2=getImageFromFile(F2);
	            same=sameAs(img1,img2,80);
	            result = String.valueOf(same);

	        }
	        catch (Exception e) {e.printStackTrace();}  
//	    }
	    return result;    
	 }
	public static void main(String[] args) {
		System.out.println(getResult());
	}
}
