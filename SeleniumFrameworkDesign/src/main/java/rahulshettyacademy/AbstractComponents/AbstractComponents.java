package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, null);
	}

	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartClick;
	
	

	public void waitTillElementAppears(By findBy)
	{
		WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElement(By findBy)
	{
		WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitTime.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	//Cart Page navigation
	public void goToCartPage()
	{
		cartClick.click();
	}
	
	public void waitTillElementDisAppears(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait waitTime = new WebDriverWait(driver, Duration.ofSeconds(15));
//		waitTime.until(ExpectedConditions.invisibilityOf(ele));
//		
	}

}
