package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

import Helper.Utility;

public class Angular_Page {

		WebDriver driver;
		
		public Angular_Page(WebDriver Idriver){
		this.driver=Idriver;
		}
		
		
		public void validateTitle() {
			Utility.validateTitle(driver, "Google Trends");
		}
		
		 public void Search(String SearchTopic){
		    driver.findElement(ByAngular.model("$mdAutocompleteCtrl.scope.searchText")).sendKeys(SearchTopic, Keys.ENTER);		 }
		 
		 public void clickOnCompare() {
			driver.findElement(ByAngular.buttonText("ng-click=\"ctrl.addSearchTerm()\"")).click();
		 }
		 
		 public void CompareText(String CompareTopic){
		     driver.findElement(ByAngular.model("$mdAutocompleteCtrl.scope.searchText")).sendKeys(CompareTopic, Keys.ENTER);
		     }
		 
		 public void City_State(String CityName) {
				Select dropdown = new Select(driver.findElement(ByAngular.model("")));
				dropdown.selectByVisibleText(CityName);
			}
		 
		 public void dateChoose(String DateSelect) {
				Select dropdown = new Select(driver.findElement(ByAngular.model("")));
				dropdown.selectByVisibleText(DateSelect);
			}
		 
		 public void resultfromMetro() {
			 String actual = driver.findElement(By.xpath("")).getText();
			 System.out.println(actual);
			 Assert.assertEquals(actual, "Expected text from Compared breakdown by metro");
		 }
}
