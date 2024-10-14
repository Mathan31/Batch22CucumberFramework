package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import base.PicoTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHome;

public class AmazonSearch {
	
	
	AmazonHome amazonHome;
	
	public AmazonSearch(PicoTestContext picoTestContext) {
		amazonHome = picoTestContext.getPageObjectManager().getAmazonHome();
	}
	
	@Given("User should navigate to Amazon")
	public void user_should_navigate_to_amazon() {
		amazonHome.navigateURL();
	}
		
		@When("User search with multiple products in Amazon called")
		public void user_search_with_multiple_products_called(DataTable dataTable) {
		 List<Map<String, String>> searchs = dataTable.asMaps();
			for (Map<String, String> search : searchs) {
				amazonHome.enterProductName(search.get("ProdName"));
				amazonHome.selectProductCatagory(search.get("ProdCat"));
				amazonHome.clickSearchButton();
			}
	} 

	@Then("Validate the Amazon search result")
	public void validate_the_search_result() {
		String sResult = amazonHome.getsearchResult();
	    System.out.println("Result is : "+sResult);
	}


}
