package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddSliderPage;
import elementRepository.AdminUserActionPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;


public class AdminUserActionTestPage extends BaseClass {
	LoginPage lp;
	 HomePage hp;
	 AddSliderPage as;
	 AdminUserActionPage aap;
	  @Test
	  public void verifyAdminUserInactiveStatus() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  aap=new AdminUserActionPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
		  aap.adminUserClick();
		  aap.adminLockClick();
		  String statusactive="Inactive";
		  String statusexpected=aap.readAddUserStatusText(1, 3);
		  Assert.assertEquals(statusactive, statusexpected,Constant.lp_verifyLoginWithInvalidData);
	  }
	  @Test
	  public void verifyAdminUserStatus() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  aap=new AdminUserActionPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
		  aap.adminUserClick();
		  aap.adminUnLockClick();
		  aap.adminUserClick();
		  String statusactive="Active";
		  String statusexpected=aap.readAddUserStatusText(1, 3);
		  Assert.assertEquals(statusactive, statusexpected,Constant.lp_verifyLoginWithInvalidData);
	 
}
}
