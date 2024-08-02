package AlterShop_Testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {
	
	//open browser,open application,screenshots,log file genration,close application
	public static WebDriver driver;
	public Logger log;
	@BeforeClass
	public void openApplication() {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://betashop.alter.game/");
		driver.manage().window().maximize();
		
		log=Logger.getLogger(this.getClass());
		PropertyConfigurator.configure("log4j.properties");
		
		
	}
	
	@AfterClass     
	public void closeApplication() {
		
		driver.quit();
	}
	
	public String captureScreen(String name)  {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ss=(TakesScreenshot) driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		String destination= "./Screenshots/"+name+timeStamp+".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}

}
