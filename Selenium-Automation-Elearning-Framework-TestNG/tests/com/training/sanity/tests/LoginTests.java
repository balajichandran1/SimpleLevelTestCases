package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CartPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void Testcase1() {
		//Entering the userName
		loginPOM.sendUserName("catchbaalaaji@gmail.com");
		//Entering the Password
		loginPOM.sendPassword("sairam786");
		//Clicking on Login button
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
		//Clicking on "Change your Password" link
		loginPOM.changepassword();
		//Entering the value "sneha" in "Password" field
		loginPOM.newpassword("sneha");
		//Entering the value "mneha" in "Password Confirm" field
		loginPOM.confirmnewpassword("mneha");
		//Clicking on Continue button
		loginPOM.continueBtn();
		// Comparing the Expected and Actual message
		String ExpectedMsg = "Password confirmation does not match password!";
		String ActualMsg = driver.findElement(By.xpath("//*[contains(text(),'Password confirmation does not match password!')]")).getText();
		//Printing the Actual Msg in console
		System.out.println(ActualMsg);
		Assert.assertEquals(ExpectedMsg,ActualMsg);
		//Printing whether Expected message & Actual message are matching or not
		System.out.println("Both ExpectedMsg and ActualMsg are matching");
	    }

}



