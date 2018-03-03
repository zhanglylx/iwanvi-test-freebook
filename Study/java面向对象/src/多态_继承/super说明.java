package 多态_继承;

public class super说明 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
	}

}
class Ioo {
	
}
class Ooo extends Ioo{
	public Ooo(){
		super();//super()必须用在子类构造器的第一行
	}
	public Ooo(int a){
		//super();//默认在构造器的第一行存在super()
	}
}