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

import com.training.pom.EditCategoryPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditCategory {

	private WebDriver driver;
	private String baseUrl;
	private EditCategoryPOM EditCategoryPOM;
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
		EditCategoryPOM = new EditCategoryPOM(driver); 
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
		EditCategoryPOM.sendUserName("admin");
		//Entering the Password
		EditCategoryPOM.sendPassword("admin@123");
		//Clicking on Login button
		EditCategoryPOM.clickLoginBtn(); 
		//Clicking on Catelog Icon
		EditCategoryPOM.clickCatelog();
		//Clicking on Categories
		EditCategoryPOM.clickCategories();
		//Clickin on Editbutton
		EditCategoryPOM.clickEdit();
		//Editing valid credentials(values) in Metatag Title textbox
		EditCategoryPOM.EditMetatagTitle("BLZ 05");
		//Editing valid credentials(values) in Metatag Description textbox
		EditCategoryPOM.EditMetatagDescription("Uniform for students");
		//Moving to DataTab & scrolling down
		EditCategoryPOM.Datatab();
        //Moving to DesignTab & Scrolling Down
		EditCategoryPOM.Designtab();
        //Clicking on Save Button
		EditCategoryPOM.clickSave();
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
