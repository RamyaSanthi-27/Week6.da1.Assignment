package week6.day1.ServiceAssignment;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceNowData {
	
public static String[][] readData(String fileName) throws IOException {
		
		//Set up the Path
				XSSFWorkbook wb = new XSSFWorkbook("Data/"+fileName+".xlsx");
				//Get in to the WorkSheet
		        XSSFSheet ws = wb.getSheet("Sheet1"); //Sheet Name ctrl +2
		       // XSSFSheet ws = wb.getSheet(0);// Using Index
		        //Get into the Row
		        XSSFRow row = ws.getRow(0);  // Row ctrl+2
		       //Get into Column
		        XSSFCell cell = row.getCell(0);
		        //Read the Data
		        String stringCellValue = cell.getStringCellValue();
		        System.out.println(stringCellValue); 
		        
		        //Row Count
		        int lastRowNum = ws.getLastRowNum();
		        //Column Count
		        short lastCellNum = row.getLastCellNum();
		        //pass the data
		        String[][] data=new String[lastRowNum][lastCellNum];
		        
		        for (int i = 1; i <=lastRowNum ; i++) {
		        	XSSFRow Lrow = ws.getRow(i);
		        	
					for (int j = 0; j <lastCellNum ; j++) {							
						
						//get into cell
						XSSFCell cell2 = Lrow.getCell(j);
						
						String stringCellValue2 = cell2.getStringCellValue();
						data[i-1][j]=stringCellValue2;
						System.out.println(stringCellValue2);
						
					}
				}
					//close the file
		        wb.close();
		        return data;
				}

}
