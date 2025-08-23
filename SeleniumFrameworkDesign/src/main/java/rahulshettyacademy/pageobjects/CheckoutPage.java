package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement option;
	By checkout = By.cssSelector(".ta-results");
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement optionSelected;
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement orderPlaced;
	
	//Checkout option
	public void checkOutPage(String options)
	{
		option.sendKeys(options);
		waitForElement(checkout);
		optionSelected.click();
		orderPlaced.click();
	}
	
	
	
			
			
			
}
