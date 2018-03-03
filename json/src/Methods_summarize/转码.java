package Methods_summarize;
import java.io.UnsupportedEncodingException;
/**
 * 以下代码中提供将字符解码和转码
 * @author Administrator
 *
 */
public class 转码  {
	public static void main(String [] args ){
		System.out.println(getURLDecoderString("http://imap.sit.ffan.com/office/book?data=%7B%22officeId%22%3A%226%22%2C%22useTime%22%3A%5B%7B%22startTime%22%3A1505430000%2C%22endTime%22%3A1505417400%7D%5D%7D%26token%3D0ad9deaaa13020cf79b19a76b9100345"));
	}
	  private final static String ENCODE = "utf-8"; 

	    /**
	     * URL 解码
	     *
	     * @return StringText
	     * @author zhanglianyu
	     * @date 2017.7.23
	     */
	    public static String getURLDecoderString(String str) {
	        String result = "";
	        if (null == str) {
	            return "";
	        }
	        try {
	        	
	            result = java.net.URLDecoder.decode(str,ENCODE);
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	    /**
	     * URL 转码
	     *
	     * @return StringText
	     * @author lifq
	     * @date 2015-3-17 下午04:10:28
	     */
	    public static String getURLEncoderString(String str) {
	        String result = "";
            str = str.replace("\n", "\r\n");
	        if (null == str) {
	            return "";
	        }
	        try {
	            result = java.net.URLEncoder.encode(str, ENCODE);
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    /**
	     * 
	     * @return void
	     * @author 张连宇
	     */

}
