package 多态_继承;
/**
 * 重写方法的调用
 * @author Administrator
 *
 */
public class 重写父类方法调用 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Shape_图形 s1 = new Circle_圆形_继承图形(3,4,5);
		//s1 引用的是圆对象，调用重写方法的时候
		//执行的是子类圆重写的方法！并不执行Shape声明的方法
		System.out.println(s1.contains(1, 1));
		System.out.println(s1.contains(10, 10));
		print(new Circle_圆形_继承图形(5, 5, 6),new Rect_矩形_继承图形(5, 5, 6, 7));
	}
	public static void print(Shape_图形 s1,Shape_图形 s2){
		for(int y=0;y<20;y++){
			for(int i = 0;i<20;i++){
				//重写的方法在运行期间动态绑定到对象的方法
				if(s1.contains(i, y) && s2.contains(i, y)){
					System.out.print("+");
				}else if (s1.contains(i, y)){
					System.out.print("-");
				}else if (s2.contains(i, y)){
					System.out.print("|");
					
				}else{
					System.out.print(" ");
				}
			}	
			System.out.println();
		}
	}
}
