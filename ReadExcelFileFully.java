package automationSepPackage;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcelFileFully {
	
	

	public static void main(String[] args) throws Exception {
		
		
		//READ  ALREADY EXIST FILE XLS FULLY  with PROPER TABLE FORMAT 
		
		File mySheet = new File("D:\\Test\\MultiUserLogin.xls");
		        
		FileInputStream inputed = new FileInputStream(mySheet);
						
		HSSFWorkbook WB = new HSSFWorkbook(inputed);
		
		//To read particular sheet using  INDEX and NAME 
		//HSSFSheet Sheet = WB.getSheetAt(0);
		HSSFSheet Sheet = WB.getSheet("Sheet1");
	 
		//It will get total number of rows and Just print ROW COUNT  
		int rowcount = Sheet.getLastRowNum();
		System.out.println("TOTAL ROWS OF SHEET =" +rowcount );
					
		
		for(int i=0; i<=rowcount; i++)
		{
					
			String tabData1 = Sheet.getRow(i).getCell(0).getStringCellValue();
			//System.out.print("USERNAME = " +i  +tabData1);
			System.out.print( +i+"  " +tabData1+ "   ");
			
			String tabData2 = Sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.print(""+tabData2+"");
			
			String tabData3 = Sheet.getRow(i).getCell(2).getStringCellValue();
			System.out.println("     "+tabData3+"");
		
			
		}
		
		WB.close();
	}

}
