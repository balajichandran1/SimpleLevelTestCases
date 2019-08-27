import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase5 {

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
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("venkat.test@gmail.com");
		//Entering the valid password 
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("venkat123");
		// Clicking on the Submit button
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Edit your account information")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='input-firstname']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys("Neha");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='input-lastname']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys("B");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='input-email']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("neha.test@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='input-telephone']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='input-telephone']")).sendKeys("9876543210");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
		System.out.println("Success: Your account has been successfully updated.");
		Thread.sleep(3000);
		driver.close();
		
	}

}
