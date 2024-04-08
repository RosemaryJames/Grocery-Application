package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddSliderPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;


public class ManageSliderPageTest extends BaseClass{
	LoginPage lp;
	 HomePage hp;
	 ManageSliderPage ms;
	 AddSliderPage as;
	  @Test
	  public void verifyLoginWithValidDataSliderPage() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  ms=new ManageSliderPage(driver);
		  as=new AddSliderPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
		  ms.manageSliderPageClick();
		  as.manageSliderNewClick();
		  as.manageSliderValidFileClick();
		  as.manageSliderFileLinkValidClick();
		  as.manageSliderSaveClick();
		  ms.manageSliderPageClick();
		 ms.manageSliderDeleteClick();
		 ms.manageSliderDeleteConfirmationClick();
		 ms.manageSliderPageClick();
		 String link ="Capture";
		 String linkexpected=ms.readManageSliderPageElementText();
		 Assert.assertNotEquals(link, linkexpected);
		 }
}
