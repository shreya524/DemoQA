package Assignment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BaseClass {

	public static WebDriver driver;
	
   
	public  WebDriver initializeDriver() throws IOException {
      

		String browserName = "chrome";

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/stars/Documents/Drivers/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless","window-size=1980,1080");
			driver = new ChromeDriver(chromeOptions);
			
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/stars/Documents/Drivers/geckodriver.exe");
//	/		driver = new FirefoxDriver();
			
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");
//			firefoxOptions.addArguments("window-size=1980,1080");
//		
			driver = new FirefoxDriver(firefoxOptions);
			
			
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.edge.driver", "C:/Users/stars/Documents/Drivers/MicrosoftEdge.exe");
			driver = new EdgeDriver();
		}
         
		 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;

	}
	
	
	
	public static String capture(String testName) {
		 TakesScreenshot ts = (TakesScreenshot) driver;
	     File source = ts.getScreenshotAs(OutputType.FILE);
	      
	     String dest = System.getProperty("user.dir")+"\\reports\\"+testName+".png";
	     File destination = new File(dest);
	     try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return dest;
	}




	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
