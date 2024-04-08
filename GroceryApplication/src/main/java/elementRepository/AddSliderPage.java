package elementRepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.GeneralUtilities;



public class AddSliderPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public AddSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement ManageSliderNew;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement ManageSliderFile;
	@FindBy(xpath = "//input[@id='link']")
	WebElement ManageSliderFileLink;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement ManageSliderFilesave;

	public void manageSliderNewClick()
	{
		ManageSliderNew.click();
	}
	public void manageSliderFileClick()
	{
		ManageSliderFile.sendKeys("C:\\Users\\TOSHOBA\\Desktop\\xpath.txt");
		
	}
	public void manageSliderValidFileClick()
	{
		ManageSliderFile.sendKeys("C:\\Users\\TOSHOBA\\Desktop\\Capture1.png");
		
	}
	public void manageSliderFileLinkClick()
	{
		gu.sendValueUsingJavaScript(driver, ManageSliderFileLink, "imagelink");
		
	}
	public void manageSliderFileLinkValidClick()
	{
		gu.sendValueUsingJavaScript(driver, ManageSliderFileLink, "Capture");
		
	}
	public void manageSliderSaveClick()
	{
		ManageSliderFilesave.click();
	}
	public String readManageSliderText(int row,int column) {
		String path="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
		WebElement element=driver.findElement(By.xpath(path));
		return element.getText();
	}
	
 }


