package 字符流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class DemoSystemOut {

	public static void main(String[] args) {
		System.out.println("你好! !");
		PrintStream out = System.out;
		
		try {
			PrintStream fileOut = new PrintStream(
					new FileOutputStream("SystemOut.txt"));
			//将我们给定的输出流赋值到System.out上
			System.setOut(fileOut);
			System.out.println("你好！ ！! 我是输出到控制台的！");		
			System.setOut(out);
			System.out.println("我是输出到控制台的 ！");
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
