package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTests {
	public WebDriver driver;
	public LandingPage landingPage;

	public void initializeDriver() throws IOException {
		
		
		// Properties Method
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + 
				"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			// Escape password manager
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("password_manager_enabled", false);
			Map<String, Object> profile = new HashMap<String, Object>();
			profile.put("password_manager_leak_detection", false);
			prefs.put("profile", profile);
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);
		}

		
		// WebDriverWait explicitWait = new WebDriverWait(driver,
		// Duration.ofSeconds(5));

		// Invoke Browser using Webdriver manager
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();

		// Explicit wait to avoid synchronization issue
		
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		initializeDriver();
		landingPage = new LandingPage(driver);
		
		//Use object to open URL and submit login
		landingPage.goTo();
		return landingPage;
		
	}
	
	@AfterMethod
	public void browserClose()
	{
		driver.quit();
	}
}
	


