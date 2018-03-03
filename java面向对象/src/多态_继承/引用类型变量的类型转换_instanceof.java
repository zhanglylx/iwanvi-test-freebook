package 多态_继承;

public class 引用类型变量的类型转换_instanceof {

	public static void main(String[] args) {
		Circle_圆形_继承图形 c = new Circle_圆形_继承图形(3, 4, 5);
		Rect_矩形_继承图形 r = new Rect_矩形_继承图形(3,4,5,6);
		Shape_图形 s = c;
		Shape_图形 s1 =r;
	   // Circle_圆形_继承图形 x = s;//编译错误，父类型变量不能赋值给子类型
	    Circle_圆形_继承图形 x = (Circle_圆形_继承图形)s;//正常执行
	    //Circle_圆形_继承图形 y = (Circle_圆形_继承图形)s1;//运行异常，类型转换异常
	    //instaceof instace : 实例  of:的
	    //instaceof 运算  检查变量引用的对象的类型是否兼容
	    System.out.println(s instanceof Circle_圆形_继承图形);//true
	    System.out.println(s1 instanceof Circle_圆形_继承图形);//false
	    test(r);
	    test(c);
	}
	public static void test(Shape_图形 s){//多态的参数
		//if(s instanceof Circle_圆形_继承图形)保护了(Circle)s不会出现异常
		if(s instanceof Circle_圆形_继承图形){
			Circle_圆形_继承图形 c = (Circle_圆形_继承图形) s;
			System.out.println("这是一个圆，面积:"+c.area());
		}
		if(s instanceof Rect_矩形_继承图形){
			Rect_矩形_继承图形 r = (Rect_矩形_继承图形) s;
			System.out.println("这是一个矩形，面积:"+r.area());
		}
	}
}
