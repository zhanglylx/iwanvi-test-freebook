package File文件类;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class 读写文件RandomAccessFile {
	public static void main(String[] args) throws IOException {
		/**
		 * 向文件 .\data.dat中写入数据
		 * 步骤：
		 * 		1.创建一个File对象用于描述该文件
		 * 		2.不存在则创建该文件
		 * 		3.创建RandomAccessFile，并将File传入
		 * 		   使RandomAccessFile对File表示的文件进行读写操作
		 * 		4.向文件中写入内容
		 */
		//1
		File file = new File("."+File.separator+"demo.dat");
		//2
		if(!file.exists()){
			//创建该文件
			file.createNewFile();
		}
		//3 对file文件可以进行读写操作
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		/*
		 * 4
		 * 写一个int最大值
		 * 2位16进制代表一个字节    8位2进制
		 * 1位16进制代表4位2进制
		 * 4字节代表32位2进制
		 * 
		 * write(int)写一个字节
		 * int最大值:01111111 11111111 11111111 11111111
		 * 
		 * 写入方式: 二进制                                               16进制
		 * 00000000 00000000 00000000 01111111  | 00 00 00 7f
		 * 00000000 00000000 01111111 11111111	| 00 00 7f ff
		 * 00000000 01111111 11111111 11111111	| 00 7f ff ff
		 * 01111111 11111111 11111111 11111111	| 7f ff ff ff
		 * 
		 * 位移00
		 * >>>
		 */
		int i = 0X7fffffff;//int最大值
		//写int值最高的8位  
		raf.write(i>>>24);//00 00 00 7f
		raf.write(i>>>16);//00 00 7f ff
		raf.write(i>>>8); //7f ff ff ff
		raf.write(i);
		
		
		//定义一个10字节数组
		byte[] data = new byte[]{0,1,2,3,4,5,6,7,8,9};
		//将这10个字节全部写入文件
		raf.write(data);
		//写到这里，当前文件应该有14个字节了
		
		//写字节数组的重载方法。
		/*
		 * write(byte[] data,int offset,int length);
		 * 从data数组的offset位置开始写，连续写length个字节到
		 * 文件中。
		 * {0,1,2,3,4}
		 */
		raf.write(data,0,5);//0,1，2，3，4
		
		/**
		 * 读
		 *  		01111111 11111111	11111111 11111111
		 *  num :	00000000 00000000 	00000000 00000000
		 *   b  :   00000000 00000000	00000000 01111111
		 *   b<<24: 01111111 00000000  	00000000 00000000
		 */
		System.out.println("当前指针位置:"+raf.getFilePointer());
		raf.seek(0);//将指针移动到文件开始的位置
		int num = 0 ;//准备读取的int值
		int b = raf.read();//读取第一个字节 7f
		num = num|(b<<24);// 01111111 00000000  	00000000 00000000
		
		b = raf.read();//读取第二个字节 ff
		num = num|(b<<16);// 01111111 11111111 00000000  00000000
		
		b = raf.read();//读取第三个字节 ff
		num = num|(b<<8);// 01111111 11111111 11111111  00000000
		
		b = raf.read();//读取第四个字节 ff
		num = num | b;// 01111111 11111111 11111111  11111111
		System.out.println("int最大值:"+num);
		
		raf.seek(0);//回到文件的开始位置
		byte[] buf = new byte[1024];//1K的内容
		int sum = raf.read(buf);//尝试读取1k的数据
		System.out.println("总共读取了"+sum+"个字节");
		System.out.println(Arrays.toString(buf));
		//写完了不再写了就关了
		raf.close();
		System.out.println(i);
		
	}
}
