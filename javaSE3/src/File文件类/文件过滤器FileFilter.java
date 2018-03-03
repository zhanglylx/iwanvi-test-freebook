package File文件类;

import java.io.File;
import java.io.FileFilter;

/**
 * 用在在获取某个目录下的子项时筛选出符合条件的子项
 * @author Administrator
 *
 */
public class 文件过滤器FileFilter {
	public static void main(String[] args) {
		/**
		 * 定义一个文件过滤器，用于过滤.java文件
		 * FileFilter是接口，使用内部类实现接口
		 */
		FileFilter filter = new FileFilter(){
			/**
			 * accept方法是用来定义过滤条件
			 * 参数pathname是将被过滤的目录中的每个子项
			 * 依次传入进行匹配
			 * 若我们认为该子项满足条件则返回true。
			 */
			public boolean accept(File pathname) {
				if(pathname.isFile()){
				//判断文件名以.java结尾的
				return pathname.getName().endsWith(".java") ||
						pathname.getName().endsWith(".classpath");
				}
				return false;
			}		
		};
		//创建一个目录
		File dir = new File(".");
		//获取所有子项
		//File[] sub = dir.listFiles();
		File[] sub = dir.listFiles(filter);//回调模式
		for(File file : sub){
			System.out.println(file);
		}
	}
}
