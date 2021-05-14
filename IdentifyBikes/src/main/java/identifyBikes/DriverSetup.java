package identifyBikes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	// Declaring the static variable
	private static WebDriver driver;

	// Creating invokeDriver method which will take browserName as a parameter
	public static WebDriver invokeDriver(String browserName) {

		// Invoking Chrome Browser
		if (browserName.equalsIgnoreCase("Chrome_Browser")) {
			String chromeDriverPath = ".\\DriverFiles\\chromedriver.exe";
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path + chromeDriverPath);

			driver = new ChromeDriver(options);
		}

		// Invoking Firefox Browser
		else if (browserName.equalsIgnoreCase("Firefox_Browser")) {
			String firefoxDriverPath = ".\\DriverFiles\\geckodriver.exe";
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", path + firefoxDriverPath);

			driver = new FirefoxDriver();
		}

		// Returning the Driver
		return driver;
	}

}