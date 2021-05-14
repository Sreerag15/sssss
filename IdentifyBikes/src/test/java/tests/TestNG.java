package tests;

import java.util.ArrayList;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import identifyBikes.DriverSetup;
import identifyBikes.GoogleSignIn;
import identifyBikes.KeywordDriven;
import identifyBikes.Main;
import identifyBikes.PopularUsedCars;
import identifyBikes.UpcomingBikes;
import identifyBikes.Wait;
import identifyBikes.WritingPropertiesFile;

public class TestNG extends Main {

	// Declaration of static variables.
	public static WebDriver driver;
	public static String Url = "https://www.zigwheels.com";
	public static Wait wait = new Wait();
	public static Scanner sc;
	public static int choice;

	// Extent report
	public static ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest test;

	// Method invoking the browser depending on platform requirements.
	@Test
	public static void getDriver() throws Exception {

		test = report.createTest("Identify New Bikes");
		test.log(Status.INFO, "Opening the Browser");

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

		// Enter your browser choice in between the inverted Commas
		// driver = DriverSetup.invokeDriver(Chrome_Browser);
		test.log(Status.PASS, "Browser Opened Successfully");

	}

	// Google Sign-in
	@Test(dependsOnMethods = "getDriver")
	public static void getGoogleSignIn() throws Exception {

		test.log(Status.INFO, "Opening the Login Page in Zigwheels");

		// Login with Google
		GoogleSignIn.loginInZigWheel(driver);

		String emailInvalid = KeywordDriven.getInvalidEmail();
		String passwordInvalid = KeywordDriven.getInvalidPassword();

		// Filling the Invalid details
		GoogleSignIn.loginWithGoogle(emailInvalid, passwordInvalid, driver);
		test.log(Status.PASS, "Error Message Captured");

		// Navigating to the official site of Zigwheels
		test.log(Status.INFO, "Opening the Site : Zigwheels.com");
		driver.manage().window().maximize();
		driver.get(Url);
		driver.navigate().to(Url);
		test.log(Status.PASS, "Zigwheels.com opened successfully");
	}

	// Popular Used Cars in Chennai
	@Test(dependsOnMethods = "getGoogleSignIn")
	public static void getPopularUsedCars() throws Exception {

		test.log(Status.INFO, "Getting Popular Used Cars in Chennai");
		ArrayList<String> cars = PopularUsedCars.popularUsedCars(driver);
		// Writing them in a file
		WritingPropertiesFile.writingFile(cars, "Used-Cars");
		test.log(Status.PASS, "Popular Used Cars Successful");
	}

	// Upcoming Honda Bikes
	@Test(dependsOnMethods = "getPopularUsedCars")
	public static void getUpcomingBikes() throws Exception {

		test.log(Status.INFO, "Getting Upcoming Honda Bikes");
		UpcomingBikes.findingUpcomingBikes(driver);
		test.log(Status.PASS, "Upcoming Honda Bikes Successful");

	}

	// Closing the application
	@Test(dependsOnMethods = "getUpcomingBikes")
	public static void closeApplication() {

		test.log(Status.INFO, "Closing the browser");
		driver.close();
		driver.quit();
		report.flush();
		test.log(Status.PASS, "Browser Closed successfully");
	}

}