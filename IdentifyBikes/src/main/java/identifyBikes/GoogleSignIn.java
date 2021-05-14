package identifyBikes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSignIn {

	public static Wait wait = new Wait();

	// Getting the data from the KeywordDriven class
	public static String zigWheel_URL = KeywordDriven.loginInZigWheel();
	public static String LoginIn_Button = KeywordDriven.getSignInButton();
	public static String continueWithGoogle_Button = KeywordDriven.continueWithGoogle();
	public static String email_TextField = KeywordDriven.getEmailId();
	public static String email_NextButton = KeywordDriven.getEmailNextButton();
	public static String password_TextField = KeywordDriven.getPassword();
	public static String password_NextButton = KeywordDriven.getPasswordNextButton();
	public static String errorMessage = KeywordDriven.getEmailErrorMsg();

	// Launching zigwheels to Login with Google Account
	public static void loginInZigWheel(WebDriver driver) {

		driver.manage().window().maximize();
		driver.get(zigWheel_URL);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id(LoginIn_Button)).click(); // Login/SignUp Button Click
	}

	// Login With Invalid Google Account Credentials
	public static void loginWithGoogle(String email, String pass, WebDriver driver) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(continueWithGoogle_Button)).click();

		// On Clicking Continue with Google Child Window is Opened

		// -----Handling Multiple Windows--------

		// It will return the parent window name as a String
		String parent = driver.getWindowHandle(); // current window

		// This will return the number of windows opened by Webdriver and will return
		// Set of Strings
		Set<String> s1 = driver.getWindowHandles();

		// Iterating using Iterator
		Iterator<String> I1 = s1.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			// Comparing if parent window is not equal to child window

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.findElement(By.cssSelector(email_TextField)).sendKeys(email);
				wait.waitImplicit(driver);
				driver.findElement(By.xpath(email_NextButton)).click();
				wait.waitImplicit(driver);
				if (validateEmail(email)) {

					System.out.println("PART 1:");
					System.out.println("Login With Google Invalid Credentials Error Message");
					wait.waitImplicit(driver);
					String error_msg = driver.findElement(By.xpath(errorMessage)).getText();
					wait.waitImplicit(driver);
					System.out.println(error_msg);

				} else if (!validateEmail(email)) {
					driver.findElement(By.xpath(password_TextField)).sendKeys(pass);
					driver.findElement(By.xpath(password_NextButton)).click();
				}

			}

		}
	}

	// Method validating email syntax
	public static boolean validateEmail(String email) {
		int atTheRatepos = email.indexOf('@');
		int dotpos = email.indexOf('.');
		if (atTheRatepos < 1 || dotpos < atTheRatepos + 2 || dotpos + 2 >= email.length()) {
			return false;
		} else
			return true;
	}

}