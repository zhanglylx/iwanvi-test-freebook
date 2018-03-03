package GifBrewery;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class getCourse {

	public static boolean getFfmpegCourse ()throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("tasklist");
		Process p = pb.start();
		BufferedReader out = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(p.getInputStream()), Charset.forName("GB2312")));
		BufferedReader err = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getErrorStream())));
		
		String ostr;
		boolean course = false;
		while ((ostr = out.readLine()) != null){
			if(ostr.contains("ffmpeg.exe")){
				course = true;
			}else{

			}
		}
		String estr = err.readLine();
		if (estr != null) {
			System.out.println("\nError Info getFfmpegCourse");
			System.out.println(estr);
		}
		
//		//查找具体进程
//		Process proc = Runtime.getRuntime().exec("tasklist /FI \"IMAGENAME eq " + "QQ.exe" + "\"");
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//		StringText line = null;
//		while ((line = bufferedReader.readLine()) != null) {
//			System.out.println(line);
//		    if (line.contains("QQ.exe")) {
//		        System.out.println("找到了");
//		    }
//		}
		return course;
	}
	/**
	 * 获取cmd新打开一个进程
	 * @return 是否打开一个cmd进程
	 * @throws IOException
	 */
	public static int getCMDOpenNumber ()throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("tasklist");
		Process p = pb.start();
		BufferedReader out = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(p.getInputStream()), Charset.forName("GB2312")));
		BufferedReader err = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getErrorStream())));	
		String ostr;
		int course = 0;
		while ((ostr = out.readLine()) != null){
			if(ostr.contains("cmd.exe")){
				course++;
			}
		}
		String estr = err.readLine();
		if (estr != null) {
			System.out.println("\nError Info ");
			System.out.println(estr);
		}
		
		return course;
	}

}
