package File文件类;

import java.io.File;
import java.io.IOException;

public class 文件工具类FileUtils {

	/**
	 * 列出给定目录下的所有子项(包括子目录中的子项)的名字
	 * 
	 * @param dir
	 * @throws IOException
	 */

	public static void listDirectory(File dir) throws IOException {
		/**
		 * 判断参数给定的目录是否存在 要做对参数的合法性判断，避免程序出错
		 */
		if (dir == null) {
			throw new NullPointerException("参数是空的");
		}
		if (!dir.exists()) {
			throw new IllegalArgumentException(dir + "路径不正确");
		}
		/**
		 * 再次进行安全验证，查看是否为一个目录而不是文件！
		 */
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "不是目录");
		}
		// 获取当前目录下的所有子项
		File[] files = dir.listFiles();
		// 判断子项数组有效
		if (files != null && files.length > 0) {
			// 遍历该目录下的所有子项
			for (File file : files) {
				// 若子项是文件，那么直接输出文件名
				if (file.isFile()) {
					System.out.println(file);
					// 否则是一个目录
				} else {
					/**
					 * 当前方法的作用就是给定一个目录，输出目录下的 所有子项，所以，若这个还是一个目录，还可以通过 当前方法输出其子项
					 * 这种在当前方法中调用当前方法的行为被称为递归 不到万不得已，尽量不使用递归。非常消耗资源的方式
					 */
					listDirectory(file);

				}
			}
		}

	}

	/**
	 * 删除给定的目录
	 * 
	 * @param dir
	 * @throws IoException
	 */
	public static void deleteDirectory(File dir) throws IOException {
		if (dir == null) {
			throw new NullPointerException("参数是空的");
		}
		/**
		 * 判断参数给定的目录是否存在 要做对参数的合法性判断，避免程序出错
		 */
		if (!dir.exists()) {
			throw new IllegalArgumentException(dir + "路径不正确");
		}
		/**
		 * 再次进行安全验证，查看是否为一个目录而不是文件！
		 */
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + "不是目录");
		}
		// 获取当前目录下的所有子项
		File[] files = dir.listFiles();
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isFile()) {
					if (file.delete()) {
						System.out.println(file+"删除成功file");
					} else {
						throw new IOException("无法删除文件："+file);
					}
				} else {
					//递归删除子目录下的所有子项
					deleteDirectory(file);
				}
			}
		}
		//所有子项删除后，要删除当前方法传入参数的这个目录
		if (dir.delete()) {
			System.out.println(dir+"删除成功");
		} else {
			throw new IOException("无法删除："+dir);
		}
	}

	public static int num(int n) {
		if (n == 100) {
			return 100;
		}
		return n + num(n - 1);
	}

	public static void main(String[] args) throws IOException {
		File file = new File("F:/test");
//		listDirectory(file);
		deleteDirectory(file);
		// System.out.println(num(10));

	}
}
