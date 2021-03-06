import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase4 {

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
		driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Order History")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);
		System.out.println("User is successfully Viewed their Order History");
		driver.close();
	}

}
