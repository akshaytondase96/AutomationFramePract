package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import bsh.This;
import resources.AbstractComponents;

public class loginPage extends AbstractComponents
{
	WebDriver driver;
  public loginPage(WebDriver driver)
  {
	   super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
  }
@FindBy(id="userEmail")
WebElement email;
@FindBy(id="userPassword")
WebElement userpassword;
@FindBy(id="login")
WebElement signIn;
@FindBy(id="toast-container")
WebElement loginMsg;
@FindBy(css=".blink_me")
WebElement blinkMsg;

public void loginApplication(String username,String password)
  {
	email.sendKeys(username);
	userpassword.sendKeys(password);
	signIn.click();
  }
public String errorMsg()
{
	waitForVisibilityOfElement(loginMsg) ;
  return loginMsg.getText();	
}
public String getBlinkMsg()
{
 return blinkMsg.getText();
}
}
