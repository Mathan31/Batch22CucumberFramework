package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayHome {
	
	private WebDriver driver;
	public String sURL = "https://www.ebay.com/";
	private By productNameTxt = By.id("gh-ac");
	private By prodCatagoryDrop = By.id("gh-cat");
	private By searchButton = By.id("gh-btn");
	private By searchResult = By.xpath("//h1[@class='srp-controls__count-heading']/span");
	
	public EbayHome(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigateToEbay() {
		driver.get(sURL);
		}
	
	public void enterSearchText(String prodName) {
		WebElement oSearch;
		oSearch = driver.findElement(productNameTxt);
		oSearch.clear();
		oSearch.sendKeys(prodName);
	}
	
	public void selectProdCatagory(String prodCatagory) {
		WebElement oDropdown;
		oDropdown = driver.findElement(prodCatagoryDrop);
		Select oSelect = new Select(oDropdown); // Select class is prefered only for a dropdown with select tag.
		oSelect.selectByVisibleText(prodCatagory);
	}

	public void clickOnSearchButton() {
		WebElement oBtn = driver.findElement(searchButton);
		oBtn.click();
	}
	
	public String getSearchResult() {
		WebElement result;
		result = driver.findElement(searchResult);
		String resultText = result.getText();
		return resultText;
	}

}
