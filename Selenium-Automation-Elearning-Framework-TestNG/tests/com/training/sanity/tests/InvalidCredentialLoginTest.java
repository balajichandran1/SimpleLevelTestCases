package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.pom.InvalidCredentialPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class InvalidCredentialLoginTest {

	private WebDriver driver;
	private String baseUrl;
	private InvalidCredentialPOM InvalidCredentialPOM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others2.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		InvalidCredentialPOM = new InvalidCredentialPOM(driver); 
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
	public void Testcase() {
		//Entering the userName
		InvalidCredentialPOM.sendUserName("Nha");
		//Entering the Password
		InvalidCredentialPOM.sendPassword("neha2345");
		//Clicking on Login button
		InvalidCredentialPOM.clickLoginBtn(); 
		
		// Comparing the Expected and Actual message
		String ExpectedMsg = "No match for Username and/or Password.";
		String ActualMsg = driver.findElement(By.xpath("//*[contains(text(),' No match for Username and/or Password.')]")).getText();
		//Printing the Actual Msg in console
		System.out.println(ActualMsg);
		Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
		//Printing whether Expected message & Actual message are matching or not
		System.out.println("Both ExpectedMsg and ActualMsg are matching");

	    }

}


