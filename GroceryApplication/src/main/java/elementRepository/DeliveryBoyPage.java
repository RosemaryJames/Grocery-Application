package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DeliveryBoyPage {
	WebDriver driver;
	
	GeneralUtilities gu=new GeneralUtilities();
	public DeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	
	@FindBy(xpath = "//i[@class='nav-icon fas fa-user-plus']")
	WebElement deliveryBoy;
	@FindBy(xpath = "//tr[1]//td[7]//a//i[@class='fa fa-angle-double-down']")
	WebElement deliveryBoyPassword;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement deliveryBoyNew;
	@FindBy(xpath = "//input[@id='name']")
	WebElement deliveryBoyName;
	@FindBy(xpath = "//input[@id='username']")
	WebElement deliveryBoyUserName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement deliveryBoyPass;
	@FindBy(xpath = "//button[@name='create']")
	WebElement deliveryBoySave;
	
	
	
	public void DeliveryBoyClick()
	{
		deliveryBoy.click();
	}
	public void DeliveryBoyNewClick()
	{
		deliveryBoyNew.click();
	}
	public void DeliveryBoyNameClick()
	{
		gu.sendValueUsingJavaScript(driver, deliveryBoyName, "Rose");	
	}
	public void DeliveryBoyUserNameClick(String userName)
	{
		
		deliveryBoyUserName.sendKeys(userName+gu.generateCurrentDateAndTime());
	}
	public void DeliveryBoyPassClick()
	{
		gu.sendValueUsingJavaScript(driver, deliveryBoyPass, "Jithin@123");
	}
	public void DeliveryBoySaveClick()
	{
		gu.scrolUsingJavaScriptforclick(driver,deliveryBoySave);
	}
	public void DeliveryBoyPasswordClick()
	{
		deliveryBoyPassword.click();
	}

	public String readdeliveryBoyPasswordShowText(int row,int column) {
		String path="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\"+row+\"]//td[\"+column+\"]//div//div";
		WebElement element=driver.findElement(By.xpath(path));
		return element.getText();
	}
	
		
}
