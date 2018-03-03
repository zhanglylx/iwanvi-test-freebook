package Methods_summarize;

import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class getExcelXls {
	/**
	 * @author zhanglianyu
	 * @param Path
	 *            查找Excel的路径
	 * @param acquire
	 *            获取第一行数据请填写:获取标题，输入其他代表所有内容
	 * @param find
	 *            匹配第一行的列，如果查找到返回本列全部内容
	 */
	public static String[] ExcelNative(String Path, String acquire, String find) {

		jxl.Workbook readwb = null;
		String[] Excel = null;
		try {
			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			InputStream instream = new FileInputStream(Path);
			readwb = Workbook.getWorkbook(instream);
			// Sheet的下标是从0开始
			// 获取第一张Sheet表
			Sheet readsheet = readwb.getSheet(0);
			// 获取Sheet表中所包含的总列数
			int rsColumns = readsheet.getColumns();// 获取所有列
			int rsRows = readsheet.getRows();// 获取所有行
			// 如果rsColumns==0,代表Excel中没有任何数据
			if (rsColumns == 0) {
				System.out.println("没有找到Excel中的指定列" + find);
				Excel = new String[2];
				Excel[0] = find;
				Excel[1] = "";
				return Excel;
			}
			Excel = new String[rsColumns];
			for (int Columns = 0; Columns < rsColumns; Columns++) {// 获取list当前所在列
				if ("获取标题".equals(acquire)) {
					// 如果获取标题，那么获取第1行的所有数据
					Cell cell = readsheet.getCell(Columns, 0);
					Excel[Columns] = cell.getContents();
				} else {

					Cell cell = readsheet.getCell(Columns, 0); // 获取到引用的位置
					String str = cell.getContents();
					if (str.contains(find)) {// 模糊匹配list
						rsColumns = Columns;
						break;
					} else {// 没有获取指定列给默认值
						if (Columns == rsColumns - 1) {
							System.out.println("没有找到Excel中的指定列" + find);
							Excel = new String[2];
							Excel[0] = find;
							Excel[1] = "";
							return Excel;
						}
					}
				}
			}
			// 获取指定单元格的对象引用
			if ("获取标题".equals(acquire) == false) {
				Excel = new String[rsRows];// 创建数组，存入Excel数据
				for (int i = 0; i < rsRows; i++) {
					Cell cell = readsheet.getCell(rsColumns, i); // 获取到引用的位置
					Excel[i] = cell.getContents();
					if ("".equals(Excel[i])) {
						Excel[i] = "获取的表格没有内容";
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			readwb.close();
		}
		if (Excel == null) {
			System.out.println("获取Excel空了");
		}
		return Excel;
	}
}
