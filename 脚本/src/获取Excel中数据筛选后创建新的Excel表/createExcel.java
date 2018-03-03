package 获取Excel中数据筛选后创建新的Excel表;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class createExcel {
	private static HSSFWorkbook workbook = null;
	/**
	 * 创建新的Excel
	 * @param filePathAndName  文件路径和名称
	 * @param title Excel中第一行的标题
	 * @param list Excel中的参数
	 * @param replaceExcelFile 是否替换存在的Excel
	 * @return 返回是否成功
	 * @throws Exception
	 */
	public static boolean create(String filePathAndName, String[] title, 
			ArrayList<ArrayList<String>> list,boolean replaceExcelFile)
			throws Exception {
		String regStr= "^.+(:\\\\).+(\\.xls)$";
		Pattern pattern = Pattern.compile(regStr);
		//匹配字符串，返回描述匹配结果的Matcher实例
		Matcher matcher = pattern.matcher(filePathAndName);
		if(matcher.find()==false){
			System.out.println("filePathAndName不正确");
			System.exit(0);
		}
		//检查创建的文件是否存在，存在将进行追加行
		if(fileExist(filePathAndName) && replaceExcelFile == false){
			ArrayList<ArrayList<String>> ls = ExistExcelData(filePathAndName);
			for(int i=0;i<ls.size();i++){
				list.add(i, ls.get(i));
			}
		}
		// 创建workbook
		workbook = new HSSFWorkbook();
		// 添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
		HSSFSheet sheet1 = workbook.createSheet("sheet");
		// 新建文件
		FileOutputStream out = null;
		try {
			HSSFCell cell;
			// 添加表头
			HSSFRow row = workbook.getSheet("sheet").createRow(0); // 创建第一行
			for (int i = 0; i < title.length; i++) {
				// 创建指定列
				cell = row.createCell(i);
				if (title[i].trim().equals("")) {
					cell.setCellValue("\n");
				} else {
					cell.setCellValue(title[i]);
				}
				
				sheet1.autoSizeColumn(i, true);// 自动适应宽度
			}
			//添加内容
			for (int i = 1; i < list.size(); i++) {
				row = workbook.getSheet("sheet").createRow(i);
				// 创建指定列
				if (list.get(i) == null) {
					continue;
				}
				ArrayList<String> ls = list.get(i - 1);

				for (int n = 0; n < ls.size(); n++) {
					cell = row.createCell(n);
					//判断元素中是否有违法格式
					if (ls.get(n).trim().equals("")) {
						cell.setCellValue("\n");
					} else {
						cell.setCellValue(ls.get(n).toString());
					}
					sheet1.autoSizeColumn(n, true);// 自动适应宽度
				}
			}
			out = new FileOutputStream(filePathAndName);
			workbook.write(out);
			//检查文件是否创建成功，并返回
			return fileExist(filePathAndName);
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
	//将存在的文件数据返回
	public static ArrayList<ArrayList<String>> ExistExcelData(String fileDir) throws IOException, InterruptedException{			
		GetExcel excel = new GetExcel(fileDir,0);
		return  excel.getExceldata();		
	}
  //检查文件是否存在
	public static boolean fileExist(String fileDir) {
		File file = new File(fileDir);
		return file.exists();
	}
}
