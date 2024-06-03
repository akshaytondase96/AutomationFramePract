package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.AbstractComponents;

public class AddToCart extends AbstractComponents
{
	WebDriver driver;
	
  public AddToCart(WebDriver driver)
  {
	  super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//h5/b")
List<WebElement> items;
@FindBy(id="toast-container")
WebElement addedMsg;
public void addProductToCart(String productName)
  {
	  for(int i=0;i<items.size();i++)
	  {
		  if(items.get(i).getText().equalsIgnoreCase(productName))
		  {
				driver.findElements(By.xpath("//div[@class='card-body']//button[2]")).get(i).click();
		  }
	  }
	  waitForInvisibilityOfElement(addedMsg);
  }
}
