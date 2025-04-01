
package com.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class LoginData {
	@DataProvider(name = "LoginCredentials")
	public Object[][] LoginDatafun() throws Exception{
		Object[][] arrobj = getExcelData("D:\\Selenium_Assessment_POM\\POMPractise\\LoginCredentials.xlsx","Sheet1");
		return arrobj ;
	}

	private Object[][] getExcelData(String filename, String sheetname) {
		Object[][] data= null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			XSSFRow row = sheet.getRow(0);
			
			int rowsize = sheet.getLastRowNum();
			int colsize = row.getLastCellNum();
			
			Cell cell ;
			
			data = new Object[rowsize][colsize];
			
			for(int i = 1 ; i <= rowsize ; i++) {
				for(int j = 0 ; j < colsize ; j++) {
					row = sheet.getRow(i);
					cell = row.getCell(j);
					if(cell != null) {
						switch(cell.getCellType()) {
						case STRING:
							data [i-1][j] = cell.getStringCellValue();
							break;
						case NUMERIC:
							data [i-1][j] = String.valueOf(cell.getNumericCellValue());
							break;
						default:
							data [i-1][j] = "";
								
						}
					}
					else {
						data [i-1][j]="";
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return data;
	}
}
