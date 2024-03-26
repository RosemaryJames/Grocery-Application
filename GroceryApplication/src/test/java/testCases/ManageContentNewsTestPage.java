package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContentNewsPage;


public class ManageContentNewsTestPage extends BaseClass {
	LoginPage lp;
	 HomePage hp;
	 ManageContentNewsPage mcn;
	  @Test
	  public void verifyLoginWithValidDataMangeLocation() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  mcn=new ManageContentNewsPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected,Constant.lp_verifyLoginWithInvalidData);
		  mcn.manageContentPageClick();
		  mcn.manageNewsPageClick();
		  String data="Rosemary";
		  mcn.manageNewsEditClick();
		  mcn.manageNewsEditText("Rosemary");
		  mcn.manageNewsUpdateClick();
		  String dataExpected=mcn.readManageNewsUpdateText();
		 Assert.assertEquals(data, dataExpected,Constant.lp_verifyLoginWithInvalidData);
	  }		
}
