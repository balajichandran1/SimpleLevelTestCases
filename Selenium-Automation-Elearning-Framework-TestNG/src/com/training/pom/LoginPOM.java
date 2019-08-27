package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPOM {

	
		private WebDriver driver; 
		
		public LoginPOM(WebDriver driver) {
		this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		//Finding Username
		@FindBy(xpath="//*[@id='input-email']")
		private WebElement userName ;
		
		//Finding Password	
		@FindBy(xpath="//*[@id='input-password']")
		private WebElement password;
		
		//Clicking on login button
		@FindBy(xpath="//*[@type='submit']")
		private WebElement loginBtn; 
		
		//Clicking on "Change your password" link
		@FindBy(linkText="Change your password")
		private WebElement changepassword;
		
		//Reset new password
		@FindBy(xpath="//*[@id='input-password']")
		private WebElement newpassword;
		
		//Confirm new password
		@FindBy(xpath="//*[@id='input-confirm']")
		private WebElement confirmnewpassword;
		
		//Clicking on Continue button
		@FindBy(xpath="//*[@type='submit']")
		private WebElement continueBtn; 
		
		//Test case 1
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
			
		//Change password link method	
			public void changepassword()
			{
			 this.changepassword.click();
			}
			
			//Entering the value in "Password" field after clearing the content
			
			public void newpassword(String newpassword) {
				this.newpassword.clear(); 
				this.newpassword.sendKeys(newpassword); 
			}
			
			//Entering the value in "Password Confirm" field after clearing the content
			
			public void confirmnewpassword(String confirmnewpassword) {
				this.confirmnewpassword.clear(); 
				this.confirmnewpassword.sendKeys(confirmnewpassword); 
			}
			
			// Clicking on Continue button method
			public void continueBtn() {
				this.continueBtn.click(); 
			}
			// End of Test Case 1
			
		
}
