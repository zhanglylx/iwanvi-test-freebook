package 多态_继承;
/**
 * 1.类一定有构造器
 * 2.子类一定调用父类构造器
 *   2.1 子类默认调用父类无参数构造器
 *   2.2 如果父类没有无参数构造器，必须使用super()调用
 *   	父类构造器
 *关于super():一定在子类构造器第一行使用！如果没有
 *			默认存在super();是java默认添加的super()                                                                                                                                                                                                                                                                             
 */
public class 父类无默认构造器使用super调用 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Yoo yoo = new Yoo();
	}

}
class Xoo{
	public Xoo(int s){
		System.out.println("Call Xoo(int)");
	}
}
//class Yoo extends Xoo{}//编译错误，子类调用不到父类型无参数构造器
class Yoo extends Xoo{
	public Yoo(){
		//super();//编译错误，子类调用不到父类型无参数构造器
		super(100);//super(100) 调用了父类 Xoo(int) 构造器
	}
}	