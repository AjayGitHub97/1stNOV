package automationSepPackage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverEvent {

	@Test
	public  void mymouse() throws InterruptedException {
						
			System.setProperty("webdriver.gecko.driver","D:\\Ajay\\geckoFF\\geckodriver.exe");
			WebDriver hoverDriver = new FirefoxDriver();
			
			hoverDriver.get("http://192.168.1.61/wordpress/doyenhub/");
			
			 Actions action = new Actions(hoverDriver);
		     Thread.sleep(1000);
		     action.moveToElement(hoverDriver.findElement(By.cssSelector("#wp-megamenu-item-39 > a:nth-child(1)"))).perform();
		     Thread.sleep(2000);
		     
		     new Actions(hoverDriver);
		     action.moveToElement(hoverDriver.findElement(By.cssSelector("#wp-megamenu-item-41 > a:nth-child(1)"))).perform();
		     Thread.sleep(2000);
		          
		     new Actions(hoverDriver);
		     action.moveToElement(hoverDriver.findElement(By.cssSelector("#wp-megamenu-item-43 > a:nth-child(1)"))).perform();
		     Thread.sleep(2000);
		     
		     new Actions(hoverDriver);
		     action.moveToElement(hoverDriver.findElement(By.cssSelector("#wp-megamenu-item-45 > a:nth-child(1)"))).perform();
		     Thread.sleep(2000);
		     
		     new Actions(hoverDriver);
		     action.moveToElement(hoverDriver.findElement(By.cssSelector("#wp-megamenu-item-172 > a:nth-child(1)"))).perform();
		     Thread.sleep(2000);
		     
	
	}
	
}
