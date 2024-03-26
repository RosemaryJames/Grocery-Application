package testCases;




import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LogOutPage;
import elementRepository.LoginPage;


public class LogOutTestPage extends BaseClass{
  
	  LoginPage lp;
		 HomePage hp;
		 LogOutPage lo;
		 
		  @Test(groups="SmokeTest")
		  public void verifyLoginOutWithValidData() {
			  lp=new LoginPage(driver);
			  hp=new HomePage(driver);
			  lo=new LogOutPage(driver);
			  lp.sendUserName("admin");
			  lp.sendPassWord("admin");
			  lp.clickOnSignINButton();
			  String expected="Admin";
			  String actual=hp.verifyhomePage();
			  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
			  lo.AdminClick();
			  lo.LogOutClick();
			  String Userexpected=lo.readLogOutPageText();
			  Assert.assertNull(null, Userexpected);
	}
  }

