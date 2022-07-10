package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Factory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties properties;

	@Before(order = 0)
	public void getProperties() {
		configReader = new ConfigReader();

		properties = configReader.init_proper();

	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = properties.getProperty("browser");
		driverFactory = new DriverFactory();
		driver=driverFactory.init_driver(browserName);
	}
	
//	@Before(order = 2)
//	public void launchUrl() {
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	
	@After(order = 1)
	public void takeScreenShot(io.cucumber.java.Scenario scenario) {
		
		if (scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
			byte[] sourcePath =takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);
			
		}
		
	}
	
	
	

}
