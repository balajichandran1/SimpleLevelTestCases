import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.training.pom.CartPOM;

public class TestCase1 {
		// TODO Auto-generated constructor stub
		public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\BALAJICHANDRAN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// Launching new browser
		WebDriver driver =new ChromeDriver();
		// Maximizing the window
		driver.manage().window().maximize();
		// Navigating to the desired url
		driver.navigate().to("http://uniform.upskills.in/index.php?route=account/login");
		//Entering the registered email id in the "Email id" input box
		//driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("catchbaalaji@gmail.com");
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("catchbaalaaji@gmail.com");
		//Entering the valid password 
		//driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("sairam123");
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("sairam786");
		// Clicking on the Submit button
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		// Let us click on "Change your password" link, to change the password.
		driver.findElement(By.linkText("Change your password")).click();
		Thread.sleep(3000);
		//Entering value "sneha" in "Password" field
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("sneha");
		Thread.sleep(2000);
		//Entering value "mneha" in "Password Confirm" field
		driver.findElement(By.xpath("//*[@id='input-confirm']")).sendKeys("mneha");
		Thread.sleep(2000);	
		//Clicking on "Continue" button
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		//System.out.println("Values entered in Password and Password Confirm fields are not matching");
		
		String ActualMsg = driver.findElement(By.xpath("//*[contains(text(),'Password confirmation does not match password!')]")).getText();
		System.out.println(ActualMsg);
		driver.close();
		////*[contains(text(),'Password confirmation does not match password!')]//
	}

}
