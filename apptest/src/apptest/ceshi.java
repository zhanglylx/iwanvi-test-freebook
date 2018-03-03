package apptest;

import java.io.IOException;

public class ceshi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  Runtime rt = Runtime.getRuntime();
	        // this code for record the screen of your device
	        rt.exec("cmd.exe /C adb shell screenrecord /sdcard/ruCase.mp4");
	}

}
