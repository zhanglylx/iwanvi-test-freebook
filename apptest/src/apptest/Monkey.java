package apptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import AppiumMethod.config;

public class Monkey {

	public static void main(String[] args) {
		try {
			Process pro = Runtime.getRuntime().exec("cmd /c adb  shell monkey -p com.mianfeia.book -v -v"
					+ "   1000000  2>D:\\error.txt 1>D:\\info.txt ");
			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
