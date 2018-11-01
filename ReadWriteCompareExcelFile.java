package automationSepPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadWriteCompareExcelFile
{

	static HSSFWorkbook wB1;

	public static void main(String[] args) throws Exception 
	{
	
		try
		{
			
		
		//MAKE USER DETAILS AND LOGIN AND UPDATD SHEET STATUS 
		//@Test
	   	
		File mySheet = new File("D:\\Test\\MultiUserExcelLoginStatusUpdate.xls");
      	FileInputStream inputed = new FileInputStream(mySheet);
						
		wB1 = new HSSFWorkbook(inputed);
		
		//To read particular sheet using  INDEX and NAME 
		HSSFSheet Sheet = wB1.getSheet("StatusColUpdate");
		
		//It will get total number of rows and Just print ROW COUNT  
		int rowcounty = Sheet.getLastRowNum();
		System.out.println("TOTAL ROWS OF SHEET =" +rowcounty );
		
		///COLUMN  COUNT & PRINT 
		int colcounty = Sheet.getRow(1).getLastCellNum();
		//System.out.println("TOTAL COLUMNS  OF SHEET =" +colcounty);
	
		
		String cellTitleUN = Sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.print( "     " +cellTitleUN+ "     ");
		
		String cellTitlePS = Sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.print("     "+cellTitlePS+"     ");
				
		String cellTitleST = Sheet.getRow(0).getCell(2).getStringCellValue();
		System.out.println("     "+cellTitleST+"     ");
		
		 for (int rowcounty1=0; rowcounty1<5; rowcounty1++ )
		 {
			HSSFRow row = Sheet.getRow(rowcounty1);

			for (int colcounty1=0; colcounty1 <5; colcounty1++ )
			{
				HSSFCell cell = row.createCell(colcounty1);
				
				String cellUName = Sheet.getRow(rowcounty1).createCell(colcounty1).getStringCellValue();
				System.out.print( "     " +cellUName+ "     ");
								
				String cellPass = Sheet.getRow(rowcounty1).getCell(colcounty1).getStringCellValue();
				System.out.print( "     " +cellPass+ "     ");
							
				//COMMENT UN COMMMENTS BASED OUTPUT WILL CHANGE
				//String cellStatus = Sheet.getRow(r).getCell(2).getStringCellValue();
				//System.out.println( "     " +cellStatus+ "     ");
											
				//HIT THE WEB BROWSER HERE 
				System.setProperty("webdriver.gecko.driver","D:\\Ajay\\geckoFF\\geckodriver.exe");
				WebDriver cDriver = new FirefoxDriver();
				
				cDriver.get("http://185.53.172.171/~littlestampco/");
				cDriver.manage().timeouts().implicitlyWait(30,java.util.concurrent.TimeUnit.SECONDS);
				cDriver.manage().window().maximize();
				Thread.sleep(4000);
								
				cDriver.findElement(By.xpath("//div[@class='panel header']//a[@title='Login'][contains(text(),'Login')]")).click();
				cDriver.findElement(By.id("email")).sendKeys(cellUName);
				cDriver.findElement(By.id("pass")).sendKeys(cellPass);
				cDriver.findElement(By.id("bnt-social-login-authentication")).click();
				Thread.sleep(10000);
				
							
				//Success Unsuccess message getting 
				WebElement TextValid = cDriver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
				
				//WebElement TextValid = cDriver.findElement(By.xpath("//*[@id=\"social-login-authentication\"]/div/div/div"));			
				String text = TextValid.getText();
				
				System.out.println("TESTING LOGIN OR NOT = "+text);
							
				//if(text.equals("Login Successful."))
				if(text.equals("Invalid login or password."))
				{
			
				    System.out.println("TESTING= "+text);
				  //  FileOutputStream FRes = new FileOutputStream(("D:\\Test\\MultiUserExcelLoginStatusUpdate.xls"));
				    Sheet.getRow(rowcounty1).createCell(2).setCellValue("PASS");
			
				    cDriver.findElement(By.xpath("//div[@class='panel header']//a[@title='Sign Out'][contains(text(),'Sign Out')]")).click();
				    Thread.sleep(10000);
				    
				    //Sheet.createRow(1).createCell(0).setCellValue("PASS");
				    
				}
				else
				{
				     //System.out.println( "TEST CASE FAILED") ;
				     Sheet.getRow(rowcounty1).createCell(2).setCellValue(" FAIL");
				     FileOutputStream FRes = new FileOutputStream(("D:\\Test\\MultiUserExcelLoginStatusUpdate.xls"));
				     cDriver.findElement(By.xpath("//div[@class='panel header']//a[@title='Sign Out'][contains(text(),'Sign Out')]")).click();
					 Thread.sleep(10000);
					   
				     
				}
				
				System.out.println("Getting Test ="+text);	
				
		  }
		 }
		}
		catch(Exception e)
		{
  
			System.out.println(e);
             			
		}
		 		 
		
			FileOutputStream FRes = new FileOutputStream(("D:\\Test\\MultiUserExcelLoginStatusUpdate.xls"));
			wB1.write(FRes);
			FRes.close();
					
			System.out.println(" UPDATED SUCCESSFULLY ");
			
	}
											 
}
