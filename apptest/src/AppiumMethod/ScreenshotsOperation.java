package AppiumMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/*
 * 截图操作
 */
public class ScreenshotsOperation {
	private File file;
	private String fileName;

	public ScreenshotsOperation(String caseName) {
		file = new File(config.IMAGES_B + File.separator + caseName);
		// 检查目录是否存在
		checkList();
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 检查文件目录是否存在 不存在创建目录
	 */
	private void checkList() {
		if (!file.exists() || !file.isDirectory()) {
			try {
				if (!file.mkdirs()) {
					Tooltip.errHint("截图目录创建失败:" + file.getPath());
				}
			} catch (Exception e) {
				Tooltip.errHint("截图目录创建失败:" + file.getPath());
			}
		}
	}

	/**
	 * 截图
	 */
	public void screenshot(File Image) {
		if (CheckFileExists()) {
			this.fileName = System.currentTimeMillis()+fileName;
		}
		try {
			FileUtils.copyFile(Image, new File(file + File.separator + fileName));
			if (!CheckFileExists()) {
				System.out.println("截图失败:" + fileName);
			}
		} catch (IOException e) {
			System.out.println("截图失败:" + fileName);
			e.printStackTrace();
		} 
	}
	/**
	 * 检查截图文件是否存在
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean CheckFileExists() {
		File fl = new File(file, fileName);
		if (fl.exists() && fl.isFile()) {
			return true;
		} else if (config.SCREEN_SHOTS_REPLACE) {
			return true;
		}
		return false;
	}

}
