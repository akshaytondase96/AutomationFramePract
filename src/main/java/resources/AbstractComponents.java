package resources;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents
{
	String productName="ADIDAS ORIGINAL";
  WebDriver driver;
  WebDriverWait wait;
 
	public AbstractComponents(WebDriver driver) 
	{
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="button[routerlink*='/cart']")
	WebElement cart;
	
	public void goToCart()
	{  
		cart.click();
	}
  public void waitForInvisibilityOfElement(WebElement e)
  {
	  wait=new WebDriverWait(driver,Duration.ofSeconds(3));
	  wait.until(ExpectedConditions.invisibilityOf(e));
  }
  public void waitForVisibilityOfElement(WebElement e)
  {
	  wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.visibilityOf(e));
}
}
