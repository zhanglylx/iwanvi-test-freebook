package 多态_继承;
/**
 * 构造器是不能继承的！
 * 子类型构造器默认调用父类型的无参数构造器
 *
 */
public class 子类不能继承父类构造器_子类默认调用父类无参数构造器 {

	public static void main(String[] args) {
		//Goo goo = new Goo(5);//编译错误，Goo中没有Goo(int)构造器
		Goo goo = new Goo();//调用的是Goo默认构造器
		Moo moo = new Moo();//子类型默认调用父类型默认构造器
		//输出Call Noo()
	}

}

class Noo{
	public Noo(){
		System.out.println("Call Noo()");
	}
}
class Moo extends Noo{	
	public Moo(){};
}


class Soo{
	public Soo(){		
	}
	public Soo(int a){
		System.out.println("Call Soo(int)");
	}
}
class Goo extends Soo{
	
}