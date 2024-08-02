package AlterShop_Testcases;

import org.testng.annotations.Test;

import alterShopPageObjects.AlterShopHomePage;

public class TC_002_Altershop_AssetDeatils extends BaseClass {
	
	@Test
	public void AssetDeatilsTest() throws InterruptedException {
		
		AlterShopHomePage asp=new AlterShopHomePage(driver);
		asp.AssetDetailsFunctionality();
		log.info("AssetDetails Page opened");
		
		
	}

}
