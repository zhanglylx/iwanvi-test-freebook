package GifBrewery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class devices {
	public static boolean devices() {
		// public static void (StringText[] args){
		BufferedReader br = null;
		int j = 0;
		String[] ary = new String[1];
		try {
			Process p = Runtime.getRuntime().exec("cmd /c  adb devices");
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;

			while ((line = br.readLine()) != null) {

				if (j == 0) {
					ary[0] = line;
				} else if (j > 0) {
					ary = Arrays.copyOf(ary, ary.length + 1);
					ary[ary.length - 1] = line;
				}
				j++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(Arrays.toString(ary));
		Pattern pattern = Pattern.compile("^.+device$");
		int num = 0;
		for (int i = 0; i < ary.length; i++) {
			System.out.println(ary[i]);
			Matcher matcher = pattern.matcher(ary[i]);
			if (matcher.find()) {
				num++;
			}
		}
		// 判断电脑是否有多台手机同时连接
		if (num > 1) {
			JOptionPane.showMessageDialog(null, "设备太多了，请使用一个设备连接电脑！", "提示", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		if (ary.length < 3) { // 如果有设备，数组长度大于等于3
			System.out.println("没有找到设备");
			for (int i = 0; i < ary.length; i++) {
				System.out.println(ary[i]);
			}
			return false;
		}
		return true;
	}
}
// int contains