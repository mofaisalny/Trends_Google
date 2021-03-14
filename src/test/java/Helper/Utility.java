package Helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility {

	public static WebElement waitForWebElement(WebDriver driver, By element) 
	{
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	return driver.findElement(element);
	}
		
	public static WebElement waitForWebElement(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	
	
	
	public static void validateTitle(WebDriver driver, String title)
	{
		boolean status = new WebDriverWait(driver, 30).until(ExpectedConditions.titleIs(title));
		Assert.assertTrue(status);
	}
	
	public static void verifyCurrentURL(WebDriver driver, String url)
	{
		boolean status = new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains(url));
		Assert.assertTrue(status);
	}
	
	
	public static String captureScreenShot(WebDriver driver, String methodName)
	{
		String time =getTime();
		String dest=System.getProperty("user.dir")+"/Screenshot/"+methodName+"_"+time+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src =ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File(dest));
		} catch(IOException e) {
			System.out.println("Screenshot Failed"+e.getMessage());
		}
		return dest;
	}
	
	
	public static String getTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		return dateFormat.format(new Date());
	}
}
