package identifyBikes;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PopularUsedCars {
	
	static Wait wait = new Wait();
	// Getting the data from the KeywordDriven class
	public static String UsedCars_linkText = KeywordDriven.getUsedCarsLinkText();
	public static String findUsedCars_Button = KeywordDriven.getFindUsedCars();
	public static String getChennai = KeywordDriven.getChennai();
	public static String allCars = KeywordDriven.getUsedCars();

	// Find Used Cars
	public static void findUsedCars(WebDriver driver) {

	Actions act = new Actions(driver);
	WebElement used_cars = driver.findElement(By.linkText(UsedCars_linkText));
	act.moveToElement(used_cars).perform();
	wait.waitImplicit(driver);
	driver.findElement(By.xpath(findUsedCars_Button)).click();
	}

	// Select Location
	public static void SelectLocation(WebDriver driver) {
	wait.waitImplicit(driver);
	try {
	Thread.sleep(3000);
	} catch (InterruptedException e) {
	e.printStackTrace();
	}
	driver.findElement(By.xpath(getChennai)).click();
	}

	// Printing models
	public static ArrayList<String> printModels(WebDriver driver) throws Exception {

	wait.waitImplicit(driver);
	String models_list = driver.findElement(By.xpath(allCars)).getText();
	ArrayList<String> models = new ArrayList<String>();
	Collections.addAll(models, models_list.split("\n"));

	// Printing the Popular used Cars in Chennai
	System.out.println("=========================================");
	System.out.println("PART 2:");
	System.out.println("Popular Models of Used Cars in Chennai are:-");
	for (int i = 0; i < models.size(); i++) {
	System.out.println((i + 1) + " " + models.get(i));
	}
	return models;
	}

	// Invoking the previous methods
	public static ArrayList<String> popularUsedCars(WebDriver driver) throws Exception {
	// Extracting the popular used cars
	findUsedCars(driver);
	SelectLocation(driver);
	ArrayList<String> models = printModels(driver);
	return models;
	}

	}

