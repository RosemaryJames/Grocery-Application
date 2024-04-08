package elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LogOutPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement AdminButton;
	@FindBy(xpath = "//div//a[2][@class='dropdown-item']")
	WebElement LogOutButton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	
	public void adminClick()
	{
		AdminButton.click();
	}
	public void logOutClick()
	{
		LogOutButton.click();
	}
	 
	public String readLogOutPageText() {
		
		return userName.getText();
		
	}
}
