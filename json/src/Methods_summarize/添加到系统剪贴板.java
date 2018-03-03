package Methods_summarize;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class 添加到系统剪贴板 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringSelection stringSelection = new StringSelection("剪贴板");
		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}

}
