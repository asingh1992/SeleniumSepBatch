package testngdemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginOrangeHRM 
{
	WebDriver driver;
	@Parameters({"BrowserType","ApplicationURL"})
	@Test
	public void login(String browser,String appURL)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("We only support Chrome and Edge Browsers");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
