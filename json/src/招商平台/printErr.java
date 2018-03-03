package 招商平台;

import java.awt.Toolkit;
import java.util.List;
import java.util.Map.Entry;

public class printErr {
	public printErr(){}
	public printErr(List<String> list){
		System.out.println("检查结束，不合格case共:"+list.size()+"条");
		if(list.size()>0){
			Toolkit.getDefaultToolkit().beep();	
		}
		for(int i=0;i<list.size();i++){
			System.out.println("第"+(i+1)+"条:"+list.get(i));
			
		}
	}
}
