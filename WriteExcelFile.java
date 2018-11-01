package automationSepPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcelFile {

	private static HSSFWorkbook wB;

	public static void main(String[] args) throws Exception {
		
		
		//WRITE ALREADY EXIST FILE XLS AT FIX POSITION
		
		File mySheet = new File("D:\\Test\\BlankSheet.xls");
		        
		FileInputStream inputed = new FileInputStream(mySheet);
		wB = new HSSFWorkbook(inputed);
		
		//To read particular sheet using  INDEX and NAME 
		//HSSFSheet Sheet = WB.getSheetAt(0);
		HSSFSheet Sheet = wB.getSheet("EmptySheet");
		
	 //Created 5 Rows & 5 columns data table using java  
	 
//	    Sheet.createRow(0).createCell(0).setCellValue("USERNAME");
//		    Sheet.createRow(1).createCell(0).setCellValue("ajay@gmail.com");
    
//		Sheet.createRow(1).createCell(0).setCellValue("PASSWORD");
//		    Sheet.createRow(2).createCell(1).setCellValue("ajay@123");

//		Sheet.createRow(0).createCell(2).setCellValue("MOBILE");
//			Sheet.createRow(1).createCell(2).setCellValue("8905252321");
				
//		Sheet.createRow(0).createCell(3).setCellValue("STATUS");
//			Sheet.createRow(1).createCell(3).setCellValue("Single");
	
		
		//Created array of data 
		Object[][] bookData = {
                {"LIFE FOR DREAM", "AJAY VAGHODE", 28},
                {" EFFECT JAVA ", "RIZWAN KHAN", 30},
                {"CLEAN CODE", " PRAJESH JANI", 32},
                {"THINKING JAVA ", "BRUCELNINA PETER", 34},
		};
		
        int rowCount = 0;
        
        for (Object[] aBook : bookData)
        {
            HSSFRow row = Sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (Object field : aBook) 
            {
            	   HSSFCell cell = row.createCell(++columnCount);
	                if (field instanceof String) {
	                    cell.setCellValue((String) field);
                }
	            else if (field instanceof Integer)
	            {
                    cell.setCellValue((Integer) field);
                }
             }
             
        } 
			
		//To write in  xls file 
		FileOutputStream FRes = new FileOutputStream(mySheet);
		wB.write(FRes);
		FRes.close();
		System.out.println(" Your New XLS file created with 5X5 successfully ");
	}

	
}


