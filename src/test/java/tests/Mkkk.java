package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Mkkk {
	@Test(dataProvider="getExcelbData")
	public  void displayExcelData(ArrayList<String> arr) throws IOException
	{
		for(String alp:arr)
		{
			System.out.println(alp);
		}
	}

	@DataProvider
  public ArrayList<String> getExcelbData() throws IOException
  {
	FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SeleniumFrameworkPractice\\src\\main\\java\\resources\\excelData.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	ArrayList<String>al=new ArrayList<String>();
	DataFormatter format=new DataFormatter();
	
    for(int i=0;i<wb.getNumberOfSheets();i++)
    {
    	
    	if(wb.getSheetName(i).equalsIgnoreCase("Sheet2"))
    	{
    		XSSFSheet sheet=wb.getSheetAt(i);
    		Iterator<Row> row=sheet.iterator();
    		
    			Row row1=row.next();
    			Row row2=row.next();
    			 Iterator<Cell> ce=row2.iterator();
    			 while(ce.hasNext())
    			 {
    				Cell cell= ce.next();
    				al.add(format.formatCellValue(cell));
    			 }
    		}
    	}
      return al;
    }
	
	 // public static void main(String arg[]) throws IOException { ExcelDataPractice
	  //exc=new ExcelDataPractice(); exc.displayExcelData(); }
	 

}
