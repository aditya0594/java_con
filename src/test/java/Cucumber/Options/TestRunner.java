package Cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features",glue = "StepDefination",plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"}/*tags = "@radio or ~@DynamicDropdown"*/)
public class TestRunner extends AbstractTestNGCucumberTests {

}
//mvn test '-Dcucumber.filter.tags="@addUser"'
//mvn test '-Dcucumber.plugin=html:reports/cucumber-report-html'