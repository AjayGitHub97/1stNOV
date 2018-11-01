package automationSepPackage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstScript {

	@Test
	public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.gecko.driver","D:\\Ajay\\geckoFF\\geckodriver.exe");
			WebDriver cDriver = new FirefoxDriver();
			
			cDriver.get("http://185.53.172.171/~littlestampco/");
			cDriver.manage().timeouts().implicitlyWait(30,java.util.concurrent.TimeUnit.SECONDS);
			cDriver.manage().window().maximize();
			Thread.sleep(4000);
									
		
			//Valid User name passWord 
			
			
			cDriver.findElement(By.xpath("//div[@class='panel header']//a[@title='Login'][contains(text(),'Login')]")).click();
			cDriver.findElement(By.id("email")).sendKeys("ajay.g.vaghode@doyenhub.com");
			cDriver.findElement(By.id("pass")).sendKeys("Ajay@123");
			cDriver.findElement(By.id("bnt-social-login-authentication")).click();
			Thread.sleep(4000);
			cDriver.findElement(By.xpath("//div[@class='panel header']//a[@title='Sign Out'][contains(text(),'Sign Out')]")).click();
			Thread.sleep(10000);
			
				
			//Valid User name passWord but Wrong Password 
			cDriver.findElement(By.xpath("//div[@class='panel header']//a[@title='Login'][contains(text(),'Login')]")).click();
			cDriver.findElement(By.id("email")).sendKeys("ajay.g.vaghode@doyenhub.com");
			cDriver.findElement(By.id("pass")).sendKeys("Ajay@123123");
			cDriver.findElement(By.id("bnt-social-login-authentication")).click();
			Thread.sleep(10000);
		
			//invalid login error mesage get
			WebElement TextValid = cDriver.findElement(By.xpath("//*[@id=\"social-login-authentication\"]/div/div/div"));			
			String text = TextValid.getText();
			
			
			
			if(text.equals("Invalid login or password."))
			{
			    System.out.println(TextValid.getText());
			}
			else
			{ 
			     System.out.println( "TEST CASE FAILED") ;
			}
			
			cDriver.close();
				
			System.out.println("VALIDATION MESSAGE IS  ="+text);
			
	}

	
}
