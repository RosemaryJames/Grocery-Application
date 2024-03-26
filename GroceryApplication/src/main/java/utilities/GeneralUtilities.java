package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void selectDropDownValueusingIndex(WebElement element,int index)
	{
		Select object =new Select(element);
		object.selectByIndex(index);
	}
	public void selectDropDownValueusingVisibleText(WebElement element,String Text)
	{
		Select object =new Select(element);
		object.selectByVisibleText(Text);
	}
	public void sendValueUsingJavaScript(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);
	}
	public void scrolUsingJavaScript(WebDriver driver,String value1,String value2) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy("+value1+","+value2+")");
	}
	public void scrolUsingJavaScriptforclick(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	

public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
}
