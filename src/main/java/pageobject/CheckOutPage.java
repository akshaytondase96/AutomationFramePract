package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.AbstractComponents;

public class CheckOutPage extends AbstractComponents
{
  WebDriver driver;
	public CheckOutPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="toast-container")
    WebElement productAddMsg;	
	@FindBy(css=".subtotal button")
	WebElement checkOut;
	@FindBy(css="input[placeholder*='Country']")
	WebElement enterCountry;
	@FindBy(css="button[class*='list-group']")
	List<WebElement> countryList;
  public void checkOut(String countryName)
  {
	  waitForInvisibilityOfElement(productAddMsg);
	  checkOut.click();
	  enterCountry.sendKeys(countryName);
	  
	     for(WebElement country:countryList)
	     {
	    	 if(country.getText().equalsIgnoreCase(countryName))
	    	 {
	    		 country.click();
	    		 break;
	    	 }
	     }
	     WebElement submitOrder=driver.findElement(By.cssSelector("a[class*='submit']"));
	     Actions a=new Actions(driver);
	     a.moveToElement(submitOrder).click().build().perform();
  }
}
