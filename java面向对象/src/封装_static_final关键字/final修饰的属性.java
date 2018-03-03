package 封装_static_final关键字;
/**
 * final 表示初始化不能再修改
 * static 表示只有一个
 * 
 *static final 共同修饰的叫常量
 *常量: PI 是直接数的代名词
 *字面量:直接写出数 3.1415926535897
 */
public class final修饰的属性 {
	public static final double PI = 3.1415926535897;

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		//d1.id = 8;
		System.out.println(d1.id+","+d2.id+","+Dog.numOfDogs);
	}

}
class Dog{
	final int id;//实例变量，不能再次修改
	static int numOfDogs=0;//静态，只有一份
	public Dog(){
		id = numOfDogs++;
	}
}