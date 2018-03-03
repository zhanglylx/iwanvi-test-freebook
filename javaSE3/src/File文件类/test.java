package File文件类;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class test {
	@Test
	public void testse() {
		File file = new File("F:/test");
		System.out.println("---");
		try {
			文件工具类FileUtils.listDirectory(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
