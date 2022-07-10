package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"classpath:appFeatures"},
		glue = {"stepDefinations","AppHooks"},
		plugin = {
				"pretty"
				},
		monochrome = true
		
		
		)
public class MyTestRunner {
	
	// "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

}
