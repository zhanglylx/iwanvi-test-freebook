package File文件类;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 思路:
 *  读取一个文件，将这个文件中每一个字节写到另一个文件中就完成了复制功能
 */
public class 使用RandomAccessFile完成文件复制 {
    public static void main(String[] args) {
        /**
         * 1:创建一个用于读取文件的RandomAccessFile
         *  用于读取被拷贝的文件
         *
         *  2.创建一个用于写入文件的RandomAccessFile
         *      用于写入拷贝的文件
         *
         *  3.读取被拷贝文件的所有字节并写到拷贝文件中
         */
        File file = new File(".project");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try  {
            RandomAccessFile src = new RandomAccessFile(file, "r");
            File desFile = new File("day06_capy.txt");
            RandomAccessFile des =
                    new RandomAccessFile(desFile,"rw");

            int data = 0;//用于保存每一个读取的字节
            //读取一个字节，只要不是-1(文件末尾)，就进行复制工作
//            while((data=src.read())!=-1){
//                des.write(data);//将读取的字节写入
//            }
            byte[] buff = new byte[1024*100];//创建一个字节数组
            int sun ;
            while(( sun = src.read(buff))>0){
                des.write(buff,0,sun);
            }
            src.close();
            des.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
