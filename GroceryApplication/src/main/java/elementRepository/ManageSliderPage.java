package elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSliderPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//i[@class='nav-icon fas fa-window-restore']")
	WebElement ManageSliderPage;
	@FindBy(xpath = "//div//section//div[3]//div[2]//table//tbody//tr[1]//td//a[2]//i[@class='fas fa-trash-alt']")
	WebElement ManageSliderDelete;
	@FindBy(xpath = "//div//section//div[3]//div[2]//table//tbody//tr[1]//td[2]")
	WebElement ManageSliderElement;
	
	public void manageSliderPageClick()
	{
		ManageSliderPage.click();
	}
	
	public void ManageSliderDeleteClick()
	{
		ManageSliderDelete.click();
	}
	
	public void ManageSliderDeleteConfirmationClick()
	{
		gu.acceptAlert(driver);
	}
	public String readManageSliderPageElementText() {
		
		return ManageSliderElement.getText();
	}
}
