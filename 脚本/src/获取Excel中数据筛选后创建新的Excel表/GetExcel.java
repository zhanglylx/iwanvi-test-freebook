package 获取Excel中数据筛选后创建新的Excel表;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Cell;

public class GetExcel {
	// excel中的所有行
	private int row;
	// excel中的所有列
	private int column;
	// excel中的标题
	private String[] headline;
	// 文件路径
	private String filePath;
	// 用于判断当前文件格式
	private boolean booleanExcelXls;
	// 用于类中对象的实例化
	private XSSFSheet xssfSheet;
	private HSSFSheet hssfSheet;
	private HSSFRow hssfRow = null;
	private XSSFRow xssfRow = null;

	/**
	 * 构造Excel中的所有行，列和标题
	 * 
	 * @param filePath
	 *            文件所在路径
	 * @param sheet
	 *            文件在第几个表，从0开始计数
	 * @throws IOException
	 */
	public GetExcel(String filePath, int sheet) throws IOException {
		// 将文件路径赋值给filePath
		this.filePath = filePath;
		if (createExcel.fileExist(filePath) == false) {
			System.out.println("获取的文件不存在:" + filePath);
			System.exit(0);
		}
		InputStream is = new FileInputStream(filePath);
		if (filePath.matches("^.+(\\.xls)$")) {
			// 将值赋值给对象booleanExcelXls
			this.booleanExcelXls = true;
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
			hssfSheet = hssfWorkbook.getSheetAt(sheet);
			// 获取所有的列，将值赋给column
			this.column = hssfSheet.getRow(0).getPhysicalNumberOfCells();
			// 获取所有的行，将值赋给row
			this.row = hssfSheet.getLastRowNum();

		} else {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			xssfSheet = xssfWorkbook.getSheetAt(sheet);
			// 获取所有的列，赋值给对象column
			this.column = xssfSheet.getRow(0).getPhysicalNumberOfCells();
			// 获取所有的行，赋值给对象row
			this.row = xssfSheet.getLastRowNum();
		}

		getExcelRowAndColumn();
	}

	/**
	 * 获取Excel的标题
	 * 
	 * @throws IOException
	 */
	private void getExcelRowAndColumn() throws IOException {
		// 获取行内容
		if (booleanExcelXls) {
			hssfRow = hssfSheet.getRow(0);
		} else {
			xssfRow = xssfSheet.getRow(0);
		}
		headline = new String[this.column];
		for (int i = 0; i < column; i++) {
			// 获取指定列内容
			if (booleanExcelXls) {
				HSSFCell one = hssfRow.getCell(i);
				one.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
				setExcelTitle(one.toString(), i);
			} else {
				XSSFCell one = xssfRow.getCell(i);
				one.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
				setExcelTitle(one.toString(), i);
			}

		}
	}

	/**
	 * 给headline对象赋值
	 * 
	 * @param one
	 *            每一列的标题
	 * @param i
	 *            当前是第几列
	 */
	private void setExcelTitle(String one, int i) {
		if (one.toString().equals(null)) {
			this.headline[i] = "未知错误自动生成列标题" + Integer.toString(i);
		} else {
			if ("".equals(one.toString().trim())) {
				this.headline[i] = ("\n");
			} else {
				this.headline[i] = one.toString();
			}
		}
	}

	/**
	 * 获取所有Excel标题正文中的内容
	 * 
	 * @return 返回所有内容listi(list)
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public ArrayList<ArrayList<String>> getExceldata() throws IOException, InterruptedException {
		return getExceldata(1, this.row, 0, this.column);
	}

	/**
	 * 获取指定行到列的内容 参数包含头和包尾
	 * 
	 * @param rowStart
	 * @param rowEnd
	 * @param columnStart
	 * @param columnEnd
	 * @return 返回list(list)
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public ArrayList<ArrayList<String>> getExceldata(int rowStart, int rowEnd, int columnStart, int columnEnd)
			throws IOException, InterruptedException {
		// 判断给定的参数是否合法
		if (rowStart > rowEnd || columnStart > columnEnd || rowEnd > this.row || columnEnd > this.column) {
			System.out.println("getExceldata提示:给定的行或列不正确，不能执行操作");
			System.exit(0);
		}
		if (rowStart < 0 || rowEnd < 0 || columnStart < 0 || columnEnd < 0) {
			System.out.println("getExceldata提示:给定的行或列为负数，不能执行操作");
			System.exit(0);
		}
		// 创建list存放数据
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		// 创建lt，存放单次循环的数据
		for (int n = rowStart; n <= rowEnd; n++) {
			// 指定行
			if (booleanExcelXls) {
				hssfRow = hssfSheet.getRow(n);
			} else {
				xssfRow = xssfSheet.getRow(n);
			}
			ArrayList<String> lt = new ArrayList<String>();
			for (int i = columnStart; i <= columnEnd; i++) {
				// 获取指定列内容
				if (booleanExcelXls) {
					HSSFCell one = hssfRow.getCell(i);
					if (null == one) {
						lt.add(("\n"));
						continue;
					}
					one.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
					lt.add(list(one.toString(), i));
				} else {
					XSSFCell one = xssfRow.getCell(i);
					if (null == one) {
						lt.add(("\n"));
						continue;
					}
					one.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
					lt.add(list(one.toString(), i));
				}
			}
			list.add(lt);
		}
		return list;
	}

	// 创建单次list
	private String list(String one, int i) {
		// 将单次数据存放到lt中
		if (one.toString().equals(null)) {
			return ("未知错误自动生成内容" + Integer.toString(i));
		} else {
			if ("".equals(one.toString().trim())) {
				return ("\n");
			} else {
				return (one.toString());
			}
		}
	}
	
	

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public String[] getHeadline() {
		return headline;
	}

	public String getFilePath() {
		return filePath;
	}

}
