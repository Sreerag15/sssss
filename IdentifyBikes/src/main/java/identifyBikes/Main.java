package identifyBikes;

import java.util.ArrayList;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;

public class Main {
	// Declaration of static variables.
	public static String Url = "https://www.zigwheels.com";
	public static Wait wait = new Wait();
	public static WebDriver driver;
	public static Scanner sc;
	public static int choice;

	// Instantiating the driver
	public static void getDriver() throws Exception {

		// Browser Choices
		String Chrome_Browser = KeywordDriven.getChromeBrowser();
		String Firefox_Browser = KeywordDriven.getFirefoxBrowser();

		sc = new Scanner(System.in);
		System.out.println("1 : Chrome Browser");
		System.out.println("2 : Firefox Browser");
		System.out.println("Enter your Choice: ");
		choice = sc.nextInt();

		switch (choice) {

		case 1:
			// Passing arguments for Invoking the Browser
			driver = DriverSetup.invokeDriver(Chrome_Browser);
			break;
		case 2:
			// Passing arguments for Invoking the Browser
			driver = DriverSetup.invokeDriver(Firefox_Browser);
			break;
		}

		// Passing arguments for Invoking the Browser
		// driver = DriverSetup.invokeDriver(Chrome_Browser);
	}

	// Navigating to the official site of Zigwheels
	public static void navigation(WebDriver driver) {

		driver.manage().window().maximize();
		driver.get(Url);
		driver.navigate().to(Url);
	}

	// Login with Google in zigwheels
	public static void loginInZigWheel() throws Exception {

		// Google Sign-in
		GoogleSignIn.loginInZigWheel(driver);

		// Reading from Excel
		String emailInvalid = KeywordDriven.getInvalidEmail();
		String passwordInvalid = KeywordDriven.getInvalidPassword();

		// Filling the Invalid details
		GoogleSignIn.loginWithGoogle(emailInvalid, passwordInvalid, driver);

	}

	// Popular Used Cars in Chennai
	public static void getPopularUsedCars() throws Exception {

		ArrayList<String> cars = PopularUsedCars.popularUsedCars(driver);
		// Writing them in Properties File
		WritingPropertiesFile.writingFile(cars, "Used-Cars");
	}

	// Closing the Driver
	public static void tearDown(WebDriver driver) {
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws Exception {

		// Invoking the Driver.
		getDriver();

		// Google Sign-in
		loginInZigWheel();

		// Navigating to the official site of Zigwheels.
		navigation(driver);

		// Popular Cars in Chennai
		getPopularUsedCars();

		// Closing the driver.
		tearDown(driver);
	}

}