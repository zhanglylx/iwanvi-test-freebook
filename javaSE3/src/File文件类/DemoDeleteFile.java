package File文件类;

import java.io.File;
import java.io.IOException;

/**
 * 删除一个文件
 * @author Administrator
 *
 */
public class DemoDeleteFile {

	public static void main(String[] args) throws IOException {
		/**
		 * 删除项目根路径下的文件date.dat
		 * 
		 * 注意：
		 * 	直接写文件名作为路径和"./date.dat"代表相同文件
		 * 
		 * 注意:
		 * 		删除目录时要确保该目录下没有任何子项后才可以将
		 * 		目录删除，否则删除失败！
		 * 
		 * 
		 * 
		 */
		File file = new File("F:/新建文件夹 (2)");
		file.createNewFile();
		//等同于上面的效果，都代表当前目录下date.dat
		//File file = new File("."+File.separator+"date.dat");
		if(file.exists()){
			//删除文件
			if(file.delete()){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		}
	
	
	
	}

}
