package identifyBikes;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpcomingBikes {

	public static Wait wait = new Wait();
	// Getting the data from the KeywordDriven class
	public static String newBikes_linkText = KeywordDriven.getLinkTextNewBikes();
	public static String upcomingHonda_xpath = KeywordDriven.getUpcomingHondaWebpage();
	public static String upcomingBikePage = KeywordDriven.getupcomingBikePage();
	public static String hondaBikes = KeywordDriven.selectingHonda();
	public static String viewMore_Button = KeywordDriven.viewMoreBikes();
	public static String bikeModel = KeywordDriven.viewBikeModels();
	public static String bikeName = KeywordDriven.getBikeNames();
	public static String bikePrice = KeywordDriven.getBikePrice();
	public static String bikeLaunchDate = KeywordDriven.getBikeLaunchDate();

	public static void clickOnUpcomingBikes(WebDriver driver) throws Exception {

		// Navigating to the New Bikes Section.
		Actions act = new Actions(driver);

		// Hovering to New Bikes
		WebElement new_bikes = driver.findElement(By.linkText(newBikes_linkText));
		act.moveToElement(new_bikes).perform();

		// Clicking Upcoming Bikes
		wait.waitImplicit(driver);
		driver.findElement(By.xpath(upcomingHonda_xpath)).click();
	}

	public static void selectHondaModels(WebDriver driver) {

		wait.waitImplicit(driver);

		// Navigating to the Upcoming Honda Bikes page
		driver.navigate().to(upcomingBikePage);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		wait.waitImplicit(driver);

		// Selecting Honda Bikes in Category
		WebDriverWait wait1 = new WebDriverWait(driver, 30);

		Select manufacturer = new Select(wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(hondaBikes))));
		manufacturer.selectByVisibleText("Honda");

		// Scrolling
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(0,1400)", "");

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		// Clicking View More in Upcoming Honda Bikes Page
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		WebElement viewmore = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewMore_Button)));
		Actions actions = new Actions(driver);
		actions.moveToElement(viewmore).click().perform();

		// Storing the information of all the Upcoming Honda Bikes
		wait.waitImplicit(driver);
		List<WebElement> bikes = driver.findElements(By.xpath(bikeModel));
		List<WebElement> bikename = driver.findElements(By.xpath(bikeName));
		List<WebElement> bikeprice = driver.findElements(By.xpath(bikePrice));
		List<WebElement> bikelaunchdate = driver.findElements(By.xpath(bikeLaunchDate));
		int count = bikes.size();
		System.out.println("==================================================");
		System.out.println("Part 3:");
		try {

			for (int i = 0; i <= count - 1; i++) {

				// Storing BikeName
				WebElement bname = bikename.get(i);
				String Name = bname.getText();

				// Storing BikePrice
				WebElement bprice = bikeprice.get(i);
				String pricetext = bprice.getText();
				String ptext = pricetext.substring(4, 9);
				float Price = Float.parseFloat(ptext);

				// Storing Expected Launch Date
				WebElement bdate = bikelaunchdate.get(i);
				String datetxt = bdate.getText();
				String expectedLaunchDate = datetxt.substring(14);

				// To Get Upcoming Bikes Under 4 Lakhs
				if (Price < 4.0) {

					System.out.println("Upcoming bikes of Honda Under 4 Lakhs");
					System.out.println("Name : " + Name);
					System.out.println("Price : " + Price + " Lakhs");
					System.out.println("Expected Launch Date : " + expectedLaunchDate);
					System.out.println("------------------------------------------");
				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

	public static void findingUpcomingBikes(WebDriver driver) throws Exception {

		// Invoking the above methods
		clickOnUpcomingBikes(driver);
		selectHondaModels(driver);

	}

}