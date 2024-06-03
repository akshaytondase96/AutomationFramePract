package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import resources.AbstractComponents;

public class ConfirmOrder extends AbstractComponents
{
  WebDriver driver;
	public ConfirmOrder(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement successMsg;
	public void confirmOrder()
	{
	     Assert.assertEquals(successMsg.getText(),"THANKYOU FOR THE ORDER.");	
	     
	}
  
}
