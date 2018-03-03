package 设计模式;

import java.util.ArrayList;
import java.util.List;

public class Test单利 {

	public static void main(String[] args) {
		//单利模式 obj = new 单利模式();
		单利模式 obj = 单利模式.get单利模式();
		单利模式 obj2 = 单利模式.get单利模式();
		System.out.println(obj.getX());
		System.out.println(obj2.getX());
	}

}
