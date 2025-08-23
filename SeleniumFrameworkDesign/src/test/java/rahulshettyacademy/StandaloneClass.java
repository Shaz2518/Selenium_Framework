package rahulshettyacademy;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandaloneClass {

	public static void main(String[] args) throws InterruptedException {
		// Escape password manager
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		Map<String, Object> profile = new HashMap<String, Object>();
		profile.put("password_manager_leak_detection", false);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		//WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Invoke Browser using Webdriver manager
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();

		// Explicit wait to avoid synchronization issue
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Fill username/password and Login
		driver.findElement(By.id("userEmail")).sendKeys("shaziya@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shaz@123");

		driver.findElement(By.id("login")).click();

		// list of all elements
		String productName = "ZARA COAT 3";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
		
		//Filter out the product which needs to be added to card
		WebElement addToCart = productList.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		//Add product to cart
		addToCart.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//Handle wait to load cart page.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//Click on cart option
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		
		//Get all the names of product added to cart and see if it matches with the order
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean cartData = cartProducts.stream().anyMatch(cartProd ->cartProd.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(cartData);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//AutoSuggestive dropdown
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		
		
		//Get Text of checkout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String login = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(login.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();

	}

}
