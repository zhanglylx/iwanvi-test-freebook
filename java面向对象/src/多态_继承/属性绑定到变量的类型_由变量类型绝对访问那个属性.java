package 多态_继承;
/**
 * 属性绑定到变量的类型，由变量类型决定访问那个属性
 * 方法动态绑定到对象，由对象的类型决定访问那个方法
 * @author Administrator
 *
 */
public class 属性绑定到变量的类型_由变量类型绝对访问那个属性 {
	public static void main (String [] args){
		Cheater c = new Cheater();
		Person p = c;
		System.out.println(p.name + "," + c.name);
		p.whoau();c.whoau();
	}
}
class Person{
	String name = "灰太狼";
	public void whoau(){
		System.out.println(this.name);
	}
}
class Cheater extends Person{
	String name = "喜羊羊";
	public void whoau(){
		System.out.println(this.name);
		//System.out.println(super.name);
	}
}