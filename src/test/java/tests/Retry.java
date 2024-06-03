package tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
   int maxCount=1;
   int count=0;
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<maxCount)
		{
			count++;
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	

}
