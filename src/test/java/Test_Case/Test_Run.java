package Test_Case;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.Base_Class;
import Helper.Browser_Factory;
import Pages.Page_Trends;

public class Test_Run extends Base_Class{
	
	Page_Trends pageTrends;
	
	@BeforeClass
	public void setupBrowser() 
	{ 	
	driver = Browser_Factory.startApplication("chrome", "https://trends.google.com/");
	//driver=Browser_Factory.startAngularApplication("chrome", "https://trends.google.com/");	
	}
	
	@Test
	public void TestRun() {
		pageTrends = PageFactory.initElements(driver, Page_Trends.class);
		
		pageTrends.validateTitle();
		pageTrends.Search("Selenium WebDriver");
		pageTrends.clickOnCompare();
		pageTrends.CompareText("Javascript WebDriverIO");
		pageTrends.City_State("US => New York");
		pageTrends.dateChoose("Past 90 days");
		pageTrends.resultfromMetro();
	}
	


}
