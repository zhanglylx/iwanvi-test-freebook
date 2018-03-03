package Methods_summarize;

import java.util.ArrayList;

public class list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Student> list = new ArrayList <Student> ();
		Student s1 = new Student("it001","黄渤",1.72);
		Student s2 = new Student("it002","孙红雷 ",1.78);
		list.add(s1);
		list.add(s2);
		System.out.println(list.get(0).getHeight());
	}

}
class Student{
	private String id;
	private String name;
	private double height;
	public Student(){
		
	}
	public Student(String id,String name,double height){
		this.id = id;
		this.name = name;
		this.height = height;
	}
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public double getHeight(){
		return this.height;
	}
}