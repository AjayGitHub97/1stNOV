package automationSepPackage;

import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	@Test
	public  void dargdrop() throws InterruptedException {
						
			System.setProperty("webdriver.gecko.driver","D:\\Ajay\\geckoFF\\geckodriver.exe");
			WebDriver DargDropDriver = new FirefoxDriver();
			
			DargDropDriver.get("http://185.53.172.171/~littlestampco/");
			Thread.sleep(1000);

			Actions action = new Actions(DargDropDriver);
		     Thread.sleep(1000);
		     
		     //Hover on CUSTOM STAMPS menu 
		     action.moveToElement(DargDropDriver.findElement(By.linkText("Custom Stamps"))).perform();
		     Thread.sleep(2000);
		     
		     //CLICK on menu 
		     DargDropDriver.findElement(By.linkText("Custom Stamps")).click();
		     Thread.sleep(2000);
		     
		     //MAXIMIZE the window screen fully
		     DargDropDriver.manage().window().maximize();
		     Thread.sleep(2000);
		     
		     //Page Scroll TOP to BOTTOM 300px only
		     JavascriptExecutor js = (JavascriptExecutor) DargDropDriver;  
		     js.executeScript("window.scrollBy(0,300)");
		     		     
		   //This will scroll the web page till end.		
		   //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		    
		     //This will scroll the web page horizontal 
		    // js.executeScript("arguments[0].scrollIntoView();",Element );
		     

		     String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
		     DargDropDriver.findElement(By.xpath("//ol[@class='products list items product-items']//li[2]//div[1]//div[3]//div[1]//div[1]//div[1]//form[1]//a[1]")).sendKeys(selectLinkOpeninNewTab);
		     
		    // DargDropDriver.findElement(By.xpath("//ol[@class='products list items product-items']//li[2]//div[1]//div[3]//div[1]//div[1]//div[1]//form[1]//a[1]")).click();
            Thread.sleep(6000);
		    
		        
//		     //Element which needs to drag.    		
//	          WebElement From=DargDropDriver.findElement(By.xpath("//*[@id='credit2']/a"));	
//	         
//	         //Element on which need to drop.		
//	          WebElement To=DargDropDriver.findElement(By.xpath("//*[@id='bank']/li"));					
//	         		
//	         //Using Action class for drag and drop.		
//	          Actions act=new Actions(DargDropDriver);					
//
//		    //Dragged and dropped.		
//	         act.dragAndDrop(From, To).build().perform();		
//		             
		     	     
	}

}
