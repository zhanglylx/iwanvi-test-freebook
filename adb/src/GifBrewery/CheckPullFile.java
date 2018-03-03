package GifBrewery;

import javax.swing.JOptionPane;

public class CheckPullFile {
	public CheckPullFile(String NoMp4,String mp4){
		System.out.println(NoMp4);
		System.out.println(FileTime.timeGif(mp4));
		if (NoMp4.equals(FileTime.timeGif(mp4))) {
			System.out.println("拉取文件失败");
			JOptionPane.showMessageDialog(null, "文件拉取失败啦", "提示", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}
}
