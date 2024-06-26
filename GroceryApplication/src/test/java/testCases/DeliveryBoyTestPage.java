package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddSliderPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.DeliveryBoyPage;

public class DeliveryBoyTestPage extends BaseClass {
	LoginPage lp;
	 HomePage hp;
	 AddSliderPage as;
	 DeliveryBoyPage dp;
	 @Test
	  public void verifyAdminUserDeliveryBoyFirstStatus() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  dp=new DeliveryBoyPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
		  dp.deliveryBoyClick();
		  dp.deliveryBoyNewClick();
		  dp.deliveryBoyNameClick();
		  dp.deliveryBoyUserNameClick("Mary");
		  dp.deliveryBoyPassClick();
		  dp.deliveryBoySaveClick();
		  dp.deliveryBoyClick();
		  dp.deliveryBoyPasswordClick();
		  String password="Password : Jithin@123";
		  String passwordexpected=dp.readdeliveryBoyPasswordShowText(2,1);
		  Assert.assertEquals(password, passwordexpected,Constant.lp_verifyLoginWithInvalidData);
	  }
	 @Test
	  public void verifyAdminUserDeliveryBoySecondStatus() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  dp=new DeliveryBoyPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
		  dp.deliveryBoyClick();
		  dp.deliveryBoyPasswordClick();
		  dp.deliveryBoyPasswordClick();
		  String password="";
		  String passwordexpected=dp.readdeliveryBoyPasswordShowText(2,1);
		  Assert.assertEquals(password, passwordexpected,Constant.lp_verifyLoginWithInvalidData);
	  }
}
