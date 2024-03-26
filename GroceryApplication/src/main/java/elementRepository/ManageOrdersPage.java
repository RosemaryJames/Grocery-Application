package elementRepository;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageOrdersPage {

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();
	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//i[@class='nav-icon fas fa-shopping-basket']")
	WebElement ManageOrdersPage;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement ManageOrdersSearch;
	
	@FindBy(xpath = "//select[@id='pt']")
	WebElement ManageOrdersPaymentMode;
	
	@FindBy(xpath = "//select[@id='st']")
	WebElement ManageOrdersStatus;
	
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement ManageOrdersSearchButton;
	
	@FindBy(xpath = "//section//div[4]//div[3]//table//tbody//tr[1]//td[5]")
	WebElement paymentelement;
	
	@FindBy(xpath = "//section//div[4]//div[3]//table//tbody//tr[1]//td[6]//span[@style='text-transform: uppercase;']")
	WebElement statusElement;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	List<WebElement> rowElement;
	
	public void manageOrdersPageClick()
	{
		ManageOrdersPage.click();
	}
	
	public void ManageOrdersSearchClick()
	{
		ManageOrdersSearch.click();
	}
	
	public void ManageOrdersPaymentMode()
	{
		gu.selectDropDownValueusingVisibleText(ManageOrdersPaymentMode, "COD");
	}
	
	public void ManageOrdersStatus()
	{
		gu.selectDropDownValueusingVisibleText(ManageOrdersStatus, "UnPaid");
	}
	public void ManageOrdersSearchButtonClick()
	{
		ManageOrdersSearchButton.click();
	}
	public void FluentWaitTime()
	{
		wu.fluventWaitElements(driver, ManageOrdersPaymentMode, "id", "pt",500);
	}
	public void JavaExecuter()
	{
		gu.scrolUsingJavaScript(driver,"0","15000");
	}
	public String readManageOrdersPagePaymentElementText() {
		
		return paymentelement.getText();
	}
	public String readManageOrdersPageStatusElementText() {
		
		return statusElement.getText();
	}
	public int getTableSize()
	{
		return rowElement.size();
	}
	public String readManageOrdersPageStatusElementTextTotal(int row,int column) {
		String path="//section//div[4]//div[3]//table//tbody//tr["+row+"]//td["+column+"]//span[@style='text-transform: uppercase;']";
		WebElement element=driver.findElement(By.xpath(path));
		return element.getText();
	}
}
