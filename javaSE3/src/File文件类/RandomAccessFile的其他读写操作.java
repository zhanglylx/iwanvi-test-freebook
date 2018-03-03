package File文件类;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile的其他读写操作 {
    public static void main(String[] args) {
        /**
         * 创建RandomAccessFile的另一个构造方法
         * 直接根据文件路径指定，前提是确保其存在
         */
        try ( RandomAccessFile raf =
                new RandomAccessFile("dat.dat","rw")){
           
            //写int最大值
            raf.writeInt(Integer.MAX_VALUE);//一次写入4个字节，写int值
            //写long最大值
            raf.writeLong(Long.MAX_VALUE);

            //写字符串
            raf.writeUTF("hello!");

            raf.seek(0);
            int intMax = raf.readInt();
            long longMax = raf.readLong();
            String info = raf.readUTF();
            System.out.println("int最大值："+intMax);
            System.out.println("long最大值："+longMax);
            System.out.println("字符串："+info);
            raf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
