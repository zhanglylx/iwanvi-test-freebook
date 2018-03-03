package File文件类;

import java.io.File;
import java.io.IOException;

/**
 * File类
 * @author Administrator
 *
 */
public class DemoFile {

	public static void main(String[] args) {
		/**
		 * 实例化一个文件，代表给定路径的文件或目录
		 * 
		 * 路径的描述不同的文件系统差异较大
		 * linux和windows就不同！
		 * 
		 * 最好使用相对路径，不要用绝对路径。
		 * 
		 * 
		 */
		/**
		 * "."代表的路径:当前目录
		 * 项目所处的目录
		 * eclipse_workspace/project_name/
		 * 
		 * File.separator目录分隔符。
		 */
		/**
		 * 创建该对象并不意味着硬盘上对应路径上就有该文件了
		 * 只是在内存中创建了该对象去代表路径指定的文件。当然这个
		 * 路径对象的文件可能根本不存在！
		 */
		File file = new File("."+File.separator+"date.dat");
		//判断该文件是否在硬盘中真实存在
		if(!file.exists()){
			/**
			 * 创建file代表的文件
			 * 调用该文件后，硬盘中就会存在该文件了!
			 * 这里要求强制捕获异常！createNewFile有throws声明
			 */
			try {
				file.createNewFile();
				System.out.println("创建文件成功！");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("创建文件失败了!");
			}
		}
	}

}
