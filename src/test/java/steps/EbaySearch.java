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
import pages.EbayHome;

public class EbaySearch {
	
	EbayHome ebayHome;
	
	public EbaySearch(PicoTestContext picoTestContext) {
		ebayHome = picoTestContext.getPageObjectManager().getEbayHome();
	}
	
	@Given("User should navigate to Ebay url")
	public void user_should_navigate_to_ebay_url() {
		ebayHome.navigateToEbay();
	}
	
	@When("User enters the product Name and Product Catagory")
	public void user_enters_the_product_name_and_product_catagory() {
		ebayHome.enterSearchText("iPhone");
		ebayHome.selectProdCatagory("Cell Phones & Accessories");
	}
	
	
	
	@When("^User enters the multiple product Name as ([^0-9]+) and Product multiple Catagory as ([^0-9]+)$")
	public void user_enters_the_multiple_product_name_as_java_and_product_multiple_catagory_as_books(String prodName,String prodCatagory) {
		ebayHome.enterSearchText(prodName);
		ebayHome.selectProdCatagory(prodCatagory);
	}
	

	@When("User enters the multiple product Name as datatable and multiple Product Catagory as datatable using List of Map")
	public void user_enters_the_multiple_product_name_as_datatable_and_multiple_product_catagory_as_datatable_using_list_of_map(DataTable dataTable) {
		List<Map<String, String>> maps = dataTable.asMaps();
		for (Map<String, String> map : maps) {
			String prodName = map.get("ProductName");
			String prodCatagory = map.get("ProductCatagory");
			ebayHome.enterSearchText(prodName);
			ebayHome.selectProdCatagory(prodCatagory);
			ebayHome.clickOnSearchButton();
		}
	}

	@When("User click on Search button")
	public void user_click_on_search_button() {
		ebayHome.clickOnSearchButton();
	}

	@Then("User should see the search results page")
	public void user_should_see_the_search_results_page() {
		String resultText = ebayHome.getSearchResult();
		resultText = resultText.replaceAll("[^0-9]", "");
		System.out.println("Result is : "+resultText);
		int iResult = Integer.parseInt(resultText);
		if(iResult > 0) {
			System.out.println("Result list is existing");
		}else {
			System.out.println("Result list is not existing");
		}
	}
	
}
