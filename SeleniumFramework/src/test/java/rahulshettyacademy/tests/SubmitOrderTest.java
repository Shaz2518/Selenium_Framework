package rahulshettyacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTests;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTests {

	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
				
		
		
		//Use object to open URL and submit login
		
		landingPage.loginPage("shaziya@gmail.com", "Shaz@123");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")));
		String productName = "ZARA COAT 3";
		// list of all elements
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> product = productCatalogue.getProductLists();
		
		//Filter out the product which needs to be added to card
		productCatalogue.addProductToCart(productName);
		
		//Handle wait to load cart page.
		Thread.sleep(6000);
		
		//Click on cart option
		productCatalogue.goToCartPage();
				
		//Get all the names of product added to cart and see if it matches with the order
		Thread.sleep(6000);
		CartPage cartPage = new CartPage(driver);
		boolean match = cartPage.getCartMatch(productName);
		Assert.assertTrue(match);
		cartPage.goToCheckout();
		
		//Checkout page
		CheckoutPage  page = new CheckoutPage(driver);
		page.checkOutPage("India");
		
		
		//Get Text of checkout
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String login = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(login.equalsIgnoreCase("Thankyou for the order."));
		

	}

	

}
