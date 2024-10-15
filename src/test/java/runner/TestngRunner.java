package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "./src/test/resources/features",
		glue = {"steps","hooks"},
		dryRun = false,
		plugin = {"pretty","json:target/reports/search.json","html:target/reports/search.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class TestngRunner extends AbstractTestNGCucumberTests{

}
