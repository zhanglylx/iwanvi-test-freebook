package File文件类;

import java.io.File;

/**
 * 使用File创建目录
 * 
 * @author Administrator
 *
 */
public class DemoFileDir {
	public static void main(String[] args) {
		/**
		 * mkdir():只能在已有的目录基础上创建目录
		 * mkdirs():可以创建所有必要的父目录并创建该目录
		 */
		try{
		//在项目根目录下创建demo目录
			File dir = new File("."+File.separator+"demo");
			if(!dir.exists()){
				//不存在则创建该目录
				dir.mkdir();
				System.out.println("目录创建成功！");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("创建失败");
		}
		/**
		 * 在项目根目录下创建test目录并创建子目录A
		 * 
		 * 路径./test/A
		 */
		try{
				File dir = new File("."+File.separator+"test"+
									File.separator+"A");
				if(!dir.exists()){
					//不存在则创建该目录
					dir.mkdirs();
					System.out.println("目录创建成功！");
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("创建失败");
			}
		
		
	}

}
