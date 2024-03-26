package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageLocationPage;
public class ManageLocationPageTest extends BaseClass {
	 LoginPage lp;
	 HomePage hp;
	 ManageLocationPage ml;
	  @Test
	  public void verifyLoginWithValidDataMangeLocation() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  ml=new ManageLocationPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected,Constant.lp_verifyLoginWithInvalidData);
		  ml.manageLocationPageClick();
		  ml.manageLocationPagenew();
		  ml.sendCountry();
		  ml.sendState();
		  ml.sendLocation("London");
		  String location=ml.getRandomlyLocationName();
		  ml.sendDeliveryCharge("100");
		  ml.clickSaveButton();
		  ml.manageLocationPageClick();
		 String locationexpected=ml.readManageLocationPageElementText(1, 1);
		 Assert.assertEquals(location, locationexpected,Constant.lp_verifyLoginWithInvalidData);
		 }
	  
	}
