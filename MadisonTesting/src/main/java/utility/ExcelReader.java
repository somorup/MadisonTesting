package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	Workbook ecomStoreWorkbook;
	Sheet loginData;

	public ExcelReader(String excelfilePath) {
		try {
			File s = new File(excelfilePath);
			FileInputStream stream = new FileInputStream(s);
			ecomStoreWorkbook = new XSSFWorkbook(stream);
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
	}

	public Object[][] getDataUsingMap(String sheetName) {

		loginData = ecomStoreWorkbook.getSheet(sheetName);
		int rowCount = loginData.getLastRowNum();
		int colCount = loginData.getRow(0).getLastCellNum();

		Object[][] obj = new Object[rowCount][1];

		for (int row = 0; row < rowCount; row++) {
			Map<Object, Object> dataMap = new HashMap<Object, Object>();
			for (int col = 0; col < colCount; col++) {
				dataMap.put(loginData.getRow(0).getCell(col).toString(),
						loginData.getRow(row + 1).getCell(col).toString());

			}
			obj[row][0] = dataMap;
		}

		return obj;

	}
}
