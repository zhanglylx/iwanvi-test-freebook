package 地图编辑器;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {
	 private static HSSFWorkbook workbook = null;  
	 /** 
     * 创建新excel. 
     * @param fileDir  excel的路径 
     * @param sheetName 要创建的表格索引 
     * @param map excel的第一行即表格头为key，第二行为values 
     */  
    public static void createExcel(String fileDir,String sheetName,Map<String,String> map) throws Exception{  
        //创建workbook  
        workbook = new HSSFWorkbook();  
        //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)  
        HSSFSheet sheet1 = workbook.createSheet(sheetName);    
       
        //新建文件  
        FileOutputStream out = null;  
        try {  
            //添加表头  
            HSSFRow row = workbook.getSheet(sheetName).createRow(0);    //创建第一行    
            HSSFRow rowTwo = workbook.getSheet(sheetName).createRow(1);    //创建第二行    
            /**
            for(int i = 0;i < map.size();i++){      	
                HSSFCell cell = row.createCell(i);  
                cell.setCellValue(titleRow[i].toString());  
                sheet1.autoSizeColumn(i,true);//自动适应宽度
            }  
            **/
            int i=0;
            for(Entry<String, String> entry : map.entrySet()){       	
            	 HSSFCell cell = row.createCell(i); 
            	 cell.setCellValue(entry.getKey());//将key付给头
            //	 sheet1.autoSizeColumn(i,true);//自动适应宽度
            	 HSSFCell cellTwo = rowTwo.createCell(i); 
            	 cellTwo.setCellValue(entry.getValue());//将值付给第二行
            	 sheet1.autoSizeColumn(i,true);//自动适应宽度
            	 i++;
            }
            out = new FileOutputStream(fileDir);  
            workbook.write(out);  
        } catch (Exception e) {  
            throw e;
        } finally {    
            try {    
                out.close();    
            } catch (IOException e) {    
                e.printStackTrace();  
            }    
        }    
    }  
}
