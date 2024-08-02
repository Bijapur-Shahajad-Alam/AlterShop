package AlterShop_Testcases;

import org.testng.annotations.Test;

import alterShopPageObjects.AlterShopHomePage;

public class TC_003_Altershop_CreateProfile extends BaseClass {

	@Test
	public void CreateProfileTest() throws InterruptedException {
		
		AlterShopHomePage asp=new AlterShopHomePage(driver);
		asp.CreateProfileFunctionality();
		log.info("profile creation complted");
	}
}
