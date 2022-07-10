package com.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	/*
	 * We can achieve the parallel execution using ThreadLocal
	 * 
	 * 
	 *  This method is used to initialize the ThreadLOcal driver based on the specified browser name
	 */
	
	public static ThreadLocal<WebDriver> tlDriver =new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser Name ->"+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}else if (browser.equalsIgnoreCase("firefox")) {
			tlDriver.set(new FirefoxDriver());
		}else if (browser.equalsIgnoreCase("safari")) {
			tlDriver.set(new SafariDriver());
		}else {
			System.out.println("supported browser are chrome.firefox,safari");
		}
		
		getWebdriver().manage().deleteAllCookies();
		getWebdriver().manage().window().maximize();
		
		return getWebdriver();
		
		
	}
	
	
	/*
	 *  If parallel execution is happening multiple browsers will open, so we need to use the synchronized keyword for handle different browsers sessions correctly  
	 */
	
	public static synchronized WebDriver getWebdriver() {
		return tlDriver.get();
	}

}
