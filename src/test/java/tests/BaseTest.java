package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.AddToCart;
import pageobject.CartPage;
import pageobject.CheckOutPage;
import pageobject.ConfirmOrder;
import pageobject.OrderDelete;
import pageobject.loginPage;
import resources.AbstractComponents;

public class BaseTest
{
	
	public WebDriver driver;
	public loginPage login;
	public CartPage cp;
	public AbstractComponents ab;
	public Properties prop;
	public CheckOutPage ch;
	public ConfirmOrder cm;
	public AddToCart add;
    public OrderDelete del;
    
	@BeforeMethod(alwaysRun=true)
   public void initialize() throws IOException
   {
	    FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SeleniumFrameworkPractice\\src\\main\\java\\resources\\info.properties");
        prop=new Properties();
       prop.load(fis);
	   String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
	   if(browserName.equalsIgnoreCase(prop.getProperty("browser")))
	   {
	   WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       driver.get(prop.getProperty("url"));
	   }
	   else {
		   WebDriverManager.edgedriver().setup();
	        driver=new EdgeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	       driver.get(prop.getProperty("url"));
	   }
        login=new loginPage(driver);
        cp=new CartPage(driver);
        ab=new AbstractComponents(driver);
        ch=new CheckOutPage(driver);
        cm=new ConfirmOrder(driver);
        add=new AddToCart(driver);
          del=new OrderDelete(driver);
   }
	public String getScreenShot(WebDriver driver) throws IOException
	{
		SimpleDateFormat df=new SimpleDateFormat("dd-mm-yyyy h-m-s");
		  Date date=new Date();
		TakesScreenshot screen=(TakesScreenshot)driver;
		File file=screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\Users\\hp\\eclipse-workspace\\SeleniumFrameworkPractice\\screenshots\\"+"_"+df.format(date)+".png"));
		return "C:\\Users\\hp\\eclipse-workspace\\SeleniumFrameworkPractice\\screenshots\\"+"_"+df.format(date)+".png";
	}
	public ExtentReports getExtentObject()
	  {
		  String extentPath="C:\\Users\\hp\\eclipse-workspace\\SeleniumFrameworkPractice\\reports\\index.html";
		    ExtentSparkReporter  report=new ExtentSparkReporter(extentPath);
		    report.config().setReportName("Automation results");
		    report.config().setDocumentTitle("Test Results");
		    ExtentReports extent=new ExtentReports();
		    extent.attachReporter(report);
		    extent.setSystemInfo("Tester", "Akshay");
		    return extent;
	  }
	
}
