package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddSliderPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;

public class AddSliderTestPage extends BaseClass {
	LoginPage lp;
	 HomePage hp;
	 AddSliderPage as;
	 ManageSliderPage ms;
	  @Test
	  public void verifyLoginWithInValidDataFile() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  ms=new ManageSliderPage(driver);
		  as=new AddSliderPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected, "Msg not as expected");
		  ms.manageSliderPageClick();
		  as.manageSliderNewClick();
		  as.manageSliderFileClick();
		  as.manageSliderFileLinkClick();
		  as.manageSliderSaveClick();
		  ms.manageSliderPageClick();
		  String link="imagelink";
		  String linkexpected=as.readManageSliderText(1, 2);
		  Assert.assertNotEquals(link, linkexpected);
			 
}
	  @Test
	  public void verifyLoginWithValidDataFile() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  ms=new ManageSliderPage(driver);
		  as=new AddSliderPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected, "Msg not as expected");
		  ms.manageSliderPageClick();
		  as.manageSliderNewClick();
		  as.manageSliderValidFileClick();
		  as.manageSliderFileLinkValidClick();
		  as.manageSliderSaveClick();
		  ms.manageSliderPageClick();
		  String link="Capture";
		  String linkexpected=as.readManageSliderText(1, 2);
		  Assert.assertEquals(link, linkexpected,Constant.lp_verifyLoginWithInvalidData);
		
}
}
