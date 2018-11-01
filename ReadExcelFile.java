package automationSepPackage;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws Exception {
		
		//READ ALREADY EXIST FILE PARTICULAR DATA OF  XLS
	
		
		File mySheet = new File("D:\\Test\\MultiUser.xls");
		        
		FileInputStream inputed = new FileInputStream(mySheet);
						
		HSSFWorkbook WB = new HSSFWorkbook(inputed);
		
		//To read particular sheet 
		//HSSFSheet Sheet = WB.getSheetAt(0);
		HSSFSheet Sheet = WB.getSheet("UserSheet1");
		
		String firstdata =Sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(firstdata);
			
		String secondData =Sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(secondData);
		
		
		String thirdData =Sheet.getRow(2).getCell(0).getStringCellValue();
		System.out.println(thirdData);
			
		String fourthData =Sheet.getRow(3).getCell(0).getStringCellValue();
		System.out.println(fourthData);
		
		//2nd COlumn data read 
		String col2 =Sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(col2);
		
		String col3 =Sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(col3);
		
		String col4 =Sheet.getRow(2).getCell(1).getStringCellValue();
		System.out.println(col4);
		
		String col5 =Sheet.getRow(3).getCell(1).getStringCellValue();
		System.out.println(col5);
		
		WB.close();
	}

}
