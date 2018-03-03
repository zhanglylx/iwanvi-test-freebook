package Methods_summarize;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class 消息提示框 {

	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            ((Throwable) e).printStackTrace();
        }
		//showMessaDialog（只有一个确认按钮的消息提示框）
		JOptionPane.showMessageDialog(null, "我是普通提示框！╮(╯▽╰)╭");  
		JOptionPane.showMessageDialog(null, "我是警告提示框！╮(╯▽╰)╭", "标题",JOptionPane.WARNING_MESSAGE);  
		JOptionPane.showMessageDialog(null, "我是错误提示框！╮(╯▽╰)╭", "标题",JOptionPane.ERROR_MESSAGE); 
		JOptionPane.showMessageDialog(null, "我是最基本提示框！╮(╯▽╰)╭", "标题",JOptionPane.PLAIN_MESSAGE);
		//showOptionDialog(带有自定义选择按钮的选择提示框，按钮和提示消息均可自定义)
		int n = JOptionPane.showConfirmDialog(null, "你会了吗?", "标题",JOptionPane.YES_NO_OPTION); //返回值为0或1
		Object[] options ={ "必须是", "当然是" };  //自定义按钮上的文字
		int m = JOptionPane.showOptionDialog(null, "钓鱼岛是中国的吗？", "标题",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]); 
		//showInoutDialog（带有下拉选择列表或者输入框的提示框，并可以将用户选择或者输入信息返回）
		Object[] obj2 ={ "路人甲", "路人乙", "路人丙" };  
		String s = (String) JOptionPane.showInputDialog(null,"请选择你的身份:\n", "身份", JOptionPane.PLAIN_MESSAGE, new ImageIcon("icon.png"), obj2, obj2[2]);
		JOptionPane.showInputDialog(null,"请输入：\n","title",JOptionPane.PLAIN_MESSAGE); 
	
	
	
	}

}
