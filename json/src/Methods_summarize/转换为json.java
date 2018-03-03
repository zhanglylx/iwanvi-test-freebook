package Methods_summarize;

import java.util.HashMap;

import net.sf.json.JSONObject;

public class 转换为json {

	public void HashMap(){
		//将Map转换为json
		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put( "name", "json" );  
        map.put( "bool", Boolean.TRUE );  
        map.put( "int", new Integer(1) );  
        map.put( "arr", new String[]{"a","b"} );  
        map.put( "func", "function(i){ return this.arr[i]; }" );            
        JSONObject jsonObject = JSONObject.fromObject( map );  
        System.out.println( jsonObject );  
	}
}
