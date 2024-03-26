package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.GeneralUtilities;

public class ManageLocationPage {

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	String locationName;
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath = "//i[@class='nav-icon fas fa-map-marker']")
	WebElement ManageLocationPage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement ManageLocationPageNew;
	@FindBy(xpath = "//select[@id='country_id']") 
	WebElement countryField;
	@FindBy(xpath = "//select[@id='st_id']")
	WebElement stateField;
	@FindBy(xpath = "//input[@id='location']")
	WebElement locationField;
	@FindBy(xpath = "//input[@id='delivery']")
	WebElement deliveryChargeField;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;

	public void manageLocationPagenew()
	{
		ManageLocationPageNew.click();
	}
	public void manageLocationPageClick()
	{
		ManageLocationPage.click();
	}
	public void sendCountry() {
		
		gu.selectDropDownValueusingVisibleText(countryField,"United Kingdom");
	}

	public void sendState() {
		
		gu.selectDropDownValueusingVisibleText(stateField,"Brechin");
		
	}
	public void sendLocation(String location) {
		String locationName=location+gu.generateCurrentDateAndTime();
		this.locationName=locationName;
		//locationField.sendKeys(location);
		locationField.sendKeys(location+gu.generateCurrentDateAndTime());
	}
	public String getRandomlyLocationName() 
 {
	return locationName;
 }
	public void sendDeliveryCharge(String deliveryCharge) {
		deliveryChargeField.sendKeys(deliveryCharge);
	}

	public void clickSaveButton() {
		saveButton.click();
	}
	public String readManageLocationPageElementText(int row,int column) {
		String path="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
		WebElement element=driver.findElement(By.xpath(path));
		return element.getText();
	}
}

