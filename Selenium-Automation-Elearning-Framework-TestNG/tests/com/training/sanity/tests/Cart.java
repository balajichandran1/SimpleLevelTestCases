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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Cart {

	private WebDriver driver;
	private String cartURL;
	private CartPOM cartPOM;
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
		cartPOM = new CartPOM(driver); 
		cartURL = properties.getProperty("cartURL");
		//	screenShot = new ScreenShot(driver); 
		// open the browser 
	    driver.get(cartURL);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
     @Test(priority = 1)
	 public void Testcase2() {
    	 
    	  //Clicking on "Regular T-shirts (Rust) link 
		  cartPOM.clickTshirt();
		  //Selecting chest size
		  cartPOM.clickChest();
		  //Clicking on "Add to Cart" button
		  cartPOM.addCart();
		  //Validating whether user is able to successfully add the items to cart
		  String ExpectedMsg1 = "REGULAR T-SHIRTS (Rust)";
		  String ActualMsg1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a[1]")).getText();
		  // Comparing the Expected and Actual message
		  Assert.assertEquals(ExpectedMsg1,ActualMsg1);
		  //Printing the Actual Msg in console
		  System.out.println(ActualMsg1);
		  //Printing the message for success!
		  System.out.println("Both ExpectedMsg1 and ActualMsg1 are matching");
		  //Clicking on Cart Icon
		  cartPOM.ClickCart();
		  //Clicking on "View Cart" button
		  cartPOM.ViewCartIcon();
	 }
	 @Test(priority = 2)
	 public void Testcase3() throws InterruptedException {
		 
		  //Clicking on "Regular T-shirts (Rust) link 
		   cartPOM.clickTshirt();
		  //Selecting chest size
		   cartPOM.clickChest();
		  //Clicking on "Add to Cart" button
		   cartPOM.addCart();
		  //Validating whether user is able to successfully add the items to cart
		  String ExpectedMsg2 = "REGULAR T-SHIRTS (Rust)";
		  String ActualMsg2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a[1]")).getText();
		  //Printing the Actual Msg in console
		  System.out.println(ActualMsg2);
		  // Comparing the Expected Message 2 and Actual message 2
		  Assert.assertEquals(ExpectedMsg2,ActualMsg2);
		  //Printing whether Expected message & Actual message are matching or not
		  System.out.println("Both ExpectedMsg2 and ActualMsg2 are matching");
		  //Clicking on Cart Icon
		  cartPOM.ClickCart();
		  //Clicking on "View Cart" button
		  cartPOM.ViewCartIcon();
		  //Clicking on Remove button
		  cartPOM.ClickCartEmpty();
		  Thread.sleep(2000);
		  //Validating whether user is able to successfully remove the items from cart
		  String ExpectedMsg3 = "Your shopping cart is empty!";
		  String ActualMsg3 = driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
		  //Printing the Actual Msg in console
		  System.out.println(ActualMsg3);
		  // Comparing the Expected Msg3 and Actual Msg3
		  Assert.assertEquals(ExpectedMsg3,ActualMsg3);
		  //Printing whether Expected message & Actual message are matching or not
		  System.out.println("Both ExpectedMsg3 and ActualMsg3 are matching");
		  
	 }
}
