package Cucumber.Options;

import StepDefination.Hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(features = "src/test/java/Features",glue = "StepDefination",plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"})
        // tags= "@dropdownWithDatatable")
public class TestRunner extends AbstractTestNGCucumberTests {

}
//mvn test '-Dcucumber.filter.tags="@addUser"'
//mvn test '-Dcucumber.plugin=html:reports/cucumber-report-html'