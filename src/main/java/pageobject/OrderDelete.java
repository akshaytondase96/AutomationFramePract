package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import resources.AbstractComponents;

public class OrderDelete extends AbstractComponents
{
	WebDriver driver;
	public OrderDelete(WebDriver driver) 
	{
		super(driver);
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
		

@FindBy(css="#toast-container")
WebElement placedMsg;
@FindBy(css=".toast-container")
WebElement deleteMsg;
@FindBy(css="button[routerlink*='/myorders']")
WebElement myOrders;
@FindBy(xpath="//tr/th[1]")
List<WebElement> AllOrderId;
@FindBy(css="tr td label[class='ng-star-inserted']")
WebElement orderId;


public void deleteOrder(String ordNum) throws InterruptedException
{
	Thread.sleep(3000);
    Actions a=new Actions(driver);
  a.moveToElement(myOrders).click().build().perform(); 
  Thread.sleep(3000);
  for(int  i=0;i<AllOrderId.size();i++) 
  {   
	  System.out.println(AllOrderId.get(i).getText());
  if(AllOrderId.get(i).getText().equalsIgnoreCase(ordNum)) 
  {
  driver.findElements(By.cssSelector(".btn.btn-danger")).get(i).click(); 
   System.out.println("Product deleted"); 
  break;
  } 
  }
}
}
