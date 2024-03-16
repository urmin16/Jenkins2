package Utilities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	
	WebDriver driver;
  
	@Parameters({"browser","URL"})
 
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }
  public  void browser(String browsername, String url) throws InterruptedException {
		
		//String ud=System.getProperty("usr.dir");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(4000);
			driver.get(url);
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
		    driver=new EdgeDriver();
			driver.manage().window().maximize();
			Thread.sleep(4000);
			driver.get(url);
			
		}
}

}
