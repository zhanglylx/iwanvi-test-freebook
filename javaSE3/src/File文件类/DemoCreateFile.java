package File文件类;

import java.io.File;
import java.io.IOException;

/**
 * 在A目录下创建文件data.dat
 * @author Administrator
 *
 */
public class DemoCreateFile {

	public static void main(String[] args) throws IOException {
		/**
		 * 两种方式：
		 * 1:直接指定data.dat需要创建的位置
		 *   并调用createNewFile().前提是，目录都要存在！
		 * 2:先指定data.dat目录，不存在的都创建好后在创建文件
		 * ./demo/A/data.dat
		 */
		//1
//		File file = new File("."+File.separator+"demo"
//							+File.separator+"A"
//							+File.separator+"data.dat"
//								);
//		if(!file.exists()){
//			//将异常抛出到main方法外，仅供演示！实际不可取！
//			file.createNewFile();
//			System.out.println("文件创建成功！");
//		}
		
		//2
		/**
		 * 步骤：
		 *    1:创建一个File实例，代表data.dat即将存放的目录
		 *    2:若该目录不存在，则创建所有不存在的目录
		 *    3:在创建一个File实例，代表data.dat文件。创建是
		 *    	基于上一个代表目录的File实例的
		 *    4:创建该文件data.dat
		 */
		//a
		File dir = new File("."+File.separator
							+"demo"
		  				+File.separator+"A");
		//b
		if(!dir.exists()){
			dir.mkdirs();//不存在则创建所有必须的父目录和当前目录
		}
		/*
		 * c File(File dir,String fileName)构造方法
		 * 	在dir所代表的目录中表示fileName指定的文件
		 */
		File file = new File(dir,"dat.dat");
		if(!file.exists()){
			//d
		file.createNewFile();
		System.out.println("文件创建完毕！");
		}
	}

}
