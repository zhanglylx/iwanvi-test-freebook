package 招商平台;

import javax.swing.JOptionPane;

public class reminder  {
	public reminder(String reminder) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				JOptionPane.showMessageDialog(null, reminder, "预置条件",JOptionPane.WARNING_MESSAGE);					
			}
		});
		t.start();
	}
}