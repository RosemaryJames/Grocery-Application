package testCases;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotCapture;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties pro;
	public static void testBasic() throws IOException {

		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		pro.load(fp);
	}
  
  @BeforeMethod(alwaysRun=true)
  @Parameters("Browser")
  public void beforeMethod(String browserName) throws IOException {
	  testBasic();
	  if(browserName.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\TOSHOBA\\eclipse-workspace\\GroceryApplication\\src\\main\\resources\\driver\\chromedriver.exe");
			driver= new ChromeDriver();  
	  }
	  else if(browserName.equals("edge")) {
		  System.setProperty("webdriver.edge.driver", "D:\\driver\\msedgedriver.exe");
			driver= new EdgeDriver();
	  }
	  driver.get(pro.getProperty("BaseUrl"));
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
  }

  @AfterMethod(alwaysRun = true)
	public void afterMethode(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

}
