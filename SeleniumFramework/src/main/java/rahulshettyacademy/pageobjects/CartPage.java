package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	// Get all the names of product added to cart
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkout;

	// see if it matches with the order
	public boolean getCartMatch(String productName) {
		boolean cartData = cartProducts.stream().anyMatch(cartProd -> cartProd.getText().equalsIgnoreCase(productName));
		return cartData;

	}

	// Click on checkout
	public void goToCheckout() {
		checkout.click();
		
	}

}
