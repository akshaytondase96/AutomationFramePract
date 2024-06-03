package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.AbstractComponents;

public class CartPage extends AbstractComponents
{
	WebDriver driver;
	public CartPage(WebDriver driver) 
    {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void verifyItems(String productName)
	{
		goToCart();
	List<WebElement> addedItems=driver.findElements(By.cssSelector(".cartSection h3"));
   for(WebElement added:addedItems)
   {
  	 if(added.getText().equalsIgnoreCase(productName))
  	 {
  		System.out.println("Product Verified Successfully");
  	 }
   }
	}
}
