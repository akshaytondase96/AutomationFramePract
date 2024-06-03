package tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitOrder extends BaseTest
{
	@Test(dataProvider="getData",priority=1)
	public void placeOrder(String username,String password,String productName,String contryName) throws InterruptedException
	{
		login.loginApplication(username,password);
		add.addProductToCart(productName);
		cp.verifyItems(productName);
	    ch.checkOut(contryName); 
	    //Assert.assertTrue(false);
		cm.confirmOrder(); 
     }
	@Test(priority=3)
	public void validateBlinkMsg()
	{
		Assert.assertEquals(login.getBlinkMsg(), "Register to sign in with your personal account.");
	}
	@Test(priority=2)
	public void errorValidation()
	{
		login.loginApplication("aks96@gmail.com","Akshay@5572");
		Assert.assertEquals(login.errorMsg(),"Incorrect email or password");;
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
	  DataFormatter format=new DataFormatter();
	  FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SeleniumFrameworkPractice\\src\\main\\java\\resources\\excelData.xlsx");
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	 XSSFSheet sh= wb.getSheetAt(0); 
	 int rowCount=sh.getPhysicalNumberOfRows();
	 XSSFRow row=sh.getRow(0);
	 int columnCount=row.getLastCellNum();
	 Object[][]data=new Object[rowCount-1][columnCount];
	 for(int i=0;i<rowCount-1;i++)
	 {
		 row=sh.getRow(i+1);
		 {
			 for(int j=0;j<columnCount;j++)
			 {
				 XSSFCell cell=row.getCell(j);
				 data[i][j]=format.formatCellValue(cell);
			 }
		 }
	 }
  return data;
}
	
}

