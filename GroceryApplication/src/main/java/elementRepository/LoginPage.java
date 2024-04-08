package elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}


	@FindBy(xpath = "//input[@name='username']") // with pagefactory
	WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passWordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath = "//div//div[@class='alert alert-danger alert-dismissible']//h5")
	WebElement alertMessageField;

	public void sendUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void sendPassWord(String passWord) {
		passWordField.sendKeys(passWord);
	}

	public void clickOnSignINButton() {
		signInButton.click();
	}
	public String displayAlert() {
		return alertMessageField.getText();
	}

}
