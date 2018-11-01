package automationSepPackage;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteNewExcelFile {

	private static HSSFWorkbook nWB;

	public static void main(String[] args) throws Exception {
				
		// CREATE NEW XLS FILE AND  ENTER DATA 5 ROWS & 5 COLUMNS INTO SHEET USING JAVA  
		
		try 
		{
		
		 nWB = new HSSFWorkbook();
		
		 //Name to sheet name 
		 HSSFSheet Sheet=nWB.createSheet("AJAY");
				 
		 for (int rowcount1=0; rowcount1<5; rowcount1++ )
		 {
				HSSFRow row = Sheet.createRow(rowcount1);

				//iterating c number of columns
				for (int colcount1=0; colcount1 <5; colcount1++ )
				{
					HSSFCell cell = row.createCell(colcount1);
		
					cell.setCellValue("AJAY "+rowcount1+" "+colcount1);
				} 
	      }
		 		 
		 //Store the created excel sheet at location 
		 FileOutputStream creatFile = new FileOutputStream(new File("D:\\Test\\MultiUserLogin123.xls"));
		
		 //Created workbook with sheet name 
		 nWB.write(creatFile);
 		 creatFile.close();
		}
		
		catch(Exception e)
		{
  
			System.out.println(e);
             			
		}
		
		System.out.println(" Your New XLS file created with 5X5 successfully ");
		
	}
	
}
