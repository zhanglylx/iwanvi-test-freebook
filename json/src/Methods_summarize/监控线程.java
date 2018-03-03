package Methods_summarize;

import java.util.HashMap;
import java.util.Map;

import sun.security.util.SecurityConstants;

public class 监控线程 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			int t=0;
			Map<Thread, StackTraceElement[]> maps = Thread.getAllStackTraces();
			for(Thread s : maps.keySet()){
				System.out.println(s);
				if(s.toString().matches(".+,main]")){
					t+=1;
				}
			}
			if(t==1){
				break;
			}
		}			
	}
}

