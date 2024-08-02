package AlterShop_Testcases;

import org.testng.annotations.Test;

import alterShopPageObjects.AlterShopHomePage;

public class TC_001_Altershop_SearchFunctionality extends BaseClass {

	
	@Test
	public void SearchTest() throws InterruptedException {
		
		AlterShopHomePage asp=new AlterShopHomePage(driver);
		asp.searchfunctionality();
		log.info("Search Functionality successfully completed");
		
	}
}
