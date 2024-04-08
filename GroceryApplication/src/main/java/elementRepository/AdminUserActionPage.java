package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUserActionPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public AdminUserActionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	WebElement adminUser;
	@FindBy(xpath = "//tr[1]//td[5]//i[@class='fa fa-unlock']")
	WebElement adminLock;
	@FindBy(xpath = "//tr[1]//td[5]//a//i[@class='fa fa-lock']")
	WebElement adminUnLock;
	
	public void adminUserClick()
	{
		adminUser.click();
	}
	public void adminLockClick()
	{
		adminLock.click();
	}
	public void adminUnLockClick()
	{
		adminUnLock.click();
	}
	public String readAddUserStatusText(int row,int column) {
		String path="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
		WebElement element=driver.findElement(By.xpath(path));
		return element.getText();
	}
	
}
