package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public WebDriver driver;
	int iBrowser = 1;
	
	public WebDriver launchBrowser() {
		if(driver==null) {
			switch (iBrowser) {
			case 1:
				System.out.println("User option is - "+iBrowser+" ,So invoking the Chrome browser!!");
				driver = new ChromeDriver();
				break;
				
			case 2:
				System.out.println("User option is - "+iBrowser+" ,So invoking the Firefox browser!!");
				driver = new FirefoxDriver();
				break;
				
			case 3:
				System.out.println("User option is - "+iBrowser+" ,So invoking the Edge browser!!");
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("User option is  wrong - "+iBrowser+" ,So invoking the default chrome browser!!");
				driver = new ChromeDriver();
				break;
			}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		return driver;
	}

}
