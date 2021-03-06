package identifyBikes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Wait {
	public static WebDriver driver;

	// Method for the Implicit Wait where 15 seconds wait is alloted.
	// This method is invoked when we need to use implicit wait.
	public void waitImplicit(WebDriver driver) {
		// Implicit wait of 25 seconds
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

}
