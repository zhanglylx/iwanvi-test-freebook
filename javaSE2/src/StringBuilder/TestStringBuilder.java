package StringBuilder;
/**
 * StringBuilder 该类用于对某个字符串频繁的编辑操作
 * 使用StringBuilder可以在大规模修改字符串时不开辟新的字符串对象
 * 从而节约内容资源
 * 所以，对以有着大量操作字符串的逻辑中，不应使用String而应该使用StringBuilder
 * @author Administrator
 *
 */
/**
 * 测试StringBuilder
 * @author Administrator
 *
 */
public class TestStringBuilder {
	public static void main(String[] args){
	
//		StringText info = "java";
//		for(int i = 0;i<1000;i++){
//			info +=	"java";//String不合适大量拼接字符串
//		}
//		System.out.println(info);
//		StringBuilder builder = new StringBuilder("java");
//		for(int i=0;i<10000;i++){
//			builder.append(i+"java\n");
//		}
//		StringText info = builder.toString();
//		System.out.println(info); 
		StringBuilder builder = new StringBuilder();
		/**
		 * 向字符串中追加内容
		 * append是有返回值的，返回类型是StringBuilder
		 * 而返回的这个StringBuilder起始就是自己(this)
		 */
		builder.append("大家好！").append("我是传奇");
		System.out.println(builder.toString());
		
		/**
		 * 在当前字符串中"!"的位置后面追加一个"!"
		 * 在字符串中插入内容使用insert方法
		 * insert(int index,StringText str);
		 * 在index的位置插入str,原位置的内容依次往后移
		 */
		builder.insert(builder.lastIndexOf("！"), "!");
		System.out.println(builder.toString());
		
		/**
		 * 将大家好替换为早上好
		 */
		builder.replace(builder.indexOf("大"), 
				builder.indexOf("好",builder.indexOf("早"))+1, "早上好");
		System.out.println(builder.toString());
		
		/**
		 * 将"我是"删除
		 */
		builder.delete(builder.indexOf("我"), builder.indexOf("是")+1);
		System.out.println(builder.toString());
		
		/**
		 * StringBuilder与StringBuffer
		 * 相同点:效果一样，都是修改字符串，节省内存空间
		 * 区别:
		 * 		StringBuilder是线程不安全的
		 * 		StringBuffer是线程安全的
		 * 在多线程操作情况下应使用StringBuffer
		 * 		因为StringBuffer是线程安全的，它要顾及安全问题，而进行必要的安全验证操作，
		 * 所以效率上要比StringBuilder低。根据实际情况选择。
		 */
	}
}
