package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvalidCredentialPOM {

	private WebDriver driver; 
	
	public InvalidCredentialPOM(WebDriver driver) {
	this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//Finding Username
	@FindBy(xpath="//*[@id='input-username']")
	private WebElement userName ;
	
	//Finding Password	
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement password;
	
	//Clicking on login button
	@FindBy(xpath="//*[@type='submit']")
	private WebElement loginBtn; 
	
	//username method
		public void sendUserName(String userName) {
				this.userName.clear();
				this.userName.sendKeys(userName);
			}
	
		//password method
			public void sendPassword(String password) {
				this.password.clear(); 
				this.password.sendKeys(password); 
			}
			
		//login button method	
			public void clickLoginBtn() {
				this.loginBtn.click(); 
			}
	

}
