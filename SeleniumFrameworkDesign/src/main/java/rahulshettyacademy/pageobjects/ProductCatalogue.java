package rahulshettyacademy.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		//Give driver to Parent
		super(driver);
		
		//Initialize WebDriver
		this.driver=driver;
		
		//PageFactory method to initialize WebElement
		PageFactory.initElements(driver, this);
	}
	
	
	//Store list of all product
	@FindBy(css=".mb-3")
	List<WebElement> productList;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductLists()
	{
		waitTillElementAppears(productBy);
		return productList;
	}
	
	//Filter product
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductLists().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
		
	//Add product to cart
	public void addProductToCart(String productName)
	{
		WebElement product_Name = getProductByName(productName);
		product_Name.findElement(addToCart).click();
		waitTillElementAppears(toastMessage);
		//waitTillElementDisAppears(spinner);
	}
	
	
	
	
	
}
