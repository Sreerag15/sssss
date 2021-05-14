package identifyBikes;

import org.openqa.selenium.By;

public class KeywordDriven {

	// Reading the Excel Data from the InputDetails.xlsx file

	// Getting Invalid EmailId
	public static String getInvalidEmail() throws Exception {

		String[] data = ExcelUtils.readExcelData("Sheet1");
		String emailInvalid = data[0];
		return emailInvalid;
	}

	// Getting Email Password
	public static String getInvalidPassword() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String passwordInvalid = data[1];
		return passwordInvalid;
	}

	// Getting Location for Used Cars
	public static String getLocationName() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String locationPopularUsedCars = data[2];
		return locationPopularUsedCars;
	}

	// Getting Chrome_Browser
	public static String getChromeBrowser() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String Chrome_Browser = data[3];
		return Chrome_Browser;
	}

	// Getting Firefox Browser
	public static String getFirefoxBrowser() throws Exception {
		String[] data = ExcelUtils.readExcelData("Sheet1");
		String Firefox_Browser = data[4];
		return Firefox_Browser;
	}

	// ----- Login With Google Account in Zigwheels---------

	// Zigwheels URL
	public static String loginInZigWheel() {
		String zigWheels_URL = "https://www.zigwheels.com/";
		return zigWheels_URL;
	}

	// Login/SignUp Button
	public static String getSignInButton() {
		String signIn_Button = "des_lIcon";
		return signIn_Button;
	}

	// ContinueWithGoogle Button
	public static String continueWithGoogle() {
		String continueWithGoogle = "//div[@id='myModal3']/div/div/div/div/div/div[2]/div[2]";
		return continueWithGoogle;
	}

	// EmailId TextField
	public static String getEmailId() {
		String email_TextField = "input#identifierId";
		return email_TextField;
	}

	// Email Next_Button
	public static String getEmailNextButton() {
		String email_NextButton = "//*[@id='identifierNext']/div/button/div[2]";
		return email_NextButton;
	}

	// Email ErrorMessage
	public static String getEmailErrorMsg() {
		String email_Error = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div";
		return email_Error;
	}

	// Password TextField
	public static String getPassword() {
		String password_TextField = "//*[@id='password']/div[1]/div/div[1]/input";
		return password_TextField;
	}

	// Password Next_Button
	public static String getPasswordNextButton() {
		String password_NextButton = "//*[@id='passwordNext']/div/button/div[2]";
		return password_NextButton;
	}

	// ----------Popular Used Cars---------

	// UsedCars LinkText
	public static String getUsedCarsLinkText() {
		String UsedCars_linkText = "Used Cars";
		return UsedCars_linkText;
	}

	// Finding UsedCars
	public static String getFindUsedCars() {
		String findUsedCars_Button = "//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[5]/ul/li/div[1]/ul/li[1]/span";
		return findUsedCars_Button;
	}

	// Location Chennai
	public static String getChennai() {
		String chennai_String = "//*[@id='popularCityList']/li[8]/a";
		return chennai_String;
	}

	// Popular Used Cars in Chennai
	public static String getUsedCars() {
		String carString = "/html/body/div[11]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[4]";
		return carString;
	}

	// ------Upcoming New Bikes--------------

	// New Bikes
	public static String getLinkTextNewBikes() {
		String NewBikes_linkText = "New Bikes";
		return NewBikes_linkText;
	}

	// UpcomingBikes
	public static String getUpcomingHondaWebpage() {
		String upcomingHondaWebpage = "//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/ul/li/div[1]/ul/li[3]/span";
		return upcomingHondaWebpage;
	}

	// UpcomingBikes webPage
	public static String getupcomingBikePage() {
		String upcomingBikePage_Url = "https://www.zigwheels.com/upcoming-bikes";
		return upcomingBikePage_Url;
	}

	// Honda Manufacturer
	public static String selectingHonda() {
		String hondaBikes = "makeId";
		return hondaBikes;
	}

	// View More Honda Bikes
	public static String viewMoreBikes() {
		String viewMore_Button = "//div[@id='carModels']//li[18]/span";
		return viewMore_Button;
	}

	// More HondaBikes Model
	public static String viewBikeModels() {
		String bikeModel = "//div[@id='carModels']//div[@class='zw-con p-0 sl-card']";
		return bikeModel;
	}

	// HondaBike Names
	public static String getBikeNames() {
		String bikeName = "//strong[@class=\"lnk-hvr block of-hid h-height\"]";
		return bikeName;
	}

	// HondaBike Price
	public static String getBikePrice() {
		String bikePrice = "//div[@class=\"clr-bl p-5\"]";
		return bikePrice;
	}

	// HondaBike ExpectedLaunchDate
	public static String getBikeLaunchDate() {
		String bikeLaunchDate = "//div[@class=\"clr-try fnt-15\"]";
		return bikeLaunchDate;
	}

}