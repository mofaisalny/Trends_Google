package Helper;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;


public class Base_Class {

	public WebDriver driver;
		
		@AfterMethod 
		public void appendReport(ITestResult result) 
		{
			System.out.println("Test Name : "+result.getName());
			
	
			int status=result.getStatus();
			
			if(status==ITestResult.SUCCESS) 
			{
				try { 
					
					Utility.captureScreenShot(driver, result.getMethod().getMethodName());
					System.out.println("Test passed and screenshot captured.");
					
				}catch(Exception e) {
					System.out.println("Not able to be attach screenshot :"+e.getMessage());
					}	
				}
			
			else if(status==ITestResult.FAILURE) 
			{
				try {
					Utility.captureScreenShot(driver, result.getMethod().getMethodName());
					System.out.println("Test failed and screenshot captured.");
					
					}catch(Exception e) {
					System.out.println("Not able to attach screnshot : "+e.getMessage());													
				}
			}
			
			else if(status==ITestResult.SKIP) 
			{
			System.out.println("Test case skipped.");
			}
		}
		
		
	@AfterClass
		public void closeSessions() {
			driver.quit();
			System.out.println("Browser session closed");
		}  
	}
