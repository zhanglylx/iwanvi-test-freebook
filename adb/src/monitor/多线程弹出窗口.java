package monitor;

import javax.swing.JOptionPane;

public class 多线程弹出窗口 {

	public static void exi() {
		// TODO 自动生成的方法存根
		 //int a =0;
		Thread t = new Thread(new Runnable(){
			   public void run(){
				  // int exi=JOptionPane.showMessageDialog(null, "开始获取性能信息，请见console日志", "提示", JOptionPane.WARNING_MESSAGE); 
				   int   exi = JOptionPane.showConfirmDialog (null, "开始获取性能信息，关闭程序请按确认", "友情提示", JOptionPane.WARNING_MESSAGE);//你的提示消息   
				   if(exi==0){
					   System.exit(0);
				   }
				   
				   //	System.out.println(exi);
				//if (exi == JOptionPane.YES_OPTION)
			   }
			});
		t.start();
		
				
	}

}
