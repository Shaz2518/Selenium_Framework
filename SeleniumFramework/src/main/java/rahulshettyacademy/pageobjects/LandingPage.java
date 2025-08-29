package rahulshettyacademy.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		//Give driver to parent class
		super(driver);
		//Initialize WebDriver
		this.driver=driver;
		
		//PageFactory method to initialize WebElement
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submitLogin;
	
	//Create a method to login
	public ProductCatalogue loginPage(String user, String pwd)
	{
		userName.sendKeys(user);
		password.sendKeys(pwd);
		submitLogin.click();
		
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
	}
	
	//Method to go to URL and maximize browser
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
	}
	
	
}
