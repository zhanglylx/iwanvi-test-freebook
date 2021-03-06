package 接口;
/**
 * interface 差不多 adbstract class
 * 接口中只能声明抽象方法和常量
 * Runner 可以跑的人
 * 接口可以定义变量，接口不能实例化，即可只能被"实现"
 * 具体类实现一个接口，必须实现全部的抽象方法。
 * 具体类可以同时实现多个接口，就是多继承现象
 * 多重继承: Cat 既是Hunter  也是 Runner
 * implements 实现，实际是继承关系
 * 
 * 
 * @author Administrator
 *
 */

public class 接口 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat tom = new Cat();
		Hunter hunter = tom;
		Runner runner = tom;
		hunter.hunt();
		runner.run();
		hunter.run();
		//new Runner();//编译错误，不能创建接口的实例
		//runner.hunt(); 编译错误，Runner上没有定义hunt方法
	}

}
/**
 * 以下代码是类和接口之间的关系
 * 创建类和接口并实现抽象方法
 * @author Administrator
 *
 */
class Cat implements Hunter,Runner{ //实现多个接口
	/**
	 * 因为Huter继承了Runner，Huter和Runner存在两个抽象方法，所以在
	 * 类中两个方法都要实现
	 */
	public void hunt(){//实现接口中的抽象方法
		System.out.println("抓猫去！");
	}
	public void run(){
		System.out.println("速度是"+SPEED);//SPEED从Runner继承的
	}
}
interface Hunter extends Runner{//猎人是能跑的
	void hunt();//打猎
}
interface Runner{
	/* public static final */ int SPEED = 100;
	/* public abstract */void run();
}