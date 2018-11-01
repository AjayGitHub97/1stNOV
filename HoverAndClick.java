package automationSepPackage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverAndClick {

	@Test
	public  void hoverclick() throws InterruptedException {
						
			System.setProperty("webdriver.gecko.driver","D:\\Ajay\\geckoFF\\geckodriver.exe");
			WebDriver hoverClickDriver = new FirefoxDriver();
			
			hoverClickDriver.get("http://192.168.1.61/wordpress/doyenhub/");
						
			 Actions action = new Actions(hoverClickDriver);
		     Thread.sleep(1000);
		    
		     //HOME MENU mouse hover 
		     action.moveToElement(hoverClickDriver.findElement(By.linkText("Home"))).perform();
		     Thread.sleep(2000);
		     
		     //click on sub menu  ABOUT US
		     hoverClickDriver.findElement(By.linkText("About Us")).click();
		     Thread.sleep(2000);

	}

}
