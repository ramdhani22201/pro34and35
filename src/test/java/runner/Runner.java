package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features ="src/test/java/featuresP",
		glue ="stepDefination",
		plugin={"html:target/cucumber_html_report.html"}
		)
public class Runner extends AbstractTestNGCucumberTests {

	
}
