package jir;
import java.io.ByteArrayInputStream;   
import java.io.ByteArrayOutputStream;   
import java.io.IOException;   
import java.util.zip.GZIPInputStream;   
import java.util.zip.GZIPOutputStream;   
// 将一个字符串按照zip方式压缩和解压缩   
public class GZIP {   
  
 // 压缩   
 public static String compress(String str) throws IOException {   
    if (str == null || str.length() == 0) {   
     return str;   
   }   
    ByteArrayOutputStream out = new ByteArrayOutputStream();   
   GZIPOutputStream gzip = new GZIPOutputStream(out);   
    gzip.write(str.getBytes());   
    gzip.close();   
   return out.toString("UTF-8");   
  }   
  
  // 解压缩   
 public static String uncompress(String str,String encoding) throws IOException {     
	 if("gzip".equals(encoding)==false){
		 return str;
	 }
	 if (str == null || str.length() == 0) {   
      return str;   
  }   
	 System.out.println(str);
   ByteArrayOutputStream out = new ByteArrayOutputStream();   
  // ByteArrayInputStream in = new ByteArrayInputStream(str   
  //      .getBytes("ISO-8859-1")); 
   ByteArrayInputStream in = new ByteArrayInputStream(str   
		         .getBytes("UTF-8"));  
    GZIPInputStream gunzip = new GZIPInputStream(in);   
    byte[] buffer = new byte[256];   
    int n;   
   while ((n = gunzip.read(buffer))>= 0) {   
    out.write(buffer, 0, n);   
    }   
    // toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)   
    return out.toString();   
  }   
  
}  