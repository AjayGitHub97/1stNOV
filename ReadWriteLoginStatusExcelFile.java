package automationSepPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadWriteLoginStatusExcelFile {

	private static HSSFWorkbook wB;

		//@Test
	    public static void main(String[] args) throws Exception {
	
		File mySheet = new File("D:\\Test\\MultiUserLoginUpdateStatus.xls");
		        
		FileInputStream inputed = new FileInputStream(mySheet);
						
		wB = new HSSFWorkbook(inputed);
		
		//To read particular sheet using  INDEX and NAME 
		HSSFSheet Sheet = wB.getSheet("StatusUpdate");
		
		//It will get total number of rows and Just print ROW COUNT  
		int rowcounty = Sheet.getLastRowNum();
		System.out.println("TOTAL ROWS OF SHEET =" +rowcounty );
		
		///COLUMN  COUNT & PRINT 
		//int colcounty = Sheet.getRow(1).getLastCellNum();
		//System.out.println("TOTAL COLUMNS  OF SHEET =" +colcounty);
	
		
		String tabData1 = Sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.print( "     " +tabData1+ "     ");
		
		String tabData2 = Sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.print("     "+tabData2+"     ");
				
		String tabData3 = Sheet.getRow(0).getCell(2).getStringCellValue();
		System.out.println("     "+tabData3+"     ");
		
		
		for(int r=1; r<rowcounty; r++)		
		{			
				String tabData21 = Sheet.getRow(r).getCell(0).getStringCellValue();
				System.out.print( "     " +tabData21+ "     ");
								
				String tabData22 = Sheet.getRow(r).getCell(1).getStringCellValue();
				System.out.print( "     " +tabData22+ "     ");
							
				
				//COMMENT UN COMMMENTS BASED OUTPUT WILL CHANGE
				String tabData23 = Sheet.getRow(r).getCell(2).getStringCellValue();
				System.out.println( "     " +tabData23+ "     ");
				
											
			//COmpare the valid user name and Password STATUS    			
				if(tabData21.equals("ajay.g.vaghode@doyenhub.com") && tabData22.equals("Ajay@123"))
				{
					
					//IF USERNAME AND PASSWORD LOGIN then STATUS COLUMN UPDATED/Write PASS/FAIL
					 Sheet.getRow(r).createCell(2).setCellValue("PASS");
					//String tabData31 = Sheet.getRow(i).getCell(2).getStringCellValue();
					//Sheet.getRow(i).createCell(2).setCellValue("PASS");
																					
				}
				else
				{
				Sheet.getRow(r).createCell(2).setCellValue(" FAIL");
					//System.out.println("FAIL"); 
									
				}
				
				
				FileOutputStream FRes = new FileOutputStream(mySheet);
				wB.write(FRes);
				FRes.close();
								
		}

		

		System.out.println("SUCCESS FULLY UPDATED");
    	 //wB.close();
	
	}
		
}
