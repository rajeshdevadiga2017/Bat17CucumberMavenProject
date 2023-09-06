package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/admin.feature",
		glue = "stepdefinations",
		dryRun = false,
		monochrome = true,
		publish = true,
		//tags = "@Sanity"
		tags = "@Sanity"
		
		)
public class TestRunner {
	

}
