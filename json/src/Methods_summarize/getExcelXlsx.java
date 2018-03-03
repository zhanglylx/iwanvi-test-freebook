package Methods_summarize;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jir.JirPath;
public class getExcelXlsx {
	public String[] Key;
	public String[] Values;
	/**
	 * @author ZhangLianYu 2017/07/27
	 * @since 以下方法为获取到指定Excel中的第一行所有列和最后一行所有列的数据 第一行列的数据赋值给Key 第二行列的数据赋值给Values
	 *        代码中获取第一行数据不能为空
	 * 
	 */
	public getExcelXlsx() {
		// jxl.Workbook readColumnwb = null;
		try {
			InputStream is = new FileInputStream(JirPath.ExcelBugPath);
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			// 获取每一个工作薄
			// for (int numSheet = 0; numSheet <
			// xssfWorkbook.getNumberOfSheets(); numSheet++) {
			// XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			// if (xssfSheet == null) {
			// continue;
			// }
			// 获取当前工作薄的每一行
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
			int Column = xssfSheet.getRow(0).getPhysicalNumberOfCells();// 获取所有的列
			int row = xssfSheet.getLastRowNum(); // 获取所有的行
			Key = new String[Column];
			Values = new String[Column];
			// 暂时插入第一行key和最后一行values
			for (int rowNum = 0; rowNum < Column; rowNum++) {
				// 指定访问第一行的内容
				XSSFRow xssfColumn = xssfSheet.getRow(0);
				// 获取第一行的key
				XSSFCell keyRow = xssfColumn.getCell(rowNum);
				if (keyRow == null) {
					Key[rowNum] = "";
				} else {
					keyRow.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);// 将小数转换成整数
					Key[rowNum] = (keyRow).toString();
				}
				XSSFRow end = xssfSheet.getRow(row);
				XSSFCell valuesEnd = end.getCell(rowNum);
				if (valuesEnd == null) {
					Values[rowNum] = "";
				} else {
					valuesEnd.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);// 将小数转换成整数
					Values[rowNum] = (valuesEnd).toString();// 获取到最后一行的内容分配给Values
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} // finally {
			// readwb.close();
			// }

	}
}
