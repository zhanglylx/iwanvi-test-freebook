package Methods_summarize;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;

public class 获取系统进程 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 获取系统所有进程
		// ProcessBuilder pb = new ProcessBuilder("tasklist");
		// Process p = pb.start();
		// BufferedReader out = new BufferedReader(
		// new InputStreamReader(new BufferedInputStream(p.getInputStream()),
		// Charset.forName("GB2312")));
		// BufferedReader err = new BufferedReader(new InputStreamReader(new
		// BufferedInputStream(p.getErrorStream())));
		//
		// StringText ostr;
		// while ((ostr = out.readLine()) != null){
		// System.out.println(ostr);
		// }
		// StringText estr = err.readLine();
		// if (estr != null) {
		// System.out.println("\nError Info");
		// System.out.println(estr);
		// }

		// 查找具体进程
		while (true) {
			Process proc = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq " + "chrome.exe" + "\"");
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(proc.getInputStream(), Charset.forName("GB2312")));
			String line = null;
			String arr;
			int memory = 0;
			String[] arrays = null;
			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				if (line.matches(".+.exe.*")) {
					arr = line.replaceAll(" +", "!");
					arrays = arr.split("!");
					memory += Integer.parseInt(arrays[4].replaceAll(",", ""));
				}

			}
			System.out.println(memory + arrays[5]);
			System.out.println("--------------");
		}
	}
}
