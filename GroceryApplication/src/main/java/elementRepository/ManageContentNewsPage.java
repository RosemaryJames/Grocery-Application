package elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageContentNewsPage {

	WebDriver driver;
	String details;
	GeneralUtilities gu=new GeneralUtilities();
	public ManageContentNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
	WebElement manageContentPage;
	@FindBy(xpath = "//li//ul[4]//li//a//i[@class='far fa-circle nav-icon']")
	WebElement manageNewsPage;
	@FindBy(xpath = "//tbody//tr[3]//td//a//i[@class='fas fa-edit']")
	WebElement manageNewsEdit;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement manageNewstext;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement manageNewsUpdate;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[3]")
	WebElement manageNewsRead;

	public void manageContentPageClick()
	{
		manageContentPage.click();
	}
	public void manageNewsPageClick()
	{
		manageNewsPage.click();
	}
	public void manageNewsEditClick()
	{
		manageNewsEdit.click();
	}
	public void manageNewsEditText(String data)
	{
		gu.sendValueUsingJavaScript(driver, manageNewstext, "Rosemary");
		
	}
	public void manageNewsUpdateClick()
	{
		manageNewsUpdate.click();
	}
	public String readManageNewsUpdateText() {
		
		return manageNewsRead.getText();
	}
	
}
