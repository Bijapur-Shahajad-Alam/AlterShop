package alterShopPageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import jdk.internal.org.jline.utils.Log;

public class AlterShopHomePage {

	public static WebDriver driver;

	public AlterShopHomePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);

	}



	@FindBy (xpath="//button[@data-testid='categoryButton']")
	WebElement drp_AllCategory1;

	@FindBy (xpath="//input[@id='auto-suggestion-search']")
	WebElement Search2;

	@FindBy(xpath="(//div[text()='Body'])[1]")
	WebElement Body3;


	@FindBy(xpath="//span[text()='Watch for TEST']")
	WebElement txt_Asset4;

	@FindBy (xpath="//span[text()='Categories']")
	WebElement categories5;

	@FindBy(xpath="(//div[@data-testid='typeLabel'])[2]")
	WebElement Asset6;

	@FindBy(xpath="(//span[text()='Mallikarjun M G'])[1]")
	WebElement creator_Name7;

	@FindBy(xpath="//span[text()='Connect']")
	WebElement Connect8;

	@FindBy(xpath="(//span[text()='Dive in with'])[1]")
	WebElement Dive_inGoogle9;

	@FindBy (xpath="//input[@id='identifierId']")
	WebElement email10;

	@FindBy (xpath="//span[text()='Next']")
	WebElement next11;

	@FindBy (xpath="//input[@type='password']")
	WebElement password12;

	//create corresponding actions for each and every element

	public void searchfunctionality() throws InterruptedException {
		Search2.sendKeys("Watch");
		Thread.sleep(3000);
		Body3.click();


	}

	public void AssetDetailsFunctionality() throws InterruptedException {

		Actions ac=new Actions(driver);

		ac.moveToElement(categories5).build().perform();

		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", Body3);
		//btn_Body.click();

		Thread.sleep(4000);

		Asset6.click();   

		Thread.sleep(4000);




	}

	public void CreateProfileFunctionality() throws InterruptedException {

		Connect8.click();

		Thread.sleep(5000);

		Set<String>Windows=driver.getWindowHandles();

		//convert set to List

		List<String>windowids=new ArrayList(Windows);

		String window1=windowids.get(0);
		String window2=windowids.get(1);

		driver.switchTo().window(window2);
		Thread.sleep(4000);

		Dive_inGoogle9.click();

		Set<String>Window=driver.getWindowHandles();

		//convert set to List

		List<String>windowid=new ArrayList(Window);

		String window11=windowid.get(0);
		String window12=windowid.get(1);
		String window13=windowid.get(2);

		driver.switchTo().window(window13);

		driver.manage().window().maximize();
		Thread.sleep(3000);

		email10.sendKeys("alamtesting4257@gmail.com");
		next11.click();
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("arguments[0].setAttribute('value','Sh@786sha')", password12);
		






	}








}
