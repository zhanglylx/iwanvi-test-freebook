package GifBrewery;

import javax.swing.JOptionPane;

public class CheckDevices {
	public CheckDevices() {
	     // 检测devices是否存在
		if (devices.devices() == false) { // 检测是否有设备连接
			JOptionPane.showMessageDialog(null, "没有找到设备", "提示", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		if (androidversion.androidversions() == false) {
			JOptionPane.showMessageDialog(null, "软件版本不正确，4.4以上\nandroid才能够录制屏幕", "提示", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}
}
