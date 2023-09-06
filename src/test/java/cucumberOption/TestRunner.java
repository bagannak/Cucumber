package cucumberOption;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "/Users/testvagrant/Baganna/Cucumber/src/test/java/features/Login.feature",
glue = "stepDefinations")
public class TestRunner extends AbstractTestNGCucumberTests {
}
