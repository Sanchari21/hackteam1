package com.hackathon.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {
	
	 public static void writeExcelData(String filePath, List<String> lstResult, List<String> lstFailure,
			    List<String> lstExecutionTime) {
			try {
			
				// Object of Execl file 
			    FileInputStream fsIP = new FileInputStream(new File(filePath));
		 
				// Object of workbook
			    XSSFWorkbook wb = new XSSFWorkbook(fsIP);
		 
				// Object of workbsheet
			    XSSFSheet worksheet = wb.getSheetAt(0);
		 
				// code for formatting of the Excel cell 
			    CellStyle style = wb.createCellStyle();
			    style.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
			    style.setWrapText(true);
		 
				//code to write the excel 
			    // Condition to clear the 'the Data column of Excel Report'
			    if (lstResult == null) {
				for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
				    XSSFRow row1 = worksheet.getRow(i);
		 
				    for (int j = 1; j <= 3; j++) {
					row1.createCell(j + 1);
					XSSFCell cell1 = worksheet.getRow(i).getCell(j + 1);
					cell1.setCellValue("");
					cell1.setCellStyle(style);
				    }
				}
			    } else {
				for (int i = 0; i < lstResult.size(); i++) {
				    XSSFRow row1 = worksheet.getRow(i + 1);
				    row1.createCell(2);
				    row1.createCell(3);
				    row1.createCell(4);
				    XSSFCell cell1 = worksheet.getRow(i + 1).getCell(2);
				    XSSFCell cell2 = worksheet.getRow(i + 1).getCell(3);
				    XSSFCell cell3 = worksheet.getRow(i + 1).getCell(4);
				    cell1.setCellValue(lstResult.get(i));
				    cell2.setCellValue(lstFailure.get(i));
				    cell3.setCellValue(lstExecutionTime.get(i));
				    cell1.setCellStyle(style);
				    cell2.setCellStyle(style);
				    cell3.setCellStyle(style);
				}
			    }
		 
				// Close the input file 
			    fsIP.close();
		 
				// Making new file 
			    FileOutputStream output_file = new FileOutputStream(new File(filePath));
			    wb.write(output_file);
				
				// Close the output file 
			    output_file.close();
			} catch (Exception ex) {
				// Exception Handling 
			    System.out.println("Exception occurred :-> " + ex.getMessage());
			    ex.printStackTrace();
			}
		    }

}
