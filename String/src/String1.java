/**
 * 以下代码包含String一些用法：查找字符的索引
 * 字符串去除空格，替换字符串指定字符,判断字符串是否相等,判断字符串开始或结尾是否相等
 * 字母大小写转换,分割字符串，判断字符串是否为数字和字母
 */
import java.util.StringTokenizer;

public class String1 {

	public static void main(String[] args) {
		
		String s1=new String(" hello");
		String s2=new String("wordw");
		String s=s1+" "+s2;
		System.out.println(s);
		int a=s.lastIndexOf("w");   //指定字符最后出现的位置
		System.out.println(a);
        System.out.println(s.charAt(a));
		/*
		 * //字符串去除空格StringTokenizer方法
		 */
        StringTokenizer str=new StringTokenizer(s," ");

		StringBuffer sb=new StringBuffer();
		int i=1;
		while(str.hasMoreTokens()){
			i++;
			sb.append(str.nextToken());
		}
		System.out.println(i);
		System.out.println(sb.toString());
	   /*
	    * 字符串去除空格replaceAll方法（替代）
	    */
		s=s.replaceAll(" ", "");
		System.out.println(s);
		/*
		 * 字符串去除前后空格trim方法
		 */
		s=s.trim();
		System.out.println(s);
		/*
		 * 替换字符串指定字符replace
		 * replaceAll也可以替换
		 */
		s="bay bay ooo";
		s=s.replace("bay", "sood");
		System.out.println(s);
		/*
		 * 替换字符串第一个出现的字符，后边再次出现不做操作
		 */
		s=s.replaceFirst("o", "a");
		System.out.println(s);
		/*
		 * 判断字符串是否相等equals
		 * 严格匹配，区分大小写
		 */
		String a1=new String("你爱我吗abc");
		String a2=new String("你爱我吗abc");
		System.out.println(a1.equals(a2));
		/*
		 * 判断字符串是否相等equalsIgnoreCase
		 * 不区分大小写
		 */
		System.out.println(a1.equalsIgnoreCase(a2));
		String a3=new String("你爱我吗ABC");
		String a4=a1;
		boolean b1=(a1==a2);
		boolean b2=(a1==a4);
		boolean b3=a1.equals(a2);
		boolean b4=a1.equals(a3);
		boolean b5=a1.equalsIgnoreCase(a2);
		boolean b6=a1.equalsIgnoreCase(a3);
		System.out.println("a1==a2:"+b1);
		System.out.println("a1==a4:"+b2);
		System.out.println("a1.equals(a2):"+b3);
		System.out.println("a1.equals(a3):"+b4);
		System.out.println("a1.equalsIgnoreCase(a2):"+b5);
		System.out.println("a1.equalsIgnoreCase(a3)"+b6);
		/*
		 * 判断字符串开始与结尾startsWith/endsWith
		 */
		boolean q1=s.startsWith("s");
		boolean q2=s.endsWith(a1);
		System.out.println(q1+" "+q2);
		/*
		 * 字母大小写转换
		 */
		String ss=new String("abc ABC 123 思维刘");
		String ss1=ss.toLowerCase();
		String ss2=ss.toUpperCase();
		System.out.println(ss1);
		System.out.println(ss2);
		/*
		 * 分割字符串split
		 */
		String split=new String(",QWE,RTY,UIO,P[]");
		String[] newSplit=split.split(",");//完全分割
		for (int ii=0;ii<newSplit.length;ii++){
			//System.out.println(newSplit[ii]);
		}
		String[] new1Split=split.split(",", 2);//指定分割
		for (int iii=0;iii<new1Split.length;iii++){
			System.out.println(new1Split[iii]);
		}
		
	    /*
	     * 判断字符串是否是数字格式
	     */
		String dd="3212321";
		boolean d1=String1.lsNumber(dd);
		boolean d2=String1.lsNumber1(dd);
		System.out.println(d1);
		if(d1==true && d2==true){
			System.out.println(dd+"true");
		}else{
			System.out.println(dd+"false");
		}
			
	}


public static boolean lsNumber(String str){ //构造lsNumber方法，并把lsNumber的值传给str
	char [] c=str.toCharArray();   //将字符串分割为单个字符数组
	for (int i=0;i<c.length;i++){
		if(Character.isDigit(c[i])){ //Character.isDigit 方法检测字符是否为数字
			
		}else{
			return false;
		}
	
}
	return true;
	
}
public static boolean lsNumber1(String str){
	char[] w=str.toCharArray();		
	for (int i=0;i<w.length;i++){
		if(Character.isAlphabetic(w[i])){  //Character.isAlphabetic方法检查字符是否为字母
			return true;
		}
	}
	return false;
}
}