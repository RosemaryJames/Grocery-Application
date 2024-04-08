package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

import elementRepository.ManageOrdersPage;

public class ManageOrdersPageTest extends BaseClass{
	LoginPage lp;
	 HomePage hp;
	 ManageOrdersPage mo;
	  @Test
	  public void verifyLoginWithValidDataMangeOrders() {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  mo=new ManageOrdersPage(driver);
		  lp.sendUserName("admin");
		  lp.sendPassWord("admin");
		  lp.clickOnSignINButton();
		  String expected="Admin";
		  String actual=hp.verifyhomePage();
		  Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithInvalidData);
		  mo.manageOrdersPageClick();
		  mo.manageOrdersSearchClick();
		  mo.waitForManageOrdersPaymentMode();
		  mo.manageOrdersPaymentMode();
		  mo.manageOrdersStatus();
		  mo.manageOrdersSearchButtonClick();
		  mo.scrollbyJavaExecuter();
		  String paymentexpected=mo.readManageOrdersPagePaymentElementText();
		  Assert.assertEquals("COD", paymentexpected, Constant.lp_verifyLoginWithInvalidData);
		  String statusexpected=mo.readManageOrdersPageStatusElementText();
		  Assert.assertEquals("UNPAID", statusexpected, Constant.lp_verifyLoginWithInvalidData);
		  for(int i=1;i<=mo.getTableSize();i++)
		  {
			  String statusexpectedtotal=mo.readManageOrdersPageStatusElementTextTotal(i,6);
			  Assert.assertEquals("UNPAID", statusexpectedtotal, "output mismatch");
		  }
		
}
}
