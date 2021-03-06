package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AddCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategory {

	private WebDriver driver;
	private String baseUrl;
	private AddCategoryPOM AddCategoryPOM;
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
		AddCategoryPOM = new AddCategoryPOM(driver); 
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
	public void Testcase() throws InterruptedException {
		//Entering the userName
		AddCategoryPOM.sendUserName("admin");
		//Entering the Password
		AddCategoryPOM.sendPassword("admin@123");
		//Clicking on Login button
		AddCategoryPOM.clickLoginBtn(); 
		//Clicking on Catelog Icon
		AddCategoryPOM.clickCatelog();
		//Clicking on Categories
		AddCategoryPOM.clickCategories();
		//Clicking on AddNew icon
		AddCategoryPOM.clickAddnew();
		//Entering valid credentials(values) in CategoryName textbox
		AddCategoryPOM.sendCategoryName("Blazers(3-5)");
		//Entering valid credentials(values) in Description textbox
		AddCategoryPOM.sendDescription("Blazers for students");
		//Entering valid credentials(values) in Metatag Title textbox
        AddCategoryPOM.sendMetatagTitle("BLZ 03");
        //Entering valid credentials(values) in Metatag Description textbox
        AddCategoryPOM.sendMetatagDescription("Blazers for primary class students");
        //Moving to DataTab & scrolling down
        AddCategoryPOM.Datatab();
        //Moving to DesignTab & Scrolling Down
        AddCategoryPOM.Designtab();
        //Clicking on Save Button
        AddCategoryPOM.clickSave();
        String ExpectedMsg = "Success: You have modified categories!";
		String ActualMsg = driver.findElement(By.xpath("//*[contains(text(),'Success: You have modified categories!')]")).getText();
		//Printing the Actual Msg in console
		System.out.println(ActualMsg);
		//Validating whether Expected message & Actual message are matching or not
		Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
		//Printing whether Expected message & Actual message are matching or not
		System.out.println("Both ExpectedMsg and ActualMsg are matching");
				
	}

}
