package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Helper.Utility;

public class Page_Trends {

	WebDriver driver;
	
	public Page_Trends(WebDriver Idriver){

	this.driver=Idriver;
	}
	
	@FindBy(xpath="//input[@id='input-254']") WebElement SearchText;
	
	
	@FindBy(xpath="//header/div[1]/div[3]/ng-transclude[1]/div[2]/explore-pills[1]/div[1]/button[1]") WebElement CompareClick;
	
	@FindBy(xpath="//body/div[2]/div[4]/md-dialog[1]/div[1]/ng-include[1]/md-autocomplete[1]") WebElement CompareText;
	
	@FindBy(xpath="//input[@id='input-254']") WebElement CityDropDown;
	
	@FindBy(xpath="//input[@id='input-254']") WebElement DateDropDown;
	
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/md-content/div/div/div[2]/trends-widget/ng-include/widget/div/div/ng-include/div/div[2]/widget/div/div/ng-include/div/div[2]/div/div/div/div[2]/span]") WebElement VerifyText;
	
	
	
	public void validateTitle() {
		Utility.validateTitle(driver, "Google Trends");
	}
	
	 public void Search(String SearchTopic){
	      Utility.waitForWebElement(driver, SearchText).sendKeys(SearchTopic, Keys.ENTER);
	 }
	 
	 public void clickOnCompare() {
			Utility.waitForWebElement(driver, CompareClick).click();
	 }
	 
	 public void CompareText(String CompareTopic){
	      Utility.waitForWebElement(driver, CompareText).sendKeys(CompareTopic, Keys.ENTER);
	      
	 }
	 
	 public void City_State(String CityName) {
			Select dropdown = new Select(CityDropDown);
			dropdown.selectByVisibleText(CityName);
		}
	 
	 public void dateChoose(String DateSelect) {
			Select dropdown = new Select(DateDropDown);
			dropdown.selectByVisibleText(DateSelect);
		}
	 
	 public void resultfromMetro() {
		 String actual = VerifyText.getText();
		 System.out.println(actual);
		 Assert.assertEquals(actual, "Expected text from Compared breakdown by metro");
	 }
	
}