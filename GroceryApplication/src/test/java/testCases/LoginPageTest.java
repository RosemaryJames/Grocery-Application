package testCases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class LoginPageTest extends BaseClass {
 LoginPage lp;
 HomePage hp;
 @Test
 public void verifyLoginWithInvalidData() {
	  lp=new LoginPage(driver);
	  lp.sendUserName("admin");
	  lp.sendPassWord("adm");
	  lp.clickOnSignINButton();
	  String expected="Alert!";
	  String actual=lp.displayAlert();
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
 }
 
  @Test(groups="SmokeTest")
  public void verifyLoginWithInvalidDataExel() throws IOException {
	  lp=new LoginPage(driver);
	  lp.sendUserName(ExcelUtilities.getstringdata(0,0));
	  lp.sendPassWord(ExcelUtilities.getstringdata(0,1));
	  lp.clickOnSignINButton();
	  String expected="Alert!";
	  String actual=lp.displayAlert();
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
  }
  @Test(groups="SmokeTest")
  public void verifyLoginWithValidDataExcel() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  lp.sendUserName(ExcelUtilities.getstringdata(1,0));
	  lp.sendPassWord(ExcelUtilities.getstringdata(1,1));
	  lp.clickOnSignINButton();
	  String expected="Admin";
	  String actual=hp.verifyhomePage();
	  Assert.assertEquals(actual, expected,Constant.lp_verifyLoginWithInvalidData);
	  
  }
  @Test(dataProvider="data-providerinvalid", dataProviderClass=DataProviderSample.class)
  public void verifyLoginWithInvalidDataProvider(String username,String password) {
	  lp=new LoginPage(driver);
	 lp.sendUserName(username);
	  lp.sendPassWord(password);
	  lp.clickOnSignINButton();
	  String expected="Alert!";
	  String actual=lp.displayAlert();
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
  }
  @Test(dataProvider="data-providervalid", dataProviderClass=DataProviderSample.class)
  public void verifyLoginWithValidDataProvider(String username,String password) {
	  lp=new LoginPage(driver);
	 hp=new HomePage(driver);
	 lp.sendUserName(username);
	  lp.sendPassWord(password);
	 lp.clickOnSignINButton();
	  String expected="Admin";
	  String actual=hp.verifyhomePage();
	  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
	  
  }
}
