package tests;


import org.testng.annotations.Test;

public class Orders extends BaseTest
{
	@Test
  public void deleteOrders() throws InterruptedException
  {
	  login.loginApplication(prop.getProperty("username"),prop.getProperty("password"));
	  add.addProductToCart(prop.getProperty("product"));
	  cp.verifyItems(prop.getProperty("product"));
	   ch.checkOut(prop.getProperty("countryName")); 
	   cm.confirmOrder();
	   del.deleteOrder("665b3656ae2afd4c0bed9d71");
  }
}
