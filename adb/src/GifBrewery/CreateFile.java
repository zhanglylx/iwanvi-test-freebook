package GifBrewery;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import GifBrewery.StartGifBrewery;

public class CreateFile {

	public static void fileLastModified() throws IOException { // 创建文件
		File file = new File(path.pullPath + "\\c.gif");
		file.createNewFile();

	}

	public static boolean fileExists() throws IOException, AWTException, InterruptedException { // 检查目录
		Robot robot = new Robot();
		String fileName = "checkTransformOrderFinish.txt";
		File filea = new File(path.pullPath + fileName);
		if (filea.exists()) {
			StartGifBrewery.keyPressString(robot, "del " + path.pullPath + fileName);
			StartGifBrewery.enter();
		}
		StartGifBrewery.keyPressString(robot, "cd " + path.pullPath);
		StartGifBrewery.enter();
		StartGifBrewery.keyPressString(robot, "cd.>" + fileName);
		StartGifBrewery.enter();
		File file = new File(path.pullPath + "\\" + fileName);
		boolean a = file.exists();
		StartGifBrewery.keyPressString(robot, "del " + path.pullPath + "\\" + fileName);
		StartGifBrewery.enter();
		return a;
	}
}
