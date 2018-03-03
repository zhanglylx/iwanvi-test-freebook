package File文件类;

import java.io.File;

public class 查看目录下的子目录或文件 {

	public static void main(String[] args) {
		File dir = new File(".");
		//是否为一个目录
		//在linux中和命令ls效果相同。获取子项
		if(dir.exists() && dir.isDirectory()){
			//获取当前目录的子项(文件或目录)
			File[] files = dir.listFiles();
			for(File file : files){
				//若这个子项是一个文件
				if(file.isFile()){
					System.out.println("文件"+file.getName());
				}else{
					System.out.println("目录"+file.getName());
				}
			}
		}
	}

}
