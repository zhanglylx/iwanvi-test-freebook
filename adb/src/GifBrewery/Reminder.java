package GifBrewery;

import javax.swing.JOptionPane;

public class Reminder  {
	public Reminder(String reminder) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				JOptionPane.showMessageDialog(null, reminder, "提示",JOptionPane.WARNING_MESSAGE);					
			}
		});
		t.start();
	}
}