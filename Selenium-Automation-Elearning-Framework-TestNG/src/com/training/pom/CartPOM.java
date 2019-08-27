package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPOM {
	private WebDriver driver; 
	
	public CartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	//TestCase2 -
	//Finding the link for "Regular T-shirts (Rust)  
	@FindBy(linkText= "REGULAR T-SHIRTS (Rust)")
	private WebElement Tshirt;
	
	// Method to click Regular T shirts link
	public void clickTshirt() {
		Actions Act = new Actions(driver);
		Action mouseover = Act.moveToElement(Tshirt).build();
		mouseover.perform();
		//Clicking on Regular T-Shirts Rust option
		Act.sendKeys(Tshirt,(Keys.RETURN)).perform();
		
		}
    // Finding the Chest Size value list box
	@FindBy(id= "input-option376")
	private WebElement Chest;
    
	 // Method to select value from drop down (Chest Size)
	public void clickChest()
	{
		this.Chest.click();
		Select dropdown = new Select(driver.findElement(By.id("input-option376")));
		dropdown.selectByIndex(11);
	}
			
	// Finding "Add to Cart" button
	@FindBy(xpath="//*[@class='btn btn-primary btn-lg btn-block']")
	private WebElement selectsize;
	
	//Method to click "Add Cart" button
	public void addCart()
	{
		this.selectsize.click();
	}
	
	//Finding Cart icon
	@FindBy(xpath="//*[@id=\"cart\"]/button")
	private WebElement Carticon;
	
	//Method to click on "Cart" icon
	public void ClickCart()
	{
		this.Carticon.click();
	}
	
	//Finding "View Cart" button
	@FindBy(xpath="//*[@id='cart']/ul/li[2]/div/p/a[1]")
	private WebElement ViewCart;
	
	//Method to click on "View Cart" button
	public void ViewCartIcon()
	{
		this.ViewCart.click();
	}
	
	//TestCase3 -
	//Finding "Remove" button
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]")
	private WebElement cartempty;
	
	//Method to click on "Remove" button
	public void ClickCartEmpty() 
	{
	this.cartempty.click();
    }
}