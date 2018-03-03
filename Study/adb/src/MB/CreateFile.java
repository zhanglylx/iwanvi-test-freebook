package MB;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import MB.cmd;
public class CreateFile {

	public static void fileLastModified() throws IOException{ //创建文件
		File file=new File(path.path()+"\\c.gif"); 
		file.createNewFile();
		
	}
	public static boolean fileExists() throws IOException, AWTException{ //检查目录
		Robot robot = new Robot();
		File filea=new File(path.path()+"\\a.txt"); 
		if(filea.exists()){
		cmd.keyPressString(robot, "del "+path.path()+"\\a.txt");
		cmd.enter();
		}
		cmd.keyPressString(robot, "cd "+path.path());
		cmd.enter();
		cmd.keyPressString(robot, "cd.>a.txt");
		cmd.enter();
		File file=new File(path.path()+"\\a.txt"); 
		boolean a=file.exists();
		cmd.keyPressString(robot, "del "+path.path()+"\\a.txt");
		cmd.enter();
		return a;
	}	
}
