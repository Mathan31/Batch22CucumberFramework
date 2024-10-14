package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private AmazonHome amazonHome;
	private EbayHome ebayHome;
	private WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public AmazonHome getAmazonHome() {
		if(amazonHome == null) {
			amazonHome = new AmazonHome(driver);
		}
		return amazonHome;
	}

	public EbayHome getEbayHome() {
		if(ebayHome == null) {
			ebayHome = new EbayHome(driver);
		}
		return ebayHome;
	}

}
