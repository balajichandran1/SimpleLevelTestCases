package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCategoryPOM {

private WebDriver driver; 
	
	public EditCategoryPOM(WebDriver driver) {
	this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//Finding Username
	@FindBy(xpath="//*[@id='input-username']")
	private WebElement userName ;
	
	//username method
			public void sendUserName(String userName) {
					this.userName.clear();
					this.userName.sendKeys(userName);
				}
		
	//Finding Password	
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement password;
	
	//password method
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//Clicking on login button
	@FindBy(xpath="//*[@type='submit']")
	private WebElement loginBtn; 
		
		//login button method	
			public void clickLoginBtn() {
				this.loginBtn.click(); 
			}
	
    //Clicking on Catelog icon
	@FindBy(xpath="//*[@class='fa fa-tags fa-fw']")		
	private WebElement catelog;
	
	//Selecting Catelog icon
	public void clickCatelog() {
		this.catelog.click();
	}
	//Clicking on Categories Option
	@FindBy(linkText = "Categories")
	private WebElement Categories;
	
	// Method to click Categories link
		public void clickCategories() {
			Actions Act = new Actions(driver);
			Action mouseover = Act.moveToElement(Categories).build();
			mouseover.perform();
			//Clicking on Categories
			Act.sendKeys(Categories,(Keys.RETURN)).perform();
		}
	//Clicking on Edit Button
		@FindBy(xpath="//*[@id=\"form-category\"]/div/table/tbody/tr[1]/td[4]/a")
		private WebElement EditButton;
		
		//Selecting Edit button
			public void clickEdit() {
					this.EditButton.click();
				}
			
		//Finding Meta Tag title field and entering values in it
			   @FindBy(xpath="//*[@id='input-meta-title1']")	
			   private WebElement MetatagTitleText;
			 
		//Clearing and Editing values in MetatagTitle field
				public void EditMetatagTitle(String MetatagTitleText) throws InterruptedException {
			    Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(2000);
				this.MetatagTitleText.clear();
				Thread.sleep(2000);
				this.MetatagTitleText.sendKeys(MetatagTitleText);
				}	
				
		//Finding MetatagDescription field and entering Values in it
				@FindBy(xpath="//*[@id='input-meta-description1']")
				private WebElement MetatagDescriptionText;
				
				//Selecting and entering values in Metatagdescription field
				public void EditMetatagDescription(String MetatagDescriptionText) throws InterruptedException {
				//Thread.sleep(2000);
				this.MetatagDescriptionText.clear();
				Thread.sleep(2000);
				this.MetatagDescriptionText.sendKeys(MetatagDescriptionText);
				}
				
		//Finding DataTab
				@FindBy(xpath="//*[@id=\"form-category\"]/ul/li[2]/a")
				private WebElement MovetoDatatab;
				
	     //Moving to Data Tab
					public void Datatab() throws InterruptedException {
					this.MovetoDatatab.click();
					Thread.sleep(3000);
					//scrolling down to see the defaultcontent
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					            
				    }
			//Finding DesignTab
					@FindBy(xpath="//*[@id=\"form-category\"]/ul/li[3]/a")
					private WebElement MovetoDesigntab;
					
					public void Designtab() throws InterruptedException {
						this.MovetoDesigntab.click();
						Thread.sleep(2000);
								            
					}
			//Finding Save Button
					@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
					private WebElement SaveButton;
					
			//Method to click on Save Button
					public void clickSave() {
						this.SaveButton.click();
					}
					
				
}

