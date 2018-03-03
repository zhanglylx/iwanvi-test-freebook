package Methods_summarize;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class 数组去重 {
	public static void main(String [] args){
		ArrayList<String> list =new ArrayList();
		list.add("e");
		list.add("c");
		list.add("c");
		for(int i =0;i<list.size()-1;i++){
			
			for(int j = list.size()-1;j>i;j--){
				if(list.get(j).equals(list.get(i))){
					list.remove(j);
				}
			}
		}
		for(int i =0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
