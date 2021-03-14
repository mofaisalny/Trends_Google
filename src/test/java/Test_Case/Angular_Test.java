package Test_Case;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Helper.Base_Class;
import Helper.Browser_Factory;
import Pages.Angular_Page;

public class Angular_Test extends Base_Class{
	
	Angular_Page angularPage;
	
	@BeforeClass
	public void setupBrowser() 
	{ 	
	driver=Browser_Factory.startAngularApplication("chrome", "https://trends.google.com/");	
	}
	
	@Test
	public void testRunAngular() {
		angularPage = PageFactory.initElements(driver, Angular_Page.class);
		
		angularPage.Search("Selenium WebDriver");
		angularPage.clickOnCompare();
		angularPage.CompareText("Javascript WebDriverIO");
		angularPage.City_State("US => New York");
		angularPage.dateChoose("Past 90 days");
		angularPage.resultfromMetro();
	}

}
