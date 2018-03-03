package AppiumMethod;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Tooltip {
	static{
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            ((Throwable) e).printStackTrace();
        }
	}
	/**
	 * 完成提示框
	 * @param Hint
	 */
	public static void finishHint(String Hint){
		JOptionPane.showMessageDialog(null, Hint); 
		System.exit(0);
	}
	/**
	 * 错误提示框
	 */
	public static void errHint(String Hint){
		JOptionPane.showMessageDialog(null, Hint, "错误，程序停止",JOptionPane.ERROR_MESSAGE);   
		System.exit(0);
	}
	public static void errHint(String Hint,String[] str){ for(String s : str){
			System.out.println("错误信息:"+s);
		}
		JOptionPane.showMessageDialog(null, Hint, "错误，程序停止",JOptionPane.ERROR_MESSAGE);   
		System.exit(0);
	}
}
