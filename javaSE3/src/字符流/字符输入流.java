package 字符流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符输入流
 * @author Administrator
 *
 */
public class 字符输入流 {

	public static void main(String[] args) {
		InputStreamReader reader = null;
		try{
			FileInputStream fis = 
					new FileInputStream("writer.txt");
			//创建用于以字符为单位读取数据的高级流
			reader = new InputStreamReader(fis,"UTF-8");
			//读取数据
			int c = -1;
			while((c=reader.read())!=-1){
				System.out.println((char)c);
			}
			
		}catch (IOException e) {
			
		}finally{
			if(reader != null){
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
			}
		}
	}

}
