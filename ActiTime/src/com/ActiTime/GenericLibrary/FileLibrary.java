package com.ActiTime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {

	public String readFromPropertyFile(String key) throws IOException {
		FileInputStream file=new FileInputStream("./TestData/CommonData.property");
		Properties P=new Properties();
		P.load(file);
		String value = P.getProperty(key);
		return value;
	}
		public String ReadDataFromExelFile(String sheetname,int row,int cell) throws IOException {
			FileInputStream file1=new FileInputStream("./TestData/AutomationTestData.xlsx");
			Workbook WB = WorkbookFactory.create(file1);
			String value=WB.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			return value;
		
	}
}
